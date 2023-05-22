package org.sopt.myhouse.exception.model;

import org.sopt.myhouse.exception.ErrorStatus;

public class NotPostFoundException extends GlobalException{
    public NotPostFoundException(ErrorStatus error, String message)
    {
        super(error,message);
    }
}
