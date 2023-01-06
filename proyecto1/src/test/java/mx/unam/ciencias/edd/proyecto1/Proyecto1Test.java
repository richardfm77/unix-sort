package mx.unam.ciencias.edd.proyecto1;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class Proyecto1Test {

    private LecturaYEscrituraDeStrings l;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testOrdenar() {
        lectura();
        assertTrue((l.escrituraString()).equals(lecturaArchivoOrdenado()));
    }

    private void lectura() {
        try {
            l = new LecturaYEscrituraDeStrings();
            FileInputStream fileIn = new FileInputStream("hombres.txt");
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
            l.lectura(in);
            in.close();
        } catch (IOException ioe) {
            assertTrue(false);
        }
    }

    private String lecturaArchivoOrdenado(){
        String linea = "";
        try {
            FileInputStream fileIn = new FileInputStream("hombresOrdenado.txt");
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
            String linea2 = "";
            while((linea2 = in.readLine()) != null)
                linea += linea2 + "\n";
            in.close();
        } catch (IOException ioe) {
            assertTrue(false);
        }
        return linea;
    }

}
