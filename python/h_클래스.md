# 클래스
똑같은 무언가를 계속 만들어 낼 수있는 설계도면

## 객체
클래스로 만든 것  
동일한 클래스로 만든 객체는 서로 영향을 주지않는다

## self
파이썬 메서드의 첫 매개변수 이름은 `self`를 사용  
클래스 명으로 매서드를 호출할 경우 객체를 매개변수에 전달해야 한다
```python
a = FourCal()
FourCal.setdata(a, 4, 2)
```

`객체.메서드` 형태인 경우 self를 생략하여 호출 해야한다
```python
a = FourCal()
a.setdata(4, 2)
```

## 생성자
객체가 생성될 때 자동으로 호출되는 메서드  
`__init__`을 사용하면 메서드는 생성자가 된다
```python
def __init__(self, first, second):
    self.first = first
    self.second = second
```
- 메서드 이름을 `__init__` 으로 했기 때문에 생성자로 인식되어, 객체가 생성되는 시점에 자동으로 호출된다

## 클래스의 상속
클래스를 만들 때 다른 클래스의 기능을 물려받을 수 있게 만드는 것  
클래스 이름 뒤 괄호 안에 상속할 클래스의 이름을 넣어야 한다  
```python
class MoreFourCal(FourCal):
    pass
```
- MoreFourCal 클래스는 FourCal 클래스를 상속하였다

## 메서드 오버라이딩
부모 클래스에 있는 메서드를 동일한 이름으로 다시 만드는 것  
부모 클래스의 메서드 대신 오버라이딩한 메서드가 호출된다

## 클래스 변수
```python
class Family:
    lastname = "김"
```
에서 `Family.lastname`이 클래스 변수
```python
a = Family()
b = Family()
print(a.lastname) # 김
print(b.lastname) # 김

Family.lastname = "박"

print(a.lastname) # 박
print(b.lastname) # 박
```
- 클래스 변수는 객체 변수와 달리 클래스로 만든 모든 객체에 공유된다