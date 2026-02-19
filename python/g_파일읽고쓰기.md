# 파일 읽고 쓰기
- r: 읽기 모드
- w: 쓰기 모드
- a: 추가 모드

```python
f = open("새파일.txt" 'w')
f.close()
```

## 파일 읽는 방법
`readline` 함수
- 파일을 한 줄씩 읽어 들인다

`readlines` 함수
- 파일의 모든 줄을 읽어서 각각의 줄을 요소로 가지는 리스트를 return

`read` 함수
- 파일의 내용 전체를 문자열로 return

## with 문과 함께 사용
`close()`를 사용하여 파일을 닫을 필요 없이 `with 문`을 사용하면 된다