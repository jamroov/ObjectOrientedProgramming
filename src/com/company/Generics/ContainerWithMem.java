package com.company.Generics;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ContainerWithMem<T> implements Collection<T> {
    public List<T> list = new ArrayList<T>();
    public ArrayList<List<T>> history = new ArrayList<>();
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
        List<T> copy = new ArrayList<>(this.list);
        this.history.add(copy);
        this.numChanges += 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        this.list.remove(o);
        List<T> copy = new ArrayList<>(this.list);
        this.history.add(copy);
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
        List<T> copy = new ArrayList<>(this.list);
        this.history.add(copy);
        this.numChanges += 1;
    }

    public List<T> getRevision(int rev) {
        return this.history.get(rev);
    }

    public void printRevision(int rev) {
        System.out.println(Arrays.toString(this.history.get(rev).toArray()));
    }

    public void printAllRevisions() {
        System.out.printf("Number of revisions: %d\n", this.numChanges);
        int i = 0;
        for (List<T> list : this.history) {
            System.out.printf("%d: ", i);
            System.out.println(Arrays.toString(list.toArray()));
            i += 1;
        }
    }

    public void restoreToRevision(int rev) {
        this.list = this.history.get(rev);
        this.numChanges += 1;
        List<T> copy = new ArrayList<>(this.list);
        this.history.add(copy);
    }
}
