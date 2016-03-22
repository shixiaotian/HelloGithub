// //redis 链接
// var redis   = require('redis');
// var client  = redis.createClient('7000', '192.168.1.200');
// // redis 链接错误
// client.on("error", function(error) {
//     console.log(error);
// });

// // 向特定的redis机器上绑定数据
// cluster.set('foo', 'bar');
// // 从特定redis上获取数据
// cluster.get('foo', function (err, res) {
  
//   console.log(res);

// });

// // set
// client.set('str_key_0', '0', function(error, res) {
//     if(error) {
//         console.log(error);
//     } else {
//         console.log(res);
//     }

//     // 关闭链接
//    
//     // 关闭链接
//     client.end();
// }); client.end();
// });

// // get
// client.get('str_key_0', function(error, res){
//     if(error) {
//         console.log(error);
//     } else {
//         console.log(res);
//     }
// 注意，不一样的模块
var Redis = require('ioredis');

// 不一样的创建方式，多台获取，出来就是集群
var cluster = new Redis.Cluster(
    [{
      port: 7000,
      host: '192.168.1.200'
    }, {
      port: 7001,
      host: '192.168.1.200'
    }, {
      port: 7002,
      host: '192.168.1.200'
    }]
);
// 设置数据相同
cluster.set('foo', 'bar');
// 获取数据相同
cluster.get('foo', function (err, res) {
  
  console.log(res);
  
});