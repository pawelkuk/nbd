1.
```bash
curl -i --location --request PUT 'localhost:8098/types/default/buckets/s23681/keys/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Petunia",
    "breed": "golden",
    "age": 10,
    "isSterilized": true
}'
```

```bash
curl -i --location --request PUT 'localhost:8098/types/default/buckets/s23681/keys/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Alice",
    "breed": "beagle",
    "age": 12,
    "isSterilized": true
}'
```

```bash
curl -i --location --request PUT 'localhost:8098/types/default/buckets/s23681/keys/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Bob",
    "breed": "dalmatian",
    "age": 5,
    "isSterilized": true
}'
```

```bash
curl -i --location --request PUT 'localhost:8098/types/default/buckets/s23681/keys/4' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Eve",
    "breed": "pomsky",
    "age": 7,
    "isSterilized": false
}'
```

```bash
curl -i --location --request PUT 'localhost:8098/types/default/buckets/s23681/keys/5' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Diffie",
    "breed": "shiba",
    "age": 9,
    "isSterilized": false
}'
```

2.
```bash
curl -i --location --request GET 'localhost:8098/types/default/buckets/s23681/keys/4' \
--header 'Content-Type: application/json' 
```

3.
```bash
curl -i --location --request GET 'localhost:8098/types/default/buckets/s23681/keys/4' \
--header 'Content-Type: application/json' 
```

```bash
curl -i --location --request PUT 'localhost:8098/types/default/buckets/s23681/keys/4' \
--header 'Vclock: a85hYGBgzGDKBVI8ziENiqvE18hBhBKZ81gZzM9r3eLLAgA=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Eve",
    "breed": "pomsky",
    "age": 7,
    "isSterilized": false,
    "wonContests": 5
}'
```

4.
```bash
curl -i --location --request GET 'localhost:8098/types/default/buckets/s23681/keys/2' \
--header 'Content-Type: application/json'
```


```bash
curl -i --location --request PUT 'localhost:8098/types/default/buckets/s23681/keys/2' \
--header 'Vclock: a85hYGBgzGDKBVI8ziENiqtE63QgQomMeawMB05p3eLLAgA=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Alice",
    "breed": "beagle",
    "age": 12
}'
```

5.
```bash
curl -i --location --request GET 'localhost:8098/types/default/buckets/s23681/keys/3'
```


```bash
curl -i --location --request PUT 'localhost:8098/types/default/buckets/s23681/keys/3' \
--header 'Vclock: a85hYGBgzGDKBVI8ziENiqsE/cshQomMeawM309p3eLLAgA=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Bob",
    "breed": "dalmatian",
    "age": 5,
    "isSterilized": false
}'
```

6.
```bash
curl -i --location --request DELETE 'localhost:8098/types/default/buckets/s23681/keys/1'
```

7.
```bash
curl -i --location --request GET 'localhost:8098/types/default/buckets/s23681/keys/1'
```

8.
```bash
curl -i --location --request POST 'localhost:8098/types/default/buckets/s23681/keys' \
--header 'Content-Type: application/json' \
--data-raw '{
    "dog": "Woof woof"
}' 
```

9.
```bash
curl -i --location --request GET 'localhost:8098/types/default/buckets/s23681/keys/Z98ZXkQQ1gPmhFGupiliVzfa2DQ'
```

10.
```bash
curl -i --location --request DELETE 'localhost:8098/types/default/buckets/s23681/keys/Z98ZXkQQ1gPmhFGupiliVzfa2DQ'
```