package connect;

import redis.clients.jedis.Jedis;

public class RedisTest {

    public static void main(String[] args) {

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("39.99.195.107",6379);
        jedis.auth("123456");
//      jedis.select(1);
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());

    }
}
