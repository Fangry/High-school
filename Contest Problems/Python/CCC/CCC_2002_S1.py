pink = int(input())
green = int(input())
red = int(input())
orange = int(input())
target = int(input())
minTickets = 999999
combo = []

for p in range(target // pink + 1):
    tPink = p * pink
    for g in range(target // green + 1):
        tGreen = g * green
        for r in range(target // red + 1):
            tRed = r * red
            for o in range(target // orange + 1):
                tOrange = o * orange
                if tPink + tGreen + tRed + tOrange == target:
                    combo.append([p, g, r, o])
                    if p + g + r + o < minTickets:
                        minTickets = p + g + r + o

for i in range(len(combo)):
    print("# of PINK is", combo[i][0], "# of GREEN is", combo[i][1], "# of RED is", combo[i][2],
          "# of ORANGE is", combo[i][3])
print("Total combinations is ", len(combo), ".", sep='')
print("Minimum number of tickets to print is ", minTickets, ".", sep='')
