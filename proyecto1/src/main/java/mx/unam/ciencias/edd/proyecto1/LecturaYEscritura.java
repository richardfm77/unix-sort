package mx.unam.ciencias.edd.proyecto1;

import java.io.BufferedReader;
import java.io.IOException;

import mx.unam.ciencias.edd.ArbolRojinegro;

/**
 * Clase abstracta para items. Provee métodos para crear un aŕbol rojinegro de items a
 * partir de la lectura de un archivo,
 * ordenar en un cierto orden los items, invertir el orden de los items,
 * convertir el valor de los items a String. Ademas
 * puede escribir los valores de los items en un archivo.
 * 
 * Las clases que extiendan a Items deben implementar el método
 * {@link #creaTipo}, que crea un item en blanco, y {@link #actualizaTipo}.
 */
public abstract class LecturaYEscritura<T extends Item<T>, R extends Comparable<R>> {

    // Estructura donde guardaresmos los items.
    private ArbolRojinegro<R> arbol;

    public LecturaYEscritura() {
        arbol = new ArbolRojinegro<>();
    }

    /* Hace la lectura de un archivo y guarda cad linea en un item y este 
    * se guarda el aŕbol rojinegro.
    */
    public void lectura(BufferedReader in) {
        String linea = "";
        try {
            while ((linea = in.readLine()) != null) {
                T t = creaTipo();
                t.deserializa(linea);
                R e = actualizaTipo(t);
                arbol.agrega(e);
            }
        } catch (IOException io) {
            return;
        }
    }

    // Convierte todas la lineas en un solo String
    public String escrituraString() {
        String linea = "";
        for (R e : arbol)
            linea += e.toString() + "\n";
        return linea;
    }

    // Convierte todas la lineas en un solo String, en orden inverso.
    public String escrituraStringReversa() {
        String linea = "";
        String [] arreglo = new String[arbol.getElementos()];
        
        int i = 0;
        for(R e : arbol){
            arreglo[i] = e.toString();
            i++;
        }    

        for(i = 0; i < arreglo.length; i++)
            linea += arreglo[arreglo.length - 1 - i] + "\n";

        return linea;
    }

    abstract protected T creaTipo();

    abstract protected R actualizaTipo(T t);

}
