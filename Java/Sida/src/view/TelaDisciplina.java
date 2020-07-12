/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import dao.disciplina.DisciplinaCursoDAO;
import dao.disciplina.DisciplinaDAO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Curso;
import model.Disciplina;
import model.disciplina.DisciplinaCurso;

/**
 *
 * @author Andreson
 */
public class TelaDisciplina extends javax.swing.JFrame {
    private int op = 0;
   
    private ArrayList<Disciplina> listaBeans1;
    private ArrayList<Curso> listaBeans2;// adicionar curso
    private ArrayList<DisciplinaCurso> listaBeans3; 
    private int indexTable;
    public static String codigoDisc;
    
    public TelaDisciplina() {
        initComponents();
        
        inicializarArray();
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
        txtCargaHoraria = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxCursos = new javax.swing.JComboBox<String>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnAdicionarCurso = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnExcluirCurso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Disciplina");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel1)
                .addContainerGap(362, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel2.setText("Sigla");

        jLabel3.setText("Descrição");

        jLabel4.setText("Carga Horária");

        txtSigla.setEnabled(false);

        txtDescricao.setEnabled(false);

        txtCargaHoraria.setEnabled(false);

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
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setText("Curso");

        cbxCursos.setEnabled(false);

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sigla", "Descrição", "Carga Horária"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela);

        btnAdicionarCurso.setText("Adicionar Cursos");
        btnAdicionarCurso.setEnabled(false);
        btnAdicionarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCursoActionPerformed(evt);
            }
        });

        jLabel6.setText("Cursos Adicionados");

        btnExcluirCurso.setText("Excluir");
        btnExcluirCurso.setEnabled(false);
        btnExcluirCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAdicionarCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCargaHoraria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluirCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnNovo)
                    .addComponent(btnCancelar))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCursoActionPerformed
        // TODO add your handling code here:
        TelaListaCurso c1 = new TelaListaCurso();
        c1.setVisible(true);
        c1.setTelaDisciplina(this);
    }//GEN-LAST:event_btnAdicionarCursoActionPerformed

    private void btnExcluirCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCursoActionPerformed
        // TODO add your handling code here:
        
        try {
            DisciplinaCursoDAO dao = new DisciplinaCursoDAO();
            DisciplinaCurso bean = new DisciplinaCurso(txtSigla.getText(),cbxCursos.getSelectedItem().toString());
            dao.excluir(bean);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int indexCbx = cbxCursos.getSelectedIndex();
        System.out.println("index: "+indexCbx);
        if(indexCbx != -1){
            cbxCursos.removeItemAt(indexCbx);
            //listaBeans2.remove(indexCbx);
        }
        if(indexCbx == 0){
            cbxCursos.removeAllItems();
        }
        try {
            DisciplinaCursoDAO dao = new DisciplinaCursoDAO();
            listaBeans3 = dao.consultarDescricao(txtSigla.getText());
            
            for (DisciplinaCurso disciplinaCurso : listaBeans3) {
                addItemComboBox(disciplinaCurso.getCursigla());
            } 
        } catch (Exception e) {
        }
        habilitarBtnExcluirCurso();
           
    }//GEN-LAST:event_btnExcluirCursoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        inicializarArray();
        if(verificarCampos()){
                    //caso op seja igual a 0, cadastra o bean
                    System.out.println("op = "+op);
                    if(op  == 0){
                        System.out.println("salvar");
                        Disciplina bean = new Disciplina();
                        
                        bean.setSigla(txtSigla.getText());
                        bean.setDescricao(txtDescricao.getText());
                        try {
                             bean.setCargahoraria(Integer.parseInt(txtCargaHoraria.getText()));
                        } catch (Exception e) {
                            showMsg("Carga Horária é numerica");
                        }
                        try { 
                            
                            DisciplinaDAO dao1 = new DisciplinaDAO();
                            DisciplinaCursoDAO dao2 = new DisciplinaCursoDAO();
                            boolean ok = dao1.cadastrar(bean);                       
                            System.out.println("----------CADASTRANDO----------");
                            
                            int tamanho = cbxCursos.getItemCount();
                            for (int i = 0; i < tamanho; i ++) {
                               DisciplinaCurso bean2 = new DisciplinaCurso();
                               bean2.setDissigla(bean.getSigla()); 
                               bean2.setCursigla(cbxCursos.getItemAt(i));
                               listaBeans3.add(bean2);   
                            }                    
                            dao2.cadastrar(listaBeans3);
                            
                            if(ok){
                                
                                showMsg("Cadastro realizado com sucesso!");;
                                limparTudo();
                                atualizaBtn(true,false,false,false);
                                atualizaCampos(false,false,false);
                            }else{
                                showMsg("Erro ao cadastrar!");
                            }                           
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }                        
                    //caso seja diferente de 0, atualiza o bean
                    }else{
                        System.out.println("alterar");
                        Disciplina bean = listaBeans1.get(indexTable);
                        bean.setSigla(txtSigla.getText());
                        bean.setDescricao(txtDescricao.getText());
                        try {
                             bean.setCargahoraria(Integer.parseInt(txtCargaHoraria.getText()));
                        } catch (Exception e) {
                            showMsg("Carga Horária é numerica");
                        }    
                        
                    try {
                            DisciplinaDAO dao1 = new DisciplinaDAO();
                            
                            boolean ok = dao1.alterar(bean);   
                            DisciplinaCursoDAO dao2 = new DisciplinaCursoDAO();
                            System.out.println("----------CADASTRANDO----------");
                            int tamanho = cbxCursos.getItemCount();
                            for (int i = 0; i < tamanho; i ++) {
                                System.out.println(i+"iii");
                               DisciplinaCurso bean2 = new DisciplinaCurso();
                               bean2.setDissigla(bean.getSigla()); 
                               bean2.setCursigla(cbxCursos.getItemAt(i));
                               listaBeans3.add(bean2);   
                            }
                            
                            dao2.cadastrar(listaBeans3);
                            
                            if(ok){
                                showMsg("Atualizado com sucesso!");
                                limparTudo();
                            }else{
                                showMsg("Erro ao atualizar!");
                            }  
                            
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    //atualiza a tabela
                    carregaTabela();
                 }
            }else{                    
                showMsg("Preencha todos os campos!");
            }   
        limparTudo();
        carregaTabela();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        op = 0;
        cbxCursos.removeAllItems();
        limpaCampos();
        atualizaCampos(true, true, true);
        atualizarCamposCurso(true);
        atualizaBtn(false, true, true, true);
        txtSigla.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        try {
            DisciplinaDAO dao = new DisciplinaDAO();
            dao.excluir(txtSigla.getText());
            carregaTabela();
        } catch (Exception e) {
            System.out.println("Erro:"+e.getMessage());
        }
        limparTudo();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limparTudo();
        atualizaBtn(true, false, false, false);
        atualizaCampos(false, false, false);
        atualizarCamposCurso(false);
        txtPesquisar.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        op = 1;
        cbxCursos.removeAllItems();
        indexTable = tabela.getSelectedRow();
        Disciplina bean = listaBeans1.get(indexTable);
        
        txtSigla.setText(bean.getSigla());
        txtDescricao.setText(bean.getDescricao());
        txtCargaHoraria.setText(Integer.toString(bean.getCargahoraria()));
      
        try {
            DisciplinaCursoDAO dao = new DisciplinaCursoDAO();
            listaBeans3 = dao.consultarDescricao(txtSigla.getText());
            
            for (DisciplinaCurso disciplinaCurso : listaBeans3) {
                addItemComboBox(disciplinaCurso.getCursigla());
            }
            
        } catch (Exception ex) {
        }
        atualizaBtn(false, true, true, true);
        atualizaCampos(false, true, true);
        atualizarCamposCurso(true);
        
    }//GEN-LAST:event_tabelaMouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        carregaTabela();
    }//GEN-LAST:event_btnPesquisarActionPerformed
    
     private void carregaTabela(){
        try {
                DisciplinaDAO dao = new DisciplinaDAO();
                listaBeans1 = dao.consultarDescricao(txtPesquisar.getText());        
                Vector linhas = new Vector();
                Vector colunas = new Vector();                
                colunas.add("Sigla");
                colunas.add("Descrição");
                colunas.add("Carga Horária");
                
                for (Disciplina bean : listaBeans1) {
                    Vector linha = new Vector();
                    linha.add(bean.getSigla());
                    linha.add(bean.getDescricao());
                    linha.add(bean.getCargahoraria());
                    linhas.add(linha);
                }
                          
                DefaultTableModel model = new DefaultTableModel(linhas, colunas);
                tabela.setModel(model);
            } catch (Exception ex) {
                System.out.println("Erro carregar tabela: "+ex.getMessage());
            }
    }
    
//    private void preencherListBeans2(String ){
//        listaBeans2.add(c1);
//    }
    
    private boolean verificarCampos(){
        if(!txtSigla.getText().trim().isEmpty() &&
           !txtDescricao.getText().trim().isEmpty() &&
           !txtCargaHoraria.getText().trim().isEmpty()){
              return true;  
           }
              return false;  
    }
    
    public void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    public void addItemComboBox(String sigla){
        cbxCursos.addItem(sigla);
        int indexCbx = cbxCursos.getItemCount();
        cbxCursos.setSelectedIndex(indexCbx-1);
        habilitarBtnExcluirCurso();
    }
    public int getCmbSize(){
        return cbxCursos.getItemCount();
    }
    
    
    public boolean checkIfIsTheSame(String sigla){
        for(int i=0;i<cbxCursos.getItemCount();i++){
            if(sigla.equals(cbxCursos.getItemAt(i))){
                return true;
            }
        }
        return false;
    }
    
    private void atualizaCampos(boolean txt1,boolean txt2,boolean txt3){
        txtSigla.setEnabled(txt1);
        txtDescricao.setEnabled(txt2);
        txtCargaHoraria.setEnabled(txt3);
    }
    
    private void atualizarCamposCurso(boolean btn1){
        //cbxCursos.setEnabled(cbx1);
        btnAdicionarCurso.setEnabled(btn1);
        habilitarBtnExcluirCurso();
       
    };
    
    private void habilitarBtnExcluirCurso(){
         int indexCbx = cbxCursos.getSelectedIndex();
         if(indexCbx == -1){
            btnExcluirCurso.setEnabled(false);
            cbxCursos.setEnabled(false);
         }else{
             btnExcluirCurso.setEnabled(true);
             cbxCursos.setEnabled(true);
         }
    }
    
    
    private void atualizaBtn(boolean btn1,boolean btn2,boolean btn3,boolean btn4){
        btnNovo.setEnabled(btn1);
        btnSalvar.setEnabled(btn2);
        btnExcluir.setEnabled(btn3);
        btnCancelar.setEnabled(btn4);
    }
    
    private void limpaCampos(){
        txtSigla.setText("");
        txtDescricao.setText("");
        txtCargaHoraria.setText("");
        cbxCursos.removeAllItems();
    }
   
    private void limparTudo(){
        limpaCampos();
        cbxCursos.removeAllItems();
        listaBeans2.clear();
        listaBeans3.clear();
        habilitarBtnExcluirCurso();
        atualizaCampos(false, false, false);
        atualizaBtn(true, false, false, false);
        atualizarCamposCurso(false);
    } 
    
    private void inicializarArray(){
        //listaBeans1 = new ArrayList();
        listaBeans2 = new ArrayList();
        listaBeans3 = new ArrayList();
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
            java.util.logging.Logger.getLogger(TelaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDisciplina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCurso;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluirCurso;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCargaHoraria;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtSigla;
    // End of variables declaration//GEN-END:variables
}
