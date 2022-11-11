/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;
import conexion.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Edwin Martinez
 */
public class frm_buscar_medicamentos extends javax.swing.JFrame {

    /**
     * Creates new form frm_buscar_productos
     */
    DefaultTableModel medicamento;
    
    public frm_buscar_medicamentos() {
        initComponents();
        
        this.medicamento = (DefaultTableModel) tbl_medicamento.getModel();
        Mostrardatos("");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    public final void Mostrardatos(String valor){
           
            MyConnection cc=new MyConnection();
            Connection cn=MyConnection.getConnection();
            RefrescarTabla();
            medicamento.addColumn("Código");
            medicamento.addColumn("Nombre");
            medicamento.addColumn("Precio");
            
           
 
            this.tbl_medicamento.setModel(medicamento);
            String sql;
            
            //Condicional IF para seleccionar los datos de los medicamentos
            if (valor.equals(""))
            {
            sql="SELECT cod_medic, nom_medic, precio_venta FROM medicamento";
            }
            else{
            sql="SELECT cod_medic, nom_medic, precio_venta FROM medicamento WHERE medicamento='"+valor+"'";
            } 
            
            //Declaración de arreglo para llenar tabla de medicamentos
            String []datos=new String [3];
            try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            
            //Asignación de posiciones para el arreglo
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            

 
         medicamento.addRow(datos);
            }
            tbl_medicamento.setModel((TableModel) medicamento);
            }
            
            //Mensaje de error
            catch(SQLException ex){
            Logger.getLogger(frm_facturacion_medicamentos.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    
    public final void RefrescarTabla(){
        //Funcion encargada de refrescar la tabla utilizando revalidate
        try {
        medicamento.setColumnCount(0);
        medicamento.setRowCount(0);
        tbl_medicamento.revalidate();
        }
        //Mensaje de error
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
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

        jp_contenedor = new javax.swing.JPanel();
        jsc_tblmedicamento = new javax.swing.JScrollPane();
        tbl_medicamento = new javax.swing.JTable();
        btn_aceptarproducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_contenedor.setBackground(new java.awt.Color(234, 234, 234));

        tbl_medicamento.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tbl_medicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_medicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_medicamentoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_medicamentoMousePressed(evt);
            }
        });
        tbl_medicamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_medicamentoKeyPressed(evt);
            }
        });
        jsc_tblmedicamento.setViewportView(tbl_medicamento);

        btn_aceptarproducto.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        btn_aceptarproducto.setText("Aceptar");
        btn_aceptarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarproductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_contenedorLayout = new javax.swing.GroupLayout(jp_contenedor);
        jp_contenedor.setLayout(jp_contenedorLayout);
        jp_contenedorLayout.setHorizontalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jsc_tblmedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(btn_aceptarproducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_contenedorLayout.setVerticalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jsc_tblmedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_aceptarproducto)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aceptarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarproductoActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_btn_aceptarproductoActionPerformed

    private void tbl_medicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_medicamentoMouseClicked
        // TODO add your handling code here:
        try {  
            
        //Declaración de variables y sus respecivas posiciones en la tabla de medicamentos
        String id = (String) medicamento.getValueAt(tbl_medicamento.getSelectedRow(),0);
        String nombre = (String) medicamento.getValueAt(tbl_medicamento.getSelectedRow(),1);
        String precio = (String) medicamento.getValueAt(tbl_medicamento.getSelectedRow(),2);
        

        
       frm_facturacion_medicamentos.txt_codigomedic.setText(id);
       frm_facturacion_medicamentos.txt_nombremedic.setText(nombre);
       frm_facturacion_medicamentos.txt_preciomedic.setText(precio);
       
      
     
        }
        //Mensaje de error
        catch (Exception ex){
        JOptionPane.showMessageDialog(null, "error "+ex);
        }
    Mostrardatos("");
    }//GEN-LAST:event_tbl_medicamentoMouseClicked

    private void tbl_medicamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_medicamentoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_medicamentoMousePressed

    private void tbl_medicamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_medicamentoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_medicamentoKeyPressed

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
            java.util.logging.Logger.getLogger(frm_buscar_medicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_buscar_medicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_buscar_medicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_buscar_medicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        //Evento para visualizar el formulario de búsqueda de medicamentos
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_buscar_medicamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptarproducto;
    private javax.swing.JPanel jp_contenedor;
    private javax.swing.JScrollPane jsc_tblmedicamento;
    private javax.swing.JTable tbl_medicamento;
    // End of variables declaration//GEN-END:variables
}
