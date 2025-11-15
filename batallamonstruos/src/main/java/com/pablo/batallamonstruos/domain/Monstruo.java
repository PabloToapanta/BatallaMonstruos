package com.pablo.batallamonstruos.domain;

public class Monstruo {
    private final String nombre;
    private int vida=100;
    private int ataque;

    public Monstruo(String nombre, int ataque){
        if (nombre==null || nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacio o nulo");
        if(ataque<=0)throw new IllegalArgumentException("EL danio no puede ser negativo");
        this.nombre=nombre;
        this.ataque=ataque;
    }
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }


    public void realizarAtaque(Monstruo monstruo){
        System.out.printf("%s ataca a %s%n",this.nombre,monstruo.getNombre());
        if(this.ataque>monstruo.getVida())monstruo.setVida(0);
        monstruo.setVida(monstruo.getVida()-this.ataque);
        System.out.printf("%s queda con %d vida%n",monstruo.getNombre(),monstruo.getVida());
    }
    @Override
    public String toString(){
        return String.format("Monstruo: %s%nVida: %d%nAtaque: %d%n",this.nombre,this.vida,this.ataque);
    }
}
