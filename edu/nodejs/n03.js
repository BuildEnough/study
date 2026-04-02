const express = require("express");
const path = require("path");
const app = express();
const port = 3300;
const _path = path.join(__dirname, "dist");

app.use(express.static(_path));

app.listen(port, () => {
  console.log(`Example app listening on port http://localhost:${port}`);
});