from selenium import webdriver

# 크롬 드라이버 실행
driver = webdriver.Chrome()
driver.get("https://www.naver.com")

# 프로그램이 종료되지 않도록 대기
input("엔터를 누르면 종료됩니다...")
driver.quit()
