# 튜플
leg_day = ("스쿼트", "런지", "레그컬")
print(leg_day)

# 딕셔너리
stock_prices = {
    '삼성전자' : 81000,
    'SK하이닉스': 140000,
    "네이버": 350000
}
print(stock_prices)
print(stock_prices['삼성전자'])

for key in stock_prices.keys():
    print(key)

for value in stock_prices.values():
    print(value)

for key, value in stock_prices.items():
    print(key, value)