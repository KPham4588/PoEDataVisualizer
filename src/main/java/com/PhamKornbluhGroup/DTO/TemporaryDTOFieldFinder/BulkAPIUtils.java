package com.PhamKornbluhGroup.DTO.TemporaryDTOFieldFinder;

import com.PhamKornbluhGroup.APIResultData;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class BulkAPIUtils {
    public static HashSet<String> knownFields = new HashSet<>();

    public static void getKnownFields() throws Exception {
        try (FileInputStream fileInput = new FileInputStream("knownFields.txt");
             ObjectInputStream objectGetter = new ObjectInputStream(fileInput)) {

            knownFields = (HashSet<String>) objectGetter.readObject();
        }
    }

    public static void saveKnownFields() throws Exception {
        try (FileOutputStream fileOut = new FileOutputStream("knownFields.txt");
             ObjectOutputStream objectSaver = new ObjectOutputStream(fileOut)) {

            objectSaver.writeObject(knownFields);
            System.out.println("Object serialized successfully!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPageCode() {
        File filePath = new File("C:\\Users\\Public\\Documents\\APIData\\pageID.txt");
        try (FileReader fileReader = new FileReader(filePath);
            BufferedReader codeReader = new BufferedReader(fileReader)) {

            String pageCode = codeReader.readLine();
            return pageCode;
        }
        catch (Exception e) {
            System.out.println("Failure to read API Page ID. Error Message = " + e.getMessage());
            System.out.println("Full Message = " + Arrays.toString(e.getStackTrace()));
        }
        return "";
    }

    public static void savePageCode(String code) {
        try (FileWriter writer = new FileWriter("C:\\Users\\Public\\Documents\\APIData\\pageID.txt")) {
            writer.write(code);
        }
        catch (Exception e) {
            System.out.println("Failure to write API Page ID. Error Message = " + e.getMessage());
            System.out.println("Full Message = " + Arrays.toString(e.getStackTrace()));
        }
    }

    private static File locateAPIResultsFilePath() {
        int pageNumber = 1;
        while (pageNumber < 1000) {
            File currentFile = new File(String.format("C:\\Users\\Public\\Documents\\APIData\\APIResult%s.txt", pageNumber));
            if (!currentFile.exists()) {
                return currentFile;
            }
            pageNumber++;
        }
        return new File("");
    }

    public static void saveAPIResults(APIResultData resultData) {
        File filePath = locateAPIResultsFilePath();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(resultData.getContent());
        }
        catch (Exception e) {
            System.out.println("Failure to write API Result Data. Error Message = " + e.getMessage());
            System.out.println("Full Message = " + Arrays.toString(e.getStackTrace()));
        }
    }






    //b Can use this method to prove that saving functionality works on HashSet<String>
    public static void examplePlaceAndSaveKnownFields() throws Exception {
        HashSet<String> knownFields = BulkAPIUtils.knownFields;

        knownFields.add("Bob");

        System.out.println("HERE'S THE INITIAL SET");
        System.out.println(knownFields);

        BulkAPIUtils.saveKnownFields();
    }

    //b Can use this method to prove that loading functionality works on HashSet<String>
    public static void exampleGetAndPrintKnownFiles() throws Exception {
        BulkAPIUtils.getKnownFields();

        System.out.println(BulkAPIUtils.knownFields);
    }

}
