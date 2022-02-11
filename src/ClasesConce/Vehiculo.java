package ClasesConce;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;

//@author JosePS
public class Vehiculo {

    /**
     * Declaramos as variables da clase vehiculo.
     * marca e fechamatricula as declaro finais porque non van cambiar o longo da vida do vehiculo, as demais poderian cambiar.
     */

    private final String marca;
    private String matricula;
    private int kilometros;
    private final String fechaMatricula;
    private String descripcion;
    private int precio;
    private String nombrePropietario;
    private String dniPropietario;

    /**
     * Creamos o constructor da clase con todos os atributos.
     * @param marca
     * @param matricula
     * @param kilometros
     * @param fechaMatricula
     * @param descripcion
     * @param precio
     * @param nombrePropietario
     * @param dniPropietario 
     */

    public Vehiculo(String marca, String matricula, int kilometros, String fechaMatricula, String descripcion, int precio, String nombrePropietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.fechaMatricula = fechaMatricula;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }


    /**
     * Creamos os metodos get-set pra ver ou modificar atributos da clase.
     * O unico setter que nos fai falta e o setKilometros, xa que e o unico atributo que imos modificar.
     * @return 
     */
    
    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    
    /**
     * Recibe a data de matriculacion do vehiculo e a compara coa actual.
     * @param data
     * @return Devolve a antiguedade do vehiculo en anos.
     */
    
    protected static int get_Anios(String data) {
        int anos = 0;
        try {
            LocalDate a = LocalDate.parse(data);
            LocalDate b = LocalDate.now();
            anos = b.getYear() - a.getYear();
        } catch (DateTimeParseException d) {
        }
        return anos;
    }

    /**
     * Metodo toString para a clase Vehiculo.
     * @return Devolve un String cos datos do vehiculo.
     */
    
    @Override
    public String toString() {
        return "Vehiculo: " + marca + " con matricula: " + matricula + " con precio: " + precio + " y numero de Km: " + kilometros + " descripcion: " + descripcion;
    }

}
