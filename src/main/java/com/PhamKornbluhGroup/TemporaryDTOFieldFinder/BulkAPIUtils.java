package com.PhamKornbluhGroup.TemporaryDTOFieldFinder;

import com.PhamKornbluhGroup.APIResultData;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class BulkAPIUtils {
    public static HashSet<String> knownFields = new HashSet<>();
    private static HashSet<String> newFields = new HashSet<>();
    private static boolean initialized = false;

    private BulkAPIUtils() {
    }

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

    public static void saveAPIResults(APIResultData resultData) throws Exception {
        File filePath = locateNextFilePathNumber("C:\\Users\\Public\\APIData\\APIResult.txt");
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
            BulkAPIUtils.loadKnownFields();
        }

        boolean foundNewElement = false;

        for (String nextElement : currentFields) {
            if (!knownFields.contains(nextElement)) {
                //TODO: Remove this printLn when not needed anymore
                System.out.println(nextElement + " is new!");
                foundNewElement = true;
                newFields.add(nextElement);
                knownFields.add(nextElement);
            }
        }

        if (foundNewElement) {
            saveKnownFields();
            saveNewFieldChangeLog(pageChangeID);
            newFields.clear();
        }
    }

    public static void saveFirstUncheckedAPIResult(String filePath, int nextUncheckedNumber) {
        try (FileWriter writer = new FileWriter("firstUncheckedAPIResult.txt")) {
            writer.write(filePath + "\r\n");
            writer.write(nextUncheckedNumber);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PageNumberFilePath getFirstUncheckedAPIResult() throws Exception {
        PageNumberFilePath path = new PageNumberFilePath();

        File file = new File("firstUncheckedAPIResult.txt");
        if (!file.exists()) {
            // If there's no file, return with just an empty array
            //TODO: Start logging this
            return path;
        }
        try (FileInputStream fileInput = new FileInputStream(file);
             InputStreamReader inputReader = new InputStreamReader(fileInput);
             BufferedReader bufferedReader = new BufferedReader(inputReader)) {

            path.setFilePath(bufferedReader.readLine());
            path.setPageNumber(Integer.parseInt(bufferedReader.readLine()));
        }
        return path;
    }

    static File locateNextFilePathNumber(String documentFilePath) throws Exception {
        PageNumberFilePath path = new PageNumberFilePath(documentFilePath);

        int pageNumber = 1;
        while (pageNumber < 10000) {
            path.setPageNumber(pageNumber);

            File filePath = new File(path.toString());
            if (!filePath.exists()) {
                return filePath;
            }
            pageNumber++;
        }
        return new File("");
    }

    private static void saveNewFieldChangeLog(String pageChangeID) throws Exception {
        File filePath = locateNextFilePathNumber("C:\\Users\\Public\\APIData\\ChangeLog\\Change.txt");
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

    public static void loadKnownFields() throws Exception {
        File file = new File("knownfields.txt");
        if (!file.exists()) {
            // If there's no file, keep knownFields list empty, and return
            //TODO: Start logging this
            return;
        }
        try (FileInputStream fileInput = new FileInputStream(file);
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
}
