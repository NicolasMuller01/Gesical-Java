package Gesical;

import Instrumento.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Musico.*;

public class Gesical {

    public static ArrayList<Musico> listaMusicos = new ArrayList<>();
   
    private static ArrayList<Cancion> listaCanciones = new ArrayList<>();
    
    public static void main(String[] args) { 
    
    // Empieza el menu principal
    logicaMenuPrincipal();
    }

    //Opcion 5: Registor masivo
    private static void registroMasivo() {
        Scanner scanner = new Scanner(System.in);

        //coleccion de 10 SOLISTAS
        ArrayList<Solista> listaSolistaTemporales = new ArrayList<>();
        System.out.println("Ingrese 10 solistas: ");

        //bucle for que va llenando la lista de solistas
        for(int i=0; i<2;i++){
            System.out.println("Ingrese solista numero "+ (i+1) +" : ");
            listaSolistaTemporales.add(registrarSolista());
        }
        //bucle for que compara valores que ya integran la listas para que NO haya valores duplicados en el array
        for (Solista solista : listaSolistaTemporales){
            listaMusicos.add(solista);
        }
        //1 de 2 ingresos para la lista de bandas, con 2 integrantes de la lista solistas
        System.out.println("Para la banda 1 ingrese: ");
        listaMusicos.add(registroMasivoBandas(listaSolistaTemporales, 1));

        System.out.println(listaMusicos);
        
        //2 de 2 ingresos para la lista de bandas, con 3 integrantes de la lista solistas (diferentes a los del primer agregado de bandas)
        System.out.println("Para la banda 2 ingrese: ");
        listaMusicos.add(registroMasivoBandas(listaSolistaTemporales, 2));

        //bucle for que pide 10 canciones para ser ingresadas
        for (int i = 0; i <20;i++){
            System.out.println("Ingrese cancion numero "+(i+1)+": ");
            listaCanciones.add(registrarCancion());
        }
        //bucle for que pide 3 discos
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese disco numero" + (i+1) +  ": ");
            registrarDisco();
        }
    }

    //Metodo para la opcion 5 que pide y agrega las canciones para definir a quien pertenece el disco
    private static Banda registroMasivoBandas(ArrayList<Solista> listaSolistaTemporales, Integer count){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese genero: ");
        String genero = scanner.nextLine();

        System.out.println("Ingrese el año, mes y dia de la fecha de lanzamiento: ");
        LocalDate anioLanzamiento = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());

        System.out.println("Ingrese la discografia: ");
        String discografia = scanner.nextLine();

        System.out.println("Ingrese el titulo (Nombre de la banda): ");
        String titulo = scanner.nextLine();

        //Listas creada para validad la condicion de: "los solistas ingresados deben ser diferentes para cada banda."
        ArrayList<Solista> listaSolista = new ArrayList<Solista>();
        ArrayList<Solista> listaSolista2 = new ArrayList<Solista>();
        //condicionante para la banda 1 de 2
        if(count == 1) {
            Integer contador = 0;
            System.out.println("Seleccione 2 solistas de la Lista de solistas");
            for (Solista soli : listaSolistaTemporales) {
                System.out.println(soli);
            }
            do {
            System.out.println("Ingrese el nombre de algun solista de la lista: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido de algun solista de la lista: ");
            String apellido = scanner.nextLine();
                for (Solista solista : listaSolistaTemporales){
                    if(solista.getNombre().equals(nombre) && solista.getApellido().equals(apellido)){
                        listaSolista.add(solista);
                        contador++;
                    }
                }
                listaSolistaTemporales.remove(listaSolista.get(contador-1));
            }while (contador!=2);
            for (int i=0; i<8;i++){
                listaSolista.add(registrarSolista());
            }
        }
        //condicionante para la banda 2 de 2
        else if (count == 2){
            Integer contador = 0;
            System.out.println("Seleccione 3 solistas de la Lista de solistas");
            for (Solista soli : listaSolistaTemporales) {
                System.out.println(soli);
            }
            do {
                System.out.println("Ingrese el nombre de algun solista de la lista: ");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese el apellido de algun solista de la lista: ");
                String apellido = scanner.nextLine();
                for (Solista solista : listaSolistaTemporales){
                    if(solista.getNombre().equals(nombre) && solista.getApellido().equals(apellido)){
                        listaSolista2.add(solista);
                        listaSolistaTemporales.remove(solista);
                        contador++;;
                    }
                    else {
                        System.out.println("Ese Solista no existe! Intente con otro.");
                    }
                }
                listaSolistaTemporales.remove(listaSolista.get(contador-1));
            }while (contador!=3);
            for (int i=0; i<7;i++){
                listaSolista.add(registrarSolista());
            }
        }
        //Se ingresan las 2 bandas a la lista
        Banda banda = new Banda(genero,anioLanzamiento,discografia,titulo,listaSolista);
        return banda;
    }
    
    //Opcion 4: Registrar disco
    private static void registrarDisco() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("lista de musicos disponibles");
        for(Musico musico : listaMusicos){
            System.out.println(musico.getNombre());
        }
        System.out.println("Ingrese nombre de la Banda o del Solista al cual pertenece este disco");
        String nombre = scanner.nextLine();
        
        if(listaMusicos.isEmpty()){
            System.out.println("Lista vacia");
            System.out.println(" ");
            generoMusicalPlaylist();
        }
        
        //Valores necesario de la clase Disco
        System.out.println("Ingrese el año, mes y dia de la fecha de año de edicion: ");
        LocalDate anioEdicion = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        
        scanner.nextLine();
        
        System.out.println("Ingrese el titulo del disco: ");
        String titulo = scanner.nextLine();
        
        ArrayList<Cancion> ListaCanciones = new ArrayList<Cancion>();
        

        System.out.println("Ingrese la cantidad de canciones a agregar: ");
        Integer cantidad = scanner.nextInt();
        for (int i = 0; i < cantidad;i++){
            ListaCanciones.add(registrarCancion());
        }
        
        scanner.nextLine();
        
        System.out.println("El musico ingresado es una banda o un solista? (banda o solista): ");
        String tipoMusico = scanner.nextLine();
        
        Disco disco = null;
        
        for (Musico musico : listaMusicos){
           if(nombre.equals(musico.getNombre())){
               if(tipoMusico.equals("banda")){
                    disco = new Disco(titulo,anioEdicion,ListaCanciones);
                    musico.setDisco(disco);
               }
                else {
                     disco = new Disco(titulo,anioEdicion,ListaCanciones);
                     musico.setDisco(disco);
                }
            }    
        }
    }
    
    //Opcion 3: Registrar cancion
    private static Cancion registrarCancion() {
        Scanner scanner = new Scanner(System.in);
        //Valores necesario de la clase Cancion
        System.out.println("Ingrese el nombre de la cancion: ");
        String nombreCancion = scanner.nextLine();
        System.out.println("Ingrese el duracion de la cancion: ");
        Integer duracion = scanner.nextInt();
       
        while(chekearCancionesRepetidas(nombreCancion, duracion)){
            System.out.println("Esa cancion ya existe!!");
            scanner.next();
            System.out.println("Ingrese el nombre de la cancion: ");
            System.out.println(" ");
            nombreCancion = scanner.nextLine();
            System.out.println("Ingrese el duracion de la cancion: ");
            duracion = scanner.nextInt();
        }

        Cancion cancion = new Cancion(nombreCancion,duracion);

        return cancion;
    }
    
    public static Boolean chekearCancionesRepetidas(String n, Integer d){
     for(Musico musico : listaMusicos){
            for(Disco disco : musico.getDisco()){
                for (Cancion cancion : disco.getListaCanciones()){
                    if(n.equals(cancion.getNombreCancion()) && d.equals(cancion.getDuracion())){
                        return true;
                    }
                }
            }
        }
     return false;
    }
    
    //Opcion 2: Registra banda
    private static Banda registrarBandan() {
        Scanner scanner = new Scanner(System.in);
        //Valores necesario de la clase Banda
        System.out.println("Ingrese genero: ");
        String genero = scanner.nextLine();

        System.out.println("Ingrese el año, mes y dia del año de lanzamiento: ");
        LocalDate anioLanzamiento = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());

        System.out.println("Ingrese la discografia: ");
        String discografia = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese el titulo (Nombre de la banda): ");
        String titulo = scanner.nextLine();

        ArrayList<Solista> listaSolista = new ArrayList<Solista>();

        System.out.println("Ingrese la cantidad de solistas a agregar: ");
        Integer cantidad = scanner.nextInt();
        for (int i = 0; i < cantidad;i++){
            listaSolista.add(registrarSolista());
        }

        Banda banda = new Banda(genero,anioLanzamiento, discografia,titulo,listaSolista);

        return banda;
    }

    //Opcion 1: Registrar solista
    private static Solista registrarSolista() {
        Scanner scanner = new Scanner(System.in);
        //Valores necesarios para la clase Solista
        System.out.println("Ingrese genero: ");
        String genero = scanner.nextLine();

        System.out.println("Ingrese el año, mes y dia del año de lanzamiento: ");
        LocalDate anioLanzamiento = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese la discografia: ");
        String discografia = scanner.nextLine();

        System.out.println("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        System.out.println("El solista toca algun instrumento? (true o false): ");
        Boolean tocaAlgunInstrumento = scanner.nextBoolean();
        
        Solista solista = new Solista(genero,anioLanzamiento,discografia,apellido,nombre,nacionalidad,tocaAlgunInstrumento,null);
        
        if(tocaAlgunInstrumento){
             System.out.println("Que instrumento toca 1)Bajo 2)Guitarra 3)Bateria 4)Teclado (Introduzca un numero)");
             Integer instrumento = scanner.nextInt(); 
             solista.setInstrumento(crearInstrumento(instrumento));
        }
        
        return solista;
    }
    
    //Crear instrumento
    public static Instrumento crearInstrumento(Integer instrumento){
        if(instrumento.equals(1)){
            Bajo bajo = new Bajo();
            return bajo;
        }
        else if(instrumento.equals(2)){
            Guitarra guitarra = new Guitarra();
            return guitarra;
        }
        else if(instrumento.equals(3)){
            Bateria bateria = new Bateria();
            return bateria;
        }
        else if(instrumento.equals(4)){
            Teclado teclado = new Teclado();
            return teclado;
        }
        return null;
    }
    
    //Mostrar menu principal con las opciones
    public static void mostrarMenuPrincipal(){
        System.out.println("Menu Principal");
        System.out.println("================================================================");
        System.out.println("1) Registrar Solista");
        System.out.println("2) Registrar Banda");
        System.out.println("3) Registrar Cancion");
        System.out.println("4) Registrar Disco");
        System.out.println("5) Registro Masivos");
        System.out.println("6) Consultas");
        System.out.println(" ");
        System.out.println("9) Cerrar Aplicacion");
        System.out.println(" ");
        System.out.println("Selecciona una Opcion: ");
    }

    //Opcion 6: mostrar consultas
    private static void consultas() {
        mostrarConsultas();
        Scanner entrada = new Scanner(System.in);
        char opcion = entrada.next().charAt(0);
        while (opcion != 'z'){
            switch (opcion) {
                case 'a': duracionDeDiscos(); break;
                case 'b': generoMusicalPlaylist(); break;
                case 'c': borrarDiscoPorAnioEdicion(); break;
                case 'd': listarDiscoPorBanda(); break;
                case 'z': logicaMenuPrincipal(); break;
                default: System.out.println("Valor invalido"); break;
            }
            mostrarConsultas();
            opcion = entrada.next().charAt(0);
        }
        System.out.println("Cerrando Aplicacion");
        System.out.println("Aplicacion cerrada");
    }

    //Mostrar mesnu secundario/consultas con las opciones
    private static void mostrarConsultas() {
        System.out.println("Consultas");
        System.out.println("================================================================");
        System.out.println("a) Discos que duran mas de X segundos");
        System.out.println("b) Playlist por genero musical");
        System.out.println("c) Borrar discos segun año de edicion");
        System.out.println("d) Listar discos por banda");
        System.out.println(" ");
        System.out.println("z) Volver al menu anterior");
        System.out.println(" ");
        System.out.println("Selecciona una Opcion: ");
    }

    //Opcion a: disco que duran mas de X segundos
    private static void duracionDeDiscos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar la duracion en segundos que dura: ");
        Integer duracion = scanner.nextInt();
        for(Musico musico : listaMusicos){
            for(Disco disco : musico.getDisco()){
                int duracionDisco = 0;
                for(Cancion canciones : disco.getListaCanciones()){
                    duracionDisco+=canciones.getDuracion();
                }
                if(duracionDisco > duracion){
                System.out.println("Nombre del disco: " + disco.getTitulo());
                System.out.println("Musico correspondiente: "+ musico.getNombre());
                System.out.println("");
                }
            }
        }
    }

    //Opcion b: Playlist por genero musical 
    private static void generoMusicalPlaylist() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese o seleccione un genero: ");
        System.out.println("1) kpop");
        System.out.println("2) cumbia");
        System.out.println("3) rock");
        System.out.println("4) reggaeton");
        System.out.println("5) otro");
        System.out.println("6) Volver al menu principal ");
        int opcion = entrada.nextInt();
        while (opcion != 5){
            switch (opcion) {
                case 1: mostrarPlaylistPorGenero("kpop"); break;
                case 2: mostrarPlaylistPorGenero("cumbia"); break;
                case 3: mostrarPlaylistPorGenero("rock"); break;
                case 4: mostrarPlaylistPorGenero("reggaeton"); break;
                case 5: mostrarPlaylistPorGenero("otro"); break;
                case 6: consultas(); break;
                default: System.out.println("Valor invalido"); break;
            }   
            System.out.println("Ingrese o seleccione un genero: ");
            System.out.println("1) kpop");
            System.out.println("2) cumbia");
            System.out.println("3) rock");
            System.out.println("4) reggae");
            System.out.println("5) Volver al menu principal ");
            opcion = entrada.nextInt();
        }
    }
    
    private static void mostrarPlaylistPorGenero(String genero) {
        for(Musico musicos : listaMusicos){
            if(musicos.getGenero().equals(genero)){
                for(Disco disco : musicos.getDisco()){
                    System.out.println("Disco: "+disco +"\n"+ "Musico: " + musicos.getNombre());
                    for(Cancion cancion : disco.getListaCanciones()) {
                        System.out.println("Canciones: " + cancion.getNombreCancion());
                    }
                }
            }
            else{
                for(Disco disco : musicos.getDisco()){
                    System.out.println("Disco: "+disco +"\n"+ "Musico: " + musicos.getNombre());
                    for(Cancion cancion : disco.getListaCanciones()) {
                        System.out.println("Canciones: " + cancion.getNombreCancion());
                    }
                }
            }
        }
    }

    //Opcion c: Borrar disco por año de edicion 
    private static void borrarDiscoPorAnioEdicion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el año de los discos que quiere borrar (todos los discos menores a ese año seran borrados): ");
        int anio = scanner.nextInt();
        ArrayList<Disco> discosABorrar = new ArrayList<>();
        
        for(Musico musicos : listaMusicos){
           for(Disco disco : musicos.getDisco()){
              if(disco.getAnioEdicion().getYear() < anio){
                  discosABorrar.add(disco);
              }
           }  
        }
         for(Disco disco : discosABorrar){
            System.out.println("el disco " + disco.getTitulo() + " Fue eliminado");      
        }
          for(Musico musicos : listaMusicos){
            musicos.getDisco().removeAll(discosABorrar);
          } 
    }

    //Opcion d: Listar disco por banda
    private static void listarDiscoPorBanda() {
        Scanner entrada = new Scanner(System.in);
        listaMusicos.forEach((musico) -> {
            System.out.println(listaMusicos.indexOf(musico)+1 + " " + musico.getNombre());
        });
        System.out.println("Seleccione una banda de la lista (numero): ");
        Integer numero = entrada.nextInt();
        
        System.out.println("lista de discos: ");
        for(Disco disco : listaMusicos.get(numero-1).getDisco()){
            System.out.println(disco);
        }
        
    }

    private static void logicaMenuPrincipal() {
    mostrarMenuPrincipal();
    Scanner entrada = new Scanner(System.in);
    Integer opcion = entrada.nextInt();
    while (opcion != 9){
        switch (opcion) {
              case 1: listaMusicos.add(registrarSolista()); break;
              case 2: listaMusicos.add(registrarBandan()); break;
              case 3: listaCanciones.add(registrarCancion()); break;
              case 4: registrarDisco(); break;
              case 5: registroMasivo();break;
              case 6: consultas(); break;
              default: System.out.println("Valor invalido, vuelva a ingresar un valor!"); break;
            }
            mostrarMenuPrincipal();
            opcion = entrada.nextInt();
        }
      System.out.println("Cerrando Aplicacion");
      System.out.println("Aplicacion cerrada");
    }
}