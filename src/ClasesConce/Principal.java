package ClasesConce;


import java.util.Scanner;
import java.util.regex.*;
import javafx.stage.Stage;

//@author JosePS
public class Principal {

    //Declaramos os atributos da clase principal.
    
    private Scanner lec = new Scanner(System.in);
    private Concesionario conce = new Concesionario();

    /**
     * Metodo no que se executa o menu e as opcions.
     */
    void run() {

        boolean estado;
        String mat;
        int km;
        char op;
        String datos = "";
        do {
            Menu me = new Menu("Benvido a coches null!!!", new String[]{"1.Novo Vehiculo", "2.Listar Vehiculos", "3.Buscar Vehiculo", "4.Modificar kms Vehiculo", "5.Eliminar vehiculo", "6.Sair"}, "123456", Menu.Direccion.VERTICAL);
            op = me.getOpcion();
            switch (op) {
                case '1':
                    novoVehiculo();
                    break;
                case '2':
                    conce.listarVehiculos();
                    break;
                case '3':
                    System.out.println("Introduce unha matricula: ");
                    datos = conce.buscaVehiculo(lec.nextLine());
                    if (datos == null) {
                        System.out.println("Non existe un vehiculo con esa matricula");
                    } else {
                        System.out.println(datos);
                    }
                    break;
                case '4':
                    do {
                        System.out.println("Introduce a matricula e os Km: ");
                        System.out.println("Matricula: ");
                        mat = lec.nextLine();
                        System.out.println("Kilometros: ");
                        km = Integer.parseInt(lec.nextLine());
                        estado = conce.actualizaKms(mat, km);
                        if (estado == false) {
                            System.out.println("Non hai vehiculo con esa matricula.");
                        }
                    } while (!estado);
                    break;
                case '5':

                        System.out.println("Introduce a matricula do vehiculo a eliminar: ");
                        System.out.println(conce.eliminaVehiculo(lec.nextLine()));   
                    break;
                case '6':
                    break;
            }
        } while (op != '6');
    }

    /**
     * Con este metodo pedimos os datos por teclado e introducimos o vehiculo no
     * concesionario.
     */
    public void novoVehiculo() {
        String marca;
        String matricula = " ";
        int kilometros = 0;
        String fechaMatricula;
        String descripcion;
        int precio = 0;
        String nombrePropietario;
        String dniPropietario;
        int ver;
        boolean sigue = false;
        String[] val;
        System.out.println("Introduce a marca: ");
        marca = lec.nextLine();
        do {
            System.out.println("Introduce a matricula: ");
            matricula = lec.nextLine();
            if (!matricula.matches("([0-9]{4})([A-Za-z]{3})")) {
                System.out.println("Debes respetar o formato de matricula.");}
        } while (!matricula.matches("([0-9]{4})([A-Za-z]{3})"));
        do {
            try {
                System.out.println("Introduce os Kilometros: ");
                kilometros = Integer.parseInt(lec.nextLine());
                sigue = true;
            } catch (NumberFormatException n) {
                sigue = false;
                System.out.println("Introduce un valor positivo.");
            }
            if (kilometros < 0) System.out.println("Introduce un valor positivo.");
        } while (!sigue || kilometros < 0);
        do {
            System.out.println("Introduce a data de matriculacion en formato DD/MM/YYYY: ");
            fechaMatricula = lec.nextLine();
        } while (!fechaMatricula.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"));
        System.out.println("Introduce unha descripcion: ");
        descripcion = lec.nextLine();
        do {
            try {
                System.out.println("Introduce o prezo: ");
                precio = Integer.parseInt(lec.nextLine());
                sigue = true;
            } catch (NumberFormatException n) {
                sigue = false;
                System.out.println("Introduce un valor positivo.");;
            }
             if (precio < 0) System.out.println("Introduce un valor positivo.");
        } while (!sigue || precio < 0);
        do {
            System.out.println("Introduce o nome do propietario: ");
            nombrePropietario = lec.nextLine();
            val = nombrePropietario.split(" ");
            if (val.length != 3) {
                System.out.println("O nome non e correcto.");
            }
        } while ((val.length != 3) || (nombrePropietario.length()>40));
        do {
            System.out.println("Introduce o DNI do propietario: ");
            dniPropietario = lec.nextLine();
        } while (!dniPropietario.matches("[XYxy]?[0-9]{1,9}[A-Za-z]"));
        ver = conce.insertarVehiculo(marca, matricula, kilometros, fechaMatricula, descripcion, precio, nombrePropietario, dniPropietario);
        if (ver == 0) {
            System.out.println("Operacion realizada con exito.");
        } else if (ver == -1) {
            System.out.println("O concesionario esta cheo.");
        } else if (ver == -2) {
            System.out.println("Este vehiculo xa esta rexistrado");
        }

    }

//    public static void main(String[] args) {
//        Principal app = new Principal();
//        app.run();
//    }

}
