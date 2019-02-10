import math

dt = input().split(':')

# convert hour and minute into int
for i in range(2):
    if dt[i][0] == '0':
        dt[i] = int(dt[i][1])
    else:
        dt[i] = int(dt[i])

# time of day in terms of minute
time = dt[0]*60 + dt[1]

# compute every minute for the trip
i = 240
while i > 0:
    time += 1
    if time > 7*60 and time <= 10*60:
        i -= 1
    elif time > 15*60 and time <= 19*60:
        i -= 1
    else:
        i -= 2

# convert int back to hour and minute
h = str(math.floor(time/60 % 24))
if len(h) == 1:
    h = '0' + h
m = str(math.floor(time % 60))
if len(m) == 1:
    m = '0' + m

print(h, ':', m, sep='')
