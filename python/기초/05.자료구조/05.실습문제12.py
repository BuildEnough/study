stock_prices = {
    '삼성전자' : [81000, 81500, 82000],
    'SK하이닉스' : [140000, 141000, 139500],
    '네이버' : [350000, 355000, 345000]
}

# 1번 방법
price_avg = [0, 0, 0]
i = 0
for price in stock_prices.values():
    price_avg[i] += int(sum(price) / len(price))
    i += 1

print(f"삼성전자 평균 주식 가격: {price_avg[0]}")
print(f"SK하이닉스 평균 주식 가격: {price_avg[1]}")
print(f"네이버 평균 주식 가격: {price_avg[2]}")


# 2번 방법
for key, value in stock_prices.items():
    avg = int(sum(value) / len(value))
    print(f"{key} 평균 주식 가격: {avg}")