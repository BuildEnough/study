const express = require('express');
const path = require('path');
const fs = require('fs');

const app = express();
const PORT = 3301;

const distPath = path.join(__dirname, 'dist');
const indexPath = path.join(distPath, 'index.html');

console.log('distPath:', distPath);
console.log('index exists:', fs.existsSync(indexPath));

app.use((req, res, next) => {
    console.log('요청 들어옴:', req.method, req.url);
    next();
});

app.use(express.static(distPath));

app.use((req, res) => {
    res.sendFile(indexPath);
});

app.listen(PORT, '0.0.0.0', () => {
    console.log(`Server is running on http://0.0.0.0:${PORT}`);
});