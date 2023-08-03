from bs4 import BeautifulSoup
import requests
import time
import re

url = "https://www.olx.ua"
target = "https://www.olx.ua/uk/transport/legkovye-avtomobili/"
endpoint = "/d/uk/obyavlenie/"

get_all_filters = 'http://localhost:8080/api/filters/all'
post_result = 'http://localhost:8080/api/results'

it = 0
while it < 100 :
    time.sleep(5)
    filters = requests.get(get_all_filters).json()
    for filter in filters:
        time.sleep(1)
        print(filter)
        telegram_user_id = filter['telegarmUserId']
        search_string = filter['searchString']

        time.sleep(1)
        res = requests.get(target)
        soup = BeautifulSoup(res.text, 'html.parser')

        for code in soup.find_all('a'):
            for tag in code.find_all('h6'):
                text = tag.get_text()
                text = text.lower()
                search_string = search_string.lower()
                if re.findall(search_string, text):
                    href = code.get('href')
                    href = str(href)
                    if href.startswith(endpoint):
                        payload={
                            'model': text,
                            'year': "default",
                            'price': "default",
                            'url': url + href,
                            'telegramUserId': telegram_user_id
                        }
                        response = requests.post(post_result, json=payload)
                        print(response.text)
    it += 1