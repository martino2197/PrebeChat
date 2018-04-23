import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class Matriz{

	Scanner sc = new Scanner(System.in);
	double matriz [][];
	int orden;

	Matriz(int orden){
		this.orden= orden;
		this.matriz = new double[orden][orden];
	}

	Matriz(int filas, int k){ //determinante
			this.orden=filas; 				
			this.matriz = new double[filas][k];
	} 

	public void setElemento(int a, int b, double x){
		this.matriz[a][b] = x;
	}

	public double getElemento(int a, int b){
		return matriz[a][b];
	}

	public int getOrden(){
		return this.orden;
	}

	public double[] getFila(int m){
		return this.matriz[m];
	}

	public void llenar(){
		double k =0;
		System.out.println("Lleando de matriz");
		for (int i=0; i< this.getOrden(); i++){
						for(int j= 0; j<this.getOrden(); j++){
							System.out.print("Elemento ["+(i+1)+"]["+(j+1)+"]: ");
							k = sc.nextInt();
							this.setElemento(i,j, k);
						}
					}
	}

	public void imprimir(){
		System.out.println("");
		for (int i=0; i< this.getOrden(); i++){
						for(int j= 0; j<this.getOrden(); j++){
							System.out.print(this.matriz[i][j]+" ");
						}
						System.out.println("");
					}
	}

	public Matriz obtenermenores(int i, int j){
		int ordenmenor= (this.getOrden()-1); 
		Matriz submatriz = new	Matriz(ordenmenor);
		
		int r=0, s = 0;

		for (int k=0; k<this.getOrden(); k++){
			double[] fila = this.getFila(k);

			if(k != i){
				for(int l=0; l<fila.length; l++){
					if (l != j){
						submatriz.setElemento(r,s++, fila[l]);
					}
				}
				r++;
				s=0;
			}
		}
		return submatriz;
	}

	

	public double getDeterminante(Matriz mat, double determinante){
		
		if(mat.getOrden()==1){
			return mat.getElemento(0,0);
		}else{
			determinante=0;
			for(int j = 0; j<mat.getOrden();j++){
				Matriz submatriz = mat.obtenermenores(0,j);
				determinante += (Math.pow(-1,j))*mat.getElemento(0,j)*(getDeterminante(submatriz, determinante));
	
			}
		}
		return determinante;
	}

		
	
}

