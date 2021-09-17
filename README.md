# Backend test task

## API

# 1) Users

- POST /user
        body: 
    ```json
            {
                "login": "<login>",
                "password": "<password>"
            }
    ```
# 2) Quotes

- POST /quote
        body: 
    ```json
            {
                "content": "<content>",
                "userId": <userId>
            }
    ```
- PUT /quote
        body: 
    ```json
            {
                "id": <id>,
                "content": "<content>"
            }
    ```        
- GET /quote/top?count={count}, /quote/top == count = 10
        response: 
    ```json
        [
            {
                "id": 1,
                "content": "content 1",
                "score": 1,
                "userId": {
                    "id": 1,
                    "login": "dima"
                },
                "votes": [
                    {
                        "id": 1,
                        "choice": 1,
                        "quoteId": 1,
                        "userDto": {
                        "id": 1,
                        "login": "dima"
                    },
                    "time": "2021-09-17T16:06:51.116+00:00"
                    }
                ]
            },
            {
                "id": 2,
                "content": "content 2",
                "score": 0,
                "userId": {
                    "id": 1,
                    "login": "dima"
                },
                "votes": []
            }
        ]
    ```

- GET /quote/{id}
    response:
    ```json
        {
            "id": 1,
            "content": "content 1",
            "score": 1,
            "userId": {
                "id": 1,
                "login": "dima"
            },
            "votes": [
                {
                    "id": 1,
                    "choice": 1,
                    "quoteId": 1,
                    "userDto": {
                        "id": 1,
                        "login": "dima"
                    },
                    "time": "2021-09-17T16:06:51.116+00:00"
                }
            ]
        }
    ```
- DELETE /quote/{id}

# 3) Votes

- POST /vote
        response: 
    ```json
            {
                "choice": <choice>, //<choice> > 0 == like, <choice> < 0 == dislike,
                "quoteId": <quoteId>
                "userId": <userId>
            }
    ```
