# 예외 처리

## try-except 문
```python
try:
    4/0
except ZeroDivisionError as e:
    print(e) # division by zero
```

## try-finally 문
finally 절은 try 수행 도중 예외 발생 여부에 상관없이 항상 수행된다  
```python
try:
    f = open('foo.txt', 'w')

finally:
    f.close()
```

## 여러 개의 오류 처리
```python
try:
    a = [1,2]
    print(a[3])
    4/0
except ZeroDivisionError:
    print("0으로 나눌 수 없다")
except IndexError:
    print("인덱싱 할 수 없다")
```

```python
try:
    a = [1,2]
    print(a[3])
    4/0
except ZeroDivisionError as e:
    print(e)
except IndexError as e:
    print(e)
```

```python
try:
    a = [1,2]
    print(a[3])
    4/0
except (ZeroDivisionError, IndexError) as e:
    print(e)
```

## try-else 문
오류가 발생하지 않으면 else 문을 수행한다  
```python
try:
    age = int(input("나이 입력: "))
except:
    print("입력이 정확하지 않습니다")
else:
    if age <= 18:
        print("미성년자는 출입금지")
    else:
        print("환영합니다")
```

## 오류 통과
`pass`를 사용하여 오류 회피
```python
try:
    f = open("없는파일", 'r')
except FileNotFoundError:
    pass
```

## 의도한 오류 발생
`raise`를 사용하여 오류 강제 발생
```python
class Bird:
    def fly(self):
        raise NotImplementedError
```

```python 
class Eagle(Bird):
    pass

eagle = Eagle()
eagle.fly()
```
- Bird를 상속받는 자식 클래스 Eagle는 fly 함수를 오버라이딩하여 강제로 구현해야한다  
구현하지 않는 경우 NotImplementedError 에러가 발생한다

fly 함수 구현
```python
class Eagle(Bird):
    def fly(self):
        print('very fast')

eagle = Eagle()
eagle.fly()
```

## 예외 만들기
```python
class MyError(Exception):
    pass
```

```python
class say_nick(nick):
    if nick == "바보":
        raise MyError()
    print(nick)
```

```python
say_nick("천사")
say_nick("바보") # 에러 발생
```

예외 처리 기법 사용
```python
try:
    say_nick("천사")
    say_nick("바보")
except MyError:
    print("허용되지 않는 별명")
# 천사
# 허용되지 않는 별명
```

오류 메시지 활용 -> 하지만 MyError을 바꿔줘야 한다
```python
try:
    say_nick("천사")
    say_nick("바보")
except MyError as e:
    print(e)
```

```python
class MyError(Exception):
    def __str__(slef):
        return "허용되지 않은 별명"
```