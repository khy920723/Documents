cities = ['서울', '부산', '인천', '대구', '대전', '광주', '울산', '수원']
print(cities[0:6])
print(cities[:6])
print(cities[2:])
print(cities[-7:])  # 음수: 선형리스트기 때문에 거꾸로 접근 가능, 실제 갯수는 몰라도 마지막 인덱스 접근 가능(-1이 마지막 인덱스)
print(cities[:-2])
print(cities[:])
print(cities)
print(cities[1:7:2])  # 1번 째 부터 6번 째 까지(7번은 포함 안됨) 2개씩 점프
print(cities[::-1])
print(cities[::2])