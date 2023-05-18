package org.sopt.myhouse.exception.model;

import org.sopt.myhouse.exception.ErrorStatus;

public class ConflictException extends GlobalException{
    public ConflictException(ErrorStatus error, String message){
        super(error, message);
    }
}
