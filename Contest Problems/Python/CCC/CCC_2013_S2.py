maxWeight = int(input())
numCars = int(input())
cars = []
curWeight = 0
num = 0
count = 0
passed = 0
for i in range(numCars):
    cars.append(int(input()))

while num < numCars:
    if curWeight + cars[num] > maxWeight:
        break
    if count < 4:
        curWeight += cars[num]
        count += 1
        # print(num, curWeight, count, passed, "add")
    if count == 4:
        curWeight -= cars[num - 3]
        passed += 1
        count -= 1
        # print(num, curWeight, count, passed, "delete")
    num += 1

print(passed + count)
