package pl.korbeldaniel.demo.model;

public class ApiErrorMessage {
    private String errorMessage;
    private int errorCode;
    private String documentation;

    public ApiErrorMessage(String errorMessage, int errorCode, String documentation) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.documentation = documentation;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDocumentation() {
        return documentation;
    }
}
