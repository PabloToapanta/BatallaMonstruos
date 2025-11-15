package com.pablo.batallamonstruos.logic;
import com.pablo.batallamonstruos.domain.*;
import java.util.*;
public class Batalla {
    private Jugador jugador1,jugador2;
    private Scanner sc;
    private int ronda=1;

    public Batalla(String nombre1,String nombre2){
        jugador1 = new Jugador(nombre1);
        jugador2 = new Jugador(nombre2);
        sc=new Scanner(System.in);
    }

    public void jugar(){
        System.out.println("-----------INICIO DE LA BATALLA-------");
        System.out.println("--------------------------------------");
        System.out.println("Jugador 1: "+jugador1.getNombre());
        System.out.println("Jugador 2: "+jugador2.getNombre());
        System.out.println("Ingreso de Monstruos------------");
        for (int i = 0; i < 1; i++) {
            System.out.println("INGRESO DE MONSTRUOS PARA "+jugador1.getNombre());
            System.out.printf("---Monstruo (%d)---%n",(i+1));
            jugador1.añadirMonstruo(recibirString("Ingrese el nombre del Monstruo: "), recibirInts("Ingrese el danio del monstruo: "));
        }
       
        for (int i = 0; i < 1; i++) {
            System.out.println("INGRESO DE MONSTRUOS PARA "+jugador2.getNombre());
            System.out.printf("---Monstruo (%d)---%n",(i+1));
            jugador2.añadirMonstruo(recibirString("Ingrese el nombre del Monstruo: "), recibirInts("Ingrese el danio del monstruo: "));
        }
         System.out.println("------------------------------------------------");
        //Ingreso de monstruos del jugador 1
            System.out.printf("%s seleccione un monstruo de acuerdo a la lista%n",jugador1.getNombre());
            jugador1.listarMonstruos();
            jugador1.elegirMonstruoActual(recibirInts("Ingrese el numero del monstruo que va a escoger: "));
        //ingreso de monstruis del jugador 2
        System.out.println("------------------------------------------------");
            System.out.printf("%s seleccione un monstruo de acuerdo a la lista%n",jugador2.getNombre());
            jugador2.listarMonstruos();
            jugador2.elegirMonstruoActual(recibirInts("Ingrese el numero del monstruo que va a escoger"));
        System.out.println("------------------------------------------------");
        boolean continuaJuego=true;
        while(continuaJuego){
            boolean j1=true;
            System.out.println("Ronda: "+(ronda++));
            if(j1){
                System.out.printf("Turno de %s%n",jugador1.getNombre());

                jugador1.getMonstruoActual().realizarAtaque(jugador2.getMonstruoActual());
            }else if(!j1){
                System.out.printf("Turno de %s%n",jugador2.getNombre());
                jugador2.getMonstruoActual().realizarAtaque(jugador1.getMonstruoActual());
            }
            if(hayGanador(jugador2, jugador1)){
                continuaJuego=false;
            }
            j1=!j1;
            System.out.println("-----------------------------------------");
        }

    }

    private String recibirString(String prompt){
        System.out.print(prompt);
        String st= sc.nextLine();
        if(st.isEmpty() && st.isBlank())throw new IllegalArgumentException("El string no puede estar vacio");
        return st;
    }

    private int recibirInts(String prompt){
        System.out.print(prompt);
        String st= sc.nextLine();
        int n = Integer.parseInt(st);
        return n;
        
    }
    public boolean hayGanador(Jugador jug1, Jugador jug2){
        if(jug1.getMonstruoActual().getVida()==0 || jug2.getMonstruoActual().getVida()==0){
            if(jug1.getMonstruoActual().getVida()==0){
                System.out.printf("El ganador de la batalla fue %s%n",jug1.getNombre());
            }else{
                System.out.printf("El ganador de la batalla fue %s%n",jug2.getNombre());
            }
            return true;
        }
        return false;
    }

}
