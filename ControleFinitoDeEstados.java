public class ControleFinitoDeEstados {
    private Pilha pilha;
    private Fila fila;

    public ControleFinitoDeEstados() {
        pilha = new Pilha();
        fila = new Fila();
    }

    public void processarEvento(String evento) {
        // Implemente a lógica do autômato aqui
        // Use pilha.push(), pilha.pop(), fila.enqueue(), fila.dequeue() conforme necessário
    }

    public boolean pilhaVazia() {
        return pilha.isEmpty();
    }

    public boolean filaVazia() {
        return fila.isEmpty();
    }
}