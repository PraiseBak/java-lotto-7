# java-lotto-precourse

# 기능 명세
## 구매
- 구매 금액 입력
  - 숫자인지 확인
  - 단위에 맞는지 확인
- 구매 결과 생성
- 구매 결과 출력

## 당첨
- 당첨번호 입력
  - 숫자인지 확인
  - 숫자 개수 확인
  - 범위안인지 확인
- 보너스 번호 입력
  - 숫자인지 확인
  - 범위안인지 확인
- 당첨 통계
  - 당첨 개수 확인
  - 보너스 번호 확인
  - 수익률 계산


# 클래스 다이어그램
![img.png](img.png)


# MVC 구조
## Application의 역할
- Application의 마치 프론트엔드 서버와 같다고 생각하여 Application에서 유저에게 직접 입력받는 부분을 위임했습니다.

## 도메인 결과값 관리
- 각 도메인은 결과값을 직접 출력하지않고 항상 Application단까지 전달하여 출력하도록 하였습니다.