package com.PhamKornbluhGroup.TemporaryDTOFieldFinder;

public class PageNumberFilePath {
    private String filePath;
    private int pageNumber;

    public PageNumberFilePath() {
    }

    public PageNumberFilePath(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PageNumberFilePath(String filePath) {
        this.filePath = filePath;
    }

    public PageNumberFilePath(String filePath, int pageNumber) {
        this.filePath = filePath;
        this.pageNumber = pageNumber;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return getFilePath();
    }

    public String getFilePath() {
        int indexOfFileType = filePath.lastIndexOf(".");
        if (indexOfFileType == -1) {
            throw new StringIndexOutOfBoundsException("Document file path must include filetype suffix, like \"[FILE_NAME].txt\"");
        }
        StringBuilder builder = new StringBuilder(filePath);

        // Add page number right before ".txt", ".notes", etc
        builder.insert(indexOfFileType, pageNumber);

        return builder.toString();
    }
}
