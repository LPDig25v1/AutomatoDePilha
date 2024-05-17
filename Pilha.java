class No {
    String elemento;
    No proximo;
    No anterior;

    public No(String elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }
}

public class Pilha {
    private No topo;

    public Pilha() {
        topo = null;
    }

    public void push(String elemento) {
        No novoNo = new No(elemento);
        if (topo == null) {
            topo = novoNo;
        } else {
            novoNo.proximo = topo;
            topo.anterior = novoNo;
            topo = novoNo;
        }
    }

    public String pop() {
        if (topo == null) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        String elementoRemovido = topo.elemento;
        topo = topo.proximo;
        if (topo != null) {
            topo.anterior = null;
        }
        return elementoRemovido;
    }

    public boolean isEmpty() {
        return topo == null;
    }
}

class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.push("Elemento1");
        pilha.push("Elemento2");

        System.out.println("Topo da pilha: " + pilha.peek());

        while (!pilha.isEmpty()) {
            System.out.println("Removido: " + pilha.pop());
        }
    }
}