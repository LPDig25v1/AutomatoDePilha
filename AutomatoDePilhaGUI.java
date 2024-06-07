import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomatoDePilhaGUI {
    private JFrame frame;
    private JTextArea outputTextArea;
    private AutomatoDePilha.ControleFinitoDeEstados controle;

    public AutomatoDePilhaGUI() {
        frame = new JFrame("Automato de Pilha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);

        JButton processButton = new JButton("Processar Evento");
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q0 = "a"; // Exemplo: substitua pelos valores desejados
                String q1 = "b"; // Exemplo: substitua pelos valores desejados

                controle.processarEvento(q0, q1);
                boolean pilhaVazia = controle.pilhaVazia();
                outputTextArea.append("Resultado (Pilha vazia): " + pilhaVazia + "\n");
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(outputTextArea, BorderLayout.CENTER);
        frame.add(processButton, BorderLayout.SOUTH);

        // Inicialize o controle de estados
        controle = new AutomatoDePilha().new ControleFinitoDeEstados();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutomatoDePilhaGUI();
            }
        });
    }
}