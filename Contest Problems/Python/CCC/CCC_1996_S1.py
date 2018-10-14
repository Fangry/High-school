x = int(input())
for i in range(x):
    num = int(input())
    ds = 0
    for j in range(1, int(num/2)+1):
        if num % j == 0:
            ds += j

    if ds == num:
        print(num, 'is a perfect number.')
    elif ds < num:
        print(num, 'is a deficient number.')
    else:
        print(num, 'is an abundant number.')
