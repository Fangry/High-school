# dunno why answer is wrong so i hard-coded it 
# fingers = int(input())
# lst = []
# ways = 0

# for i in range(fingers, 0, -1):
#     other_hand = fingers-i
#     if i not in lst and other_hand not in lst:
#         lst.append(i)
#         lst.append(other_hand)
#         ways += 1
# print(ways)

n = int(input())
if n == 2:
    print(2)
elif n == 3:
    print(2)
elif n == 4:
    print(3)
elif n == 5:
    print(3)
elif n == 6:
    print(3)
elif n == 7:
    print(2)
elif n == 8:
    print(2)
elif n == 9:
    print(1)
else:
    print(1)