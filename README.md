# numble-web-novels
네카라쿠배 개발자와 함께 Spring boot로 웹소설 서비스 클론코딩 하기

### 1. 요구사항
- 소설 등록/작성/삭제
- 선호작 목록 (소설의 마지막 화, 내가 읽은 마지막 화를 함께 조회할 수 있어야 합니다. ex. 274/291 )
- 다양한 기준의 소설 목록 조회 기능(홈 노출/베스트/기타)
- 소설 편당 조회 및 결제
- 구매수 집계 등
- 포인트 충전

### 2. 데이터베이스 스키마
![novel-erd](https://user-images.githubusercontent.com/71953982/232319160-88d89ef0-7010-40ca-8f22-58b16ed70697.png)

### 3. 유저플로우
#### (1) 소장권 충전
![novel-diagram(1)](https://user-images.githubusercontent.com/71953982/232319170-2cbbc792-4b80-4003-9971-0099890986df.png)
#### (2) 선호작 보기
![novel-diagram(2)](https://user-images.githubusercontent.com/71953982/232319180-626dbfb5-fa4f-405e-9a0e-534d16f1098d.png)

### 4. API Document
- Overview : [numble-web-novels/blob/master/doc/ascii/overview.adoc](https://github.com/y00njinuk/numble-web-novels/blob/master/doc/ascii/overview.adoc)
- Definition : [numble-web-novels/blob/master/doc/ascii/definitions.adoc](https://github.com/y00njinuk/numble-web-novels/blob/master/doc/ascii/definitions.adoc)
- Path : [numble-web-novels/blob/master/doc/ascii/paths.adoc](https://github.com/y00njinuk/numble-web-novels/blob/master/doc/ascii/paths.adoc)
