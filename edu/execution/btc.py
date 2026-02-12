#문제
import requests as req
from datetime import date

bitUrl = "https://api4.binance.com/api/v3/ticker/price?symbol=BTCUSDT"
wonUrl = "https://m.search.naver.com/p/csearch/content/qapirender.nhn?key=calculator&pkid=141&q=%ED%99%98%EC%9C%A8&where=m&u1=keb&u6=standardUnit&u7=0&u3=USD&u4=KRW&u8=down&u2=1"

bitRes = req.get(bitUrl).text
wonRes = req.get(wonUrl).text

bit = wonRes[wonRes.rfind("value", 2 )+10:wonRes.rfind("value", 2)+15]
bit = int(bit.replace(',', ''))
won = format(bit * int(bitRes[29:34]), ',')

print(won + "원")