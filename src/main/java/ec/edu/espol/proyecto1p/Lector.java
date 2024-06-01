/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author leoza
 */
public class Lector {
     public static ArrayList<MedioDeTransporte> leerArchivo(String nomfile){
        
        ArrayList<MedioDeTransporte> r;
        r = new ArrayList<>();
        try(BufferedReader bf =  new BufferedReader(new FileReader(nomfile));)
        {
            String line;
            bf.readLine();
            
            
            while((line=bf.readLine())!=null)
            {
                //Willy Wonka y los Humpa Lumpa, una aventura en la fabrica de chocolates,wonka.jpg
               String[] tokens = line.split(";");
               MedioDeTransporte m = new MedioDeTransporte(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3]),
                       Integer.parseInt(tokens[4]),tokens[5],Integer.parseInt(tokens[6]),tokens[7],tokens[8],tokens[9],tokens[10]);
               r.add(m);
            }
        }
        catch(IOException io)
        {
            System.out.println(io.getMessage());
        }
        return r;
        
    }
     
     
             public static ArrayList<String> filtrar(ArrayList<String> lista, String marca) {
        ArrayList<String> filtrados = new ArrayList<>();
        for (String t : lista) {
           String [] tokens=t.split("-");
           if(marca.equals(tokens[0]))
               filtrados.add(t);
        }
        return filtrados;
        
        
             }
}
