/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.admin;

import components.ButtonEditor;
import components.ButtonRenderer;
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

/**
 *
 * @author ang3lfco
 */
public class pnlRequest extends javax.swing.JPanel {
    private List<Request> requests;
    private int currentPage = 1;
    private int itemsPerPage = 4;
    /**
     * Creates new form pnlRequest
     */
    public pnlRequest() {
        initComponents();
        
        tblRequests.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Request Info", "General info", ""}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        });
        
        initRequests();

        fillTable(currentPage, requests);
        addTableButtons();
        
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (currentPage > 1) {
                    currentPage--;
                    fillTable(currentPage, requests);
                }
            }
        });

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int totalPages = (int) Math.ceil((double) requests.size() / itemsPerPage);
                if (currentPage < totalPages) {
                    currentPage++;
                    fillTable(currentPage, requests);
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
            fillTable(currentPage, requests);
            return;
        }

        List<Request> filtered = new ArrayList<>();
        for (Request r : requests) {
            switch (selectedType) {
                case "patient name":
                    if (r.getPatient().toLowerCase().contains(searchText)) {
                        filtered.add(r);
                    }
                    break;
                case "test name":
                    for (String test : r.getTests()) {
                        if (test.toLowerCase().contains(searchText)) {
                            filtered.add(r);
                            break;
                        }
                    }
                    break;
                case "test status":
                    if (r.getStatus().toLowerCase().contains(searchText)) {
                        filtered.add(r);
                    }
                    break;
            }
        }

        if (filtered.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No matches found.");
        }

        currentPage = 1;
        fillTable(currentPage, filtered);
    }

    
    private void fillTable(int page, List<Request> listToShow){
        DefaultTableModel table = (DefaultTableModel) tblRequests.getModel();
        table.setRowCount(0);
        
        int start = (page - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, listToShow.size());
        
        for (int i = start; i < end; i++) {
            Request r = listToShow.get(i);
            Object[] row = new Object[3];
            
            String[] tests = r.getTests();
            String additionalTests = "";
            if (tests != null && tests.length > 0) {
                additionalTests = tests[0];
                if (tests.length > 1) {
                    additionalTests += " <span style='color:#FB9E78'>(+" + (tests.length - 1) + ")</span>";
                }
            }
            
            row[0] = "<html><b>" + r.getRequestedAt() + "</b><br><span style='font-size:9px;color:#FB9E78'>" + (r.getStatus()) + "</span></html>";
            row[1] = "<html><b>" + additionalTests + "</b><br><span style='font-size:9px'>" + r.getPatient() + "</span></html>";
            table.addRow(row);
        }
        
        jLabel3.setText(String.valueOf(currentPage));
        int totalPages = (int) Math.ceil((double) listToShow.size() / itemsPerPage);
        jLabel5.setText(String.valueOf(totalPages));
        
        tblRequests.setRowHeight(70);
        tblRequests.setBackground(Color.WHITE);
        Font fuente = new Font("Segoe UI", Font.BOLD, 13);
        tblRequests.getTableHeader().setFont(fuente);
        tblRequests.getTableHeader().setPreferredSize(new Dimension(getWidth(), 50));
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setFont(fuente);
        headerRenderer.setBackground(Color.WHITE);
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        headerRenderer.setOpaque(true);

        for (int i = 0; i < tblRequests.getColumnModel().getColumnCount(); i++) {
            tblRequests.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    private void addTableButtons() {
        tblRequests.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        ButtonEditor editor = new ButtonEditor(
            e -> {
                JOptionPane.showMessageDialog(null, "Edit");
            },
            e -> {
                JOptionPane.showMessageDialog(null, "Delete");
            }
        );
        tblRequests.getColumnModel().getColumn(2).setCellEditor(editor);
    }
    
    private void initRequests() {
        String[] testsUser1 = {"BRCA1/BRCA2 Gene Test", "Urinalysis"};
        String[] testsUser2 = {"Testosterone"};
        String[] testsUser3 = {"COVID-19 PCR", "Thyroid Stimulating Hormone", "Cortisol Test"};
        
        requests = new ArrayList<>();
        requests.add(new Request(1, "2025-04-19 17:07:00", "Completed", "Emily Smith", testsUser1));
        requests.add(new Request(2, "2025-04-19 17:13:00", "In progress", "James Johnson", testsUser2));
        requests.add(new Request(3, "2025-04-19 17:18:00", "Cancelled", "Olivia Brown", testsUser3));
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequests = new javax.swing.JTable();
        txfSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbSearchType = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(233, 233, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblRequests.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tblRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Request Info", "Patient Info", ""
            }
        ));
        tblRequests.setGridColor(new java.awt.Color(255, 255, 255));
        tblRequests.setRowSelectionAllowed(false);
        tblRequests.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblRequests);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );

        txfSearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txfSearch.setText("   type and press enter to search...");
        txfSearch.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Showing:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("of");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("15");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel6.setText("<");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel7.setText(">");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmbSearchType.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cmbSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "patient name", "test name", "test status" }));
        cmbSearchType.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
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
    
    public class Request{
        private int requestId;
        private String requestedAt;
        private String status;
        private String patient;
        private String[] tests;

        public Request(int requestId, String requestedAt, String status, String patient, String[] tests) {
            this.requestId = requestId;
            this.requestedAt = requestedAt;
            this.status = status;
            this.patient = patient;
            this.tests = tests;
        }

        public int getRequestId() {
            return requestId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
        }

        public String getRequestedAt() {
            return requestedAt;
        }

        public void setRequestedAt(String requestedAt) {
            this.requestedAt = requestedAt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPatient() {
            return patient;
        }

        public void setPatient(String patient) {
            this.patient = patient;
        }

        public String[] getTests() {
            return tests;
        }

        public void setTests(String[] tests) {
            this.tests = tests;
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbSearchType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRequests;
    private javax.swing.JTextField txfSearch;
    // End of variables declaration//GEN-END:variables
}
