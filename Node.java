public class Node {
    private char letra;
    private Node menor;
    private Node maior;

    public Node(char letra) {
        this.letra = letra;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Node getMenor() {
        return menor;
    }

    public void setMenor(Node menor) {
        this.menor = menor;
    }

    public Node getMaior() {
        return maior;
    }

    public void setMaior(Node maior) {
        this.maior = maior;
    }
}
