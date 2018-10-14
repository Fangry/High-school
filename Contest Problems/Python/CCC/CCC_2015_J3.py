word = list(input())
cons = 'bcdfghjklmnpqrstvwxyz'
vows = 'aaeeeiiiiooooouuuuuuu'
nextCons = 'cdfghjklmnpqrstvwxyzz'
output = []

for i in range(len(word)):
    c = word[i]
    output.append(c)
    if c not in 'aeiou':
        indx = cons.index(c)
        output.append(vows[indx])
        output.append(nextCons[indx])

for c in output:
    print(c, end="")
