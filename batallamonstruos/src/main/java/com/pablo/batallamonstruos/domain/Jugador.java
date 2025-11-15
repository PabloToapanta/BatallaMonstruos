package com.pablo.batallamonstruos.domain;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
     private List<Monstruo> listaMonstruo;
    private String nombre;
    private Monstruo monstruoActual;
    public Jugador(String nombre){  
        listaMonstruo = new ArrayList<>();
        if(nombre == null || nombre.isEmpty())throw new IllegalArgumentException("El nombre no puede ser nulo");
        this.nombre=nombre;
    }

    public List<Monstruo> getListaMonstruo() {
        return listaMonstruo;
    }

    public void setListaMonstruo(List<Monstruo> listaMonstruo) {
        this.listaMonstruo = listaMonstruo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Monstruo getMonstruoActual() {
        return monstruoActual;
    }

    public void setMonstruoActual(Monstruo monstruoActual) {
        this.monstruoActual = monstruoActual;
    }

    public void añadirMonstruo(String nombre, int ataque){
        this.listaMonstruo.add(new Monstruo(nombre, ataque));
    }
    public void elegirMonstruoActual(int n){
        if(this.listaMonstruo.size()==0)throw new IllegalArgumentException("La lista no contiene monstruos");
        setMonstruoActual(this.listaMonstruo.get(n-1));
    }

    public void rendirse(){
        if(this.listaMonstruo.size()==0)throw new RuntimeException("La lista está vacía");
        for(Monstruo monstruo: this.listaMonstruo){
            monstruo.setVida(0);
        }
    }
    public String listarMonstruos(){
        StringBuilder sb = new StringBuilder();
        sb.append("-----LISTA DE MONSTRUOS----\n");
        int n=1;
        for(Monstruo monstruo: this.listaMonstruo){
            sb.append((n++)+" ");
            sb.append(monstruo.toString());
            sb.append("-------------------\n");
        }
        return sb.toString();
    }
    public boolean haPerdido(){
        for(Monstruo monstruo: listaMonstruo){
            if(monstruo.getVida()>0){
                return false;
            }
        }
        return true;
    }
    @Override
    public String toString(){
        if(this.monstruoActual==null) throw new RuntimeException("Monstruo Actual no elegido");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Jugador: %s%nMonstruo en Uso: %s%n ",this.nombre,this.monstruoActual.getNombre()));
        sb.append("-----LISTA DE MONSTRUOS----\n");
        for(Monstruo monstruo: this.listaMonstruo){
            sb.append(monstruo.toString());
            sb.append("-------------------\n");
        }
        return sb.toString();
    }
}
