package com.ll.hashMap;

import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> {
    Object[] keys;
    Object[] values;
    int size;

    public HashMap() {
        keys = new Object[2];
        values = new Object[2];
        size = 0;
    }

    public void put(K key, V value) {
        if (isSameKey(key, value)) {
            int index = getIndexOfKey(key);
            if( index != -1 ) values[index] = value;
            return;
        }
        sizeUpArr();

        size++;
        keys[size-1] = key;
        values[size-1] = value;

    }

    public void sizeUpArr() {
        if(size == keys.length) {    // 배열이 full 이면, 확장한다.
            keys = Util.arr.sizeUp(keys);
            values = Util.arr.sizeUp(values);
        }
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

    public int size() {
        return size;
    }

    public void remove(K key) {
        int removeKey = getIndexOfKey(key);
        if (removeKey == -1) {
            System.out.println("삭제할 값이 없습니다.");
            return;
        }
        Util.arr.moveLeft(keys, removeKey+1, size-1);  // removeKey 우측에 있는 키부터 왼쪽으로 차례대로 옮겨준다.
        Util.arr.moveLeft(keys, removeKey+1, size-1);

        size--;
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            keySet.add((K)keys[i]);
        }
        return keySet;
    }


}
