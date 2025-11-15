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
        System.out.println("Ingreso de Monstruos");
        System.out.println("INGRESO DE MONSTRUOS PARA "+jugador1.getNombre());
        for (int i = 0; i < 2; i++) {
            
            System.out.printf("---Monstruo (%d)---%n",(i+1));
            jugador1.añadirMonstruo(recibirString("Ingrese el nombre del Monstruo: "), recibirInts("Ingrese el danio del monstruo: "));
            System.out.println("----------------------");
            System.out.println();
        }
       System.out.println("INGRESO DE MONSTRUOS PARA "+jugador2.getNombre());
        for (int i = 0; i < 2; i++) {
            
            System.out.printf("---Monstruo (%d)---%n",(i+1));
            jugador2.añadirMonstruo(recibirString("Ingrese el nombre del Monstruo: "), recibirInts("Ingrese el danio del monstruo: "));
            System.out.println("----------------------");
            System.out.println();
        }
         System.out.println("------------------------------------------------");
         System.out.println("-------SELECCION DE MONSTRUOS----------------");
        //Ingreso de monstruos del jugador 1
            System.out.printf("%s seleccione un monstruo de acuerdo a la lista%n",jugador1.getNombre());
            System.out.println(jugador1.listarMonstruos());
            jugador1.elegirMonstruoActual(recibirInts("Ingrese el numero del monstruo que va a escoger: "));
        //ingreso de monstruis del jugador 2
        System.out.println("------------------------------------------------");
            System.out.printf("%s seleccione un monstruo de acuerdo a la lista%n",jugador2.getNombre());
            System.out.println(jugador2.listarMonstruos());
            jugador2.elegirMonstruoActual(recibirInts("Ingrese el numero del monstruo que va a escoger"));
        System.out.println("------------------------------------------------");
        boolean continuaJuego=true;
        boolean j1=true;
        Jugador atacante;
        Jugador defensor;
        System.out.println("-----------------------------------");
            System.out.println("----------EL JUEGO INICIA----------");
        while(continuaJuego){
            
            System.out.println("Ronda: "+(ronda++));
            if(j1){
                 atacante = jugador1;
                 defensor=jugador2;
            }else{
                atacante = jugador2;
                 defensor=jugador1;
            }
            
            System.out.printf("TURNO DE  %s%n",atacante.getNombre());
            System.out.printf("Monstruo actual: %s Vida: %d%n", atacante.getMonstruoActual().getNombre(),atacante.getMonstruoActual().getVida());
            System.out.println("------LISTA DE OPCIONES--------");
            mostrarMenu();
            switch (recibirInts("Ingrese segun desee:\n-----------------------")) {
                case 1:
                    System.out.printf("%s ataca a %s%n",atacante.getMonstruoActual().getNombre(),defensor.getMonstruoActual().getNombre());
                    atacante.getMonstruoActual().realizarAtaque(defensor.getMonstruoActual());
                    System.out.printf("%s queda con %d vida%n",defensor.getMonstruoActual().getNombre(),defensor.getMonstruoActual().getVida());
                    break;
                case 2:
                System.out.println(atacante.listarMonstruos());
                    atacante.elegirMonstruoActual(recibirInts("Seleccione un monstruo de su lista: "));
                    j1=!j1;
                    break;
                case 4:
                atacante.rendirse();
                System.out.println(atacante.getNombre()+" se acaba de rendir");
                    break;
                case 3:
                System.out.println(atacante.listarMonstruos());
                j1=!j1;
                break;
                default:
                System.out.println("INGRESE UNA OPCION CORRECTA");
                break;
            }
            System.out.println("-----------------------------------------");
            if(hayGanador()){
                continuaJuego=false;
            }
            j1=!j1;
           
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
    public boolean hayGanador(){
        if(jugador1.haPerdido()){
            System.out.printf("Atencion, todos los monstruos de %s se quedaron sin vida%nEl ganador es %s",jugador1.getNombre(),jugador2.getNombre());
            return true;
        }
        if(jugador2.haPerdido()){
            System.out.printf("Atencion, todos los monstruos de %s se quedaron sin vida%nEl ganador es %s",jugador2.getNombre(),jugador1.getNombre());
            return true;
        }
        return false;
    }


    public void mostrarMenu(){
        System.out.println("Seleccion la opcion deseada\n1.Atacar\n2.Cambiar de monstruo\n3.Ver Estado del equipo\n4. Rendirse");
    }

}
