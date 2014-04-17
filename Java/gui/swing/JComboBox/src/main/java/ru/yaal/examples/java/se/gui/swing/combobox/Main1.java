package ru.yaal.examples.java.se.gui.swing.combobox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Добавление элементов в выпадающий список через DefaultComboBoxModel.
 */
public class Main1 {
    public static void main(String[] args) {
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setEditable(true);

        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) comboBox.getModel();

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new OkButtonActionListener(comboBoxModel));

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(300, 50);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(comboBox, BorderLayout.CENTER);
        frame.add(okButton, BorderLayout.EAST);
    }

    static class OkButtonActionListener implements ActionListener {
        private DefaultComboBoxModel<String> comboBoxModel;

        OkButtonActionListener(DefaultComboBoxModel<String> comboBoxModel) {
            this.comboBoxModel = comboBoxModel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedItem = (String) comboBoxModel.getSelectedItem();
            if (selectedItem != null && !selectedItem.trim().isEmpty()) {
                comboBoxModel.addElement(selectedItem);
            }
        }
    }
}

