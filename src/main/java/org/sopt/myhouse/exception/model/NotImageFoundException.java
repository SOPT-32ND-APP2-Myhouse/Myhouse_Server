package org.sopt.myhouse.exception.model;


import org.sopt.myhouse.exception.ErrorStatus;

public class NotFoundException extends GlobalException{
    public NotFoundException(ErrorStatus error, String message){
        super(error, message);
    }
}
