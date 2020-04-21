/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Jayjomjohn
 */
public class MainHome extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    
    
    public MainHome() {
        initComponents();
        conn=JavaConnector.ConnecrDb();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        
        showDate();
        showTime();
        table();
        showemployee();
        showposition();
        showaccount();
        showdata1();
        showdata2();
        showdata3();
        showaudit();
        
        countaudit();
        countemployee();
        countposition();
        countaccount();
        countcash();
        countuser();
    }
//TABLEHEAD========================================================================================    
public final void table() {    
       jTable8.setShowGrid(true);
       jTable8.setGridColor(Color.DARK_GRAY);
       jTable8.setSelectionBackground(Color.lightGray);      
       JTableHeader th = jTable8.getTableHeader();
       th.setForeground(Color.BLACK);
       th.setFont(new Font("Century Gothic", Font.BOLD, 14));
}        
//SHOWDATATABLE====================================================================================
public void showaudit(){
   try {
            String sql ="Select Login_Name, Date, Status from tblaudit";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable7.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));                    
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }    
}
public void showemployee(){
        try {
            String sql ="Select * from tblemployee";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();          
            jTable8.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs)); 
            jTable8.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
          
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
}    

public void showposition(){
    
        try {
            String sql="select * from tblposition";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void showaccount(){
      try {
            String sql="select * from tblaccount";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable6.setModel(DbUtils.resultSetToTableModel(rs));
            jTable6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void showdata1(){
       try {
            String sql="select id, firstname, middlename, lastname, address, contact, gender, date_of_birth, status from tblemployee";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void showdata2(){
         try {
            String sql="select * from tblposition";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void showdata3(){
         try {
            String sql="select * from tblaccount";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable5.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
}

//SHOWDATE & TIME ==================================================================================    
public final void showDate() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("MMMM dd, yyyy");
        SimpleDateFormat a = new SimpleDateFormat("EEEE");
        Date.setText(s.format(d)+", it's "+a.format(d));
        }  
public final void showTime() {
          new Timer(0, new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            java.util.Date d = new java.util.Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
            Time.setText(s.format(d));
            }
            }).start();
   }   
//SETPANELBACKGROUND==============================================================================    
  public void setColor (JPanel pane) {
        pane.setBackground(new Color(58,83,155));
    }
    public void resetColor(JPanel []pane, JPanel[] indicators) {
        for (int i=0; i<pane.length; i++) {
           pane[i].setBackground(new Color(1,50,67));
            
        }for (int i=0; i<indicators.length; i++) {
           indicators[i].setOpaque(false);          
        }
    }   
//SETFONTS==========================================================================================
public void setFont(JLabel label) {    
        label.setFont(new java.awt.Font("Century Gothic BOLD", 0, 16)); // NOI18N
        label.setForeground(Color.WHITE);
}
public void resetFont(JLabel label){
        label.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label.setForeground(new Color(255,255,255));
}    
//SETBACKGROUND TEXTFIELDS==========================================================================
public void setTextfield(JTextField text){
       text.setBackground(new java.awt.Color(255, 255, 201));
}
public void resetTextfield(JTextField text){
       text.setBackground(new java.awt.Color(255,255,255));
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
        PanelHead = new javax.swing.JPanel();
        Exit = new javax.swing.JButton();
        Minimize = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PanelSide = new javax.swing.JPanel();
        BTN1 = new javax.swing.JPanel();
        PN1 = new javax.swing.JPanel();
        Label1 = new javax.swing.JLabel();
        BTN2 = new javax.swing.JPanel();
        PN2 = new javax.swing.JPanel();
        Label2 = new javax.swing.JLabel();
        BTN3 = new javax.swing.JPanel();
        PN3 = new javax.swing.JPanel();
        Label3 = new javax.swing.JLabel();
        BTN4 = new javax.swing.JPanel();
        PN4 = new javax.swing.JPanel();
        Label4 = new javax.swing.JLabel();
        BTN5 = new javax.swing.JPanel();
        PN5 = new javax.swing.JPanel();
        Label5 = new javax.swing.JLabel();
        BTN6 = new javax.swing.JPanel();
        PN6 = new javax.swing.JPanel();
        Label6 = new javax.swing.JLabel();
        BTN7 = new javax.swing.JPanel();
        PN7 = new javax.swing.JPanel();
        Label7 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        labelmg = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PanelFoot = new javax.swing.JPanel();
        Date = new javax.swing.JLabel();
        LabelTime = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        CardPanel = new javax.swing.JPanel();
        PanelDash = new javax.swing.JPanel();
        Dashboard = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        count_log = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        count_employee = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        count_position = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        count_account = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        count_cash = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        count_user = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        editpanel = new javax.swing.JPanel();
        btn_edit = new javax.swing.JButton();
        addpanel = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        deletepanel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        aID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        afirstname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        amiddlename = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        alastname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        aAddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        aContact = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Combo_Status = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        label_uplod = new javax.swing.JLabel();
        clearPanel = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        Combo_Gender = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        Panel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        position_id = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        position_name = new javax.swing.JTextField();
        pdailyrate = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        pmonthlyrate = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        pworkingdays = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        Label_img = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        Panel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        emp_id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        e2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        e3 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        e4 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        e5 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        e6 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        e7 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        e8 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        e9 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        e10 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        e11 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        total_without_deduction = new javax.swing.JTextField();
        gross_salary = new javax.swing.JTextField();
        advancepay = new javax.swing.JTextField();
        total_salary = new javax.swing.JTextField();
        overtimepay = new javax.swing.JTextField();
        pag_ibigtax = new javax.swing.JTextField();
        SSStax = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        philhealth = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        e12 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        eposition_name = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        Panel5 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        PanelInfo = new javax.swing.JPanel();
        Panel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        Panel6 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 770));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1370, 770));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelHead.setBackground(new java.awt.Color(1, 50, 67));
        PanelHead.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Close_Window_35px.png"))); // NOI18N
        Exit.setToolTipText("Close Window");
        Exit.setBorderPainted(false);
        Exit.setContentAreaFilled(false);
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.setFocusPainted(false);
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        PanelHead.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1336, 0, 33, 44));

        Minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Minimize_Window_35px.png"))); // NOI18N
        Minimize.setToolTipText("Minimize Window");
        Minimize.setBorderPainted(false);
        Minimize.setContentAreaFilled(false);
        Minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimize.setFocusPainted(false);
        Minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinimizeActionPerformed(evt);
            }
        });
        PanelHead.add(Minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1298, 0, 33, 44));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Payroll Management System");
        PanelHead.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 11, 275, 33));

        jPanel1.add(PanelHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1375, 55));

        PanelSide.setBackground(new java.awt.Color(1, 50, 67));
        PanelSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN1.setBackground(new java.awt.Color(58, 83, 155));
        BTN1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN1MousePressed(evt);
            }
        });
        BTN1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PN1Layout = new javax.swing.GroupLayout(PN1);
        PN1.setLayout(PN1Layout);
        PN1Layout.setHorizontalGroup(
            PN1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        PN1Layout.setVerticalGroup(
            PN1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        BTN1.add(PN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 11, 66));

        Label1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Label1.setForeground(new java.awt.Color(255, 255, 255));
        Label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Home_35px.png"))); // NOI18N
        Label1.setText("DashBoard");
        BTN1.add(Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, 231, 44));

        PanelSide.add(BTN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 286, -1));

        BTN2.setBackground(new java.awt.Color(1, 50, 67));
        BTN2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN2MousePressed(evt);
            }
        });
        BTN2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PN2.setOpaque(false);

        javax.swing.GroupLayout PN2Layout = new javax.swing.GroupLayout(PN2);
        PN2.setLayout(PN2Layout);
        PN2Layout.setHorizontalGroup(
            PN2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        PN2Layout.setVerticalGroup(
            PN2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        BTN2.add(PN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 11, 66));

        Label2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Label2.setForeground(new java.awt.Color(255, 255, 255));
        Label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Add_User_Group_Woman_Man_35px.png"))); // NOI18N
        Label2.setText("Add Employee");
        BTN2.add(Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, 231, 44));

        PanelSide.add(BTN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 286, 286, -1));

        BTN3.setBackground(new java.awt.Color(1, 50, 67));
        BTN3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN3MousePressed(evt);
            }
        });
        BTN3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PN3.setOpaque(false);

        javax.swing.GroupLayout PN3Layout = new javax.swing.GroupLayout(PN3);
        PN3.setLayout(PN3Layout);
        PN3Layout.setHorizontalGroup(
            PN3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        PN3Layout.setVerticalGroup(
            PN3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        BTN3.add(PN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 11, 66));

        Label3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Label3.setForeground(new java.awt.Color(255, 255, 255));
        Label3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Businessman_35px.png"))); // NOI18N
        Label3.setText("Add Position");
        BTN3.add(Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, 231, 44));

        PanelSide.add(BTN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 352, 286, -1));

        BTN4.setBackground(new java.awt.Color(1, 50, 67));
        BTN4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN4MousePressed(evt);
            }
        });
        BTN4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PN4.setOpaque(false);

        javax.swing.GroupLayout PN4Layout = new javax.swing.GroupLayout(PN4);
        PN4.setLayout(PN4Layout);
        PN4Layout.setHorizontalGroup(
            PN4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        PN4Layout.setVerticalGroup(
            PN4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        BTN4.add(PN4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 11, 66));

        Label4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Label4.setForeground(new java.awt.Color(255, 255, 255));
        Label4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Payroll_35px.png"))); // NOI18N
        Label4.setText("Add Information Payroll");
        BTN4.add(Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, 231, 44));

        PanelSide.add(BTN4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 418, 286, -1));

        BTN5.setBackground(new java.awt.Color(1, 50, 67));
        BTN5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN5MousePressed(evt);
            }
        });
        BTN5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PN5.setOpaque(false);

        javax.swing.GroupLayout PN5Layout = new javax.swing.GroupLayout(PN5);
        PN5.setLayout(PN5Layout);
        PN5Layout.setHorizontalGroup(
            PN5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        PN5Layout.setVerticalGroup(
            PN5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        BTN5.add(PN5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 11, 66));

        Label5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Label5.setForeground(new java.awt.Color(255, 255, 255));
        Label5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_System_Information_35px.png"))); // NOI18N
        Label5.setText("Information Employee");
        BTN5.add(Label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, 231, 44));

        PanelSide.add(BTN5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 484, 286, -1));

        BTN6.setBackground(new java.awt.Color(1, 50, 67));
        BTN6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN6MousePressed(evt);
            }
        });
        BTN6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PN6.setOpaque(false);

        javax.swing.GroupLayout PN6Layout = new javax.swing.GroupLayout(PN6);
        PN6.setLayout(PN6Layout);
        PN6Layout.setHorizontalGroup(
            PN6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        PN6Layout.setVerticalGroup(
            PN6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        BTN6.add(PN6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 11, 66));

        Label6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Label6.setForeground(new java.awt.Color(255, 255, 255));
        Label6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Schedule_35px.png"))); // NOI18N
        Label6.setText("Logs History");
        Label6.setToolTipText("");
        BTN6.add(Label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, 231, 44));

        PanelSide.add(BTN6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 286, -1));

        BTN7.setBackground(new java.awt.Color(1, 50, 67));
        BTN7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN7MousePressed(evt);
            }
        });
        BTN7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PN7.setOpaque(false);

        javax.swing.GroupLayout PN7Layout = new javax.swing.GroupLayout(PN7);
        PN7.setLayout(PN7Layout);
        PN7Layout.setHorizontalGroup(
            PN7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        PN7Layout.setVerticalGroup(
            PN7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        BTN7.add(PN7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 11, 66));

        Label7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Label7.setForeground(new java.awt.Color(255, 255, 255));
        Label7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Sign_Out_35px.png"))); // NOI18N
        Label7.setText("Log-Out");
        BTN7.add(Label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, 231, 44));

        PanelSide.add(BTN7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 616, 286, -1));

        jDesktopPane1.setBackground(new java.awt.Color(108, 122, 137));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));

        labelmg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jDesktopPane1.setLayer(labelmg, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelmg, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelmg, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );

        PanelSide.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        labelLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(204, 204, 204));
        labelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogin.setText("Logged in As: ");
        PanelSide.add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 174, 180, 30));
        PanelSide.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 180, 10));

        jPanel1.add(PanelSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 286, 715));

        PanelFoot.setBackground(new java.awt.Color(1, 50, 67));
        PanelFoot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Date.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Date.setForeground(new java.awt.Color(255, 255, 255));
        Date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Calendar_35px_1.png"))); // NOI18N
        Date.setText("Date:");
        PanelFoot.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 1, 253, 33));

        LabelTime.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        LabelTime.setForeground(new java.awt.Color(204, 204, 204));
        LabelTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Clock_35px.png"))); // NOI18N
        LabelTime.setText("Time:");
        LabelTime.setIconTextGap(10);
        PanelFoot.add(LabelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, -2, 99, 33));

        Time.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        PanelFoot.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 154, 33));

        jPanel1.add(PanelFoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 738, 1375, 33));

        CardPanel.setBackground(new java.awt.Color(255, 255, 255));
        CardPanel.setLayout(new java.awt.CardLayout());

        PanelDash.setBackground(new java.awt.Color(255, 255, 255));

        Dashboard.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Dashboard.setText("DASHBOARD");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 111, 177));

        count_log.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        count_log.setForeground(new java.awt.Color(255, 255, 255));
        count_log.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton14.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Schedule_35px.png"))); // NOI18N
        jButton14.setText("Logs History");
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconC/icons8_Schedule_45px_1.png"))); // NOI18N
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton14MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(count_log, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(count_log, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 242, 187));

        jPanel6.setBackground(new java.awt.Color(0, 161, 87));

        jButton15.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Team_35px.png"))); // NOI18N
        jButton15.setText("Employee");
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconC/icons8_Team_45px.png"))); // NOI18N
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton15MouseExited(evt);
            }
        });

        count_employee.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        count_employee.setForeground(new java.awt.Color(255, 255, 255));
        count_employee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(count_employee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(count_employee, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 11, 253, 187));

        jPanel7.setBackground(new java.awt.Color(247, 129, 26));

        jButton16.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Conference_35px.png"))); // NOI18N
        jButton16.setText("Position");
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconC/icons8_Conference_45px.png"))); // NOI18N
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton16MouseExited(evt);
            }
        });

        count_position.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        count_position.setForeground(new java.awt.Color(255, 255, 255));
        count_position.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(count_position, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(count_position, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 11, 242, 187));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(0, 153, 153));

        jButton17.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Payroll_35px.png"))); // NOI18N
        jButton17.setText("Account");
        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        jButton17.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconC/icons8_Payroll_45px.png"))); // NOI18N
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton17MouseExited(evt);
            }
        });

        count_account.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        count_account.setForeground(new java.awt.Color(255, 255, 255));
        count_account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(count_account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(count_account, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel22.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 242, 187));

        jPanel25.setBackground(new java.awt.Color(0, 186, 232));

        jButton19.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Stack_of_Money_35px.png"))); // NOI18N
        jButton19.setText("Cash");
        jButton19.setBorderPainted(false);
        jButton19.setContentAreaFilled(false);
        jButton19.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconC/icons8_Stack_of_Money_45px.png"))); // NOI18N
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton19MouseExited(evt);
            }
        });

        count_cash.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        count_cash.setForeground(new java.awt.Color(255, 255, 255));
        count_cash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(count_cash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(count_cash, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel22.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 11, 253, 187));

        jPanel26.setBackground(new java.awt.Color(103, 65, 114));

        jButton18.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_User_35px.png"))); // NOI18N
        jButton18.setText("User");
        jButton18.setBorderPainted(false);
        jButton18.setContentAreaFilled(false);
        jButton18.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconC/icons8_User_Account_45px.png"))); // NOI18N
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton18MouseExited(evt);
            }
        });

        count_user.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        count_user.setForeground(new java.awt.Color(255, 255, 255));
        count_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(count_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(count_user, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel22.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 11, 242, 187));

        javax.swing.GroupLayout PanelDashLayout = new javax.swing.GroupLayout(PanelDash);
        PanelDash.setLayout(PanelDashLayout);
        PanelDashLayout.setHorizontalGroup(
            PanelDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDashLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PanelDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        PanelDashLayout.setVerticalGroup(
            PanelDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDashLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CardPanel.add(PanelDash, "card2");

        Panel2.setBackground(new java.awt.Color(255, 255, 255));
        Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 83, 155), 2, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Add_Image_35px.png"))); // NOI18N
        jButton1.setText("Upload");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 176, 44));

        Panel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(858, 363, 198, 66));

        editpanel.setBackground(new java.awt.Color(0, 0, 0));
        editpanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 83, 155), 1, true));
        editpanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_edit.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Edit_File_35px.png"))); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.setBorderPainted(false);
        btn_edit.setContentAreaFilled(false);
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.setFocusPainted(false);
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editMouseExited(evt);
            }
        });
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        editpanel.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 231, 44));

        Panel2.add(editpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 528, 253, 66));

        addpanel.setBackground(new java.awt.Color(0, 0, 0));
        addpanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 83, 155), 2, true));
        addpanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_add.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Add_File_35px.png"))); // NOI18N
        btn_add.setText("ADD");
        btn_add.setBorderPainted(false);
        btn_add.setContentAreaFilled(false);
        btn_add.setFocusPainted(false);
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addMouseExited(evt);
            }
        });
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        addpanel.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 220, 44));

        Panel2.add(addpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 528, 242, 66));

        deletepanel.setBackground(new java.awt.Color(0, 0, 0));
        deletepanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 83, 155), 2, true));
        deletepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Trash_Can_35px.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        deletepanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 231, 44));

        Panel2.add(deletepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 605, 253, 66));

        aID.setEditable(false);
        aID.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel2.add(aID, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 55, 286, 33));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("FIRSTNAME:");
        Panel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 88, 286, 33));

        afirstname.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        afirstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                afirstnameFocusGained(evt);
            }
        });
        Panel2.add(afirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 121, 286, 33));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("MIDDLENAME");
        Panel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 154, 286, 33));

        amiddlename.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        amiddlename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amiddlenameFocusGained(evt);
            }
        });
        Panel2.add(amiddlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 187, 286, 33));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setText("ID");
        Panel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 22, 242, 33));

        jDateChooser1.setOpaque(false);
        jDateChooser1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDateChooser1FocusGained(evt);
            }
        });
        Panel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(858, 55, 198, 33));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setText("LASTNAME");
        Panel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 220, 286, 33));

        alastname.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        alastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alastnameFocusGained(evt);
            }
        });
        Panel2.add(alastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 253, 286, 33));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setText("ADDRESS");
        Panel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 286, 286, 33));

        aAddress.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        aAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aAddressFocusGained(evt);
            }
        });
        Panel2.add(aAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 319, 286, 33));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setText("GENDER:");
        Panel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 418, 242, 33));

        aContact.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        aContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aContactFocusGained(evt);
            }
        });
        aContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aContactKeyTyped(evt);
            }
        });
        Panel2.add(aContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 385, 286, 33));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setText("DATE OF BIRTH");
        Panel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(858, 22, 198, 33));

        Combo_Status.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Combo_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Single", "In Relationship", "Married", " " }));
        Combo_Status.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Combo_Status.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Combo_Status.setOpaque(false);
        Combo_Status.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Combo_StatusFocusGained(evt);
            }
        });
        Panel2.add(Combo_Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(858, 121, 198, 33));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setText("STATUS");
        Panel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(858, 88, 198, 33));

        jDesktopPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));

        jDesktopPane2.setLayer(label_uplod, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_uplod, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_uplod, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        Panel2.add(jDesktopPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(858, 165, 198, 187));

        clearPanel.setBackground(new java.awt.Color(0, 0, 0));
        clearPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 83, 155), 1, true));
        clearPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Erase_35px.png"))); // NOI18N
        jButton5.setText("Clear");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusPainted(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        clearPanel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 220, 44));

        Panel2.add(clearPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 605, 242, 66));

        jLabel38.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel38.setText("CONTACT:");
        Panel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 352, 286, 33));

        Combo_Gender.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Combo_Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Male", "Female", " " }));
        Combo_Gender.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Combo_Gender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Combo_Gender.setOpaque(false);
        Combo_Gender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Combo_GenderFocusGained(evt);
            }
        });
        Panel2.add(Combo_Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 451, 286, 33));

        jTable8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable8);

        Panel2.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 55, 517, 429));

        CardPanel.add(Panel2, "card3");

        Panel3.setBackground(new java.awt.Color(255, 255, 255));
        Panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Search_35px.png"))); // NOI18N
        jLabel2.setText("Find Employee ID");
        Panel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 253, 33));

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel3.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 627, 242, 33));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setText("ID");
        Panel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 66, 242, 33));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setText("FIRSTNAME");
        Panel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 132, 242, 33));

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel3.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 165, 242, 33));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setText("MIDDLENAME");
        Panel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 198, 242, 33));

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel3.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 231, 242, 33));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setText("LASTNAME");
        Panel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 264, 242, 33));

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel3.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 297, 242, 33));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setText("ADDRESS:");
        Panel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 330, 242, 33));

        jTextField12.setEditable(false);
        jTextField12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel3.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 363, 242, 33));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setText("CONTACT:");
        Panel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 396, 242, 33));

        jTextField13.setEditable(false);
        jTextField13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel3.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 429, 242, 33));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel20.setText("POSITION ID:");
        Panel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 264, 242, 33));

        position_id.setEditable(false);
        position_id.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel3.add(position_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 297, 242, 33));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setText("DATE OF BIRTH:");
        Panel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 462, 242, 33));

        jTextField15.setEditable(false);
        jTextField15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel3.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 495, 242, 33));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel22.setText("GENDER:");
        Panel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 594, 242, 33));

        jTextField16.setEditable(false);
        jTextField16.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Panel3.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 561, 242, 33));

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel23.setText("POSITION NAME:");
        Panel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 330, 242, 33));

        position_name.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        position_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                position_nameFocusGained(evt);
            }
        });
        Panel3.add(position_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 363, 242, 33));

        pdailyrate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        pdailyrate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pdailyrateFocusGained(evt);
            }
        });
        pdailyrate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pdailyrateKeyTyped(evt);
            }
        });
        Panel3.add(pdailyrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 429, 242, 33));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setText("DAILY RATE:");
        Panel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 396, 242, 33));

        pmonthlyrate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        pmonthlyrate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pmonthlyrateFocusGained(evt);
            }
        });
        pmonthlyrate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pmonthlyrateKeyTyped(evt);
            }
        });
        Panel3.add(pmonthlyrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 495, 242, 33));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel25.setText("MONTHLY RATE:");
        Panel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 462, 242, 33));

        pworkingdays.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        pworkingdays.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pworkingdaysFocusGained(evt);
            }
        });
        pworkingdays.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pworkingdaysKeyTyped(evt);
            }
        });
        Panel3.add(pworkingdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 561, 242, 33));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel26.setText("WORKING DAYS PER MONTH");
        Panel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 528, 242, 33));

        jTable2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        Panel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 33, 528, 561));

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 83, 155), 2, true));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Trash_Can_35px.png"))); // NOI18N
        jButton7.setText("Delete");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 253, 44));

        Panel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 605, 275, 66));

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 83, 155), 2, true));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Add_File_35px.png"))); // NOI18N
        jButton8.setText("Add");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 220, 44));

        Panel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 605, 242, 66));

        jDesktopPane3.setBackground(new java.awt.Color(51, 51, 51));
        jDesktopPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));

        jDesktopPane3.setLayer(Label_img, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_img, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_img, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        Panel3.add(jDesktopPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 66, 220, 187));

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 83, 155), 2, true));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Edit_File_35px.png"))); // NOI18N
        jButton9.setText("Edit");
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setFocusPainted(false);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 220, 44));

        Panel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 605, 242, 66));

        txtID.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        Panel3.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 99, 242, 33));

        jLabel39.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel39.setText("STATUS");
        Panel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 528, 242, 33));

        CardPanel.add(Panel3, "card4");

        Panel4.setBackground(new java.awt.Color(255, 255, 255));
        Panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel27.setText("Employee ID:");
        Panel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 77, 242, 33));

        emp_id.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        emp_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emp_idFocusGained(evt);
            }
        });
        emp_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emp_idKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emp_idKeyTyped(evt);
            }
        });
        Panel4.add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 110, 242, 33));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel11.setText("Add Information Payroll");
        Panel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 275, 33));

        e2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e2FocusGained(evt);
            }
        });
        e2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e2KeyTyped(evt);
            }
        });
        Panel4.add(e2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 176, 242, 33));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel28.setText("NUMBER OF DAYS WORK:");
        Panel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 143, 242, 33));

        e3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e3FocusGained(evt);
            }
        });
        e3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e3KeyTyped(evt);
            }
        });
        Panel4.add(e3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 242, 242, 33));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel29.setText("BONUS:");
        Panel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 209, 242, 33));

        e4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e4FocusGained(evt);
            }
        });
        e4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e4KeyTyped(evt);
            }
        });
        Panel4.add(e4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 308, 242, 33));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel30.setText("OVERTIME PAY");
        Panel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 275, 242, 33));

        e5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e5FocusGained(evt);
            }
        });
        e5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e5KeyTyped(evt);
            }
        });
        Panel4.add(e5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 374, 242, 33));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel31.setText("GROSS SALARY");
        Panel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 341, 242, 33));

        e6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e6FocusGained(evt);
            }
        });
        e6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e6KeyTyped(evt);
            }
        });
        Panel4.add(e6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 440, 242, 33));

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel32.setText("CASH ADVANCE");
        Panel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 407, 242, 33));

        e7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e7FocusGained(evt);
            }
        });
        Panel4.add(e7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 506, 242, 33));

        jLabel33.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel33.setText("LATE HOURS");
        Panel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 473, 242, 33));

        e8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e8FocusGained(evt);
            }
        });
        e8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e8KeyTyped(evt);
            }
        });
        Panel4.add(e8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 572, 242, 33));

        jLabel34.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel34.setText("ABSENT DAYS");
        Panel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 539, 242, 33));

        e9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e9FocusGained(evt);
            }
        });
        e9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e9KeyTyped(evt);
            }
        });
        Panel4.add(e9, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 242, 242, 33));

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel35.setText("SSS CONTRIBUTION:");
        Panel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 209, 242, 33));

        e10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e10FocusGained(evt);
            }
        });
        e10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e10KeyTyped(evt);
            }
        });
        Panel4.add(e10, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 308, 242, 33));

        jLabel36.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel36.setText("PHILHEALTH");
        Panel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 275, 242, 33));

        e11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e11FocusGained(evt);
            }
        });
        e11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e11KeyTyped(evt);
            }
        });
        Panel4.add(e11, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 374, 242, 33));

        jLabel37.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel37.setText("TOTAL DEDUCTION:");
        Panel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 341, 242, 33));

        jLabel40.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel40.setText("ACCOUNT ID:");
        Panel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 407, 242, 33));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray)), "DEDUCTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        total_without_deduction.setEditable(false);
        total_without_deduction.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        total_without_deduction.setForeground(new java.awt.Color(255, 255, 255));
        total_without_deduction.setText("0");
        total_without_deduction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL WITHOUT DEDUCTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        total_without_deduction.setOpaque(false);
        jPanel12.add(total_without_deduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 198, 242, 55));

        gross_salary.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        gross_salary.setForeground(new java.awt.Color(255, 255, 255));
        gross_salary.setText("0");
        gross_salary.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GROSS SALARY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        gross_salary.setOpaque(false);
        jPanel12.add(gross_salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 33, 242, 55));

        advancepay.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        advancepay.setForeground(new java.awt.Color(255, 255, 255));
        advancepay.setText("0");
        advancepay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADVANCE PAY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        advancepay.setOpaque(false);
        jPanel12.add(advancepay, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 88, 242, 55));

        total_salary.setEditable(false);
        total_salary.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        total_salary.setForeground(new java.awt.Color(255, 255, 255));
        total_salary.setText("0");
        total_salary.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL SALARY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        total_salary.setOpaque(false);
        jPanel12.add(total_salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 198, 242, 55));

        overtimepay.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        overtimepay.setForeground(new java.awt.Color(255, 255, 255));
        overtimepay.setText("0");
        overtimepay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OVERTIME PAY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        overtimepay.setOpaque(false);
        jPanel12.add(overtimepay, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 143, 242, 55));

        pag_ibigtax.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        pag_ibigtax.setForeground(new java.awt.Color(255, 255, 255));
        pag_ibigtax.setText("0");
        pag_ibigtax.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAG-IBIG TAX", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pag_ibigtax.setOpaque(false);
        jPanel12.add(pag_ibigtax, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 33, 242, 55));

        SSStax.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        SSStax.setForeground(new java.awt.Color(255, 255, 255));
        SSStax.setText("0");
        SSStax.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SSS TAX", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        SSStax.setOpaque(false);
        jPanel12.add(SSStax, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 88, 242, 55));

        jPanel16.setBackground(new java.awt.Color(0, 0, 0));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Erase_35px.png"))); // NOI18N
        jButton6.setText("Clear");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusPainted(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 220, 33));

        jPanel12.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 264, 242, 55));

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Calculator_35px.png"))); // NOI18N
        jButton11.setText("Convert");
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setFocusPainted(false);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 220, 33));

        jPanel12.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 264, 242, 55));

        philhealth.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        philhealth.setForeground(new java.awt.Color(255, 255, 255));
        philhealth.setText("0");
        philhealth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PHIL-HEALTH TAX", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        philhealth.setOpaque(false);
        jPanel12.add(philhealth, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 143, 242, 55));

        jTable6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable6.getTableHeader().setReorderingAllowed(false);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jPanel12.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 330, 506, 286));

        Panel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 22, 550, 638));

        e12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        e12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e12FocusGained(evt);
            }
        });
        Panel4.add(e12, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 440, 242, 33));

        jPanel17.setBackground(new java.awt.Color(0, 0, 0));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 83, 155), 2, true));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Add_File_35px.png"))); // NOI18N
        jButton10.setText("Add");
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setFocusPainted(false);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 220, 44));

        Panel4.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 484, 242, 66));

        eposition_name.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        eposition_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                eposition_nameFocusGained(evt);
            }
        });
        Panel4.add(eposition_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 110, 242, 33));

        jLabel45.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel45.setText("Position Name:");
        Panel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 77, 242, 33));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconS/icons8_Trash_Can_35px.png"))); // NOI18N
        jButton13.setText("DELETE");
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.setFocusPainted(false);
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton13MouseExited(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 220, 44));

        Panel4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 561, 242, 66));

        CardPanel.add(Panel4, "card5");

        Panel5.setBackground(new java.awt.Color(255, 255, 255));
        Panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel41.setText("Information Employee");
        Panel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 220, 33));

        PanelInfo.setLayout(new java.awt.CardLayout());

        Panel11.setBackground(new java.awt.Color(255, 255, 255));
        Panel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        Panel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        Panel11.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 1034, 506));

        jLabel43.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel43.setText("Employee List");
        Panel11.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 209, 66));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("PRINT");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 242, 44));

        Panel11.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 11, 264, 66));

        PanelInfo.add(Panel11, "card2");

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);

        jPanel20.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 89, 1023, 506));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel13.setText("Position List");
        jPanel20.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, 242, 55));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("PRINT");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 231, 44));

        jPanel20.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 11, 253, 66));

        PanelInfo.add(jPanel20, "card3");

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable5.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable5);

        jPanel21.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 88, 1012, 506));

        jLabel42.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel42.setText("Account List");
        jPanel21.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 22, 242, 55));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("PRINT");
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setFocusPainted(false);
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 231, 44));

        jPanel21.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 11, 253, 66));

        PanelInfo.add(jPanel21, "card4");

        Panel5.add(PanelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 55, 1056, 616));

        jComboBox3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Employee List", "Position List", "Account List" }));
        jComboBox3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox3.setOpaque(false);
        jComboBox3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox3FocusGained(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        Panel5.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 11, 242, 33));

        CardPanel.add(Panel5, "card6");

        Panel6.setBackground(new java.awt.Color(255, 255, 255));
        Panel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel44.setText("Logs History");
        jLabel44.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panel6.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 231, 55));

        jTable7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable7.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable7);

        Panel6.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 77, 1056, 594));

        CardPanel.add(Panel6, "card7");

        jPanel1.add(CardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 55, 1089, 682));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
      System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void MinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinimizeActionPerformed
      this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MinimizeActionPerformed

    private void BTN1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MousePressed
    setColor(BTN1);
    PN1.setOpaque(true);
    resetColor(new JPanel[]{BTN2,BTN3,BTN4,BTN5,BTN6,BTN7},new JPanel[]{PN2,PN3,PN4,PN5,PN6,PN7});
    }//GEN-LAST:event_BTN1MousePressed

    private void BTN2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MousePressed
    setColor(BTN2);
    PN2.setOpaque(true);
    resetColor(new JPanel[]{BTN1,BTN3,BTN4,BTN5,BTN6,BTN7},new JPanel[]{PN1,PN3,PN4,PN5,PN6,PN7});
    }//GEN-LAST:event_BTN2MousePressed

    private void BTN3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MousePressed
    setColor(BTN3);
    PN3.setOpaque(true);
    resetColor(new JPanel[]{BTN1,BTN2,BTN4,BTN5,BTN6,BTN7},new JPanel[]{PN1,PN2,PN4,PN5,PN6,PN7});  
    }//GEN-LAST:event_BTN3MousePressed

    private void BTN4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MousePressed
    setColor(BTN4);
    PN4.setOpaque(true);
    resetColor(new JPanel[]{BTN1,BTN2,BTN3,BTN5,BTN6,BTN7},new JPanel[]{PN1,PN2,PN3,PN5,PN6,PN7});   
    }//GEN-LAST:event_BTN4MousePressed

    private void BTN5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MousePressed
    setColor(BTN5);
    PN5.setOpaque(true);
    resetColor(new JPanel[]{BTN1,BTN2,BTN3,BTN4,BTN6,BTN7},new JPanel[]{PN1,PN2,PN3,PN4,PN6,PN7});     
    }//GEN-LAST:event_BTN5MousePressed

    private void BTN6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN6MousePressed
    setColor(BTN6);
    PN6.setOpaque(true);
    resetColor(new JPanel[]{BTN1,BTN2,BTN3,BTN4,BTN5,BTN7},new JPanel[]{PN1,PN2,PN3,PN4,PN5,PN7}); 
    }//GEN-LAST:event_BTN6MousePressed

    private void BTN7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN7MousePressed
    setColor(BTN7);
    PN7.setOpaque(true);
    resetColor(new JPanel[]{BTN1,BTN2,BTN3,BTN4,BTN5,BTN6},new JPanel[]{PN1,PN2,PN3,PN4,PN5,PN6}); 
    }//GEN-LAST:event_BTN7MousePressed

    private void BTN1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MouseEntered
        setFont(Label1);
    }//GEN-LAST:event_BTN1MouseEntered

    private void BTN1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MouseExited
        resetFont(Label1);
    }//GEN-LAST:event_BTN1MouseExited

    private void BTN2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MouseEntered
        setFont(Label2);
    }//GEN-LAST:event_BTN2MouseEntered

    private void BTN2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MouseExited
        resetFont(Label2);
    }//GEN-LAST:event_BTN2MouseExited

    private void BTN3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MouseEntered
        setFont(Label3);
    }//GEN-LAST:event_BTN3MouseEntered

    private void BTN3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MouseExited
        resetFont(Label3);
    }//GEN-LAST:event_BTN3MouseExited

    private void BTN4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MouseEntered
        setFont(Label4);
    }//GEN-LAST:event_BTN4MouseEntered

    private void BTN4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MouseExited
        resetFont(Label4);
    }//GEN-LAST:event_BTN4MouseExited

    private void BTN5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MouseEntered
        setFont(Label5);
    }//GEN-LAST:event_BTN5MouseEntered

    private void BTN5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MouseExited
        resetFont(Label5);
    }//GEN-LAST:event_BTN5MouseExited

    private void BTN6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN6MouseEntered
        setFont(Label6);
    }//GEN-LAST:event_BTN6MouseEntered

    private void BTN6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN6MouseExited
        resetFont(Label6);
    }//GEN-LAST:event_BTN6MouseExited

    private void BTN7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN7MouseEntered
        Label7.setFont(new java.awt.Font("Century Gothic BOLD", 0, 16)); // NOI18N
        Label7.setForeground(Color.RED);
    }//GEN-LAST:event_BTN7MouseEntered

    private void BTN7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN7MouseExited
        resetFont(Label7);
    }//GEN-LAST:event_BTN7MouseExited

    private void BTN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MouseClicked
    CardPanel.removeAll();
    CardPanel.repaint();
    CardPanel.revalidate();
    CardPanel.add(PanelDash);
    CardPanel.repaint();
    CardPanel.revalidate();
    }//GEN-LAST:event_BTN1MouseClicked

    private void BTN2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MouseClicked
    CardPanel.removeAll();
    CardPanel.repaint();
    CardPanel.revalidate();
    CardPanel.add(Panel2);
    CardPanel.repaint();
    CardPanel.revalidate();
    }//GEN-LAST:event_BTN2MouseClicked

    private void BTN3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MouseClicked
    CardPanel.removeAll();
    CardPanel.repaint();
    CardPanel.revalidate();
    CardPanel.add(Panel3);
    CardPanel.repaint();
    CardPanel.revalidate();
    }//GEN-LAST:event_BTN3MouseClicked

    private void BTN4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MouseClicked
    CardPanel.removeAll();
    CardPanel.repaint();
    CardPanel.revalidate();
    CardPanel.add(Panel4);
    CardPanel.repaint();
    CardPanel.revalidate();
    }//GEN-LAST:event_BTN4MouseClicked

    private void BTN5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MouseClicked
    CardPanel.removeAll();
    CardPanel.repaint();
    CardPanel.revalidate();
    CardPanel.add(Panel5);
    CardPanel.repaint();
    CardPanel.revalidate();
    }//GEN-LAST:event_BTN5MouseClicked

    private void BTN6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN6MouseClicked
    CardPanel.removeAll();
    CardPanel.repaint();
    CardPanel.revalidate();
    CardPanel.add(Panel6);
    CardPanel.repaint();
    CardPanel.revalidate();
    }//GEN-LAST:event_BTN6MouseClicked

    private void BTN7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN7MouseClicked
        int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure? \nYou want to logout?","Warning!", JOptionPane.YES_NO_OPTION);
        if(YesOrNo == 1){
// if click no
       }
        if(YesOrNo == 0){
// if click yes
	JOptionPane.showMessageDialog(null, "Thank You For Using My System!");
                
        this.setVisible(false);
	Login L = new Login();
	L.setVisible(true);
        }
    }//GEN-LAST:event_BTN7MouseClicked

    private void afirstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_afirstnameFocusGained
            setTextfield(afirstname);
        resetTextfield(amiddlename);
        resetTextfield(alastname);
        resetTextfield(aAddress);
        resetTextfield(aContact);
        resetTextfield(((JTextField)jDateChooser1.getDateEditor().getUiComponent()));
        Combo_Gender.setBackground(new java.awt.Color(255, 255, 255));
        Combo_Status.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_afirstnameFocusGained

    private void amiddlenameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amiddlenameFocusGained
        resetTextfield(afirstname);
            setTextfield(amiddlename);
        resetTextfield(alastname);
        resetTextfield(aAddress);
        resetTextfield(aContact);
        resetTextfield(((JTextField)jDateChooser1.getDateEditor().getUiComponent()));
        Combo_Gender.setBackground(new java.awt.Color(255, 255, 255));
        Combo_Status.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_amiddlenameFocusGained

    private void alastnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alastnameFocusGained
        resetTextfield(afirstname);
        resetTextfield(amiddlename);
            setTextfield(alastname);
        resetTextfield(aAddress);
        resetTextfield(aContact);
        resetTextfield(((JTextField)jDateChooser1.getDateEditor().getUiComponent()));
        Combo_Gender.setBackground(new java.awt.Color(255, 255, 255));
        Combo_Status.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_alastnameFocusGained

    private void aAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aAddressFocusGained
        resetTextfield(afirstname);
        resetTextfield(amiddlename);
        resetTextfield(alastname);
            setTextfield(aAddress);
        resetTextfield(aContact);
        resetTextfield(((JTextField)jDateChooser1.getDateEditor().getUiComponent()));
        Combo_Gender.setBackground(new java.awt.Color(255, 255, 255));
        Combo_Status.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_aAddressFocusGained

    private void aContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aContactFocusGained
        resetTextfield(afirstname);
        resetTextfield(amiddlename);
        resetTextfield(alastname);
        resetTextfield(aAddress);
            setTextfield(aContact);
        resetTextfield(((JTextField)jDateChooser1.getDateEditor().getUiComponent()));
        Combo_Gender.setBackground(new java.awt.Color(255, 255, 255));
        Combo_Status.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_aContactFocusGained

    private void Combo_GenderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Combo_GenderFocusGained
        resetTextfield(afirstname);
        resetTextfield(amiddlename);
        resetTextfield(alastname);
        resetTextfield(aAddress);
        resetTextfield(aContact);
        resetTextfield(((JTextField)jDateChooser1.getDateEditor().getUiComponent()));
        Combo_Gender.setBackground(new java.awt.Color(255, 255, 201));
        Combo_Status.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_Combo_GenderFocusGained

    private void jDateChooser1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooser1FocusGained
        resetTextfield(afirstname);
        resetTextfield(amiddlename);
        resetTextfield(alastname);
        resetTextfield(aAddress);
        resetTextfield(aContact);
        setTextfield(((JTextField)jDateChooser1.getDateEditor().getUiComponent()));
        Combo_Gender.setBackground(new java.awt.Color(255, 255, 255));
        Combo_Status.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jDateChooser1FocusGained

    private void Combo_StatusFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Combo_StatusFocusGained
        resetTextfield(afirstname);
        resetTextfield(amiddlename);
        resetTextfield(alastname);
        resetTextfield(aAddress);
        resetTextfield(aContact);
        resetTextfield(((JTextField)jDateChooser1.getDateEditor().getUiComponent()));
        Combo_Gender.setBackground(new java.awt.Color(255, 255, 255));
        Combo_Status.setBackground(new java.awt.Color(255, 255, 201));
    }//GEN-LAST:event_Combo_StatusFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        filename =f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(label_uplod.getWidth(), label_uplod.getHeight(), Image.SCALE_DEFAULT));
        label_uplod.setIcon(imageIcon);
        try {

            File image = new File(filename);
            FileInputStream fis = new FileInputStream (image);
            ByteArrayOutputStream bos= new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf))!=-1; ){
                bos.write(buf,0,readNum);
            }
            person_image=bos.toByteArray();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
       jButton1.setForeground(Color.WHITE);
       jPanel3.setBackground(new Color(52, 73, 94));
       jPanel3.setBorder(new LineBorder(new Color(58,83,155),1,true));
       jButton1.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
       jButton1.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jButton1.setForeground(new Color(255,255,255));
       jPanel3.setBackground(Color.BLACK);   
       jPanel3.setBorder(new LineBorder(Color.WHITE, 1,true));     
    }//GEN-LAST:event_jButton1MouseExited

    private void btn_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseEntered
       btn_add.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       btn_add.setForeground(Color.WHITE);
       addpanel.setBackground(new Color(58,83,155));
       addpanel.setBorder(new LineBorder(new Color(58,83,155),1,true));
    }//GEN-LAST:event_btn_addMouseEntered

    private void btn_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseExited
       btn_add.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       btn_add.setForeground(new Color(255,255,255));
       addpanel.setBackground(Color.BLACK);   
       addpanel.setBorder(new LineBorder(Color.WHITE, 1,true));
    }//GEN-LAST:event_btn_addMouseExited

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
      
 int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
    if(p==0){
            
        if(afirstname.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Firstname cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);    
        }else if(amiddlename.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Middlename cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);   
        }else if(alastname.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Lastname cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);
        }else if(aAddress.getText().isEmpty())
        { 
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Address cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);   
        }else if(aContact.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Contact cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);    
        }else if(Combo_Gender.getSelectedItem()=="-Select-" ||Combo_Gender.getSelectedItem().equals("-Select-"))
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "You must select a valid type to proceed!", "WARNING!", JOptionPane.WARNING_MESSAGE);      
        }else if(((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().isEmpty())
        {    
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "You must select date a valid type to proceed!", "WARNING!", JOptionPane.WARNING_MESSAGE);         
        }else if(Combo_Status.getSelectedItem()=="-Select-"||Combo_Status.getSelectedItem().equals("-Select-"))
        {    
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "You must select a valid type to proceed!", "WARNING!", JOptionPane.WARNING_MESSAGE);          
        }else{    
            
            
        try {
            String sql="insert into tblemployee(firstname, middlename, lastname, address, contact, gender, "
                    + "date_of_birth, status, picture)"
                    + "values(?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,afirstname.getText());
            pst.setString(2,amiddlename.getText());
            pst.setString(3,alastname.getText());
            pst.setString(4,aAddress.getText());
            pst.setString(5,aContact.getText());
            pst.setString(6,Combo_Gender.getSelectedItem().toString());
            pst.setString(7,((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
            pst.setString(8,Combo_Status.getSelectedItem().toString());
            pst.setBytes(9,person_image);
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Data Saved Successfully");
            showemployee();
            clear();
            showdata1();
            countemployee();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
            }
    }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseEntered
       btn_edit.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       btn_edit.setForeground(Color.WHITE);
       editpanel.setBackground(new Color(30, 130, 76));
       editpanel.setBorder(new LineBorder(new Color(58,83,155),1,true));
    }//GEN-LAST:event_btn_editMouseEntered

    private void btn_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseExited
       btn_edit.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       btn_edit.setForeground(new Color(255,255,255));
       editpanel.setBackground(Color.BLACK);   
       editpanel.setBorder(new LineBorder(Color.WHITE, 1,true));
    }//GEN-LAST:event_btn_editMouseExited

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
    int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
    if(p==0){ 
            
              if(afirstname.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Firstname cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);    
        }else if(amiddlename.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Middlename cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);   
        }else if(alastname.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Lastname cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);
        }else if(aAddress.getText().isEmpty())
        { 
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Address cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);   
        }else if(aContact.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Contact cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);    
        }else if(Combo_Gender.getSelectedItem()=="-Select-" ||Combo_Gender.getSelectedItem().equals("-Select-"))
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "You must select a valid type to proceed!", "WARNING!", JOptionPane.WARNING_MESSAGE);      
        }else if(((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().isEmpty())
        {    
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "You must select date a valid type to proceed!", "WARNING!", JOptionPane.WARNING_MESSAGE);         
        }else if(Combo_Status.getSelectedItem()=="-Select-"||Combo_Status.getSelectedItem().equals("-Select-"))
        {    
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "You must select a valid type to proceed!", "WARNING!", JOptionPane.WARNING_MESSAGE);          
        }else{   
                
        try {
            int row=jTable8.getSelectedRow();
            String value=(jTable8.getModel().getValueAt(row, 0).toString());
            String sql="update tblemployee set id=?, firstname=?, middlename=?, lastname=?, address=?, contact=?, "
                    + "gender=?, date_of_birth=?, status=?, picture=? where id="+value;
            pst=conn.prepareStatement(sql);
            pst.setString(1,aID.getText());
            pst.setString(2,afirstname.getText());
            pst.setString(3,amiddlename.getText());
            pst.setString(4,alastname.getText());
            pst.setString(5,aAddress.getText());
            pst.setString(6,aContact.getText());
            pst.setString(7,Combo_Gender.getSelectedItem().toString());
            pst.setString(8,((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
            pst.setString(9,Combo_Status.getSelectedItem().toString());
            pst.setBytes(10,person_image);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successfully");
            showemployee();
            clear();
            showdata1();
            countemployee();
             
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
       }
    }
    }//GEN-LAST:event_btn_editActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
       jButton5.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jButton5.setForeground(Color.WHITE);
       clearPanel.setBackground(new Color(149, 165, 166));
       clearPanel.setBorder(new LineBorder(new Color(58,83,155),1,true));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
       jButton5.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jButton5.setForeground(new Color(255,255,255));
       clearPanel.setBackground(Color.BLACK);   
       clearPanel.setBorder(new LineBorder(Color.WHITE, 1,true));
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void aContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aContactKeyTyped
        if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_aContactKeyTyped

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
       jButton4.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jButton4.setForeground(Color.WHITE);
       deletepanel.setBackground(new Color(207, 0, 15));
       deletepanel.setBorder(new LineBorder(new Color(58,83,155),1,true));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
       jButton4.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jButton4.setForeground(new Color(255,255,255));
       deletepanel.setBackground(Color.BLACK);   
       deletepanel.setBorder(new LineBorder(Color.WHITE, 1,true));
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p==0){ 
            
            
                   if(afirstname.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Firstname cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);    
        }else if(amiddlename.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Middlename cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);   
        }else if(alastname.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Lastname cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);
        }else if(aAddress.getText().isEmpty())
        { 
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Address cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);   
        }else if(aContact.getText().isEmpty())
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(rootPane,"Contact cannot be empty","Warning!",JOptionPane.WARNING_MESSAGE);    
        }else if(Combo_Gender.getSelectedItem()=="-Select-" ||Combo_Gender.getSelectedItem().equals("-Select-"))
        {
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "You must select a valid type to proceed!", "WARNING!", JOptionPane.WARNING_MESSAGE);      
        }else if(((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().isEmpty())
        {    
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "You must select date a valid type to proceed!", "WARNING!", JOptionPane.WARNING_MESSAGE);         
        }else if(Combo_Status.getSelectedItem()=="-Select-"||Combo_Status.getSelectedItem().equals("-Select-"))
        {    
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "You must select a valid type to proceed!", "WARNING!", JOptionPane.WARNING_MESSAGE);          
        }else{   
              
            
        try {
            String sql="delete from tblemployee where id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,aID.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Delete Data Successfully");
            
            showemployee();
            clear();
            showdata1();
            countemployee();
            
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
     
        try {
            String sql="select * from tblemployee where id=?";
            pst=conn.prepareCall(sql);
            pst.setString(1,txtID.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                jTextField9.setText(rs.getString("firstname"));
                jTextField10.setText(rs.getString("middlename"));
                jTextField11.setText(rs.getString("lastname"));
                jTextField12.setText(rs.getString("address"));
                jTextField13.setText(rs.getString("contact"));
                jTextField15.setText(rs.getString("date_of_birth"));
                jTextField16.setText(rs.getString("status"));
                jTextField8.setText(rs.getString("gender"));
                position_id.setText(rs.getString("id"));
    byte[] img = rs.getBytes("picture");
    ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(Label_img.getWidth(), Label_img.getHeight(), Image.SCALE_SMOOTH));
    Label_img.setIcon(imageIcon);            
                  
                txtID.setToolTipText("Enter your ID");
            }else{
              
                jTextField9.setText("");
                jTextField10.setText("");
                jTextField11.setText("");
                jTextField12.setText("");
                jTextField13.setText("");
                jTextField15.setText("");
                jTextField16.setText("");
                jTextField8.setText("");
                Label_img.setIcon(null);
            
                position_id.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtIDKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          for (double i = 0.0; i <= 1.0; i = i +0.1) {
            String  val = i + " ";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){              
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void pdailyrateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pdailyrateKeyTyped
          if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pdailyrateKeyTyped

    private void pmonthlyrateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pmonthlyrateKeyTyped
         if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pmonthlyrateKeyTyped

    private void pworkingdaysKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pworkingdaysKeyTyped
           if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pworkingdaysKeyTyped

    private void position_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_position_nameFocusGained
        setTextfield(position_name);
        resetTextfield(pdailyrate);
        resetTextfield(pmonthlyrate);
        resetTextfield(pworkingdays);
    }//GEN-LAST:event_position_nameFocusGained

    private void pdailyrateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pdailyrateFocusGained
        resetTextfield(position_name);
            setTextfield(pdailyrate);
        resetTextfield(pmonthlyrate);
        resetTextfield(pworkingdays);
    }//GEN-LAST:event_pdailyrateFocusGained

    private void pmonthlyrateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pmonthlyrateFocusGained
       resetTextfield(position_name);
       resetTextfield(pdailyrate);
            setTextfield(pmonthlyrate);
        resetTextfield(pworkingdays);
    }//GEN-LAST:event_pmonthlyrateFocusGained

    private void pworkingdaysFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pworkingdaysFocusGained
       resetTextfield(position_name);
       resetTextfield(pdailyrate);
       resetTextfield(pmonthlyrate);
       setTextfield(pworkingdays);
    }//GEN-LAST:event_pworkingdaysFocusGained

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
       jButton8.setForeground(Color.WHITE);
       jButton8.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel14.setBackground(new Color(58,83,155));
       jPanel14.setBorder(new LineBorder(new Color(58,83,155),1,true));
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
       jButton8.setForeground(new Color(255,255,255));
       jButton8.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel14.setBackground(Color.BLACK);   
       jPanel14.setBorder(new LineBorder(Color.WHITE, 1,true));
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p==0){
            
            
        try {
            String sql="insert into tblposition(position_id, position_name, daily_rate, monthly_rate, working_days_per_month)"
                    + "values(?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,position_id.getText());
            pst.setString(2,position_name.getText());
            pst.setString(3,pdailyrate.getText());
            pst.setString(4,pmonthlyrate.getText());
            pst.setString(5,pworkingdays.getText());               
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Data Saved Successfully");
            showposition();
            clear();
            showdata2();
            countposition();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
            }        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
          try {
            int row = jTable2.getSelectedRow();
            String Table_click=(jTable2.getModel().getValueAt(row, 0).toString());
            String sql = "select * from tblposition where position_id='"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                position_id.setText(rs.getString("position_id"));
                position_name.setText(rs.getString("position_name"));
                pdailyrate.setText(rs.getString("daily_rate"));
                pmonthlyrate.setText(rs.getString("monthly_rate"));
                pworkingdays.setText(rs.getString("working_days_per_month"));              
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
       jButton9.setForeground(Color.WHITE);
       jButton9.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel15.setBackground(new Color(30, 130, 76));
       jPanel15.setBorder(new LineBorder(new Color(58,83,155),1,true));
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
       jButton9.setForeground(new Color(255,255,255));
       jButton9.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel15.setBackground(Color.BLACK);   
       jPanel15.setBorder(new LineBorder(Color.WHITE, 1,true));
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
    if(p==0){ 
            
            
                
        try {
            int row=jTable2.getSelectedRow();
            String values=(jTable2.getModel().getValueAt(row, 0).toString());
            String sql="update tblposition set position_id=?, position_name=?, daily_rate=?, monthly_rate=?,"
                    + "working_days_per_month=? where position_id="+values;
            pst=conn.prepareStatement(sql);
            pst.setString(1,position_id.getText());
            pst.setString(2,position_name.getText());
            pst.setString(3,pdailyrate.getText());
            pst.setString(4,pmonthlyrate.getText());
            pst.setString(5,pworkingdays.getText());        
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successfully");
            showposition();
            clear();
            showdata2();
            countposition();
            
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
       jButton7.setForeground(Color.WHITE);
       jButton7.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel13.setBackground(new Color(217, 30, 24));
       jPanel13.setBorder(new LineBorder(new Color(58,83,155),1,true));
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
       jButton7.setForeground(new Color(255,255,255));
       jButton7.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel13.setBackground(Color.BLACK);   
       jPanel13.setBorder(new LineBorder(Color.WHITE, 1,true));
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
           int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p==0){ 
            
        try {
            String sql="delete from tblposition where position_id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,position_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Delete Data Successfully");
            
            showposition();
            clear();
            showdata2();
            countposition();
            
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void emp_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emp_idFocusGained
        setTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);       
    }//GEN-LAST:event_emp_idFocusGained

    private void emp_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emp_idKeyReleased
         try {
            String sql="select * from tblposition where position_id=?";
            pst=conn.prepareCall(sql);
            pst.setString(1,emp_id.getText());
            rs=pst.executeQuery();
            if(rs.next()){            
                eposition_name.setText(rs.getString("position_name"));
                emp_id.setToolTipText("Enter your ID");
            }else{              
                eposition_name.setText("");                                                      
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_emp_idKeyReleased

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
            if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
         
        }
    }//GEN-LAST:event_txtIDKeyTyped

    private void e2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e2FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        setTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e2FocusGained

    private void eposition_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eposition_nameFocusGained
        resetTextfield(emp_id);
        setTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_eposition_nameFocusGained

    private void e3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e3FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        setTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e3FocusGained

    private void e4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e4FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        setTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e4FocusGained

    private void e5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e5FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        setTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e5FocusGained

    private void e6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e6FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        setTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e6FocusGained

    private void e7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e7FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        setTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e7FocusGained

    private void e8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e8FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        setTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e8FocusGained

    private void e9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e9FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        setTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e9FocusGained

    private void e10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e10FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        setTextfield(e10);
        resetTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e10FocusGained

    private void e11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e11FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        setTextfield(e11);
        resetTextfield(e12);  
    }//GEN-LAST:event_e11FocusGained

    private void e12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e12FocusGained
        resetTextfield(emp_id);
        resetTextfield(eposition_name);
        resetTextfield(e2);
        resetTextfield(e3);
        resetTextfield(e4);
        resetTextfield(e5);
        resetTextfield(e6);
        resetTextfield(e7);
        resetTextfield(e8);
        resetTextfield(e9);
        resetTextfield(e10);
        resetTextfield(e11);
        setTextfield(e12);  
    }//GEN-LAST:event_e12FocusGained

    private void emp_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emp_idKeyTyped
            if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_emp_idKeyTyped

    private void e3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e3KeyTyped
            if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_e3KeyTyped

    private void e2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e2KeyTyped
            if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_e2KeyTyped

    private void e4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e4KeyTyped
           if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }       
    }//GEN-LAST:event_e4KeyTyped

    private void e5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e5KeyTyped
           if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_e5KeyTyped

    private void e6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e6KeyTyped
           if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_e6KeyTyped

    private void e8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e8KeyTyped
          if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_e8KeyTyped

    private void e9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e9KeyTyped
           if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_e9KeyTyped

    private void e10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e10KeyTyped
           if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_e10KeyTyped

    private void e11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e11KeyTyped
            if (!Character.isDigit(evt.getKeyChar())){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Numbers Only!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_e11KeyTyped

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
       jButton1.setForeground(Color.WHITE);
       jButton1.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel17.setBackground(new Color(83, 51, 237));
       jPanel17.setBorder(new LineBorder(new Color(58,83,155),1,true));
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
       jButton1.setForeground(new Color(255,255,255));
       jButton1.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel17.setBackground(Color.BLACK);   
       jPanel17.setBorder(new LineBorder(Color.WHITE, 1,true));
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p==0){
            
            
        try {
            String sql="insert into tblaccount(employee_id, positionname, number_of_days_work, bonus, overtime_pay,"
                    + "gross_salary, cash_advance, late_hours, absent_days, sss_contribute, philhealth, total_deduction, account_id)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,emp_id.getText());
            pst.setString(2,eposition_name.getText());
            pst.setString(3,e2.getText());
            pst.setString(4,e3.getText());
            pst.setString(5,e4.getText());
            pst.setString(6,e5.getText());   
            pst.setString(7,e6.getText());
            pst.setString(8,e7.getText());
            pst.setString(9,e8.getText());
            pst.setString(10,e9.getText());
            pst.setString(11,e10.getText());
            pst.setString(12,e11.getText());
            pst.setString(13,e12.getText()); 
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Data Saved Successfully");
            showaccount();
            clear();           
            showdata3();
            countaccount();
            countcash();
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
            }    
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
       jButton6.setForeground(Color.WHITE);
       jButton6.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel16.setBackground(new Color(145, 180, 150));
       jPanel16.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
       jButton6.setForeground(new Color(255,255,255));
       jButton6.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel16.setBackground(Color.BLACK);   
       jPanel16.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    JOptionPane.showMessageDialog(null,"Warning!\nThis will clear the fields!","Warning Message",JOptionPane.WARNING_MESSAGE);
         
    gross_salary.setText("0");
    advancepay.setText("0");
    overtimepay.setText("0");
    total_without_deduction.setText("0");
    pag_ibigtax.setText("0");
    SSStax.setText("0");
    philhealth.setText("0");
    total_salary.setText("0");
             
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
       jButton11.setForeground(Color.WHITE);
       jButton11.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel18.setBackground(new Color(0,102,102));
       jPanel18.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
       jButton11.setForeground(new Color(255,255,255));
       jButton11.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel18.setBackground(Color.BLACK);   
       jPanel18.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       
    double gros;
    double advance;
    double otime;
    double pag_i;
    double ss;
    double phil;
    double tot;
        
       double totwo;
        

        try{
                            
        gros = Double.parseDouble(gross_salary.getText());
        advance = Double.parseDouble(advancepay.getText());
        otime = Double.parseDouble(overtimepay.getText());

        totwo = (gros + otime)-advance;
            if(totwo>0){
                phil = 100.0;
                pag_i = (totwo*00.02);
                ss = (totwo*00.05);
            }else{
                phil = 0;
                pag_i = 0;
                ss = 0;               
            }
        
        tot = (totwo - (pag_i + phil + ss));
        
        String pagibigt = String.format("%.2f",pag_i);
        pag_ibigtax.setText(pagibigt);
        String ssst = String.format("%.2f",ss);
        SSStax.setText(ssst);
        String philt = String.format("%.2f", phil);
        philhealth.setText(philt);
        String totalt = String.format("%.2f", tot);
        total_salary.setText(totalt);
        String totduc = String.format("%.2f", totwo);
        total_without_deduction.setText(totduc);
        e11.setText(totduc);
        }catch (NumberFormatException numErr) {
            
            JOptionPane.showMessageDialog(null,"Only input numerical figures!","Warning Message",JOptionPane.WARNING_MESSAGE);
            
        
        }
    
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
       jButton2.setForeground(Color.WHITE);
       jButton2.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel8.setBackground(new Color(189, 195, 199));
       jPanel8.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
       jButton2.setForeground(new Color(255,255,255));
       jButton2.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel8.setBackground(Color.BLACK);   
       jPanel8.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MessageFormat header = new MessageFormat("Report");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try{
            jTable6.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, null, true, null);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox3FocusGained
        jComboBox3.setBackground(new Color(255, 255, 201));
    }//GEN-LAST:event_jComboBox3FocusGained
int ComboBox;
    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        ComboBox=jComboBox3.getSelectedIndex();
        
        if(ComboBox==1){
        //removing panel
        PanelInfo.removeAll();
        PanelInfo.repaint();
        PanelInfo.revalidate();        
        //adding panel
        PanelInfo.add(Panel11);
        PanelInfo.repaint();
        PanelInfo.revalidate();   
        
        }else if(ComboBox==2){
        //removing panel
        PanelInfo.removeAll();
        PanelInfo.repaint();
        PanelInfo.revalidate();        
        //adding panel
        PanelInfo.add(jPanel20);
        PanelInfo.repaint();
        PanelInfo.revalidate();   
        
        }else if(ComboBox==3){
        //removing panel
        PanelInfo.removeAll();
        PanelInfo.repaint();
        PanelInfo.revalidate();        
        //adding panel
        PanelInfo.add(jPanel21);
        PanelInfo.repaint();
        PanelInfo.revalidate();   
          
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
       jButton3.setForeground(Color.WHITE);
       jButton3.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel9.setBackground(new Color(197, 239, 247));
       jPanel9.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
       jButton3.setForeground(new Color(255,255,255));
       jButton3.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel9.setBackground(Color.BLACK);   
       jPanel9.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           MessageFormat header = new MessageFormat("Report");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try{
            jTable4.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, null, true, null);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
       jButton12.setForeground(Color.WHITE);
       jButton12.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel10.setBackground(new Color(197, 239, 247));
       jPanel10.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
       jButton12.setForeground(new Color(255,255,255));
       jButton12.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel10.setBackground(Color.BLACK);   
       jPanel10.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
            MessageFormat header = new MessageFormat("Report");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try{
            jTable5.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, null, true, null);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseEntered
       jButton13.setForeground(Color.WHITE);
       jButton13.setFont(new java.awt.Font("Century Gothic BOLD", 0, 18)); // NOI18N
       jPanel11.setBackground(new Color(207, 0, 15));
       jPanel11.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton13MouseEntered

    private void jButton13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseExited
       jButton13.setForeground(new Color(255,255,255));
       jButton13.setFont(new java.awt.Font("Century Gothic BOLD", 0, 14)); // NOI18N
       jPanel11.setBackground(Color.BLACK);   
       jPanel11.setBorder(new LineBorder(new Color(0,102,102),1,true));
    }//GEN-LAST:event_jButton13MouseExited

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p==0){ 
            
        try {
            String sql="delete from tblaccount where employee_id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,emp_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Delete Data Successfully");           
            showdata3();
            clear();
            countaccount();
            countcash();
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
         try {
            int row = jTable6.getSelectedRow();
            String Table_clicks=(jTable6.getModel().getValueAt(row, 0).toString());
            String sql = "select * from tblaccount where employee_id='"+Table_clicks+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
              emp_id.setText(rs.getString("employee_id"));
              eposition_name.setText(rs.getString("positionname"));
              e2.setText(rs.getString("number_of_days_work"));
              e3.setText(rs.getString("bonus"));
              e4.setText(rs.getString("overtime_pay"));
              e5.setText(rs.getString("gross_salary"));
              e6.setText(rs.getString("cash_advance"));
              e7.setText(rs.getString("late_hours"));
              e8.setText(rs.getString("absent_days"));
              e9.setText(rs.getString("sss_contribute"));
              e10.setText(rs.getString("philhealth"));
              e11.setText(rs.getString("total_deduction"));
              e12.setText(rs.getString("account_id"));
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_jTable6MouseClicked

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        jButton14.setFont(new java.awt.Font("Century Gothic BOLD", 0, 28)); // NOI18N
        count_log.setFont(new java.awt.Font("Century Gothic BOLD", 0, 60)); // NOI18N
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseExited
        jButton14.setFont(new java.awt.Font("Century Gothic BOLD", 0, 24)); // NOI18N
        count_log.setFont(new java.awt.Font("Century Gothic BOLD", 0, 48)); // NOI18N
        
    }//GEN-LAST:event_jButton14MouseExited

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        jButton15.setFont(new java.awt.Font("Century Gothic BOLD", 0, 28)); // NOI18N
        count_employee.setFont(new java.awt.Font("Century Gothic BOLD", 0, 60)); // NOI18N
        
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
       jButton15.setFont(new java.awt.Font("Century Gothic BOLD", 0, 24)); // NOI18N
       count_employee.setFont(new java.awt.Font("Century Gothic BOLD", 0, 48)); // NOI18N
       
    }//GEN-LAST:event_jButton15MouseExited

    private void jButton16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseEntered
        jButton16.setFont(new java.awt.Font("Century Gothic BOLD", 0, 28)); // NOI18N
        count_position.setFont(new java.awt.Font("Century Gothic BOLD", 0, 60)); // NOI18N
        
    }//GEN-LAST:event_jButton16MouseEntered

    private void jButton16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseExited
       jButton16.setFont(new java.awt.Font("Century Gothic BOLD", 0, 24)); // NOI18N
       count_position.setFont(new java.awt.Font("Century Gothic BOLD", 0, 48)); // NOI18N
        
    }//GEN-LAST:event_jButton16MouseExited

    private void jButton17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseEntered
        jButton17.setFont(new java.awt.Font("Century Gothic BOLD", 0, 28)); // NOI18N
        count_account.setFont(new java.awt.Font("Century Gothic BOLD", 0, 60)); // NOI18N
    }//GEN-LAST:event_jButton17MouseEntered

    private void jButton17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseExited
        jButton17.setFont(new java.awt.Font("Century Gothic BOLD", 0, 24)); // NOI18N
        count_account.setFont(new java.awt.Font("Century Gothic BOLD", 0, 48)); // NOI18N
    }//GEN-LAST:event_jButton17MouseExited

    private void jButton18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseEntered
        jButton18.setFont(new java.awt.Font("Century Gothic BOLD", 0, 28)); // NOI18N
        count_user.setFont(new java.awt.Font("Century Gothic BOLD", 0, 60)); // NOI18N
    }//GEN-LAST:event_jButton18MouseEntered

    private void jButton18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseExited
        jButton18.setFont(new java.awt.Font("Century Gothic BOLD", 0, 24)); // NOI18N
        count_user.setFont(new java.awt.Font("Century Gothic BOLD", 0, 48)); // NOI18N
    }//GEN-LAST:event_jButton18MouseExited

    private void jButton19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseEntered
         jButton19.setFont(new java.awt.Font("Century Gothic BOLD", 0, 28)); // NOI18N
         count_cash.setFont(new java.awt.Font("Century Gothic BOLD", 0, 60)); // NOI18N
    }//GEN-LAST:event_jButton19MouseEntered

    private void jButton19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseExited
         jButton19.setFont(new java.awt.Font("Century Gothic BOLD", 0, 24)); // NOI18N
        count_cash.setFont(new java.awt.Font("Century Gothic BOLD", 0, 48)); // NOI18N
    }//GEN-LAST:event_jButton19MouseExited

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
          try {
            int row = jTable8.getSelectedRow();
            String Table_click=(jTable8.getModel().getValueAt(row, 0).toString());
            String sql = "select * from tblemployee where id='"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                aID.setText(rs.getString("id"));
                afirstname.setText(rs.getString("firstname"));
                alastname.setText(rs.getString("lastname"));
                amiddlename.setText(rs.getString("middlename"));
                aAddress.setText(rs.getString("address"));
                aContact.setText(rs.getString("contact"));
                Combo_Gender.setSelectedItem(rs.getString("gender"));
                Combo_Status.setSelectedItem(rs.getString("status"));
                ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText(rs.getString("date_of_birth"));
               
    byte[] img = rs.getBytes("picture");
    ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(label_uplod.getWidth(), label_uplod.getHeight(), Image.SCALE_SMOOTH));
    label_uplod.setIcon(imageIcon);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_jTable8MouseClicked
//COUNTS========================================================================
public void countaudit(){
      try {
                String sql = "select count(id) as id from tblaudit";
                pst = conn.prepareStatement(sql);
                rs=pst.executeQuery();             
                if(rs.next()) {                    
                count_log.setText(rs.getString("id"));
                }
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);
          }
}   
public void countemployee(){
      try {
                String sql = "select count(id) as id from tblemployee";
                pst = conn.prepareStatement(sql);
                rs=pst.executeQuery();             
                if(rs.next()) {                    
                count_employee.setText(rs.getString("id"));
                }
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);
          }
}   
public void countposition(){
      try {
                String sql = "select count(position_id) as position_id from tblposition";
                pst = conn.prepareStatement(sql);
                rs=pst.executeQuery();             
                if(rs.next()) {                    
                count_position.setText(rs.getString("position_id"));
                }
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);
          }
}   

public void countaccount(){
      try {
                String sql = "select count(employee_id) as employee_id from tblaccount";
                pst = conn.prepareStatement(sql);
                rs=pst.executeQuery();             
                if(rs.next()) {                    
                count_account.setText(rs.getString("employee_id"));
                }
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);
          }
}  

public void countuser(){
      try {
                String sql = "select count(userid) as userid from tbllogin";
                pst = conn.prepareStatement(sql);
                rs=pst.executeQuery();             
                if(rs.next()) {                    
                count_user.setText(rs.getString("userid"));
                }
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);
          }
}  

public void countcash(){
      try {
                String sql = "select sum(cash_advance) as cash_advance from tblaccount";
                pst = conn.prepareStatement(sql);
                rs=pst.executeQuery();             
                if(rs.next()) {                    
                count_cash.setText(rs.getString("cash_advance"));
                }
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e);
          }
} 


//CLEARFIELDS===================================================================    
public void clear(){
    //employee
    aID.setText("");
    afirstname.setText("");
    amiddlename.setText("");
    alastname.setText("");
    aAddress.setText("");
    aContact.setText("");
    ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText("");
    Combo_Gender.setSelectedIndex(0);
    Combo_Status.setSelectedIndex(0);
    label_uplod.setIcon(null);
    
    //position
    position_id.setText("");
    position_name.setText("");
    pdailyrate.setText("");
    pmonthlyrate.setText("");
    pworkingdays.setText("");
    Label_img.setIcon(null);
    
    //account    
    emp_id.setText("");
    eposition_name.setText("");
    e2.setText("");
    e3.setText("");
    e4.setText("");
    e5.setText("");
    e6.setText("");
    e7.setText("");
    e8.setText("");
    e9.setText("");
    e10.setText("");
    e11.setText("");
    e12.setText("");
    
}

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel BTN1;
    public javax.swing.JPanel BTN2;
    public javax.swing.JPanel BTN3;
    public javax.swing.JPanel BTN4;
    public javax.swing.JPanel BTN5;
    public javax.swing.JPanel BTN6;
    public javax.swing.JPanel BTN7;
    public javax.swing.JPanel CardPanel;
    public javax.swing.JComboBox<String> Combo_Gender;
    public javax.swing.JComboBox<String> Combo_Status;
    public javax.swing.JLabel Dashboard;
    public javax.swing.JLabel Date;
    public javax.swing.JButton Exit;
    public javax.swing.JLabel Label1;
    public javax.swing.JLabel Label2;
    public javax.swing.JLabel Label3;
    public javax.swing.JLabel Label4;
    public javax.swing.JLabel Label5;
    public javax.swing.JLabel Label6;
    public javax.swing.JLabel Label7;
    public javax.swing.JLabel LabelTime;
    public javax.swing.JLabel Label_img;
    public javax.swing.JButton Minimize;
    public javax.swing.JPanel PN1;
    public javax.swing.JPanel PN2;
    public javax.swing.JPanel PN3;
    public javax.swing.JPanel PN4;
    public javax.swing.JPanel PN5;
    public javax.swing.JPanel PN6;
    public javax.swing.JPanel PN7;
    public javax.swing.JPanel Panel11;
    public javax.swing.JPanel Panel2;
    public javax.swing.JPanel Panel3;
    public javax.swing.JPanel Panel4;
    public javax.swing.JPanel Panel5;
    public javax.swing.JPanel Panel6;
    public javax.swing.JPanel PanelDash;
    public javax.swing.JPanel PanelFoot;
    public javax.swing.JPanel PanelHead;
    public javax.swing.JPanel PanelInfo;
    public javax.swing.JPanel PanelSide;
    public javax.swing.JTextField SSStax;
    public javax.swing.JLabel Time;
    public javax.swing.JTextField aAddress;
    public javax.swing.JTextField aContact;
    public javax.swing.JTextField aID;
    public javax.swing.JPanel addpanel;
    public javax.swing.JTextField advancepay;
    public javax.swing.JTextField afirstname;
    public javax.swing.JTextField alastname;
    public javax.swing.JTextField amiddlename;
    public javax.swing.JButton btn_add;
    public javax.swing.JButton btn_edit;
    public javax.swing.JPanel clearPanel;
    public javax.swing.JLabel count_account;
    public javax.swing.JLabel count_cash;
    public javax.swing.JLabel count_employee;
    public javax.swing.JLabel count_log;
    public javax.swing.JLabel count_position;
    public javax.swing.JLabel count_user;
    public javax.swing.JPanel deletepanel;
    public javax.swing.JTextField e10;
    public javax.swing.JTextField e11;
    public javax.swing.JTextField e12;
    public javax.swing.JTextField e2;
    public javax.swing.JTextField e3;
    public javax.swing.JTextField e4;
    public javax.swing.JTextField e5;
    public javax.swing.JTextField e6;
    public javax.swing.JTextField e7;
    public javax.swing.JTextField e8;
    public javax.swing.JTextField e9;
    public javax.swing.JPanel editpanel;
    public javax.swing.JTextField emp_id;
    public javax.swing.JTextField eposition_name;
    public javax.swing.JTextField gross_salary;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton10;
    public javax.swing.JButton jButton11;
    public javax.swing.JButton jButton12;
    public javax.swing.JButton jButton13;
    public javax.swing.JButton jButton14;
    public javax.swing.JButton jButton15;
    public javax.swing.JButton jButton16;
    public javax.swing.JButton jButton17;
    public javax.swing.JButton jButton18;
    public javax.swing.JButton jButton19;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    public javax.swing.JButton jButton9;
    public javax.swing.JComboBox<String> jComboBox3;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    public javax.swing.JDesktopPane jDesktopPane1;
    public javax.swing.JDesktopPane jDesktopPane2;
    public javax.swing.JDesktopPane jDesktopPane3;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel26;
    public javax.swing.JLabel jLabel27;
    public javax.swing.JLabel jLabel28;
    public javax.swing.JLabel jLabel29;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel30;
    public javax.swing.JLabel jLabel31;
    public javax.swing.JLabel jLabel32;
    public javax.swing.JLabel jLabel33;
    public javax.swing.JLabel jLabel34;
    public javax.swing.JLabel jLabel35;
    public javax.swing.JLabel jLabel36;
    public javax.swing.JLabel jLabel37;
    public javax.swing.JLabel jLabel38;
    public javax.swing.JLabel jLabel39;
    public javax.swing.JLabel jLabel40;
    public javax.swing.JLabel jLabel41;
    public javax.swing.JLabel jLabel42;
    public javax.swing.JLabel jLabel43;
    public javax.swing.JLabel jLabel44;
    public javax.swing.JLabel jLabel45;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel11;
    public javax.swing.JPanel jPanel12;
    public javax.swing.JPanel jPanel13;
    public javax.swing.JPanel jPanel14;
    public javax.swing.JPanel jPanel15;
    public javax.swing.JPanel jPanel16;
    public javax.swing.JPanel jPanel17;
    public javax.swing.JPanel jPanel18;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel20;
    public javax.swing.JPanel jPanel21;
    public javax.swing.JPanel jPanel22;
    public javax.swing.JPanel jPanel24;
    public javax.swing.JPanel jPanel25;
    public javax.swing.JPanel jPanel26;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTable jTable3;
    public javax.swing.JTable jTable4;
    public javax.swing.JTable jTable5;
    public javax.swing.JTable jTable6;
    public javax.swing.JTable jTable7;
    public javax.swing.JTable jTable8;
    public javax.swing.JTextField jTextField10;
    public javax.swing.JTextField jTextField11;
    public javax.swing.JTextField jTextField12;
    public javax.swing.JTextField jTextField13;
    public javax.swing.JTextField jTextField15;
    public javax.swing.JTextField jTextField16;
    public javax.swing.JTextField jTextField8;
    public javax.swing.JTextField jTextField9;
    public javax.swing.JLabel labelLogin;
    public javax.swing.JLabel label_uplod;
    public javax.swing.JLabel labelmg;
    public javax.swing.JTextField overtimepay;
    public javax.swing.JTextField pag_ibigtax;
    public javax.swing.JTextField pdailyrate;
    public javax.swing.JTextField philhealth;
    public javax.swing.JTextField pmonthlyrate;
    public javax.swing.JTextField position_id;
    public javax.swing.JTextField position_name;
    public javax.swing.JTextField pworkingdays;
    public javax.swing.JTextField total_salary;
    public javax.swing.JTextField total_without_deduction;
    public javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables

    public ImageIcon format =null;
    String filename = null;
    byte[] person_image = null;
    
 
    
}
