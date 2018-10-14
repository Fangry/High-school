t1 = int(input())
t2 = int(input())
len = 2

while t2 <= t1:
    temp = t2
    t2 = t1 - t2
    t1 = temp
    len += 1
    # print(len, t1, t2)
print(len)
