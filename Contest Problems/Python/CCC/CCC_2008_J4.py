while True:
    line = input().split()
    nums = []

    if line == ['0']:
        break

    for i in range(len(line) - 1, -1, -1):
        if line[i] in '0123456789':
            nums.append(line[i])
        else:
            a = nums.pop()
            b = nums.pop()
            nums.append(a + " " + b + " " + line[i])
        # print(nums)
    print(nums[0])
