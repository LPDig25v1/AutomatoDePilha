import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomatoPilhaGUI extends JFrame {
    private Pilha<Character> pilha; // Implemente a classe Pilha

    public AutomatoPilhaGUI() {
        pilha = new Pilha<>(); // Inicialize a pilha

        setTitle("Autômato de Pilha");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton pushButton = new JButton("Empilhar");
        JButton popButton = new JButton("Desempilhar");
        JLabel statusLabel = new JLabel("Pilha vazia");

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Digite o elemento a ser empilhado:");
                if (input != null && !input.isEmpty()) {
                    char elemento = input.charAt(0);
                    pilha.push(elemento);
                    statusLabel.setText("Elemento empilhado: " + elemento);
                }
            }
        });

        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    char elementoDesempilhado = pilha.pop();
                    statusLabel.setText("Elemento desempilhado: " + elementoDesempilhado);
                } catch (IllegalStateException ex) {
                    statusLabel.setText("Pilha vazia");
                }
            }
        });

        setLayout(new FlowLayout());
        add(pushButton);
        add(popButton);
        add(statusLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AutomatoPilhaGUI().setVisible(true);
        });
    }
}