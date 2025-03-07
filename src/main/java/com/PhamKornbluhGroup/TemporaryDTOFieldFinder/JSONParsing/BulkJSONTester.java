package com.PhamKornbluhGroup.TemporaryDTOFieldFinder.JSONParsing;

import com.PhamKornbluhGroup.APIResultData;
import com.PhamKornbluhGroup.TemporaryDTOFieldFinder.BulkAPIResultHandler;

import java.util.ArrayList;

public class BulkJSONTester {
    public static void run(int numOfBatchesOfTwentyFive) throws Exception {
        // TODO: Instead of grabbing the APIResultData as it's being created, and immediately checking
        // TODO: Implement use of BulkAPIUtils getFirstUncheckedAPIResult / saveFirstUncheckedAPIResult
        // TODO: Use this to find the correct files and create APIResultData Objects, and check from there.
        // TODO: This allows an easier time re-checking without re-running the Bulk grabber

        for (int i = 0; i < numOfBatchesOfTwentyFive; i++) {
            BulkAPIResultHandler handler = new BulkAPIResultHandler();
            ArrayList<APIResultData> APIResultList = handler.getBulkPOEApiResults(25);

            JSONParsingTool traverser = new JSONParsingTool();

//        PageNumberFilePath nextPath = BulkAPIUtils.getFirstUncheckedAPIResult();
//        int startingPoint = nextPath.getPageNumber();

            for (int j = 0; j < 25; j++) {
                APIResultData nextResult = APIResultList.get(j);
                traverser.traverseJson(nextResult);
            }
            APIResultList.clear();
//        BulkAPIUtils.saveFirstUncheckedAPIResult();
        }
    }
}
