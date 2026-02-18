# 제어문
## if 문
조건 판단 후 상황에 맞는 상황을 수행하기 위해 사용  
조건문 다음 `:`
```python
money = 2000
if money >= 3000:
    print("택시")
else:
    print("버스")
# 버스
```

## 다양한 조건을 판단하는 elif

## 조건문
`참`과 `거짓`을 판단하는 문장

### 조건을 판단하기 위한 연산자
`and`  
`or`  
`not`

### 파이썬의 특별한 조건문
`in`  
`not in`  
리스트나 튜플에서 사용할 수 있다  

### 조건문에서 넘어가고 싶을 경우
`pass`

### 조건부 표현식
```python
if score >= 60:
    message = "success"
else:
    message = "faliure"
```

```python
message = "success" if score >= 60 else "faliure"
```
## 반복문
### while 문
조건문이 True인 동안 while문에 속한 문장들이 반복해서 수행된다

### while 문 강제로 빠져나가기
`break`

### while 문의 맨 처음으로 돌아가기
`continue`

## for 문
