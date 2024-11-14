import csv
import matplotlib.pyplot as plt
from matplotlib import font_manager, rc
import platform

# 한글 폰트 설정
if platform.system() == "Windows":
    rc("font", family="Malgun Gothic")
elif platform.system() == "Darwin":  # macOS
    rc("font", family="AppleGothic")
plt.rcParams["axes.unicode_minus"] = False  # 마이너스 기호 깨짐 방지

# 학년별 키 데이터 초기화
elementary_heights = []
middle_heights = []
high_heights = []

# 데이터 파일 열기
try:
    with open("건강검진_키.csv", "r", encoding="euc-kr") as f:
        data = csv.reader(f)
        header = next(data)  # 헤더 건너뛰기

        # 학년별 키 데이터 수집
        for row in data:
            grade_level = row[1].strip()  # 학교급별 (초, 중, 고)
            try:
                height = float(row[4])  # 키 정보 (5번째 열)
            except ValueError:
                continue  # 키 정보가 잘못된 경우 건너뜀

            if grade_level == '초':
                elementary_heights.append(height)
            elif grade_level == '중':
                middle_heights.append(height)
            elif grade_level == '고':
                high_heights.append(height)

except FileNotFoundError:
    print("파일을 찾을 수 없습니다. 파일 이름과 경로를 확인하세요.")
except UnicodeDecodeError:
    print("파일 인코딩 오류입니다. 인코딩을 확인하세요.")

# 각 학년별 평균 키 계산
elementary_avg = sum(elementary_heights) / len(elementary_heights) if elementary_heights else 0
middle_avg = sum(middle_heights) / len(middle_heights) if middle_heights else 0
high_avg = sum(high_heights) / len(high_heights) if high_heights else 0

# 결과 출력
print("초등학생 평균 키:", elementary_avg)
print("중학생 평균 키:", middle_avg)
print("고등학생 평균 키:", high_avg)

# 막대그래프로 시각화
categories = ["초등학생", "중학생", "고등학생"]
averages = [elementary_avg, middle_avg, high_avg]

plt.figure(figsize=(8, 5))
plt.bar(categories, averages, color=["blue", "green", "red"])
plt.xlabel("학년")
plt.ylabel("평균 키 (cm)")
plt.title("초등학생, 중학생, 고등학생의 평균 키")
plt.show()
