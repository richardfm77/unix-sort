package mx.unam.ciencias.edd.proyecto1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import mx.unam.ciencias.edd.Lista;

/**
 * Proyecto 2: Ordenador lexicográfico.
 */
public class Proyecto1 {

    // Mensajes de errores.
    static final String ERROR_BANDERA_O = 
                "El nombre del archivo de salida debe ir depues de la bandera -o.";
    static final String ERROR_ESCRITURA_ARCHIVO = 
                "Error al ecribir en el archivo de salida.";
    static final String ERROR_LECTURA = 
                "Error al leer.";

    // Variable para saber si la bandera -r ha sido activada.
    static boolean reversa = false;
    // Variable para saber si la bandera -o ha sido activada.
    static boolean salidaArchivo = false;
    // Nombre del archivo de salida si se activo la bandera -o
    static String nombreArchivoSalida;
    // Nombres de lo archivos para leer.
    static Lista<String> archivos = new Lista<>();
    // Objeto que lee y escribe.
    static LecturaYEscrituraDeStrings l = new LecturaYEscrituraDeStrings();

    /* Hace lectura de lo archivos por lienea de comandos */
    private static void lecturaDeArchivos() {
        for(String archivo : archivos){
            try {
                FileInputStream fileIn = new FileInputStream(archivo);
                InputStreamReader isIn = new InputStreamReader(fileIn);
                BufferedReader in = new BufferedReader(isIn);
                l.lectura(in);
                in.close();
            } catch (IOException ioe) {
                error(ERROR_LECTURA);
            }
        }
    }

    /* Escribe en un archivo las líneas. */
    private static void escritura(String lineas) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nombreArchivoSalida);
            OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
            BufferedWriter out = new BufferedWriter(osOut);
            out.write(lineas);
            out.close();
        } catch (IOException ioe) {
            error(ERROR_ESCRITURA_ARCHIVO);
        }
    }

    //  Hace la lectura estadar, y muestra su repectiva salida.
    private static void lecturaEstandar() {
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            l.lectura(br);
            br.close();
            salida();
        } catch (IOException io) {
            error(ERROR_LECTURA);
        }
    }

    private static void salida() {
        String lineas = reversa ? l.escrituraStringReversa() : l.escrituraString();
        if (salidaArchivo) {
            escritura(lineas);
        } else {
            System.out.print(lineas);
        }
    }

    // Valida las banderas que le pasen al programa.
    private static void validaArgumentos(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-r"))
                    reversa = true;
                if (args[i].equals("-o")) {
                    salidaArchivo = true;
                    nombreArchivoSalida = args[i + 1];
                    if(nombreArchivoSalida.equals("-r"))
                        error(ERROR_BANDERA_O);
                }
                if(!args[i].equals("-r") &&
                   !args[i].equals("-o") &&
                   !args[i].equals(nombreArchivoSalida))
                    archivos.agrega(args[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            error(ERROR_BANDERA_O);
        }
    }

    private static void error(String mensaje){
        System.out.println(mensaje);
        System.exit(1);
    }

    public static void main(String[] args) {
        int longitudArgs = args.length;
        validaArgumentos(args);
        // Entrada estandar.
        if (longitudArgs == 0
                || (longitudArgs == 3 && salidaArchivo && reversa)
                || (longitudArgs == 2 && salidaArchivo)
                || (longitudArgs == 1 && reversa)) {
            lecturaEstandar();
            return;
        }
        // Lectura por liena de comandos.
        lecturaDeArchivos();
        salida();
    }
}
