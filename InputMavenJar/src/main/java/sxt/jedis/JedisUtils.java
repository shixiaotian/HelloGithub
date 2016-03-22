package sxt.jedis;

import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * redis工具
 *
 * Created by shixiaotian on 15-10-21.
 */
public class JedisUtils {

    /**
     * 创建默认本机redis
     *
     * @return Jedis
     */
    public static Jedis createJedis() {
        Jedis jedis = new Jedis("127.0.0.1");
        return jedis;
    }

    /**
     * 创建指定主机和端口的redis
     *
     * @param host 主机地址
     * @param port 端口号
     * @return Jedis
     */
    public static Jedis createJedis(String host, int port) {
        Jedis jedis = new Jedis(host, port);

        return jedis;
    }

    /**
     * 创建redis,并验证密码
     *
     * @param host 主机地址
     * @param port 端口号
     * @param passwrod 密码
     * @return Jedis
     */
    public static Jedis createJedis(String host, int port, String passwrod) {
        Jedis jedis = new Jedis(host, port);

//        if (!StringUtils.isNotBlank(passwrod))
            jedis.auth(passwrod);

        return jedis;
    }
}
