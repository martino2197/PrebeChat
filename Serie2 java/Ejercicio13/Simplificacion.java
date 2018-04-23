//Prebecario#06

import java.util.Scanner;
import java.util.InputMismatchException;

public class Simplificacion
{
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);
        int nume,denomi;
        boolean go=true;

        System.out.println("--BIENVENIDO AL SIMPLIFICADOR DE MARTÍN--");
        while(go){
            try{
                System.out.print("\n\nSimplificar fracciones\n\t1) Sí\t2)No\n--->R: ");
                int op=Integer.parseInt(sc.nextLine());
                if(op==1){

                    try{
                        System.out.print("\n Ingresa el numerador: ");
                        nume = sc.nextInt();
                    }catch (InputMismatchException ime) {
                        System.out.println("\n\tValor invalido"); 
                        nume=0;
                    }
                    try
                    {
                        sc.nextLine();
                        System.out.print("\n Ingresa el denominador: ");
                        denomi = sc.nextInt();
                        sc.nextLine();
                        int r=nume/denomi;
                        int aux = Math.max(nume, denomi);
                        while(aux!=0)
                        {
                            if(aux==1 && ((nume*nume)==denomi))
                            {
                                denomi=denomi/nume;
                                nume=nume/nume;
                                System.out.println("\nNúmero simplificado \n\t "+nume+"\n\t-----\n\t  "+denomi);
                                aux=0;
                            }
                            else if(((nume%aux)==0) && ((denomi%aux)==0))
                            {
                                //System.out.println("\n if 2\n aux:"+aux);
                                nume=nume/aux; denomi=denomi/aux;
                                System.out.println("\nNúmero simplificado \n\t "+nume+"\n\t-----\n\t  "+denomi);
                                aux=0;
                            }
                            else aux--;
                        }
                    }
                    catch (ArithmeticException ae) {System.out.println("\n\tValor NO valido"); sc.nextLine(); denomi=0;nume=0;}
                    catch (InputMismatchException ime) {System.out.println("\n\tValor NO valido"); sc.nextLine(); nume=0;denomi=0;}

                }else if (op==2) {
                    System.out.printf("\n\n--------Hasta pronto-------\n\n\n");
                    go=false;
                }
            }catch(InputMismatchException ime){
                System.out.printf("\n\n*****La riegas. Esa no es una opción*****");
            }
            catch(NumberFormatException nfe){
                System.out.printf("\n\n*****La riegas. Esa no es una opción******");
            }
        }
    }

}

