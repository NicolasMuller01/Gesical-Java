package Gesical;

import Musico.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gesical {
    public static void main(String[] args) {
        ArrayList<Musico> listaMusicos = new ArrayList<>();
        ArrayList<Disco> listaDiscos = new ArrayList<>();
        ArrayList<Cancion> listaCanciones = new ArrayList<>();
      mostrarMenuPrincipal();
      Scanner entrada = new Scanner(System.in);
      Integer opcion = entrada.nextInt();
      while (opcion != 9){
          switch (opcion) {
              case 1: listaMusicos.add(registrarSolista()); break;
              case 2: listaMusicos.add(registrarBandan()); break;
              case 3: registrarCancion(); break;
              case 4: registrarDisc(); break;
              case 5: registroMasivo(); break;
              case 6: consultas(); break;
              default: System.out.println("Valor invalido"); break;
          }
          mostrarMenuPrincipal();
          opcion = entrada.nextInt();
      }
        System.out.println("Cerrando Aplicacion");
        System.out.println("Aplicacion cerrada");
    }

    private static void consultas() {
    }

    private static void registroMasivo() {
    }

    private static void registrarDisc() {
    }

    private static void registrarCancion() {
    }

    private static Banda registrarBandan() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese genero: ");
        String genero = scanner.nextLine();

        System.out.println("ingrese año de lanzamiento: ");
        LocalDate anioLanzamiento = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());

        System.out.println("Ingrese discografia: ");
        String discografia = scanner.nextLine();

        System.out.println("Ingrese titulo (nombre de la banda): ");
        String titulo = scanner.nextLine();

        ArrayList<Solista> listaSolista = new ArrayList<Solista>();

        System.out.println("Ingrese cantidad de solistas a agregar: ");
        Integer cantidad = scanner.nextInt();
        for (int i = 0; i < cantidad;i++){
            listaSolista.add(registrarSolista());
        }
        Banda banda = new Banda(genero,anioLanzamiento, discografia,titulo,listaSolista);

        return banda;
    }


    private static Solista registrarSolista() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese genero: ");
        String genero = scanner.nextLine();

        System.out.println("ingrese año de lanzamiento: ");
        LocalDate anioLanzamiento = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());

        System.out.println("Ingrese Discografia: ");
        String discografia = scanner.nextLine();

        System.out.println("Ingrese Apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese Nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        System.out.println("El solista toca algun instrumento (true - false): ");
        Boolean tocaAlgunInstrumento = scanner.nextBoolean();

        Solista solista = new Solista(genero, anioLanzamiento,discografia,apellido,nombre,nacionalidad,tocaAlgunInstrumento);

        return solista;
    }

    public static void mostrarMenuPrincipal(){
        System.out.println("Menu Principal");
        System.out.println("================================================================");
        System.out.println("1_registrar solista");
        System.out.println("2_Registrar banda");
        System.out.println("3_Registrar Cancion");
        System.out.println("4_registrar disco");
        System.out.println("5_Registros masivos");
        System.out.println("6_Consultas");
        System.out.println(" ");
        System.out.println("9_Cerrar Aplicacion");
        System.out.println(" ");

        System.out.println("Selecciona una Opcion: ");
    }
}