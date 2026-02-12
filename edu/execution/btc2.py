# 이전에 알아낸 실시간 비트코인 BTC/USD 가격으로
# 실시간 환율을 계산하여 비트코인 가격을 원화로 표시
# py 파일로 저장하여 python3로 실행까지
import requests as req
from datetime import date

bitUrl = "https://api4.binance.com/api/v3/ticker/price?symbol=BTCUSDT"
usdUrl = "https://oapi.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=fqtmvcQvGE7tcLcesKHys2NyZk6MG1Zd&data=AP01"
resultbit = req.get(bitUrl).text
resultUsd = req.get(usdUrl).json()


bitPrice = int(resultbit[29:34]) # 비트코인 가격
wonPrice = resultUsd[-1]['deal_bas_r'].replace(',', '') #달러

bitResult = bitPrice * float(wonPrice)
bitResult = round(bitResult)
print(f"{bitResult:,}원")