因为项目中要用到事务，而且还要保证sql语句的顺序执行，所以有了下面的代码。
也是用了好多种方法，最后决定有下面的，希望能满足你的需求。

// 加载mysql
var mysql = require(’./mysqlConn’);
// 加载mysql-queues 支持事务
var queues = require(‘mysql-queues’);
// 加载async 支持顺序执行
var async = require(‘async’);

var db_tran = function(){
// 获取事务
	queues(mysql);
	var trans = mysql.startTransaction();

async.series([
    function(insert_cb) { 
    	var insert_sql = "INSERT INTO `shop` (`id`, `name`, `address`, `tel`, `fax`, `mail`, `shop_kbn`, `modified_date`, `modified_id`) VALUES ('18', '1212', '1212', '12', '12', '12', '12', '2013-05-28 16:10:15', '0')";
    	// 执行第一条sql语句 如果出错 直接进入最后的 错误方法 回滚事务
    	trans.query(insert_sql, function(err, info) {
    		insert_cb(err, info);
    	})
    	
    },
    function(update_cb_1) { 
    	var update_sql_1 = "UPDATE `shop` SET `address`='管理会社  1' WHERE `id`='17'";
    	
    	// 执行第二条sql语句 如果出错 直接进入最后的 错误方法 回滚事务
    	trans.query(update_sql_1, function(err, info) {
    		update_cb_1(err, info);
    	})
    },
    function(update_cb_2) {
    	var update_sql_2 = "UPDATE `shop` SET `address`='管理会社  2' WHERE `id`='16'";
    	// 执行第三条sql语句 如果出错 直接进入最后的 错误方法 回滚事务
    	trans.query(update_sql_2, function(err, info) {
    		update_cb_2(err, info);
    	})
    	
    }
], function(err, results) {
	if (err) {
		console.log("rollback");
		// 出错的场合 回滚
		trans.rollback();
	} else {
		// 没有错误的场合 提交事务
		trans.commit();
	}
	
});
// 执行这个事务
trans.execute();
}