import java.util.Scanner;

public class Ejercicio17{

     public static void main(String[] args) {
            boolean jugar=true;
            int ndiscos=0;
            try{
                while(jugar){
                    System.out.println("Bienvenido al juego de las torres de hanoi");
                    System.out.println("....");
                    System.out.println("-¿Jugar?");
                    System.out.println("1) Juego");
                    System.out.println("2) No");
                    System.out.print("Opcion: ");
                    Scanner sc=new Scanner(System.in);
                    int opcion=sc.nextInt();
                    if(opcion==1){
                        System.out.print("Numero de discos: ");
                        ndiscos=sc.nextInt();
                        //int nDisks = ndiscos;
                        System.out.println("..................");
                        System.out.println("..................");
                        System.out.println("Solucion mas veloz:");
        
                        Torres(ndiscos, 'A', 'B', 'C');
                    }else if (opcion==2) {
                        System.out.println("...");
                        System.out.println("Hasta luego, gracias por no jugar");
                        jugar=false;
                    }else{
                        System.out.println("...");
                        System.out.println("Opcion no valida");
                        System.out.println("...");
                        System.out.println("");
                    }

                }
            }catch(Exception e){
                System.out.println("...");
                System.out.println("Lo siento, adios");
            }
            
    }
 
    public static void Torres(int topN, char from,char inter, char to) {
         //separador
        if (topN == 1){
            System.out.println("");
            System.out.println(" Mover Disco 1 desde " + from + " hacia " + to);
        }else {
            Torres(topN - 1, from, to, inter);
            System.out.println(" Mover Disco " + topN + " desde " + from + " hacia " + to);
            // llamada recursiva
            Torres(topN - 1, inter, from, to);
        }
    }
}
