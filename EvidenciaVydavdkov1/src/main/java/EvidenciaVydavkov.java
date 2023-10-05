import ExpensePanel1.ExpensePanel;

import javax.swing.*;
import java.awt.*;

public class EvidenciaVydavkov {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Evidencia výdavkov");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ExpensePanel expensePanel = new ExpensePanel();
            frame.add(expensePanel, BorderLayout.NORTH);

            JButton exitButton = new JButton("Ukončit");
            exitButton.addActionListener(e -> System.exit(0));

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(exitButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

