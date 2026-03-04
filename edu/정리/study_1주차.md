# 1주차
# 2026-02-02(1일차)
[7-zip 압축 프로그램 설치](#1-7-zip-압축-프로그램-설치)  
[디스크 분할 D 드라이브](#2-디스크-분할-d-드라이브)  
[윈도우 하위 리눅스 설정(WSL)](#3-윈도우-하위-리눅스-설정wsl)  
[Ubuntu 설치](#4-ubuntu-설치)  
[cmd 리눅스](#5-cmd-리눅스)  
[리눅스에서 파이썬](#6-리눅스에서-파이썬)  
[파이썬 가상환경 설치](#7-파이썬-가상환경-설치)  
[파이썬 가상환경 실행](#8-파이썬-가상환경-실행)  
[주피터 랩](#9-주피터-랩)  
[Cmd 명령어](#10-cmd-명령어)  
[파이썬](#11-파이썬)  
[파이썬 실행 방법](#12-파이썬-실행-방법)  
[그 외](#13-그-외)

## 1. 7-zip 압축 프로그램 설치

## 2. 디스크 분할 D 드라이브
- 윈도우 아이콘 우클릭 -> 디스크 관리 -> 우클릭(볼륨 축소) -> 새 단순 볼륨 -> 파티션 포맷(볼륨 레이블: DATA)

## 3. 윈도우 하위 리눅스 설정(WSL)
- 설정 -> 시스템 -> 선택적기능 -> 기타 윈도우 기능
- Cmd 창에서 `wsl` 명령어 입력 후 설치

## 4. Ubuntu 설치
- `cat /etc/os*` : 리눅스 OS 버전 확인 명령어

## 5. cmd 리눅스
root 인지 확인만
- `sudo passwd`: 1234
- `su`
- `exit`

exit로 나오고 
- `sudo apt update`
- `sudo apt upgrade`

## 6. 리눅스에서 파이썬
- `pip -V`
- `sudo apt install python3-pip`
- `pip install jupyterlab`

## 7. 파이썬 가상환경 설치
- `python3 -m venv 가상환경이름`
- `sudo apt install python3.12-venv`: 처음 설치시 명령어
- `rm -r 가상환경폴더이름`: 폴더 지우기
- `cd 들어가고싶은폴더`: 경로 이동

## 8. 파이썬 가상환경 실행
- 가상환경 폴더 -> bin -> activate
- `source activate`: 가상환경 실행
- `deactivate`: 가상환경 종료
- `. ./venv/bin/activate`

## 9. 주피터 랩
가상환경에서 
- `pip install jupyter lab`: 주피터 랩 설치
- `jupyter lab`: 주피터 랩 실행
    - 명령어에 URLs 주소 클릭

자동닫기 처리 환경설정
- setting -> NoteBook -> Auto Closing Brackets 체크

## 10. Cmd 명령어
`explorer.exe .`: 현재 디렉토리를 파일 탐색기로 열기
- 잘 안될 경우 `wsl shutdown` 명령어 실행 후 다시 하면 됨

## 11. 파이썬
- print()안에서 `end=''` 를 이용하여 개행제거
```python
print("=", end='')
print("?")
# =?
```  

- print()안에서 `sep=''` 를 이용하여 문자열 사이 구분
    - `,`는 자동 띄어쓰기를 지원하기 때문에 사용
```python
print("안녕","하시","겠습니까","?") # 안녕 하시 겠습니까 ?
print("안녕","하시","겠습니까","?", sep='-') # 안녕-하시-겠습니까-?
print(1, 2, 3, 4, 5, sep='') # 12345
```

- time.sleep 사용
    - 출력 사이마다 1초 대기
```python
import time as t
print("안녕")
t.sleep(1)
print("하시렵니까")
t.sleep(1)
print("?")
```

- 캐리지 리턴
    - 텍스트의 줄 바꿈에서 줄 시작 위치로 복귀하는 동작을 제어하기 위해 사용
    - 화면을 새로 그리지 않고 동일한 위치에서 내용을 갱신
    - `\r`
```python
import time as t
print("기대하세요", end='\r') # 캐리지 리턴
t.sleep(1)
print("드디어~~", end='\r') # 캐리지 리턴
t.sleep(1)
print("개봉합니다!")
```

- 정수형, 실수형, 2진수
```python
aaa = 0b11 # 2진수(bin) 2x1 + 1x0
bbb = 0o11 # 8진수(oct) 8x1 + 1x0
ccc = 0x1f # 16진수(hex) 16*1 + f(15)
print(aaa) # 3
print(bbb) # 9
print(ccc) # 31
```

- 거듭제곱
```python
ss = 2
dd = 10
print(ss ** dd) # 1024
```

- 사칙연산
    - 몫 계산: `//`
    - 승 계산: `**`

- 복합연산자
    - `+=`, `-=`, `*=`, `/=`, `//=`, `%=`, `**=`


## 12. 파이썬 실행 방법
- cmd 창 -> `python3 파일이름.py`

## 13. 그 외
- 웹 브라우저 -> 개발자 모드 -> html 편집기 -> 복사 -> 마크다운 삽입


# 2026-02-03(2일차)
[vi](#1-vi)  
[리눅스](#2-리눅스)  
[자동화 파일](#3-자동화-파일)  
[주피터 랩](#4-주피터-랩)  

## 1. vi
`vi`
- `:q`: 종료


## 2. 리눅스
`cat`
- 파일 내용을 화면에 출력하거나, 여러 파일을 하나로 연결하는 데 사용

`cat >> 생성할파일.확장자`
- 파일 생성

`cat > 생성할파일.확장자`
- 파일 덮어쓰기

`cat <<'end'>> 생성할파일.확장자`
- 작성 후 종료 시 `end` 입력하여 종료
- 덮어 쓸 경우 `cat <<'end'> 생성할파일.확장자`

`history`
- 실행한 명령어 확인

## 3. 자동화 파일
`cat <<'end'>> jupy.sh`
```
> echo "주피터랩 서버를 시작합니다."
> source /home/kbw/venv/bin/activate
> jupyter lab
> end
```
- 절대주소로 시작: `/`

`. jupy.sh`
- 실행

## 4. 주피터 랩
- 주피터랩 안에서 명령어 실행 시 `!`를 붙여주면 됨 ->  `! ls`, `! pwd`
- 문자열 자료형
- 문자열 길이 구하기
    - `len`
    ```python
    a = "Life is too short"
    print(a+"는",str(len(a)) + "자 입니다")
    # Life is too short는 17자 입니다
    ```
- 문자열 인덱싱과 슬라이싱
    - `[]`
- 문자열은 불변(immutable)이다

- `requests`, `get` 사용
    ```python
    import requests as req
    url = "https://v.daum.net/v/20260203120206039"
    res = req.get(url).text
    print(res[res.find("오영석 박사는 "):res.find('"이라며 "대형 부품 제조를')])
    ```

    ```python
    # 비트코인 환율 변환기
    import requests as req
    from datetime import date

    bitUrl = "https://api4.binance.com/api/v3/ticker/price?symbol=BTCUSDT"
    wonUrl = "https://m.search.naver.com/p/csearch/content/qapirender.nhn?key=calculator&pkid=141&q=%ED%99%98%EC%9C%A8&where=m&u1=keb&u6=standardUnit&u7=0&u3=USD&u4=KRW&u8=down&u2=1"

    bitRes = req.get(bitUrl).text
    wonRes = req.get(wonUrl).text

    bit = wonRes[wonRes.rfind("value", 2)+10:wonRes.rfind("value", 2)+15]
    bit = int(bit.replace(',', ''))
    won = format(bit * int(bitRes[29:34]), ',')

    print(won + "원")
    ```
- 문자열 포매팅
    - `%`
    ```python
    # input 으로 개수를 입력받아
    # 한 잔에 2500원인 아이스 아메리카노와 3800원인 라떼를 계산한 영수증을 출력
    # 예
    '''
    =====================
            영수증
    =====================
        아아 7잔
        라떼 4잔

    ---------------------
        아아 17500원
        라떼 15200원
    >>> 총 가격:  32700원
    =====================
    '''
    aaEa = input("아이스 아메리카노 개수를 입력해주세요")
    latteEa = input("라떼 개수를 입력해주세요")

    print("=====================\n\t영수증\n=====================")
    print("       아아 {0}잔".format(aaEa))
    print("       라떼 {0}잔".format(latteEa))

    aaPrice = 2500 * int(aaEa)
    lattePrice = 3800 * int(latteEa)
    print("\n---------------------")
    print("     아아 {0}원".format(aaPrice))
    print("     라떼 {0}원".format(lattePrice))
    print(">>> 총 가격:  {0}원".format(aaPrice + lattePrice))
    print("=====================")
    ```
- dir 내장함수
    ```python
    dir(str)
    ```
    -  어떤 객체를 인자로 넣어주면 해당 객체가 어떤 변수와 메소드(method)를 가지고 있는지 나열

### 4-1. 마크다운
- 스타일
    - `<table style="float:left">`: 왼쪽으로 표이동
    - `<td><mark>문자열 안에서 줄을 바꿀 때 사용</mark></td>`: mark 강조표시


# 2026-02-04(3일차)
[주피터 랩](#1-주피터-랩)  

## 1. 주피터 랩
- f 문자열 포매팅
    ```python
    name = "홍길동"
    age  = 30
    print(f"나의 이름은 {name:=^11}이고, 나이는 {age+1} 입니다.")
    # 나의 이름은 ====홍길동====이고, 나이는 31 입니다.
    ```
- 딕셔너리 자료형
    ```python
    d = {'name':'홍길동', 'age':30}
    print(f"나의 이름은 {(d['name']):=^11}이고, 나이는 {d['age']+1} 입니다.")
    # 나의 이름은 ====홍길동====이고, 나이는 31 입니다.
    ```
- 문자열 관련함수
    ```python
    dir(str)
    ```
    - `count`, `find`, `index`, `join`
    - `upper`, `lower`, `lstrip`, `rstrip`, `replace`, `split`,
    - `isalpha`, `isdigit`
    ```python
    # BaNaNa -> banana -> c = b*n*a*N*a -> ['b', 'a', 'n', 'a', 'n', 'a']
    ba = 'BaNaNa'
    ba = ba.lower()
    print(ba)
    ba = "*".join(ba)
    print(ba)
    ba = ba.split("*")
    print(ba)
    ```
- 리스트 자료형
    ```python
    # 배열 초기화
    cc = []
    dd = list()
    ```
    ```python
    # 2중 배열
    li = [1,2,3,4,[11,22,33]]
    print(li)
    print(li[4][0])
    ```
    ```python
    # 3중 리스트, Life 출력
    a = [1, 2, 3, ['a', 'b', 'c', ['ok', 'Life', 'is']]]
    print(a[-1][-1][1])
    ```
    ```python
    # 중첩된 리스트에서 슬라이싱, ['a', 'b', 'c'] 출력
    a = [1, 2, ['0', '1', 'a', 'b', 'c'], 4, 5]
    print(a[2][2:5])
    ```
    ```python
    # 리스트 더하기
    a = [1, 2, 3]
    b = [4, 5, 6]
    print(a + b)

    # 리스트 반복
    c = a * 3
    print(c, len(c))
    ```
    ```python
    # del 요소 삭제
    aa = [11, 22, 33, 44, 55]
    del aa[:2]
    print(aa)
    ```
- 리스트 함수
    ```python
    # append - 추가
    a = []
    a.append(1)
    a.append([11, 22, 33])
    a.append(3)
    print(a)
    ```
    ```python
    # sort - 리스트 정렬
    a = [5, 43, 20, 4, 67, 42, 30]
    b = ['as', 'qw', 'asd', 'yi', 'gk', 'co', 'it']
    a.sort()
    b.sort()
    print(a)
    print(b)
    ```
    ```python
    # reverse - 리스트 뒤집기
    a = [5, 43, 20, 4, 67, 42, 30]
    b = ['as', 'qw', 'asd', 'yi', 'gk', 'co', 'it']
    print(a[::-1])
    print(b[::-1])
    a.reverse()
    b.reverse()
    print(a)
    print(b)
    ```
    ```python
    # sorted - 원본 유지
    aa = [66, 77, 88, 99, 0]
    print(sorted(aa))
    print(sorted(aa, reverse=True))
    print(aa)

    fruit = ['banana', 'kiwi', 'orange', 'melon', 'apple', 'watermelon']
    print(sorted(fruit))
    print(sorted(fruit, key=len, reverse=True)) # 글자 길이의 오름차순
    print(sorted(fruit, key=len, reverse=False)) # 글자 길이의 내림차순
    ```
    ```python
    # insert 리스트에 요소 삽입
    a = [1,2,3,4,5,6]
    a.insert(len(a), 77)
    print(a)
    ```
    ```python
    # pop 리스트 요소 꺼내기
    a = [1,2,3,4,5]
    print(a.pop())
    print(a)
    print(a.pop())
    print(a)
    print(a.pop())
    print(a)
    ```


# 2026-02-05(4일차)
[튜플](#1-튜플)  
[딕셔너리](#2-딕셔너리)  
[set 집합 자료형](#3-set-집합-자료형)

## 1. 튜플
- 1개의 요소만을 가질 때는 요소 뒤에 `,`를 반드시 붙여야 한다
- 소괄호(())를 생략해도 된다
    ```python
    t1 = ()
    t2 = (1,) # 1개의 요소
    t3 = (1, 2, 3)
    t4 = 1, 2, 3 # ()생략 가능
    t5 = ('a', 'b', ('ab', 'cd'))
    ```
- 튜플의 요솟값은 한 번 정하면 지우거나 변경할 수 없다
    ```python
    # 튜플 요솟값 삭제
    t1 = (1, 2, 'a', 'b')
    del t1[1] # 삭제 불가
    # TypeError: 'tuple' object doesn't support item deletion
    ```
    ```python
    # 튜플 요솟값 변경
    t1 = (1, 2, 'a', 'b')
    t1[2] = 'apple' # 변경 불가
    # TypeError: 'tuple' object does not support item assignment
    ```
- 인덱싱
    ```python
    # 인덱싱하기
    t1 = 1, 2, 'a', 'b'
    t2 = t1[2:]
    print(t2)
    ```
- 더하기
    ```python
    # 튜플 더하기
    t1 = (1, 2, 'a', 'b')
    t2 = (3, 4)
    t3 = t1 + t2
    print(t3)
    ```
- 길이 구하기
    ```python
    # 튜플 길이 구하기
    t1 = (1, 2, 'a', 'b')
    print(len(t1))
    ```

## 2. 딕셔너리
- Key와 Value의 쌍 여러 개가 {}로 둘러싸여 있다
- 각각의 요소는 `Key: Value` 형태로 이루어져 있고 `,`로 구분되어 있다
```python
# 딕셔너리 초기화
dic0 = {}
print(dic0)

dic1 = dict()
print(dic1)
```
``` python
# 딕셔너리 생성
dic0 = {0:'banana', 1:'apple', 2:'kiwi', 3:'orange'}
dic1 = {'name': 'pey', 'phone': '010-9999-1234', 'birth': 1118}
print(dic0)
print(dic1['name'])
```
```python
#  딕셔너리 쌍 추가
dic1['리스트'] = [11,22,33]
dic1['튜플'] = 44, 55, 66
dic1['딕셔너리'] = {"name":"홍길동"}
print(dic1)
```
```python
# 딕셔너리 요소 삭제
del dic1[1]
print(dic1)
```
- 딕셔너리에서 Key는 고유한 값이므로 중복되는 Key 값을 설정하면 하나를 제외한 나머지 것들이 모두 무시됨
    ```python
    a = {1:'a', 1:'b'}
    print(a) # {1: 'b'}
    ```
- Key에는 불변만 가능
```python
a = {[1,2]: "hi"}
# TypeError: unhashable type: 'list'

a = {{1:'hello'}: "hi"}
# TypeError: unhashable type: 'dict'
```

### 딕셔너리 관련함수
- `keys()`, `values()`, `items`, `clear()`, `get()`, `in`, `pop()`

## 3. set 집합 자료형
```python
# 집합 자료형 초기화
s1 = set()
print(s1, type(s1))
```
- 중복을 허용하지 않는다
    ```python
    # 중복 허용 불가
    li = [1,2,3]*2 + [11,22,33]*3
    print(li)
    s1 = set(li)
    print(s1)
    ```
- 순서가 없다
    ```python
    # 순서 없음
    s2 = set("abcdefghijklnmopqrstuvwxyz")
    print(s2)
    ```
- 교집합, 차집합, 합집합
    ```python
    s1 = set([1, 2, 3, 4, 5, 6])
    s2 = set([4, 5, 6, 7, 8, 9])
    # 교집합
    print(s1&s2)
    print(s1.intersection(s2))

    #차집합
    print(s1|s2)
    print(s1.union(s2))

    #합집합
    print(s1-s2)
    print(s1.difference(s2))
    ```


- 집합 자료형 관련 함수
    ```python
    # add 집합 자료형 값 1개 추가
    s1 = set([1,2,3])
    s1.add(4)
    ```
    ```python
    # update 집합 자료형 값 여러 개 추가
    s1 = set([1,2,3])
    s1.update([2,3,4,5,6,7])
    ```
    ```python
    # remove 집합 자료형 특정 값 제거
    s1 = set([1,2,3])
    s1.remove(2)
    s1.discard(0) # 없는 값이어도 오류가 발생하지 않음
    ```
    ```python
    # clear 집합 자료형 모든 값 제거
    s1 = set([1,2,3])
    s1.clear()
    ```

- 불 자료형
    ```python
    a = True
    b = False
    ```
    - `==`, `!=`, `>`, `<`, `<=`, `>=`
    ```python
    print(bool("python")) #True
    print(bool("")) #False
    print(bool([1, 2, 3])) #True
    print(bool([])) #False
    print(bool((1, 2, 3))) #True
    print(bool(())) #False
    print(bool({'a': 1})) #True
    print(bool({})) #False
    print(bool(1)) #True
    print(bool(0)) #False
    ```
- 논리연산자
    ```python
    # and 연산자
    print(True and True) #True
    print(True and False) #False
    print(False and True) #False
    print(False and False) #False
    ```
    ```python
    # or 연산자
    print(True or True) #True
    print(True or False) #True
    print(False or True) #True
    print(False or False) #False
    ```
    ```python
    # not 연산자
    print(not True) #False
    print(not False) #True
    print(not 1) #False
    print(not 0) #True
    ```

# 2026-02-06(5일차)
[비트코인](#1-비트코인)  
[API 문제1](#2-api-문제1)  
[API 문제2](#3-api-문제2)  
[주피터랩 실행단축](#4-주피터랩-실행단축)

## 1. 비트코인
- 빗썸 API 활용
    ```python
    # 비트코인 API
    import requests as req
    url = "https://api.bithumb.com/v1/candles/minutes/1?market=KRW-BTC&count=1"
    d_url = "https://api.bithumb.com/v1/candles/days?market=KRW-BTC&count=1"
    ori = req.get(url).json()[0]
    ori2 = req.get(d_url).json()[0]

    '''분봉'''
    # 시작가
    openp = float(ori['opening_price']) 
    # 최대가
    maxp = float(ori['high_price'])
    # 최소가
    minp = float(ori['low_price'])
    # 변화폭
    bandp = maxp - minp

    '''일봉'''
    # 시작가
    openp2 = float(ori2['opening_price']) 
    # 최대가
    maxp2 = float(ori2['high_price'])
    # 최소가
    minp2 = float(ori2['low_price'])
    # 변화폭
    bandp2 = maxp2 - minp2

    print("분기준 시작가:", openp, "\n분기준 최대가:", maxp, "\n분기준 최소가:", minp, "\n분기준변화폭:", bandp)
    print("일기준 시작가:", openp2, "\n일기준 최대가:", maxp2, "\n일기준최소가:", minp2, "\n일기준 변화폭:", bandp2)
    # print("검토:", openp+bandp)
    # print("최고가:", maxp)

    result = "떡상 중" if ((openp+bandp) > maxp) else "떡락 중"
    result2 = "떡상 중" if ((openp2+bandp2) > maxp2) else "떡락 중"
    print("분봉 판단:", result)
    print("일봉 판단:", result2)
    ```


## 2. API 문제1

터미널에서 `pip install requests`

```python
# 정제하기
import requests as req
import webbrowser as wb

url = "http://api.open-notify.org/iss-now.json" # 위성위치
url2 = "http://api.open-notify.org/astros.json" # 팁승자 명단

result = req.get(url).json()
lat = result['iss_position']['latitude'] # 위도
lon = result['iss_position']['longitude'] # 경도

human_num = req.get(url2).json()["number"]
print(human)

url = f'https://www.google.com/maps?q={lat},{lon}'
print(f"현재 {human_num}명이 탑승한 인공위성(국제우주정거장) 위치를 열겠습니다.위도:{lat}, 경도:{lon}")

wb.open(url)
```


## 3. API 문제2
```python
import requests as req
url = "https://api.fda.gov/drug/event.json?count=patient.reaction.reactionmeddrapt.exact"
value = req.get(url).json()

# 1. FDA 데이터베이스에서 보고서 중 구토 증상의 횟수를 찾아 출력 -> "NAUSEA"
NAUSEA_COUNT = value['results'][3]['count']
print(f'NAUSEA의 구토 증상 횟수: {NAUSEA_COUNT}')

# 2. COVID-19 관련 보고 건수는 몇 건 ?
# COVID 찾기
covid_count = 0
for i in range(len(value["results"])):
    item = value["results"][i]
    if item["term"] == "COVID-19":
        COVID_COUNT = value["results"][covid_count]['count']
    covid_count = covid_count + 1

print(f'COVID-19 건수: {COVID_COUNT}')

# 3. MYOCARDIAL INFARCTION(심근경색) 몇 건?
myocardial_count = 0
for i in range(len(value["results"])):
    item = value["results"][i]
    if item["term"] == "MYOCARDIAL INFARCTION":
        MYOCARDIAL_COUNT = value["results"][myocardial_count]['count']
    myocardial_count = myocardial_count + 1

print(f'MYOCARDIAL INFARCTION 건수: {MYOCARDIAL_COUNT}')

# 4. 2번과 3번을 비교하여 (if 조건 else 를 사용) "코로나가 더 많음" vs " 심근경색이 더 많음" 을 출력 하여라
covid_myocardial = "코로나가 더 많음" if (COVID_COUNT > MYOCARDIAL_COUNT) else "심근경색이 더 많음"
print(covid_myocardial)

# 5. NAUSEA(구역질)와 VOMITING(구토)의 보고 건수를 비교하면, 어느 쪽이 더 많으며 차이는 몇 건인가?
nausea_count = 0
vomitting_count = 0
for i in range(len(value["results"])):
    item = value["results"][i]
    if item["term"] == "MYOCARDIAL INFARCTION":
        NAUSEAL_COUNT = value["results"][nausea_count]['count']
    if item["term"] == "MYOCARDIAL INFARCTION":
        VOMITING_COUNT = value["results"][vomitting_count]['count']
    vomitting_count = vomitting_count + 1

if (NAUSEAL_COUNT > VOMITING_COUNT):
    print(f"NAUSEAL가 {(NAUSEAL_COUNT-VOMITING_COUNT)}건 더 많음")
elif (NAUSEAL_COUNT > VOMITING_COUNT):
    print(f"VOMITING가 {(VOMITING_COUNT-NAUSEAL_COUNT)}건 더 많음")

# 6. 메타 정보의 disclaimer(경고문구) 안에 "FDA"라는 단어가 포함되어 있는지 확인하여 출력하라.
line = value["meta"]['disclaimer']
FDA_count = line.count("FDA")
print(f'disclaimer(경고문구) 안에는 FDA 단어가 {FDA_count}번 들어가 있습니다')
```

## 4. 주피터랩 실행단축
- `jupy.sh` 파일 생성
    ```
    echo "주피터랩 서버를 시작합니다."
    source /home/kbw/venv/bin/activate
    jupyter lab
    ```