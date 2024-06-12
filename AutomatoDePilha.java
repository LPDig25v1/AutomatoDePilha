import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            AutomatoDePilha automatoDePilha = new AutomatoDePilha();
            AutomatoDePilha.Pilha pilha = automatoDePilha.new Pilha();
            AutomatoDePilha.Fila fila = automatoDePilha.new Fila();
            AutomatoDePilha.ControleFinitoDeEstados automato = automatoDePilha.new ControleFinitoDeEstados();
    
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

    public class InterfaceGrafica {

        public static void main(String[] args) {
            JFrame frame = new JFrame("Autômato de Pilha");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            JPanel panel = new JPanel();

            JLabel label = new JLabel("Digite a palavra:");
            JTextField palavraField = new JTextField(20);

            JButton verificarButton = new JButton("Verificar");
            verificarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String entrada = palavraField.getText();

                    AutomatoDePilha automatoDePilha = new AutomatoDePilha();
                    AutomatoDePilha.ControleFinitoDeEstados automato = automatoDePilha.new ControleFinitoDeEstados();

                    for (char symbol : entrada.toCharArray()) {
                        automato.processaEntrada(symbol);
                    }

                    if (automato.isAceita()) {
                        JOptionPane.showMessageDialog(frame, "Palavra aceita pelo autômato de pilha!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Palavra não é aceita pelo autômato de pilha.");
                    }
                }
            });

            panel.add(label);
            panel.add(palavraField);
            panel.add(verificarButton);

            frame.add(panel);

            frame.setVisible(true);
        }
    }
}