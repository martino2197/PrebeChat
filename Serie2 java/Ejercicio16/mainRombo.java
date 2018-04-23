import java.util.Scanner;


public class mainRombo {

    public static void main(String[] args) {
        
    	boolean go=true;
        Scanner sc=new Scanner(System.in);
        while(go){
        	try{
	        	System.out.println("---Rombomania---");
	        	System.out.println("¿Quieres dibujar un gran rombo?\n1)SI\n2)NO");
	        	System.out.print("Opcion: ");
	        	int op=Integer.parseInt(sc.nextLine());
	        	if(op==1){
	        		Rombo rombo = new Rombo();
        			rombo.dibujaRombo();
	        	}
	        	else if (op==2) {
	        		System.out.println("\n****Entonces para que me ejecutas? adios\n");
	        		go=false;
	        	}
        	}catch(NumberFormatException nfe){
        		System.out.println("Las opciones son el 1 y el 2, no lo que pusiste");
        	}
        }
        
    }
    
}
