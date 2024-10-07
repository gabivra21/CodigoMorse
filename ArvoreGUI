import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArvoreGUI {
    private JFrame frame;
    private JTextField inputField;
    private JTextArea outputArea;
    private Arvore arvore;

    public ArvoreGUI() {
        arvore = new Arvore();
        frame = new JFrame("Árvore Binária do Código Morse");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Digite uma palavra:");
        userLabel.setBounds(10, 20, 100, 25);
        panel.add(userLabel);

        inputField = new JTextField(20);
        inputField.setBounds(120, 20, 165, 25);
        panel.add(inputField);

        JButton generateButton = new JButton("Gerar Árvore");
        generateButton.setBounds(10, 50, 150, 25);
        panel.add(generateButton);

        outputArea = new JTextArea();
        outputArea.setBounds(10, 80, 560, 380);
        outputArea.setFont(outputArea.getFont().deriveFont(16f).deriveFont(java.awt.Font.BOLD));
        panel.add(outputArea);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = inputField.getText();
                arvore.gerarArvorePlavra(word);
                outputArea.setText("Árvore gerada para: " + word + "\n");
                outputArea.append("Estrutura da Árvore:\n");
                arvore.imprimeArvoreVertical(outputArea);
            }
        });
    }


}
