/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dashboard;

import static dashboard.frmpasok.nampungtgl;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import static koneksi.koneksi.getkoneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Tubagus.r
 */
public class frmtransaksi extends javax.swing.JFrame {

    /**
     * Creates new form frmtransaksi
     */
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabmodel;
    PreparedStatement ps;
    String sql;
    Connection conn=null;
    Date jdc = new Date();
    PreparedStatement pst=null;

    Connection cn = koneksi.getkoneksi();
    public frmtransaksi() {
        initComponents();
       
        this.setLocationRelativeTo(null);
        koneksi k=new koneksi();
        k.getkoneksi();
        conn=k.cn;
        st=k.stm;
        temp.setVisible(false);
        tampil();
        kosong();
       
//        jDateChooser1.setDate(jdc);
        
        kdBarang.setEnabled(true);
        totalBayar.setEnabled(false);
        harga.setEnabled(false);
        namaBarang.setEnabled(false);
        total.setEnabled(false);
        harga.setEnabled(false);
        kembalian.setEnabled(false);
    }
//     private void kode(){
//        try {
//            String sql = "SELECT * FROM tbl_laporan ORDER by kd_laporan DESC";
//            st=conn.createStatement();
//            rs=st.executeQuery(sql);
//            if(rs.next()) {
//                String kd_laporan = rs.getString("kd_laporan").substring(1);
//                String laporan = "" + (Integer.parseInt(kd_laporan) +1);
//                
//                kdTransaksi.setText("TR" + laporan);
//            }else{
//                kdTransaksi.setText("TR0001");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    private void kosong(){
        notransaksi();
        jumlahUang.setText("");
        kdBarang.setText("");
        namaBarang.setText("");
        harga.setText("");
        jumlah.setText("");
        total.setText("");
        totalBayar.setText("");
        kembalian.setText("");
        btnSimpan.setEnabled(true);
        bayar.setEnabled(true);
        kdTransaksi.setEnabled(false);
        kembalian.setEnabled(false);
        kdBarang.requestFocus();
    }
    private void tampil(){
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("Kode Transaksi");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Satuan");
        model.addColumn("Jumlah");
        model.addColumn("Subtotal");
        
        try {
            String sql = "SELECT * FROM temp";
            rs=st.executeQuery(sql);
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                });
            }
            tbtrans.setModel(model);
        } catch (Exception e) {
        }
        }
   private void temp(){
     DefaultTableModel model = (DefaultTableModel) tbtrans.getModel();
    try{
        String sql="INSERT INTO transaksi SELECT * FROM temp";
        String sql2="delete from temp";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.addBatch(sql);
        ps.addBatch(sql2);
        ps.executeBatch();
        
        while(rs.next()){
         
        }
        model.setRowCount(0);
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    
    
    
   
    
private void notransaksi()
    {
       try {
            sql="select * from tbl_laporan order by kd_laporan desc";
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("kd_laporan").substring(2);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "0000";}
                else if(AN.length()==2)
                {Nol = "000";}
                else if(AN.length()==3)
                {Nol = "00";}
                else if(AN.length()==4)
                {Nol = "0";}
                else if(AN.length()==5)
                {Nol = "";}

               kdTransaksi.setText("TR" + Nol + AN);
            } else {
               kdTransaksi.setText("TR00001");
            }

           }catch(Exception e){
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kdTransaksi = new javax.swing.JTextField();
        kdBarang = new javax.swing.JTextField();
        namaBarang = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtrans = new javax.swing.JTable();
        btnSelesai = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        totalBayar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jumlahUang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bayar = new javax.swing.JButton();
        kembalian = new javax.swing.JTextField();
        temp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("FORM TRANSAKSI");

        jLabel2.setText("Kode Transaksi : ");

        jLabel3.setText("Kode Barang : ");

        jLabel4.setText("Nama Barang : ");

        jLabel5.setText("Harga Satuan : ");

        jLabel6.setText("Jumlah : ");

        jLabel7.setText("Sub Total : ");

        kdBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdBarangActionPerformed(evt);
            }
        });
        kdBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kdBarangKeyReleased(evt);
            }
        });

        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });
        jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jumlahKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlahKeyReleased(evt);
            }
        });

        btnSimpan.setFont(new java.awt.Font("Franklin Gothic Demi", 2, 13)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setFont(new java.awt.Font("Franklin Gothic Demi", 2, 13)); // NOI18N
        btnBatal.setText("Batal");

        tbtrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Transaksi", "Kode Barang", "Nama Barang", "Harga", "Jumlah"
            }
        ));
        jScrollPane1.setViewportView(tbtrans);
        if (tbtrans.getColumnModel().getColumnCount() > 0) {
            tbtrans.getColumnModel().getColumn(3).setResizable(false);
            tbtrans.getColumnModel().getColumn(4).setResizable(false);
        }

        btnSelesai.setFont(new java.awt.Font("Franklin Gothic Demi", 2, 13)); // NOI18N
        btnSelesai.setText("SELESAI BELANJA");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        jLabel8.setText("Total Bayar :");

        totalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBayarActionPerformed(evt);
            }
        });

        jLabel9.setText("Jumlah Uang :");

        jumlahUang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlahUangKeyReleased(evt);
            }
        });

        jLabel10.setText("Kembalian : ");

        bayar.setFont(new java.awt.Font("Franklin Gothic Demi", 2, 13)); // NOI18N
        bayar.setText("BAYAR");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        temp.setText("0");

        jButton1.setFont(new java.awt.Font("Franklin Gothic Demi", 2, 13)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-mm-dd");
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kdBarang)
                                    .addComponent(namaBarang)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(kdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(23, 23, 23))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnSimpan)
                        .addGap(35, 35, 35)
                        .addComponent(btnBatal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelesai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(totalBayar)
                                    .addComponent(jumlahUang, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(16, 16, 16)
                                .addComponent(kembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(bayar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(kdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(kdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(totalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnBatal)
                            .addComponent(jLabel9)
                            .addComponent(jumlahUang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kdBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kdBarangActionPerformed
       

    }//GEN-LAST:event_kdBarangActionPerformed

    private void kdBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdBarangKeyReleased
         try {
        String sql = "SELECT kd_barang,nama_barang,harga_jual FROM tbl_barang WHERE kd_barang =?";
        pst=cn.prepareStatement(sql);
        pst.setString(1,kdBarang.getText());

        rs = pst.executeQuery();
    if(rs.next()) { 
        String ID = rs.getString("kd_barang");
        kdBarang.setText(ID);
        String FN = rs.getString("nama_barang");
        namaBarang.setText(FN);
        String LN = rs.getString("harga_jual");
        harga.setText(LN);


    }
    } catch (SQLException e ) {
    e.printStackTrace();

    }//GEN-LAST:event_kdBarangKeyReleased
    }
    private void jumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jumlahKeyPressed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
//        String tgl=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
//        int bayar = JOptionPane.showConfirmDialog(this, "Apakah Anda ingin mencetak Struk Transaksi?",
//                "TRANSAKSI",JOptionPane.YES_NO_CANCEL_OPTION);
//        switch(bayar) {
//            case JOptionPane.YES_OPTION:
//                try {
//        
//                    String sqlinsert = "INSERT INTO tbl_laporan VALUES ('"+kdTransaksi.getText()+"',"
//                            +"'"+totalBayar.getText()+"','"+jumlahUang.getText()+"','"+kembalian.getText()+"',"
//                            +"'"+tgl+"')";
//                    st.executeUpdate(sqlinsert);
//                    Class.forName("com.mysql.jdbc.Driver");
//                    conn =DriverManager.getConnection("jdbc:mysql://localhost/db_java","root","");
//                    InputStream in = new FileInputStream(new File("D:\\Sekul\\Produktif\\Kelas XI\\Java\\Tugas\\11706424_Tubagus Radhiyya Ramandhika_RPLXI4\\Jobsheet\\src\\laporan\\fakturr.jrxml"));
//                    JasperDesign jd=JRXmlLoader.load(in);
//                    sql="SELECT * FROM query_faktur_transaksi";
//                    JRDesignQuery newQuery= new JRDesignQuery();
//                    newQuery.setText(sql);
//                    jd.setQuery(newQuery);
//                    JasperReport jr=JasperCompileManager.compileReport(jd);
//                    HashMap para=new HashMap();
//                    JasperPrint j=JasperFillManager.fillReport(jr, para,conn);
//                    JasperViewer.viewReport(j,false);
//                    OutputStream os=new FileOutputStream(new File("D:\\Sekul\\Produktif\\Kelas XI\\Java\\Tugas\\11706424_Tubagus Radhiyya Ramandhika_RPLXI4\\report"));
//                    JasperExportManager.exportReportToPdfStream(j, os);
//                    try {
//                        String sql1="SET @disable_triggers=1;";
//                        String sql2="TRUNCATE temp;";
//                        String sql3="SET @disable_triggers=NULL;";
//                        st.addBatch(sql1);
//                        st.addBatch(sql2);
//                        st.addBatch(sql3);
//                        st.executeBatch();
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, "TRANSAKSI GAGAL!!" + e.getMessage());
//                    }
//                    kosong();
//                    tampil();
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, e);
//                }
//                break;
//                case JOptionPane.NO_OPTION:
//                    try {
//                        String tgl=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
//                        String sql1="INSERT INTO temp VALUES ('"+kdTransaksi.getText()+"','"+totalBayar.getText()+"',"
//                                +"'"+jumlah.getText()+"','"+kembalian.getText()+"','"+tgl+"')";
//                        String sql2="SET @disable_triggers=1;";
//                        String sql3="TRUNCATE tbl_transaksi;";
//                        String sql4="SET @disable_triggers=NULL;";
//                        st.addBatch(sql1);
//                        st.addBatch(sql2);
//                        st.addBatch(sql3);
//                        st.addBatch(sql4);
//                        st.executeBatch();
//                        JOptionPane.showMessageDialog(null, "TRANSAKSI BERHASIL!!");
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, "TRANSAKSI GAGAL!\n" + e.getMessage());
//                    }
//                    kosong();
//                    tampil();
//                    break;
//                case JOptionPane.CANCEL_OPTION:
//        }
//        

 int bayar = JOptionPane.showConfirmDialog(this, "Apakah Anda ingin mencetak Struk Transaksi?",
                "TRANSAKSI",JOptionPane.YES_NO_CANCEL_OPTION);
        switch(bayar) {
            case JOptionPane.YES_OPTION:
                try {
                    String tgl=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
                    String sqlinsert = "INSERT INTO tbl_laporan VALUES ('"+kdTransaksi.getText()+"',"
                            +"'"+totalBayar.getText()+"','"+jumlahUang.getText()+"','"+kembalian.getText()+"',"
                            +"'"+tgl+"')";
                    st.executeUpdate(sqlinsert);
                    Class.forName("com.mysql.jdbc.Driver");
                    conn =DriverManager.getConnection("jdbc:mysql://localhost/db_java","root","");
                    InputStream in = new FileInputStream(new File("D:\\Sekul\\Produktif\\Kelas XI\\Java\\Tugas\\11706424_Tubagus Radhiyya Ramandhika_RPLXI4\\Jobsheet\\src\\laporan\\fakturr.jrxml"));
                    JasperDesign jd=JRXmlLoader.load(in);
                    sql="SELECT * FROM query_faktur_transaksi";
                    JRDesignQuery newQuery= new JRDesignQuery();
                    newQuery.setText(sql);
                    jd.setQuery(newQuery);
                    JasperReport jr=JasperCompileManager.compileReport(jd);
                    HashMap para=new HashMap();
                    JasperPrint j=JasperFillManager.fillReport(jr, para,conn);
                    JasperViewer.viewReport(j,false);
                    OutputStream os=new FileOutputStream(new File("D:\\Sekul\\Produktif\\Kelas XI\\Java\\Tugas\\11706424_Tubagus Radhiyya Ramandhika_RPLXI4\\report"));
                    JasperExportManager.exportReportToPdfStream(j, os);
                    try {
                        String sql1="SET @disable_triggers=1;";
                        String sql2="TRUNCATE temp;";
                        String sql3="SET @disable_triggers=NULL;";
                        st.addBatch(sql1);
                        st.addBatch(sql2);
                        st.addBatch(sql3);
                        st.executeBatch();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "TRANSAKSI GAGAL!!" + e.getMessage());
                    }
                    kosong();
                    tampil();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                break;
                case JOptionPane.NO_OPTION:
                    try {
                        String tgl=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
                        String sql1="INSERT INTO tbl_laporan VALUES ('"+kdTransaksi.getText()+"','"+totalBayar.getText()+"',"
                                +"'"+jumlah.getText()+"','"+kembalian.getText()+"','"+tgl+"')";
                        String sql2="SET @disable_triggers=1;";
                        String sql3="TRUNCATE tbl_transaksi;";
                        String sql4="SET @disable_triggers=NULL;";
                        st.addBatch(sql1);
                        st.addBatch(sql2);
                        st.addBatch(sql3);
                        st.addBatch(sql4);
                        st.executeBatch();
                        JOptionPane.showMessageDialog(null, "TRANSAKSI BERHASIL!!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "TRANSAKSI GAGAL!\n" + e.getMessage());
                    }
                    kosong();
                    tampil();
                    break;
                case JOptionPane.CANCEL_OPTION:
        }
    }//GEN-LAST:event_bayarActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(kdTransaksi.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Lengkapi Semua Data(Kode Barang)!");
           kdTransaksi.requestFocus();
       }else if(kdBarang.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Masukkan Kode Barang yang Benar !");
           kdBarang.requestFocus();
       }else if(namaBarang.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Lengkapi Semua Data(Jumlah)!");
           namaBarang.requestFocus();
       }else if(harga.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Masukkan Jumlah Yang Valid");
           harga.requestFocus();
       }else if(jumlah.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Masukkan Jumlah Yang Valid");
           harga.requestFocus();
       }else if(total.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Masukkan Jumlah YangValid");
           total.requestFocus();
       }else{
            try {
               String sql = "INSERT INTO temp VALUES ('"+kdTransaksi.getText()+"','"+kdBarang.getText()+"',"
                       +"'"+namaBarang.getText()+"','"+harga.getText()+"','"+jumlah.getText()+"',"
                       +"'"+total.getText()+"')";
               st.executeUpdate(sql);
               JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!!");
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!" + e.getMessage());
           }
            kosong();
            tampil();
            
       }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
 try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT SUM(subtotal) FROM temp");
            if(rs.next()){
            jumlah.setEnabled(true);
            totalBayar.setText(rs.getString(1));
            notransaksi();
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi Gagal"+e.getMessage());
        }       
        
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahKeyReleased
        // TODO add your handling code here:
      
        int tot,a,b;
        a=Integer.parseInt(harga.getText());
        b=Integer.parseInt(jumlah.getText());
        tot=b*a;
        total.setText(Integer.toString(tot));
        
        
    }//GEN-LAST:event_jumlahKeyReleased

    private void totalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalBayarActionPerformed

    private void jumlahUangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahUangKeyReleased
        // TODO add your handling code here:
         int tot,a,b;
        a=Integer.parseInt(totalBayar.getText());
        b=Integer.parseInt(jumlahUang.getText());
        tot=b-a;
        kembalian.setText(Integer.toString(tot));
    }//GEN-LAST:event_jumlahUangKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmdashboard index = new frmdashboard();
        index.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
                if(jDateChooser1.getDate()!=null)
{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            nampungtgl = format.format(jDateChooser1.getDate()); 
            System.out.println("propertychange"+nampungtgl);
}
    }//GEN-LAST:event_jDateChooser1PropertyChange


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
            java.util.logging.Logger.getLogger(frmtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmtransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bayar;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JButton btnSimpan;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JTextField harga;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JEditorPane jEditorPane1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField jumlahUang;
    private javax.swing.JTextField kdBarang;
    private javax.swing.JTextField kdTransaksi;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTable tbtrans;
    private javax.swing.JTextField temp;
    private javax.swing.JTextField total;
    private javax.swing.JTextField totalBayar;
    // End of variables declaration//GEN-END:variables
}
