/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Comanda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author davia
 */
public class FVendas extends javax.swing.JFrame {

    Comanda ped = new Comanda();
    
    public String construirData(String dia, String mes, String ano) {
        String dataComanda = "";
        
        if(ano.equals("")) {
            dataComanda = dataComanda + "%-";
        } else {
            dataComanda = dataComanda + ano + "-";
        }
        
        if(mes.equals("")) {
            dataComanda = dataComanda + "%-";
        } else {
            dataComanda = dataComanda + mes + "-";
        }
        
        if(dia.equals("")) {
            dataComanda = dataComanda + "%";
        } else {
            dataComanda = dataComanda + dia;
        }
        
        return dataComanda;
    }
    
    public void listagemDeVendas() {
        ResultSet retornoVendas;
        
        String dataComanda = construirData(txtDia.getText(), txtMes.getText(), txtAno.getText());
        
        String hora;
        if(Integer.parseInt(txtHora.getValue().toString()) == 0) {
            hora = "%";
        } else {
            if(Integer.parseInt(txtHora.getValue().toString()) < 10) {
                hora = "0" + txtHora.getValue().toString() + "%";
            } else {
                hora = txtHora.getValue().toString() + "%";
            }
        }
        
        String func;
        if(txtFunc.getText().equals("")) {
            func = "%";
        } else {
            func = txtFunc.getText();
        }
        
        retornoVendas = ped.listarVendas(dataComanda, hora, func);
        
        DefaultTableModel tabelaVendas = (DefaultTableModel) tblVendas.getModel();
        tabelaVendas.setNumRows(0);

        try {
            do {
                tabelaVendas.addRow(new String[]{retornoVendas.getString(1), retornoVendas.getString(2), retornoVendas.getString(3), retornoVendas.getString(4), retornoVendas.getString(5)});
            } while(retornoVendas.next());
        } catch(SQLException ex) {
            Logger.getLogger(FHomeFunc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não existem vendas realizadas com estes filtros!");
        }
        
        listagemFiltro();
    }
    
    public void listagemFiltro() {
        if(txtFiltro.getSelectedIndex() == 0) {
            ResultSet retornoFiltro = ped.listarVendasTotais();
            DefaultTableModel tabelaFiltro = (DefaultTableModel) tblFiltro.getModel();
            tabelaFiltro.setNumRows(0);

            try {
                do {
                    tabelaFiltro.addRow(new String[]{txtFiltro.getSelectedItem().toString(), retornoFiltro.getString(2), retornoFiltro.getString(1)});
                } while(retornoFiltro.next());
            } catch(SQLException ex) {
                Logger.getLogger(FHomeFunc.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Não existem vendas realizadas!");
            }
        } else {
            ResultSet retornoFiltro = ped.listarVendasProduto();
            DefaultTableModel tabelaFiltro = (DefaultTableModel) tblFiltro.getModel();
            tabelaFiltro.setNumRows(0);

            try {
                do {
                    tabelaFiltro.addRow(new String[]{retornoFiltro.getString(3), retornoFiltro.getString(2), retornoFiltro.getString(1)});
                } while(retornoFiltro.next());
            } catch(SQLException ex) {
                Logger.getLogger(FHomeFunc.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Não existem vendas realizadas!");
            }
        }
    }
    
    /**
     * Creates new form FVendas
     */
    public FVendas() {
        initComponents();
        
        // LISTAGEM DE VENDAS
        ResultSet retornoVendas = ped.listarVendas("%", "%", "%");
        DefaultTableModel tabelaVendas = (DefaultTableModel) tblVendas.getModel();
        tabelaVendas.setNumRows(0);

        try {
            do {
                tabelaVendas.addRow(new String[]{retornoVendas.getString(1), retornoVendas.getString(2), retornoVendas.getString(3), retornoVendas.getString(4), retornoVendas.getString(5)});
            } while(retornoVendas.next());
        } catch(SQLException ex) {
            Logger.getLogger(FHomeFunc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não existem vendas realizadas!");
        }
        
        listagemFiltro();
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
        menuBar = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        imgHome = new javax.swing.JLabel();
        imgComanda = new javax.swing.JLabel();
        imgEstoque = new javax.swing.JLabel();
        imgFuncionarios = new javax.swing.JLabel();
        imgVendas = new javax.swing.JLabel();
        imgSair = new javax.swing.JLabel();
        lblIdComanda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHora = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        txtFunc = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFiltro = new javax.swing.JTable();
        txtFiltro = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatórios de Venda");
        setMaximumSize(new java.awt.Dimension(1300, 620));
        setMinimumSize(new java.awt.Dimension(1300, 620));
        setPreferredSize(new java.awt.Dimension(1300, 620));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(244, 148, 27));
        jPanel1.setMaximumSize(new java.awt.Dimension(1300, 620));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 620));

        menuBar.setBackground(new java.awt.Color(0, 0, 0));
        menuBar.setMaximumSize(new java.awt.Dimension(96, 620));
        menuBar.setMinimumSize(new java.awt.Dimension(96, 620));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/gemini_logo_white_60x60.png"))); // NOI18N

        imgHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/home.png"))); // NOI18N
        imgHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imgHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgHomeMouseClicked(evt);
            }
        });

        imgComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/notes.png"))); // NOI18N
        imgComanda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imgComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgComandaMouseClicked(evt);
            }
        });

        imgEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/boxes.png"))); // NOI18N
        imgEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imgEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgEstoqueMouseClicked(evt);
            }
        });

        imgFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/employee.png"))); // NOI18N
        imgFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imgFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgFuncionariosMouseClicked(evt);
            }
        });

        imgVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/sales.png"))); // NOI18N
        imgVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        imgSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/open-door.png"))); // NOI18N
        imgSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imgSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(imgLogo)
                .addGap(18, 18, 18))
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imgComanda)
                    .addComponent(imgHome)
                    .addComponent(imgEstoque)
                    .addComponent(imgFuncionarios)
                    .addComponent(imgVendas)
                    .addComponent(imgSair))
                .addGap(32, 32, 32))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(imgLogo)
                .addGap(80, 80, 80)
                .addComponent(imgHome)
                .addGap(40, 40, 40)
                .addComponent(imgComanda)
                .addGap(40, 40, 40)
                .addComponent(imgEstoque)
                .addGap(40, 40, 40)
                .addComponent(imgFuncionarios)
                .addGap(40, 40, 40)
                .addComponent(imgVendas)
                .addGap(40, 40, 40)
                .addComponent(imgSair)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        lblIdComanda.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        lblIdComanda.setForeground(new java.awt.Color(255, 255, 255));
        lblIdComanda.setText("Listagem de Vendas");

        tblVendas.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Comanda", "Funcionário", "Data", "Hora", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(tblVendas);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Filtrar por Data (Dia / Mês / Ano):");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Filtrar por Hora:");

        txtHora.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        txtHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Filtrar por Funcionário:");

        txtFunc.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        btnFiltrar.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        tblFiltro.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        tblFiltro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filtro", "Quantidade", "Valor"
            }
        ));
        jScrollPane2.setViewportView(tblFiltro);

        txtFiltro.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        txtFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendas totais", "Vendas por produtos" }));
        txtFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtFiltroItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Filtrar:");

        txtDia.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        txtMes.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        txtAno.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(menuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIdComanda)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHora)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFunc))
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrar))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addComponent(txtFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblIdComanda)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFiltro)
                    .addComponent(txtFunc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAno)
                        .addComponent(txtMes))
                    .addComponent(txtDia))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imgHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgHomeMouseClicked
        this.dispose();
        new FHomeAdmin().setVisible(true);
    }//GEN-LAST:event_imgHomeMouseClicked

    private void imgComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgComandaMouseClicked
        this.dispose();
        new FComandaAdmin().setVisible(true);
    }//GEN-LAST:event_imgComandaMouseClicked

    private void imgEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEstoqueMouseClicked
        this.dispose();
        new FProdutos().setVisible(true);
    }//GEN-LAST:event_imgEstoqueMouseClicked

    private void imgSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgSairMouseClicked
        this.dispose();
        new FLogin().setVisible(true);
    }//GEN-LAST:event_imgSairMouseClicked

    private void imgFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgFuncionariosMouseClicked
        this.dispose();
        new FFuncionarios().setVisible(true);
    }//GEN-LAST:event_imgFuncionariosMouseClicked

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        listagemDeVendas();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void txtFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtFiltroItemStateChanged
        listagemFiltro();
    }//GEN-LAST:event_txtFiltroItemStateChanged

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
            java.util.logging.Logger.getLogger(FVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JLabel imgComanda;
    private javax.swing.JLabel imgEstoque;
    private javax.swing.JLabel imgFuncionarios;
    private javax.swing.JLabel imgHome;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgSair;
    private javax.swing.JLabel imgVendas;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIdComanda;
    private javax.swing.JPanel menuBar;
    private javax.swing.JTable tblFiltro;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtDia;
    private javax.swing.JComboBox<String> txtFiltro;
    private javax.swing.JTextField txtFunc;
    private javax.swing.JSpinner txtHora;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables
}
