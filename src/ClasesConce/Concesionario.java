package ClasesConce;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@author JosePS
public class Concesionario {

    //Declaramos atributos da clase concesionario, un array de vehiculos e un contador.
    private final Vehiculo[] coches = new Vehiculo[50];
    private int numVehiculos;

    //Como sempre vai ter a mesma capacidade, non creo constructor, sirve o constructor por defecto.
    /**
     * Recibe unha matricula e localiza o vehiculo no array.
     *
     * @param mat
     * @return Devolve a posicion de ese vehiculo no array ou -1 se non existe.
     */
    public int localizaVehiculo(String mat) {
        for (int i = 0; i < numVehiculos; i++) {
            if (coches[i].getMatricula().equals(mat)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Recibe unha matricula e devolve os datos de marca, prezo e matricula do
     * vehiculo
     *
     * @param mat
     * @return Devolve un String cos datos ou null se non existe ese vehiculo.
     */
    public String buscaVehiculo(String mat) {
        Vehiculo v = null;
        int pos = 0;
        if (numVehiculos == 0) {
            return "O concesionario esta vacio.";
        }
        pos = localizaVehiculo(mat);
        v = coches[pos];
        if (v == null) {
            return null;
        }
        return "Vehiculo: " + v.getMarca() + " con matricula: " + v.getMatricula() + " ten un prezo de " + v.getPrecio() + " Euros";
    }

    /**
     * Recibe os datos de un vehiculo e o mete na primeira posicion libre do
     * concesionario.
     *
     * @param marca
     * @param matricula
     * @param kilometros
     * @param fechaMatricula
     * @param descripcion
     * @param precio
     * @param nombrePropietario
     * @param dniPropietario
     * @return Devolve -1 se non hai sitio, -2 se xa existe o vehiculo e 0 se o
     * insertou con exito.
     */
    public int insertarVehiculo(String marca, String matricula, int kilometros, String fechaMatricula, String descripcion, int precio, String nombrePropietario, String dniPropietario) {
        Vehiculo v = new Vehiculo(marca, matricula, kilometros, fechaMatricula, descripcion, precio, nombrePropietario, dniPropietario);
        if (numVehiculos >= coches.length) {
            return -1;
        }
        if (localizaVehiculo(matricula) >= 0) {
            return -2;
        }
        coches[numVehiculos] = v;
        numVehiculos++;
        return 0;
    }

    /**
     * Actualiza os km do vehiculo introducindo a matricula.
     *
     * @param mat
     * @param km
     * @return true si a operacion se realizou con exito, false se non se pudo
     * realizar.
     */
    public boolean actualizaKms(String mat, int km) {
        int pos = localizaVehiculo(mat);
        if (pos < 0) {
            return false;
        } else {
            coches[pos].setKilometros(km);
        }
        return true;
    }

    /**
     * Fai un listado dos vehiculos que hai no concesionario.
     */
    public void listarVehiculos() {
        if (numVehiculos == 0) {
            System.out.println("O concesionario esta vacio.");
        }
        for (int i = 0; i < numVehiculos; i++) {
            System.out.println(coches[i].toString());
        }
    }

    /**
     * Recibe unha matricula e elimina o vehiculo, movendo os demais no array
     * para non deixar ocos libres.
     *
     * @param mat
     * @return Devolve -1 se non o atopou, -2 se esta vacio o array ou 0 se o
     * eliminou con exito.
     */
    public int eliminaVehiculo(String mat) {
        int pos;
        if (numVehiculos == 0) {
            return -2;
        }
        pos = localizaVehiculo(mat);
        if (pos < 0) {
            return -1;
        }
        for (int q = pos; q < numVehiculos; q++) {
            coches[q] = coches[pos + 1];
            coches[pos + 1] = null;
        }
        numVehiculos--;
        return 0;
    }

}
