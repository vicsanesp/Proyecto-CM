package com.example.cumslide;

public class Bridge {
    public static Pair source;
    public static Pair target;

    public Bridge(Integer a, Integer b, Integer c, Integer d){
        this.source = new Pair(a,b);
        this.target = new Pair(c,d);
    }

    //public static Pair getSource(){
    //    return source;
    //}

    //public static Pair getTarget(){
    //    return target;
    //}

    public static Integer getSourceX(){
        return source.getX();
    }

    public static Integer getSourceY(){
        return source.getY();
    }

    public static Integer getTargetX(){
        return target.getX();
    }

    public static Integer getTargetY(){
        return target.getY();
    }
}