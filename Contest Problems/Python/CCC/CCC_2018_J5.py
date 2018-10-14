pages = int(input())
book = {}
visited = set()
count_visited = 0
min_path = pages
reachable = False

for i in range(1, pages + 1):
    line = list(map(int, input().split()))
    book[i] = []
    if line[0] == 0:
        continue
    for n in line[1:]:
        book[i].append(n)


def search(vertex, path):
    global min_path
    visited.add(vertex)

    new_path = path + [vertex]
    if book[vertex] == []:
        min_path = min(len(new_path), min_path)

    for v in book[vertex]:
        if v not in new_path:
            search(v, new_path)


search(1, [])
if len(visited) == pages:
    print('Y')
else:
    print('N')
print(min_path)
