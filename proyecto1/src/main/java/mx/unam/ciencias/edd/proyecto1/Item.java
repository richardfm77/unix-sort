package mx.unam.ciencias.edd.proyecto1;
/**
 * Interfaz para Items. Los Items son nodos que pueden almacenar cualquier tipo
 * de objeto. Un item se puede deserializar y serializar.
 */
public interface Item<T> {
    /**
     * Regresa el valor del item serializado en una línea de texto.
     * 
     * @return la serialización del valor del item en una línea de texto.
     */
    public String serializa();

    /**
     * Deserializa una línea de texto en las propiedades de un item.
     */
    public void deserializa(String l);
}
