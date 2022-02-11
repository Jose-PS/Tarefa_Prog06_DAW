package ClasesConce;


import java.util.Scanner;



//@author JosePS
public class Menu {

    /**
     * Definimos os atributos da clase.
     */
    
    enum Direccion {
        HORIZONTAL, VERTICAL
    }
    private String titulo;
    private String[] opcions;
    private String validas;
    private Direccion direccion;

    /**
     * Constructor do menu.
     * @param titulo
     * @param opcions
     * @param validas
     * @param direccion 
     */
    
    public Menu(String titulo, String[] opcions, String validas, Direccion direccion) {
        this.titulo = titulo;
        this.opcions = opcions;
        this.validas = validas;
        this.direccion = direccion;
    }

    /**
     * Con este metodo obtemos a opcion seleccionada.
     * @return Devolve un char co valor elexido.
     */
    
    public char getOpcion() {
        String op;
        Scanner lec = new Scanner(System.in);
        do {
            System.out.print(titulo);
            setDir();
            for (int i = 0; i < opcions.length; i++) {
                System.out.print(opcions[i]);
                setDir();
            }
            op = lec.nextLine();
        } while (validas.indexOf(op) < 0);
        return op.charAt(0);
    }

    /**
     * Define a orientacion do menu, vertical ou horizontal.
     */
    
    public void setDir() {
        if (direccion == Direccion.HORIZONTAL) {
            System.out.print(" ");
        } else {
            System.out.println();
        }
    }
}
