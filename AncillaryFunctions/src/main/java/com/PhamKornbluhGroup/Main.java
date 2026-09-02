package com.PhamKornbluhGroup;

import com.PhamKornbluhGroup.DAO.ResultDAO;
import com.PhamKornbluhGroup.DTO.ResultDTO;
import com.PhamKornbluhGroup.jsonParsing.JSONParser;
import com.PhamKornbluhGroup.utilities.ChangeIdService;

public class Main {
    public static void main(String[] args) {

        ChangeIdService changeIdService = new ChangeIdService("https://www.pathofexile.com/api/trade/data/change-ids");
        String changeId = changeIdService.getLatestChangeId();

        // TODO: Now it's time to write code to get the pageChangeId and use it to call getPublicStashData
        System.out.println("Beginning Ancillary Function");
        GGGAPIHandler apiHandler = new GGGAPIHandler();
        System.out.println("Created GGGAPIHandler object");
        APIResultData result = apiHandler.getPublicStashData(changeId);
        System.out.println("Got back APIResultData");
        System.out.println(result.getResponseCode());

        try {
            ResultDTO resultDTO = JSONParser.parseAPIResultData(result);
            System.out.println("Parsed APIResultData into ResultDTO");

            ResultDAO resultDAO = new ResultDAO();
            resultDAO.insertResult(resultDTO);
            System.out.println("Inserted ResultDTO into the database");
        }
        catch (Exception e) {
            System.out.println("Failure to parse and insert APIResultData. Message = " + e.getMessage());
        }
    }
}