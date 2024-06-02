/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

/**
 *
 * @author leoza
 */
public class MediosTransporteManager {
    private static MediosTransporteManager instance = null;
    private ArrayList<MedioDeTransporte> lista;

    private MediosTransporteManager() {
        lista = new ArrayList<>();
    }

    public static MediosTransporteManager getInstance() {
        if (instance == null) {
            instance = new MediosTransporteManager();
        }
        return instance;
    }

    public ArrayList<MedioDeTransporte> getLista() {
        return lista;
    }

    public void agregarMedioTransporte(MedioDeTransporte medioTransporte) {
        lista.add(medioTransporte);
    }
}
