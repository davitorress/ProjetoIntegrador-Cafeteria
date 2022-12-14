/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Atendente;
import Model.Comanda;
import Model.Estoque;
import Model.ItensComanda;
import Model.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fatec_aluno
 */
public class FComandaAdmin extends javax.swing.JFrame {

    Estoque est = new Estoque();
    Produto prod = new Produto();
    Atendente func = new Atendente();
    Comanda ped = new Comanda();
    ItensComanda it = new ItensComanda();
    
    private double valorTotal = 0;
    
    /**
     * Creates new form FComandaAdmin
     */
    public FComandaAdmin() {
        initComponents();
        
        // BLOQUEIO DOS CAMPOS DOS ITENS DA COMANDA
        txtNomeProduto.setEditable(false);
        txtPrecoProduto.setEditable(false);
        txtTotalProduto.setEditable(false);
    }
    
    private void limparCampos() {
        txtNomeProduto.setText("");
        txtPrecoProduto.setText("");
        txtQuantidadeProduto.setValue(1);
        txtTotalProduto.setText("");
        txtPesquisarProduto.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPesquisarProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNomeProduto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        txtPrecoProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtQuantidadeProduto = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        txtTotalProduto = new javax.swing.JTextField();
        btnAdicionarItem = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItensComanda = new javax.swing.JTable();
        lblTotalPedido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comanda - Admin");

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
        imgVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgVendasMouseClicked(evt);
            }
        });

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
                .addContainerGap(48, Short.MAX_VALUE))
        );

        lblIdComanda.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        lblIdComanda.setForeground(new java.awt.Color(255, 255, 255));
        lblIdComanda.setText("Comanda:");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login do Funcion??rio:");

        txtLogin.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pesquisar:");

        txtPesquisarProduto.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        txtPesquisarProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarProdutoKeyReleased(evt);
            }
        });

        tblNomeProduto.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        tblNomeProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome"
            }
        ));
        tblNomeProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNomeProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNomeProduto);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Itens:");

        btnFinalizar.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btnFinalizar.setText("Finalizar Pedido");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar Compra");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nome:");

        txtNomeProduto.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        txtPrecoProduto.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pre??o Unit??rio:");

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantidade:");

        txtQuantidadeProduto.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        txtQuantidadeProduto.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        txtQuantidadeProduto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtQuantidadeProdutoStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total do Produto:");

        txtTotalProduto.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        btnAdicionarItem.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btnAdicionarItem.setText("Adicionar ao Pedido");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        btnLimparCampos.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimparCamposMouseClicked(evt);
            }
        });

        tblItensComanda.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        tblItensComanda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade", "Pre??o Total"
            }
        ));
        tblItensComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItensComandaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblItensComanda);

        lblTotalPedido.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        lblTotalPedido.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPedido.setText("Total: R$ 00.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(menuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIdComanda)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtLogin)
                    .addComponent(txtPesquisarProduto)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addGap(150, 150, 150)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(93, 93, 93)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblTotalPedido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel7))
                            .addGap(40, 40, 40)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6)
                                .addComponent(txtPrecoProduto)
                                .addComponent(txtTotalProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)))
                .addGap(0, 124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdComanda)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrecoProduto)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtLogin))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTotalProduto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTotalPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void imgSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgSairMouseClicked
        this.dispose();
        new FLogin().setVisible(true);
    }//GEN-LAST:event_imgSairMouseClicked

    private void imgHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgHomeMouseClicked
        this.dispose();
        new FHomeAdmin().setVisible(true);
    }//GEN-LAST:event_imgHomeMouseClicked

    private void imgEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEstoqueMouseClicked
        this.dispose();
        new FProdutos().setVisible(true);
    }//GEN-LAST:event_imgEstoqueMouseClicked

    private void imgFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgFuncionariosMouseClicked
        this.dispose();
        new FFuncionarios().setVisible(true);
    }//GEN-LAST:event_imgFuncionariosMouseClicked

    private void imgVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgVendasMouseClicked
        this.dispose();
        new FVendas().setVisible(true);
    }//GEN-LAST:event_imgVendasMouseClicked

    private void txtPesquisarProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarProdutoKeyReleased
        ResultSet retornoProdutos = prod.consultarNome(txtPesquisarProduto.getText());
        DefaultTableModel tabela = (DefaultTableModel) tblNomeProduto.getModel();
        tabela.setNumRows(0);
        
        try {
            do {
                tabela.addRow(new String[]{retornoProdutos.getString(2)});
            } while(retornoProdutos.next());
        } catch(SQLException ex) {
            Logger.getLogger(FHomeFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPesquisarProdutoKeyReleased

    private void tblNomeProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNomeProdutoMouseClicked
        int campo = tblNomeProduto.getSelectedRow();
        ResultSet retornoProdutos = prod.consultarNome(tblNomeProduto.getValueAt(campo, 0).toString());
        
        try {
            do {          
                ResultSet retornoEstoque = est.consultar(Integer.parseInt(retornoProdutos.getString(1)));
                
                txtNomeProduto.setText(retornoProdutos.getString(2));
                txtPrecoProduto.setText(retornoProdutos.getString(3));
                txtQuantidadeProduto.setModel(new SpinnerNumberModel(1, 1, Integer.parseInt(retornoEstoque.getString(2)), 1));
                
                double total = Integer.parseInt(txtQuantidadeProduto.getValue().toString()) * Double.parseDouble(txtPrecoProduto.getText());
                txtTotalProduto.setText(String.valueOf(total));
            } while(retornoProdutos.next());
        } catch(SQLException ex) {
            Logger.getLogger(FHomeFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblNomeProdutoMouseClicked

    private void btnLimparCamposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparCamposMouseClicked
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposMouseClicked

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        if(!txtNomeProduto.getText().equals("")) {
            ResultSet retornoProdutos = prod.consultarNome(txtNomeProduto.getText());
            DefaultTableModel tabela = (DefaultTableModel) tblItensComanda.getModel();
            
            try {
                ResultSet retornoEstoque = est.consultar(Integer.parseInt(retornoProdutos.getString(1)));
                if(Integer.parseInt(retornoEstoque.getString(2)) >= Integer.parseInt(txtQuantidadeProduto.getValue().toString())) {
                    valorTotal = valorTotal + Double.parseDouble(txtTotalProduto.getText());
                    tabela.addRow(new String[]{retornoProdutos.getString(1), retornoProdutos.getString(2), txtQuantidadeProduto.getValue().toString(), txtTotalProduto.getText()});

                    est.diminuirEstoque(Integer.parseInt(retornoEstoque.getString(1)), Integer.parseInt(txtQuantidadeProduto.getValue().toString()));
                } else {
                    JOptionPane.showMessageDialog(null, "Estoque Indispon??vel! M??ximo: " + retornoEstoque.getString(2));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FComandaFunc.class.getName()).log(Level.SEVERE, null, ex);
            }

            lblTotalPedido.setText("Total: R$ " + valorTotal);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para adicionar na comanda!");
        }
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        valorTotal = 0.00;
        lblTotalPedido.setText("Total: R$ 0.00");
        DefaultTableModel tabela = (DefaultTableModel) tblItensComanda.getModel();
        
        int linhas = tabela.getRowCount();
        for(int i = 0; i < linhas; i++) {
            est.aumentarEstoque(Integer.parseInt(tabela.getValueAt(0, 0).toString()), Integer.parseInt(tabela.getValueAt(0, 2).toString()));
            tabela.removeRow(0);
        }
        
        JOptionPane.showMessageDialog(null, "Comanda cancelada com sucesso!");
        limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtQuantidadeProdutoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtQuantidadeProdutoStateChanged
        txtTotalProduto.setText(String.valueOf(Integer.parseInt(txtQuantidadeProduto.getValue().toString()) * Double.parseDouble(txtPrecoProduto.getText())));
    }//GEN-LAST:event_txtQuantidadeProdutoStateChanged

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if(!txtLogin.getText().equals("")) {
            ResultSet retornarAtendente = func.buscarIdPeloLogin(txtLogin.getText());
            try {
                if(retornarAtendente.isFirst()) {
                    ped.criarComanda(Integer.parseInt(retornarAtendente.getString(1)));
                    ResultSet retornarComanda = ped.consultarIdComanda(Integer.parseInt(retornarAtendente.getString(1)));
                    
                    DefaultTableModel tabela = (DefaultTableModel) tblItensComanda.getModel();
                    int linhas = tabela.getRowCount();
                    for(int i = 0; i < linhas; i++) {
                        it.criarItemComanda(
                            Integer.parseInt(tabela.getValueAt(0, 2).toString()), 
                            Double.parseDouble(tabela.getValueAt(0, 3).toString()), 
                            Integer.parseInt(retornarComanda.getString(1)), 
                            Integer.parseInt(tabela.getValueAt(0, 0).toString())
                        );
                        tabela.removeRow(0);
                    }
                
                    limparCampos();
                    JOptionPane.showMessageDialog(null, "Comanda finalizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Login inv??lido!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FComandaFunc.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Para finalizar o pedido ?? necess??rio digitar o seu login no campo!");
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void tblItensComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItensComandaMouseClicked
        int campo = tblItensComanda.getSelectedRow();
        
        DefaultTableModel tabela = (DefaultTableModel) tblItensComanda.getModel();
        est.aumentarEstoque(Integer.parseInt(tabela.getValueAt(campo, 0).toString()), Integer.parseInt(tabela.getValueAt(campo, 2).toString()));
        tabela.removeRow(campo);
        JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
    }//GEN-LAST:event_tblItensComandaMouseClicked

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
            java.util.logging.Logger.getLogger(FComandaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FComandaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FComandaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FComandaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FComandaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JLabel imgComanda;
    private javax.swing.JLabel imgEstoque;
    private javax.swing.JLabel imgFuncionarios;
    private javax.swing.JLabel imgHome;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgSair;
    private javax.swing.JLabel imgVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIdComanda;
    private javax.swing.JLabel lblTotalPedido;
    private javax.swing.JPanel menuBar;
    private javax.swing.JTable tblItensComanda;
    private javax.swing.JTable tblNomeProduto;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPesquisarProduto;
    private javax.swing.JTextField txtPrecoProduto;
    private javax.swing.JSpinner txtQuantidadeProduto;
    private javax.swing.JTextField txtTotalProduto;
    // End of variables declaration//GEN-END:variables
}
