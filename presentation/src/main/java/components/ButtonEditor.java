/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author ang3lfco
 */
public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel;
    private final JButton editButton;
    private final JButton deleteButton;

    public ButtonEditor(ActionListener editAction, ActionListener deleteAction) {
        panel = new JPanel(new GridBagLayout());
        editButton = new JButton(new ImageIcon(getClass().getResource("/icons/view20x.png")));
        deleteButton = new JButton(new ImageIcon(getClass().getResource("/icons/delete20x.png")));

        styleButton(editButton);
        styleButton(deleteButton);

        editButton.addActionListener(editAction);
        deleteButton.addActionListener(deleteAction);

        JPanel buttonPanel = new JPanel(); // Panel interior con los botones
        buttonPanel.setBackground(panel.getBackground());
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(buttonPanel, gbc);
    }

    private void styleButton(JButton button) {
        button.setBackground(null);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}