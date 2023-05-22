package org.sopt.myhouse.common.advice;


import org.sopt.myhouse.common.advice.dto.ApiResponseDto;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.model.NotFolderFoundException;
import org.sopt.myhouse.exception.model.NotImageFoundException;
import org.sopt.myhouse.exception.model.NotPostFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerExceptionAdvice {

    /*
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ApiResponseDto.error(ErrorStatus.VALIDATION_REQUEST_MISSING_EXCEPTION);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotImageFoundException.class)
    protected ApiResponseDto handleNotFoundException(final NotImageFoundException e){
        return ApiResponseDto.error(ErrorStatus.IMAGE_URL_NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFolderFoundException.class)
    protected ApiResponseDto handleNotFolderException(final NotFolderFoundException e){
        return ApiResponseDto.error(ErrorStatus.NO_FOLDER);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotPostFoundException.class)
    protected ApiResponseDto handlerPostNotFoundException(final NotPostFoundException e ){
        return ApiResponseDto.error(ErrorStatus.NO_POST);
    }
}
