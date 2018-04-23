import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.util.InputMismatchException;

public class Cifrado{

	public static void main(String[] args) {

		boolean sigue=true;
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> caracteres = new ArrayList<Character>();
		System.out.println("CIFRADO CESAR");
		System.out.print("\n1)Cifrar\n2)Descifrar\nPara salir presiona cualquier otra cosa");
		System.out.print("\n-->");
	
		try{	
		while(sigue){
	
		int op=Integer.parseInt(sc.nextLine());
		
		if(op==1){
			System.out.print("\n Texto para cifrar: "); 
			String palabra = sc.nextLine();
			for(int i=0; i<palabra.length(); i++) caracteres.add(palabra.charAt(i));
				System.out.println("\n Analizando "+caracteres+" ...");
			for(int i=0; i<caracteres.size(); i++)
			{
				char aux = (char) ((int) caracteres.get(i)+3);
				caracteres.set(i,aux);
			}
			System.out.println("\n Palabra cifrada: "+caracteres);

		}else if (op==2) {
			
			
			System.out.print("\n Texto cifrado: "); 
			String palabra = sc.next();
			for(int i=0; i<palabra.length(); i++) caracteres.add(palabra.charAt(i));
				System.out.println("\n Analizando "+caracteres+" ...");
			for(int i=0; i<caracteres.size(); i++){
				char aux = (char) ((int) caracteres.get(i)-3);
				caracteres.set(i,aux);
			}
			System.out.println("\n Texto descifrado: "+caracteres);

				
		}
		else
			sigue=false;
	}
		}catch(InputMismatchException ie){
			System.out.println("Algo mal pasó");
		}
		catch(NumberFormatException nfe){
			System.out.println("Metiste mal el número");
		}   
	}

}
