package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {

    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
        }
        return 0L;
    }

    public void putEntry(Entry entry) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path));
            outputStream.writeObject(entry);
            while ((entry = entry.next) != null)
                outputStream.writeObject(entry);
        } catch (IOException e) {
        }
    }

    public Entry getEntry() {
        Entry result = null;
        try {
            if (getFileSize() != 0) {
                ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path));
                Entry entry = (Entry) inputStream.readObject();
                result = entry;
                while (inputStream.available() > 0) {
                    entry.next = (Entry) inputStream.readObject();
                    entry = entry.next;
                }
            }
        } catch (Exception e) {
        }
        return result;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
        }
    }
}
