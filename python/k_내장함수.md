# 내장함수
## abs
절대값 리턴

## all
반복 가능한 요소들 중 모두 참이면 True, 아니면 False 리턴

## any
반복 가능한 요소들 중 하나라도 참이 있으면 True, 모두 거짓일 때 False

## chr
유니코드 숫자 값을 입력받아, 문자 리턴
```python
print(chr(97)) # a
```

## ord
문자의 유니코드 숫자 값을 리턴
```python
print(ord('a')) # 97
```

## dir
객체가 지닌 변수나 함수를 보여준다

## divmod
인자 2개를 입력받아, 몫과 나머지를 튜플로 리턴

## enumerate
순서가 있는 데이터(리스트, 튜플, 문자열)를 입력받아 인덱스 값을 포함하는 객체를 리턴
```python
for i, name in enumerate(['body', 'foo', 'bar']):
    print(i, name)
```

## eval
문자열로 구성된 표현식을 입력받아, 문자열을 실행한 결과값으로 리턴
```python
print(eval('1 + 2')) # 3
```

## filter
반복 가능한 데이터를 받고, 요소 순서대로 함수를 호출할때 리턴값이 True인 것만 묶어 리턴  
1번째 인자: 함수  
2번째 인자: 반복 가능한 데이터
```python
def positive(x):
    return x > 0

print(list(filter(positive, [1,2,3,-1,-4,-5])))
```

## hex
정수를 입력받아 16진수로 변환하여 리턴

## id
객체를 입력받아 고유 주소값을 리턴

## input
사용자 입력을 받는 함수

## int
문자열 형태의 숫자, 소수점이 있는 숫자를 정수로 리턴  
10진수로 표현
```python
print(int('11', 2)) # 2진수로 표현된 11을 10진수 2로 변환
print(int('1A', 16)) # 16진수로 표현된 11을 10진수 26으로 변환
```

## isinstance
1번째 인수: 객체  
2번쨰 인수: 클래스
객체가 클래스의 인스턴스인지 판단하여 리턴
```python
class Person:
    pass

a = Person()
print(isinstance(a, Person)) # True
```

## len
요소의 전체 개수를 리턴

## list
반복 가능한 데이터를 입력받아 리스트로 리턴

## map
1번째 인수: 함수
2번째 인수: 반복 가능한 데이터
```python
def two_times(x):
    return x * 2

print(list(map(two_times, [1,2,3,4]))) # [2, 4, 6, 8]
```

## max
반복 가능한 데이터를 입력받아 최댓값을 리턴
```python
print(max([1,2,3])) # 3 
print(max("abcdzefg")) # z
```

## min
반복 가능한 데이터를 입력받아 최솟값을 리턴
```python
print(min([1,2,3])) # 1
print(min("bcdaefg")) # a
```

## oct
정수를 8진수 문자열로 바꾸어 리턴

## oepn
'파일 이름'과 '읽기 방법'을 입력받아 파일 객체를 리턴

## pow
제곱한 결괏값을 리턴

## range
숫자에 해당하는 범위 값을 반복 가능한 객체로 리턴
```python
print(list(range(5))) # [0, 1, 2, 3, 4]
print(list(range(5, 10))) # [5, 6, 7, 8, 9]
print(list(range(1, 10, 2))) # [1, 3, 5, 7, 9]s
```

## round
숫자를 입력받아 반올림하여 리턴
```python
print(round(9.87654)) # 10
print(round(9.87654, 2)) # 9.88
```

## sorted
입력 데이터를 정렬한 후, 결과를 리스트로 리턴
```python
print(sorted([6,2,3,1])) # [1, 2, 3, 6]s
```

## str
문자열 형태로 객체를 변환하여 리턴

## sum
입력 데이터의 합을 리턴

## tuple
반복 가능한 데이터를 튜플로 바꾸어 리턴
```python
print(tuple("abc")) # ('a', 'b', 'c')
print(tuple([1,2,3])) # (1, 2, 3)
```

## type
입력값의 자료형이 무엇인지 알려주는 함수

## zip
동일한 개수로 이루어진 데이터들을 묶어서 리턴
```python
a = list(zip([1,2,3], [4,5,6]))
b = list(zip([1,2,3], [4,5,6], [7,8,9]))
c = list(zip("abc", "def", "hij"))

print(a) # [(1, 4), (2, 5), (3, 6)]
print(b) # [(1, 4, 7), (2, 5, 8), (3, 6, 9)]
print(c) # [('a', 'd', 'h'), ('b', 'e', 'i'), ('c', 'f', 'j')]
```