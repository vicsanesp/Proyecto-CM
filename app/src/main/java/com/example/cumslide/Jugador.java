package com.example.cumslide;

public class Jugador {
    Pair Posicion;
    Boolean Movimiento;

    Cuarteto angulo;

    Pair posicionFinal;

    public Jugador(){
        this.Posicion = new Pair(0,0);
        this.Movimiento = Boolean.FALSE;
        this.angulo=new Cuarteto(0,0,0,0);
        this.posicionFinal = new Pair(0,0);
    }

    public Boolean getMov(){
        return this.Movimiento;
    }

    public Pair getPos(){
        return this.Posicion;
    }

    public Integer getX(){
        return this.Posicion.getX();
    }

    public Integer getY(){
        return this.Posicion.getY();
    }

    public void setMovimiento(Boolean mov){
        this.Movimiento = mov;
    }

    public void setCuarteto(Cuarteto c, Pair posAct){
        this.angulo = c;
        if (c.getA()==posAct) {
            this.posicionFinal = c.getB();
        }
        else{
            this.posicionFinal = c.getA();
        }
    }

    public Cuarteto getCuarteto(){
        return this.angulo;
    }

    public double getAngulo(){
        double deltaY = this.angulo.getAy() - this.angulo.getBy();
        double deltaX = this.angulo.getAx() - this.angulo.getBx();
        double radianes = Math.atan2(deltaY, deltaX);
        double grados = Math.toDegrees(radianes);
        return grados;
    }

    public void setX(Integer x){
        this.Posicion.setX(x);
    }

    public void setY(Integer y){
        this.Posicion.setY(y);
    }
}
