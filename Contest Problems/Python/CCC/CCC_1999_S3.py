d = int(input())

for iteration in range(d):
    n = int(input())
    b = int(input())
    t = int(input())
    l = int(input())
    r = int(input())

    # we use [t-1 to b-2] instead of [t to b-1] since its easier to calculate for indices [0 to 3**n - 1]
    for y in range(t - 1, b - 2, -1):
        # we also begin counting at zero for each x position in the matrix
        for x in range(l - 1, r):
            # initially, our square is filled
            val = "* "

            # for each iteration from 1 to n
            for i in range(1, n + 1):
                # if the x and y position of the square is in the middle of a square of size 3**i, then it is empty, calculate all iternations right away
                if (x // 3 ** (i - 1)) % 3 == 1 and (y // 3 ** (i - 1)) % 3 == 1:
                    val = "  "
                    break
            print(val, end="")
        print()  # new line