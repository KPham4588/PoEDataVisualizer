package com.PhamKornbluhGroup;

import com.PhamKornbluhGroup.DAO.ResultDAO;
import com.PhamKornbluhGroup.DTO.ResultDTO;
import com.PhamKornbluhGroup.jsonParsing.JSONParser;
import com.PhamKornbluhGroup.utilities.ChangeIdService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* This class is the entry point from main. It orchestrates a few things:
 * 1. it determines an amount of times (instances) or time (time span) that
 * the program is allowed to get data from GGG
 * 2. it gets the latest change ID and uses the data to get information from GGG
 * 3. it inserts the result to the database
 * 4. it logs errors and successes as needed
 */
public class GGGProcessOrchestrator {
    private final static Logger GGGProcessOrchestratorLogger = LogManager.getLogger(GGGProcessOrchestrator.class);

    // for now, we get data X amounts of instances, but later on we might run on a timer and when the timer
    // expires, we let the last instance finish and close out the program
    private final static int NUMBER_OF_TIMES_WE_GET_DATA = 5;
    private final static String GGG_CHANGE_ID_URL = "https://www.pathofexile.com/api/trade/data/change-ids";

    static void GetGGGDataAndInsertResult() {
        ChangeIdService changeIdService = new ChangeIdService(GGG_CHANGE_ID_URL);
        String changeId = changeIdService.fetchLatestPageChangeId();
        GGGAPIHandler apiHandler = new GGGAPIHandler();

        for (int i = 0; i < NUMBER_OF_TIMES_WE_GET_DATA; i++) {
            try {
                APIResultData result = apiHandler.fetchPublicStashData(changeId);
                ResultDTO resultDTO = JSONParser.parseAPIResultData(result);

                if ((resultDTO.getStashes() == null) || resultDTO.getStashes().isEmpty()) {
                    return;
                }

                ResultDAO resultDAO = new ResultDAO();
                resultDAO.insertResult(resultDTO);

                if (changeId.equalsIgnoreCase(resultDTO.getNextChangeId())) {
                    return;
                }

                GGGProcessOrchestratorLogger.log(Level.INFO, "Finished inserting for change ID {}", changeId);
                changeId = resultDTO.getNextChangeId();
            }
            catch (Exception e) {
                GGGProcessOrchestratorLogger.log(Level.ERROR, e.getMessage());
            }
        }
    }
}
