import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Arvore {
    private Node raiz;
    private final Map<Character, String> morseCodeMap;

    public Arvore() {
        morseCodeMap = new HashMap<>();
        initMorseCodeMap();
    }


    private void initMorseCodeMap() {
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
    }


    private void insert(String code, char letra) {
        if (raiz == null) {
            raiz = new Node(letra);
        } else {
            insertRecursively(raiz, code, letra);
        }
    }


    private void insertRecursively(Node atual, String code, char letra) {
        for (char c : code.toCharArray()) {
            if (c == '.') {
                if (atual.getMenor() == null) {
                    atual.setMenor(new Node(' '));
                }
                atual = atual.getMenor();
            } else if (c == '-') {
                if (atual.getMaior() == null) {
                    atual.setMaior(new Node(' '));
                }
                atual = atual.getMaior();
            }
        }
        atual.setLetra(letra);
    }


    public void gerarArvorePlavra(String word) {
        boolean isFirstLetter = true;
        for (char c : word.toUpperCase().toCharArray()) {
            String morseCode = morseCodeMap.get(c);
            if (morseCode != null) {
                if (isFirstLetter) {
                    raiz = new Node(c);
                    isFirstLetter = false;
                } else {
                    insert(morseCode, c);
                }
            }
        }
    }


    public void imprimeArvore() {
        printArvore(raiz, "");
    }


    private void printArvore(Node node, String indent) {
        if (node != null) {
            printArvore(node.getMaior(), indent + "   ");
            if (node.getLetra() != ' ') {
                String morseCode = morseCodeMap.get(node.getLetra());
                System.out.println(indent + node.getLetra() + ": " + morseCode);
            }
            printArvore(node.getMenor(), indent + "   ");
        }
    }


    public void generateMorseTreeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual palavra você quer decodificar em Código Morse? ");
        String word = scanner.nextLine();

        gerarArvorePlavra(word);
        System.out.println("Árvore gerada: " + word);
        imprimeArvore();
    }
}
