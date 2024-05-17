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
        automato.processarEvento(evento);
    }
}