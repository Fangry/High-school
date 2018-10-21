river_len = int(input())
num_ani = int(input())
river = [0, river_len]

for i in range(num_ani):
    a, b = [int(x) for x in input().split()]
    for j in range(0, len(river), 2):
        if river[j] < a < river[j + 1] or river[j] < b < river[j + 1]:
            if river[j] == a and river[j + 1] == b:  # entire river taken, exit
                river = [0, 0]
                print('all')
                break
            else:
                if river[j] != a and river[j + 1] != b:  # a segment in middle of river is taken
                    river.extend([river[j], a])
                    river.extend([b, river[j + 1]])
                    del river[j:j + 2]
                    print('middle')
                else:
                    if river[j] != a:  # a segment to right is taken
                        river.extend([river[j], a])
                        print('right')
                    elif river[j + 1] != b:
                        river.extend([b, river[j + 1]])  # a segment to left is taken
                        print('left')
                    del river[j:j + 2]
        print(river)

print(river[1] - river[0])
