const express = require("express");
const app = express();
const port = 3000;

/* JSON 해석기 */
app.use(express.json());
/* POST 방식을 위한 해석 */
app.use(express.urlencoded({ extended: true }));

let num = 0;

app.get("/", (req, res) => {
  console.log(__dirname);
  res.sendFile("D:\nodejs\dist\index2.html");
});

app.post("/data", (req, res) => {
  const { name, age } = req.body;
  const newUser = {
    id: num++,
    name,
    age,
  };

  console.log(newUser);
  res.json(newUser);
});

app.listen(port, () => {
  console.log(`Example app listening on port http://localhost:${port}`);
});