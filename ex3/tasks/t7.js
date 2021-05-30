printjson(
  db.people.deleteMany({
    $where: function () {
      return Number(this.height) >= 190;
    },
  })
);
