package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AnimalClassLoader extends ClassLoader {

    private String classPath;

    public AnimalClassLoader(String classPath, ClassLoader parent) {
        super(parent);
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String name) {
        Class result = null;
        try {
            Path classFile = Paths.get(classPath).resolve(name + ".class");
            byte[] classBytes =  Files.readAllBytes(classFile);
            result = defineClass(null, classBytes, 0, classBytes.length);
        } catch (IOException e) {
        }
        return result;
    }
}
