/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bug_tracking_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author ANIK ADRISH MAJHI
 */
public class Login_Page extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    /**
     * Creates new form Login_Page
     */
    public Login_Page() {
        initComponents();
        display();
    }

    public void display(){
            lbl_user.setVisible(true);
            lbl_id.setVisible(false);
            lbl_password.setVisible(true);
            lbl_email.setVisible(false);
            txt_username.setVisible(true);
            txt_id.setVisible(false);
            txt_password.setVisible(true);
            txt_email.setVisible(false);
            btn_admin.setVisible(true);
            btn_dev.setVisible(false);
    }
    
    //validation
    public boolean validateLogin() {
        String uname = txt_username.getText();
        String pwd = txt_password.getText();
        
        
        if(uname.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter username");
            return false;
        }
        if(pwd.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter password");
            return false;
        }
        
        return true;
    }

    
    public boolean validateLogin2() {
        String uname = txt_id.getText();
        String pwd = txt_email.getText();
        
        
        if(uname.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter expert id");
            return false;
        }
        if(pwd.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter email address");
            return false;
        }
        
        return true;
    }
    
   //verify data
    public void login() {
        String uname = txt_username.getText();
        String pwd = txt_password.getText();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bug_tracking_system","root","");
            
            PreparedStatement pst = con.prepareStatement("select * from signup where user_name = ? and password = ?"); 
            pst.setString(1, uname);
            pst.setString(2, pwd);
            rs = pst.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(this, "login Successfully");
                Home_Page home = new Home_Page();
                home.setVisible(true);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void login2() {
        String uname = txt_id.getText();
        String pwd = txt_email.getText();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bug_tracking_system","root","");
            
            PreparedStatement pst = con.prepareStatement("select * from expert where id = ? and email = ?"); 
            pst.setString(1, uname);
            pst.setString(2, pwd);
            rs = pst.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(this, "login Successfully");
                Home_Page home = new Home_Page();
                home.setVisible(true);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new app.bolivia.swing.JCTextField();
        lbl_password = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        btn_admin = new necesario.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_administrator = new javax.swing.JButton();
        btn_expert = new javax.swing.JButton();
        lbl_user = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        lbl_email = new javax.swing.JLabel();
        txt_email = new app.bolivia.swing.JCTextField();
        btn_dev = new necesario.RSMaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 1, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(242, 242, 242));
        jLabel16.setText("   X");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 60, 40));

        jLabel4.setFont(new java.awt.Font("Sitka Subheading", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Login to Your Account");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 280, -1));

        lbl_id.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(242, 242, 242));
        lbl_id.setText("Id");
        jPanel2.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 248, 31));

        txt_id.setBackground(new java.awt.Color(0, 204, 255));
        txt_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_id.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_id.setPlaceholder("Enter Id");
        txt_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idFocusLost(evt);
            }
        });
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 314, -1));

        lbl_password.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(242, 242, 242));
        lbl_password.setText("Password");
        jPanel2.add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 248, 31));

        txt_password.setBackground(new java.awt.Color(0, 204, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_password.setPlaceholder("Enter Password");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 314, -1));

        rSMaterialButtonCircle1.setText("Creat New Account");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 320, 60));

        btn_admin.setText("login");
        btn_admin.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        btn_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adminActionPerformed(evt);
            }
        });
        jPanel2.add(btn_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 320, 60));

        jLabel2.setFont(new java.awt.Font("Sitka Display", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bug Tracking System");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 220, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Display", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Welcome To");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        btn_administrator.setBackground(new java.awt.Color(0, 112, 192));
        btn_administrator.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btn_administrator.setForeground(new java.awt.Color(255, 255, 255));
        btn_administrator.setText("Administrator");
        btn_administrator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_administratorMouseClicked(evt);
            }
        });
        btn_administrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_administratorActionPerformed(evt);
            }
        });
        jPanel2.add(btn_administrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        btn_expert.setBackground(new java.awt.Color(0, 112, 192));
        btn_expert.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btn_expert.setForeground(new java.awt.Color(255, 255, 255));
        btn_expert.setText("Technical Expert");
        btn_expert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_expertMouseClicked(evt);
            }
        });
        btn_expert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_expertActionPerformed(evt);
            }
        });
        jPanel2.add(btn_expert, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        lbl_user.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(242, 242, 242));
        lbl_user.setText("Username");
        jPanel2.add(lbl_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 248, 31));

        txt_username.setBackground(new java.awt.Color(0, 204, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_username.setPlaceholder("Enter Username");
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 314, -1));

        lbl_email.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(242, 242, 242));
        lbl_email.setText("Email Id");
        jPanel2.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 248, 31));

        txt_email.setBackground(new java.awt.Color(0, 204, 255));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_email.setPlaceholder("Enter Email");
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 314, -1));

        btn_dev.setText("login");
        btn_dev.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        btn_dev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_devActionPerformed(evt);
            }
        });
        jPanel2.add(btn_dev, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 320, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 530, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bug icons/bug-tracking1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 830, 800));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 800));

        setSize(new java.awt.Dimension(1500, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void txt_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idFocusLost
        
    }//GEN-LAST:event_txt_idFocusLost

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
         Signup_Page sig = new Signup_Page();
        sig.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void btn_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adminActionPerformed
        if(validateLogin()) {
            login();
        }
    }//GEN-LAST:event_btn_adminActionPerformed

    private void btn_administratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_administratorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_administratorActionPerformed

    private void btn_expertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_expertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_expertActionPerformed

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameFocusLost

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void btn_administratorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_administratorMouseClicked
        lbl_user.setVisible(true);
            lbl_id.setVisible(false);
            lbl_password.setVisible(true);
            lbl_email.setVisible(false);
            txt_username.setVisible(true);
            txt_id.setVisible(false);
            txt_password.setVisible(true);
            txt_email.setVisible(false);
            btn_admin.setVisible(true);
            btn_dev.setVisible(false);
    }//GEN-LAST:event_btn_administratorMouseClicked

    private void btn_expertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_expertMouseClicked
        lbl_user.setVisible(false);
            lbl_id.setVisible(true);
            lbl_password.setVisible(false);
            lbl_email.setVisible(true);
            txt_username.setVisible(false);
            txt_id.setVisible(true);
            txt_password.setVisible(false);
            txt_email.setVisible(true);
            btn_admin.setVisible(false);
            btn_dev.setVisible(true);
    }//GEN-LAST:event_btn_expertMouseClicked

    private void btn_devActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_devActionPerformed
        if(validateLogin2()) {
            login2();
        }
    }//GEN-LAST:event_btn_devActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private necesario.RSMaterialButtonCircle btn_admin;
    private javax.swing.JButton btn_administrator;
    private necesario.RSMaterialButtonCircle btn_dev;
    private javax.swing.JButton btn_expert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_user;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_id;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
