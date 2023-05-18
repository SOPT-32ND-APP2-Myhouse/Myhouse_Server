package org.sopt.myhouse.exception.model;

import lombok.Getter;
import org.sopt.myhouse.exception.ErrorStatus;

@Getter
public class GlobalException extends RuntimeException{

    private final ErrorStatus errorStatus;

    public GlobalException(ErrorStatus error, String message){
        super(message);
        this.errorStatus = error;
    }

    public int getHttpStatus(){
        return errorStatus.getHttpStatusCode();
    }
}
