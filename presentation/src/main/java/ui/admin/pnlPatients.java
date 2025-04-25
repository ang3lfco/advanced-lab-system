/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.admin;

import components.ButtonEditor;
import components.ButtonRenderer;
import dtos.PatientDTO;
import interfaces.IPatientService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ui.admin.forms.frmPatientInfo;

/**
 *
 * @author ang3lfco
 */
public class pnlPatients extends javax.swing.JPanel {
    private List<PatientDTO> patients;
    private int currentPage = 1;
    private int itemsPerPage = 4;
    private List<PatientDTO> filteredPatients = null;
    private IPatientService patientService;
    /**
     * Creates new form pnlPatients
     */
    public pnlPatients(IPatientService patientService) {
        initComponents();
        this.patientService = patientService;
        
        tblPatients.setBorder(BorderFactory.createEmptyBorder());
        tblPatients.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Patient", "Contact Info", ""}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        });
        tblPatients.setBorder(BorderFactory.createEmptyBorder());
        initPatients();
        fillTable(currentPage, patients);
        addTableButtons();
        
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (currentPage > 1) {
                    currentPage--;
                    fillTable(currentPage, filteredPatients != null ? filteredPatients : patients);
                }
            }
        });

        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int total = (filteredPatients != null ? filteredPatients.size() : patients.size());
                int totalPages = (int) Math.ceil((double) total / itemsPerPage);
                if (currentPage < totalPages) {
                    currentPage++;
                    fillTable(currentPage, filteredPatients != null ? filteredPatients : patients);
                }
            }
        });
        
        txfSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search();
            }
        });
        
        cmbSearchType.setBackground(new Color(255, 255, 255));
        cmbSearchType.setForeground(new Color(0, 0, 0));
        cmbSearchType.setFont(new Font("Segoe UI", Font.BOLD, 13));
        cmbSearchType.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));
        cmbSearchType.setFocusable(false);

        cmbSearchType.setRenderer(new javax.swing.plaf.basic.BasicComboBoxRenderer() {
            @Override
            public Component getListCellRendererComponent(javax.swing.JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                c.setBackground(isSelected ? new Color(251,158,120) : Color.WHITE);
                c.setForeground(new Color(0, 0, 0));
                c.setFont(new Font("Segoe UI", Font.BOLD, 13));
                return c;
            }
        });
    }
    
    private void search() {
        String searchText = txfSearch.getText().trim().toLowerCase();
        String selectedType = (String) cmbSearchType.getSelectedItem();

        if (searchText.isEmpty()) {
            filteredPatients = null;
            fillTable(currentPage, patients);
            return;
        }

        List<PatientDTO> filtered = new ArrayList<>();
        for (PatientDTO p : patients) {
            switch (selectedType) {
                case "patient name":
                    if (p.getFirstName().toLowerCase().contains(searchText)) {
                        filtered.add(p);
                    }
                    break;
                case "last name":
                    if (p.getLastName().toLowerCase().contains(searchText)) {
                        filtered.add(p);
                        break;
                    }
                    break;
                case "gender":
                    if (p.getGender().toLowerCase().contains(searchText)) {
                        filtered.add(p);
                    }
                    break;
            }
        }

        if (filtered.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No matches found.");
        }
        
        filteredPatients = filtered;
        currentPage = 1;
        fillTable(currentPage, filteredPatients);
    }
    
    private void fillTable(int page, List<PatientDTO> listToShow){
        DefaultTableModel table = (DefaultTableModel) tblPatients.getModel();
        table.setRowCount(0);
        
        int start = (page - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, listToShow.size());
        
        for (int i = start; i < end; i++) {
            PatientDTO p = listToShow.get(i);
            Object[] row = new Object[3];
            row[0] = "<html><b>" + p.getFirstName() + " " + p.getLastName() + "</b><br><span style='font-size:9px;color:gray'>" + (p.getGender().equalsIgnoreCase("F") ? "Female" : "Male") + "</span></html>";
            row[1] = "<html>" + p.getAddress() + "<br><span style='font-size:9px;color:gray'>" + p.getPhoneNumber() + "</span><br><span style='font-size:9px;color:#FB9E78'>" + p.getEmail() + "</span></html>";
            table.addRow(row);
        }
        
        lblLeftCounter.setText(String.valueOf(currentPage));
        int totalPages = (int) Math.ceil((double) listToShow.size() / itemsPerPage);
        lblRightCounter.setText(String.valueOf(totalPages));
        
        tblPatients.setRowHeight(70);
        tblPatients.setBackground(Color.WHITE);
        Font fuente = new Font("Segoe UI", Font.BOLD, 13);
        tblPatients.getTableHeader().setFont(fuente);
        tblPatients.getTableHeader().setPreferredSize(new Dimension(getWidth(), 50));
        tblPatients.setBorder(BorderFactory.createEmptyBorder());
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setFont(fuente);
        headerRenderer.setBackground(Color.WHITE);
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        headerRenderer.setOpaque(true);

        for (int i = 0; i < tblPatients.getColumnModel().getColumnCount(); i++) {
            tblPatients.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    private void addTableButtons() {
        tblPatients.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        ButtonEditor editor = new ButtonEditor(
            e -> {
                JOptionPane.showMessageDialog(null, "Edit");
            },
            e -> {
                JOptionPane.showMessageDialog(null, "Delete");
            }
        );
        tblPatients.getColumnModel().getColumn(2).setCellEditor(editor);
    }
    
    private void initPatients() {
        patients = patientService.consultPatientList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLeftCounter = new javax.swing.JLabel();
        lblOf = new javax.swing.JLabel();
        lblRightCounter = new javax.swing.JLabel();
        txfSearch = new javax.swing.JTextField();
        lblBack = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        cmbSearchType = new javax.swing.JComboBox<>();
        lblAddPatient = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(233, 233, 255));

        lblLeftCounter.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblLeftCounter.setText("1");

        lblOf.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblOf.setText("of");

        lblRightCounter.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblRightCounter.setText("15");

        txfSearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txfSearch.setText("   type and press enter to search...");
        txfSearch.setBorder(null);

        lblBack.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblBack.setText("<");
        lblBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblNext.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblNext.setText(">");
        lblNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblPatients.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient", "Contact Info", ""
            }
        ));
        tblPatients.setGridColor(new java.awt.Color(255, 255, 255));
        tblPatients.setRowSelectionAllowed(false);
        tblPatients.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblPatients);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );

        cmbSearchType.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cmbSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "patient name", "last name", "gender" }));
        cmbSearchType.setBorder(null);

        lblAddPatient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAddPatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add3-icon.png"))); // NOI18N
        lblAddPatient.setText("Add new patient");
        lblAddPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddPatient.setIconTextGap(8);
        lblAddPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddPatientMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAddPatient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBack)
                        .addGap(18, 18, 18)
                        .addComponent(lblLeftCounter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRightCounter)
                        .addGap(18, 18, 18)
                        .addComponent(lblNext)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLeftCounter)
                    .addComponent(lblOf)
                    .addComponent(lblRightCounter)
                    .addComponent(lblBack)
                    .addComponent(lblNext)
                    .addComponent(lblAddPatient))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblAddPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddPatientMouseClicked
        // TODO add your handling code here:
        frmPatientInfo patientInfo = new frmPatientInfo(patientService);
        patientInfo.setVisible(true);
    }//GEN-LAST:event_lblAddPatientMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbSearchType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddPatient;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblLeftCounter;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblOf;
    private javax.swing.JLabel lblRightCounter;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextField txfSearch;
    // End of variables declaration//GEN-END:variables
}
