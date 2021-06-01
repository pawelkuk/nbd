```bash
HTTP/1.1 200 OK
X-Riak-Vclock: a85hYGBgzGDKBVI8ziENiqtE63QgQomMeawMB05p3eLLAgA=
Vary: Accept-Encoding
Server: MochiWeb/1.1 WebMachine/1.10.9 (cafe not found)
Link: </buckets/s23681>; rel="up"
Last-Modified: Tue, 01 Jun 2021 15:14:08 GMT
ETag: "6OdCgKxhR5lIcHEnEmeZOS"
Date: Tue, 01 Jun 2021 15:37:55 GMT
Content-Type: application/json
Content-Length: 87

{
    "name": "Alice",
    "breed": "beagle",
    "age": 12,
    "isSterilized": true
}
```

```bash
HTTP/1.1 204 No Content
Vary: Accept-Encoding
Server: MochiWeb/1.1 WebMachine/1.10.9 (cafe not found)
Date: Tue, 01 Jun 2021 15:39:46 GMT
Content-Type: application/json
Content-Length: 0
```