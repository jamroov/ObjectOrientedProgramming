package com.company.Generics;

public class SuperNumber<T extends Number> {
    public T obj;

    public SuperNumber(T obj) {
        this.obj = obj;
    }

    public Double returnDbl() {
        return obj.doubleValue();
    }

    public Integer returnInt() {
        return obj.intValue();
    }

    public Boolean dblsEqual(SuperNumber<T> num) {
        return Math.abs(this.obj.doubleValue()) == Math.abs(num.obj.doubleValue());
    }

    public Boolean intsEqual(SuperNumber<T> num) {
        return Math.abs(this.obj.intValue()) == Math.abs(num.obj.intValue());
    }

    public Boolean valEqual() {
        return this.obj.doubleValue() == this.obj.intValue();
    }
}
