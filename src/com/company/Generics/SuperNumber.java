package com.company.Generics;

public class SuperNumber<T extends Number> {
    public T obj;

    public SuperNumber(T obj) {
        this.obj = obj;
    }

    public Double returnDbl() {
        return (Double) obj;
    }

    public Integer returnInt() {
        return (Integer) obj;
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
