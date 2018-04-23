/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import java.util.Set;

public class Persona {
    String nombre,tel,pet;
    Mascota m;
    Persona(String nombre,String tel,String pet){
        this.nombre = nombre;
        this.tel = tel;    
        this.m = new Mascota();
        m.setNombre(pet);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getNombre() {
        return nombre;
    }

    public String getTel() {
        return tel;
    }

    public String getM() {
        pet=m.getNombre();
        return pet;
    }


} 

