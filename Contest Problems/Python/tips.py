# frequency list
'''
from collections import Counter
lst = [6, 3, 6, 3, 37, 2, 4, 67, 2, 4, 6, 9, 4, 2]
counter = Counter(lst)
top_three = counter.most_common(3)
print(top_three)
'''

# sort dictionary according to key or value
'''
import operator
x = {1: 2, 3: 4, 4: 3, 2: 1, 0: 0}
sorted1 = sorted(x.items(), key=operator.itemgetter(0)) # according to key
sorted2 = sorted(x.items(), key=operator.itemgetter(1)) # according to value
print(sorted1)
print(sorted2)
'''

# zip() maps iterables into an iterator that uses tuple, it can also used to unzip
'''
numberList = [1, 2, 3]
strList = ['one', 'two', 'three']
result = zip(numberList, strList)
resultList = list(result)
print(resultList)

n, s = zip(*resultList)
print(n)
print(s)

stocks = {
    'Goog': 520.54,
    'FB': 76.45,
    'yhoo': 39.28,
    'AMZN': 306.21,
    'APPL': 99.76
}

zipped_1 = zip(stocks.values(), stocks.keys())
zipped_2 = zip(stocks.keys(), stocks.values())
print(sorted(zipped_1)) # sorting according to values
print(sorted(zipped_2)) # sorting according to keys
'''

# iterate through dictionary using for loop
'''
dict_ex = {"brand": "Ford", "model": "Mustang", "year": 1964}
for x in dict_ex:  # print KEYS
    print(x)
for x in dict_ex.values():  # print VALUES
    print(x)
for x, y in dict_ex.items(): # print both KEYS & VALUES
    print(x, y)
'''
