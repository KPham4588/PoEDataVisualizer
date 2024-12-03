package com.PhamKornbluhGroup;

import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class runner {
    public static void main(String[] args) {
        new PublicStashTabBulkAPICaller().callAndPrintResults();
    }
}
