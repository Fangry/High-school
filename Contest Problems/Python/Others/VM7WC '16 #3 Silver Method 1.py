info = tuple(map(int, input().split()))
graph = {}
visited = set()
stack = [info[2]]

for i in range(info[1]):
    line = tuple(map(int, input().split()))
    if line[0] not in graph:
        graph[line[0]] = set()
    if line[1] not in graph:
        graph[line[1]] = set()
    graph[line[1]].add(line[0])
    graph[line[0]].add(line[1])

while stack:
    # print('stack:', stack)
    # print('visited:', visited)
    house = stack.pop()
    if house not in visited:
        visited.add(house)
        if house in graph:
            stack.extend(list(graph[house] - visited))
# print(visited)

if info[3] in visited:
    print('GO SHAHIR!')
else:
    print('NO SHAHIR!')
