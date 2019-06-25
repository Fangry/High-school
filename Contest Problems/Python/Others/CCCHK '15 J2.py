num_points = int(input())
points = [list(map(int, input().split())) for i in range(num_points)]
min_dist = 10001

for i in range(num_points):
    for j in range(i+1, num_points):
        xdist = abs(points[i][0]-points[j][0])
        ydist = abs(points[i][1]-points[j][1])
        if max(xdist, ydist) < min_dist:
            min_dist = max(xdist, ydist)

print(min_dist*min_dist)
