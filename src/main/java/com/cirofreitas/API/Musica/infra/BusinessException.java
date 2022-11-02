package com.cirofreitas.API.Musica.infra;

public class BusinessException extends RuntimeException {
    private String errorCode;
    private String suggestion;
    private int httpStatus;

    public BusinessException(String message){
        super(message);
        this.errorCode = "400";
        this.httpStatus=400;
        this.suggestion = "Contate o administrador";
    }

    public BusinessException(String errorCode, String suggestion,String message, Object ... params ){
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
