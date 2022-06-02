/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Code.connect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class mainView extends javax.swing.JFrame {
    private String SQL; 
    private Object jTable;
DefaultTableModel model,model2;
public static int statuscari = 0; 
    /**
     * Creates new form mainView
     */
    public void pindah_panelKyw(){
         mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelKaryawan);
        mainpanel.repaint();
        mainpanel.revalidate();
    }
    public void pindah_panelBeli(){
         mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelLap_pembelian);
        mainpanel.repaint();
        mainpanel.revalidate();
    }
    public void pindah_panelBrg(){
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelBarang);
        mainpanel.repaint();
        mainpanel.revalidate();
    }
    
    public void Tampil_Jam(){
        ActionListener taskPerformer = new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent evt) {
            String nol_jam = "", nol_menit = "",nol_detik = "";
 
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();
 
            if(nilai_jam <= 9) nol_jam= "0";
            if(nilai_menit <= 9) nol_menit= "0";
            if(nilai_detik <= 9) nol_detik= "0";
 
            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);
 
            jLabel_jam.setText(jam+":"+menit+":"+detik+"");
            }
        };
    new Timer(1000, taskPerformer).start();
    }   
 
public void Tampil_Tanggal() {
    java.util.Date tglsekarang = new java.util.Date();
    SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd MMMMMMMMM yyyy", Locale.getDefault());
    String tanggal = smpdtfmt.format(tglsekarang);
    jLabel_tgl.setText(tanggal);
}

    public mainView() {
        initComponents();
        setLocationRelativeTo(null);
          String [] judul1={"KODE OBAT","NAMA OBAT","SATUAN","JENIS","HARGA","STOK"};
        model = new DefaultTableModel(judul1,0);
        tblobat.setModel(model);
        String[] judul2 = {"Id Karyawan","Id User","Nama Karyawan","Email","No Hp","Alamat"};
        model2 = new DefaultTableModel(judul2, 0);
        table.setModel(model2);
        Tampil_Jam();
        Tampil_Tanggal();
        tampilkan_brg();
        tampilkan_kyw();
    }
    private void tampilkan_kyw() {
        int row = table.getRowCount();
        for (int a = 0; a < row; a++) {
            model2.removeRow(0);
        }
        try {
            Connection en = DriverManager.getConnection("jdbc:mysql://localhost/db_apotek", "root", "");
            ResultSet rs = en.createStatement().executeQuery("SELECT * FROM tb_karyawan");
            while (rs.next()) {
                String data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                model2.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

 private void tampilkan_brg() {
        int row = tblobat.getRowCount();
        for(int a=0; a<row;a++){
        model.removeRow(0);}
        String cari  = txtcari.getText();
        Connection conn = connect.getConnection();
        try {
        java.sql.Statement stmt = conn.createStatement();
            String SQL = "select * from tb_barang";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
               model.addRow(new Object[]{
                    res.getString("kd_obat"),
                    res.getString("nama_obat"),
                    res.getString("satuan"),
                    res.getString("jenis"),
                    res.getString("satuan"),
                    res.getString("harga"),
                    res.getString("stok")
                });
                }
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodypanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        mainpanel = new javax.swing.JPanel();
        PanelHome = new javax.swing.JPanel();
        panelSearch = new javax.swing.JPanel();
        labelSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        jLabel_jam = new javax.swing.JLabel();
        jLabel_tgl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelGambar = new javax.swing.JLabel();
        PanelBarang = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        btncari = new javax.swing.JToggleButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblobat = new javax.swing.JTable();
        PanelKaryawan = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btncari1 = new javax.swing.JToggleButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        PanelLap_penjualan = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Cetak = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableLaporan = new javax.swing.JTable();
        PanelLap_pembelian = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jToggleButton5 = new javax.swing.JToggleButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabLap = new javax.swing.JTable();
        Cetak1 = new javax.swing.JButton();
        panelnama = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelmenu1 = new javax.swing.JPanel();
        buttonHome = new javax.swing.JButton();
        buttonBarang = new javax.swing.JButton();
        buttonKyw = new javax.swing.JButton();
        buttonTransaksi = new javax.swing.JButton();
        buttonLapPen = new javax.swing.JButton();
        buttonLapBeli = new javax.swing.JButton();
        buttonUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        mainpanel.setBackground(new java.awt.Color(224, 216, 176));
        mainpanel.setLayout(new java.awt.CardLayout());

        PanelHome.setBackground(new java.awt.Color(224, 216, 176));

        panelSearch.setBackground(new java.awt.Color(222, 160, 87));

        buttonSearch.setText("CARI");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        jLabel_jam.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel_jam.setText("Pukul");

        jLabel_tgl.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel_tgl.setText("Tanggal");

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel5.setBackground(new java.awt.Color(252, 255, 231));

        jTextField4.setText("jTextField3");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(222, 160, 87));

        jLabel3.setBackground(new java.awt.Color(222, 160, 87));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText("Penjualan");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(222, 160, 87)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTextField4)
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(252, 255, 231));

        jTextField3.setText("jTextField3");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(222, 160, 87));

        jLabel4.setBackground(new java.awt.Color(222, 160, 87));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText("Barang");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(222, 160, 87)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        labelGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/obat2.jpg"))); // NOI18N

        javax.swing.GroupLayout PanelHomeLayout = new javax.swing.GroupLayout(PanelHome);
        PanelHome.setLayout(PanelHomeLayout);
        PanelHomeLayout.setHorizontalGroup(
            PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHomeLayout.createSequentialGroup()
                        .addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(PanelHomeLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        PanelHomeLayout.setVerticalGroup(
            PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(233, Short.MAX_VALUE))
        );

        mainpanel.add(PanelHome, "card2");

        PanelBarang.setBackground(new java.awt.Color(224, 216, 176));

        jLabel19.setBackground(new java.awt.Color(222, 160, 87));
        jLabel19.setFont(new java.awt.Font("Bahnschrift", 1, 50)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(222, 160, 87));
        jLabel19.setText("Data Obat");

        btncari.setBackground(new java.awt.Color(252, 255, 231));
        btncari.setText("CARI");
        btncari.setToolTipText("");
        btncari.setBorderPainted(false);
        btncari.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncariMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btncariMousePressed(evt);
            }
        });
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jButton8.setText("Tambah Data");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        jButton9.setText("Edit Data");

        jButton10.setText("Hapus Data");

        tblobat.setModel(new javax.swing.table.DefaultTableModel(
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
        tblobat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblobatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblobat);

        javax.swing.GroupLayout PanelBarangLayout = new javax.swing.GroupLayout(PanelBarang);
        PanelBarang.setLayout(PanelBarangLayout);
        PanelBarangLayout.setHorizontalGroup(
            PanelBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBarangLayout.createSequentialGroup()
                .addContainerGap(697, Short.MAX_VALUE)
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(PanelBarangLayout.createSequentialGroup()
                .addGroup(PanelBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBarangLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelBarangLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelBarangLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBarangLayout.setVerticalGroup(
            PanelBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBarangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(244, Short.MAX_VALUE))
        );

        mainpanel.add(PanelBarang, "card3");

        PanelKaryawan.setBackground(new java.awt.Color(224, 216, 176));

        jLabel20.setBackground(new java.awt.Color(222, 160, 87));
        jLabel20.setFont(new java.awt.Font("Bahnschrift", 1, 50)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(222, 160, 87));
        jLabel20.setText("Data Karyawan");

        btncari1.setBackground(new java.awt.Color(252, 255, 231));
        btncari1.setText("CARI");
        btncari1.setToolTipText("");
        btncari1.setBorderPainted(false);
        btncari1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncari1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btncari1MousePressed(evt);
            }
        });
        btncari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncari1ActionPerformed(evt);
            }
        });

        jButton11.setText("Tambah Data");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Edit Data");

        jButton13.setText("Hapus Data");

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout PanelKaryawanLayout = new javax.swing.GroupLayout(PanelKaryawan);
        PanelKaryawan.setLayout(PanelKaryawanLayout);
        PanelKaryawanLayout.setHorizontalGroup(
            PanelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKaryawanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncari1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(PanelKaryawanLayout.createSequentialGroup()
                .addGroup(PanelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelKaryawanLayout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelKaryawanLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(PanelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelKaryawanLayout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        PanelKaryawanLayout.setVerticalGroup(
            PanelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKaryawanLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(PanelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(218, Short.MAX_VALUE))
        );

        mainpanel.add(PanelKaryawan, "card4");

        PanelLap_penjualan.setBackground(new java.awt.Color(224, 216, 176));

        jLabel8.setBackground(new java.awt.Color(224, 216, 176));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 50)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(222, 160, 87));
        jLabel8.setText("Laporan Penjualan");

        Cetak.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        Cetak.setText("CETAK");
        Cetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CetakMouseClicked(evt);
            }
        });
        Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakActionPerformed(evt);
            }
        });

        TableLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane3.setViewportView(TableLaporan);

        javax.swing.GroupLayout PanelLap_penjualanLayout = new javax.swing.GroupLayout(PanelLap_penjualan);
        PanelLap_penjualan.setLayout(PanelLap_penjualanLayout);
        PanelLap_penjualanLayout.setHorizontalGroup(
            PanelLap_penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLap_penjualanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(PanelLap_penjualanLayout.createSequentialGroup()
                .addGroup(PanelLap_penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLap_penjualanLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLap_penjualanLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        PanelLap_penjualanLayout.setVerticalGroup(
            PanelLap_penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLap_penjualanLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(Cetak)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        mainpanel.add(PanelLap_penjualan, "card5");

        PanelLap_pembelian.setBackground(new java.awt.Color(224, 216, 176));

        jLabel11.setBackground(new java.awt.Color(222, 160, 87));
        jLabel11.setFont(new java.awt.Font("Bahnschrift", 1, 50)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(222, 160, 87));
        jLabel11.setText("Laporan Pembelian");

        jToggleButton5.setText("Tambah");
        jToggleButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton5MouseClicked(evt);
            }
        });

        TabLap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane5.setViewportView(TabLap);

        Cetak1.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        Cetak1.setText("CETAK");
        Cetak1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cetak1MouseClicked(evt);
            }
        });
        Cetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cetak1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLap_pembelianLayout = new javax.swing.GroupLayout(PanelLap_pembelian);
        PanelLap_pembelian.setLayout(PanelLap_pembelianLayout);
        PanelLap_pembelianLayout.setHorizontalGroup(
            PanelLap_pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLap_pembelianLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cetak1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLap_pembelianLayout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(PanelLap_pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLap_pembelianLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLap_pembelianLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        PanelLap_pembelianLayout.setVerticalGroup(
            PanelLap_pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLap_pembelianLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(PanelLap_pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cetak1))
                .addGap(85, 85, 85))
        );

        mainpanel.add(PanelLap_pembelian, "card6");

        panelnama.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/farmasi.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel7.setText("APOTEK GUARDIAN");

        javax.swing.GroupLayout panelnamaLayout = new javax.swing.GroupLayout(panelnama);
        panelnama.setLayout(panelnamaLayout);
        panelnamaLayout.setHorizontalGroup(
            panelnamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnamaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(874, Short.MAX_VALUE))
        );
        panelnamaLayout.setVerticalGroup(
            panelnamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnamaLayout.createSequentialGroup()
                .addGroup(panelnamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelmenu1.setBackground(new java.awt.Color(224, 216, 176));

        buttonHome.setText("Home");
        buttonHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonHomeMouseClicked(evt);
            }
        });
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });

        buttonBarang.setText("Data Obat");
        buttonBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBarangMouseClicked(evt);
            }
        });
        buttonBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarangActionPerformed(evt);
            }
        });

        buttonKyw.setText("Data Karyawan");
        buttonKyw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonKywMouseClicked(evt);
            }
        });
        buttonKyw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKywActionPerformed(evt);
            }
        });

        buttonTransaksi.setText("Transaksi");
        buttonTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTransaksiMouseClicked(evt);
            }
        });
        buttonTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransaksiActionPerformed(evt);
            }
        });

        buttonLapPen.setText("Laporan Penjualan");
        buttonLapPen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLapPenMouseClicked(evt);
            }
        });
        buttonLapPen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLapPenActionPerformed(evt);
            }
        });

        buttonLapBeli.setText("Laporan Pembelian");
        buttonLapBeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLapBeliMouseClicked(evt);
            }
        });

        buttonUser.setText("User");
        buttonUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUserMouseClicked(evt);
            }
        });
        buttonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelmenu1Layout = new javax.swing.GroupLayout(panelmenu1);
        panelmenu1.setLayout(panelmenu1Layout);
        panelmenu1Layout.setHorizontalGroup(
            panelmenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenu1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelmenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLapBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonKyw, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLapPen, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelmenu1Layout.setVerticalGroup(
            panelmenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenu1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buttonBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(buttonKyw, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(buttonTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(buttonLapPen, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonLapBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(buttonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelmenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelnama, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelmenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout bodypanelLayout = new javax.swing.GroupLayout(bodypanel);
        bodypanel.setLayout(bodypanelLayout);
        bodypanelLayout.setHorizontalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        bodypanelLayout.setVerticalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodypanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bodypanel, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHomeMouseClicked
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelHome);
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_buttonHomeMouseClicked

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBarangMouseClicked
        // TODO add your handling code here:
        //go to halaman data barang
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelBarang);
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_buttonBarangMouseClicked

    private void buttonBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBarangActionPerformed

    private void buttonKywMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonKywMouseClicked
        // TODO add your handling code here:
        //go to halaman data karyawan
        
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelKaryawan);
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_buttonKywMouseClicked

    private void buttonKywActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKywActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonKywActionPerformed

    private void buttonTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTransaksiMouseClicked
        // TODO add your handling code here:
         mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelTransaksi);
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_buttonTransaksiMouseClicked

    private void buttonTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTransaksiActionPerformed

    private void buttonLapPenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLapPenMouseClicked
        // TODO add your handling code here:
         mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelLap_penjualan);
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_buttonLapPenMouseClicked

    private void buttonLapBeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLapBeliMouseClicked
        // TODO add your handling code here:
         mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelLap_pembelian);
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_buttonLapBeliMouseClicked

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btncariMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariMousePressed
        // 
    }//GEN-LAST:event_btncariMousePressed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncariActionPerformed

    private void tblobatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblobatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblobatMouseClicked

    private void btncari1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncari1MousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btncari1MousePressed

    private void btncari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncari1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncari1ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int i  = table.getSelectedRow();

        if (i > -1) {
            id_karyawan.setText(model.getValueAt(i, 0).toString());
            id_user.setText(model.getValueAt(i, 1).toString());
            nama_karyawan.setText(model.getValueAt(i, 2).toString());
            email.setText(model.getValueAt(i, 3).toString());
            no_tlp.setText(model.getValueAt(i, 4).toString());
            alamat.setText(model.getValueAt(i, 5).toString());
        }
    }//GEN-LAST:event_tableMouseClicked

    private void CetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CetakMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CetakMouseClicked

    private void CetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakActionPerformed
        // TODO add your handling code here:
        cetak_penjualan pen =new cetak_penjualan();
        pen.setVisible(true);
        pen.pack();
        pen.setLocationRelativeTo(null);
        this.dispose();
       
    }//GEN-LAST:event_CetakActionPerformed

    private void buttonLapPenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLapPenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLapPenActionPerformed

    private void Cetak1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cetak1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Cetak1MouseClicked

    private void Cetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cetak1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cetak1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void buttonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUserActionPerformed

    private void buttonUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUserMouseClicked
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(PanelUser);
        mainpanel.repaint();
        mainpanel.revalidate();
        
    }//GEN-LAST:event_buttonUserMouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        tambahBarang tb =new tambahBarang();
        tb.setVisible(true);
        tb.pack();
        tb.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
        tambahKaryawan tk =new tambahKaryawan();
        tk.setVisible(true);
        tk.pack();
        tk.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton11MouseClicked

    private void jToggleButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton5MouseClicked
        // TODO add your handling code here:
        tambahPembelian tp =new tambahPembelian();
        tp.setVisible(true);
        tp.pack();
        tp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jToggleButton5MouseClicked

    private void btncariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncariMouseClicked
        // TODO add your handling code here:
        tampilkan_brg();
    }//GEN-LAST:event_btncariMouseClicked

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
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cetak;
    private javax.swing.JButton Cetak1;
    private javax.swing.JPanel PanelBarang;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JPanel PanelKaryawan;
    private javax.swing.JPanel PanelLap_pembelian;
    private javax.swing.JPanel PanelLap_penjualan;
    private javax.swing.JTable TabLap;
    private javax.swing.JTable TableLaporan;
    private javax.swing.JPanel bodypanel;
    private javax.swing.JToggleButton btncari;
    private javax.swing.JToggleButton btncari1;
    private javax.swing.JButton buttonBarang;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonKyw;
    private javax.swing.JButton buttonLapBeli;
    private javax.swing.JButton buttonLapPen;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonTransaksi;
    private javax.swing.JButton buttonUser;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_jam;
    private javax.swing.JLabel jLabel_tgl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JLabel labelGambar;
    private javax.swing.JTextField labelSearch;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelmenu1;
    private javax.swing.JPanel panelnama;
    private javax.swing.JTable table;
    private javax.swing.JTable tblobat;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}
