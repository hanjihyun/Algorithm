# model
- User : 사용자
- Group : 그룹
- Feed : 피드
- Comment : 댓글
- Mileage : 마일리지
- Tag : 태그(워드 클라우드)

# Class
### DoitApplication  (main class)
- 워드 클라우드
### UserController 
- 로그인/로그아웃, SNS 구글 로그인
- 회원가입, 회원정보(비밀번호 변경, 탈퇴 ...)
### GroupController
 - 그룹 목록, 검색, 그룹 정보 조회,수정,삭제, 그룹 순위, 그룹 생성, 탈퇴
가입한 그룹 관리
 - 팀장 : 팀원 관리(강퇴), 팀장 위임
### FeedController
- 피드 (등록, 수정, 삭제)
- 그룹 내 정보 조회 
- 그룹명,소개, 인원, 활동 점수
### CommentController 
- 댓글(등록, 수정, 삭제)
### MileageController 
- 마일리지 상품 목록 조회
- 상품 구입
- 마일리지 내역 조회
### ManagerController 
- 회원 관리(강퇴)
- 마일리지 상품 등록
- 그룹 관리(수정 삭제)
- 피드 관리(수정 삭제)

# dao
- UserDao
- GroupDao
- FeedDao
- CommentDao
- MileageDao
- ManagerDao
