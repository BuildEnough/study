from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import pyperclip
import pyautogui

# 크롬 드라이버 실행
driver = webdriver.Chrome()
# driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/")
# driver.maximize_window() #화면 최대화

# # 아이디 입력창
# id = driver.find_element(By.CSS_SELECTOR, "#id")
# id.click()
# pyperclip.copy('네이버아이디')
# pyautogui.hotkey("ctrl", "v")
# ## id.send_keys("네이버아이디") #네이버 아이디 입력
# time.sleep(2)

# # 비밀번호 입력창
# pw = driver.find_element(By.CSS_SELECTOR, "#pw")
# pw.click()
# pyperclip.copy('네이버비밀번호')
# pyautogui.hotkey("ctrl", "v")
# ## pw.send_keys("네이버비밀번호") #네이버 비밀번호 입력
# time.sleep(2)

# # 로그인 버튼
# driver.find_element(By.CSS_SELECTOR, "#log\.login").click()

# # 프로그램이 종료되지 않도록 대기
# input("엔터를 누르면 종료됩니다...")
driver.quit()
