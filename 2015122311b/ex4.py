

d1 = {"id": "alabala",
	  "name": "pesho",
	  "address": "sofia",
	 }
	 
print(d1)

print(d1["id"])
d1["family"] = "peshev"
print(d1)

t1 = ("id", 1)
print(t1)

(k,v) = t1
print(k)
print(v)

print(d1.items())
for (k,v) in d1.items():
	print("key: {}, value: {}".format(k,v))

for k in d1:
	print("key: {}, value: {}".format(k, d1[k]))




 
