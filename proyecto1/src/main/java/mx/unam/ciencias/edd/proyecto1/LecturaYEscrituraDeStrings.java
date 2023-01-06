package mx.unam.ciencias.edd.proyecto1;

public class LecturaYEscrituraDeStrings extends LecturaYEscritura<Linea, MyString> {
    @Override
    protected Linea creaTipo() {
        return new Linea();
    }
    @Override
    protected MyString actualizaTipo(Linea t) {
        return t.getValor();
    }
}
