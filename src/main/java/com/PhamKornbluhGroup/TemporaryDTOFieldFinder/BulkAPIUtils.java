package com.PhamKornbluhGroup.TemporaryDTOFieldFinder;

import com.PhamKornbluhGroup.APIResultData;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class BulkAPIUtils {
    private static HashSet<String> knownFields = new HashSet<>();
    private static HashSet<String> newFields = new HashSet<>();
    private static boolean initialized = false;

    public static String getChangeId() {
        File filePath = new File("C:\\Users\\Public\\APIData\\ChangeId.txt");
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader codeReader = new BufferedReader(fileReader)) {

            String changeId = codeReader.readLine();
            return changeId;
        }
        catch (Exception e) {
            System.out.println("Failure to read API Page Change ID. Error Message = " + e.getMessage());
            System.out.println("Full Message = " + Arrays.toString(e.getStackTrace()));
        }
        return "";
    }

    public static void saveChangeId(String code) {
        try (FileWriter writer = new FileWriter("C:\\Users\\Public\\APIData\\ChangeId.txt")) {
            writer.write(code);
        }
        catch (Exception e) {
            System.out.println("Failure to write API Page ID. Error Message = " + e.getMessage());
            System.out.println("Full Message = " + Arrays.toString(e.getStackTrace()));
        }
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

    public static void compareKnownFieldsAndUpdate(HashSet<String> currentFields, String pageChangeID) throws Exception {
        if (!initialized) {
            BulkAPIUtils.getKnownFields();
        }

        for (String nextElement : currentFields) {
            if (!knownFields.contains(nextElement)) {
                //TODO: Remove this printLn when not needed anymore
                System.out.println(nextElement + " is new!");
                newFields.add(nextElement);
                knownFields.add(nextElement);
            }
        }
        saveKnownFields();
        saveNewFieldChangeLog(pageChangeID);
    }

    private BulkAPIUtils() {
    }

    private static void saveNewFieldChangeLog(String pageChangeID) {
        File filePath = locateNewSaveFieldChangeLogFilePath();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("PAGE CHANGE ID = " + pageChangeID + "\r\n\r\n");
            for (String element : newFields) {
                writer.write(element + "\r\n");
            }
        }
        catch (Exception e) {
            System.out.println("Failure to write New Field Change Log. Error Message = " + e.getMessage());
            System.out.println("Full Message = " + Arrays.toString(e.getStackTrace()));
        }
    }

    private static void getKnownFields() throws Exception {
        File file = new File("knownfields.txt");
        if (!file.exists()) {
            // If there's no file, return with just an empty list
            //TODO: Start logging this
            return;
        }
        try (FileInputStream fileInput = new FileInputStream("knownFields.txt");
             ObjectInputStream objectGetter = new ObjectInputStream(fileInput)) {
            knownFields = (HashSet<String>) objectGetter.readObject();
        }
    }

    private static void saveKnownFields() {
        try (FileOutputStream fileOut = new FileOutputStream("knownFields.txt");
             ObjectOutputStream objectSaver = new ObjectOutputStream(fileOut)) {

            objectSaver.writeObject(knownFields);
            System.out.println("Object serialized successfully!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File locateAPIResultsFilePath() {
        int pageNumber = 1;
        while (pageNumber < 1000) {
            File filePath = new File(String.format("C:\\Users\\Public\\APIData\\APIResult%s.txt", pageNumber));
            if (!filePath.exists()) {
                return filePath;
            }
            pageNumber++;
        }
        return new File("");
    }

    private static File locateNewSaveFieldChangeLogFilePath() {
        int pageNumber = 1;
        while (pageNumber < 1000) {
            File filePath = new File(String.format("C:\\Users\\Public\\APIData\\ChangeLog\\Change%s.txt", pageNumber));
            if (!filePath.exists()) {
                return filePath;
            }
            pageNumber++;
        }
        return new File("");
    }
}
