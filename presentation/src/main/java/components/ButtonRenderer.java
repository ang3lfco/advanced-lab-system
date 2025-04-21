/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ang3lfco
 */
public class ButtonRenderer extends JPanel implements TableCellRenderer {
    private final JButton editButton;
    private final JButton deleteButton;

    public ButtonRenderer() {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        editButton = new JButton(new ImageIcon(getClass().getResource("/icons/view20x.png")));
        deleteButton = new JButton(new ImageIcon(getClass().getResource("/icons/delete20x.png")));

        styleButton(editButton);
        styleButton(deleteButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(buttonPanel, gbc);
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}