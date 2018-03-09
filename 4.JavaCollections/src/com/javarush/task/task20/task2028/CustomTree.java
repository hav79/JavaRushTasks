package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root = new Entry<>("root");

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int count = -1; //root не учитываем
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            count++;
            if (current.leftChild != null) queue.add(current.leftChild);
            if (current.rightChild != null) queue.add(current.rightChild);
        }

        return count;
    }

    @Override
    public boolean add(String s) {
//        Entry<String> entry = new Entry<>(s);
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            if (current.isAvailableToAddChildren()){
                return current.addChild(s);
            } else {
                queue.add(current.leftChild);
                queue.add(current.rightChild);
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        String name = (String) o;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            if (current.elementName.equals(name)) {
                return current.parent.removeChild(name);
            } else {
                if (current.leftChild != null) queue.add(current.leftChild);
                if (current.rightChild != null) queue.add(current.rightChild);
            }
        }
            return false;
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            if (current.leftChild != null && current.leftChild.elementName.equals(s))
                return current.elementName;
            else if (current.rightChild != null && current.rightChild.elementName.equals(s))
                return current.elementName;
            else {
                if (current.leftChild != null) queue.add(current.leftChild);
                if (current.rightChild != null) queue.add(current.rightChild);
            }
        }
        return null;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            availableToAddRightChildren = rightChild == null;
            availableToAddLeftChildren = leftChild == null;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        boolean addChild(String s) {
            if (availableToAddLeftChildren) {
                leftChild = new Entry<>(s);
                leftChild.parent = this;
                checkChildren();
                return true;
            } else if (availableToAddRightChildren) {
                rightChild = new Entry<>(s);
                rightChild.parent = this;
                checkChildren();
                return true;
            }
            return false;
        }

        boolean removeChild(String s) {
            if (leftChild.elementName.equals(s)) {
                leftChild = null;
//                checkChildren();
                return true;
            }
            else if (rightChild.elementName.equals(s)) {
                rightChild = null;
//                checkChildren();
                return true;
            }
            return false;
        }
    }
}
