# 9주차
## 2026-03-30(37일차)
?

## 2026-03-31(38일차)
### html에서 css, js 나누기
js: defer: html에서 body 위에 있을 경우

### 로그인 화면

## 2026-04-01(39일차)
### nodejs로 서버 띄우기
`npm install express --save`

```js
const { createServer } = require("http");
const port = 3000;

const server = createServer((req, res) => {
  res.end(`
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>하이퍼링크</title>
    </head>
    <body>
        <h1>하이퍼링크</h1>
        <a href="#">홈으로</a>
        <hr />
        <a href="https://naver.com">네이버</a>
        <br />
        <a href="https://daum.net">다음</a>
    </body>
</html>
`);
});

server.listen(port, () => {
  console.log("서버가 동작하였습니다.");
});
```

```js
const express = require("express");
const app = express();
const port = 3366;

app.get("/", (req, res) => {
  res.send(`<h1>Hello World!</h1><a href="/hi">인사로 가기</a>`);
});

app.get("/hi", (req, res) => {
  res.send("hihihihi");
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
```

## 2026-04-02(40일차)
### nodejs로 서버

### Axios 시간되면 해보라고 함

### 퀴즈 마지막 시간

## 2026-04-03(41일차)
### java-springboot 시작
### visual studio code insiders 설치
- 비주얼 스튜디오 2개 사용

### Java 시작