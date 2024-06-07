import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            return inicio == null ? null : inicio.elemento;
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
            return topo == null ? null : topo.elemento;
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
                if ("a".equals(q1) || "b".equals(q1)) {
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
        AutomatoDePilha automato = new AutomatoDePilha();
        AutomatoDePilha.ControleFinitoDeEstados controle = automato.new ControleFinitoDeEstados();

        controle.processarEvento("c", "b");
        controle.processarEvento("c", "a");
        controle.processarEvento("b", "a");

        boolean pilhaVazia = controle.pilhaVazia();
        boolean filaVazia = controle.filaVazia();

        System.out.println("Pilha vazia?" + pilhaVazia);
        System.out.println("Fila vazia?" + filaVazia);
    }

    class AutomatoDePilhaGUI {
        private JFrame frame;
        private JTextArea outputTextArea;
        private AutomatoDePilha.ControleFinitoDeEstados controle;
        
        public AutomatoDePilhaGUI() {
            frame = new JFrame("Automato de Pilha");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
        
            outputTextArea = new JTextArea();
            outputTextArea.setEditable(false);

            JTextField q0TextField = new JTextField();
            JTextField q1TextField = new JTextField();
        
            JButton processButton = new JButton("Processar Evento");
            processButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String q0 = q0TextField.getText(); // Exemplo: substitua pelos valores desejados
                    String q1 = q1TextField.getText(); // Exemplo: substitua pelos valores desejados
        
                    controle.processarEvento(q0, q1);
                    boolean pilhaVazia = controle.pilhaVazia();
                    outputTextArea.append("Resultado (Pilha vazia): " + pilhaVazia + "\n");
                }
            });
        
            frame.setLayout(new BorderLayout());
            frame.add(outputTextArea, BorderLayout.CENTER);
            frame.add(processButton, BorderLayout.SOUTH);
            frame.add(outputTextArea, BorderLayout.SOUTH);
        
            // Inicialize o controle de estados
            controle = new AutomatoDePilha().new ControleFinitoDeEstados();
        
            frame.setVisible(true);
        }
    }
}