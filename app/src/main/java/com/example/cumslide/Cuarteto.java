package com.example.cumslide;

public class Cuarteto {
    private Pair a;
    private Pair b;

    public Cuarteto(Integer a, Integer b, Integer c, Integer d){
        this.a = new Pair(a,b);
        this.b = new Pair(c,d);
    }

    public Pair getA(){
        return this.a;
    }

    public Pair getB(){
        return this.b;
    }

    public Integer getAx(){
        return this.a.getX();
    }

    public Integer getAy(){
        return this.a.getY();
    }

    public Integer getBx(){
        return this.b.getX();
    }

    public Integer getBy(){
        return this.b.getY();
    }
}
