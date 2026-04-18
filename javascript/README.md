# 자바스크립트
브라우저에서 실행되는 작은 프로그램으로 HTML 마크업 및 CSS 규칙과 상호작용하여 표시되는 내용과 브라우저에서 실행되는 작은 프로그램을 작성하고 현재 문서의 HTML 및 CSS를 변경할 수 있다.

## 기초 문법
### `<script>` 요소
`<script>` 태그는 HTML 문서에서 자바스크립트를 작동하도록 함.  
HTML 문서 어디든 상관없이 삽입할 수 있으며, 여러 개의 `<script>` 태그를 사용해도 무관.  

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JavaScript 연습</title>
</head>
<body>
    <script>
        document.write('<h1>환영합니다</h1>')
        document.write('<p>JavaScript</p>')
    </script>
</body>
</html>
```

---

### 결과물 출력
#### 외부 스크립트 파일 연결
`sample.js`
```js
document.write('<p>외부 스크립트.</p>')
```

`javascript.html`
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JavaScript 연습</title>
    <script src="js/sample.js"></script> <!-- 외부 스크립트 연결 -->
</head>
<body>
    <script>
        document.write('<p>내부 스크립트</p>')
    </script>
</body>
</html>
```
자바스크립트가 작동되는 시점은 HTML 문서에 삽입된 위치에서 작동됨.  
자바스크립트의 소스가 HTML 문서 어느 부분에서 작동시키는지 중요.  

### 콘솔창 사용
브라우저 안에서 프로그램을 확인하거나 필요한 결과를 출력할 수 있는 창  
`ctrl + shift + j`, `cmd + opt + j`
```html
<script>
    console.log(3+5);
</script>
```

#### document.write()
HTML 문서에서 직접 결괏값을 출력
```html
<script>
    document.write('welcome <br>');
    document.write('<h1>welcome</h1><br>');
    document.write(2+3);
</script>
```

#### alert()
창을 열어서 원하는 값 출력  
값만 사용자에게 전달
```html
<script>
    alert("환영합니다");
</script>
```

### 입력
#### comfirm()
브라우저가 사용자에게 질문하고 사용자의 답을 기다림
```html
<script>
    var answer = confirm('20세 이상인가요?');
    console.log(answer);
</script>
```

#### prompt()
브라우저가 사용자에게 질문을 하면 사용자는 자신의 답을 보낼 수 있다.
```html
<script>
    var answer = prompt('20세 이상이면 나이를 입력: ');
    console.log(answer);
</script>
```

## 변수
데이터를 저장하고 사용 또는 추가 변경 후 사용하는 데이터 저장소  
변수 선언 -> 변수 초기화 -> 변수 사용

```html
<script>
    var num1 = 5;
    
    var num2, num3, num4;
    num2 = 10;
    num3 = 15;
    num4 = 20;
</script>
```

### const
상수 선언  
상수 값으로 재할당할 수 없으며, 다시 선언도 할 수 없다.
```html
<script>
    const my = 5;
    my = 7; // 에러 발생(Assignment to constant variable)
</script>
```

### let
블록 변수  
자신이 속한 영역에서 사용 가능한 변수를 만들어 사용할 수 있다.
```html
<script>
    function logScope() {
        let local = 2;

        if (local) {
            let local = '다른 값';
            console.log(local); // 다른 값
        }

        console.log(local); // 2
    }
    logScope();
</script>
```

### var
변수를 선언하고, 선택적으로 초기화할 수 있다.  
같은 이름의 변수는 하나의 변수로 인식됨
```html
<script>
    function logScope() {
        var local = 2;

        if (local) {
            var local = '다른 값';
            console.log(local); // 다른 값
        }

        console.log(local); // 다른 값
    }
    logScope();
</script>
```

## 데이터형
`number`, `string`, `boolean`, `undefined`, `null`, `Infinity`

### 데이터 형을 알려주는 연산자 `typeof`
```html
<script>
    var num = -3.141592
    var str = 'welcome';
    var boolm = true;
    var no = null;
    var some;

    console.log(typeof(num)); // number
    console.log(typeof(str)); // string
    console.log(typeof(boolm)); // boolean
    console.log(typeof(no)); // object
    console.log(typeof(some)); //undefined
</script>
```

### String형(문자형)
따옴표에 둘러싸여 있는 문자나 숫자
```html
<script>
    var str1 = "봉래산";
    var str2 = '<p class="main">문자데이터 입니다</p>';

    document.write(str1);
    document.write(str2);
</script>
```

### Number형(숫자형)
계산 작업이 가능한 정수와 실수
```html
<script>
    var num1 = 5;
    var num2 = 4;

    var sum = num1 + num2;
    console.log(sum);
</script>
```

#### 문자형 데이터를 숫자로 바꾸기
<script>
    var num1 = "50";

    var strToNum1 = Number(num1); // 문자형 -> 숫자형
    console.log(strToNum1, typeof(strToNum1)); // 50 'number'
    
    var num2 = "60";
    var strToNum2 = parseInt(num2); // 문자형 -> 숫자형
    console.log(strToNum2, typeof(strToNum2)); // 60 'number'
</script>

### Boolean형(논리형)
데이터를 비교하거나 논리를 펼쳐 true와 false의 상황을 판단하고자 할 때 사용  
자바스크립트에선 데이터가 존재하면 `true`로, 데이터가 존재하지 않으면 `false`로 인식
```html
<script>
    var bol1 = 1<2;
    var bol2 = true;
    var bol3 = !false;
    console.log(bol1, bol2, bol3); // true true true

    var bol4 = Boolean(0);
    var bol5 = Boolean(null);
    var bol6 = Boolean(undefined);
    var bol7 = Boolean('welcome');
    console.log(bol4, bol5, bol6, bol7); // false false false true
</script>
```

### undefined
undefined는 데이터형에 속하지만, 데이터형이라기보다는 현재 변수의 데이터 상태를 알려주는 역할  
변수 선언은 했지만, 현재 가지고 있는 데이터가 없는 상태
```html
<script>
    var num;
    console.log(num); // undefined
</script>
```

### null
변수에 저장된 값이 유효하지 않은 상태  
```html
<script>
    var num = null;
    console.log(num); // null
</script>
```

## 백틱(`) 사용법
여러 데이터 형을 결합이나 연산자로 이용하는 대신 문자열에 수식을 끼어 사용하는 방법
```html
<script>
    var num1 = 5;
    var num2 = 6;
    var sum1 = `합은 ${num1 + num2}입니다.`;
    console.log(sum1); // 합은 11입니다.
</script>
```

## 제어문
조건에 따라 실행 순서를 바꾸거나 반복적인 실행을 하도록 프로그램의 흐름을 제어하는 문장

### 조건문
조건식에 나오는 결괏값이 true, false에 따라 실행문을 제어하는 경우

#### if문
조건식의 값이 true일 경우 실행문을 실행
```html
<script>
    var num = prompt("숫자 입력:")
    if (num < 10) {
        document.write("num은 10보다 작다.");
    }
</script>
```

#### if-else문
조건식의 값이 true 값일 경우 또는 false 값일 경우에 실행문이 다를 경우
```html
<script>
    var age = prompt("나이 입력:")
    if (age > 20 && age < 40) {
        document.write("입장");
    } else {
        document.write("입장 불가");
    }
</script>
```

#### if-else if문
```html
<script>
    var score = 85;

    if (score >= 90) {
        console.log("A학점");
    } else if (score >= 80) {
        console.log("B학점"); // 85는 B학점 출력
    } else {
        console.log("C학점");
    }
</script>
```

#### switch문
다양한 조건이 제시되었을 때 선택된 값에 따라 실행문을 선택하여 실행하도록 하는 제어문  
여러 조건이 많은 경우 if ~else문 보다 switch문이 더 효과적
```html
<script>
    var classRoom = prompt("학년 입력: ");

    switch (classRoom) {
        case '1': {
            document.write('1층');
        }
        case '2': {
            document.write('2층');
        }
        case '3': {
            document.write('3층');
        }
        default: {
            document.write('별관');
        }
    }
</script>
```

### 반복문
같은 원리를 가진 실행문을 조건이 성립될 때까지 반복적으로 실행하도록 하는 제어문

#### for문
실행하고자 하는 실행문이 반복적으로 진행할 수 있는 조건을 외부에서가 아닌 for문에서 설정 가능
```html
<script>
    for(let i=1; i<10; i++) {
        document.write(i+', ');
    }
    document.write('end');
</script>
```

```html
<script>
    var hap = 0;

    for(let i=1; i<=100; i++) {
        hap += i;
    }
    
    document.write('1부터 100까지 더한 값: ' + hap);
</script>
```

```html
<script>
    for(let i=1; i<=9; i++) {
        document.write(i + '단<br>');
        for(let j=1; j<=9; j++) {
            document.write(`${i} x ${j} = ${i*j}<br>`);
        }
        document.write('<br>');
    }
</script>
```

#### while문
반복문 외부에서 기준의 값을 가져와 특정한 조건이 달성될 때가지 실행문이 반복된다.
```html
<script>
    var num = 10;
    while(num >= 0) {
        document.write(num + '<br>');
        num--;
    }
</script>
```

#### do-while문
while문과 다른 점은 조건이 참이 아닌 경우라도 무조건 한 번 실행문이 실행된다.
```html
<script>
    var num = -10;
    do {
        document.write(num + '<br>');
        num--;
    }
    while(num >= 0) {
    }
</script>
```

#### continue문
현재 사용하고 있는 루프 반복에서 명령문의 실행을 종료하고 반복문의 처음으로 돌아가서 다시 반복문을 실행하게 됨
```html
<script>
    let num;

    for(num=1; num<=10; num++) {
        if(num == 3) {
            continue;
        }
        document.write(num, ", ")
    }
</script>
```

#### break문
루프의 실행을 완전히 종료.
```html
<script>
    let num;

    for(num=1; num<=10; num++) {
        if(num == 3) {
            break;
        }
        document.write(num, ", ")
    }
</script>
```

## 함수
자주 사용하는 기능이 있다면 그 기능을 등록해 놓으면 매번 그 기능을 작성하지 않아도 사용할 수 있다.  
프로그램의 정리가 간결하고 기능별로 시작과 끝점을 구분하여 정리할 수 있어 충돌의 위험이 없어짐.  
함수는 사용환경에 따라 `내장함수`와 `사용자 정의 함수`로 나눌 수 있다.

### 내장함수
`document()`, `write()`, `alert()`, `prompt()` 등과 같이 메소드라 불리던 명령어들이 내장함수로 브라우저에 내장되어 있다.

### 사용자 정의 함수
사용자가 자신이 만들고 있는 프로그램의 편의를 위해 만들어 사용하는 함수.  
함수는 만드는 방법과 사용법에 따라 `이름 있는 함수`, **이름 없는 함수**, **함수식**이 있다.
```html
<script>
    function line(str) {
        for (let i=1; i<=20; i++) {
            document.write(str);
        }
        document.write('end<br>');
    }

    line('*');
    line('&');
    line('@');
</script>
```

### 매개변수
사용자 정의 함수를 사용할 때 함수의 이름만 불러 필요한 기능을 실행시키는 것뿐 아니라 기능을 실행하기 위해 데이터가 필요할 때가 있다.  
함수를 만들어 사용하고자 할 때 데이터가 필요한 경우, 데이터를 같이 전달하여 함수를 호출하는 통로를 매개변수, 인수라고 함.

- 버튼을 클릭하여 함수를 불러들이는 방법
    ```html
    <script>
        function flower(flowerName) {
            switch(flowerName) {
                case '무궁화': alert('무궁화 추천');
                break;
                case '장미': alert('장미 추천');
                break;
                case '국화': alert('국화 추천');
                break;
            }
        }
    </script>
    <button type="button" onclick="flower('무궁화')"></button>
    <button type="button" onclick="flower('장미')"></button>
    <button type="button" onclick="flower('국화')"></button>
    ```

### return 문
함수에서 결괏값을 함수 밖으로 넘기는 역할.  
return 문이 실행되는 위치를 항상 함수 실행문의 가장 마지막에 사용하여 함수의 결괏값을 외부로 반환한 후 프로그램의 포커스를 함수 밖으로 나오게 함.  
return 문이 함수 실행문 중간에 나오게 되면 return 문 다음에 오는 실행문은 실행이 되지 않는 상태에서 함수가 끝나게 됨.

```html
<script>
    var first = 13;
    var last = 7;

    var result = all(first, last);
    console.log(result);

    function all(a, b) {
        var sam = a + b;
        return sam;
    }
</script>
```

### 스코프
전역변수: 프로그램 전역에서 모두 사용 가능한 변수.  
지역변수: 변수가 만들어진 지역 안에서만 사용 가능한 변수.
```html
<script>
    var num = 1;

    function love() {
        var a = num + 1;
        console.log(a);
    }

    love(); // 2
    console.log(num); // 1
</script>
```

#### 함수 안에서 변수 만들기
함수 안에서 전역변수를 만들 경우 `var`라는 명령어를 빼고 변수를 선언하면 됨.  
함수 안에서 전역적으로 쓸 수 있는 변수를 만들 수 있지만, 함수를 한 번이라도 사용하여야만 가능.
```html
<script>
    function love(){
        str ='산';     // 전역변수
        var sum ='강'; // 지역변수
        document.write('함수내에서 출력 ', str,'<br>'); // 한 번 사용해야 함수 밖에서 사용 가능
        document.write('함수내에서 출력 ', sum,'<br>');
        return str;
    }

    love();
    document.write(str,'<br>');
    // document.write(sum,'<br>');
</script>
```

### 이름 있는 함수
function이라는 명령어를 사용해서 함수 이름을 선언하고, 인수에서 필요한 데이터를 보내 함수 선언에 있는 매개변수에서 그 데이터를 받아 사용할 수 있는 함수.
```html
<script>
    function all(a, b) {
        var result;
        result = a>b? console.log('a가 큽니다.') : console.log('b가 큽니다');
    return result;
    }

    var first = 13;
    var last = 7;

    all(first, last);
</script>
```

### 익명 함수
이름이 없이 함수를 선언하여 하나의 식처럼 변수에 해당하는 함수의 값을 제공하여 사용하는 방법
```html
<script>
    var all = function(a,b) {
        var result;
        a>b ? result = 'a' : result = 'b';
        return result;
    }
    console.log(all(7,10));
</script>
```

### 즉시 실행 함수식
정의된 함수와 함께 실행하여 즉시 그 결괏값을 받아 사용하는 방법
```html
<script>
    var first = 5;
    var last = 7;
    
    var all = (function(a,b){
        var result;
        a>b ? result = 'a가크다' : result = 'b가크다';
    return result;
    })(first,last)

    console.log(all);
</script>
```

### 화살표 함수
기존의 함수를 훨씬 간단하게 표현할 수 있게 만든 함수.  
재사용하지 않는 이름 없는 함수인 경우 function 이라는 키워드 없이 `=>`를 이용해 함수를 생성하는 방법.

#### 매개변수 없는 경우
매개변수가 없는 경우는 `()`를 생략할 수 없다.
```html
<script>
    const main1 = () => {
        console.log('main1');
    }
    main1();
</script>
```

#### 매개변수 1개인 경우
매개변수가 1개인 경우에는 `()`를 생략 가능.
```html
<script>
    const main2 = a => {
        console.log(a);
    }
    main2('welcome');
</script>
```

#### 매개변수가 여러 개인 경우
`()` 생략하지 않는다.
```html
<script>
    const main3 = (a,b) => {
        console.log(a + b);
    }
    main3(5, 10);
</script>
```

## 객체
자바스크립트에 필요한 시스템.  
객체와 메소드`()`, 속성의 연결은 `.`로 연결한다(체인 사용법).  

### 객체 종류1: 내장 객체
자바스크립트 엔진에 내장이 되어 있는 기본 객체들로 string, Date, Array, Math 객체 등.

### 객체 종류2: 브라우저 객체
브라우저에 내장된 객체로 BOM(Browser Object Model).  
브라우저의 최상위 객체는 `window`객체로 어느 객체보다 위에 존재하기 때문에 window 객체는 생략하여 사용.  
window 객체 안에는 DOM(Document Object Model)이라 불리는 문서객체도 포함됨.

### 객체 종류3: 사용자 (정의) 객체
프로그램 작성 시 사용자가 필요에 따라 시스템을 설계하여 만드는 객체.

### 객체의 프로토타입
자바스크립트에 내장된 객체 또는 사용자에 필요에 따라 만든 객체 등  
모든 객체 안에는 객체의 속성과 메서드()가 설계되어 있다.  
이런 내부 구조도를 프로토타입이라고 함.

### 객체의 인스턴스 생성
객체의 인스턴스: 구조가 만들어져 있는 시스템에서 기본 시스템을 이용하여 자신이 사용할 복제품.  
`var`로 사용할 이름을 설정하고 `new`라는 연산자를 이용하여 만들고자 하는 객체의 이름을 활용.

## 내장객체

### Array 객체
데이터를 관리하는 객체.
```html
<script>
    var pen = new Array(4);
    pen[0] = 'red';
    pen[1] = 'green';
    pen[2] = 'blue';
    pen[3] = 'orange';

    console.log(pen); // (4) ['red', 'green', 'blue', 'orange']
    console.log(pen[2]); // blue
</script>
```

```html
<script>
    var room = new Array();
    room = ['red', 'green', 'blue', 'orange']

    console.log(room); // (4) ['red', 'green', 'blue', 'orange']
</script>
```

```html
<script>
    var str = new Array('red', 'green', 'blue', 'orange');

    console.log(str); // (4) ['red', 'green', 'blue', 'orange']
</script>
```

### 배열의 성격
배열은 변수와 같이 각각의 소스들을 변경할 수 있다.
```html
<script>
    var str = new Array('red', 'green', 'blue', 'orange');
    console.log(str); // (4) ['red', 'green', 'blue', 'orange']

    str[2] = 'pink';
    console.log(str); // (4) ['red', 'green', 'pink', 'orange']
</script>
```

### 배열 속성
length: 객체의 갯수를 수치로 나타냄  
constructor: 객체의 생성자를 참조  
prototype: 속성과 메소드를 추가하여 배열 선언을 확장

### 배열 메소드
concat(): 하나의 배열에 다른 배열의 요소를 결합. 
join(): 문자열로 배열의 요소를 분리하여 1개의 데이터 결합  
pop(): 배열의 마지막 요소를 삭제  
push(): 마지막 인덱스에 다른 요소를 추가  
shift(): 배열의 첫 요소를 제거  
unshift(): 배열의 처음에 요소를 추가  
splice(): 이전 배열 요소를 삭제하고 새로운 내용물을 추가하는 형태로 배열 내용을 변경하고, 삭제된 요소들은 반환  
slice(): 배열 값의 일부분을 선택하여 새로운 배열을 만들어 줌  
sort(): 숫자 또는 문자열을 순서대로 정렬  
reverse(): 배열의 요소를 역순으로 나타낸다

```html
<script>
    pens = ["red", "blue", "green", "orange"];
    console.log(pens); // 'red', 'blue', 'green', 'orange']

    pens.reverse();
    console.log(pens); // ['orange', 'green', 'blue', 'red']

    pens.shift();
    pens.unshift('pink', 'shy');
    console.log(pens); // ['pink', 'shy', 'green', 'blue', 'red']

    pens.pop();
    console.log(pens); // ['pink', 'shy', 'green', 'blue']

    pens.push('sky');
    console.log(pens); // ['pink', 'shy', 'green', 'blue', 'sky']

    pens.splice(1,2, 'apple', 'number');
    console.log(pens); // ['pink', 'apple', 'number', 'blue', 'sky']

    var newPens = pens.slice(1, 3);
    console.log(newPens); // ['apple', 'number']

    var result = pens.indexOf('apple');
    console.log(result); // 1

    console.log(pens.join('/')); // pink/apple/number/blue/sky
</script>
```

```html
<script>
    let pens = ["red", "blue", "green", "orange"];
    console.log(pens.sort()); // ['blue', 'green', 'orange', 'red']

    let arr = new Array(1,2,3,4,11,'11',1111,123,'124',11111);
    console.log(arr.sort()); // [1, 11, '11', 1111, 11111, 123, '124', 2, 3, 4]
</script>
```

sort() 함수로 오름차순 정렬
```html
<script>
    const arr = [2,1,3,10];
    arr.sort(function(a,b) {
        return a - b;
    });
    console.log(arr); // [1, 2, 3, 10]
</script>
```