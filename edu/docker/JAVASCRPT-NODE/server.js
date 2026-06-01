const express = require('express');

const app = express();
const PORT = 3300;

// Simple middleware and route
app.use(express.json());

app.get('/', (req, res) => {
  res.send('Hello from Express on port ' + PORT);
});

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});

// Note: run `npm install express` before starting the server