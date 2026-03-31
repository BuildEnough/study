# Python
- [공부 참고](https://www.youtube.com/watch?v=W3vzf_Pz-VI)

## 1. 파이썬 업무자동화 세팅
- pyautogui 세팅
```
pip install pyautogui
```
```
pip3 install pyautogui
```

- 듀얼모니터일 경우, screeninfo 설치
```
pip install screeninfo
```

### 1-1. 자동화 영상
- 마우스 자동화
![마우스 자동화](./image/마우스%20자동화.gif)

## 2. 웹 사이트 자동화

### 2-1. 셀레니움(selenium)
- 웹 브라우저를 제어할 수 있는 파이썬 라이브러리
- 웹 사이트를 자동화할 수 있게 도와줌

### 2-2. selenium 라이브러리 설치
```
pip install selenium
```

### 2-3. 크롬 드라이버 다운로드
- 윈도우: c:/chromedriver.exe
- 맥: /Users/Documents/chromedriver

#### 1) 크롬 버전 확인
#### 2) 크롬 드라이버 다운로드
- 구글 검색 ㄱ

#### 3) send_keys 우회방법 -> pyautogui
- 'send_keys'는 자동입력 탐지기가 자바스트립트를 감지하기 때문에,
- pyautogui의 붙여넣기 기능을 활용하면 네이버에 로그인 할 수 있다.

## 2. 엑셀 자동화
- openpyxl 세팅
```
pip install openpyxl
```

## 3. 색상의 HEX 값 구하기
구글 -> `color picker` 검색
![HEX 색상값](./image/HEX%20색상값.png)
