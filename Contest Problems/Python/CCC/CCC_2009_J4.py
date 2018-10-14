n = int(input())
words = ['WELCOME', 'TO', 'CCC', 'GOOD', 'LUCK', 'TODAY']
lens = [7, 2, 3, 4, 4, 5]
lines = {}

# ----------- PART 1 ----------- #
# assign words to line numbers.
# e.g. ON INPUT 13 => lines = {0: ['WELCOME', 'TO'], 1: ['CCC', 'GOOD', 'LUCK'], 2: ['TODAY']}

empty = n
i = 0
line = 0
count = 0
while i < 6:
    if count > 0:
        empty -= 1
    if empty >= lens[i]:
        if line not in lines:
            lines[line] = [words[i]] # start new line and append first word
        else:
            lines[line].append(words[i]) # append new word
        empty -= lens[i]
        i += 1
        count += 1
    else:  # new line
        line += 1
        count = 0
        empty = n
# ----------- PART 2 ----------- #
# create spacing in between each word and print each line

# for each line
for x in range(line + 1):
    # get number of words in line
    length = len(lines[x])

    # base case (there is only 1 word on the line)
    if length == 1:
        print(lines[x][0] + '.' * (n - len(lines[x][0])))

    # if there are 2 or more words on the line
    else:
        # get the sum of all words in the line
        totalcount = 0
        for elem in lines[x]:
            totalcount += len(elem)

        # create an array that represents the number of spaces between each word
        # each value in the array will be the average of the remaining spaces (rounded down)
        # NOTE our use of Floor division '//'
        spaces = [(n - totalcount) // (length - 1)] * (length - 1)

        # distribute the remaining spaces from left to right
        # NOTE our use of modulus '%'
        for y in range((n - totalcount) % (length - 1)):
            spaces[y] += 1

        # output line
        outputString = lines[x][0]
        for y in range(length - 1):
            outputString += '.' * spaces[y] + lines[x][y + 1]
        print(outputString)
