init = int(input())
streams = []
for i in range(init):
    streams.append(int(input()))
while True:
    x = int(input())
    if x == 77:  # done
        break
    elif x == 99:  # split
        si = int(input()) - 1
        percent = int(input()) * 0.01
        s = streams[si]
        del streams[si]
        first = int(round(s*percent))
        second = s-first
        streams.insert(si, first)
        streams.insert(si + 1, second)
    else:  # join
        ji = int(input()) - 1
        streams[ji] += streams[ji + 1]
        del streams[ji + 1]
for i in range(len(streams)):
    print(streams[i], "", end="")
