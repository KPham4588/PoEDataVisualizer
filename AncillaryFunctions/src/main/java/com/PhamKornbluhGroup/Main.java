package com.PhamKornbluhGroup;

public class Main {
    public static void main(String[] args) {

        // TODO: Now it's time to write code to get the pageChangeId and use it to call getPublicStashData
        System.out.println("Beginning Ancillary Function");
        GGGAPIHandler apiHandler = new GGGAPIHandler();
        System.out.println("Created GGGAPIHandler object");
        APIResultData result = apiHandler.getPublicStashData("3176716451-3104538686-3029882391-3371404298-3262573054");
        System.out.println("Got back APIResultData");
        System.out.println(result.getResponseCode());
    }
}