package com.ll.hashMap;

public class HashMap<K, V> {
    Object[] keys;
    Object[] values;
    int size;

    public HashMap() {
        keys = new Object[100];
        values = new Object[100];
        size = 0;
    }

    public void put(K key, V value) {
        if (isSameKey(key, value)) {
            int index = getIndexOfKey(key);
            if( index != -1 ) values[index] = value;
            return;
        }
        size++;
        keys[size-1] = key;
        values[size-1] = value;


    }

    public V get(K key) {
        int index = getIndexOfKey(key);
        if(index == -1) return null;
        return (V)values[index];
    }

    public int getIndexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)) {
                return i;
            }
        }
        return -1; // 없는 경우.
    }

    public boolean isSameKey(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return true;
            }
        }
        return false;
    }

}
