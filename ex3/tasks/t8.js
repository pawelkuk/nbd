printjson(
  db.people.update(
    {
      "location.city": "Moscow",
    },
    { $set: { "location.city": "Moskwa" } },
    false,
    true
  )
);
