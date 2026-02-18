# 변수
자료형의 값을 저장하는 공간  
파이썬은 자료형의 타입을 직접 지정하지 않아도 된다  
변수는 객체를 가리키는 것  

## 메모리 주소 확인
id
```python
a = [1,2,3]
print(id(a)) # 4353446144
```

## 리스트의 복사
```python
a = [1,2,3]
b = a

print(id(a)) # 4368748800
print(id(b)) # 4368748800
```

is
```python
a = [1,2,3]
b = a

print(a is b) # True
```

주소 값 동일 비교
```python
a = [1,2,3]
b = a

a[1] = 4

print(a) # [1, 4, 3]
print(b) # [1, 4, 3]
```

기존 값을 가져오면서 다른 주소 가리키기  
1. `[:]`
```python
a = [1,2,3]
b = a[:]

a[1] = 4

print(a) # [1, 4, 3]
print(b) # [1, 2, 3]
```

2. copy 모듈
```python
from copy import copy

a = [1,2,3]
b = copy(a)

a[1] = 4

print(a) # [1, 4, 3]
print(b) # [1, 2, 3]
```