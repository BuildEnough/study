# Vue js

## node 버전 확인
```
node -v
```

## Vue CLI 설치
- 명령어 인터페이스로, 뷰 애플리케이션을 쉽게 생성하고 관리하는 여러 명령어를 제공

### Vue CLI 설치 확인 명령어
```
vue --version
```

### Vue CLI 설치 명령어
```
npm install [-g] 패키지명
```

```
npm install -g @vue/cli
```


## vue 애플리케이션 생성
### CDN 사용
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
    <div id="app">{{ message }}</div>
    <script>
        const { createApp } = Vue;
        createApp({
            data() {
                return {
                    message: "Hello Vue.js!",
                };
            },
        }).mount("#app");
    </script>
</body>
</html>
```

### NPM 사용
```
npm create vue@latest
```

```
npm install
npm run dev
```

### 과거 버전
```
vue create 폴더_이름
```

## CDN과 NPM 비교
### CDN
- CDN을 사용하면 CDN 서비스로 제공되는 `<script>` 태그만 추가해 뷰 어플리케이션을 바로 적용 가능한 장점 -> 별 다른 개발 환경을 갖추지 않아도 됨
- 하지만 개발에 필요한 라이브러리를 직접 추가해야하고 의존성 관리도 직접 해야함
- 또한 HTML과 함계 사용해야 해서 규모가 큰 프로젝트에는 적합하지 않음

### NPM
- 뷰 애플리케이션을 만들면 CDN을 사용할 때보다 설치 과정이 번거로움
- 하지만 뷰 애플리케이션의 세부 설정을 직접 지정할 수 있음 -> 초기 설정에서 폭이 크다
- NPM이라는 패키지 관리 도구를 사용하므로 패키지에 대한 의존성 관리가 쉽다
- vue로 끝나는 단독 파일을 사용해 애플리케이션을 만들기 때문에 관리와 유지보수가 쉬워 규모가 큰 프로젝트에 적합하다

### package.json
- vue 애플리케이션에서 가장 중심이 되는 파일
- 기본 정보, 의존성, 모듈 정보, 스크립트 명령어 정보 등을 담고 있다
```json
{
  "name": "vue1",
  "version": "0.0.0",
  "private": true,
  "type": "module",
  "scripts": {
    "dev": "vite",
    "build": "vite build",
    "preview": "vite preview"
  },
  "dependencies": {
    "vue": "^3.5.32"
  },
  "devDependencies": {
    "@vitejs/plugin-vue": "^6.0.6",
    "vite": "^8.0.8",
    "vite-plugin-vue-devtools": "^8.1.1"
  },
  "engines": {
    "node": "^20.19.0 || >=22.12.0"
  }
}
```
- name: vue application의 이름을 나타내는 문자열
- version: vue application의 버전을 나타내는 문자열
- private: vue application의 공개 여부를 의미하는 논리형 값
- script: vue application을 빌드하거나 실행할 수 있는 명령어를 등록하는 부분, 값은 객체 형태로 저장됨, 여기에 등록된 명령어는 `npm run` 명령어로 실행 가능
- dependencies: vue application을 실행할 때 필요한 의존성 모듈을 정의하는 부분
- devDependencies: 뷰 애플리케이션을 개발할 때 필요한 의존성 모듈을 정의하는 부분

### 개발 진행 중 패키지 설치
```
npm install [패키지명] [--save| --save-dev]
```
- 해당 명령어로 설치되는 패키지는 dependencies나 devDependencies에 의존성으로 등록됨
- `--save` 옵션을 주면 dependencies에 설치되고, `--save-dev` 옵션을 주면 devDependencies에 설치됨
- 아무런 옵션을 주지 않으면 `--save` 옵션 적용됨

### index.html
```html
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <link rel="icon" href="/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vite App</title>
  </head>
  <body>
    <div id="app"></div>
    <script type="module" src="/src/main.js"></script>
  </body>
</html>
```
- vue application은 id 속성의 값이 `app`인 HTML 요소를 root 요소로 지정
    - id 속성 값을 `app`으로 지정하는 것이 관례이긴 해도 다른 값으로 지정해도 상관없음
- vue application의 핵심인 main.js 모듈을 불러오는 부분
    - 이 부분에서 main.js 파일에 작성된 코드를 불러오고 이때부터 vue application에서 사용할 패키지와 코드가 실행됨

### main.js
- `index.html` 파일에서 main.js 파일을 불러오면 vue application의 코드가 실행됨
- `main.js` 파일은 vue application을 초기화하고 구성하는 역할을 하는 파일
```js
import './assets/main.css' // main.css 파일을 불러와 컴포넌트에 스타일을 적용
import { createApp } from 'vue' // vue 패키지에서 함수를 가져옴, 모든 vue application은 하나의 인스턴스를 가지는데, createApp() 함수가 vue application의 인스턴스를 생성하는 역할을 함
import App from './App.vue' // App.vue 파일을 불러옴, 해당 파일이 root 컴포넌트가 됨
createApp(App).mount('#app') //createApp() 함수로 vue application의 인스턴스를 생성함, 이때 매개변수로 App.vue 파일을 전달하는데, 전달한 파일이 초기 루트 컴포넌트가 됨, 루트 컴포넌트는 mount() 함수에 의해 id 속성의 값이 app인 요소에 추가됨
```

#### vue application의 실행과정 정리
- npm run dev 명령어를 실행하면 개발 서버를 구동한 후 index.html 파일을 불러옵니다.
- `index.html` 파일은 다시 `main.js` 파일을 불러오고 index.html 파일에서 id 속성의 값이 app인 div 요소에 root 컴포넌트를 추가합니다.
- 이 과정을 거쳐 App.vue 파일에 작성된 코드가 웹 브라우저에서 주소를 입력했을 때 보게되는 vue application의 첫 화면이 됨

### App.vue
- App.vue 파일처럼 확장자가 `vue`인 파일을 뷰에서는 SFC(Single File Component), 다른 말로는 Component라고 함
- vue application은 이런 컴포넌트를 여러 개 생성하면서 애클레이션을 만든다
- App.vue 파일은 vue 애플리케이션에서 root 컴포넌트 역할을 함

#### SFC(Single File Component)
- SFC는 `<script>`, `<template>`, `<style>` 태그로 영역을 구분

### vue application 인스턴스
- 자바스크립트에서 instance는 클래스의 실체화된 객체를 의미
- `클래스`가 객체를  생성하기 위한 템플릿이라면, 인스턴스는 해당 클래스의 실제 객체
```javascript
class Person {
  construtor(name, age) {
    this.name = name;
    this.age = age;
  }

  sayHello() {
    console.log(`안녕하세요, 저는 ${this.name} 입니다.`);
  }
}

// Person 클래스의 인스턴스 생성
const person1 = new Person('Kim', 25);
const person1 = new Person('John', 30);
console.log(person1.name); // Kim
console.log(person2.age); // 30
person1.sayHello(); // 안녕하세요 저는 Kim입니다.
person2.sayHello(); // 안녕하세요 저는 John입니다.
```
- vue에서 인스턴스를 생성하는 코드는 main.js 파일에 작성함
```javascript
import { createApp } from 'vue' // createApp() 함수는 vue 패키지에 정의된 Vue 클래스의 인스턴스를 생성하는 역할을 하는 함수
import App from './App.vue'
createApp(App).mount('#app') // createApp() 함수로 Vue 인스턴스를 생성하고, 생성한 인스턴스를 mount() 함수로 HTML DOM과 연결
```

### 인스턴스의 구성 요소
- createApp() 함수를 사용해 애플리케이션 인스턴스를 생성할 때, App.vue 파일만 매개변수로 전달함
- 그런데 createApp() 함수를 사용할 때 인스턴스의 초기 설정을 담은 객체 {}를 직접 전달할 수도 있다
```javascript
// import './assets/main.css'
import { createApp, h } from 'vue'
// import App from './App.vue'

createApp({
    data() {
        return {
            message: 'Hello, Vue!',
        };
    },
    methods: {
        reverse() {
            this.message = this.message.split('').reverse().join('');
        },
    },
    render() { // data와 methods에 정의한 속성 사용
        return h('div', [
            h('p', this.message),
            h('button', { onClick: this.reverse }, 'Reverse'),
        ]);
    },
}).mount('#app');
```
- `data`, `methods`, `render` 속성 존재하고 인스턴스의 구성요소라고 함
- 3가지 속성은 HTML 구조, 데이터, 함수 등을 객체 속성으로 설정, 해당 속성들을 매개변수로 전달해 객체를 바탕으로 뷰 애플리케이션의 인스턴스를 생성
- but, 객체에 포함되는 구성 요소의 코드가 길어질수록 가독성이 떨어지고 코드의 유지보수도 어려워짐
- 이런 단점을 극복하기 위해 SFC라는 독자적인 파일 형식을 만듦 => `App.vue`가 SFC 파일

#### App.vue 파일
- 뷰 애플리케이션 인스턴스의 설정 정보가 들어있음
- 인스턴스를 생성할 때 SFC 파일을 createApp() 함수의 매개변수로 전달하면 SFC 파일의 설정 정보를 가져와 인스턴스를 생성하고 이 방법으로 작성한 코드가 `main.js` 파일
- 이 방식으로 인스턴스를 생성하면 코드의 가독성이 향상되고 유지 보수가 편해짐
```javascript
import { createApp } from 'vue'
import App from './App.vue'
createApp(App).mount('#app')
```

### SFC
- SFC는 뷰만의 특별한 파일 형태로, 확장자가 vue인 단일 구성 요소
- `단일 구성 요소`는 하나의 파일에 인스턴스 구성 요소와 관련한 모든 코드가 포함되는 형식을 의미
```javascript
<script>
export default {}
</script>
<template></template>
<style></style>
```
- SFC는 일반적으로 `<script>`, `<template>`, `<style>` 3가지 태그 영역으로 구성됨
- 주의할 점: SFC 파일에 `<template>` 태그를 1개 이상 포함해야 한다는 점, 안그러면 뷰 애플리케이션을 실행할 때 오류 발생함

#### `<script>` 태그 영역
- SFC 파일에서 사용할 로직을 자바스크립트로 작성, 일반적인 자바스크립트 개념과 문법을 사용하되, Vue에서만 사용할 수 있는 문법 규칙을 지키며 코드를 작성해야 함
- SFC 파일 형식을 보면 `<script>` 태그 영역에 export default 키워드로 객체 {}를 내보내는 문법이 있다 => 이러한 문법은 자바스크립트 문법
- 원래 객체는 자유롭게 속성과 값을 설정할 수 있지만 Vue는 객체 안에 특성 속성을 사용하도록 문법 규칙이 정해져 있다
- Vue에서 객체를 작성할 때 지켜야 하는 문법 규칙을 `옵션스 API`라고 함

#### `<template>` 태그 영역
- HTML 코드를 작성, 별도 영역으로 분리되기 때문에 HTML 코드를 작성하기 쉽다
- 단, `<template>` 태그 영역에 작성된 HTML은 `<script>` 태그 영역에서 작성한 여러 속성으로 정의한 값들과 연동할 수 있다는 점이 다름

#### `<style>` 태그 영역
- `<template>` 태그 영역에 작성한 구성 요소에 CSS 스타일을 적용하기 위해 사용

---

## 기본 문법
1. 뷰 애플리케이션 생성
```
npm create vue@latest
```

2. 뷰 애플리케이션에 node_modules 폴더가 없다면 `npm install` 실행
```
npm install
```

3. assets 폴더 삭제
4. main.js에서 main.css를 import 하는 부분 삭제
5. App.vue에 작성된 코드를 지우고 다음 코드 새로 작성
```javascript
<script></script>
<template></template>
<style></style>
```

6. src/components 폴더 삭제

### 옵션스 API 사용하기
- SFC 파일(App.vue)의 `<script>` 태그 영역에는 SFC 파일에서 사용할 로직을 자바스크립트로 작성함
- 옵션스 API는 `export default` 키워드로 내보내는 객체{} 안에 여러 속성을 사용하는 형태
```javascript
<script>
export default {}
</script>
<template></template>
<style></style>
```
- 원래 자바스크립트의 객체는 자유롭게 속성을 정의할 수 있지만
- Vue에서 export default 키워드로 내보내는 객체는 Vue에서 약속된 속성을 사용해야만 함 => 옵션 API, 옵션 속성

### 데이터 정의하기
- `<script>` 태그 영역에 로직을 작성할 때 가장 기본이 되는 개념은 데이터
- 데이터는 컴포넌트 전반에 걸쳐 사용할 값
- 자바스크립트에서는 데이터를 선언할 때 var, let const 키워드 중 하나를 선택하지만, 뷰에서는 data 옵션 속성을 사용
```javascript
<script>
export default {
  data: function() { // data()
    return {};
  },
}
</script>
```

- data 옵션 속성에서 return 문을 반환하는 객체에 정의된 속성이 SFC에서 사용할 수 있는 데이터 속성
```javascript
<script>
export default {
  data() {
    return {
      name: '철수',
      age: 19
    };
  },
}
</script>
```
- data 옵션 속성의 return 문에 정의된 객체의 속성이 컴포넌트에서 사용할 수 있는 값이 됨

### 데이터 보간 사용
- data 옵션 속성으로 선언한 데이터 속성은 `<template>` 태그 영역에서 사용할 수 있다.
- 텍스트 보간은 중괄호 두 쌍으로 표시하는 mustach syntax로 구성
```javascript
<script>
export default {
  data() {
    return {
      name: '철수',
      age: 19
    };
  },
}
</script>
<template>
  {{ name }}
  {{ age }}
</template>
```

- `<template>` 태그 영역에서는 HTML 태그도 사용할 수 있다
```javascript
<template>
  <p>내 이름은 {{ name }} 입니다</p>
  <p>나이는 {{ age }} 살 입니다</p>
</template>
```

- 단순한 자바스크립트 표현식도 전개 가능
```javascript
<template>
  {{ 10 * 20 * 30 }}
  {{ name.toUpperCase() }}
</template>
```

### 디렉티브 사용하기
- `<script>` 태그 영역에서 정의한 data 옵션 속성을 `<template>` 태그 영역에서 사용할 수 있게 하는 방법
- Vue에서만 사용하는 문법으로, `v-`가 붙는다
- `<template>` 태그 영역에서 사용하며 HTML 태그의 속성으로만 표현됨

#### v-html
- data 옵션 속성으로 정의한 데이터 속성을 `<template>` 태그 영역에서 출력할 때 콧수염 문법 사용
- HTML 태그가 포함되었으면 값을 단순 텍스트로 치환해 출력
```javascript
<script>
export default {
  data() {
    return {
      message: '<h1>Hello, Vue JS</h1>',
    };
  },
}
</script>
<template>
  {{ message }}
</template>
```

- 값에 포함된 태그를 웹 브라우저에도 태그로 인식하게 하려면 `v-html 디렉티브` 사용
```javascript
<template>
  <div v-html="message"></div>
</template>
```
- v.html 디렉티브는 데이터에 포함된 HTML 태그를 인식해 렌더링하므로 XSS 공격에 취약함
- 따라서 사용자가 입력한 데이터를 출력할 때는 사용하면 안되고, 개발자가 직접 작성한 데이터를 출력할 때만 사용해야 안전함

#### v-text
- 값을 단순하게 텍스트로 출력하는 디렉티브, 단순하게 텍스트만 출력됨

#### v-pre
- 컴파일 할 때 `<template>` 태그 영역을 건너뛰게 하는 디렉티브
- 뷰는 SFC 파일의 `<template>` 태그를 런타임 또는 빌드 과정에서 컴파일함
- 컴파일은 성능에 영향을 주는 부분으로, 컴파일하는 코드 양이 많을수록 초기 렌더링 성능이 저하됨
- SFC 파일의 `<template>` 태그 영역에 Vue 문법이 사용되지 않으면 컴파일할 필요가 없으므로 v-pre 디렉티브를 추가해 컴파일을 건너뛰게 함
```javascript
<script>
export default {
  data() {
    return {
      message: 'Hello, Vus JS',
    };
  },
}
</script>
<template>
  <div v-pre>{{ message }}</div>
</template>
```

#### v-bind
- HTML 태그의 contents가 아니라 attribute에 데이터를 연결하고 싶다면 `v-bind` 디렉티브를 사용해야 함
- data 옵션 속성으로 정의한 데이터 속성의 값을 `<template>` 태그 영역에서 HTML 태그의 속성 값으로 지정할 수 없다
- v-bind 디렉티브는 항상 HTML 태그의 속성 앞에 콜론(:)을 붙여 표시
```javascript
<script>
export default {
  data() {
    return {
      className: 'red-color',
    };
  },
}
</script>
<template>
  <h1 v-bind:class="className">안녕하세요</h1>
</template>
<style>
.red-color {
  color:red;
}
</style>
```
- `v-bind` 디렉티브를 간단하게 사용하기 위한 문법 형태로 축약형이 있다, v-bind 대신 `:`만 사용
```  
<template>
  <h1 :class="className">Hello, Vue Js</h1>
</template>
```

#### v-if
- `v-if`는 `<template>` 태그 영역에서 조건부 렌더링 기능을 구현하는 디렉티브
- 조건부 렌더링이란 디렉티브에 할당된 값의 참/거짓에 따라 HTML 요소를 렌더링하거나 렌더링하지 않는 것을 의미함
```javascript
<script>
export default {
  data() {
    return {
      visible: true,
      unvisible: false,
    };
  },
}
</script>
<template>
  <p v-if="visible">이 요소는 렌더링됩니다</p> <!-- 보임 --> 
  <p v-if="unvisible">이 요소는 렌더링되지 않습니다</p> <!-- 추가되지 않음 --> 
</template>
<style></style>
```
- 화면에 보이지 않는 요소는 DOM에 추가되지 않는다

#### v-else-if/v-else
- 각 조건에 맞는 값이 표시됨
```javascript
<script>
export default {
  data() {
    return {
      condition: 'B',
    };
  },
}
</script>
<template>
  <p v-if="condition === 'A'">condition 데이터의 값은 A입니다</p>
  <p v-else-if="condition === 'B'">condition 데이터의 값은 B입니다</p>
  <p v-else-if="condition === 'C'">condition 데이터의 값은 C입니다</p>
  <p v-else-if="condition === 'D'">condition 데이터의 값은 D입니다</p>
  <p v-else>어떤 조건에도 해당하지 않습니다</p>
</template>
```

#### v-show
- 조건부 렌더링 기능을 구현하는 디렉티브
- 디렉티브에 할당된 값의 참/거짓에 따라 `<template>` 태그 영역에 작성된 요소를 숨기거나 보여줌
```javascript
<script>
export default {
  data() {
    return {
      condition: true,
    };
  },
}
</script>
<template>
  <p v-show="condition">v-show 디렉티브는 조건이 참입니다</p>
  <p v-show="!condition">v-show 디렉티브는 조건이 거짓입니다</p>
</template>
```
- `v-show`는 `v-if`와 다르게 요소를 렌더링하고 CSS의 display 속성으로 감춘다

#### v-cloak
- 뷰 애플리케이션의 렌더링 과정에서 데이터 바인딩이 완료되기 전에 데이터가 화면에 노출되는 것을 막기위해 사용
- NPM 방식으로 뷰 애플리케이션을 개발할 때는 잘 느끼지 못하지만, CDN 방식으로 뷰 애플리케이션을 개발하면 초기에 뷰 패키지를 로딩하고 적용하는데 시간이 걸린다
- Vue가 적용되기 전에 콧수염 문법이 보였다가 2초 뒤 Vue 패키지 적용이 끝나면 설정한 데이터로 변경됨
```html
<!DOCTYPE html>
<html lang="">
  <head>
    <meta charset="UTF-8">
    <link rel="icon" href="/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vite App</title>
  </head>
  <body>
    <div id="app">
      <h1>{{ message }}</h1>
    </div>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
    <script>
      const { createApp } = Vue;
      window.setTimeout(() => {
        createApp({
          data() {
            return {
              message: 'Hello Vue!',
            };
          },
        }).mount('#app');
      }, 2000);
    </script>
    <!-- <script type="module" src="/src/main.js"></script> -->
  </body>
</html>
```

- v-cloak 디렉티브는 Vue 패키지가 로딩되어 뷰 애플리케이션에 적용되면 자체적으로 v-cloak 디렉티브를 삭제한다
- 그래서 CSS와 함께 사용하면 Vue가 적용되기 전 바인딩되지 않은 모습을 효과적으로 감출 수 있다
```html
<!DOCTYPE html>
<html lang="">
  <head>
    <meta charset="UTF-8">
    <link rel="icon" href="/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vite App</title>
  </head>
  <body>
    <style>
      [v-cloak] {
        display: none;
      }
    </style>
    <div id="app">
      <h1 v-cloak>{{ message }}</h1>
    </div>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
    <script>
      const { createApp } = Vue;
      window.setTimeout(() => {
        createApp({
          data() {
            return {
              message: 'Hello Vue!',
            };
          },
        }).mount('#app');
      }, 2000);
    </script>
    <!-- <script type="module" src="/src/main.js"></script> -->
  </body>
</html>
```

#### v-for
- Vue에서 반복적으로 렌더링하는 HTML 요소를 생성하는데 사용
- 배열과 객체를 사용할 때 형식이 각각 다르다
```javascript
v-for="값 in 배열" key="고유값"
v-for="(값, 인덱스) in 배열" key="고유값"
```

- 배열을 반복해서 출력할 때는 key 속성에 고유한 값을 할당하기 위한 용도로 index를 사용
```html
<script>
export default {
  data() {
    return {
      fruits: ['apple', 'banana', 'ornage'],
    };
  },
}
</script>
<template>
  <h1>fruits 데이터의 반복 결과</h1>
  <ul>
    <li v-for="(fruit, index) in fruits" :key="index">
      인덱스 : {{ index }}, 값: {{ fruit }}
    </li>
  </ul>
</template>
```

- `<li>` 태그 부분의 key 속성을 그냥 쓰면 안됨, 그러면 <li> 태그의 key 속성의 앖이 모두 문자열 index로 똑같아진다
- 요소를 반복하면서 얻는 index를 key 속성에 바인딩해서 서로 다른 값을 가지게 하는 것이 목적.
- 그래서 key 속성에 값을 할당할 때는 `v-bind` 디렉티브(축약형 :)을 사용해야 한다
- 사용하지 않으면 v-for 디렉티브로 반복되는 `<li>` 태그는 모두 key 속성의 값으로 문자열 index를 가지게 된다
- `v-bind` 디렉티브를 사용해야 key 속성의 값이 반복될 때마다 0, 1, 2가 된다
```html
<script>
export default {
  data() {
    return {
      user: {
        name: 'John',
        age: 20,
        gender: 'male',
      }
    };
  },
}
</script>
<template>
  <h1>fruits 데이터의 반복 결과</h1>
  <ul>
    <li v-for="(value, key, index) in user" :key="index">
      {{ index }} : {{ key }} : {{value}} 
    </li>
  </ul>
</template>
<style></style>
```

### 이벤트 다루기
- 자바스크립트에서 event는 사용자와 상호작용해서 발생하는 일련의 사건을 말한다
- 대표적으로 마우스를 클릭하거나 드래그하는 마우스 관련 이벤트와 키보드를 사용할 때 발생하는 키보드 관련 이벤트가 있다
- 자바스크립트는 이벤트를 다룰 때 document 객체의 여러 속성과 메서드를 조합해서 사용해야 한다
- 하지만 Vue에서는 자바스크립트보다 쉽게 이벤트를 다룰 수 있다

#### v-on 디렉티브와 methods 옵션 속성으로 이벤트 연결하기
```
v-on:이벤트_타입="이벤트_핸들러"
```
- 여기서 이벤트 타입은 `click`, `keyup`, `keydown`과 같이 이벤트 종류를 식별하는 문자열로 자바스크립트와 개념이 같다
- 이벤트 핸들러는 이벤트 타입과 일치하는 이벤트가 발생하면 실행되는 함수
```html
<script>
export default {
  methods: {}, // 메서드 정의
}
</script>
```

##### Vue 애플리케이션에서 버튼 요소에 클릭 이벤트를 연결
```html
<script>
export default {
  methods: {
    clickHandler() {
      alert('click');
    },
  },
}
</script>
<template>
  <button type="button" v-on:click="clickHandler">클릭</button>
</template>
```

##### 더블 클릭 이벤트 발생
```html
<script>
export default {
  methods: {
    clickHandler() {
      alert('click');
    },
  },
}
</script>
<template>
  <button type="button" v-on:dblclick="clickHandler">클릭</button>
  <!-- <button type="button" @dblclick="clickHandler">클릭</button> -->
</template>
<style></style>
```

#### 함수
- 어떤 작업을 수행하는 독립적인 코드 단위
- 특정한 작업을 수행하도록 설계되며, 입력 값(인자)를 받아 처리한 후 결과 값을 반환
- 함수는 특정 객체에 속하지 않고 독립적으로 존재
```javascript
function add(a, b) {
  return a + b;
}
```

#### 메서드
- 객체에 속성에 할당된 함수
- 객체의 데이터와 행위를 결합하는 객체지향 프로그램의 핵심 중 하나
```javascript
const calculaotr = {
  add(a, b) {
    return a + b;
  }
}
```

#### 이벤트 객체 사용하기
- 자바스크립트에서 이벤트 객체는 특정 이벤트에 대한 상세 정보를 가지고 있는 객체를 의미함
- Vue에서는 이벤트 핸들러의 매개변수로 `$event`를 전달하면 이벤트 객체를 사용할 수 있다
```html
<script>
export default {
  methods: {
    clickHandler() {
      console.log(event);
    },
  },
}
</script>
<template>
  <button type="button" @click="clickHandler($event)">클릭</button>
</template>
```

##### 화살표 함수 사용하는 방법
```html
<script>
export default {
  methods: {
    clickHandler() {
      console.log(event);
    },
  },
}
</script>
<template>
  <button type="button" @click="($event) => clickHandler($event)">클릭</button>
</template>
```

#### 수식어(modifier) 사용하기
- 수식어는 이벤트 처리 방식을 제어하는데 사용하는 기능
- 수식어를 사용하면 일반적인 DOM 이벤트 동작을 변경하거나 기능을 추가할 수 있다
```
@이벤트_타입.수식어
```


##### keyup 이벤트는 이벤트 객체를 사용해 `Enter` 키 입력을 확인함
```html
<script>
export default {
  methods: {
    onKeyupHandler(e) {
      if (e.keyCode === 13) { // 키보드 이벤트 객체에서 keyCode 속성 13은 Enter키
        console.log('Enter!');
      }
    },
  },
}
</script>
<template>
  <input type="text" @keyup="($event) => onKeyupHandler($event)" />
</template>
```

##### Vue에서 제공하는 수식어 사용하면 코드가 간단해 짐
```javascript
<script>
export default {
  methods: {
    onKeyupHandler() {
      console.log('Enter!');
    },
  },
}
</script>
<template>
  <input type="text" @keyup.enter="onKeyupHandler" />
</template>
```

##### 이벤트 수식어
- .stop: 이벤트 전파를 상위 요소로 전달하지 않음(이벤트 버블링 금지)
- .prevent: 기본 이벤트 제거
- .self: 이벤트가 발생한 요소 자체에서만 이벤트 처리
- .capture: 이벤트 캡처링 활성화
- .once: 이벤트 발생을 한 번으로 제한
- .passvie: 스크롤 동작을 기다리지 않고 즉시 처리

##### 키보드 입력 키 수식어
- .ener: `Enter` 키를 눌렀을 떄 이벤트 처리
- .tab: `Tab` 키를 누렀을 때 이벤트 처리
- .delete: `Del`키나 `backspace` 키를 눌렀을 때 처리
- .esc: `Esc` 키를 눌렀을 때 처리
- .space: `space` 키를 눌렀을 때 이벤트 처리
- .up: `↑` 키를 눌렀을 때 이벤트 처리
- .down: `↓` 키를 눌렀을 때 이벤트 처리
- .left: `←` 키를 눌렀을 때 이벤트 처리
- .right: `→` 키를 눌렀을 때 이벤트 처리

##### 시스템 입력 키 수식어
- .ctrl: `Ctrl` 키를 눌렀을 때 이벤트 처리
- .alt: `Alt` 키를 눌렀을 때 이벤트 처리
- .shift: `Shift` 키를 눌렀을 때 이벤트 처리
- .meta: 메타키(`Win`/`command`)를 눌렀을 때 이벤트 처리

##### 특별 수식어
- .exact: 키 이벤트 처리 시 특정 키 조합만을 처리하는데 사용

##### 마우스 버튼 수식어
- .left: 마우스 왼쪽 버튼을 클릭했을 때 이벤트 처리
- .right: 마우스 오른쪽 버튼을 클릭했을 때 이벤트 처리
- .middle: 마우스 가운데(휠) 버튼을 클릭했을 때 이벤트 처리

### 이벤트와 반응성(reactivity)
- `반응성`은 데이터의 변화를 감지하고 자동으로 화면 UI를 업데이트하는 기능
- Vue에서는 자체적으로 반응성 시스템을 사용해 데이터 변화를 감지하도록 구성되어 있다
- `반응성 시스템`은 데이터 변화를 감지하고 업데이트하는 기능을 제공하는 시스템을 가리킴
- 이런 반응성은 Vue에서 이벤트가 발생했을 때 동작하는 경우가 많다
- **Vue는 메서드에서 데이터 속성을 참조할 때 `this` 키워드를 사용**
- Vue 애플리케이션은 값이 바뀌면 이를 감지하고 화면은 다시 렌더링함, 이 과정에서 웹 브라우저는 새로고침이 발생하지 않는다 -> Vue의 반응성 때문

##### 증가 버튼을 누를 때마다 1씩 증가
```html
<script>
export default {
  data() {
    return {
      number: 0,
    };
  },

  methods: {
    increasement() {
      this.number++;
    },
  },
}
</script>
<template>
  <h1>{{ number }}</h1>
  <button type="button" @click="increasement">증가</button>
</template>
```

#### v-once 디렉티브로 화면 업데이트 막기
- Vue는 반응성 시스템이 구현되어 값이 변경되면 자동으로 감지하고 화면을 업데이트 함
- 하지만 경우에 따라 값을 변경하여도 화면을 업데이트하고 싶지 않을 때가 있다
- 이럴 때 `v-once` 디렉티브를 사용한다
- `v-once` 디렉티브는 정적 디렉티브로, 이를 사용하면 어떠한 요소든지 한 번만 렌더링하고 이후에는 렌더링하지 않는다

```html
<script>
export default {
  data() {
    return {
      number: 0,
    };
  },

  methods: {
    increasement() {
      this.number++;
    },
  },
}
</script>
<template>
  <h1 v-once>{{ number }}</h1>
  <button type="button" @click="increasement">증가</button>
</template>
```

#### v-memo 디렉티브로 렌더링 결과 저장
- v-memo 디렉티브는 Vue 3.2 이상에서 사용 가능
- memoization 기술로 `<template>` 태그의 구성 요소를 효율적으로 렌더링하고 싶을 때 사용
- memoization이란 이전에 계산한 결과를 저장해 중복 계산을 피하고 실행 속도를 향상시키는 프로그래밍 기술
- `<template>` 태그에서 반복해서 렌더링되는 요소에 v-memo 디렉티브를 사용해 렌더링 결과를 저장하면 렌더링이 반복되는 것을 방지해 실행 속도를 향상할 수 있다
- v-memo 디렉티브는 1,000번 이상 반복되는 요소에 사용하면 효과를 볼 수 있다고 적혀 있어, 효과가 직접적으로 드러나지 않아 최적화하기 위한 용도로만 사용하면 된다

```
<태그 v-memo="[조건1, 조건2, ...]"></태그>
```

```html
<script>
export default {
  data() {
    return {
      name: '철수',
      gender: '남자',
      age: 20,
    };
  },
}
</script>
<template>
  <div v-meno="[name, gender]">
    <p>이름: {{ name }}</p>
    <p>성별: {{ gender }}</p>
    <p>나이: {{ age }}</p>
  </div>
  <button @click="name = '영희'">이름 변경</button>
  <button @click="gender = '여자'">성별 변경</button>
  <button @click="age = '30'">나이 변경</button>
</template>
```
- `이름 변경`과 `성별 변경` 버튼을 누르면 v-memo 디렉티브가 사용된 요소가 다시 렌더링된다
- `나이 변경` 버튼을 누르면 v-memo 디렉티브의 조건이 아니라서 실제 데이터는 변경된 상태지만 화면은 다시 렌더링되지 않는다

## 폼(form) 다루기
- 프런트엔드에서 폼 관련 요소는 사용자에게 갑을 입력받아 서버로 전송하기 위해 사용
- 서버로 전송된 값을 처리하는 것은 백엔드지만, 서버로 전송하는 것은 프런트엔드에서 처리해야 한다
1. `<form>` 태그에서 입력받은 값을 `<form>` 태그의 action 속성에 지정된 경로로 전송해 처리하는 방법
    - 사용자가 값을 입력한 페이지에서 다른 페이지로 이탈해 버린다는 단점 존재
    - 단점이 있지만, 입력 값을 전송하는 가장 간단한 방법
    ```html
    <form action="/login_process.php">
        <label for="uid">아이디: <input type="text" id="uid"></label>
        <label for="upw">비밀번호: <input type="text" id="upw"></label>
        <button type="submit">로그인</button>
    </form>
    ```
2. 자바스크립트로 가져와서 AJAX(Asynchronous JavaScript And XML)를 사용해 전송하는 방법
- 사용자 입력 데이터를 전송하면서 페이지를 이동하지 않아도 되어 데이터를 전송한 후 처리 방법의 자유도가 높다
- AJAX가 등장한 이후부터 대부분 AJAX 기술을 사용해 폼 데이터를 처리한다
- Vue에서도 사용자가 입력한 값을 가져와 별도의 처리 함수에서 AJAX 기술로 데이터를 전송한다
    ```html
    <form id="loginForm">
        <label for="uid">아이디: <input type="text" id="uid"></label>
        <label for="upw">비밀번호: <input type="text" id="upw"></label>
        <button type="submit">로그인</button>
    </form>
    <script>
        docuemnt.getElementById('loginForm').addEventListener('submit', function (event) {
            event.provenDefault(); // 폼 전송 이벤트 취소

            // 요소에 입력된 값 가져오기
            const uid = document.getElementById('uid').value;
            const upw = document.getElementById('upw').value;

            // AJAX 요청 만들기
            const xhr = new XMLHttpRequest();
            xhr.open('POST', '/login_process.php', true);

            // AJAX 응답 설정
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        // 요청이 성공할 경우
                        const response = xhr.responseText;
                        console.log(response);
                    } else {
                        // 요청이 실패할 경우
                        console.error("Request faild with status " + xhr.status);
                    }
                }
            };

            // 데이터 전송 준비하기
            const formData = new FormData();
            formData.append('uid', uid);
            formData.append('upw', upw);

            // AJAX로 데이터 전송 요청
            xhr.send(formData);
        });
    </script>
    ```

### v-model 디렉티브로 폼 요소 다루기
- Vue에서는 입력한 요소의 값을 가져올 때 v-model 디렉티브를 사용한다
- v-model 디렉티브는 `<script>` 태그 영역에 정의한 데이터 속성과 `<template>` 태그 영역에 작성한 HTML 요소가 양방향으로 서로 연결되어 데이터 속성의 값을 자동으로 업데이트한다 => 양방향 데이터 바인딩

#### 한 줄 입력 요소 값 가져오기
```html
<script>
export default {
  data() {
    return {
      uid: '',
      upw: '',
    };
  },
  methods: {
    login() {
      console.log(`id: ${this.uid}`);
      console.log(`pw: ${this.upw}`);
    },
  },
}
</script>
<template>
  <form id="loginForm">
    <label for="uid">아이디: <input type="text" id="uid" v-model="uid"></label>
    <label for="upw">비밀번호: <input type="password" id="upw" v-model="upw"></label>
    <button type="button" @click=login>로그인</button>
  </form>
</template>
```

<br>

- Vue는 양방향 데이터 바인딩이라서 v-model 디렉티브로 바인딩한 데이터에 초깃값이 있으면 입력 요소도 해당 초깃값으로 보이게 됨
```html
<script>
export default {
  data() {
    return {
      uid: '초기값',
      upw: '',
    };
  },
  methods: {
    login() {
      console.log(`id: ${this.uid}`);
      console.log(`pw: ${this.upw}`);
    },
  },
}
</script>
<template>
  <form id="loginForm">
    <label for="uid">아이디: <input type="text" id="uid" v-model="uid"></label>
    <label for="upw">비밀번호: <input type="password" id="upw" v-model="upw"></label>
    <button type="button" @click=login>로그인</button>
  </form>
</template>
```

#### 여러 줄 입력 요소의 값 가져오기
- 여러 줄 입력 요소는 `<textarea>` 태그로 만든다
- `<textarea>` 태그도 v-model 디렉티브를 사용하면 초깃값을 초기 렌더링 화면에서 보여주거나 (`<script`> -> `<template>`) 사용자가 입력한 값을 업데이트(`<template>` -> `<script>`) 할 수 있다
```html
<script>
export default {
  data() {
    return {
      message: '',
    };
  },
  methods: {
    printData() {
      console.log(`id: ${this.message}`);
    },
  },
}
</script>
<template>
  <form id="loginForm">
    <textarea v-model="message"></textarea>
    <button type="button" @click=printData>데이터 출력</button>
  </form>
</template>
```

#### 체크박스 요소에서 값 가져오기
- `<input>` 태그에서 type 속성의 값을 checkbox로 지정한 요소를 의미
- 사용자는 체크박스 요소에 체크 표시를 하거나, 표시를 하지 않도록 상호작용 할 수 있다
- 체크박스 요소도 v-model 디렉티브를 사용하면 양방향 데이터를 바인딩 할 수 있다

##### 연결된 데이터 fruits의 초깃값이 논리형 값 중 하나인 true면 초기에 체크 표시된 상태로 해당 데이터를 렌더링할 수 있다
```html
<script>
export default {
  data() {
    return {
      fruits: true,
    };
  },
}
</script>
<template>
  <form id="loginForm">
    <label for="banana">
      <input type="checkbox" id="banana" v-model="fruits" value="banana" />banana
    </label>
  </form>
</template>
```

<br>

- 체크박스 요소는 보통 사용자에게 복수 선택지를 제공하는 용도로 사용
- v-model 디렉티브로 바인딩할 데이터를 배열로 만든다
- 배열에 데이터와 연결할 체크박스 요소의 value 속성 값을 넣어주면 해당 체크박스 요소를 초기에 체크 표시된 상태로 렌더링할 수 있다
```html
<script>
export default {
  data() {
    return {
      fruits: ['banana', 'orange'],
    };
  },
  methods: {
    printData() {
      console.log(this.fruits); // 선택된 입력 요소의 value 속성 값 출력
    }
  },
}
</script>
<template>
  <form id="loginForm">
    <label for="banana">
      <input type="checkbox" v-model="fruits" value="banana" />banana
    </label>
    <label for="orange">
      <input type="checkbox" v-model="fruits" value="orange" />orange
    </label>
    <label for="apple">
      <input type="checkbox" v-model="fruits" value="apple" />apple
    </label>
    <button type="button" @click="printData">확인</button>
  </form>
</template>
```
- v-model에 바인딩된 fruits 데이터 속성이 banana, ornage를 값으로 가지므로 이와 일치하는 `value` 속성의 값을 가진 체크박스에 표시된 상태로 화면에 렌더링된다
- v-model 디렉티브로 양방향 데이터 바인딩되므로 value 속성의 값을 데이터 속성 배열의 값으로 추가하거나 삭제할 수 있다

#### 라디오 버튼 요소
- `<input>` 태그의 type 속성 값을 `radio`로 지정하면 만들 수 있다
- 라디오 버튼 요소는 체크박스 요소와 다르게 1개만 선택할 수 있다
- v-model 디렉티브로 바인딩할 데이터 속성의 값이 value 속성의 값과 일치하면 체크 표시된 상태로 렌더링됨
```html
<script>
export default {
  data() {
    return {
      gender: 'male',
    };
  },
  methods: {
    printData() {
      console.log(this.gender); // 선택된 입력 요소의 value 속성 값 출력
    }
  },
}
</script>
<template>
  <form id="loginForm">
    <label for="male">
      <input type="radio" v-model="gender" value="male" />male
    </label>
    <label for="female">
      <input type="radio" v-model="gender" value="female" />female
    </label>
    <button type="button" @click="printData">확인</button>
  </form>
</template>
```
- 데이터와 `value` 속성의 값이 일치하는 male 라디오 버튼 요소만 체크 표시된 상태로 렌더링된다
- 값을 변경하고 [확인] 버튼을 누를 때마다 선택한 라디오 버튼의 value 속성 값이 자동으로 데이터에 업데이트되는 것을 확인할 수 있다

#### 콤보박스 요소
- `<select>` 태그와 `<option>` 태그로 만들며, 주로 드롭다운 목록에서 여러 값 중 하나를 선택하기 위해 사용한다
- v-model 디렉티브를 사용하면 콤보박스 요소도 양방향 데이터 바인딩을 처리할 수 있다

```html
<script>
export default {
  data() {
    return {
      selectItem: 'cafeLatte', // value 속성의 값이 cafeLatte인 option 태그 선택
    };
  },
  methods: {
    printData() {
      console.log(this.selectItem);
    },
  },
}
</script>
<template>
  <form id="loginForm">
    <select v-model="selectItem">
      <option value="americano">아메리카노</option>
      <option value="espresso">에스프레소</option>
      <option value="cafeLatte">카페라떼</option>
    </select>
    <button type="button" @click="printData">확인</button>
  </form>
</template>
```
- value 속성의 값이 cafeLatte인 `<option>` 태그가 선택되어 있다
- 선택한 `<option>` 태그의 value 속성의 값이 v-model 디렉티브에 연결된 데이터에 자동으로 업데이트된다

#### v-model 디렉티브 사용 시 주의사항
- Vue에서 사용자 입력 요소를 다룰 때, 대부분 `v-model` 디렉티브를 사용하면 된다
- 밑의 코드는 v-model 디렉티브로 양방향 데이터 바인딩한다, 한 줄 입력 요소에 텍스트를 입력하면 v-model 디렉티브에 바인딩한 message 데이터 속성의 값이 실시간으로 변경된다
```html
<script>
export default {
  data() {
    return {
      message: '',
    };
  },
}
</script>
<template>
  <input type="text" v-model="message" />
  {{ message }}
</template>
```
- 영문을 입력하면 실시간으로 데이터가 표시된다
- 한글을 입력하면 예를 들어 6글자를 입력했는데 5글자만 보이는 문제가 발생한다
  - 한글이나 한자처럼 글자를 조합해서 단어를 만다는 문자는 IME(Input Method Editor)를 사용하는데 이때 발생하는 문제이다
- 실시간으로 글자 수를 확인해야 할 때는 v-model 디렉티브를 사용할 수 없어, 이벤트를 사용해 수동으로 데이터를 업데이트 해야한다

##### input 이벤트
- 입력 요소의 값이 변경될 때 발생하는 이벤트
- 입력 요소의 값이 바뀌는 것을 실시간으로 확인할 수 있다
- v-model 디렉티브는 한글, 한자처럼 IME가 필요한 문자는 값이 한 글자씩 늦게 인식되는 경우에 `input` 이벤트를 사용해 해결할 수 있다
```html
<script>
export default {
  data() {
    return {
      message: '',
    };
  },
  methods: {
    onChangeHandler($event) {
      this.message = $event.target.value;
    },
  },
}
</script>
<template>
  <input type="text" @input="onChangeHandler($event)" />
  {{ message }}
</template>
```
- 입력 요소에 값이 변경됐을 때 v-model 디렉티브 대신에 `input` 태그를 사용해 이벤트 핸들러 함수를 호출한다
- 이벤트 핸들러 함수에서는 이벤트 객체를 전달받아 입력 요소의 값을 데이터에 반영하고, 이렇게 하면 한글 입력도 문제없이 실시간으로 업데이트된다.

##### change 이벤트
- 폼 요소의 값이 변경되면 발생하는 이벤트
- `<input>`, `<select>`, `<textarea>` 태그로 만든 폼 관련 요소에서 사용
- `<select>` 태그로 만들 수 있는 콤보박스 요소에서 가장 많이 사용함
- 예를 들어, 콤보박스에서 사용자가 선택한 값에 따른 추가 작업이 필요할 때 change 이벤트를 사용하면 효과적으로 처리할 수 있다

```html
<script>
export default {
  data() {
    return {
      selected: 'banana',
      price: 500,
    };
  },
  methods: {
    onChangeHandler($event) {
      if (this.selected === 'banana') {
        this.price = 500;
      }
      if (this.selected === 'apple') {
        this.price = 700;
      }
    },
  },
}
</script>
<template>
  <select v-model="selected" @change="onChangeHandler">
    <option value="banana">바나나</option>
    <option value="apple">사과</option>
  </select>
  가격: {{ price }}원
</template>
```
- 사용자가 콤보박스로 선택한 값은 v-model 디렉티브로 양방향 데이터 바인딩만 해도 알 수 있다
- 하지만 선택한 값에 따라 가격을 다르게 나타내는 것은 v-model 디렉티브만으로는 할 수 없다
- 이럴 때 `change` 이벤트를 사용하면 사용자가 선택한 값에 따른 처리를 추가할 수 있다

##### submit 이벤트
- `<form>` 태그에 사용한 폼 요소의 데이터를 서버로 전송하는 시점에서 발생하는 이벤트
- 일반적으로 `<form>` 태그는 submit 이벤트가 발생할 때 action 속성에 명시된 주소로 페이지를 이동한다
- 그런데 Vue에서는 페이지 이동 없이 AJAX 기술을 사용해 폼 데이터를 전송하기 때문에 이벤트 객체의 `preventDafault()` 메서드를 함께 사용한다
```html
<script>
export default {
  methods: {
    onSubmitHandler(e) {
      e.preventDefault();

      // 별도의 폼 전송 처리
      console.log('onSubmit Handler!');
    },
  },
}
</script>
<template>
  <form @submit="onSubmitHandler">
    <button type="submit">전송</button>
  </form>
</template>
```
- [전송] 버튼을 누르면 `<form>` 태그의 기본 전송 이벤트가 실행되지 않고 `onSubmitHandler()` 메서드의 값이 출력됨


##### keyup 이벤트
- 입력 요소에서 키보드의 키를 눌렀다가 뗐을 때 발생하는 이벤트
- 주로 사용자의 키 입력에 따라 코드를 동적으로 처리해야 하는 경우에 유용
- 입력한 값에 초점을 맞춤
```html
<script>
export default {
  methods: {
    onKeyupHandler() {
      console.log(`keyup event!`);
    }
  },
}
</script>
<template>
  <input type="text" @keyup="onKeyupHandler" />
</template>
```

##### keydown 이벤트
- 키를 눌렀을 때 발생
- 입력한 키의 종류(`Esc`키를 눌렀는지, `Shift` 키를 눌렀는지)에 초점을 맞춤

##### keypress 이벤트
- 키를 누르고 있을 때 발생

## 계산된 속성과 감시자 속성
- Vue에서 데이터와 상호작용하는 강력한 기능

### 계산된 속성(computed)
- 옵션스 API에서 제공하는 속성 중 하나로, computed 옵션 속성으로 정의해 사용할 수 있다.
- computed 옵션 속성은 컴포넌트에서 자주 사용하는 데이터를 캐시(데이터를 메모리 같은 곳에 임시로 저장하는 것)해 애플리케이션의 성능을 향상시키는데 목적이 있다

<br>

- `<h1>` 태그 2개에 lastName, firstName 데이터 속성의 값을 각각 출력
- Vue 애플리케이션은 `<template>` 태그에 데이터를 바인딩할 때마다 각 데이터의 속성의 값을 참조한다
- 또한, 성과 이름을 모두 보여주려면 두 데이터를 모두 참조해야 하므로 번거롭다
```html
<script>
export default {
  data() {
    return {
      firstName: 'Gildong',
      lastName: 'Hong',
    };
  },
}
</script>
<template>
  <h1>{{ lastName }} {{ firstName }} </h1>
  <h1>{{ lastName }} {{ firstName }} </h1>
</template>
```

<br>

- `<computed>` 옵션 속성은 함수를 값으로 가지는 methods 옵션 속성과 같은 속성을 값으로 가진다
- `<computed>` 옵션 속성에 정의한 함수는 내부에서 항상 데이터를 참조하는데, 한 번 참조한 데이터는 값이 변경되기 전까지 computed 옵션 속성에 의해 캐싱된다
```html
<script>
export default {
  data() {
    return {
      firstName: 'Gildong',
      lastName: 'Hong',
    };
  },
  computed: {
    fullName() {
      console.log(`computed fullname`);
      return `${this.lastName} ${this.firstName}`;
    }
  }
}
</script>
<template>
  <h1>{{ fullName }}</h1>
  <h1>{{ fullName }}</h1>
</template>
```
- `<h1>` 태그로 두 번에 걸쳐 fullName 데이터 속성을 참조하지만, 콘솔에는 한 번만 출력된다
- 이는 fullName 데이터 속성을 `<template>` 태그 영역에 출력하기 위해 한 번만 접근하고, 이후에는 캐싱된 값을 가져왔기 때문 -> fullName 데이터 속성에 다시 접근하지 않았음을 보여주는 근거


#### 꼭 캐싱이 목적이 아니라도 `computed` 옵션 속성으로 데이터를 미리 만들어놓으면 코드의 가독성을 훨씬 높일 수 있다
- 숫자 배열에서 짝수만 찾아 총합을 출력하는 코드
- `filter()`와 `reduce()` 메서드를 사용하면 배열 요소 중 짝수만 필터링해서 합을 구할 수 있다

<br>

- 콧수염 문법이 매우 복잡하고 가독성 떨어짐,
- Vue에서는 `<template>` 태그 영역에 사용하는 콧수염 문법을 간단히 작성하도록 권고
```html
<script>
export default {
  data() {
    return {
      numArr: [1, 2, 3, 4, 5],
    };
  },
}
</script>
<template>
  <h1>{{ numArr.filter((v) => v % 2 === 0).reduce((acc, cur) => acc + cur, 0) }}</h1>
</template>
```

<br>

- `computed` 옵션을 사용하면 캐싱도 되고 가독성도 높일 수 있다
```html
<script>
export default {
  data() {
    return {
      numArr: [1, 2, 3, 4, 5],
    };
  },
  computed: {
    evenSum() {
      return this.numArr
      .filter((v) => v % 2 === 0)
      .reduce((acc, cur) => acc + cur, 0);
    }
  }
}
</script>
<template>
  <h1>{{ evenSum }}</h1>
</template>
```