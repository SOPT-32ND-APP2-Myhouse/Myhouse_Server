package org.sopt.myhouse.exception;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {

    /*
    BAD_REQUEST
     */
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    VALIDATION_REQUEST_MISSING_EXCEPTION(HttpStatus.BAD_REQUEST, "요청값이 입력되지 않았습니다."),

    NO_CONTENT(HttpStatus.NOT_FOUND, "해당 페이지가 없습니다"),

    NO_POST(HttpStatus.NOT_FOUND,"해당 하는 게시물이 없습니다"),

    NO_SCRAP(HttpStatus.NOT_FOUND, "해당 스크랩이 없습니다"),

    NO_FOLDER(HttpStatus.NOT_FOUND, "해당 폴더가 없습니다"),

    NO_PRODUCT(HttpStatus.NOT_FOUND, "해당 상품은 없습니다."),

    /*
    404
    Not Found
     */
    IMAGE_URL_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 이미지가 존재하지 않습니다."),
    /*
    409 CONFLICT
     */
    ALREADY_EXIST_SCRAP_EXCEPTION(HttpStatus.CONFLICT, "이미 스크랩 되었습니다."),
    /*
    SERVER_ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 서버 에러가 발생했습니다."),
    BAD_GATEWAY_EXCEPTION(HttpStatus.BAD_GATEWAY, "일시적인 에러가 발생하였습니다.\n잠시 후 다시 시도해주세요!"),
    SERVICE_UNAVAILABLE_EXCEPTION(HttpStatus.SERVICE_UNAVAILABLE, "현재 점검 중입니다.\n잠시 후 다시 시도해주세요!"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode(){
        return httpStatus.value();
    }
}