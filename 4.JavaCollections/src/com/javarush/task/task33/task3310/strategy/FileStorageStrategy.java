package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10_000L;
    int size;
    long maxBucketSize = DEFAULT_BUCKET_SIZE_LIMIT;

    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;

    public FileStorageStrategy() {
        for (int i = 0; i < table.length; i++) {
            table[i] = new FileBucket();
        }
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        return getKey(value) != null;
    }

    @Override
    public void put(Long key, String value) {
        int keyHash = hash(key);
        int pos = indexFor(keyHash, table.length);
        FileBucket fileBucket = table[pos];
        Entry firstEntry = fileBucket.getEntry();
        Entry entry = firstEntry;
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.value = value;
                fileBucket.putEntry(firstEntry);
                break;
            }
            entry = entry.next;
        }
        if (entry == null)
            addEntry(hash(key), key, value, pos);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fileBucket : table) {
            Entry e = fileBucket.getEntry();
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
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        FileBucket fileBucket = table[index];
        Entry entry = fileBucket.getEntry();
        while (entry != null) {
            if (entry.getKey().equals(key))
                return entry.getValue();
            entry = entry.next;
        }
        return null;
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
        FileBucket fileBucket = table[index];
        Entry entry = fileBucket.getEntry();
        while (entry != null) {
            if (entry.getKey().equals(key))
                return entry;
            entry = entry.next;
        }
        return null;
    }

    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
//        threshold = (int) (newCapacity * loadFactor);
    }

    void transfer(FileBucket[] newTable) {
        for (FileBucket fileBucket : table) {
            Entry entry = fileBucket.getEntry();
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);
                newTable[newIndex] = new FileBucket();
                newTable[newIndex].putEntry(entry);
//                entry = entry.next;
                entry.next = null;
                entry = next;
            }
            fileBucket.remove();
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (table[bucketIndex].getFileSize() > bucketSizeLimit) {
            resize(2 * table.length);
            bucketIndex = indexFor(hash(key), table.length);
        }
        createEntry(hash, key, value, bucketIndex);
//        FileBucket fileBucket = table[bucketIndex];
//        Entry first = fileBucket.getEntry();
//        fileBucket.putEntry(new Entry(hash, key, value, first));
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        FileBucket fileBucket = table[bucketIndex];
        Entry firstEntry = fileBucket.getEntry();
        fileBucket.putEntry(new Entry(hash, key, value, firstEntry));
        size++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }
}
