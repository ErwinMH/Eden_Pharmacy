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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Edwin Martinez
 */
public class frm_buscar_cliente_medicamentos extends javax.swing.JFrame {

    /**
     * Creates new form frm_buscar_cliente
     */
    DefaultTableModel cliente;
    
    public frm_buscar_cliente_medicamentos() {
        initComponents();
        this.cliente = (DefaultTableModel) tbl_cliente.getModel();
        Mostrardatos("");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
       
    }
    
    public final void Mostrardatos (String valor){
        MyConnection cc=new MyConnection();
        Connection cn=MyConnection.getConnection();
        RefrescarTabla();
        cliente.addColumn("ID");
        cliente.addColumn("Nombre");
        cliente.addColumn("Apellidos");
        
        this.tbl_cliente.setModel(cliente);
            String sql;
            
            //Condicionar IF para mostrar los datos de los clientes
            if (valor.equals(""))
            {
            sql="SELECT ID_cliente, nom_cliente, apellidos_cliente FROM cliente";
            }
            else{
            sql="SELECT ID_cliente, nom_cliente, apellidos_cliente FROM cliente WHERE cliente='"+valor+"'";
            } 
            
            //Arreglo para llenar la tabla de clientes
            String []datos=new String [3];
            try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            

 
         cliente.addRow(datos);
            }
            tbl_cliente.setModel((TableModel) cliente);
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
        cliente.setColumnCount(0);
        cliente.setRowCount(0);
        tbl_cliente.revalidate();
        }
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
        jsc_tblcliente = new javax.swing.JScrollPane();
        tbl_cliente = new javax.swing.JTable();
        btn_aceptarclientemedic = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_contenedor.setBackground(new java.awt.Color(255, 255, 255));

        tbl_cliente.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_clienteMousePressed(evt);
            }
        });
        tbl_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_clienteKeyPressed(evt);
            }
        });
        jsc_tblcliente.setViewportView(tbl_cliente);

        btn_aceptarclientemedic.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        btn_aceptarclientemedic.setText("Aceptar");
        btn_aceptarclientemedic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarclientemedicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_contenedorLayout = new javax.swing.GroupLayout(jp_contenedor);
        jp_contenedor.setLayout(jp_contenedorLayout);
        jp_contenedorLayout.setHorizontalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jsc_tblcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(btn_aceptarclientemedic)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_contenedorLayout.setVerticalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jsc_tblcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btn_aceptarclientemedic)
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void btn_aceptarclientemedicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarclientemedicActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_aceptarclientemedicActionPerformed

    private void tbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMouseClicked
        // TODO add your handling code here:
        try {  
            
        //Declaración de variables y sus respectivas posiciones en la tabla para pasar los datos a la facturación
        String id = (String) cliente.getValueAt(tbl_cliente.getSelectedRow(),0);
        String nombre = (String) cliente.getValueAt(tbl_cliente.getSelectedRow(),1);
        String apellidos = (String) cliente.getValueAt(tbl_cliente.getSelectedRow(),2);
        

        
       frm_facturacion_medicamentos.txt_idclientemedic.setText(id);
       frm_facturacion_medicamentos.txt_nombreclientemedic.setText(nombre);
       frm_facturacion_medicamentos.txt_apellidosclientemedic.setText(apellidos);
       
      
     
        }
        //Mensaje de error
        catch (Exception ex){
        JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void tbl_clienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_clienteMousePressed

    private void tbl_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_clienteKeyPressed

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
            java.util.logging.Logger.getLogger(frm_buscar_cliente_medicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_buscar_cliente_medicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_buscar_cliente_medicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_buscar_cliente_medicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        //Evento para visualizar la pantalla de búsqueda
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_buscar_cliente_medicamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptarclientemedic;
    private javax.swing.JPanel jp_contenedor;
    private javax.swing.JScrollPane jsc_tblcliente;
    private javax.swing.JTable tbl_cliente;
    // End of variables declaration//GEN-END:variables
}
