import re

string = 'maaaaaaaaaaaaaaaaan'

# method 1: using finditer, it returns match object
pattern = re.compile('ma*n')
matches = pattern.finditer(string)
for match in matches:
    print(match)

# method 2: using findall, it returns tuple
# print(re.findall('ma*n', string))


emails = '''
CoreyMSchafer@gmail.com
corey.schafer@university.edu
corey-321-schafer@my-work.net
'''

pattern = re.compile(r'[\w.-]+@[\w-]+\.[\w.-]+')
matches = pattern.finditer(emails)
for match in matches:
    print(match)


# ^ vs $
s = 'the end'
print(re.findall(r'the end', s))
print(re.findall(r'^the end', s))
print(re.findall(r'the end$', s))


# match() vs. search()
line = "Cats are smarter than dogs"

matchObj = re.match( r'dogs', line, re.M|re.I)
if matchObj:
   print ("match --> matchObj.group() : ", matchObj.group())
else:
   print ("No match!!")

searchObj = re.search( r'dogs', line, re.M|re.I)
if searchObj:
   print ("search --> searchObj.group() : ", searchObj.group())
else:
   print ("Nothing found!!")


