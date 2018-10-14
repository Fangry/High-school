n = int(input())
for i in range(n):
    inputs = list(map(int, input().split()))
    if 2007 - inputs[0] > 18:
        print('Yes')
    elif 2007 - inputs[0] < 18:
        print('No')
    else:
        if inputs[1] > 2:
            print('No')
        elif inputs[1] < 2:
            print('Yes')
        else:
            if inputs[2] > 27:
                print('No')
            else:
                print('Yes')

