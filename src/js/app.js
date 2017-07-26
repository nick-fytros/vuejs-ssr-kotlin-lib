const uuidv4 = require('uuid/v4');
const http = require('http');

const server = http.createServer(function (request, response) {
    response.writeHead(200, {'Content-Type': 'text/plain'});
    response.end(someKotlinMethod(logUUID()));
});

function logUUID() {
    return uuidv4();
}

server.listen(8000);

console.log('Server running at http://127.0.0.1:8000/');