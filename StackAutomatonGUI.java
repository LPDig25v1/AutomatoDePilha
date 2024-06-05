import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StackAutomatonGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Autômato com Pilha");

        // Área de texto para entrada do código
        TextArea codeTextArea = new TextArea();
        codeTextArea.setPromptText("Insira seu código aqui...");

        // Botão para processar o código
        Button processButton = new Button("Processar Código");
        processButton.setOnAction(e -> processCode(codeTextArea.getText()));

        // Layout
        VBox root = new VBox(10);
        root.getChildren().addAll(codeTextArea, processButton);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processCode(String code) {
        // Implemente sua lógica de processamento do código aqui
        // Por enquanto, vamos apenas imprimir o código no console
        System.out.println("Código inserido:\n" + code);
    }
}
