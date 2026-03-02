package edu.frcc.csc1061j.MyHashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
	private final static double LOAD_FACTOR_THRESHOLD = 0.5;
	private final static int INITAIL_NUM_BUCKETS = 4;

	private LinkedList<Entry<K, V>>[] buckets;
	private int size;

	private class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
	}

	public MyHashMap() {
		buckets = new LinkedList[INITAIL_NUM_BUCKETS];
		size = 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean containsKey(Object key) {
		return true;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<>();
		for (LinkedList<Entry<K, V>> bucket : buckets) {
			if (bucket != null) {
				for (Entry<K, V> entry : bucket) {
					set.add(entry);
				}
			}
		}
		return set;
	}

	@Override
	public V get(Object key) {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<>();
		for (LinkedList<Entry<K, V>> bucket : buckets) {
			if (bucket != null) {
				for (Entry<K, V> entry : bucket) {
					set.add(entry.getKey());
				}
			}
		}

		return null;
	}

	@Override
	public V put(K key, V value) {
		// Set hashVal positive hashCode
		int hashVal = Math.abs(key.hashCode());

		// Hash Function to store the hashVal in a bucket
		int bucketIndex = hashVal % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

		// Look for existing keys since we cannot have
		// duplicate keys in the map.
		if (bucket != null) {
			for (Entry<K, V> entry : bucket) {
				if (entry.getKey().equals(key)) {
					V oldVal = entry.setValue(value);
					return oldVal;
				}
			}
		}

		// Key does not exist, we need to add entry
		// TODO Check if the load factor threshold has been exceeded
		// and take action
		// rehash()
		if (bucket == null) {
			bucket = new LinkedList<Entry<K, V>>();
			buckets[bucketIndex] = bucket;
		}

		bucket.add(new Entry<K, V>(key, value));
		size++;

		return null;
	}

	// private void rehash()

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {

	}

	@Override
	public V remove(Object key) {
		// Set hashVal positive hashCode
		int hashVal = Math.abs(key.hashCode());

		// Hash Function to store the hashVal in a bucket
		int bucketIndex = hashVal % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

		if (bucket != null) {
			for (Entry<K, V> entry : bucket) {
				if (entry.getKey().equals(key)) {
					V oldVal = entry.getValue();
					bucket.remove(entry);
					size--;
					return oldVal;
				}
			}
		}

		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Collection<V> values() {
		return null;
	}
}