# Servlet MVC Board

## clone/pull 전에 확인 요망
- git 익숙하지 않으면 원래 프로젝트 다른데다 clone 할 것(원래 프로젝트에 pull하여 충돌나서 파일 사라지면 오열...)
- git clone/pull 하면 `bit.report.servletmvcboard.config.MybatisManager`의 db 정보 변경하기
- 테이블 정의 파일 : create-table.sql

## 프로젝트 패키지 구조
```text
.
├── java
│   └── bit
│       └── report
│           └── servletmvcboard
│               ├── config    <- ** 설정 클래스 보관 **
│               ├── controller   <- ** 컨트롤러(HttpServlet 상속) 클래스 보관 **
│               ├── dao    <- ** DB와 관련된 클래스 보관 **
│               │   ├── model    <- ** DB 테이블과 동일한 class **
│               │   └── param    <- ** Dao에 전달할 파라미터 class **
│               ├── dto    <- ** db로부터 조회하여 view에 전달할 class **
│               └── service    <- ** 비즈니스 로직을 담은 class **
├── resources
│   └── bit
│       └── report
│           └── servletmvcboard
│               └── dao    <- ** Dao 인터페이스와 매핑될 xml 파일 보관 **
└── webapp
    ├── WEB-INF
    │   ├── components
    │   ├── views    <- ** 여기에 view 파일 보관 **
    │   │   ├── article
    │   │   └── user
    │   └── web.xml
    ├── css
    └── index.jsp    <- ** '/' 경로를 '/article/list' 경로로 리다이렉트 **
```


---
## TODO
### 기능 구현 및 페이지 연결
- [x] 로그인
    - [x] 로그인 상태 관리(페이지별 접근 제어)
- [x] 회원가입
- [x] 글 쓰기
- [ ] 글 상세 (재구현 필요)
    - [ ] 좋아요
    - [ ] 싫어요
- [x] 글 수정
- [x] 글 삭제
- [x] 글 목록 (검색, 페이징)
- [x] 스크랩
- [ ] 마이페이지


### 페이지 작성
- [x] 로그인
- [x] 회원가입
- [x] 글 쓰기
- [x] 글 상세
    - [x] 좋아요/싫어요 버튼 - 기능 연동 필요!!
    - [x] 스크랩 버튼 (완료)
    - [x] 수정/삭제 버튼 (완료)
- [x] 글 수정
- [x] 글 목록 (검색, 페이징)
- [ ] 마이페이지
    - [x] 스크랩 리스트
    - [ ] 좋아요 싫어요 리스트
    - [x] 회원 정보 수정

### 기타
- [ ] error control


---

