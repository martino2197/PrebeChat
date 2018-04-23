/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Agenda{
    public static void main(String[] args) {
        String namePersona,nMascota,tel;
        int opcion=0;
        ArrayList<Persona> directorio = new ArrayList<Persona>(); 
        boolean continuar=true;
        Scanner lectura = new Scanner(System.in);
        
        while(continuar){
        System.out.println("  <<<MENÚ>>>");
            System.out.println(" 1)ADD Persona");
            System.out.println(" 2)FIND Persona");
            System.out.println(" 3)DELETE Persona");
            System.out.println(" 4)SALIR");
            System.out.print("Opcion: ");
        try{
     
         opcion=lectura.nextInt();
         lectura.nextLine();
        
        switch(opcion){
            case 1:
                  
                System.out.println("Nombre de la persona");
                System.out.print("-->");
                namePersona=lectura.nextLine();
                
                System.out.println("Numero de tel");
                System.out.print("-->");
                tel=lectura.nextLine();
                System.out.println("Nombre de su mascota");
                System.out.print("-->");
                nMascota=lectura.nextLine();
                Persona p = new Persona(namePersona,tel,nMascota);
                directorio.add(p);
            break;
            case 2:
                System.out.println("Ingrese el nombre de la persona que desea buscar");
                System.out.print("-->");
                namePersona=lectura.nextLine();
                    for (int  i = 0; i < directorio.size(); i++) {
                        if(namePersona.equals(directorio.get(i).getNombre())){
                            System.out.println("\nEncontrada");
                            System.out.println("\tNombre: "+directorio.get(i).getNombre());
                            System.out.println("\tTel: "+directorio.get(i).getTel());
                            System.out.println("\tMascota: "+directorio.get(i).getM()+"\n\n");
                        }
                       
                     }
                      break;
            case 3:
                System.out.println("Ingrese el nombre de la persona que desea borrar");
                System.out.print("-->");
                namePersona=lectura.nextLine();
                    for (int  i = 0; i < directorio.size(); i++) {
                        if(namePersona.equals(directorio.get(i).getNombre())){
                            directorio.remove(i);
                            System.out.println("BORRADA...");
                        }
                }
                      break;
            case 4: continuar=false; break;
            default:
                System.out.println("No hay no existe");
                directorio.clear();
                      break;
        }
        }catch(Exception e){
           System.out.println("-----Errror. ----\n\n");
        }
        }
    }
        
}
    
