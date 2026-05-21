# HTML / CSS

## 1. 제목 / 문단 태그

### h1 ~ h6

제목을 나타내는 태그이다.  
숫자가 작을수록 더 큰 제목이다.

```html
<h1>큰 제목</h1>
<h2>중간 제목</h2>
<h3>작은 제목</h3>
```

### p

문단을 만들 때 사용한다.

```html
<p>문단 내용입니다.</p>
```

### br

줄바꿈할 때 사용한다.  
닫는 태그는 없다.

```html
안녕하세요.<br>
반갑습니다.
```

---

## 2. 인용 관련 태그

### blockquote

긴 인용문을 나타낼 때 사용한다.

```html
<blockquote>
  인용할 문장입니다.
</blockquote>
```

### q

짧은 인용문을 나타낼 때 사용한다.

```html
<p>그는 <q>열심히 하자</q>라고 말했다.</p>
```

---

## 3. 글자 의미 태그

### strong

중요한 내용을 표시할 때 사용한다.  
화면에서는 보통 굵게 나온다.

```html
<strong>중요한 내용</strong>
```

### em

강조하고 싶은 내용을 표시할 때 사용한다.  
보통 기울임으로 나온다.

```html
<em>강조할 내용</em>
```

### ins

추가된 내용을 표시한다.

```html
<ins>추가된 내용</ins>
```

### del

삭제된 내용을 표시한다.

```html
<del>삭제된 내용</del>
```

### sub

아래 첨자를 표시한다.

```html
H<sub>2</sub>O
```

### sup

위 첨자를 표시한다.

```html
2<sup>3</sup>
```

---

## 4. 영역 태그

### div

블록 단위로 영역을 묶을 때 사용한다.  
화면 구조를 나눌 때 많이 사용한다.

```html
<div>
  <h2>제목</h2>
  <p>내용</p>
</div>
```

### span

문장 안에서 일부분만 묶을 때 사용한다.

```html
<p>이 부분은 <span>span 영역</span>입니다.</p>
```

---

## 5. 목록 태그

### ul

순서가 없는 목록이다.

```html
<ul>
  <li>HTML</li>
  <li>CSS</li>
</ul>
```

### ol

순서가 있는 목록이다.

```html
<ol>
  <li>첫 번째</li>
  <li>두 번째</li>
</ol>
```

### li

목록 안의 항목이다.

```html
<li>목록 항목</li>
```

### dl, dt, dd

설명 목록을 만들 때 사용한다.

- `dl`: 설명 목록 전체
- `dt`: 설명할 단어
- `dd`: 설명 내용

```html
<dl>
  <dt>HTML</dt>
  <dd>웹 페이지 구조를 만드는 언어</dd>
</dl>
```

---

## 6. 링크 / 이미지 태그

### a

링크를 만들 때 사용한다.

```html
<a href="https://www.google.com">구글</a>
```

자주 쓰는 속성

| 속성 | 설명 |
|---|---|
| href | 이동할 주소 |
| target | 링크를 여는 방식 |
| title | 마우스를 올렸을 때 설명 |

```html
<a href="https://www.google.com" target="_blank" title="구글 사이트">
  구글 이동
</a>
```

### img

이미지를 넣을 때 사용한다.  
닫는 태그는 없다.

```html
<img src="image.jpg" alt="이미지 설명">
```

| 속성 | 설명 |
|---|---|
| src | 이미지 경로 |
| alt | 이미지 설명 |

---

## 7. form 관련 태그

### form

사용자가 입력한 값을 서버로 보낼 때 사용하는 영역이다.

```html
<form>
  <input type="text" name="username">
  <button type="submit">전송</button>
</form>
```

### input

사용자에게 값을 입력받을 때 사용한다.

```html
<input type="text" name="loginId" value="test">
```

자주 쓰는 속성

| 속성 | 설명 |
|---|---|
| type | 입력 방식 |
| name | 서버로 보낼 이름 |
| value | 입력값 또는 기본값 |
| placeholder | 입력 안내 문구 |
| readonly | 읽기 전용 |
| disabled | 비활성화 |
| maxlength | 최대 글자 수 |
| checked | 체크된 상태 |

```html
<input type="text" name="userId" placeholder="아이디 입력">
<input type="password" name="password">
<input type="checkbox" name="agree" checked> 동의
```

### label

input에 이름표를 붙일 때 사용한다.

```html
<label for="userId">아이디</label>
<input type="text" id="userId" name="userId">
```

### textarea

여러 줄의 글을 입력받을 때 사용한다.

```html
<textarea name="content" placeholder="내용 입력"></textarea>
```

### select

여러 선택지 중 하나를 선택할 때 사용한다.

```html
<select name="city">
  <option value="busan">부산</option>
  <option value="seoul">서울</option>
</select>
```

### option

select 안에 들어가는 선택 항목이다.

```html
<option value="java">Java</option>
```

### optgroup

option들을 그룹으로 묶을 때 사용한다.

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

select, option 관련 속성

| 속성 | 설명 |
|---|---|
| size | 한 번에 보여줄 항목 수 |
| multiple | 여러 개 선택 가능 |
| selected | 기본 선택 |

```html
<select name="language" size="3" multiple>
  <option value="java" selected>Java</option>
  <option value="html">HTML</option>
  <option value="css">CSS</option>
</select>
```

### button

버튼을 만들 때 사용한다.

```html
<button type="button">일반 버튼</button>
<button type="submit">전송</button>
<button type="reset">초기화</button>
```

| 속성 | 설명 |
|---|---|
| disabled | 버튼 비활성화 |

```html
<button type="submit" disabled>전송 불가</button>
```

### fieldset

폼 안에서 관련 있는 입력 요소를 묶을 때 사용한다.

```html
<fieldset>
  <legend>회원 정보</legend>

  <label for="name">이름</label>
  <input type="text" id="name" name="name">
</fieldset>
```

### legend

fieldset의 제목을 나타낸다.

```html
<legend>회원 정보</legend>
```

---

## 8. table 관련 태그

### table

표를 만들 때 사용한다.

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

표의 제목을 나타낸다.

```html
<caption>회원 목록</caption>
```

### tr

표의 한 줄을 만든다.

```html
<tr>
  <td>데이터</td>
</tr>
```

### th

표의 제목 셀이다.

```html
<th>이름</th>
```

### td

표의 일반 데이터 셀이다.

```html
<td>홍길동</td>
```

### rowspan

행을 합칠 때 사용한다.

```html
<td rowspan="2">행 합치기</td>
```

### colspan

열을 합칠 때 사용한다.

```html
<td colspan="2">열 합치기</td>
```

### thead, tbody, tfoot

표의 영역을 나눌 때 사용한다.

- `thead`: 표의 제목 부분
- `tbody`: 표의 본문 부분
- `tfoot`: 표의 아래 부분

```html
<table>
  <thead>
    <tr>
      <th>상품명</th>
      <th>가격</th>
    </tr>
  </thead>

  <tbody>
    <tr>
      <td>키보드</td>
      <td>30000</td>
    </tr>
  </tbody>

  <tfoot>
    <tr>
      <td>합계</td>
      <td>30000</td>
    </tr>
  </tfoot>
</table>
```

### colgroup, col

표의 열을 묶어서 스타일을 줄 때 사용한다.

```html
<table>
  <colgroup>
    <col style="width: 100px;">
    <col style="width: 200px;">
  </colgroup>

  <tr>
    <th>이름</th>
    <th>설명</th>
  </tr>
</table>
```

### scope

th가 어떤 방향의 제목인지 알려준다.  
접근성을 위해 사용한다.

```html
<th scope="col">이름</th>
<th scope="row">1번</th>
```

---

## 9. audio / video 태그

### audio

오디오 파일을 넣을 때 사용한다.

```html
<audio controls>
  <source src="music.mp3" type="audio/mpeg">
</audio>
```

### video

비디오 파일을 넣을 때 사용한다.

```html
<video controls width="400">
  <source src="movie.mp4" type="video/mp4">
</video>
```

### source

audio, video 안에서 파일 경로와 형식을 지정한다.

```html
<source src="movie.mp4" type="video/mp4">
```

---

## 10. 시맨틱 태그

시맨틱 태그는 이름만 봐도 역할을 알 수 있는 태그이다.  
화면 구조를 더 명확하게 만들 때 사용한다.

### header

페이지나 영역의 상단 부분이다.

```html
<header>
  <h1>사이트 제목</h1>
</header>
```

### nav

메뉴 영역이다.

```html
<nav>
  <a href="/">홈</a>
  <a href="/board">게시판</a>
</nav>
```

### main

페이지의 핵심 내용이다.

```html
<main>
  <h2>메인 내용</h2>
</main>
```

### section

관련 있는 내용을 하나의 구역으로 묶을 때 사용한다.

```html
<section>
  <h2>공지사항</h2>
  <p>공지 내용입니다.</p>
</section>
```

### article

하나의 독립적인 글이나 콘텐츠를 나타낸다.

```html
<article>
  <h2>게시글 제목</h2>
  <p>게시글 내용입니다.</p>
</article>
```

### aside

본문 옆의 보조 내용을 나타낸다.

```html
<aside>
  <p>사이드 메뉴</p>
</aside>
```

### footer

페이지나 영역의 하단 부분이다.

```html
<footer>
  <p>하단 정보</p>
</footer>
```