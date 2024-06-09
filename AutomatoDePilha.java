import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class AutomatoDePilha{
    public class Pilha {
        private Stack<Character> stack;
    
        public Pilha() {
            stack = new Stack<>();
        }
    
        public void push(char symbol) {
            stack.push(symbol);
        }
    
        public char pop() {
            return stack.pop();
        }
    
        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public class Fila {
        private Queue<Character> queue;
    
        public Fila() {
            queue = new LinkedList<>();
        }
    
        public void enqueue(char symbol) {
            queue.add(symbol);
        }
    
        public char dequeue() {
            return queue.poll();
        }
    
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public class ControleFinitoDeEstados {
        private enum Estado {
            Q0, Q1
        }

        private Estado estadoAtual;
        private Pilha pilha;

        public ControleFinitoDeEstados() {
            estadoAtual = Estado.Q0;
            pilha = new Pilha();
        }

        public void processaEntrada(char inputSymbol) {
            switch (estadoAtual) {
                case Q0:
                    if (inputSymbol == 'a') {
                        pilha.push('a');
                    } else if (inputSymbol == 'b') {
                        pilha.push('b');
                    } else if (inputSymbol == 'c') {
                        estadoAtual = Estado.Q1;
                    }
                    break;
                case Q1:
                    if (inputSymbol == 'a' || inputSymbol == 'b') {
                        pilha.pop();
                    }
                    break;
                // Adicione outras transições conforme necessário
            }
        }

        public boolean isAceita() {
            return estadoAtual == Estado.Q1 && pilha.isEmpty();
        }
    }

    public class Main {
        public static void main(String[] args) {
            // Crie as instâncias das classes
            Pilha pilha = new Pilha();
            Fila fila = new Fila();
            ControleFinitoDeEstados automato = new ControleFinitoDeEstados();
    
            // Exemplo de entrada (substitua pela sua palavra)
            String entrada = "abac";
    
            // Processa cada símbolo da entrada
            for (char symbol : entrada.toCharArray()) {
                automato.processaEntrada(symbol);
            }
    
            // Verifica se a palavra é aceita
            if (automato.isAceita()) {
                System.out.println("Palavra aceita pelo autômato de pilha!");
            } else {
                System.out.println("Palavra não é aceita pelo autômato de pilha.");
            }
        }
    }    
}