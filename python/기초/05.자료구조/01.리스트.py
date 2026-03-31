'''
company_list = ["삼성전자", "SK하이닉스", "네이버"]
print(company_list)
for i in range(len(company_list)):
    print(company_list[i])

company_list[0] = "애플"
company_list[1] = "구글"
company_list[2] = "테슬라"
print(company_list)

company_list.append("마이크로소프트")
print(company_list)

del company_list[0]
print(company_list)

num_list = [1, 2, 3, 4, 5, 6, 7, 8]
print(num_list[0:2])
print(num_list[:2])
print(num_list[2:])
print(num_list[::2])
'''

inventory = ["대검", "포션", "마법서"]
for item in inventory:
    print(f"{item}을(를) 확인했습니다.)")
    print("창닫기")

game_map = [
    ["대검", "포션", None],
    [None, "보물상자", "포션"],
    ["몬스터", None, "열쇠"]
]
print(game_map[0])
print(game_map[0][2])
print(game_map[2][2])