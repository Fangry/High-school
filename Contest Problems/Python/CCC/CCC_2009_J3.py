time = input()
while len(time) < 4:
    time = '0' + time
hr, min = int(time[:len(time) // 2]), int(time[len(time) // 2:])


def calctime(h, m, hr, min):
    nh = (h + hr) % 24
    nm = (m + min) % 60
    if m + min >= 60:
        nh += 1

    sm = ''
    if len(str(nm)) == 1 and nh != 0:
        sm = '0' + str(nm)
    else:
        sm = str(nm)

    if nh == 0 and nm == 0:
        return 0
    elif nm == 0:
        return str(nh) + '00'
    elif nh == 0:
        return sm
    else:
        return str(nh) + sm


print(calctime(0, 0, hr, min), 'in Ottawa')
print(calctime(-3, 0, hr, min), 'in Victoria')
print(calctime(-2, 0, hr, min), 'in Edmonton')
print(calctime(-1, 0, hr, min), 'in Winnipeg')
print(calctime(0, 0, hr, min), 'in Toronto')
print(calctime(1, 0, hr, min), 'in Halifax')
print(calctime(1, 30, hr, min), "in St. John's")
