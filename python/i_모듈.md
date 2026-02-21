# 모듈
함수나 변수 또는 클래스를 모아 놓은 파이썬 파일  

```python
# mod1.py
def add(a, b):
    return a+b

def sub(a, b):
    return a-b
```

`import`로 파이썬 모듈을 사용할 수 있게 해준다
```python
import mod1
print(mod1.add(3,4)) # 7
print(mod1.sub(3,4)) # -1
```

함수를 직접 `import`
```python
from mod1 import add, sub
print(add(3,4)) # 7
print(sub(3,4)) # -1
```

모든 함수 호출
```python
from mod1 import *
print(add(3,4)) # 7
print(sub(3,4)) # -1
```

## `if __name__`과 `__main__`
```python
# hello.py
def hello(name):
    return f'Hello~ {name}'

print(hello('batman'))
```

```python
# index.py
import hello

print(hello.hello('superman'))
# Hello~ batman
# Hello~ superman
```
- hello.py의 batman 까지 출력이 되었다

```python
# hello.py
def hello(name):
    return f'Hello~ {name}'

if __name__ == "__main__":
    print(hello('batman'))
```

```python
# index.py
import hello

print(hello.hello('superman'))
# Hello~ superman
```
- superman만 실행되었다

이유를 보면
```python
# hello.py
def hello(name):
    return f'Hello~ {name}'

if __name__ == "__main__":
    print(hello('batman'))

print(__name__) # __main__
# Hello~ batman
```
즉, 자기 자신을 실행시키면 `__main__`이 나온다  
그런데
```python
# index.py
import hello

print(hello.hello('superman'))

print(hello.__name__) # hello
```
index.py에서 hello.py의 `__name__`은 hello 이기 때문에 조건에 맞지 않아 실행이 되지 않는다