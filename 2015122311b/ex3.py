

l1 = [1,2,3,4,5]

print(l1)
print(type(l1))

l1.append("ala bala")

print(l1)
print(l1[1])
print(l1[-1])
print(l1[1:-2])


for v in l1:
	print(v)


l2 = range(10)
print(l2)


print([v*v for v in l2])
print([v*v*v for v in l2])

l3 = []
for v in l2:
	l3.append(v*v*v)
print(l3)






