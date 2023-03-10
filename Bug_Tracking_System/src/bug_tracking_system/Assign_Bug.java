/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bug_tracking_system;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.DateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author ANIK ADRISH MAJHI
 */
public class Assign_Bug extends javax.swing.JFrame {

    Connection con;
    Statement st;
    /**
     * Creates new form Report_Bugs
     */
    DefaultTableModel model;
    String Priority,Status,Author;
    int Id;
    
    
    public Assign_Bug() {
        initComponents();
       //getRecords();
       expertComboBox();
       setBugDetailsToTable();
    }

   
    
    
    
    
    public void expertComboBox(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bug_tracking_system","root","");
           PreparedStatement st = con.prepareStatement("select name from expert");
           ResultSet rs = st.executeQuery();
           while(rs.next()){
               combo_expert.addItem(rs.getString("name"));
           }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void setBugDetailsToTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bug_tracking_system","root","");
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from reportbug");
            
            while(rs.next()) {
                String Id = rs.getString("id");
                String Title = rs.getString("title");
                String Type = rs.getString("type");
                String Des = rs.getString("description");
                String Date = rs.getString("time");
                String Author = rs.getString("author");
                String Priority = rs.getString("priority");
                String Status = rs.getString("status");
                
                Object[] obj = {Id,Title,Type,Des,Date,Author,Priority,Status};
                model =(DefaultTableModel) tbl_bugDetails.getModel();
                model.addRow(obj);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //to update student to book_details table
    public boolean updateBug() {
        boolean isUpdated = false;
        Id = Integer.parseInt(txt_bugId.getText());
        Author = combo_expert.getSelectedItem().toString();
        Status = combo_status.getSelectedItem().toString();
        Priority = combo_priority.getSelectedItem().toString();
        
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bug_tracking_system","root","");
            String sql = "update reportbug set author = ?,priority = ?,status = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql); 
           
            pst.setString(1, Author);
            pst.setString(2, Priority);
            pst.setString(3, Status);
            pst.setInt(4, Id);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
       return isUpdated;
    }
    
    
    //method to clear table
    public void clearTable() {
        model =(DefaultTableModel) tbl_bugDetails.getModel();
        model.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelParent = new javax.swing.JPanel();
        lbl_ChequeNo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_BankName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combo_expert = new javax.swing.JComboBox<>();
        txt_date = new javax.swing.JLabel();
        txt_bugId = new javax.swing.JLabel();
        txt_BugTitle = new javax.swing.JLabel();
        txt_Type = new javax.swing.JLabel();
        txt_Desc = new javax.swing.JLabel();
        combo_status = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bugDetails = new rojerusan.RSTableMetro();
        lbl_ChequeNo1 = new javax.swing.JLabel();
        combo_priority = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelParent.setBackground(new java.awt.Color(0, 204, 204));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ChequeNo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_ChequeNo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ChequeNo.setText("Priority :");
        panelParent.add(lbl_ChequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 730, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bug Id :   ");
        panelParent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bug Title :");
        panelParent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, -1, -1));

        lbl_BankName.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_BankName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_BankName.setText("Type :");
        panelParent.add(lbl_BankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Developer's List :");
        panelParent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 570, 150, 30));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("    X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panelParent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 70, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Assign Bug");
        panelParent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelParent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 250, 30));

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelParent.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 740, 140, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date :");
        panelParent.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Status :");
        panelParent.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, -1, -1));

        combo_expert.setBackground(new java.awt.Color(0, 204, 204));
        combo_expert.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combo_expert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_expertActionPerformed(evt);
            }
        });
        panelParent.add(combo_expert, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 630, 290, 30));

        txt_date.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_date.setForeground(new java.awt.Color(255, 255, 255));
        panelParent.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 190, 40));

        txt_bugId.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_bugId.setForeground(new java.awt.Color(255, 255, 255));
        panelParent.add(txt_bugId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 150, 40));

        txt_BugTitle.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_BugTitle.setForeground(new java.awt.Color(255, 255, 255));
        panelParent.add(txt_BugTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 320, 40));

        txt_Type.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_Type.setForeground(new java.awt.Color(255, 255, 255));
        panelParent.add(txt_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 320, 40));

        txt_Desc.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_Desc.setForeground(new java.awt.Color(255, 255, 255));
        panelParent.add(txt_Desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 630, 320, 40));

        combo_status.setBackground(new java.awt.Color(0, 204, 204));
        combo_status.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        combo_status.setForeground(new java.awt.Color(255, 255, 255));
        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "New", "pending", "Successfull", "Complete" }));
        panelParent.add(combo_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 220, 40));

        tbl_bugDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bug Id", "Bug Title", "Type", "Description", "Date", "Author", "Priority", "Status"
            }
        ));
        tbl_bugDetails.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        tbl_bugDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bugDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bugDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bugDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 23)); // NOI18N
        tbl_bugDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        tbl_bugDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        tbl_bugDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_bugDetails.setRowHeight(30);
        tbl_bugDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bugDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bugDetails);

        panelParent.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 1040, 250));

        lbl_ChequeNo1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_ChequeNo1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ChequeNo1.setText("Description :");
        panelParent.add(lbl_ChequeNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 630, -1, 30));

        combo_priority.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        combo_priority.setForeground(new java.awt.Color(255, 255, 255));
        combo_priority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Low", "High", "Medium" }));
        panelParent.add(combo_priority, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 722, 240, 40));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 1150, 800));

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Sitka Display", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Welcome To");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Display", 0, 20)); // NOI18N
        jLabel8.setText("Bug Tracking System");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 180, -1));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel14.setText("           Home ");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 250, 50));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        jLabel5.setText("View Technical Expert ");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 250, 50));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel13.setText("View All Report ");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 190, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 250, 50));

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel16.setText("  Report New Bug ");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 250, 50));

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel15.setText("Logout");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 130, 50));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        jLabel12.setText("     Testing Report");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 250, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 800));

        setSize(new java.awt.Dimension(1500, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if(updateBug() == true) {
            //JOptionPane.showMessageDialog(this, "Bug Assign");
            clearTable();
            setBugDetailsToTable();
        }else {
           // JOptionPane.showMessageDialog(this, "Bug Assign failed");
        }
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo_expertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_expertActionPerformed
      
    }//GEN-LAST:event_combo_expertActionPerformed

    private void tbl_bugDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bugDetailsMouseClicked
        int rowNo = tbl_bugDetails.getSelectedRow();
        TableModel model = tbl_bugDetails.getModel();

        txt_bugId.setText(model.getValueAt(rowNo, 0).toString());
        txt_BugTitle.setText(model.getValueAt(rowNo, 1).toString());
        txt_Type.setText(model.getValueAt(rowNo, 2).toString());
        txt_Desc.setText(model.getValueAt(rowNo, 3).toString());
        txt_date.setText(model.getValueAt(rowNo, 4).toString());
        combo_expert.setSelectedItem(model.getValueAt(rowNo, 5).toString());
        combo_priority.setSelectedItem(model.getValueAt(rowNo, 6).toString());
        combo_status.setSelectedItem(model.getValueAt(rowNo, 7).toString());
        
    }//GEN-LAST:event_tbl_bugDetailsMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Home_Page s=new Home_Page();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        Color clr = new Color(0,102,102);
        jPanel6.setBackground(clr);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        Color clr = new Color(0,204,204);
        jPanel6.setBackground(clr);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Technical_Expert s = new Technical_Expert();
        s.show();
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        Color clr = new Color(0,102,102);
        jPanel2.setBackground(clr);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        Color clr = new Color(0,204,204);
        jPanel2.setBackground(clr);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        AllReport s=new AllReport();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        Color clr = new Color(0,102,102);
        jPanel4.setBackground(clr);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        Color clr = new Color(0,204,204);
        jPanel4.setBackground(clr);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        Report_Bugs s=new Report_Bugs();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        Color clr = new Color(0,102,102);
        jPanel7.setBackground(clr);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        Color clr = new Color(0,204,204);
        jPanel7.setBackground(clr);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        Login_Page s=new Login_Page();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        Color clr = new Color(0,102,102);
        jPanel5.setBackground(clr);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        Color clr = new Color(0,204,204);
        jPanel5.setBackground(clr);
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        TestBug s = new TestBug();
        s.show();
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        Color clr = new Color(0,102,102);
        jPanel2.setBackground(clr);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        Color clr = new Color(0,204,204);
        jPanel2.setBackground(clr);
    }//GEN-LAST:event_jLabel12MouseExited

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
            java.util.logging.Logger.getLogger(Assign_Bug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assign_Bug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assign_Bug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assign_Bug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assign_Bug().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_expert;
    private javax.swing.JComboBox<String> combo_priority;
    private javax.swing.JComboBox<String> combo_status;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_BankName;
    private javax.swing.JLabel lbl_ChequeNo;
    private javax.swing.JLabel lbl_ChequeNo1;
    private javax.swing.JPanel panelParent;
    private rojerusan.RSTableMetro tbl_bugDetails;
    private javax.swing.JLabel txt_BugTitle;
    private javax.swing.JLabel txt_Desc;
    private javax.swing.JLabel txt_Type;
    private javax.swing.JLabel txt_bugId;
    private javax.swing.JLabel txt_date;
    // End of variables declaration//GEN-END:variables
}
