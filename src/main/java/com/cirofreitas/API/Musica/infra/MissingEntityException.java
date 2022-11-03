package com.cirofreitas.API.Musica.infra;

public class MissingEntityException extends RuntimeException {
    private String errorCode;
    private String suggestion;
    private int httpStatus;

    public MissingEntityException(String message){
        super(message);
        this.errorCode = "404";
        this.httpStatus=404;
        this.suggestion = "Contate o administrador";
    }

    public MissingEntityException(String errorCode, String suggestion,String message, Object ... params ){
        super(String.format(message, params));
        this.errorCode = errorCode;
        this.suggestion = suggestion;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
