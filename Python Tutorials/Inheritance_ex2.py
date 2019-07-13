class Fish:
    def __init__(self, first_name, last_name="Fish"):
        self.first_name = first_name
        self.last_name = last_name

    def swim(self):
        print("The fish is swimming.")

    def swim_backwards(self):
        print("The fish can swim backwards.")


class Trout(Fish):
    def __init__(self, water="freshwater"):
        self.water = water
        super().__init__(self)

terry = Trout()
# terry.name = 'Terry'
print(terry.first_name) 
# uncomment line 19 and see different output