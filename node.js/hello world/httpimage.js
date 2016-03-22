/* 服务器返回图片 */
require('http').createServer(
	function(req, res) {

		res.writeHead(200,{'Content-type':'image/gif'});
		var stream = require('fs').createReadStream('src/1.gif');
		stream.on('data',function(data) {
			res.write(data);
		});

		stream.on('end',function () {
			res.end();
		});

	}).listen(3000);