# 자료형

## 숫자형
### 정수형
```python
# 정수형
a = 123
a = -178
a = 0
```

### 실수형
```python
# 실수형
a = 1.2
a = -3.45   
```

### 제곱 연산자
```python
a = 3
b = 4
print(a ** b)
```

### % 연산자(나머지 연산자)
```python
a = 7
b = 3
print(a % b)
```

### // 연산자(몫 연산자)
```python
a = 7
b = 3
print(a // b)
```

## 문자열
### 문자열 만들기
```python
"Hello World"
'hello world'
"""Life is too short, you need python"""
'''Life is too short, you need python'''
```

### 문자열 연산
```python
head = "Python"
tail = " is fun"
print(head + tail) # Python is fun
```

### 문자열 곱하기
```python
a = "python"
print(a * 3) # pythonpythonpython
```

### 문자열 길이 구하기
```python
a = "Life is too short"
print(len(a)) # 17
```

### 문자열 인덱싱
```python
a = "Life is too short, You need python"
print(a[0]) # L
print(a[12]) # s
print(a[-1]) # n
```

```python
a = "Life is too short, You need python"
print(a[0:4]) # Life
```

### 문자열 나누기
```python
a = "20230331Rainy"
date = a[:8]
weather = a[8:]
print(date) # 20230331
print(weather) # Rainy
```

### 문자열 포매팅
```python
a = "I eat %d apples" % 3
```

```python
a = "I eat %s apples" % "five"
```

```python
number = 3
day = "three"
a = "I eat %d apples, so I was sick for %s days" % (number, day)
```

```python
a = "rate is %s" % 0.05
print(a)
```

### 정렬과 공백
```python
a = "%10s" % "hi"
print(a) #         hi
```

```python
a = "%-10sjane" % "hi"
print(a) # hi        jane
```

### 소수점 표현
```python
a = "%10.4f" % 3.1415926
print(a) #     3.1416
```

### format 함수를 사용한 포매팅
```python
a = "I eat {0} apples".format(3)
print(a) # I eat 3 apples
```

```python
number = 3
day = 5
a = "I eat {0} apples, so I was sick for {1} days".format(number, day)
print(a) # I eat 3 apples, so I was sick for 5 days
```

```python
a = "I eat {number} apples, so I was sick for {day} days".format(number = 10, day = 5)
print(a) # I eat 10 apples, so I was sick for 5 days
```

### 왼쪽 정렬
```python
a = "{0:<10}".format("hi")
print(a)
```

### 오른쪽 정렬
```python
a = "{0:>10}".format("hi")
print(a)
```

### 가운데 정렬
```python
a = "{0:^10}".format("hi")
print(a)
```

### 공백 채우기
```python
a = "{0:=^10}".format("hi")
print(a)
```

### f 문자열 포매팅
```python
name = "홍길동"
age = 30

a  = f"나의 이름은 {name}입니다. 나이는 {age}살입니다"
print(a) # 나의 이름은 홍길동입니다. 나이는 30살입니다
```

```python
d = { 'name':'홍길동', 'age': 30 }

a = f"나의 이름은 {d['name']}입니다. 나이는 {d['age']}살입니다"
print(a) # 나의 이름은 홍길동입니다. 나이는 30살입니다
```

#### 왼쪽 정렬
```python
a = f'{"hi":<10}'
print(a)
```

#### 오른쪽 정렬
```python
a = f'{"hi":>10}'
print(a)
```

#### 가운데 정렬
```python
a = f'{"hi":^10}'
print(a)
```

#### 공백 채우기
```python
a = f'{"hi":=^10}'
print(a) # ====hi====
```

### 문자열 함수
count
```python
a = 'hobby'
result  = a.count('b')

print(result) # 2
```

find
```python
a = 'aaaabbbbccccddddeeeeffff'
result1 = a.find('b')
result2 = a.find('g')

print(result1) # 4
print(result2) # -1
```

index
```python
a = 'aaaabbbbccccddddeeeeffff'
result1 = a.index('b')
# result2 = a.index('g')

print(result1) # 4
# print(result2) # 오류
```

join
```python
a = ",".join('abcd')
print(a) # a,b,c,d
```

upper
```python
a = 'hi'
print(a.upper()) # HI
```

lower
```python
a = 'HI'
print(a.lower()) # hi
```

lstrip, 왼쪽 공백 지우기
```python
a = '  hi  '
print(a.lstrip())
```

rstrip, 오른쪽 공백 지우기
```python
a = '  hi  '
print(a.rstrip())
```

rstrip, 양쪽 공백 지우기	
```python
a = '  hi  '
print(a.strip())
```

replace
```python
a = 'Life is too short, you need python'
result = a.replace("python", "java")

print(result) # Life is too short, you need java
```

split
```python
a = 'Life is too short, you need python'
result1 = a.split()

b = "a:b:c:d"
result2 = b.split(":")

print(result1) # ['Life', 'is', 'too', 'short,', 'you', 'need', 'python']
print(result2) # ['a', 'b', 'c', 'd']
```

## 리스트
리스트 안에는 어떤 자료형도 포함할 수 있다. 
리스트는 값을 수정하거나 삭제할 수 있다

### 리스트 인덱싱
```python
a = [1,2,3,4,5,6,7,8,9]
print(a[0:2]) # [1, 2]
```

### 리스트 연산
```python
a = [1,2,3]
b = [4,5,6]
print(a+b) # [1, 2, 3, 4, 5, 6]
```

### 리스트 반복
```python
a = [1,2,3]
print(a*3) # [1, 2, 3, 1, 2, 3, 1, 2, 3]
```

### 리스트 길이 구하기
```python
a = [1,2,3]
print(len(a)) # 3
```

### 리스트 값 수정
```python
a = [1,2,3]
a[2] = 4

print(a) # [1, 2, 4]
```

### 리스트 값 삭제
```python
a = [1,2,3]
del a[2]

print(a) # [1, 2]
```

### 리스트 요소 추가
```python
a = [1,2,3]
a.append(4)

print(a) # [1, 2, 3, 4]
```

### 리스트 정렬
```python
a = ['a', 'c', 'b']
a.sort()

print(a) # ['a', 'b', 'c']
```

### 리스트 뒤집기
```python
a = ['a', 'c', 'b']
a.reverse()

print(a) # ['b', 'c', 'a']
```

### 리스트 요소 삽입
```python
a = [1,2,3]
a.insert(0, 4)

print(a) # [4, 1, 2, 3]
```

### 인덱스 반환
```python
a = [1,2,3]
result = a.index(3)

print(result) # 2
```

### 리스트 요소 제거
```python
a = [1,2,3,1,2,3]
a.remove(3)

print(a) # [1, 2, 1, 2, 3]
```

### 리스트 요소 끄집어 내기
```python
a = [1,2,3]

print(a.pop()) # 3
print(a) # [1, 2]
```

### 리스트에 포함된 요소 x 개수 세기
```python
a = [1,2,3,1]
result = a.count(1)

print(result) # 2
```

### 리스트 확장
```python
a = [1,2,3]
a.extend([4,5])

b = [6,7]
a.extend(b)

print(a) # [1, 2, 3, 4, 5, 6, 7]
```

## 튜플
튜플의 요소값의 생성, 삭제, 수정을 불가능하다. 
1개의 요소만 가질 때, `,`를 붙여야 한다  
소괄호`()`를 생략해도 된다
```python
t1 = ()
t2 = (1, )
t3 = (1,2,3)
t4 = 1, 2, 3
t5 = ('a', 'b', ('ab', 'cd'))
```

### 튜플 인덱싱
```python
t1 = (1, 2, 'a', 'b')
print(t1[0]) # 1
```

### 튜플 슬라이싱
```python
t1 = (1, 2, 'a', 'b')
print(t1[1:3]) # (2, 'a')
```

### 튜플 더하기
```python
t1 = (1, 2, 'a', 'b')
t2 = (3, 4)
t3 = t1 + t2
print(t3) # (1, 2, 'a', 'b', 3, 4)
```

### 튜플 곱하기
```python
t2 = (3, 4)
t3 = t2 * 3
print(t3) # (3, 4, 3, 4, 3, 4)
```

### 튜플 길이
```python
t1= (1, 2, 'a', 'b')

print(len(t1)) # 4
```

## 딕셔너리
요소는 `key`와 `value` 형태로 이루어져 있고, 쉼표`,`로 구분되어 있다  
Key는 고유한 값이므로 하나를 제외한 나머지 것들이 모두 무시된다  
Key에 리스트는 사용할 수 없다(변경가능하기 때문에 사용 불가)

### 딕셔너리 쌍 추가
```python
a = {1 : 'a'}
a[2] = 'b'
a['name'] = 'pey'

print(a) # {1: 'a', 2: 'b', 'name': 'pey'}
```

### 딕셔너리 요소 삭제
```python
a = {1: 'a', 2: 'b', 'name': 'pey'}
del a[1]

print(a) # {2: 'b', 'name': 'pey'}
```

### 딕셔너리에서 Key를 사용해 Value 얻기
```python
grade = {'pey' : 10, 'julliet' : 99}

print(grade['pey']) # 10
print(grade['julliet']) # 99
```

### 딕셔너리 함수
keys
```python
a = {'name' : 'pey', 'phone' : '010-1234-5678', 'birth' : '1118'}
print(a.keys()) # dict_keys(['name', 'phone', 'birth']) 
print(list(a.keys())) # ['name', 'phone', 'birth']
```

values
```python
a = {'name' : 'pey', 'phone' : '010-1234-5678', 'birth' : '1118'}
print(a.values()) # dict_values(['pey', '010-1234-5678', '1118'])
print(list(a.values())) # ['pey', '010-1234-5678', '1118']
```

items
```python
a = {'name' : 'pey', 'phone' : '010-1234-5678', 'birth' : '1118'}
print(a.items()) # dict_items([('name', 'pey'), ('phone', '010-1234-5678'), ('birth', '1118')])
print(list(a.items())) # [('name', 'pey'), ('phone', '010-1234-5678'), ('birth', '1118')]
```

clear
```python
a = {'name' : 'pey', 'phone' : '010-1234-5678', 'birth' : '1118'}
a.clear()
print(a) # {}
```

get
```python
a = {'name' : 'pey', 'phone' : '010-1234-5678', 'birth' : '1118'}

print(a.get('name')) # pey
print(a.get('abcd')) # None
```

in
```python
a = {'name' : 'pey', 'phone' : '010-1234-5678', 'birth' : '1118'}

result1 = 'name' in a
result2 = 'email' in a
print(result1) # True
print(result2) # False
```

## 집합 자료형
중복을 허락하지 않는다  
순서가 없다  

```python
s1 = set([1,2,3])
print(s1) # {1, 2, 3}

s2 = set("Hello")
print(s2) # {'l', 'H', 'e', 'o'}
```

### 교집합
```python
s1 = set([1,2,3,4,5,6])
s2 = set([4,5,6,7,8,9])

print(s1 & s2) # {4, 5, 6}
print(s1.intersection(s2)) # {4, 5, 6}
```

### 합집합
```python
s1 = set([1,2,3,4,5,6])
s2 = set([4,5,6,7,8,9])

print(s1 | s2) # {1, 2, 3, 4, 5, 6, 7, 8, 9}
print(s1.union(s2)) # {1, 2, 3, 4, 5, 6, 7, 8, 9}
```

### 차집합
```python
s1 = set([1,2,3,4,5,6])
s2 = set([4,5,6,7,8,9])

print(s1 - s2) # {1, 2, 3}
print(s1.difference(s2)) # {1, 2, 3}
```

### 집합 자료형 관련 함수
add: 한 개의 값만 추가
```python
s1 = set([1,2,3])
s1.add(4)

print(s1) # {1, 2, 3, 4}
```

update: 값 여러 개 추가
```python
s1 = set([1,2,3])
s1.update([4,5,6])

print(s1) # {1, 2, 3, 4, 5, 6}
```

remove
```python
s1 = set([1,2,3])
s1.remove(2)

print(s1) # {1, 3}
```

## 불 자료형
True와 False를 나타내는 자료형  
```python
a = True
b = False

print(type(a)) # <class 'bool'>
print(type(b)) # <class 'bool'>
```

### 자료형의 True와 False
문자열`""`, 리스트`[]`, 튜플`()`, 딕셔너리`{}` 등의 값이 비어있으면 Flase, 있으면 True  
```python
if [1,2,3]:
    print("True")
else:
    print("False")
# True
```

```python
if []:
    print("True")
else:
    print("False")
# False
```

```python
a = [1,2,3,4]
while a:
    print(a.pop())
```

