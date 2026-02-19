# 함수
같은 내용을 반복하는 경우 사용  
프로그램을 기능 단위로 분리하여 사용  
함수의 리턴 값은 항상 하나
```python
def add(a, b):
    return a+b
```

## 입력값이 없는 함수
```python
def say():
    return 'Hi'
```

## 입력값과 리턴값이 없는 함수
```python
def say():
    print('Hi')
```

## 매개변수 지정하여 호출
```python
def sub(a, b):
    return a - b
```

## 입력값이 여러 개인 경우
`*`을 붙여 입력값을 튜플로 만들어준다
```python
def add_many(*args):
    result = 0
    for i in args:
        result += i
    return result
```

## 키워드 매개변수
`**`을 붙여 딕셔너리 형태로 저장된다
```python
def print_kwargs(**kwargs):
    print(kwargs)
```

## return 의 다른 사용
특별한 상황에서 함수를 빠져나가고 싶을때 return을 단독으로 사용해 빠져나갈 수 있다

## 매개변수 초기값 미리 설정
초기화하고 싶은 매개변수는 항상 뒤쪽에 놓아야 한다
```python
def say_myself(name, age, man=True):
    print("%s" % name)
    print("%s" % age)
    if man:
        print("남자")
    else:
        print("여자")
```

```python
say_myself("홍길동", 30)
say_myself("홍길동", 30, True)
say_myself("홍길동", 30, False)
```

## global 명령어
함수 안에서의 변수를 사용하고 싶은 경우 `global` 명령어를 사용  
하지만 `global` 명령어는 사용하지 않는걸 추천  
함수는 독립적으로 존재하는 것이 좋기 때문
```python
a = 1
def vartest():
    global a 
    a += 1

vartest()
print(a) # 2
```

## lambda
def와 동일한 역할 수행  
함수를 간결하게 만들 때 사용
```python
add =  lambda a, b : a + b
result = add(3, 4)
print(result) # 7
```