/* 读取文件 */
var rf=require("fs");
rf.readFile("test.txt",'utf-8',function(err,data){
    if(err){
        console.log("error");
    }else{
        console.log(data);
    }
});
console.log("READ FILE ASYNC END");