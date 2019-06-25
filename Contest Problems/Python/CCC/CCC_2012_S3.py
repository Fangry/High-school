import operator

n = int(input())
r = list(map(int, [input() for i in range(n)]))
freq = {}

for i in range(n):
    if r[i] in freq:
        freq[r[i]] += 1
    else:
        freq[r[i]] = 1
sort_by_val = sorted(freq.items(), key=operator.itemgetter(1), reverse=True)

if sort_by_val[0][1] == sort_by_val[1][1]:  # tied max
    i, max_, min_ = 0, 0, 1001
    while i < len(sort_by_val):
        if sort_by_val[i][1] == sort_by_val[0][1]:
            if sort_by_val[i][0] > max_:
                max_ = sort_by_val[i][0]
            if sort_by_val[i][0] < min_:
                min_ = sort_by_val[i][0]
            i += 1
        else:
            break
    print(max_-min_)
elif sort_by_val[1][1] == sort_by_val[2][1]:  # one max but many 2nd max
    i, max_diff = 1, 0
    while i < len(sort_by_val):
        if sort_by_val[i][1] == sort_by_val[1][1]:
            diff = abs(sort_by_val[0][0] - sort_by_val[i][0])
            if diff > max_diff:
                max_diff = diff
            i += 1
        else:
            break
    print(max_diff)
else:
    print(sort_by_val[0][1])
