import requests

def getResults(id):
    results = requests.get(f'http://localhost:8080/api/results/{id}').json()
    return results

def deleteAllResults(id):
    requests.delete(f'http://localhost:8080/api/results/delete/{id}')
    return "Your results repository is Empty"

def getFilters(id):
    results = requests.get(f'http://localhost:8080/api/filters/all/{id}').json()
    return results

def postFilter(id, search_str):
    payload={
        "telegramUserId": id,
        "searchString": search_str,
        }
    response = requests.post('http://localhost:8080/api/filters', json=payload)
    return "Ok! We are searching now..."

def deleteAllFilters(id):
    requests.delete(f'http://localhost:8080/api/filters/delete/{id}')
    return "Your filters repository is Empty"
