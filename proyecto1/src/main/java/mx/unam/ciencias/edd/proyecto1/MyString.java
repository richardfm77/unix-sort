package mx.unam.ciencias.edd.proyecto1;

import java.text.Collator;

/**
 * Clase para tener nuestro Tipo String, tal que sea comparable.
 * Implementa la intefaz {@link Comparable}, y sobre cargamos 
 * {@link compareTo} para decirle a nuestro tipo String como ordenarse.
 */
public class MyString implements Comparable<MyString> {

    private String valor;

    public MyString(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(MyString T2) {
        String newT1 = valor;
        String newT2 = T2.valor;

        Collator collator = Collator.getInstance();
		collator.setStrength(Collator.PRIMARY);
		return collator.compare(newT1.replaceAll("\\P{L}+", ""),
		                        newT2.toString().replaceAll("\\P{L}+", ""));
    }

    @Override
    public String toString() {
        return valor;
    }
}
