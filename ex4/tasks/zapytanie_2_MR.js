let mapFunction = function () {
  this.credit.map((card) => {
    key = card.currency;
    value = { balance: Number(card.balance) };
    emit(key, value);
  });
};

let reduceFunction = function (key, values) {
  let value = {
    balance: values.reduce((a, b) => a + b.balance, 0),
  };
  return value;
};

let finalizeFunction = function (key, value) {
  return {
    currency: key,
    balance: value.balance,
  };
};

db.people.mapReduce(mapFunction, reduceFunction, {
  out: "task1",
  finalize: finalizeFunction,
});

printjson(db.task1.find({}).toArray());
