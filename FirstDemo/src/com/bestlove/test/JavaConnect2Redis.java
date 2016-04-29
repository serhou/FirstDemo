package com.bestlove.test;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Redis key-value数据库
 * @author think
 *
 */

public class JavaConnect2Redis {

	public static void main(String[] args) {
		//Connecting to Redis server 远程数据库
		Jedis jedis = new Jedis("192.168.18.129", 6379, 10000);
		jedis.connect();
		System.out.println(jedis.ping());
		System.out.println(jedis.get("foo"));
		System.out.println(jedis.get("age"));
		String info = jedis.info();
		System.out.println(info);
		//lpush
		jedis.lpush("tutorial-list", "张三丰");
		jedis.lpush("tutorial-list", "李元霸");
		jedis.lpush("tutorial-list", "李香君");
		jedis.lpush("tutorial-list", "柳如是");
		List<String> list = jedis.lrange("tutorial-list", 0, 5);
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println(jedis.lrange("tutoriallist", 0, 6));
		//查找所有符合模式的key
		Set set = jedis.keys("t*");
		for (Object object : set) {
			System.out.println(object);
		}
		//delete list
		System.out.println(jedis.del("tutorial-list"));
		//hmset
		System.out.println(jedis.hgetAll("user:1"));
		//sadd 
		System.out.println(jedis.smembers("tutoriallist-list"));
		//zadd  zset (sorted set: 有序集合)
		System.out.println(jedis.zrangeByScore("tutoriallist-z", 0, 1000));
		System.out.println(jedis.set("sex", "男"));
		System.out.println(jedis.get("sex"));
		System.out.println(jedis.del("sex"));
		System.out.println(jedis.get("sex"));
		System.out.println(jedis.exists("sex"));
		System.out.println(jedis.exists("foo"));
		//从当前数据库中随机返回一个key
		System.out.println(jedis.randomKey());
		//返回key所存储的值的类型
		System.out.println(jedis.type("tutoriallist-list"));
		System.out.println(jedis.type("tutoriallist"));
		System.out.println(jedis.type("tutoriallist-z"));
		System.out.println(jedis.type("dbname"));
		System.out.println(jedis.type("age"));
		//修改key的名称
//		System.out.println(jedis.rename("foo", "dbname"));
		System.out.println(jedis.get("dbname"));
		
		//HyperLogLog 是用来做基数统计的算法
		jedis.pfadd("dbproducts", "redis");
		jedis.pfadd("dbproducts", "mongodb");
		jedis.pfadd("dbproducts", "oracle");
		jedis.pfadd("dbproducts", "mysql");
		jedis.pfadd("dbproducts", "db2");
		jedis.pfadd("dbproducts", "pgsql");
		jedis.pfadd("dbproducts", "noe4j");
		jedis.pfadd("dbproducts", "SQLite");
		jedis.pfadd("dbproducts", "SQLServer");
		System.out.println(jedis.pfcount("dbproducts"));
		jedis.del("dbproducts");
		//订阅服务 一个客户端要开通一个频道：SUBSCRIBE redisChat
		jedis.publish("redisChat", "Hello, Redis!");
		//Redis先以multi开始一个事务 然后将多个命令入队到事务中，最后有EXEC命令触发事务，一并执行事务中的所有命令
		long start = System.currentTimeMillis();
		//开始事务
		Transaction tx = jedis.multi();
		//命令入队
		tx.set("book-name", "Thinking in Java");
		System.out.println(tx.get("book-name"));
		tx.sadd("tag", "Java", "Programming", "HotSpot");
		System.out.println(tx.smembers("tag"));
		System.out.println(tx.smembers("Programming"));
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				tx.set("wait"+i, "low"+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//触发事务
		tx.exec();
		long end = System.currentTimeMillis();
		System.out.println("用时："+((end-start)/1000)+"s");
		jedis.disconnect();
		
	}
	
	
}
