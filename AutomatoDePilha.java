import javax.lang.model.element.VariableElement;

public class AutomatoDePilha {
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
    
    class Fila {
        No inicio;
        No fim;
    
        public Fila() {
            inicio = null;
            fim = null;
        }
    
        public void enqueue(String elemento) {
            No novoNo = new No(elemento);
            if (inicio == null) {
                inicio = fim = novoNo;
            } else {
                fim.proximo = novoNo;
                novoNo.anterior = fim;
                fim = novoNo;
            }
        }
    
        public String dequeue() {
            if (inicio == null) {
                throw new IllegalStateException("A fila está vazia.");
            }
            String elementoRemovido = inicio.elemento;
            inicio = inicio.proximo;
            if (inicio != null) {
                inicio.anterior = null;
            } else {
                fim = null;
            }
            return elementoRemovido;
        }
    
        public boolean isEmpty() {
            return inicio == null;
        }

        public String peek() {
            if (inicio == null) {
                throw new IllegalStateException("A fila está vazia.");
            }
            return inicio.elemento;
        }
    }

    public class Pilha {
        No topo;
    
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
    
        public String peek() {
            if (topo == null) {
                throw new IllegalStateException("A pilha está vazia.");
            }
            return topo.elemento;
        }
    }

    public class ControleFinitoDeEstados {
        Pilha pilha;
        Fila fila;
    
        public ControleFinitoDeEstados() {
            pilha = new Pilha();
            fila = new Fila();
        }
    
        public void processarEvento(String q0, String q1) {
            // Use pilha.push(), pilha.pop(), fila.enqueue(), fila.dequeue() conforme necessário
            if ("a".equals(q0)) {
                pilha.push("a");
            }
            else if ("b".equals(q0)) {
                pilha.push("b");
            }
            else if ("c".equals(q0)) {
                pilha.pop();
                pilha.push("l");
                if ("a".equals(q1)) {
                    pilha.pop();
                }
                else if ("b".equals(q1)) {
                    pilha.pop();
                }
            }
        }
    
        public boolean pilhaVazia() {
            return pilha.isEmpty();
        }
    
        public boolean filaVazia() {
            return fila.isEmpty();
        }
    }
    
    public static void main(String[] args) {
        ControleFinitoDeEstados automato = new ControleFinitoDeEstados();
    
        // Exemplo de uso:
        automato.fila.enqueue("Evento1");
        automato.fila.enqueue("Evento2");
        automato.pilha.push("Elemento1");
        automato.pilha.push("Elemento2");
    
        // Processamento do autômato
        while (!automato.filaVazia()) {
            String evento = automato.fila.dequeue();
            automato.processarEvento(evento, evento);
        }
    }
}