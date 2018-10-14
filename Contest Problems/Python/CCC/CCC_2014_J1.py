x = int(input())
y = int(input())
z = int(input())
sum = x + y + z
message = "Error"

if sum == 180:
    if x == y and x == z and y == z:
        message = "Equilateral"
    elif x == y or x == z or y ==z:
        message = "Isosceles"
    else:
        message = "Scalene"

print(message)
