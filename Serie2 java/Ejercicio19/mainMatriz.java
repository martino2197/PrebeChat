
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class mainMatriz{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		boolean seguir = true;
		ArrayList <Matriz> matrices= new ArrayList <Matriz>();
		int orden;
		try{
		while(seguir)
		{
			try{
			
			System.out.println("MAKE MATRICES BY MARTÍN");
			System.out.println("---Opciones**\n");
			System.out.println("-1) Crear matriz");
			System.out.println("-2) Lista de matrices");
			System.out.println("-3) Calcular determinante ");
			System.out.println("--EXIT (otro número que no sea 1, 2, 3\n ");
			System.out.print("--Opcion: ");
			int opcion=sc.nextInt();
			System.out.println("");
			switch(opcion){

				case 1: 
					System.out.print("Orden de la matriz: ");
					int nue= sc.nextInt();
					if (nue == 0){
						System.out.println("---NO HAY MATRICES DE ORDEN CERO, NO EXISTEN");
					}else{
						int k;
						Matriz nueva= new Matriz(nue);
						nueva.llenar();
						matrices.add(nueva);
					}
					System.out.println("");
				break;

				case 2: 
					int i=1;
					for (Matriz mat : matrices){ 
						System.out.println("\nMatriz "+i);
						mat.imprimir();
						i++;
					}
				System.out.println("");
				break;

				case 3: 
					System.out.println("Elige matriz para sacar su determinante");
					for (Matriz mat : matrices){ 
						mat.imprimir();
					}
					System.out.println("");
					//imprimirMatrices(matrices);
					System.out.print("Numero de matriz: ");
					int uno = sc.nextInt();
					uno -=1;
					
					Matriz mat1 = matrices.get(uno);
					double det= mat1.getDeterminante(mat1,0);

					System.out.println("---Determinante:  "+det);
					System.out.println("");
			
				break;


				default:
					System.out.println("LÁSTIMA QUE TERMINÓ EL FESTIVAL DE HOY ");
					seguir = false;
				break;

				}
			}catch(InputMismatchException ime){
				System.out.println("\n\n--Caracter no válido. SAL DE MI PROGRAMA--\n");
				seguir=false;
			}
		}
	}catch(InputMismatchException ime){
		System.out.println("--ERROR, POR FAVOR SAL DE MI PROGRAMA");
	}
	}
}