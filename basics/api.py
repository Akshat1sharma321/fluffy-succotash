import requests
import json
response = requests.get("https://api.stackexchange.com/2.3/answers?order=desc&sort=activity&site=stackoverflow")
print(response.json())
for data in response.json()['items']:
    print(data['owner']['display_name'])