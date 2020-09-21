package juc;


import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


/**
 * java.util.ConcurrentModificationException
 *
 */
public class NotSafeDemo03 {

	public static void main(String[] args) {

		Map<String,String> map = new ConcurrentHashMap<String, String>();//new HashMap();
		
		for(int i = 0; i < 30; i ++) {
			new Thread(() -> {
				map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
				System.out.println(map);
			},String.valueOf(i)).start();
		}
				
	}
	
}