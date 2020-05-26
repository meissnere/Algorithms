const raytheonJSON = require("/workspace/request.json");

const empireAPI = require('bindings')('empirejs');

console.log(empireAPI.getEmpireVersion());
console.log(empireAPI.isTrue());

console.log(raytheonJSON.parameters);

const http = require('http');

const requestListener = function (req, res) {
    res.writeHead(200);
    // console.log(raytheonJSON.parameters);
    res.end('Empire API Endpoint');
}

const server = http.createServer(requestListener);
server.listen(3001);
// server.timeout = 1000;
console.log("END OF FILE");