# 4주차
# 2026-02-23(13일차)
[표준 라이브러리](#1-표준-라이브러리)  
[venv 세팅 복사](#venv-세팅-복사)  
[sympy](#sympy)
[BeautifulSoup](#beautifulsoup)

## 1. 표준 라이브러리

### filter,  map
순회 가능한 데이터들을 필터를 통하여 줄이는 것

### operator.itemgetter
 sorted와 같은 함수의 key 매개변수에 적용하여 다양한 기준으로 정렬할 수 있도록 도와주는 모듈

### shutil
파일을 복사(copy)하거나 이동(move)할 때 사용하는 모듈

### glob
특정 디렉터리에 있는 파일 이름 모두 확인할 때 사용

### pickle
객체의 형태를 그대로 유지하면서 파일에 저장하고 불러올 수 있게 하는 모듈

### dotenv
```
nano .env
cat .env
    SECRET_KEY=아주중요한
    DEBUG=12345
    TEST=배고파
cat <<'end'>> .gitignore
cat .env
cat .gitignore
```

```python
from dotenv import load_dotenv
import os
load_dotenv()

data = os.getenv("SECRET_KEY")
dbug = os.getenv("DEBUG")
test = os.getenv("TEST")

print(data, dbug, test)
```

### os
환경 변수나 디렉터리, 파일 등의 OS 자원을 제어할 수 있게 해 주는 모듈

### zipfile
여러 개의 파일을 zip 형식으로 합치거나 이를 해제할 때 사용하는 모듈


### 실습
```python
'''
현재 폴더에 temp 폴더가 있는지 확인해 보고
없으면 생성하고 그 temp 폴더 안에
test_aa.txt , test_bb.txt ... test_gg
이름으로 파일(내용은 아무것이나)을 생성하고
모든 파일을 zip 파일로 압축하라.
'''
import os

# os.mkdir("temp") #FileExistsError

try:
    os.mkdir("temp")
except FileExistsError:
    pass

i = 0
while i < 7:
    alpha = chr(97 + i)
    with open(f"temp/test_{alpha*2}.txt", "w") as f:
        f.write("아무값: " + str(i))
    i += 1
```

### threading
```python
import time
import threading

def long_task():
    for i in range(5):
        time.sleep(1)
        print("working:%s\n" % i)

print("Start")

threads = []
for i in range(5):
    t = threading.Thread(target=long_task)
    threads.append(t) 

for t in threads:
    t.start()

print("End")
```

### traceback
```python
# traceback 오류 추적
import traceback

def a():
    return 1/0
    
def b():
    a()

def main():
    try:
        b()
    except:
        print("오류 발생")
        print(traceback.format_exc())

main()
```

## venv 세팅 복사
가상환경 pip 세팅 복사  
- 가상환경 venv1에 있는 pip 리스트를 `requirements.txt`에 뽑아 가상환경 venv2에도 동일하게 pip를 다운받을 수 있다
```
ls
. ./venv/bin/activate
pip list
deactivate

python -m venv venv2
ls
. ./venv2/bin/activate
pip list

pip freeze > requirements.txt
nano requirements.txt : 버전 바꾸고 저장

pip install -r requirements.txt
pip list
```

```
pip uninstall ~=1.1.1   : pip 삭제
pip install ~=1.1.2     : pip 설치
pip install --upgrade ~ : pip 업그레이드
```

## pip **
```
! pip install faker
```

랜덤 이름, 주소, 전화번호 뽑기
```python
from faker import Faker
fake = Faker('ko-KR')
print(fake.name())
print(fake.address())

test_data = [(fake.name(), fake.address(), fake.phone_number()) for i in range(30)]
print(test_data)
```

## sympy
```
! pip install sympy
```

```python
# sympy_test.py
from fractions import Fraction
import sympy

# 가지고 있던 돈을 x라고 하자.
# sympy_test.py
from fractions import Fraction
import sympy

x = sympy.symbols("x")

f = sympy.Eq(x*Fraction('2/5'), 1760)

result = sympy.solve(f)
remains = result[0] - 1760

print('남은 돈은 {}원 입니다.'.format(remains))
```

## BeautifulSoup
```python
# 응용, 멜론 차트 뽑기
import requests as req
from bs4 import BeautifulSoup as bs

url = "https://www.melon.com/chart/index.htm"
headers = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Safari/537.36 Edg/145.0.0.0'}

web = req.get(url, headers=headers)
web.content

title = soup.select('.rank01')[:20]
name = soup.select('.checkEllipsis a')[:20]
str = ''
for i, (t, n) in enumerate(zip(title, name),1):
    str += f'{i}위: {t.text.strip()} / {n.text}\n'
print(str,end=' ') 
```

# 2026-02-24(14일차)
[라이브러리 풀이](#1-라이브러리-문제-풀이)  
[API](#2-api)  
[클로저와 데코레이터](#클로저와-데코레이터)

## 1. 라이브러리 문제 풀이

## 2. API
Google Gemini
```python
# 구글 제미나이 AI
from google import genai

client = genai.Client(api_key="")

response = client.models.generate_content(
    model="gemini-2.5-flash-lite", contents="낮과 밤 중 언제가 길어?"
)
print(response.text)
```

## 클로저와 데코레이터


# 2026-02-25(15일차)
[크롤링](#1-크롤링)  
[이터레이터](#이터레이터)  
[제너레이터](#제너레이터)  
[타입 어노테이션](#타입-어노테이션)  
[파이썬 시험](#파이썬-시험)  
[우분투](#우분투)

## 1. 크롤링
웹사이트 뒤에 `robots.txt` -> 정보 나옴  
```python
# 날씨
import requests as req
from bs4 import BeautifulSoup as bs

url = "https://search.naver.com/search.naver?where=nv&sm=top_sug.pre&fbm=0&acr=1&acq=spdlqj+skf&qdt=0&ie=utf8&query=%EB%84%A4%EC%9D%B4%EB%B2%84%EB%82%A0%EC%94%A8&ackey=0w6wigb9"
headers = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/145.0.0.0 Safari/537.36 Edg/145.0.0.0'}
web = req.get(url , headers=headers)
soup = bs(web.content, 'html.parser')
location = soup.select(".title")[0].text.strip()
cc = soup.select(".temperature_text")[0].text.strip()
summary = soup.select(".summary")[0].text.strip()

print(location)
print(cc)
print(summary)
```

## 이터레이터
`next()`로 값을 하나씩 꺼낼 수 있는 객체
```python
a = [1,2,3]
it = iter(a)
```

```python
print(next(it))
```

```python
while True:
    try:
        print(next(it))
    except StopIteration:
        break
```

```python
# iterator.py
class MyIterator:
    def __init__(self, data):
        self.data = data
        self.position = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.position >= len(self.data):
            raise StopIteration
        result = self.data[self.position]
        self.position += 1
        return result

if __name__ == "__main__":
    i = MyIterator([1,2,3])
    for item in i:
        print(item)
```

## 제너레이터
이터레이터를 쉽게 만들어 주는 함수  
```python
# 제너레이터
def mygen():
    yield 1
    yield 2
    yield 3

g = mygen()
```

```python
next(g)
```

## 타입 어노테이션
타입에 대한 힌트를 제공하는 정도의 기능만 지원  
동적 언어의 장점을 잃지 않으면서 기존 코드와의 호환성을 유지
```python
# 변수에 타입 지정
num: int = 1
name: str = "홍길동"
numbers: list = [1, 2, 3]
```

```python
# 함수에 타입 지정
def add(a: int, b: int) -> int: 
    return a + b

def greet(name: str) -> str:
    return f"안녕하세요, {name}님!"

def get_user_info(user_id: int) -> dict:
    return {"id": user_id, "name": "홍길동"}
```

## 파이썬 시험

## 우분투
`sudo apt install net-tools`  
`hostname -I`  
`ifconfig`  
`sudo apt update`
`sudo apt install openssh-server`

### 윈도우 파워쉘에서 리눅스 연결  
ssh로 연결할 수 있다  
접속: `ssh kbw@리눅스IP주소`

htop 설치: 성능 확인, 작업관리자라고 보면 됨  
`htop`
`sudo apt install htop`


# 2026-02-26(16일차), DB 시작

## 1. 도커
- 도커 설치

## 2. 데이터베이스
- 도커에서 Oracle 설치
- DBeaver 설치
    - database 연결(Oracle)
- VSCode
    - extensions
    - database 연결(Oracle)

## 웹 개발 면접 준비 스터디
- Null이란
- http, https 차이
- 트랜잭션
- 인덱스
- DB 모니터링
* 지역변수, 전역변수
* 토큰, 세션, 쿠키, CRUD, jwt방식, RAID, sql injection, XSS



# 2026-02-27(17일차)

## 1. DBeaver 사용법

## 2. DB
- 모든 언어는 index가 0부터 시작이지만, DB는 1부터 시작
- SELECT 문
    - 셀렉션, 프로젝션, 조인
    - 별칭, 중복제거
    - 정렬
    - 조건절
    - 연산자
    - NOT
    - IN
    - BETWEEN
    - UNION
    - UNION ALL
- 오라클 함수
    - UPPER
    - LOWER
    - INITCAP
    - LENGTH
    - SUBSTR
    - INSTR
    - REPLACE

## etc
- 실행계획: DB 최적화
- cmd 창: `nslookup`
    - 도메인 주소로 인터넷 접속