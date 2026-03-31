def easy_recipe(a, b):
    print(f"{a}와 {b}을(를) 이용해서 맛있는 요리를 시작합니다.")
    result = a + b + '볶음밥'
    print("요리완료")
    return result

print("배가 출출하네...")
print("오늘은 야식으로 무엇을 야무지게 먹을까?")
dish = easy_recipe("치즈", "불닭")
print(dish)

dish = easy_recipe("김치", "제육")
print(dish)

