package org.sopt.myhouse.exception.model;

import org.sopt.myhouse.exception.ErrorStatus;

public class NotFolderFoundException extends GlobalException{
    public NotFolderFoundException(ErrorStatus error, String message){
        super(error, message);
    }
}
