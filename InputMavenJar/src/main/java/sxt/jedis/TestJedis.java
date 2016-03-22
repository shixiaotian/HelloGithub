package sxt.jedis;

import redis.clients.jedis.Jedis;

/**
 * 学习redis
 *
 * Created by shixiaotian on 15-10-21.
 */
public class TestJedis {


    public static void main(String[]  arg){

        //主redis
        Jedis jedis = JedisUtils.createJedis("127.0.0.1", 6379);
        //绑定值
        jedis.append("name", "shixiaotian");
        //查看
        System.out.println("redis1---->"+jedis.get("name"));

        //从redis
        Jedis jedis2 = JedisUtils.createJedis("127.0.0.1", 6380);
        //输出从主redis同步到从redis的数据
        System.out.println("redis2---->"+jedis2.get("name"));

    }

}
