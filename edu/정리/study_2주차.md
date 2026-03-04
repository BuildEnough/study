# 2주차
# 2026-02-09(6일차)
[변수](#1-변수)  
[제어문](#2-제어문)  
[그 외](#3-그-외)  

## 1. 변수
1. 영문자, 숫자, 언더스코어(_)만 사용할 수 있다.
2. 숫자로 시작할 수 없다.
3. 예약어는 사용할 수 없다.
4. 대소문자를 구분한다.
```python
# snake_case(단어 사이에 언더스코어)를 권장

# 올바른 변수명 예시
name = "홍길동"
age = 25
user_name = "gildong"
userName = "gildong"  # 카멜 케이스
_private = "비공개"
count1 = 10

# 잘못된 변수명 예시
# 1name = "홍길동"    # 숫자로 시작 (오류)
# user-name = "홍길동"  # 하이픈 사용 (오류)
# if = 10             # 예약어 사용 (오류)
```
- 참조
```python
e = [11, 22, 33]
ee = e
ee[2] = 77
print(ee is e, ee, e) # True [11, 22, 77] [11, 22, 77]
```
- 복사
```python
e = [11, 22, 33]
ee = e[:]
ee[2] = 77
print(ee is e, ee, e) # False [11, 22, 77] [11, 22, 33]
```
- copy() 함수를 사용한 복사
```python
e = [11, 22, 33]
ee = e.copy()
ee[2] = 77
print(ee is e, ee, e) # False [11, 22, 77] [11, 22, 33]
```

- 두 변수의 값을 바꿀 때
```python
a = 33
b = 55
print(a, b)

a, b = b, a
print(a, b)
```

## 2. 제어문
조건문에 속하는 모든 문장에 들여쓰기를 해야함 
### if 문

### in, not in

### while 문

- 로또 생성
```python
# 로또 생성
import random

nums = set()

while len(nums) < 6:
    nums.add(random.randint(1, 45))

lotto = sorted(nums)
print(lotto)
```

## 3. 그 외
### RAG(검색 증강 생성, Retrieval-Augmented Generation)
대규모 언어 모델(LLM)이 답변을 생성하기 전, 외부 지식 베이스(사내 문서, DB 등)에서 관련 정보를 검색하여 참고하게 함으로써 정확도와 최신성을 높이는 기술


# 2026-02-10(7일차)
[조건문](#1-조건문)  
[tqdm](#2-tqdm)  
[그 외](#3-그외)  

## 1. 제어문
- if 문
- while 문
- for 문
- `pass`
- `continue`
- `range`
    ```python
    #for, range를 사용하여 다음 요소가 담긴 리스트 생성
    # 1. [3,4,5,6,7,8,9,10,11]
    list1 = []
    for i in range(3, 12):
        list1.append(i)
    print(list1)


    # 2. [1,4,7,10,13] 이 담긴 리스트 생성
    list2 = []
    for i in range(1, 14, 3):
        list2.append(i)
    print(list2)

    # 3. 0~50까지 짝수값 리스트 생성'''
    list3 = []
    for i in range(1, 51):
        if (i%2==0):
            list3.append(i)
    print(list3)

    # 4. 1부터 10까지 모두 더한 값
    add_num = 0
    for i in range(11):
        add_num += i
    print(add_num)

    # 구구단
    for i in range(1,10):
        for j in range(1, 10):
            print(f"{i}x{j}={i*j}") 
        print('') 
    ```

- 리스트 컴프리헨션
    ```python
    a = [int(((r*3)/2)*1.5) for r in range(0, 100)]

    b = [i for i in a if i % 2 == 0]
    c = [i for i in a if i % 2 != 0]

    print(b)
    print(c)
    ```

- for-else 문
- enumerate
    ```python
    arr = [11,22,33,44,55]
    for i, a in enumerate(arr):
        print(f"{i}: {a}")

    # 0: 11
    # 1: 22
    # 2: 33
    # 3: 44
    # 4: 55
    ```

## 2. tqdm
- tqdm 설치
```python
!pip install tqdm
```

```python
# 테스트 타이머, 하드코딩으로 프로레스 시각화
import time as tt
for x in range(11):
    print(f"{('■')*x:□<10} {x*10}%", end="\r")
    tt.sleep(1)
```

- tqdm으로 프로레스 시각화
```python
# tqdm으로 프로레스 시각화
from tqdm import tqdm
import time as tt
for x in tqdm(range(100)):
    a = 1
    tt.sleep(0.1)
```

## 3. 그외
```python
# 달력
import calendar

c = calendar.TextCalendar(calendar.SUNDAY)
print(c.formatmonth(2026,2))
```

```python
# 테스트 타이머
import time as tt
for x in range(11):
    print(f"{('■')*x:□<10} {x*10}%", end="\r")
    tt.sleep(1)
```


# 2026-02-11(8일차)
[제어문](#1-제어문)  
[함수](#2-함수)  
[matplotlib](#3-matplotlib)  

## 1. 제어문
- 구구단
    ```python
    # 구구단
    for p in [f"{y} x {x} = {y*x}" for y in range(1, 10) for x in range(1, 10)]: print(p)
    ```
- 큰 값, 작은 값
    ```python
    # 큰 수, 작은 수
    arr = [11,33,77,2,4,6]
    max_num = arr[0]
    min_num = arr[0]

    for i in arr:
        if max_num < i:
            max_num = i
        elif min_num > i:
            min_num = i
            
    print(max_num)
    print(min_num)
    ```
- 주사위 확률 조작
    - 3확률을 2배로: 숫자 7이 나올 경우 7 -> 3으로 대체
    ```python
    import random as ran
    import matplotlib.pyplot as plt
    box = []
    n = 0
    cc = 10000
    values = []
    choice = int(input("조작할 확률 %를 입력하세요.") or 10)
    my = int(input("조작할 번호를 입력하세요.") or 3)

    while n < cc:
        num = ran.randint(1,6)
        lucky = ran.randint(1,100)
        if choice >= lucky:
            box.append(my)

        else:
            box.append(num)
        n += 1

    if cc == len(box):
        print(f"{cc}회 정상 진행 되었습니다.")
        for n in range(1,7):
            print(f"주사위 눈금 {n}이 {box.count(n)}번 { ((box.count(n)/cc) * 100):0.2f}% 출현하였습니다.")
            values.append(box.count(n))

    else:
        print(f"검증 결과 이상이 있습니다. {cc}회 목표로 동작하였으나, {len(box)}으로 측정되었습니다. ")

    color = ["skyblue","orange","skyblue","orange","skyblue","orange"]
    plt.bar(range(1,7), values , color=color)
    plt.show()
    ```


## 2. 함수
```python
# 매개변수
def add(a, b):
    return a+b

add(15, 20) * 10 # 350
```

- return 특징
    - return 값은 항상 하나
        ```python
        def add_and_mul1(a,b):
            return [a+b, a*b]

        value1  = add_and_mul1(3,5)
        print(value1, type(value1)) # [8, 15] <class 'list'>

        def add_and_mul2(a,b):
            return {a+b, a*b} # {8, 15} <class 'set'>

        value2  = add_and_mul2(3,5)
        print(value2, type(value2))

        def add_and_mul3(a,b):
            return a+b, a*b

        value3  = add_and_mul3(3,5)
        print(value3, type(value3)) # (8, 15) <class 'tuple'>
        ```
    - `__doc__`
        ```python
        # return의 특징, 함수 종료
        def return_test():
            '''
            테스트
            '''
            print("리턴 전 입니다")
            return
            print("리턴 후 입니다")
            
        return_test()
        print(return_test.__doc__)
        ```
        ```python
        print.__doc__
        ```
- 매개변수 여러개 `*`
    ```python
    def add_many(*args):
        result = 0
        for i in args:
            result += i
        return result
    ```
- 키워드 매개변수, `kwargs`
    - 함수 호출 시 `키워드=값` 형태로 전달하는 매개변수를 받을 때 사용
    - 키워드 매개변수를 사용할 때는 매개변수 앞에 `별 2개(**)`를 붙임
    ```python
    def print_test(*args):
        print(args, type(args))
    print_test(1,2,3,4,5) # (1, 2, 3, 4, 5) <class 'tuple'>
    ```
    ```python
    def print_kwargs(**kwargs):
        print(kwargs, type(kwargs))
    print_kwargs(name='foo', arg=3) # {'name': 'foo', 'arg': 3} <class 'dict'>
    ```

-  매개변수의 초기화는 항상 마지막에 둬야 함, 아니면 밑에 처럼 오류 발생
    ```python
    def say_myself(name, man=True, age): 
        print("나의 이름은 %s 입니다." % name) 
        print("나이는 %d살입니다." % age) 
        if man: 
            print("남자입니다.") 
        else: 
            print("여자입니다.")
    ```

- 함수 안에서 사용하는 매개변수는 함수 밖의 변수 이름과는 전혀 상관없다
    ```python
    a = 1
    def vartest(a):
        a += 10
    vartest(a)
    print(a)
    ```

- lambda
    ```python
    # json  파싱하여 lambda로 데이터 키를 설정하여 정렬하기
    import requests as req
    url = "https://jsonplaceholder.typicode.com/todos"

    result = req.get(url).json()
    print(result[:10])
    fin = sorted(result, key=lambda x:x['id'], reverse=True)
    print(fin)
    ```

    ```python
    # json  파싱하여 lambda로 데이터 키를 설정하여 정렬하기
    import requests as req
    import random as ran

    url = "https://jsonplaceholder.typicode.com/todos"

    result = req.get(url).json()

    print("1. id의 번호를 기분으로 내림차순으로 정렬")
    fin = sorted(result, key=lambda x:x['id'], reverse=True)
    # print(fin)
    print("="*50)

    print("2. compledted가 True가 된 내용만 전처리하라")
    answer2 = [x for x in result if x["completed"] == True]
    # print(answer2)
    print("="*50)

    print("3. 리스트의 각 요소 끝에 score 이름으로 키를 만들고, 그 키의 값을 40~100까지의 값을 임으로 배정하여 fix라는 변수에 등록")
    fix = [dict(x, score=ran.randint(40, 100)) for x in result]
    # print(fix)
    print("="*50)

    print("4. score를 키로 내림차순으로 sort, (원본손상 X)")
    answer4 = sorted(fix, key=lambda x: x["score"], reverse=True)
    print(fix[:10])
    print("="*50)
    print(answer4[:10])
    ```

## 3. matplotlib
- 데이터 시각화
- matplotlib 설치
    ```python
    !pip install matplotlib
    ```

# 2026-02-12(9일차)
[Git](#1-git)  
[명령어](#2-명령어)  
[파일 읽고 쓰기](#3-파일-읽고-쓰기)   

## 1. Git
- git 설치
- github
- git
    ```bash
    cat <<'end'>> .gitignore
    > .gitignore
    > end

    cat .gitignore

    git init

    git status

    git add .

    git add -A

    git commit -m "첫 커밋"

    git config --global user.email "you@example.com"
    git config --global user.name "Your Name"

    git config -l

    git branch -M main

    git remote add origin 주소

    git remote -

    git push -u origin main

    git fetch

    git pull
    ```
창 분리: `ALT` + `SHIFT` + `+`

## 2. 명령어
```bash
mv 이름.확장자 
```

## 3. 파일 읽고 쓰기
```python
f = open("새파일이에요.txt", 'w')

for i in range(0, 20, 2):
    f.write(str(i) + "\n")

f.close()
```

```python
# 파이썬의 파일 쓰기 기능을 이용
''' 
파일 쓰기 기능을 이용하여
로또 번호 중복없는 6개의 번호로 차례로 구성된
결과를 10가지로 추천하여
"로또추천.txt" 라는 문서로 남기라.
'''
import random

f = open("로또추천.txt", 'w')

result = ""

for _ in range(10):
    nums = set()
    while len(nums) < 6:
        nums.add(random.randint(1, 45))

    lotto = sorted(nums)
    result += str(lotto) + "\n"
f.write(result)
f.close()
```
- readline 함수
- readlines 함수
- read 함수


# 2026-02-13(10일차)
[Git](#1-git)  
[함수 스코프 vs 블록 스코프](#2-함수-스코프-vs-블록-스코프)  
[프로그램의 입출력](#3-프로그램의-입출력)  
[주피터 랩](#4-주피터-랩)  
[클래스](#5-클래스)  



## 1. Git
`git log`  
`git log --oneline`  
`git checkout branch-name`  
`git switch branch-name`  
`git switch -c 해쉬값`

## 2. 함수 스코프 vs 블록 스코프
- 함수 안에서 선언된 변수는 함수 밖에서 접근할 수 없다
    ```python
    def my_function():
        func_var = "함수 안의 변수"

    my_function()
    # print(func_var)  # 오류! 함수 밖에서는 접근 불가
    ```
- if, for, while, with 등의 블록들 안에서 선언된 변수는 블록 밖에서도 접근할 수 있다
    ```python
    for x in range(3):
        print(x)
    print(x) # 2
    ```

## 3. 프로그램의 입출력
```python
# 대문자 변환 프로그램
import sys
args = sys.argv[1:] # 처음은 자기자신이 나와서 다음꺼부터
for i in args:
    print(i.upper(), end =" ")
```

## 4. 주피터 랩
```python
%%sh
파이썬말고 쉘 명령어 실행가능
```

## 5. 클래스