gugudan = int(input("몇 단을 출력할까요?: "))
for i in range(1, 10):
    print(f"{gugudan} * {i} = {gugudan * i}")

print()

cnt = 1
while cnt < 10:
    print(f"{gugudan} * {cnt} = {gugudan * cnt}")
    cnt += 1