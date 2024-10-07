import javax.swing.JTextArea;
import java.util.HashMap;
import java.util.Map;

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
        } else if (raiz != null && raiz.getLetra() != letra) {

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

    public void imprimeArvoreVertical(JTextArea textArea) {
        printArvoreVertical(raiz, 0, textArea, true);
    }

    private void printArvoreVertical(Node node, int level, JTextArea textArea, boolean isRight) {
        if (node != null) {
            printArvoreVertical(node.getMaior(), level + 1, textArea, true);
            StringBuilder indentation = new StringBuilder();
            for (int i = 0; i < level; i++) {
                indentation.append("   ");
            }
            if (node.getLetra() != ' ') {
                String arrow = (isRight ? " -> " : " <- ");
                textArea.append(indentation.toString() + node.getLetra() + " = " + morseCodeMap.get(node.getLetra()) + "\n");
            }
            printArvoreVertical(node.getMenor(), level + 1, textArea, false);
        }
    }
}
