stock_info = {
    '삼성전자' : {'최고가':85000, '최저가':80000, '현재가':82000},
    'SK하이닉스' : {'최고가':145000, '최저가':139000, '현재가':140500},
    '네이버' : {'최고가':360000, '최저가':340000, '현재가':350000}
}

# 방법 1
for stock_key, stock_value in stock_info.items():
    print(f"{stock_key} - 최고가: {stock_value['최고가']}, 최저가: {stock_value['최저가']}")


# 방법 2
for key, value in stock_info.items():
    max_value = value['최고가']
    min_value = value['최저가']
    print(f"{key} - 최고가: {max_value}, 최저가: {min_value}")