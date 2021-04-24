package com.company.Generics;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Container<T> implements Collection<T> {
    public List<T> list = new ArrayList<T>();
    public Integer numChanges = 0;

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(T o) {
        this.list.add(0, o);
        this.numChanges += 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        this.list.remove(o);
        this.numChanges += 1;
        return true;
    }

    @Override
    public boolean addAll(@NotNull Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(@NotNull Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(@NotNull Object[] objects) {
        return new Object[0];
    }

    public void deleteAll() {
        this.list.clear();
        this.numChanges += 1;
    }
}
