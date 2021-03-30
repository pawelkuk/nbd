me = {
  sex: "Male",
  first_name: "Paweł",
  last_ame: "Kukliński",
  job: "Software Eng.",
  email: "paffcio314[at]gmail.com",
  location: {
    city: "Warszawa",
    address: {
      streetname: "Długa",
      streetnumber: "36",
    },
  },
  description: "Some description",
  height: "181.61",
  weight: "82.3",
  birth_date: "1996-06-27T05:44:11Z",
  nationality: "Poland",
  credit: [
    {
      type: "laser",
      number: "5586087121891962",
      currency: "IDR",
      balance: "5512.36",
    },
  ],
};
printjson(db.people.insert(me));
