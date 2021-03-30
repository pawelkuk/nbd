printjson(
  db.people
    .find({
      $where: function () {
        return Number(this.weight) >= 68 && Number(this.weight) < 71.5;
      },
    })
    .toArray()
);
