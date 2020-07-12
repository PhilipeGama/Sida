/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CursoDAO;
import dao.TurmaDAO;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Curso;
import model.Turma;

/**
 *
 * @author Andreson
 */
public class TelaTurma extends javax.swing.JFrame {
    private int op = 0;
    private ArrayList<Turma> listaTurma;
    public TelaTurma() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSigla = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        cmbTurno = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Turma");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel2.setText("Sigla");

        jLabel3.setText("Descricao");

        jLabel4.setText("Turno");

        txtSigla.setEnabled(false);

        txtDescricao.setEnabled(false);

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");

        cmbTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matutino", "Vespertino", "Noturno" }));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sigla", "Descrição", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao)
                            .addComponent(cmbTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSigla)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(0, 279, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnExcluir)
                            .addComponent(btnNovo)
                            .addComponent(btnCancelar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(28, 28, 28))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        atualizaBtn(false, true, false, true);
        op = 0;
        atualizaCampos(true, true);
        cmbTurno.setEnabled(true);
        tblProduto.clearSelection();
        limpaCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        // TODO add your handling code here:
        op = 1;
        int index = tblProduto.getSelectedRow();
        Turma bean = listaTurma.get(index);
        txtSigla.setText(bean.getSigla());
        txtDescricao.setText(bean.getDescricao());
        cmbTurno.setEnabled(true);
        
        
        atualizaBtn(true, true, true, false);
        atualizaCampos(true, true);
        
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        txtSigla.setEnabled(false);
        txtDescricao.setEnabled(false);
        cmbTurno.setEnabled(false);
        atualizaBtn(true, false, false, false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(!txtSigla.getText().trim().isEmpty() && !txtDescricao.getText().trim().isEmpty()){
                    //caso op seja igual a 0, cadastra o bean
                    if(op  == 0){
                        Turma bean = new Turma();
                        bean.setSigla(txtSigla.getText());
                        bean.setDescricao(txtDescricao.getText());
                        bean.setTurno((String) cmbTurno.getSelectedItem());
                        try { 
                            TurmaDAO dao = new TurmaDAO();         
                            boolean ok = dao.cadastrar(bean);
                            
                            if(ok){
                                showMsg("Cadastro realizado com sucesso!");;
                                limpaCampos();
                                atualizaBtn(true,false,false,false);
                                atualizaCampos(false, false);
                               
                            }else{
                                showMsg("Erro ao cadastrar!");
                            }                           
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    //caso seja diferente de 0, atualiza o bean
                        
                    //caso seja diferente de 0, atualiza o bean
                    }else{
                        int index = tblProduto.getSelectedRow();
                        Turma bean = listaTurma.get(index);
                        bean.setSigla(txtSigla.getText());
                        bean.setDescricao(txtDescricao.getText());
                        bean.setTurno((String) cmbTurno.getSelectedItem());
                        try {
                            TurmaDAO dao = new TurmaDAO();
                            boolean ok = dao.alterar(bean);
                            if(ok){
                                showMsg("Atualizado com sucesso!");
                                limpaCampos();
                                atualizaBtn(true,false,false,false);
                            }else{
                                showMsg("Erro ao atualizar!");
                            }  
                            
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
              }
                    //atualiza a tabela
                    carregaTabela();
            }else{                    
                showMsg("Preencha todos os campos!");
            }                                   
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Deseja proseguir?", "Selecione a opção desejada: ",JOptionPane.YES_NO_OPTION);
        int index = tblProduto.getSelectedRow();
        Turma bean = listaTurma.get(index);
        
        try {
            TurmaDAO dao = new TurmaDAO();             
            boolean ok = dao.excluir(bean.getSigla());
            if(ok){
                carregaTabela();
                showMsg("Excluido com sucesso!");
                limpaCampos();                    
                atualizaBtn(true,false,false,false);

            }
        } catch (Exception ex) {
            showMsg("Erro ao excluir!");
        }
       
    }//GEN-LAST:event_btnExcluirActionPerformed
    private void carregaTabela(){
        try {
                TurmaDAO dao = new TurmaDAO();
                listaTurma = dao.consultar(txtPesquisar.getText());
                
                Vector linhas = new Vector();
                Vector colunas = new Vector();                
                colunas.add("Sigla");
                colunas.add("Descrição");
                colunas.add("Turno");

                for (Turma bean : listaTurma) {
                    Vector linha = new Vector();
                    linha.add(bean.getSigla());
                    linha.add(bean.getDescricao());
                    linha.add(bean.getTurno());
                    linhas.add(linha);
                }
                          
                DefaultTableModel model = new DefaultTableModel(linhas, colunas);
                tblProduto.setModel(model);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    }
    

    public String getTxtDescricao() {
        return txtSigla.getText();
    }

    public void setTxtDescricao(String txtDescricao) {
        this.txtSigla.setText(txtDescricao);
    }

    public String getTxtPesquisar() {
        return txtPesquisar.getText();
    }

    public String getTxtQuantidade() {
        return txtDescricao.getText();
    }

    public void setTxtQuantidade(String txtQuantidade) {
        this.txtDescricao.setText(txtQuantidade);
    }

    
    
    public int getTableCursor(){
        return this.tblProduto.getSelectedRow();
    }
          
    public void addTblProdutoListener(MouseListener listener){
        this.tblProduto.addMouseListener(listener);
    }
    
    public void setTblProduto(DefaultTableModel model){
        this.tblProduto.setModel(model);
    }
    
    public void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    //adiciona ação do botão
    
    public void addBtnPesquisarListener(ActionListener listener){
        this.btnPesquisar.addActionListener(listener);
    }
    
    public void addBtnNovoListener(ActionListener listener){
        this.btnNovo.addActionListener(listener);
    }
    
    public void addBtnSalvarListener(ActionListener listener){
        this.btnSalvar.addActionListener(listener);
    }
    
    public void addBtnExcluirListener(ActionListener listener){
        this.btnExcluir.addActionListener(listener);
    }
    
    public void addBtnCancelarListener(ActionListener listener){
        this.btnCancelar.addActionListener(listener);
    }
        
    //habilitar/desabilitar botões
    
    public void btnNovoEnabled(boolean ok){
        this.btnNovo.setEnabled(ok);
    }
    
    public void btnSalvarEnabled(boolean ok){
        this.btnSalvar.setEnabled(ok);
    }
    
    public void btnExcluirEnabled(boolean ok){
        this.btnExcluir.setEnabled(ok);
    }
    
    public void btnCancelarEnabled(boolean ok){
        this.btnCancelar.setEnabled(ok);
    }
    
    //habilitar/desabilitar campos
    
    public void txtDescricaoEnabled(boolean ok){
        this.txtSigla.setEnabled(ok);
    }
    
    public void txtQuantidadeEnabled(boolean ok){
        this.txtDescricao.setEnabled(ok);
    }
    private void atualizaBtn(boolean btn1,boolean btn2,boolean btn3,boolean btn4){
        btnNovo.setEnabled(btn1);
        btnSalvar.setEnabled(btn2);
        btnExcluir.setEnabled(btn3);
        btnCancelar.setEnabled(btn4);
    }
    private void atualizaCampos(boolean txt1,boolean txt2){
       txtDescricao.setEnabled(txt1);
       txtSigla.setEnabled(txt2);    
    }
    
    private void limpaCampos(){
        txtSigla.setText("");
        txtDescricao.setText("");
        txtPesquisar.setText("");
    } 
    
    
 
      
    
    
    
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
            java.util.logging.Logger.getLogger(TelaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtSigla;
    // End of variables declaration//GEN-END:variables
}
