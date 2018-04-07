package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();
        ClassLoader loader = new AnimalClassLoader(pathToAnimals, Solution.class.getClassLoader());
        try {
            List<Path> files = Files.walk(Paths.get(pathToAnimals))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            for (Path file : files) {
                String filename = file.getFileName().toString();
                String className = filename.substring(0, filename.indexOf('.'));
                Class clazz = loader.loadClass(className);

                Class[] interfaces = clazz.getInterfaces();
                boolean hasInterface = false;
                for (Class anInterface : interfaces)
                    if (Animal.class.equals(anInterface))
                        hasInterface = true;

                Constructor[] constructors = clazz.getConstructors();
                boolean hasConstructor = false;
                for (Constructor constructor : constructors) {
                    if (Modifier.isPublic(constructor.getModifiers())
                            && constructor.getParameterCount() == 0)
                        hasConstructor = true;
                }

                if (hasInterface && hasConstructor)
                    set.add((Animal) clazz.newInstance());
            }
        } catch (Exception e) {

        }
        return set;
    }
}
