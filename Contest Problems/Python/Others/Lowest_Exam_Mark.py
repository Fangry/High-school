from math import floor

p = int(input())
q = int(input())
w = int(input()) / 100

if w > 0:
    best = floor((q - p * (1 - w)) / w)
else:
    best = p
# print(best)
if best > 100:
    print('DROP THE COURSE')
else:
    if best < 0:
        print(0)
    else:
        print(best)
