let mapFunction = function () {
  const key = this.nationality;
  const bmi =
    (Number(this.weight) / (Number(this.height) * Number(this.height))) * 10000;
  emit(key, { maxBmi: bmi, minBmi: bmi, sumBmi: bmi, count: 1 });
};

let reduceFunction = function (key, values) {
  const min = values.reduce((a, b) => (a < b.minBmi ? a : b.minBmi), 99999);
  const max = values.reduce((a, b) => (a > b.maxBmi ? a : b.maxBmi), 0);
  const sum = values.reduce((a, b) => a + b.sumBmi, 0);
  const count = values.reduce((a, b) => a + b.count, 0);
  return { minBmi: min, maxBmi: max, sumBmi: sum, count: count };
};

let finalizeFunction = function (key, value) {
  const { sumBmi, count, ...remaining } = value;
  const avgBmi = sumBmi / count;

  return { ...remaining, avgBmi };
};

db.people.mapReduce(mapFunction, reduceFunction, {
  out: "task1",
  finalize: finalizeFunction,
});

printjson(db.task1.find({}).toArray());
