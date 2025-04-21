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
public class pnlEmployees extends javax.swing.JPanel {
    private List<Employee> employees;
    private int currentPage = 1;
    private int itemsPerPage = 4;
    private List<Employee> filteredEmployees = null;
    /**
     * Creates new form pnlPatients
     */
    public pnlEmployees() {
        initComponents();
        
        tblEmployees.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Employee", "Contact Info", ""}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        });
        
        initPatients();
        fillTable(currentPage, employees);
        addTableButtons();
        
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (currentPage > 1) {
                    currentPage--;
                    fillTable(currentPage, filteredEmployees != null ? filteredEmployees : employees);
                }
            }
        });

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int total = (filteredEmployees != null ? filteredEmployees.size() : employees.size());
                int totalPages = (int) Math.ceil((double) total / itemsPerPage);
                if (currentPage < totalPages) {
                    currentPage++;
                    fillTable(currentPage, filteredEmployees != null ? filteredEmployees : employees);
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
            filteredEmployees = null;
            fillTable(currentPage, employees);
            return;
        }

        List<Employee> filtered = new ArrayList<>();
        for (Employee e : employees) {
            switch (selectedType) {
                case "name":
                    if (e.getFirstName().toLowerCase().contains(searchText)) {
                        filtered.add(e);
                    }
                    break;
                case "last name":
                    if (e.getLastName().toLowerCase().contains(searchText)) {
                        filtered.add(e);
                        break;
                    }
                    break;
                case "position":
                    if (e.getPosition().toLowerCase().contains(searchText)) {
                        filtered.add(e);
                    }
                    break;
            }
        }

        if (filtered.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No matches found.");
        }
        
        filteredEmployees = filtered;
        currentPage = 1;
        fillTable(currentPage, filteredEmployees);
    }
    
    private void fillTable(int page, List<Employee> listToShow){
        DefaultTableModel table = (DefaultTableModel) tblEmployees.getModel();
        table.setRowCount(0);
        
        int start = (page - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, listToShow.size());
        
        for (int i = start; i < end; i++) {
            Employee u = listToShow.get(i);
            Object[] row = new Object[3];
            row[0] = "<html><b>" + u.getFirstName() + " " + u.getLastName() + "</b><br><span style='font-size:9px;color:#FB9E78'>" + (u.getPosition()) + "</span></html>";
            row[1] = "<html>" + u.getAddress() + "<br><span style='font-size:9px;color:gray'>" + u.getPhoneNumber() + "</span><br><span style='font-size:9px;color:#FB9E78'>" + u.getEmail() + "</span></html>";
            table.addRow(row);
        }
        
        jLabel2.setText(String.valueOf(currentPage));
        int totalPages = (int) Math.ceil((double) listToShow.size() / itemsPerPage);
        jLabel4.setText(String.valueOf(totalPages));
        
        tblEmployees.setRowHeight(70);
        tblEmployees.setBackground(Color.WHITE);
        Font fuente = new Font("Segoe UI", Font.BOLD, 13);
        tblEmployees.getTableHeader().setFont(fuente);
        tblEmployees.getTableHeader().setPreferredSize(new Dimension(getWidth(), 50));
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setFont(fuente);
        headerRenderer.setBackground(Color.WHITE);
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        headerRenderer.setOpaque(true);

        for (int i = 0; i < tblEmployees.getColumnModel().getColumnCount(); i++) {
            tblEmployees.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    private void addTableButtons() {
        tblEmployees.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        ButtonEditor editor = new ButtonEditor(
            e -> {
                JOptionPane.showMessageDialog(null, "Edit");
            },
            e -> {
                JOptionPane.showMessageDialog(null, "Delete");
            }
        );
        tblEmployees.getColumnModel().getColumn(2).setCellEditor(editor);
    }
    
    private void initPatients() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Liam", "Martinez", "M", "1991-02-25", "145 Maple St, Orlando, FL", "555-321-7890", "liam.martinez@email.com", "liamart", "Administrative", "liam123"));
        employees.add(new Employee(2, "Mia", "Garcia", "F", "1994-10-12", "67 Lakeview Rd, Portland, OR", "555-654-1234", "mia.garcia@email.com", "miagar", "Assistant", "mia098"));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        cmbSearchType = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(233, 233, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Showing:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("1");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("of");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("15");

        txfSearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txfSearch.setText("   type and press enter to search...");
        txfSearch.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setText("<");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel6.setText(">");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblEmployees.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Employee", "Contact Info", ""
            }
        ));
        tblEmployees.setGridColor(new java.awt.Color(255, 255, 255));
        tblEmployees.setRowSelectionAllowed(false);
        tblEmployees.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblEmployees);

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
        cmbSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "name", "last name", "position", " " }));
        cmbSearchType.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
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
    
    private static class Employee {
        private int userId;
        private String firstName;
        private String lastName;
        private String gender;
        private String birthdate;
        private String address;
        private String phoneNumber;
        private String email;
        private String username;
        private String position;
        private String password;

        public Employee(int userId, String firstName, String lastName, String gender, String birthdate, String address, String phoneNumber, String email, String username, String position, String password) {
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.birthdate = birthdate;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.username = username;
            this.position = position;
            this.password = password;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(String birthdate) {
            this.birthdate = birthdate;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbSearchType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txfSearch;
    // End of variables declaration//GEN-END:variables
}
