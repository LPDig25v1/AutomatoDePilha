import java.util.LinkedList;

public class Fila<T> {
    private LinkedList<T> lista;

    public Fila() {
        lista = new LinkedList<>();
    }

    public void enfileira(T elemento) {
        lista.addLast(elemento);
    }

    public T desenfileira() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        return lista.removeFirst();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }
}

