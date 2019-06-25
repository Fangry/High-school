s1 = sorted(input().replace(' ', ''))
s2 = sorted(input().replace(' ', ''))
output = 'Is an anagram.'

for i in range(len(s1)):
    if s1[i] != s2[i]:
        output = 'Is not an anagram.'
        break

print(output)
