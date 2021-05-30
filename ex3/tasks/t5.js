const projection = { _id: 0, first_name: 1, last_name: 1, city: 1 };
const res = db.people.aggregate([
  {
    $project: {
      first_name: 1,
      last_name: 1,
      "location.city": 1,
      birth_date: 1,
      date: {
        $dateFromString: {
          dateString: "$birth_date",
        },
      },
    },
  },
  {
    $replaceWith: {
      firstName: "$first_name",
      lastName: "$last_name",
      city: "$location.city",
      birthDate: "$birth_date",
      date: "$date",
    },
  },
  {
    $match: {
      date: {
        $lt: ISODate("2000-01-01T00:00:00.000Z"),
        $gte: ISODate("1900-01-01T00:00:00.000Z"),
      },
    },
  },
  {
    $project: {
      firstName: 1,
      lastName: 1,
      city: 1,
    },
  },
]);
printjson(res.toArray());
