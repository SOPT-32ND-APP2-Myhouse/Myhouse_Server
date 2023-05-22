package org.sopt.myhouse.exception.model;

import org.sopt.myhouse.exception.ErrorStatus;
import org.springframework.http.HttpStatus;

public class NotScrapFoundException extends GlobalException{
    public NotScrapFoundException(ErrorStatus error, String message){
        super(error, message);
    }
}
