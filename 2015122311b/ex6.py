
import requests

url = "http://lubo.elsys-bg.org"

res = requests.get(url)
print(res)

if res.status_code == 200:
	print("success!!!")


print(res.content)


