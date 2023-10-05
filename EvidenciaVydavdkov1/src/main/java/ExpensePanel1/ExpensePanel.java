package ExpensePanel1;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpensePanel extends JPanel {

    private JTextField nameField;
    private JTextField priceField;
    private JComboBox<String> categoryComboBox;
    private JDateChooser dateChooser;
    private DefaultTableModel tableModel;
    private JTable expenseTable;

    public ExpensePanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        nameField = new JTextField(20);
        priceField = new JTextField(10);
        categoryComboBox = new JComboBox<>(new String[]{"Potraviny", "Domácnosť", "Doprava", "Zábava", "Ostatné"});
        dateChooser = new JDateChooser(new Date());

        inputPanel.add(new JLabel("Názov výdavku:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Cena:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Kategória:"));
        inputPanel.add(categoryComboBox);
        inputPanel.add(new JLabel("Dátum:"));
        inputPanel.add(dateChooser);

        tableModel = new DefaultTableModel();
        expenseTable = new JTable(tableModel);
        tableModel.addColumn("Názov výdavku");
        tableModel.addColumn("Cena");
        tableModel.addColumn("Kategória");
        tableModel.addColumn("Dátum");

        JScrollPane scrollPane = new JScrollPane(expenseTable);
        expenseTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = expenseTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);

        scrollPane.setBorder(BorderFactory.createTitledBorder("Evidencia výdavkov"));

        JButton addButton = new JButton("Pridať výdavok");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String price = priceField.getText();
                String category = (String) categoryComboBox.getSelectedItem();
                Date date = dateChooser.getDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                String formattedDate = dateFormat.format(date);

                tableModel.addRow(new Object[]{name, price, category, formattedDate});
                nameField.setText("");
                priceField.setText("");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
