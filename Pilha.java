class No<T> {
    T elemento;
    No<T> proximo;
    No<T> anterior;

    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }
}

public class Pilha<T> {
    private No<T> topo;

    public Pilha() {
        topo = null;
    }

    public void push(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (isEmpty()) {
            topo = novoNo;
        } else {
            novoNo.proximo = topo;
            topo.anterior = novoNo;
            topo = novoNo;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        T elementoDesempilhado = topo.elemento;
        topo = topo.proximo;
        if (topo != null) {
            topo.anterior = null;
        }
        return elementoDesempilhado;
    }

    public boolean isEmpty() {
        return topo == null;
    }
}