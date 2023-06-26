/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.user;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.user.User;
import hr.algebra.utils.FormUtils;
import hr.algebra.utils.MessageUtils;
import hr.algebra.view.model.admin.MovieEditPanelAdmin;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Jo
 */
public class UserRegistrationPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserLogIn
     */
    public UserRegistrationPanel() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfUsernameRegistration = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfLastNameRegistration = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfFirstNameRegistration = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnOKRegistration = new javax.swing.JButton();
        btnCancelRegistration = new javax.swing.JButton();
        btnCancelLogIn = new javax.swing.JButton();
        btnOKLogIn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfUsernameLogIn = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pfPasswordLogin = new javax.swing.JPasswordField();
        pfPasswordReg = new javax.swing.JPasswordField();
        pfConPasswordReg = new javax.swing.JPasswordField();
        lblErrPasswordLogIn = new javax.swing.JLabel();
        lblErrUsernameLogIn = new javax.swing.JLabel();
        lblErrLName = new javax.swing.JLabel();
        lblErrFName = new javax.swing.JLabel();
        lblErrPasswordReg = new javax.swing.JLabel();
        lblErrUsernameReg = new javax.swing.JLabel();
        lblErrConPasswordReg = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(230, 230, 249));
        setPreferredSize(new java.awt.Dimension(1192, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/assets/default-avatar.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRATION:");

        jLabel3.setText("Username:");

        jLabel4.setText("Password:");

        jLabel5.setText("First name:");

        jLabel6.setText("Last name:");

        jLabel7.setText("Confirm password:");

        btnOKRegistration.setText("OK");
        btnOKRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKRegistrationActionPerformed(evt);
            }
        });

        btnCancelRegistration.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelRegistration.setText("Cancel");
        btnCancelRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelRegistrationActionPerformed(evt);
            }
        });

        btnCancelLogIn.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelLogIn.setText("Cancel");
        btnCancelLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelLogInActionPerformed(evt);
            }
        });

        btnOKLogIn.setText("OK");
        btnOKLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKLogInActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("LOG IN ");

        jLabel10.setText("Username:");

        jLabel11.setText("Password:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        pfPasswordLogin.setToolTipText("");

        lblErrPasswordLogIn.setForeground(new java.awt.Color(255, 0, 51));

        lblErrUsernameLogIn.setForeground(new java.awt.Color(255, 0, 51));

        lblErrLName.setForeground(new java.awt.Color(255, 0, 51));

        lblErrFName.setForeground(new java.awt.Color(255, 0, 51));

        lblErrPasswordReg.setForeground(new java.awt.Color(255, 0, 51));

        lblErrUsernameReg.setForeground(new java.awt.Color(255, 0, 51));

        lblErrConPasswordReg.setForeground(new java.awt.Color(255, 0, 51));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/assets/default-avatar.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfUsernameLogIn)
                                    .addComponent(pfPasswordLogin)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOKLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrPasswordLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrUsernameLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrLName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrPasswordReg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrConPasswordReg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrUsernameReg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrFName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfFirstNameRegistration)
                                .addComponent(tfLastNameRegistration)
                                .addComponent(tfUsernameRegistration)
                                .addComponent(pfPasswordReg)
                                .addComponent(pfConPasswordReg)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(btnOKRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCancelRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(tfFirstNameRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(tfLastNameRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(tfUsernameRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pfPasswordReg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pfConPasswordReg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOKRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(282, 282, 282)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErrUsernameLogIn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblErrPasswordLogIn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(337, 337, 337)
                                .addComponent(lblErrFName)
                                .addGap(19, 19, 19)
                                .addComponent(lblErrLName)
                                .addGap(52, 52, 52)
                                .addComponent(lblErrUsernameReg)
                                .addGap(18, 18, 18)
                                .addComponent(lblErrPasswordReg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblErrConPasswordReg))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(146, 146, 146)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(tfUsernameLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pfPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOKLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(124, 124, 124))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private List<JTextComponent> fieldsReg;
    private List<JLabel> labelsReg;
    private List<JTextComponent> fieldsLog;
    private List<JLabel> labelsLog;
    private Repository repository;
    private static final String EDITMOVIEADMIN = "Admin Edit Movie";


    private void btnOKLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKLogInActionPerformed
        if (FormUtils.formValid(fieldsLog, labelsLog)) {
            try {
                int ID = getUserId();

                Optional<User> user = RepositoryFactory.getUserRepository().selectOne(ID);
                if (!user.isPresent()) {
                    MessageUtils.showErrorMessage("No user", "Wrong username or password");
                    clearLogInForm();
                } else if (user.get().getUserRoleID() == 1) {
                    JTabbedPane tp = new JTabbedPane();
                    Dimension d = new Dimension(1192, 768);

                    tp.setPreferredSize(d);
                    tp.setVisible(true);
                    this.setVisible(false);
                    tp.addTab(EDITMOVIEADMIN, new MovieEditPanelAdmin());
                } else {
                    MessageUtils.showErrorMessage("Error", "= user");
                }

            } catch (Exception ex) {
                Logger.getLogger(UserRegistrationPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to fetch user");
            }
        }


    }//GEN-LAST:event_btnOKLogInActionPerformed

    private void btnCancelLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelLogInActionPerformed
        clearLogInForm();

        labelsLog.forEach((field) -> {
            field.setText("");
        });
    }//GEN-LAST:event_btnCancelLogInActionPerformed

    private void btnCancelRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRegistrationActionPerformed
        fieldsReg.forEach((field) -> {
            field.setText("");
        });
        labelsReg.forEach((field) -> {
            field.setText("");
        });
    }//GEN-LAST:event_btnCancelRegistrationActionPerformed

    private void btnOKRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKRegistrationActionPerformed
        Regiser();

    }//GEN-LAST:event_btnOKRegistrationActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            init();
        } catch (IOException ex) {
            MessageUtils.showErrorMessage("Error", "Unable to connect to database");
        }
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelLogIn;
    private javax.swing.JButton btnCancelRegistration;
    private javax.swing.JButton btnOKLogIn;
    private javax.swing.JButton btnOKRegistration;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblErrConPasswordReg;
    private javax.swing.JLabel lblErrFName;
    private javax.swing.JLabel lblErrLName;
    private javax.swing.JLabel lblErrPasswordLogIn;
    private javax.swing.JLabel lblErrPasswordReg;
    private javax.swing.JLabel lblErrUsernameLogIn;
    private javax.swing.JLabel lblErrUsernameReg;
    private javax.swing.JPasswordField pfConPasswordReg;
    private javax.swing.JPasswordField pfPasswordLogin;
    private javax.swing.JPasswordField pfPasswordReg;
    private javax.swing.JTextField tfFirstNameRegistration;
    private javax.swing.JTextField tfLastNameRegistration;
    private javax.swing.JTextField tfUsernameLogIn;
    private javax.swing.JTextField tfUsernameRegistration;
    // End of variables declaration//GEN-END:variables

    private int getUserId() throws Exception {
        List<User> users = RepositoryFactory.getUserRepository().selectList();
        for (User user : users) {
            String temp = new String(pfPasswordLogin.getPassword());

            if (user.getUsername().equals(tfUsernameLogIn.getText().trim()) && user.getPassword().equals(temp)) {
                return user.getID();

            }
        }
        return 0;

    }

    private void initValidation() {
        fieldsReg = Arrays.asList(tfFirstNameRegistration, tfLastNameRegistration, tfUsernameRegistration, pfPasswordReg, pfConPasswordReg);
        labelsReg = Arrays.asList(lblErrFName, lblErrLName, lblErrUsernameReg, lblErrPasswordReg, lblErrConPasswordReg);
        fieldsLog = Arrays.asList(tfUsernameLogIn, pfPasswordLogin);
        labelsLog = Arrays.asList(lblErrUsernameLogIn, lblErrPasswordLogIn);
    }

    private void init() throws IOException {
        initValidation();
        initRepository();
    }

    private void initRepository() throws IOException {
        repository = RepositoryFactory.getUserRepository();
    }

    private void checkPass() {
        if (!Arrays.equals(pfPasswordReg.getPassword(), pfConPasswordReg.getPassword())) {
            MessageUtils.showErrorMessage("Error", "Password and confirm password MUST match");
        }
    }

    private void Regiser() {
        checkPass();

        if (FormUtils.formValid(fieldsReg, labelsReg)) {
            try {
                User user = new User(
                        tfFirstNameRegistration.getText().trim(),
                        tfLastNameRegistration.getText().trim(),
                        tfUsernameRegistration.getText().trim(),
                        new String(pfPasswordReg.getPassword())
                );

                repository.createOne(user);
                fieldsReg.forEach((field) -> {
                    field.setText("");
                });
                MessageUtils.showInformationMessage("Registration", "Registration succsessful, please LOG IN to continue!");

            } catch (Exception ex) {
                MessageUtils.showErrorMessage("Error", "Unable to register user");
            }
        }

    }

    private void clearLogInForm() {
        tfUsernameLogIn.setText("");
        pfPasswordLogin.setText("");
    }

}