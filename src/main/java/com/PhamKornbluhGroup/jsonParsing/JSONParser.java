package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.ResultDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class JSONParser {

    private static ResultDTO parsePublicStashChange(InputStream stream) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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
