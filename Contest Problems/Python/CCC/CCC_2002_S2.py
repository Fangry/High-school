def gcf(x, y):
    while y != 0:
        (x, y) = (y, x % y)
    return x


numer = int(input())
denom = int(input())

remain = numer % denom
if remain == 0:
    print(int(numer / denom))
else:
    if numer > denom:
        whole = (numer - remain) / denom
        x = gcf(remain, denom)
        print(int(whole), " ", int(remain / x), "/", int(denom / x), sep="")
    else:
        x = gcf(numer, denom)
        print(int(numer / x), "/", int(denom / x), sep="")
