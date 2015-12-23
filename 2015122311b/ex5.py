

class Person(object):
	
	def __init__(self, name, address):
		self.name = name
		self.address = address
		self.__private = "private"
		
	
	def __str__(self):
		return "Person(name={}, address={})".format(self.name, self.address)


class Employee(Person):
	# mixin??? 
	
	def __init__(self, name, address):
		Person.__init__(self, name,address)
		# ala bala
	
p = Person("pesho", "sofia")
print(p.name)
print(p.address)

print(p)


e = Employee("pesho", "sofia")
print(e)



e = None
print(e is None)
if e is None:
	print("e is None")







