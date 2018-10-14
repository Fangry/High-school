first_line = tuple(map(int, input().split()))
N = first_line[0]
M = first_line[1]
A = first_line[2]
B = first_line[3]
graph = {}
visited = []

for x in range(M):  # links both locations together, not just one way
    next_line = tuple(map(int, input().split()))
    if next_line[0] not in graph:
        graph[next_line[0]] = []
    if next_line[1] not in graph:
        graph[next_line[1]] = []
    graph[next_line[0]].append(next_line[1])
    graph[next_line[1]].append(next_line[0])


def search(node):
    if B == node:
        return True
    if node not in graph:
        return False

    returnVal = False
    for n in graph[node]:
        if n not in visited:
            visited.append(n)
            returnVal = returnVal or search(n) # recursive
    return returnVal


visited.append(A)

if search(A):
    print("GO SHAHIR!")
else:
    print("NO SHAHIR!")
