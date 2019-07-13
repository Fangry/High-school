class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __repr__(self):
        return 'Point (x={} y={}'.format(self.x, self.y)

    def __str__(self):
        return 'Point(x=%s, y=%s)' % (self.x, self.y)

# try commenting out __repr__ or __str__ or both and see what happens! It's all about readability or clarity
p = Point(1, 2)
print(p)
