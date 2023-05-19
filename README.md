# Myhouse_Server 

## 팀 멤버 및 역할 분담

<table>
<thead>
<tr>
<th align="center">도소현</th>
<th align="center">최가희</th>
</tr>
</thead>
<tbody>
<tr>
<td align="center"><img src = https://github.com/sohyundoh/sohyundoh/assets/79795051/478d604c-af15-469d-98b3-4be51a64ac37 width = 200/></td>
<td align="center"><img src = https://github.com/sohyundoh/Readme_Check/assets/79795051/5762cdb3-a87a-4554-96bd-457e90d9a97c width = 200/></td>
</tr>
</tbody>
<tbody>
<tr>
<td align="center">GO SOPT Server Part YB</td>
<td align="center">GO SOPT Server Part OB</td>
</tr>
</tbody>
<tbody>
<tr>
<td align="center">AWS 배포<br/> [GET] (베스트 상품)상품 카테고리별 보기<br/> [GET] 이주의 인기 컨텐츠<br/> [GET] 둘러보기<br/> [POST] 스크랩 하기</td>
<td align="center">[DELETE] 스크랩 지우기 <br/>
[GET] nickname을 위한 추천 집들이<br/>
[GET] 게시글 상세 보기<br/>
[POST] 스크랩 폴더에 추가하기<br/>
[GET] 모든 스크랩</td>
</tr>
</tbody>
</table>

## 디렉토리 구조
```
src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── sopt
    │   │           └── myhouse
    │   │               ├── MyhouseApplication.java
    │   │               ├── common
    │   │               │   └── advice
    │   │               │       ├── ControllerExceptionAdvice.java
    │   │               │       └── dto
    │   │               │           └── ApiResponseDto.java
    │   │               ├── controller
    │   │               │   ├── HomeController.java
    │   │               │   ├── PostsController.java
    │   │               │   ├── ProductController.java
    │   │               │   ├── ScrapController.java
    │   │               │   └── dto
    │   │               │       ├── request
    │   │               │       │   └── ScrapRequestDto.java
    │   │               │       └── response
    │   │               │           ├── HomeDto.java
    │   │               │           └── PostPopularResponseDto.java
    │   │               ├── entity
    │   │               │   ├── Folder.java
    │   │               │   ├── Image.java
    │   │               │   ├── Post.java
    │   │               │   ├── Product.java
    │   │               │   └── Scrap.java
    │   │               ├── exception
    │   │               │   ├── ErrorStatus.java
    │   │               │   ├── SuccessStatus.java
    │   │               │   └── model
    │   │               │       ├── ConflictException.java
    │   │               │       └── GlobalException.java
    │   │               ├── repository
    │   │               │   ├── FolderRepository.java
    │   │               │   ├── ImageRepository.java
    │   │               │   ├── PostRepository.java
    │   │               │   ├── ProductRepository.java
    │   │               │   └── ScrapRepository.java
    │   │               └── service
    │   │                   ├── PostService.java
    │   │                   ├── ProductService.java
    │   │                   ├── ScrapService.java
    │   │                   └── dto
    │   │                       ├── request
    │   │                       │   └── ScrapSaveServiceDto.java
    │   │                       └── response
    │   │                           ├── FolderDto.java
    │   │                           ├── GetPostDetailDto.java
    │   │                           ├── ImageDto.java
    │   │                           ├── PostListResponseDto.java
    │   │                           ├── PostPopularResponseDto.java
    │   │                           ├── ProductResponseDto.java
    │   │                           └── ScrapDto.java
    │   └── resources
    │       └── application.yaml
    └── test
        └── java
            └── org
                └── sopt
                    └── myhouse
                        └── MyhouseApplicationTests.java
```

## Git Convention || Coding Convention
- 카멜 케이스로 작성
- eature branch는 이슈넘버를 사용하여 브랜치 삭제 및 생성을 반복합니다.
**형식** : [feature/#issue number] 
**커밋 예시** : [feature/#3] home 뷰 구현

*# feat : 기능 추가*

*# fix : 버그 수정*

*# docs : 문서 수정*

*# test : 테스트 코드 추가*

*# refactor : 코드 리팩토링*

*# style : 코드 의미에 영향을 주지 않는 변경사항*

*# chore : 빌드 부분 혹은 패키지 매니저 수정사항*

*# cicd : CI/CD 관련 설정*

## ER-Diagram
![image](https://github.com/sohyundoh/Readme_Check/assets/79795051/2c9e7124-ba92-40ef-95ed-0ac0552ade29)

