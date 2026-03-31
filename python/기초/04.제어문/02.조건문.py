origin_pass = "1234"
input_pass = input()

if (origin_pass == input_pass):
    print("로그인 성공")
elif (input_pass == ""):
    print("비밀번호를 입력해주세요.")
else:
    print("로그인 실패")