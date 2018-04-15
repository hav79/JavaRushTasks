package com.javarush.task.task36.task3606;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        ClassLoader loader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                Class result = null;
                try {
                    Path classFile = Paths.get(packageName).resolve(name + ".class");
                    byte[] classBytes = Files.readAllBytes(classFile);
                    result = defineClass(null, classBytes, 0, classBytes.length);
                } catch (IOException e) {
                }
                return result;
            }
        };

        try {
            List<Path> files = Files.walk(Paths.get(packageName))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            for (Path file : files) {
                String filename = file.getFileName().toString();
                String className = filename.substring(0, filename.indexOf('.'));
                Class clazz = loader.loadClass(className);

                Class[] interfaces = clazz.getInterfaces();
                for (Class anInterface : interfaces)
                    if (HiddenClass.class.equals(anInterface))
                        hiddenClasses.add(clazz);
            }
        } catch (Exception e) {

        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        HiddenClass result = null;
        try {
            for (Class hiddenClass : hiddenClasses)
                if (hiddenClass.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                    Constructor[] constructors = hiddenClass.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterCount() == 0) {
                            constructor.setAccessible(true);
                            result = (HiddenClass) constructor.newInstance();
                            break;
                        }
                    }
                }
        } catch (Exception e) {
            System.out.println("error");
        }
        return result;
    }
}

