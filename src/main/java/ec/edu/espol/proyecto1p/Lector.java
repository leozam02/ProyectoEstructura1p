/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
     
     
    public static CircularDoublyLinkedList<String> filtrar(ArrayList<String> lista, String marca) {
        CircularDoublyLinkedList<String> filtrados = new CircularDoublyLinkedList<>();
        for (String t : lista) {
           String [] tokens=t.split("-");
           if(marca.equals(tokens[0]))
               filtrados.addFirst(t);
        }
        return filtrados;
        
    }
             
    public static ArrayList<MedioDeTransporte> filtrarPorMarca(List<MedioDeTransporte> lista, String marca) {
        ArrayList<MedioDeTransporte> filtrados = new ArrayList<>();
        for (MedioDeTransporte transporte : lista) {
            if (transporte.getMarca().equalsIgnoreCase(marca)) {
                filtrados.add(transporte);
            }
        }
        return filtrados;
    }
    public static void escribirEnCSV(MedioDeTransporte medio) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Datos.csv", true));
        writer.write(medio.toString());
        writer.newLine();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }
    
    public static boolean igualdad(ArrayList<MedioDeTransporte> t, MedioDeTransporte k){
        for(MedioDeTransporte m: t){
            if(m.getId().equals(k.getId()))
                return true;
            
        }
        return false;
        
        
    }
    
    //Eliminacion de linea verificando el ID
    public static void eliminarLineaPorID(String filePath, String id) {
        List<String> lineasNuevas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                if (!campos[10].equals(id)) {
                    lineasNuevas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Se escribenlas líneas nuevas en el archivo CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String nuevaLinea : lineasNuevas) {
                bw.write(nuevaLinea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

}
