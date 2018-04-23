//Prebecario#06
import java.util.Scanner;
import java.util.InputMismatchException;
public class mainExcepcionRaices {
    public static void main(String[] args) {
        double A,B,C;
        ComplexException iiee = new ComplexException();
        boolean valida=true;

        while(valida){

            try{

                System.out.println("...............................................................");
                System.out.println("-----CALCULADORA DE RAÍCES DE POLINOMIOS DE SEGUNDO GRADO------");    
                System.out.println("....................................................................");
                System.out.println("Polinomio de la forma ax²+bx²+c=0, los coeficientes son 'a', 'b', 'c'.");
                System.out.println(".................................................................");
                System.out.printf("\n¿Quieres calcular algunas raíces y alocarnos?\n1)YES\n2)NEL\n\n--->");
                    Scanner sc = new Scanner(System.in);
                    if(sc.nextInt()==1){

                        try{
                            System.out.println("-->Ingresa dichos coeficientes<--");
                            System.out.print("-->Coeficiente a: ");
                                String dato = "";
                                dato=sc.nextLine();
                                dato=sc.nextLine();
                                A=Double.parseDouble(dato);        

                            System.out.print("-->Coeficiente b: ");
                                dato = sc.nextLine();
                                B = Double.parseDouble(dato);        
            
                            System.out.print("-->Coeficiente c: ");
                                dato = sc.nextLine();
                                C = Double.parseDouble(dato);
                            polinomio p = new polinomio(A,B,C);        
                            System.out.printf("\n\n---POLINOMIO---\n\t %.2fx² + %.2fx + %.2f = 0 ",A,B,C);
                            try{
                                p.calRaiz();
                                
                            }catch(ComplexException ce) {
                                System.out.println(iiee.getMessage());
                            }

                            }catch(NumberFormatException nfe){
                                System.out.printf("\n\n***ERRROR: Ingresa una opción válida\n*\n*\n*\n");
                            }

                           

                    }else{
                        System.out.println("Ok. BAI.");
                        valida=false;
                    }
                
            }catch(InputMismatchException ime) {
                System.out.println("Ingrese un numero válido");
            }
        }

      
    }
}
