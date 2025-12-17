package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.ResultDTO;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.io.*;

public class JSONParser {

    private static ResultDTO parsePublicStashChange(InputStream stream) {
        JsonMapper mapper = JsonMapper.builder()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();

        ResultDTO resultDTO = new ResultDTO();

//        try {
        try (stream) {
            resultDTO = mapper.readValue(stream, ResultDTO.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return resultDTO;
    }


    public static ResultDTO parseHardCodedAPIFile() {
//        try {
//            File file = new File("C:\\Dev\\PhamkornbluhAPIResult\\NewAPIResult.txt");
//            FileInputStream stream = new FileInputStream(file);
//            return stream;
//        }
        File file = new File("C:\\Dev\\PhamkornbluhAPIResult\\NewAPIResult.txt");
        try (FileInputStream stream = new FileInputStream(file)) {
            return parsePublicStashChange(stream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
