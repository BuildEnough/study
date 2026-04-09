# Git pull, merge, rebase 정리 + stash 활용 방법

Git 작업 중 아래와 같은 상황이 자주 생깁니다.

- 작업 중인 파일 수정 내용은 아직 커밋하고 싶지 않다.
- 그런데 원격 저장소의 최신 내용을 먼저 반영해야 한다.
- 가능하면 히스토리는 깔끔하게 유지하고 싶다.

---

## 1. 작업 중인 변경사항이 있을 때 원격 최신 내용을 반영하는 방법

### 사용한 명령어

```bash
# 수정파일 아직 올리고 싶지 않으면
git stash

# 원격 최신 반영 + 내 커밋 재배치
git pull --rebase origin master

# 내 커밋 push
git push origin master

# 숨겨둔 작업 복원
git stash pop
```

---

## 상황 설명

다음과 같은 상황에서 이 방법을 사용할 수 있습니다.

- 로컬에서 파일을 수정 중이다.
- 아직 커밋하고 싶지 않은 변경사항이 있다.
- 원격 저장소의 최신 내용을 먼저 받아와야 한다.
- merge commit을 남기기보다 히스토리를 깔끔하게 유지하고 싶다.

이럴 때 `stash`로 작업 내용을 잠시 숨기고, `pull --rebase`로 최신 내용을 반영한 뒤 다시 작업을 복원하면 편리합니다.

---

## 명령어별 설명

### 1) `git stash`

```bash
git stash
```

현재 작업 중이던 **커밋하지 않은 변경사항**을 임시로 숨겨둡니다.

#### 왜 필요한가?

`git pull --rebase`를 수행할 때 작업 중인 변경사항이 남아 있으면 rebase가 정상적으로 진행되지 않을 수 있습니다.  
그래서 먼저 현재 수정 내용을 잠시 치워두는 것입니다.

#### 참고

- 작업 내용이 삭제되는 것은 아닙니다.
- Git이 임시 저장해두었다가 나중에 다시 복원할 수 있습니다.

---

### 2) `git pull --rebase origin master`

```bash
git pull --rebase origin master
```

원격 저장소의 `master` 브랜치 최신 내용을 가져온 뒤, 내 로컬 커밋을 그 위에 다시 배치합니다.

#### 핵심 의미

- `pull` : 원격 내용을 가져온다.
- `--rebase` : 내 커밋을 최신 원격 커밋 뒤로 다시 정렬한다.

#### 왜 `--rebase`를 쓰는가?

일반 `git pull`은 상황에 따라 merge commit이 생길 수 있습니다.  
반면 `rebase`를 사용하면 커밋 흐름이 한 줄로 이어져서 비교적 깔끔한 히스토리를 유지할 수 있습니다.

---

### 3) `git push origin master`

```bash
git push origin master
```

최신 원격 내용을 반영한 뒤 내 커밋을 원격 저장소에 업로드합니다.

#### 의미

- 최신 내용을 먼저 반영하고
- 충돌을 해결한 뒤
- 정리된 커밋을 push 하는 과정입니다.

---

### 4) `git stash pop`

```bash
git stash pop
```

처음에 `stash`로 숨겨두었던 작업 내용을 다시 복원합니다.

#### 주의

- 복원 과정에서 충돌이 날 수도 있습니다.
- 충돌이 발생하면 내용을 확인해서 직접 수정해야 합니다.

#### `pop`과 `apply` 차이

- `git stash pop` : 복원 후 stash 목록에서 제거
- `git stash apply` : 복원만 하고 stash는 유지

조금 더 안전하게 확인하고 싶으면 `apply`를 먼저 쓰는 방법도 있습니다.

---

## 전체 흐름 요약

```bash
git stash
git pull --rebase origin master
git push origin master
git stash pop
```

### 흐름 해석

1. 커밋하지 않은 작업을 잠시 숨긴다.
2. 원격 최신 내용을 rebase 방식으로 반영한다.
3. 내 커밋을 push 한다.
4. 숨겨둔 작업을 다시 꺼내서 이어서 작업한다.

---

## 2. `pull`, `merge`, `rebase` 차이

이미지 내용을 참고해서 같이 정리하면 아래처럼 이해하면 됩니다.

---

## `git pull` 이란?

```bash
git pull
```

보통 내부적으로 아래 두 단계 중 하나로 동작합니다.

```bash
git fetch + git merge
```

또는

```bash
git fetch + git rebase
```

즉, `pull`은 단순히 "가져오기"만 하는 게 아니라,  
**원격 변경사항을 가져온 뒤 현재 브랜치에 반영까지 하는 명령어**입니다.

### 쉽게 말하면

`pull`은  
**"원격 내용을 가져오고(fetch), 현재 작업 브랜치에 합친다(merge 또는 rebase)"**  
라고 보면 됩니다.

---

## `merge` 란?

`merge`는 두 갈래로 나뉜 커밋 흐름을 하나로 합치는 방식입니다.

### 예시

```text
A -- B ---- M
 \        /
  -- C --
```

위 구조는 다음 의미입니다.

- `A`에서 시작해서 두 갈래로 나뉜다.
- 한쪽은 `B`로 진행되고
- 다른 한쪽은 `C`로 진행된다.
- 이후 `merge`를 하면 `M`이라는 병합 커밋이 생길 수 있다.

### 특징

- 두 브랜치를 합친다.
- 브랜치의 갈라진 흐름이 히스토리에 그대로 남는다.
- 상황에 따라 `merge commit`이 생성된다.
- 협업 중에는 흐름을 보존한다는 장점이 있다.

### 명령어 예시

```bash
git merge 브랜치명
```

예를 들어 현재 브랜치에서 `feature` 브랜치를 합치려면:

```bash
git merge feature
```

---

## `rebase` 란?

`rebase`는 내 커밋의 시작 위치를 다른 커밋 뒤로 옮겨서 히스토리를 다시 정렬하는 방식입니다.

### 예시 개념

기존:

```text
A -- B
 \
  C -- D
```

`rebase` 후:

```text
A -- B -- C' -- D'
```

### 의미

- 원래는 `A`에서 갈라져 작업한 `C`, `D` 커밋이 있었다.
- `rebase`를 하면 `B` 뒤로 옮겨서 다시 적용한다.
- 그래서 커밋 흐름이 한 줄처럼 보이게 된다.
- 이때 `C`, `D`는 실제로는 새로 만들어진 커밋이므로 `C'`, `D'`처럼 생각하면 이해하기 쉽다.

### 특징

- 히스토리가 직선형으로 정리된다.
- merge commit 없이 깔끔하게 보일 수 있다.
- 다만 이미 공유된 커밋을 rebase하면 협업 중 혼란이 생길 수 있다.

### 명령어 예시

```bash
git rebase 브랜치명
```

예를 들어 현재 브랜치를 `master` 위로 다시 정렬하려면:

```bash
git rebase master
```

---

## 3. `merge` 와 `rebase` 비교

### `merge`가 어울리는 경우

- 브랜치가 합쳐진 흔적을 남기고 싶을 때
- 협업 중 실제 병합 흐름을 그대로 보존하고 싶을 때
- 히스토리 구조를 그대로 유지하는 것이 더 중요할 때

### `rebase`가 어울리는 경우

- 커밋 히스토리를 깔끔하게 정리하고 싶을 때
- 내 로컬 작업을 최신 원격 커밋 뒤로 다시 붙이고 싶을 때
- merge commit을 줄이고 싶을 때

### 한 줄 비교

| 항목 | merge | rebase |
|---|---|---|
| 히스토리 형태 | 갈라진 흐름 유지 | 직선형으로 정리 |
| merge commit | 생길 수 있음 | 보통 없음 |
| 장점 | 실제 병합 이력 보존 | 히스토리가 깔끔함 |
| 주의점 | 히스토리가 복잡해질 수 있음 | 공유 커밋 재작성 주의 |

---

## 4. `git pull` 에서 `merge` 와 `rebase`의 차이

### 1) 일반 pull

```bash
git pull origin master
```

보통 fetch 후 merge 방식으로 반영될 수 있습니다.

개념적으로는 다음과 비슷합니다.

```bash
git fetch origin
git merge origin/master
```

#### 결과

- 원격 최신 내용을 가져온 뒤
- 현재 브랜치에 병합한다.
- 경우에 따라 merge commit이 생길 수 있다.

---

### 2) rebase 방식 pull

```bash
git pull --rebase origin master
```

개념적으로는 다음과 비슷합니다.

```bash
git fetch origin
git rebase origin/master
```

#### 결과

- 원격 최신 내용을 가져온 뒤
- 내 로컬 커밋을 그 뒤에 다시 붙인다.
- 히스토리가 더 직선적으로 정리된다.

---

## 5. 왜 이 상황에서 `stash + pull --rebase`를 썼는가

처음 상황을 다시 보면 다음과 같습니다.

- 수정한 파일이 있는데 아직 커밋하고 싶지 않다.
- 그런데 원격 저장소 최신 내용은 먼저 반영해야 한다.
- 내 커밋 이력은 깔끔하게 유지하고 싶다.

이럴 때 아래 흐름이 잘 맞습니다.

```bash
git stash
git pull --rebase origin master
git push origin master
git stash pop
```

### 이유

#### `git stash`

작업 중인 수정사항을 잠시 치워서 rebase 가능 상태를 만든다.

#### `git pull --rebase`

원격 최신 내용을 먼저 반영하고, 내 커밋을 뒤로 재배치해서 히스토리를 깔끔하게 만든다.

#### `git push`

반영이 끝난 내용을 원격에 올린다.

#### `git stash pop`

처음에 숨겨둔 작업을 다시 이어서 진행한다.

---

## 6. 주의사항

### 1) 기본 브랜치 이름 확인

저장소에 따라 기본 브랜치 이름이 `master`가 아니라 `main`일 수 있습니다.

예시:

```bash
git pull --rebase origin main
git push origin main
```

---

### 2) rebase 중 충돌이 날 수 있음

충돌이 발생하면 보통 아래처럼 진행합니다.

```bash
# 충돌 파일 수정
git add .

# rebase 계속 진행
git rebase --continue
```

중단하고 싶다면:

```bash
git rebase --abort
```

---

### 3) stash 복원 시에도 충돌 가능

`git stash pop` 이후에도 충돌이 발생할 수 있습니다.  
복원 후에는 반드시 변경사항을 확인하는 것이 좋습니다.

---

### 4) 이미 공유된 커밋 rebase 주의

다른 사람과 이미 공유한 커밋을 rebase하면 커밋 해시가 바뀌어서 협업 중 혼란이 생길 수 있습니다.  
보통은 **내 로컬 작업 정리용**으로 rebase를 사용하는 것이 안전합니다.

---

## 7. 예시 시나리오

### 상황

- 로컬에서 작업 중인 수정 파일이 있다.
- 아직 커밋은 하지 않았다.
- 팀원이 원격 브랜치에 최신 내용을 push 해두었다.
- 나는 최신 내용을 먼저 반영한 뒤 작업을 이어가고 싶다.

### 진행

```bash
git stash
git pull --rebase origin master
git push origin master
git stash pop
```

### 결과

- 작업 중이던 수정사항은 안전하게 임시 보관된다.
- 원격 최신 내용이 먼저 반영된다.
- 커밋 히스토리는 비교적 깔끔하게 유지된다.
- 이후 원래 하던 작업을 다시 이어갈 수 있다.

---

## 8. 최종 정리

### `pull`

원격 내용을 가져와서 현재 브랜치에 반영하는 명령어  
즉, 내부적으로는 `fetch + merge` 또는 `fetch + rebase`

### `merge`

두 갈래의 브랜치 흐름을 합치는 방식  
필요하면 merge commit 생성

### `rebase`

내 커밋을 다른 커밋 뒤로 옮겨서 히스토리를 다시 정리하는 방식  
직선형 히스토리를 만들기 좋음

### 이번 상황의 핵심 해결 흐름

```bash
git stash
git pull --rebase origin master
git push origin master
git stash pop
```

### 한 줄 요약

**커밋하지 않은 작업은 stash로 잠시 숨기고, 원격 최신 내용은 rebase로 반영한 뒤, 다시 작업을 복원하는 방식이다.**