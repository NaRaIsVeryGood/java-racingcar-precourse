# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 기능 목록 정리

1. 자동차 이름 입력 받기
 - 자동차 이름은 쉼표를 기준으로 구분 => 쉼표를 기준으로 배열화
 - 5자 이하만 가능 => 자릿수 검토 로직

2. 시도 횟수 입력받기
 - 숫자인지 검토

3. 전진 조건 랜덤 값 생성
 - 0~9 랜덤 값, 랜덤값이 4이상 - 전진, 3이하 - 멈춤

4. 전진/멈춤 기능 처리
 - 4 이상 : 전진
 - 3 이하 : 멈춤

5. 우승자 메시지 리턴
 - 여러명의 경우 쉼표(,) 처리



## 기타
 - 일급컬렉션
 - 모든 원시값과 문자열을 포장
 - 에러 처리
 - convention 검토

