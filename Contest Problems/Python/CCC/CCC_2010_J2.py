abcds = []
for i in range(5):
    abcds.append(int(input()))
nikky = 0
nf = abcds[0]
nb = abcds[1]
byron = 0
bf = abcds[2]
bb = abcds[3]

for i in range(abcds[4]):
    if nf == 0 and nb == 0:
        nf = abcds[0]
        nb = abcds[1]

    if nf > 0:
        nikky += 1
        nf -= 1
    else:
        if nb > 0:
            nikky -= 1
            nb -= 1

    if bf == 0 and bb == 0:
        bf = abcds[2]
        bb = abcds[3]
    if bf > 0:
        byron += 1
        bf -= 1
    else:
        if bb > 0:
            byron -= 1
            bb -= 1

if nikky > byron:
    print('Nikky')
elif byron > nikky:
    print('Byron')
else:
    print('Tied')
