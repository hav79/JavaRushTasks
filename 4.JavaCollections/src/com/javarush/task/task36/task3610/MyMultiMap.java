package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return map.values().stream().mapToInt(List::size).sum();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        List<V> valueList = map.get(key);
        if (valueList == null) {
            valueList = new ArrayList<>();
            valueList.add(value);
            map.put(key, valueList);
            return null;
        } else {
            V lastValue = valueList.get(valueList.size() - 1);
            if (valueList.size() < repeatCount) {
                valueList.add(value);
            } else if (valueList.size() == repeatCount) {
                valueList.remove(0);
                valueList.add(value);
            }
            return lastValue;
        }
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if (!map.containsKey(key))
            return null;
        List<V> valueList = map.get(key);
        V value = valueList.isEmpty() ? null : valueList.remove(0);
        if (valueList.isEmpty())
            map.remove(key);
        return value;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> allValues = new ArrayList<>();
        map.values().forEach(allValues::addAll);
        return allValues;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        boolean contains = false;
        for (List<V> list : map.values())
            if (list.contains(value))
                contains = true;
        return contains;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}