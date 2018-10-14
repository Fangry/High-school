winCount = 0;
for i in range(6):
    if input() == 'W':
        winCount += 1;

if winCount == 5 or winCount == 6:
    print(1)
elif winCount == 3 or winCount == 4:
    print(2)
elif winCount == 2 or winCount == 1:
    print(3)
else:
    print(-1)
