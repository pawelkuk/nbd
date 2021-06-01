import riak
import time

print("Waiting for riak to come up...")
time.sleep(5)

client = riak.RiakClient(
    pb_port=8087,
    protocol="pbc",
    nodes=[{"host": "coordinator", "http_port": 8098, "pb_port": 8087}],
)
bucket = client.bucket_type("default").bucket("s23681")

obj = riak.RiakObject(client, bucket, "doggie")
obj.content_type = "text/plain"
obj.data = "What a nice doggie it is! Woof woof"


try:
    print(f"Trying to store object {obj.key}")
    obj.store()
except Exception as e:
    print("Something went horribly wrong", e)

if "doggie" in bucket.get_keys():
    print(f"Object {obj.key} has been stored")

obj_to_update = bucket.get("doggie")
print(
    "Object before updating:", {"key": obj_to_update.key, "value": obj_to_update.data}
)
obj_to_update.data = "This updated doggie is even better"
obj_to_update.store()

obj_updated = bucket.get("doggie")
print("Doggie after updating:", {"key": obj_updated.key, "value": obj_updated.data})


print("Deleting doggie...")
bucket.delete("doggie")

print("Trying to read doggie again...")
deleted_obj = bucket.get("doggie")
if deleted_obj.data is None:
    print("Deletion successfull", {"key": deleted_obj.key, "value": deleted_obj.data})
else:
    print("something went wrong")
