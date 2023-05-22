package org.sopt.myhouse.exception.model;


import org.sopt.myhouse.exception.ErrorStatus;

public class NotImageFoundException extends GlobalException{
    public NotImageFoundException(ErrorStatus error, String message){
        super(error, message);
    }
}
