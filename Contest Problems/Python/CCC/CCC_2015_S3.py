g = int(input())
p = int(input())
gates = [i + 1 for i in range(g)]
planes = [i + 1 for i in range(p)]
output = 0

for i in range(p):
    order = int(input())
    can_land = False
    for j in range(len(gates) - 1, -1, -1):
        if order >= gates[j]:
            del gates[j]
            can_land = True
            output += 1
            # print('plane', i+1, 'dock in gate', j+1)
            # print('gates:', gates)
            # print('planes:', planes)
            break
    if not can_land:
        break

print(output)
