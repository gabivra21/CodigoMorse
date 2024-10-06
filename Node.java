public class Node {
    private char letra;
    private Node maior;
    private Node menor;

    public Node(char letra) {
        this.letra = letra;
        this.maior = null;
        this.menor = null;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Node getMaior() {
        return maior;
    }

    public void setMaior(Node maior) {
        this.maior = maior;
    }

    public Node getMenor() {
        return menor;
    }

    public void setMenor(Node menor) {
        this.menor = menor;
    }
}
