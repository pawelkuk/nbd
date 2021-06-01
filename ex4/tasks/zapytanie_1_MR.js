let groupBySex = function () {
  let key = this.sex;
  let value = {
    count: 1,
    weight: Number(this.weight),
    height: Number(this.height),
  };
  emit(key, value);
};

let reduceFunction = function (key, values) {
  let value = {
    count: values.reduce((a, b) => a + b.count, 0),
    weight: values.reduce((a, b) => a + b.weight, 0),
    height: values.reduce((a, b) => a + b.height, 0),
  };
  return value;
};

let finalizeFunction = function (key, value) {
  return {
    sex: key,
    avgHeight: value.height / value.count,
    avgWeight: value.weight / value.count,
  };
};

db.people.mapReduce(groupBySex, reduceFunction, {
  out: "task1",
  finalize: finalizeFunction,
});

printjson(db.task1.find({}).toArray());
