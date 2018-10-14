def printLst(lst):
    for x in range(len(lst)):
        print(lst[x], '', end='')
    print()

n = int(input())
nums = list(map(int, input().split()))
printLst(nums)

for i in range(n):
    for j in range(n - i - 1):
        if nums[j] > nums[j + 1]:
            nums[j], nums[j + 1] = nums[j + 1], nums[j]
            printLst(nums)
