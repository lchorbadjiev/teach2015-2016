

def square(val):
	return val*val


def mmax(v1, v2):
	if v1 > v2:
		return v1
	else:
		return v2

def mmax3(v1, v2, v3):
	if v1 > v2 and v1 > v3:
		return v1
	elif v2 > v1 and v2 > v3:
		return v2
	elif v3 > v1 and v3 > v2:
		return v3
	else:
		return (v1,v2,v3)
		
def gcd(a, b):
	r = a % b
	while r!=0:
		a = b
		b = r
		r = a % b
	return b


print(square(3))
print(mmax(3, 4))

print(mmax3(1,2,3))

print(mmax3(1,1,1))


print(gcd(10, 20))
print(gcd(12, 16))


