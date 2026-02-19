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
