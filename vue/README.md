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
vue cretae 폴더_이름
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
- index.html 파일은 다시 main.js 파일을 불러오고 index.html 파일에서 id 속성의 값이 app인 div 요소에 root 컴포넌트를 추가합니다.
- 이 과정을 거쳐 App.vue 파일에 작성된 코드가 웹 브라우저에서 주소를 입력했을 때 보게되는 vue application의 첫 화면이 됩니다