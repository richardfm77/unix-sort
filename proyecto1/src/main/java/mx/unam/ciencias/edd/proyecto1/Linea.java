package mx.unam.ciencias.edd.proyecto1;

/**
 * Clase para representar Líneas de texto. Una Línea tiene
 * valor, que es el String que contiene esta misma.
 * La clase implementa {@link Item}, por lo que
 * puede serializarse en una línea de texto y deserializarse de una línea de
 * texto.
 */
public class Linea implements Item<Linea>{
    
    private MyString valor;

    public Linea(){
        valor = new MyString(null);
    }

    public MyString getValor(){
        return valor;
    }

    @Override
    public String serializa() {
        return valor.getValor();
    }

    @Override
    public void deserializa(String l) {
        valor.setValor(l);
    }

}
