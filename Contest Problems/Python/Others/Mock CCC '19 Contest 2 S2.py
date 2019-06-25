from math import sqrt
'''
from 4 corners of house/rect, separate entire grid into 4 quadrants by drawing diagonal lines out from each corner at 45 degree
starting from the top-left corner of house, going clock-wise, label each corner 0, 1, 2, 3
the largest radius of circle can either touch the corner or the side of the house (getDistance handles this)
'''


class Rect:

    def __init__(self, x1, y1, x2, y2):
        self.corners = [(x1, y2), (x2, y2), (x2, y1), (x1, y1)]

    def getQuadrant(self, x, y):
        index = 0
        minimum = 5000
        for i in range(4):
            distance = sqrt((self.corners[i][1]-y)
                            ** 2 + (self.corners[i][0]-x)**2)
            # print('dist from', i, 'th corner: ', round(distance,2))
            if distance < minimum:
                minimum = distance
                index = i
        # print('index:', index)
        return index

    def getDistance(self, index, x, y):
        intersect_x, intersect_y = None, None

        if index == 0:
            if x >= self.corners[0][0]:
                intersect_x = x
                intersect_y = self.corners[0][1]
            else:
                if y <= self.corners[0][1]:
                    intersect_x = self.corners[0][0]
                    intersect_y = y
                else:
                    intersect_x = self.corners[0][0]
                    intersect_y = self.corners[0][1]
        elif index == 1:
            if x >= self.corners[1][0]:
                if y <= self.corners[1][1]:
                    intersect_x = self.corners[1][0]
                    intersect_y = y
                else:
                    intersect_x = self.corners[1][0]
                    intersect_y = self.corners[1][1]
            else:
                intersect_x = x
                intersect_y = self.corners[1][1]
        elif index == 2:
            if x >= self.corners[2][0]:
                if y <= self.corners[2][1]:
                    intersect_x = x
                    intersect_y = self.corners[2][1]
                else:
                    intersect_x = self.corners[2][0]
                    intersect_y = self.corners[2][1]
            else:
                intersect_x = x
                intersect_y = self.corners[2][1]
        else:
            if x >= self.corners[3][0]:
                intersect_x = x
                intersect_y = self.corners[3][1]
            else:
                if y <= self.corners[3][1]:
                    intersect_x = self.corners[3][0]
                    intersect_y = y
                else:
                    intersect_x = self.corners[3][0]
                    intersect_y = self.corners[3][1]

        distance = sqrt((intersect_y-y) ** 2 + (intersect_x-x)**2)
        # print('intersect_x:', intersect_x, 'intersect_y:', intersect_y)
        return distance


inputs = list(map(int, input().split()))
house = Rect(inputs[2], inputs[3], inputs[4], inputs[5])
quad = house.getQuadrant(inputs[0], inputs[1])
print("{0:.3f}".format(house.getDistance(quad, inputs[0], inputs[1])))
