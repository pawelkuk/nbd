let mapFunction = function () {
  this.credit.map((card) => {
    key = card.currency;
    value = { balance: Number(card.balance), count: 1 };
    emit(key, value);
  });
};

let reduceFunction = function (key, values) {
  const value = {
    balance: values.reduce((a, b) => a + b.balance, 0),
    count: values.reduce((a, b) => a + b.count, 0),
  };
  return value;
};

let finalizeFunction = function (key, value) {
  const avgBalance = value.balance / value.count;
  return {
    currency: key,
    summedBalance: value.balance,
    avgBalance: avgBalance,
  };
};

db.people.mapReduce(mapFunction, reduceFunction, {
  out: "task1",
  query: { sex: "Female", nationality: "Poland" },
  finalize: finalizeFunction,
});

printjson(db.task1.find({}).toArray());
