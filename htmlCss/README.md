# HTML / CSS 공부 정리

## HTML 정리

---

## 1. 제목 / 문단 태그

### h1 ~ h6
제목을 나타내는 태그  
숫자가 작을수록 더 큰 제목
```html
<h1>큰 제목</h1>
<h2>중간 제목</h2>
<h3>작은 제목</h3>
```

### p
문단을 만들 때 사용
```html
<p>문단 내용입니다.</p>
```

### br
줄바꿈할 때 사용  
닫는 태그는 없다
```html
안녕하세요.<br>
반갑습니다.
```

---

## 2. 인용 관련 태그

### blockquote
긴 인용문을 나타낼 때 사용
```html
<blockquote>
  인용할 문장입니다.
</blockquote>
```

### q
짧은 인용문을 나타낼 때 사용
```html
<p>그는 <q>열심히 하자</q>라고 말했다.</p>
```

---

## 3. 글자 의미 태그

### strong
중요한 내용을 표시할 때 사용  
화면에서는 보통 굵게 나온다
```html
<strong>중요한 내용</strong>
```

### em
강조하고 싶은 내용을 표시할 때 사용  
화면에서는 보통 기울임으로 나온다
```html
<em>강조할 내용</em>
```

### ins
추가된 내용을 표시할 때 사용
```html
<ins>추가된 내용</ins>
```

### del
삭제된 내용을 표시할 때 사용
```html
<del>삭제된 내용</del>
```

### sub
아래 첨자를 표시할 때 사용
```html
H<sub>2</sub>O
```

### sup
위 첨자를 표시할 때 사용
```html
2<sup>3</sup>
```

---

## 4. 영역 태그

### div
블록 단위로 영역을 묶을 때 사용  
화면 구조를 나눌 때 많이 사용
```html
<div>
  <h2>제목</h2>
  <p>내용</p>
</div>
```

### span
문장 안에서 일부분만 묶을 때 사용
```html
<p>이 부분은 <span>span 영역</span>입니다.</p>
```

---

## 5. 목록 태그

### ul
순서가 없는 목록을 만들 때 사용
```html
<ul>
  <li>HTML</li>
  <li>CSS</li>
</ul>
```

### ol
순서가 있는 목록을 만들 때 사용
```html
<ol>
  <li>첫 번째</li>
  <li>두 번째</li>
</ol>
```

### li
목록 안의 항목을 나타낼 때 사용
```html
<ul>
  <li>목록 항목</li>
</ul>
```

### dl
설명 목록 전체를 만들 때 사용
```html
<dl>
  <dt>HTML</dt>
  <dd>웹 페이지 구조를 만드는 언어</dd>
</dl>
```

### dt
설명할 단어를 나타낼 때 사용
```html
<dt>HTML</dt>
```

### dd
단어에 대한 설명을 나타낼 때 사용
```html
<dd>웹 페이지 구조를 만드는 언어</dd>
```

---

## 6. 링크 / 이미지 태그

### a
링크를 만들 때 사용
```html
<a href="https://www.google.com">구글</a>
```

### href
이동할 주소를 지정할 때 사용  
a 태그에서 사용
```html
<a href="https://www.google.com">구글</a>
```

### target
링크를 어디에서 열지 지정할 때 사용  
`_blank`는 새 탭으로 열기
```html
<a href="https://www.google.com" target="_blank">구글</a>
```

### title
마우스를 올렸을 때 설명을 보여줄 때 사용
```html
<a href="https://www.google.com" title="구글 사이트">구글</a>
```

### img
이미지를 넣을 때 사용  
닫는 태그는 없다
```html
<img src="image.jpg" alt="이미지 설명">
```

### src
이미지 파일 경로를 지정할 때 사용  
img 태그에서 사용
```html
<img src="image.jpg" alt="이미지 설명">
```

### alt
이미지 설명을 작성할 때 사용  
이미지가 안 보일 때도 표시된다
```html
<img src="image.jpg" alt="강아지 사진">
```

---

## 7. form 관련 태그

### form
사용자가 입력한 값을 서버로 보낼 때 사용하는 영역
```html
<form>
  <input type="text" name="username">
  <button type="submit">전송</button>
</form>
```

### input
사용자에게 값을 입력받을 때 사용
```html
<input type="text" name="loginId">
```

### type
input의 입력 방식을 정할 때 사용
```html
<input type="text">
<input type="password">
<input type="checkbox">
```

### name
서버로 값을 보낼 때 사용하는 이름
```html
<input type="text" name="loginId">
```

### value
입력값이나 기본값을 지정할 때 사용
```html
<input type="text" name="loginId" value="test">
```

### placeholder
입력 전에 안내 문구를 보여줄 때 사용
```html
<input type="text" placeholder="아이디 입력">
```

### readonly
읽기 전용으로 만들 때 사용  
값은 서버로 전송될 수 있다
```html
<input type="text" value="수정 불가" readonly>
```

### disabled
비활성화할 때 사용  
값은 보통 서버로 전송되지 않는다
```html
<input type="text" value="사용 불가" disabled>
```

### maxlength
입력 가능한 최대 글자 수를 정할 때 사용
```html
<input type="text" maxlength="20">
```

### checked
체크박스나 라디오 버튼을 기본 선택할 때 사용
```html
<input type="checkbox" checked> 동의
```

### label
input에 이름표를 붙일 때 사용
```html
<label for="userId">아이디</label>
<input type="text" id="userId" name="userId">
```

### fieldset
폼 안에서 관련 있는 입력 요소를 묶을 때 사용
```html
<fieldset>
  <legend>회원 정보</legend>

  <label for="name">이름</label>
  <input type="text" id="name" name="name">
</fieldset>
```

### legend
fieldset의 제목을 나타낼 때 사용
```html
<fieldset>
  <legend>회원 정보</legend>
</fieldset>
```

### textarea
여러 줄의 글을 입력받을 때 사용
```html
<textarea name="content" placeholder="내용 입력"></textarea>
```

### select
여러 선택지 중에서 선택할 때 사용
```html
<select name="city">
  <option value="busan">부산</option>
  <option value="seoul">서울</option>
</select>
```

### option
select 안에 들어가는 선택 항목
```html
<option value="java">Java</option>
```

### optgroup
option들을 그룹으로 묶을 때 사용
```html
<select name="subject">
  <optgroup label="Frontend">
    <option value="html">HTML</option>
    <option value="css">CSS</option>
  </optgroup>

  <optgroup label="Backend">
    <option value="java">Java</option>
    <option value="spring">Spring</option>
  </optgroup>
</select>
```

### size
select에서 한 번에 보여줄 항목 수를 정할 때 사용
```html
<select name="language" size="3">
  <option value="java">Java</option>
  <option value="html">HTML</option>
  <option value="css">CSS</option>
</select>
```

### multiple
select에서 여러 개를 선택할 수 있게 할 때 사용
```html
<select name="language" multiple>
  <option value="java">Java</option>
  <option value="html">HTML</option>
  <option value="css">CSS</option>
</select>
```

### selected
option을 기본 선택 상태로 만들 때 사용
```html
<select name="language">
  <option value="java" selected>Java</option>
  <option value="html">HTML</option>
</select>
```

### button
버튼을 만들 때 사용
```html
<button type="button">일반 버튼</button>
<button type="submit">전송</button>
<button type="reset">초기화</button>
```

---

## 8. table 관련 태그

### table
표를 만들 때 사용
```html
<table>
  <tr>
    <th>이름</th>
    <th>나이</th>
  </tr>
  <tr>
    <td>홍길동</td>
    <td>20</td>
  </tr>
</table>
```

### caption
표의 제목을 나타낼 때 사용
```html
<table>
  <caption>회원 목록</caption>
</table>
```

### tr
표의 한 줄을 만들 때 사용
```html
<tr>
  <td>데이터</td>
</tr>
```

### th
표의 제목 셀을 만들 때 사용
```html
<th>이름</th>
```

### td
표의 일반 데이터 셀을 만들 때 사용
```html
<td>홍길동</td>
```

### rowspan
행을 합칠 때 사용
```html
<td rowspan="2">행 합치기</td>
```

### colspan
열을 합칠 때 사용
```html
<td colspan="2">열 합치기</td>
```

### thead
표의 제목 영역을 나타낼 때 사용
```html
<thead>
  <tr>
    <th>상품명</th>
    <th>가격</th>
  </tr>
</thead>
```

### tbody
표의 본문 영역을 나타낼 때 사용
```html
<tbody>
  <tr>
    <td>키보드</td>
    <td>30000</td>
  </tr>
</tbody>
```

### tfoot
표의 하단 영역을 나타낼 때 사용
```html
<tfoot>
  <tr>
    <td>합계</td>
    <td>30000</td>
  </tr>
</tfoot>
```

### colgroup
표의 열들을 묶을 때 사용
```html
<table>
  <colgroup>
    <col style="width: 100px;">
    <col style="width: 200px;">
  </colgroup>
</table>
```

### col
표의 열 하나를 나타낼 때 사용
```html
<col style="width: 100px;">
```

### scope
th가 어느 방향의 제목인지 알려줄 때 사용  
접근성을 위해 사용
```html
<th scope="col">이름</th>
<th scope="row">1번</th>
```

---

## 9. audio / video 태그

### audio
오디오 파일을 넣을 때 사용
```html
<audio controls>
  <source src="music.mp3" type="audio/mpeg">
</audio>
```

### video
비디오 파일을 넣을 때 사용
```html
<video controls width="400">
  <source src="movie.mp4" type="video/mp4">
</video>
```

### source
audio, video 안에서 파일 경로와 형식을 지정할 때 사용
```html
<source src="movie.mp4" type="video/mp4">
```

---

## 10. 시맨틱 태그

### header
페이지나 영역의 상단 부분을 나타낼 때 사용
```html
<header>
  <h1>사이트 제목</h1>
</header>
```

### nav
메뉴 영역을 나타낼 때 사용
```html
<nav>
  <a href="/">홈</a>
  <a href="/board">게시판</a>
</nav>
```

### main
페이지의 핵심 내용을 나타낼 때 사용
```html
<main>
  <h2>메인 내용</h2>
</main>
```

### section
관련 있는 내용을 하나의 구역으로 묶을 때 사용
```html
<section>
  <h2>공지사항</h2>
  <p>공지 내용입니다.</p>
</section>
```

### article
하나의 독립적인 글이나 콘텐츠를 나타낼 때 사용
```html
<article>
  <h2>게시글 제목</h2>
  <p>게시글 내용입니다.</p>
</article>
```

### aside
본문 옆의 보조 내용을 나타낼 때 사용
```html
<aside>
  <p>사이드 메뉴</p>
</aside>
```

### footer
페이지나 영역의 하단 부분을 나타낼 때 사용
```html
<footer>
  <p>하단 정보</p>
</footer>
```

---

## CSS 정리

---

## 1. CSS 적용 방법

### 내부 스타일 시트
HTML 파일 안에 style 태그로 CSS를 작성하는 방법
```html
<head>
  <style>
    p {
      color: blue;
    }
  </style>
</head>
```

### 외부 스타일 시트
CSS 파일을 따로 만들고 HTML에서 연결하는 방법  
가장 많이 사용하는 방식
```html
<link rel="stylesheet" href="style.css">
```

```css
p {
  color: blue;
}
```

### 인라인 스타일
HTML 태그 안에 직접 style 속성을 작성하는 방법  
간단하지만 코드가 지저분해질 수 있다
```html
<p style="color: red;">빨간색 문장</p>
```

---

## 2. 기본 선택자

### 전체 선택자
모든 요소를 선택할 때 사용
```css
* {
  margin: 0;
  padding: 0;
}
```

### 태그 선택자
특정 태그를 선택할 때 사용
```css
p {
  color: blue;
}
```

### 아이디 선택자
특정 id를 가진 요소를 선택할 때 사용  
id는 보통 한 페이지에서 하나만 사용
```html
<h1 id="title">제목</h1>
```

```css
#title {
  color: red;
}
```

### 클래스 선택자
특정 class를 가진 요소를 선택할 때 사용  
여러 요소에 같은 class를 사용할 수 있다
```html
<p class="text">문장 1</p>
<p class="text">문장 2</p>
```

```css
.text {
  color: green;
}
```

---

## 3. 속성 선택자

### 기본 속성 선택자
특정 속성이 있는 요소를 선택할 때 사용
```html
<input type="text">
<input type="password">
```

```css
input[type] {
  border: 1px solid black;
}
```

### 속성값 선택자
속성값이 정확히 같은 요소를 선택할 때 사용
```css
input[type="text"] {
  background-color: lightgray;
}
```

### 문자열 속성 선택자
속성값의 문자열 조건으로 요소를 선택할 때 사용
```css
a[href^="https"] {
  color: green;
}

a[href$=".com"] {
  color: blue;
}

a[href*="google"] {
  font-weight: bold;
}
```

---

## 4. 조합 선택자

### 그룹 선택자
여러 선택자에 같은 스타일을 적용할 때 사용
```css
h1, h2, p {
  color: navy;
}
```

### 자식 선택자
바로 아래 자식 요소만 선택할 때 사용
```html
<div>
  <p>바로 아래 p</p>
  <section>
    <p>section 안의 p</p>
  </section>
</div>
```

```css
div > p {
  color: red;
}
```

### 하위 선택자
안쪽에 포함된 모든 하위 요소를 선택할 때 사용
```css
div p {
  color: blue;
}
```

### 인접 형제 선택자
바로 뒤에 오는 형제 요소 하나를 선택할 때 사용
```html
<h1>제목</h1>
<p>첫 번째 문단</p>
<p>두 번째 문단</p>
```

```css
h1 + p {
  color: red;
}
```

### 일반 형제 선택자
뒤에 오는 형제 요소들을 선택할 때 사용
```css
h1 ~ p {
  color: blue;
}
```

---

## 5. 가상 요소 선택자

### ::before
요소의 앞에 내용을 추가할 때 사용
```css
.notice::before {
  content: "공지: ";
}
```

### ::after
요소의 뒤에 내용을 추가할 때 사용
```css
.notice::after {
  content: "!";
}
```

---

## 6. 가상 클래스 선택자

### 링크 가상 클래스 선택자
링크 상태에 따라 스타일을 적용할 때 사용
```css
a:link {
  color: blue;
}

a:visited {
  color: purple;
}
```

### 동적 가상 클래스 선택자
사용자의 동작에 따라 스타일을 적용할 때 사용
```css
button:hover {
  background-color: lightgray;
}

button:active {
  background-color: gray;
}
```

### 입력 요소 가상 클래스 선택자
입력 요소의 상태에 따라 스타일을 적용할 때 사용
```css
input:focus {
  border: 2px solid blue;
}

input:checked {
  width: 20px;
  height: 20px;
}

input:disabled {
  background-color: lightgray;
}

input:enabled {
  background-color: white;
}
```

### 구조적 가상 클래스 선택자
요소의 위치나 순서에 따라 선택할 때 사용
```html
<ul>
  <li>첫 번째</li>
  <li>두 번째</li>
  <li>세 번째</li>
</ul>
```

```css
li:first-child {
  color: red;
}

li:last-child {
  color: blue;
}

li:nth-child(2) {
  color: green;
}

li:nth-child(odd) {
  background-color: lightgray;
}

li:nth-child(even) {
  background-color: white;
}
```

---

## 7. CSS 선택자 간단 예시

### :link
방문하지 않은 링크를 선택할 때 사용
```css
a:link {
  color: blue;
}
```

### :visited
방문한 링크를 선택할 때 사용
```css
a:visited {
  color: purple;
}
```

### :hover
마우스를 올렸을 때 사용
```css
button:hover {
  background-color: lightgray;
}
```

### :active
클릭하고 있는 동안 사용
```css
button:active {
  background-color: gray;
}
```

### :focus
input 같은 요소가 선택된 상태일 때 사용
```css
input:focus {
  border: 2px solid blue;
}
```

### :checked
체크박스나 라디오 버튼이 선택된 상태일 때 사용
```css
input:checked {
  width: 20px;
}
```

### :disabled
비활성화된 입력 요소를 선택할 때 사용
```css
input:disabled {
  background-color: lightgray;
}
```

### :enabled
활성화된 입력 요소를 선택할 때 사용
```css
input:enabled {
  background-color: white;
}
```

### :first-child
첫 번째 자식 요소를 선택할 때 사용
```css
li:first-child {
  color: red;
}
```

### :last-child
마지막 자식 요소를 선택할 때 사용
```css
li:last-child {
  color: blue;
}
```

### :nth-child()
n번째 자식 요소를 선택할 때 사용
```css
li:nth-child(2) {
  color: green;
}
```