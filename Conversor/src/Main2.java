import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Main2 {

    private JFrame frame;
    private JTextField realField;
    private JLabel resultLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main2 app = new Main2();
            app.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Conversor de moeda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel realLabel = new JLabel("Quantidade em REAL:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(realLabel, constraints);

        realField = new JTextField(10);
        constraints.gridx = 1;
        panel.add(realField, constraints);

        JButton convertButton = new JButton("Converter");
        constraints.gridx = 2;
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
        panel.add(convertButton, constraints);

        resultLabel = new JLabel();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        panel.add(resultLabel, constraints);

        frame.setSize(500, 200);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    private void convertCurrency() {
        try {
            double realAmount = Double.parseDouble(realField.getText());
            double exchangeRate = 5.25; // Example exchange rate (1 Real = 0.19 Dollar)
            double dollarAmount = realAmount / exchangeRate;

            DecimalFormat df = new DecimalFormat("#.##");
            resultLabel.setText("Quantidade em DOLAR: $" + df.format(dollarAmount));
        } catch (NumberFormatException e) {
            resultLabel.setText("Valor invalido, por favor insira um valor valido.");
        }
    }
}
