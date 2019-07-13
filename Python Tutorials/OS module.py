import os 
from datetime import datetime

os.chdir('/Users/Windows/Desktop')
print(os.getcwd())
print(dir(os.path))

# os.makedirs('lol')
# os.rmdir('lol')
# os.rename('test.txt', 'demo.txt')

# print(os.stat('test.txt'))
# print(os.stat('test.txt').st_size)

# mod_time = os.stat('test.txt').st_mtime
# print(datetime.fromtimestamp(mod_time))

# print(os.environ)
# print(os.environ.get('HOME'))

# this file doesn't have to exist for the code to work
# print(os.path.basename('/temp/test.txt'))
# print(os.path.dirname('/temp/test.txt'))
# print(os.path.split('/temp/test.txt'))

# print(os.path.isfile('/temp/test.txt'))
# print(os.path.isdir('/temp/test.txt'))
# print(os.path.exists('/temp/test.txt'))

# print(os.path.splitext('/temp/test.txt'))
# print(os.path.splitext('/temp/test'))