from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import pyperclip
import pyautogui

driver = webdriver.Chrome()
driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/")
driver.maximize_window()

# 아이디 입력
driver.find_element(By.CSS_SELECTOR, "#id").click()
pyperclip.copy('네이버아이디')
pyautogui.hotkey("ctrl", "v")
time.sleep(2)

# 비밀번호 입력
driver.find_element(By.CSS_SELECTOR, "#pw").click()
pyperclip.copy('네이버비밀번호!')
pyautogui.hotkey("ctrl", "v")
time.sleep(2)

# 로그인
driver.find_element(By.CSS_SELECTOR, "#log\.login").click()
time.sleep(10)

# 메일함 이동
driver.get("https://mail.naver.com/v2/folders/0/all")
time.sleep(2)

# 메일 쓰기 버튼 클릭
driver.find_element(By.CSS_SELECTOR, "#root > div > nav > div > div.lnb_header > div.lnb_task > a.item.button_write").click()
time.sleep(2)

# 받는 사람
driver.find_element(By.CSS_SELECTOR, "#recipient_input_element").send_keys("rhtmaehcl878@naver.com")
time.sleep(2)

# 제목
driver.find_element(By.CSS_SELECTOR, "#subject_title").send_keys("파이썬으로 자동화한 메일")
time.sleep(2)

# 내용(본문) - iframe 안으로 들어가기
iframe = driver.find_element(By.CSS_SELECTOR, "#content > div.contents_area > div > div.editor_area > div > div.editor_body > iframe")
driver.switch_to.frame(iframe)

driver.find_element(By.CSS_SELECTOR, "body > div > div.workseditor-content").send_keys("본문 내용")
time.sleep(2)

# iframe 밖으로 나가기
driver.switch_to.default_content()

# 보내기 버튼
driver.find_element(By.CSS_SELECTOR, "#content > div.mail_toolbar.type_write > div:nth-child(1) > div > button.button_write_task").click()


input("엔터 입력 시 종료")
driver.quit()