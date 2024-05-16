public class ControleFinitoDeEstados {
    private String estadoAtual;

    public ControleFinitoDeEstados() {
        // Defina o estado inicial aqui (por exemplo, estadoAtual = "q0")
    }

    public void transicao(char simbolo) {
        // Implemente a lógica para transição de estados com base no símbolo
        // Exemplo: if (estadoAtual.equals("q0") && simbolo == 'a') { estadoAtual = "q1"; }
    }

    public boolean verificaAceitacao() {
        // Implemente a lógica para verificar se o estado atual é um estado de aceitação
        // Exemplo: return estadoAtual.equals("q2");
        return false;
    }
}