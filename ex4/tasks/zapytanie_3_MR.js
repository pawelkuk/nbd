let mapFunction = function () {
  key = this.job;
  emit(key, { count: 1 });
};

let reduceFunction = function (key, values) {
  return null;
};

let finalizeFunction = function (key, value) {
  return null;
};

db.people.mapReduce(mapFunction, reduceFunction, {
  out: "task1",
  finalize: finalizeFunction,
});

printjson(
  db.task1
    .find({}, { _id: 1 })
    .toArray()
    .map((el) => el._id)
);
