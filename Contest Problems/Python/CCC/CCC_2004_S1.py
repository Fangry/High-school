n = int(input())

for i in range(n):
    collection = []
    output = "Yes"
    for j in range(3):
        collection.append(input())
    for j in range(3):
        l = len(collection[j])
        if collection[j] == collection[(j + 1) % 3][l:] or collection[j] == collection[(j + 2) % 3][l:] \
                or collection[j] == collection[(j + 1) % 3][-l:] or collection[j] == collection[(j + 2) % 3][-l:]:
            output = "No"
    print(output)
