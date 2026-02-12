import requests as req
url = "https://api.fda.gov/drug/event.json?count=patient.reaction.reactionmeddrapt.exact"
value = req.get(url).json()

# 1. FDA 데이터베이스에서 보고서 중 구토 증상의 횟수를 찾아 출력 -> "NAUSEA"
NAUSEA_COUNT = value['results'][3]['count']
print(f'NAUSEA의 구토 증상 횟수: {NAUSEA_COUNT}')

# 2. COVID-19 관련 보고 건수는 몇 건 ?
# COVID 찾기
covid_count = 0
for i in range(len(value["results"])):
    item = value["results"][i]
    if item["term"] == "COVID-19":
        COVID_COUNT = value["results"][covid_count]['count']
    covid_count = covid_count + 1

print(f'COVID-19 건수: {COVID_COUNT}')

# 3. MYOCARDIAL INFARCTION(심근경색) 몇 건?
myocardial_count = 0
for i in range(len(value["results"])):
    item = value["results"][i]
    if item["term"] == "MYOCARDIAL INFARCTION":
        MYOCARDIAL_COUNT = value["results"][myocardial_count]['count']
    myocardial_count = myocardial_count + 1

print(f'MYOCARDIAL INFARCTION 건수: {MYOCARDIAL_COUNT}')

# 4. 2번과 3번을 비교하여 (if 조건 else 를 사용) "코로나가 더 많음" vs " 심근경색이 더 많음" 을 출력 하여라
covid_myocardial = "코로나가 더 많음" if (COVID_COUNT > MYOCARDIAL_COUNT) else "심근경색이 더 많음"
print(covid_myocardial)

# 5. NAUSEA(구역질)와 VOMITING(구토)의 보고 건수를 비교하면, 어느 쪽이 더 많으며 차이는 몇 건인가?
nausea_count = 0
vomitting_count = 0
for i in range(len(value["results"])):
    item = value["results"][i]
    if item["term"] == "MYOCARDIAL INFARCTION":
        NAUSEAL_COUNT = value["results"][nausea_count]['count']
    if item["term"] == "MYOCARDIAL INFARCTION":
        VOMITING_COUNT = value["results"][vomitting_count]['count']
    vomitting_count = vomitting_count + 1

if (NAUSEAL_COUNT > VOMITING_COUNT):
    print(f"NAUSEAL가 {(NAUSEAL_COUNT-VOMITING_COUNT)}건 더 많음")
elif (NAUSEAL_COUNT > VOMITING_COUNT):
    print(f"VOMITING가 {(VOMITING_COUNT-NAUSEAL_COUNT)}건 더 많음")

# 6. 메타 정보의 disclaimer(경고문구) 안에 "FDA"라는 단어가 포함되어 있는지 확인하여 출력하라.
line = value["meta"]['disclaimer']
FDA_count = line.count("FDA")
print(f'disclaimer(경고문구) 안에는 FDA 단어가 {FDA_count}번 들어가 있습니다')