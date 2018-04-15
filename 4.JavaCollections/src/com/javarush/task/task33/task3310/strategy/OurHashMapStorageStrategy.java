package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    @Override
    public boolean containsKey(Long key) {
        return getValue(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        return getKey(value) != null;
    }

    @Override
    public void put(Long key, String value) {
        int keyHash = hash(key);
        int pos = indexFor(keyHash, table.length);
        Entry entry = table[pos];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.value = value;
                break;
            }
            entry = entry.next;
        }
        if (entry == null)
            addEntry(hash(key), key, value, pos);
    }

    @Override
    public Long getKey(String value) {
        for (Entry entry : table) {
            Entry e = entry;
            while (e != null) {
                if (e.value.equals(value))
                    return e.getKey();
                e = e.next;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).getValue();
    }

    public int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Entry entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key))
                return entry;
            entry = entry.next;
        }
        return null;
    }

    void resize(int newCapacity) {
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    void transfer(Entry[] newTable) {
        for (Entry e : table) {
            Entry entry = e;
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);
                newTable[newIndex] = entry;
//                entry = entry.next;
                entry.next = null;
                entry = next;
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (size > threshold) {
            resize(2 * table.length);
            bucketIndex = indexFor(hash(key), table.length);
        }
        createEntry(hash, key, value, bucketIndex);
//        Entry first = table[bucketIndex];
//        table[bucketIndex] = new Entry(hash, key, value, first);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry firstEntry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, firstEntry);
        size++;
    }
}
