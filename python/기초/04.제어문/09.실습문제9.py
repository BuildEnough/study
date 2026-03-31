while (True):
    password = input("비밀번호를 입력하세요: ")
    if (password == "1234"):
        print("로그인 성공")
        break
    else:
        print("로그인 실패")