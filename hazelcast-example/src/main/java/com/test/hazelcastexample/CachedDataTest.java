package com.test.hazelcastexample;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class CachedDataTest {

	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.addAddress("127.0.0.1");
		HazelcastInstance client = HazelcastClient
				.newHazelcastClient(clientConfig);
		IMap<Object, Object> map = client.getMap("customers");
		printMap(map);

	}

	@SuppressWarnings("unchecked")
	private static void printMap(@SuppressWarnings("rawtypes") Map map) {
		System.out.println("Map Size:" + map.size());
		Set<Entry<Integer, String>> customers = map.entrySet();
		for (Iterator<Entry<Integer, String>> iterator = customers.iterator(); iterator
				.hasNext();) {
			Entry<Integer, String> entry = (Entry<Integer, String>) iterator
					.next();
			System.out.println("Customer Id : " + entry.getKey()
					+ " Customer Name : " + entry.getValue());
		}
	}

}
