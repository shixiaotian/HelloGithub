/* 服务器返回字符 */
require('http').createServer(function(req,res) {

	res.writeHead(200);
	res.write("new ");
	setTimeout(function() {
		res.end('hello nodejs');
	},20000);
	
	
}).listen(3000);