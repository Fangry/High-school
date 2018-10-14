lines = int(input())
events = []
trackFriends = []
trackTime = []
totalTime = []
waiting = []
time = 0

for i in range(lines):
    events.append(input().split())
for i in range(lines):
    letter = events[i][0]
    friend = int(events[i][1])
    if letter == "W":
        time += friend
        # print(events[i], trackFriends, trackTime, totalTime, waiting, time)
    elif letter == "R":
        if friend not in trackFriends:
            trackFriends.append(friend)
            trackTime.append(time)
            totalTime.append(0)
            waiting.append(1)
            # print(events[i], trackFriends, trackTime, totalTime, waiting, time)
        else:
            index = trackFriends.index(friend)
            trackTime[index] = time
            waiting[index] = 1
            # print(events[i], trackFriends, trackTime, totalTime, waiting, time)
        if events[(i + 1) % lines][0] != "W":
            time += 1
    else:  # S case
        index = trackFriends.index(friend)
        totalTime[index] += time - trackTime[index]
        waiting[index] = -1
        # print(events[i], trackFriends, trackTime, totalTime, waiting, time)
        if events[(i + 1) % lines][0] != "W":
            time += 1

numFriends = len(trackFriends)
for i in range(numFriends):  # deal with unresponded messages
    if waiting[i] == 1:
        totalTime[i] = -1

trackFriendsSorted = trackFriends.copy()
trackFriendsSorted.sort()
totalTimeCopy = totalTime.copy()
for i in range(numFriends):
    for j in range(numFriends):
        if trackFriends[i] == trackFriendsSorted[j]:
            totalTimeCopy[i] = totalTime[j]
            break

for i in range(numFriends):
    print(trackFriendsSorted[i], totalTimeCopy[i])
