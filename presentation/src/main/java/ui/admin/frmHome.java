/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.admin;

import components.RoundedPanel;
import interfaces.IPatientService;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ang3lfco
 */
public class frmHome extends javax.swing.JFrame {
    private IPatientService patientService;
    private JPanel selectedPanel;
    /**
     * Creates new form frmHome
     */
    public frmHome(IPatientService patientService) {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
        this.patientService = patientService;
        setLocationRelativeTo(null);
        
        JPanel homePanel = new pnlHome();
        pnlContainer.removeAll();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.add(homePanel, BorderLayout.CENTER);
        pnlContainer.revalidate();
        pnlContainer.repaint();
        selectedPanel = pnlMenuHome;
        pnlMenuHome.setBackground(new Color(251,158,120));
        
        setHoverEffect(pnlMenuHome);
        setHoverEffect(pnlMenuPatients);
        setHoverEffect(pnlMenuEmployees);
        setHoverEffect(pnlMenuRequest);
        setHoverEffect(pnlMenuTest);
        setHoverEffect(pnlMenuResult);
        
        RoundedPanel mainPanel = new RoundedPanel(50, new Color(233, 233, 255));
        mainPanel.setOpaque(false);
        setContentPane(mainPanel);

        RoundedPanel menuPanel = new RoundedPanel(50, new Color(255, 255, 255));
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(pnlMenu, BorderLayout.CENTER);
        pnlMenu.setOpaque(false);

        RoundedPanel contentPanel = new RoundedPanel(50, new Color(233, 233, 255));
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(pnlGlobalContainer, BorderLayout.CENTER);
        pnlGlobalContainer.setOpaque(false);

        JPanel contentWrapper = new JPanel(new BorderLayout());
        contentWrapper.setOpaque(false);
        contentWrapper.setBorder(new EmptyBorder(10, 0, 10, 10));
        contentWrapper.add(contentPanel, BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(contentWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
    }
    
    private void setHoverEffect(JPanel panel) {
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(panel != selectedPanel){
                    panel.setBackground(new Color(233,233,255));
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(panel == selectedPanel){
                    panel.setBackground(new Color(251,158,120));
                }
                else{
                    panel.setBackground(Color.WHITE);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pnlGlobalContainer = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlMenuHome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlMenuPatients = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlMenuEmployees = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlMenuRequest = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlMenuTest = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlMenuResult = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlTitleBar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        pnlContainer = new javax.swing.JPanel();

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/result.png"))); // NOI18N
        jLabel8.setText("Result");
        jLabel8.setIconTextGap(15);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlGlobalContainer.setBackground(new java.awt.Color(233, 233, 255));

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo-icon.png"))); // NOI18N

        pnlMenuHome.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenuHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMenuHomeMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        jLabel2.setText("Home");
        jLabel2.setIconTextGap(15);

        javax.swing.GroupLayout pnlMenuHomeLayout = new javax.swing.GroupLayout(pnlMenuHome);
        pnlMenuHome.setLayout(pnlMenuHomeLayout);
        pnlMenuHomeLayout.setHorizontalGroup(
            pnlMenuHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMenuHomeLayout.setVerticalGroup(
            pnlMenuHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenuPatients.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenuPatients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMenuPatientsMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/patient-icon.png"))); // NOI18N
        jLabel3.setText("Patients");
        jLabel3.setIconTextGap(15);

        javax.swing.GroupLayout pnlMenuPatientsLayout = new javax.swing.GroupLayout(pnlMenuPatients);
        pnlMenuPatients.setLayout(pnlMenuPatientsLayout);
        pnlMenuPatientsLayout.setHorizontalGroup(
            pnlMenuPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuPatientsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMenuPatientsLayout.setVerticalGroup(
            pnlMenuPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuPatientsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenuEmployees.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenuEmployees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMenuEmployeesMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/employee-icon.png"))); // NOI18N
        jLabel4.setText("Employees");
        jLabel4.setIconTextGap(15);

        javax.swing.GroupLayout pnlMenuEmployeesLayout = new javax.swing.GroupLayout(pnlMenuEmployees);
        pnlMenuEmployees.setLayout(pnlMenuEmployeesLayout);
        pnlMenuEmployeesLayout.setHorizontalGroup(
            pnlMenuEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuEmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMenuEmployeesLayout.setVerticalGroup(
            pnlMenuEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuEmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenuRequest.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenuRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMenuRequestMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/result.png"))); // NOI18N
        jLabel5.setText("Requests");
        jLabel5.setIconTextGap(15);

        javax.swing.GroupLayout pnlMenuRequestLayout = new javax.swing.GroupLayout(pnlMenuRequest);
        pnlMenuRequest.setLayout(pnlMenuRequestLayout);
        pnlMenuRequestLayout.setHorizontalGroup(
            pnlMenuRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMenuRequestLayout.setVerticalGroup(
            pnlMenuRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenuTest.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenuTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMenuTestMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/test.png"))); // NOI18N
        jLabel6.setText("Tests");
        jLabel6.setIconTextGap(15);

        javax.swing.GroupLayout pnlMenuTestLayout = new javax.swing.GroupLayout(pnlMenuTest);
        pnlMenuTest.setLayout(pnlMenuTestLayout);
        pnlMenuTestLayout.setHorizontalGroup(
            pnlMenuTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuTestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMenuTestLayout.setVerticalGroup(
            pnlMenuTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuTestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenuResult.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenuResult.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMenuResultMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/request-icon.png"))); // NOI18N
        jLabel7.setText("Results");
        jLabel7.setIconTextGap(15);

        javax.swing.GroupLayout pnlMenuResultLayout = new javax.swing.GroupLayout(pnlMenuResult);
        pnlMenuResult.setLayout(pnlMenuResultLayout);
        pnlMenuResultLayout.setHorizontalGroup(
            pnlMenuResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMenuResultLayout.setVerticalGroup(
            pnlMenuResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Clinical Laboratory");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuPatients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(43, 43, 43)
                .addComponent(pnlMenuHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenuPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenuEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenuRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenuTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenuResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pnlTitleBar.setBackground(new java.awt.Color(233, 233, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setText("Laboratory /");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(251, 158, 120));
        lblTitle.setText("Home");

        javax.swing.GroupLayout pnlTitleBarLayout = new javax.swing.GroupLayout(pnlTitleBar);
        pnlTitleBar.setLayout(pnlTitleBarLayout);
        pnlTitleBarLayout.setHorizontalGroup(
            pnlTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(560, Short.MAX_VALUE))
        );
        pnlTitleBarLayout.setVerticalGroup(
            pnlTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlGlobalContainerLayout = new javax.swing.GroupLayout(pnlGlobalContainer);
        pnlGlobalContainer.setLayout(pnlGlobalContainerLayout);
        pnlGlobalContainerLayout.setHorizontalGroup(
            pnlGlobalContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGlobalContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTitleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGlobalContainerLayout.setVerticalGroup(
            pnlGlobalContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlobalContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlobalContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGlobalContainerLayout.createSequentialGroup()
                        .addComponent(pnlTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobalContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobalContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlMenuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuHomeMouseClicked
        // TODO add your handling code here:
        JPanel homePanel = new pnlHome();
        pnlContainer.removeAll();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.add(homePanel, BorderLayout.CENTER);
        pnlContainer.revalidate();
        pnlContainer.repaint();
        selectedPanel.setBackground(Color.WHITE);
        selectedPanel = pnlMenuHome;
        pnlMenuHome.setBackground(new Color(251,158,120));
        lblTitle.setText("Home");
    }//GEN-LAST:event_pnlMenuHomeMouseClicked

    private void pnlMenuPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuPatientsMouseClicked
        // TODO add your handling code here:
        JPanel patientsPanel = new pnlPatients(patientService);
        pnlContainer.removeAll();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.add(patientsPanel, BorderLayout.CENTER);
        pnlContainer.revalidate();
        pnlContainer.repaint();
        selectedPanel.setBackground(Color.WHITE);
        selectedPanel = pnlMenuPatients;
        pnlMenuPatients.setBackground(new Color(251,158,120));
        lblTitle.setText("Patients");
    }//GEN-LAST:event_pnlMenuPatientsMouseClicked

    private void pnlMenuEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuEmployeesMouseClicked
        // TODO add your handling code here:
        JPanel employeesPanel = new pnlEmployees();
        pnlContainer.removeAll();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.add(employeesPanel, BorderLayout.CENTER);
        pnlContainer.revalidate();
        pnlContainer.repaint();
        selectedPanel.setBackground(Color.WHITE);
        selectedPanel = pnlMenuEmployees;
        pnlMenuEmployees.setBackground(new Color(251,158,120));
        lblTitle.setText("Employees");
    }//GEN-LAST:event_pnlMenuEmployeesMouseClicked

    private void pnlMenuRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuRequestMouseClicked
        // TODO add your handling code here:
        JPanel requestPanel = new pnlRequest();
        pnlContainer.removeAll();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.add(requestPanel, BorderLayout.CENTER);
        pnlContainer.revalidate();
        pnlContainer.repaint();
        selectedPanel.setBackground(Color.WHITE);
        selectedPanel = pnlMenuRequest;
        pnlMenuRequest.setBackground(new Color(251,158,120));
        lblTitle.setText("Requests");
    }//GEN-LAST:event_pnlMenuRequestMouseClicked

    private void pnlMenuTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuTestMouseClicked
        // TODO add your handling code here:
        JPanel testPanel = new pnlTest();
        pnlContainer.removeAll();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.add(testPanel, BorderLayout.CENTER);
        pnlContainer.revalidate();
        pnlContainer.repaint();
        selectedPanel.setBackground(Color.WHITE);
        selectedPanel = pnlMenuTest;
        pnlMenuTest.setBackground(new Color(251,158,120));
        lblTitle.setText("Tests");
    }//GEN-LAST:event_pnlMenuTestMouseClicked

    private void pnlMenuResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMenuResultMouseClicked
        // TODO add your handling code here:
        JPanel resultPanel = new pnlResult();
        pnlContainer.removeAll();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.add(resultPanel, BorderLayout.CENTER);
        pnlContainer.revalidate();
        pnlContainer.repaint();
        selectedPanel.setBackground(Color.WHITE);
        selectedPanel = pnlMenuResult;
        pnlMenuResult.setBackground(new Color(251,158,120));
        lblTitle.setText("Results");
    }//GEN-LAST:event_pnlMenuResultMouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmHome().setVisible(true);
//            }
//        });
//    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlGlobalContainer;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuEmployees;
    private javax.swing.JPanel pnlMenuHome;
    private javax.swing.JPanel pnlMenuPatients;
    private javax.swing.JPanel pnlMenuRequest;
    private javax.swing.JPanel pnlMenuResult;
    private javax.swing.JPanel pnlMenuTest;
    private javax.swing.JPanel pnlTitleBar;
    // End of variables declaration//GEN-END:variables
}
