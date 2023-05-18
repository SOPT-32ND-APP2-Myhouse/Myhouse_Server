package org.sopt.myhouse.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    /*
    user
     */
//    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),
    /*
    scrap
     */
     SCRAP_SUCCESS(HttpStatus.CREATED, "스크랩이 완료되었습니다"),

     DELETE_SCRAP_SUCCESS(HttpStatus.ACCEPTED, "스크랩 삭제에 성공하였습니다"),

     GET_POST_DETAIL_SUCCESS(HttpStatus.OK, "게시글 조회에 성공하였습니다"),


    /*
    post
     */
    GET_RECOMMEND_POST_SUCCESS(HttpStatus.ACCEPTED, "추천 게시글 조회에 성공하였습니다");

    private final HttpStatus httpStatus;
    private final String message;
}