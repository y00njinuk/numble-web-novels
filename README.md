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
![novel-ERD drawio](https://user-images.githubusercontent.com/71953982/232318800-c02081ea-8cf6-4757-b229-194b5fba90e0.png)

### 3. 유저플로우
1. 소장권 충전
![novel-diagram(1)](https://user-images.githubusercontent.com/71953982/232318866-4fb110ed-6e2c-4995-9d92-bcdab8dce61c.png)

2. 선호작 보기
![novel-diagram(2)](https://user-images.githubusercontent.com/71953982/232318878-8a96b3a7-2a2f-4f72-a0b2-3e2832573086.png)
