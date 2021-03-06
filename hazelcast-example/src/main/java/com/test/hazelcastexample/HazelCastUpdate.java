package com.test.hazelcastexample;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastUpdate {

	public static void main(String[] args) {
		Config cfg = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
		Map<Integer, String> customerMap = instance.getMap("customers");
		customerMap.put(3, "Mumbai");
		customerMap.put(4, "Kolkata");
		customerMap.put(5, "Delhi");

		System.out.println("Map Size:" + customerMap.size());
		Set<Entry<Integer, String>> customers = customerMap.entrySet();

		for (Iterator<Entry<Integer, String>> iterator = customers.iterator(); iterator
				.hasNext();) {
			Entry<Integer, String> entry = (Entry<Integer, String>) iterator
					.next();
			System.out.println("Customer Id : " + entry.getKey()
					+ " Customer Name : " + entry.getValue());
		}
	}
}
