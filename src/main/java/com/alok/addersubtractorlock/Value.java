package com.alok.addersubtractorlock;

public class Value {
    private int value1 = 0;
    private int value2 = 0;

    public void add1(int i) {
        value1 += i;
    }
    public void subtract1(int i) {
        value1 -= i;
    }
    public int get1() {
        return value1;
    }
    public void set1(int x) {
        value1 = x;
    }
    public void add2(int i) {
        value2 += i;
    }
    public void subtract2(int i) {
        value2 -= i;
    }
    public int get2() {
        return value2;
    }
    public void set2(int x) {
        value2 = x;
    }
}
