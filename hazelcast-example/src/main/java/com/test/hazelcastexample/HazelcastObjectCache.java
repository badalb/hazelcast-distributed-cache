package com.test.hazelcastexample;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.test.hazelcastexample.domian.Employee;

public class HazelcastObjectCache {

	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.addAddress("127.0.0.1");
		HazelcastInstance client = HazelcastClient
				.newHazelcastClient(clientConfig);
		IMap<Object, Object> map = client.getMap("employees");
		printMap(map);
		map.put(1, new Employee("John Travolta"));
		map.put(2, new Employee("Cristian Bale"));
		printMap(map);
	}

	@SuppressWarnings("unchecked")
	private static void printMap(@SuppressWarnings("rawtypes") Map map) {
		System.out.println("Map Size:" + map.size());
		Set<Entry<Integer, Employee>> customers = map.entrySet();
		for (Iterator<Entry<Integer, Employee>> iterator = customers.iterator(); iterator
				.hasNext();) {
			Entry<Integer, Employee> entry = (Entry<Integer, Employee>) iterator
					.next();
			String empName = ((Employee) entry.getValue()).getFirstName();
			System.out.println("Employee Id : " + entry.getKey()
					+ " Employee Name : " + empName);
		}
	}

}
