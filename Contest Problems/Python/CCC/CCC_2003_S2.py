n = int(input())
lstform = []
for i in range(n):
    form = "free"
    lstsyll = []
    for j in range(4):
        verse = input().split()
        syll = []
        for k in verse[-1].lower()[::-1]:
            syll.append(k)
            if k == 'a' or k == 'e' or k == 'i' or k == 'o' or k == 'u':
                break
        lstsyll.append(syll)
    if lstsyll[0] == lstsyll[1] and lstsyll[2] == lstsyll[3]:
        if lstsyll[0] == lstsyll[2]:
            form = "perfect"
        else:
            form = "even"
    elif lstsyll[0] == lstsyll[2] and lstsyll[1] == lstsyll[3]:
        form = "cross"
    elif lstsyll[0] == lstsyll[3] and lstsyll[1] == lstsyll[2]:
        form = "shell"
    lstform.append(form)
for f in lstform:
    print(f)
