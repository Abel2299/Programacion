/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.banco.vista;

import com.sauces.banco.controlador.Controlador;
import com.sauces.banco.modelo.Cuenta;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author daw1
 */
public class MiVentana extends javax.swing.JFrame {
    
    private DialogoCuenta dialogo = new DialogoCuenta(this,true);
    private Controlador controlador;
    
    /**
     * Creates new form MiVentana
     */
    public MiVentana() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        SelectorFichero = new javax.swing.JFileChooser();
        PanelCuenta = new javax.swing.JPanel();
        CodigoTitulo = new javax.swing.JLabel();
        CodigoTexto = new javax.swing.JTextField();
        TitulatTitulo = new javax.swing.JLabel();
        SaldoTitulo = new javax.swing.JLabel();
        TitualrTexto = new javax.swing.JTextField();
        SaldoText = new javax.swing.JTextField();
        PanelListadoCuenta = new javax.swing.JPanel();
        tablaListadoCuentas = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuArriba = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        Abrir = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        menuBanco = new javax.swing.JMenu();
        AbrirCuenta = new javax.swing.JMenuItem();
        Operar = new javax.swing.JMenuItem();
        Cancelar = new javax.swing.JMenuItem();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PanelCuenta.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuenta"));

        CodigoTitulo.setText("CODIGO");
        CodigoTitulo.setToolTipText("CODIGO");

        TitulatTitulo.setText("TITULAR");

        SaldoTitulo.setText("SALDO");

        javax.swing.GroupLayout PanelCuentaLayout = new javax.swing.GroupLayout(PanelCuenta);
        PanelCuenta.setLayout(PanelCuentaLayout);
        PanelCuentaLayout.setHorizontalGroup(
            PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodigoTitulo)
                    .addComponent(TitulatTitulo)
                    .addComponent(SaldoTitulo))
                .addGap(18, 18, 18)
                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodigoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TitualrTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaldoText, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCuentaLayout.setVerticalGroup(
            PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodigoTitulo)
                    .addComponent(CodigoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitulatTitulo)
                    .addComponent(TitualrTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaldoTitulo)
                    .addComponent(SaldoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        PanelListadoCuenta.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de cuentas"));

        cuentaTM = new CuentaTableModel();
        jTable1.setModel(cuentaTM);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tablaListadoCuentas.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout PanelListadoCuentaLayout = new javax.swing.GroupLayout(PanelListadoCuenta);
        PanelListadoCuenta.setLayout(PanelListadoCuentaLayout);
        PanelListadoCuentaLayout.setHorizontalGroup(
            PanelListadoCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelListadoCuentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tablaListadoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelListadoCuentaLayout.setVerticalGroup(
            PanelListadoCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListadoCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaListadoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );

        menuArchivo.setText("Archivo");

        Abrir.setText("Abrir...");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(Abrir);

        Guardar.setText("Guardar...");
        menuArchivo.add(Guardar);

        Salir.setText("Salir");
        menuArchivo.add(Salir);

        jMenuArriba.add(menuArchivo);

        menuBanco.setText("Banco");

        AbrirCuenta.setText("Abrir cuenta");
        AbrirCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirCuentaActionPerformed(evt);
            }
        });
        menuBanco.add(AbrirCuenta);

        Operar.setText("Operar con cuenta");
        Operar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperarActionPerformed(evt);
            }
        });
        menuBanco.add(Operar);

        Cancelar.setText("Cancelar cuenta");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        menuBanco.add(Cancelar);

        jMenuArriba.add(menuBanco);

        setJMenuBar(jMenuArriba);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelListadoCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListadoCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void mostrar(){
        setVisible(true);
    }
    
    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        if(this.SelectorFichero.showOpenDialog(Abrir) == JFileChooser.APPROVE_OPTION){
            String nombre = SelectorFichero.getSelectedFile().getName();
            JOptionPane.showMessageDialog(this, nombre);
        }
    }//GEN-LAST:event_AbrirActionPerformed

    private void AbrirCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirCuentaActionPerformed
        //dialogo.setVisible(true);
        if(this.dialogo.mostrar() == dialogo.ACEPTAR){  //DialogoCuenta.ACEPTAR 
            this.CodigoTexto.setText(dialogo.getCodigo());
            this.TitualrTexto.setText(dialogo.getTitular());
            this.SaldoText.setText(Float.toString(dialogo.getSaldo()));
            controlador.abrirCuenta();
        }
    }//GEN-LAST:event_AbrirCuentaActionPerformed

    private void OperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperarActionPerformed
         
    }//GEN-LAST:event_OperarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
       controlador.cancelarCuenta();
        this.CodigoTexto.setText("");
        this.SaldoText.setText("");
        this.TitualrTexto.setText("");
        this.actualizarTabla();
    }//GEN-LAST:event_CancelarActionPerformed

    //private MiVentana vista;
        
    
    // metodo que permite fijar el controlador
    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }
    
    
    
    
    public String getCodigo(){
        return this.CodigoTexto.getText();
    }
    
    public String getTitular(){
        return this.TitualrTexto.getText();
    }
    
    public float getSaldo(){
        return Float.parseFloat(this.SaldoText.getText());
    }
    
    public int getOperacion(){
        return JOptionPane.showOptionDialog(this,"Operacion a realizar", "Operar con cuenta", WIDTH, HEIGHT, null, new String[]{"Ingresar","Reintegrar"}, "xx");
    }
    
    public float getCantidad(){
        return Float.parseFloat(JOptionPane.showInputDialog(this, "Introduzca cantidad"));
    }
    
    public String getArchivo(){
        return null;
    }
    
    public void mostrarCuentas(List<Cuenta> listado){
        cuentaTM.setCuentas(listado);
    }
    
    public void actualizarTabla(){
        this.tablaListadoCuentas.revalidate();
    }
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MiVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MiVentana().setVisible(true);
            }
        });
    }

   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JMenuItem AbrirCuenta;
    private javax.swing.JMenuItem Cancelar;
    private javax.swing.JTextField CodigoTexto;
    private javax.swing.JLabel CodigoTitulo;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem Operar;
    private javax.swing.JPanel PanelCuenta;
    private javax.swing.JPanel PanelListadoCuenta;
    private javax.swing.JTextField SaldoText;
    private javax.swing.JLabel SaldoTitulo;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JFileChooser SelectorFichero;
    private javax.swing.JTextField TitualrTexto;
    private javax.swing.JLabel TitulatTitulo;
    private javax.swing.JMenuBar jMenuArriba;
    private CuentaTableModel cuentaTM;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuBanco;
    private javax.swing.JScrollPane tablaListadoCuentas;
    // End of variables declaration//GEN-END:variables
}
