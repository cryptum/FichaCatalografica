package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.glass.ui.CommonDialogs;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.FichaM;
import org.jdesktop.beansbinding.Converter;
import sun.security.x509.Extension;
import util.LimiteDigitos;


public class PrincipalView extends javax.swing.JFrame {
    FichaM ficha = new FichaM();
    Document doc;
    String caminho;
    
    public PrincipalView() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        colocaDicas();
        preencheComboBox();
        LimitaDigitos();
        
        ImageIcon icone = new ImageIcon("C:/Users/NUPSI-04/Documents/NetBeansProjects/FichaCatalográficaSemBanco/src/view/imagens/iconInterno.png");
        setIconImage(icone.getImage());
    }


    public void LimitaDigitos(){
         tfdNome.setDocument(new LimiteDigitos(55));
         tfdAutor2.setDocument(new LimiteDigitos(55));
         tfdAutor3.setDocument(new LimiteDigitos(55));
         tfdTitulo.setDocument(new LimiteDigitos(160));
         tfdSubTitulo.setDocument(new LimiteDigitos(100));
         tfdNumPaginas.setDocument(new LimiteDigitos(4));
         tfdOrientador.setDocument(new LimiteDigitos(40));
         tfdCoorientador.setDocument(new LimiteDigitos(40));
         tfdPalavra1.setDocument(new LimiteDigitos(40));
         tfdPalavra2.setDocument(new LimiteDigitos(40));
         tfdPalavra3.setDocument(new LimiteDigitos(40));
    }
    
    public void colocaDicas(){
       //SetToolTipText em todos os campos para caso haja dúvidas (não deixei no painel para não deixar poluído)
       tfdNome.setToolTipText("Digite o nome do autor 1. Exemplo: Leandro Matias Baldo");
       tfdAutor2.setToolTipText("Digite o nome completo do autor 2.");
       tfdAutor3.setToolTipText("Digite o nome completo do autor 3.");
       tfdOrientador.setToolTipText("Digite o nome completo do Orientador. Exemplo: Leonardo Vieira Barcelos");
       tfdCoorientador.setToolTipText("Digite o nome completo do Orientador. Exemplo: Ivan Filho Reis");
       ckxMaisAutores.setToolTipText("Caso haja mais autores, selecione esta opção.");
       tfdTitulo.setToolTipText("Digite o Título de seu trabalho, Exemplo: Aspectos que envolvem...." );
       tfdSubTitulo.setToolTipText("Digite o SubTítulo de seu trabalho, Exemplo: Ensino e aprendizagem...." );
       tfdAno.setToolTipText("Informe o Ano.");
       cbxCurso.setToolTipText("Selecione aqui sua graduação.");
       tfdNumPaginas.setToolTipText("Numero de páginas em seu trabalho.");
       cbxIlustracao.setToolTipText("Seu trabalho possui imagens?");
       cbxTrabalho.setToolTipText("Selecione o tipo do seu trabalho.");
       cbxOrientador.setToolTipText("Esp = Especialização • Me. = Mestre • Ma. = Mestra • Dr. = Doutor • Dra. = Doutora • PHD = Pós Doutorado");
       cbxCoorientador.setToolTipText("Esp = Especialização • Me. = Mestre • Ma. = Mestra • Dr. = Doutor • Dra. = Doutora • PHD = Pós Doutorado");
       tfdPalavra1.setToolTipText("Digite uma palavra chave relacionada ao projeto. Exemplo: Jogos");
       tfdPalavra2.setToolTipText("Digite uma palavra chave que não tenha usado em outro campo de palavras chaves. Exemplo: Realidade Aumentada");
       tfdPalavra3.setToolTipText("Digite uma palavra chave que não tenha usado em outro campo de palavras chaves. Exemplo: Computadores");
       
    }
    
    public void preencheComboBox(){
        //Preenche ComboBox de Curso
        cbxCurso.addItem("Selecione");
        cbxCurso.addItem("Administração");
        cbxCurso.addItem("Comunicação Social com Habilitação em Publicidade e Propaganda");
        cbxCurso.addItem("Comunicação Social com Habilitação em Jornalismo");
        cbxCurso.addItem("Direito");
        cbxCurso.addItem("Geografia");
        cbxCurso.addItem("Sistemas de Informação");
        cbxCurso.addItem("Sucroalcooleiro");
        cbxCurso.addItem("Tecnologia de Alimentos");
        cbxCurso.addItem("Pós Graduação em Agroecologia no Cerrado");
        cbxCurso.addItem("Pós Graduação Direito Civil e Processual Civil");
        
        
        //Prenche ComboBox Trabalho
        cbxTrabalho.addItem("Selecione");
        cbxTrabalho.addItem("Bacharel");
        cbxTrabalho.addItem("Especialização - Lato Sensu");
        cbxTrabalho.addItem("Licenciatura");
        cbxTrabalho.addItem("Tecnólogo");
        
        //Prenche ComboBox Orientador e Coorientador
        cbxOrientador.addItem("Esp.");
        cbxOrientador.addItem("Me.");
        cbxOrientador.addItem("Ma.");
        cbxOrientador.addItem("Dr.");
        cbxOrientador.addItem("Dra.");
        cbxOrientador.addItem("PHD");
        
        cbxCoorientador.addItem("Esp.");
        cbxCoorientador.addItem("Me.");
        cbxCoorientador.addItem("Ma.");
        cbxCoorientador.addItem("Dr.");
        cbxCoorientador.addItem("Dra.");
        cbxCoorientador.addItem("PHD");

    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotao = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlComGuia = new javax.swing.JTabbedPane();
        pnlFichaCalatografica = new javax.swing.JPanel();
        btnGerarFicha = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfdNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfdAutor2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfdAutor3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ckxMaisAutores = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        tfdOrientador = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfdCoorientador = new javax.swing.JTextField();
        cbxOrientador = new javax.swing.JComboBox();
        cbxCoorientador = new javax.swing.JComboBox();
        OrientadorMasc = new javax.swing.JRadioButton();
        OrientadorFem = new javax.swing.JRadioButton();
        CoorientadorMasc = new javax.swing.JRadioButton();
        CoorientadorFem = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfdTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdSubTitulo = new javax.swing.JTextField();
        cbxTrabalho = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfdAno = new javax.swing.JFormattedTextField();
        tfdNumPaginas = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxIlustracao = new javax.swing.JComboBox<String>();
        jLabel12 = new javax.swing.JLabel();
        tfdPalavra1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfdPalavra2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfdPalavra3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pnlSobre = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ficha Catalográfica");

        pnlFichaCalatografica.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 154, 193)), "Módulo de Ficha Catalográfica", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        pnlFichaCalatografica.setPreferredSize(new java.awt.Dimension(1014, 400));

        btnGerarFicha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGerarFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Files-Pdf-icon (1).png"))); // NOI18N
        btnGerarFicha.setText("Gerar Ficha");
        btnGerarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarFichaActionPerformed(evt);
            }
        });

        jLabel22.setText("Dúvidas? Mantenha o mouse sobre");

        jLabel23.setText("o campo a ser preenchido para dicas.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 154, 193)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))), "Informação do Aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel2.setToolTipText("");

        tfdNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdNomeMouseClicked(evt);
            }
        });
        tfdNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("*Nome Completo do Autor 1:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Nome Completo do Autor 2:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Nome Completo do Autor 3:");

        ckxMaisAutores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ckxMaisAutores.setText("Mais de 3 Autores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdAutor2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ckxMaisAutores)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfdAutor3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdAutor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdAutor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(ckxMaisAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 154, 193)), "Informações do Orientador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("*Nome completo do orientador:");

        tfdOrientador.setPreferredSize(new java.awt.Dimension(223, 20));
        tfdOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdOrientadorActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Nome completo do coorientador:");

        tfdCoorientador.setPreferredSize(new java.awt.Dimension(223, 20));

        OrientadorMasc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OrientadorMasc.setText("Masculino");
        OrientadorMasc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrientadorMascMouseClicked(evt);
            }
        });
        OrientadorMasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrientadorMascActionPerformed(evt);
            }
        });

        OrientadorFem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OrientadorFem.setText("Feminino");
        OrientadorFem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrientadorFemMouseClicked(evt);
            }
        });
        OrientadorFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrientadorFemActionPerformed(evt);
            }
        });

        CoorientadorMasc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CoorientadorMasc.setText("Masculino");
        CoorientadorMasc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoorientadorMascMouseClicked(evt);
            }
        });
        CoorientadorMasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoorientadorMascActionPerformed(evt);
            }
        });

        CoorientadorFem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CoorientadorFem.setText("Feminino");
        CoorientadorFem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoorientadorFemMouseClicked(evt);
            }
        });
        CoorientadorFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoorientadorFemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("*Sexo:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxOrientador, 0, 43, Short.MAX_VALUE)
                    .addComponent(cbxCoorientador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdCoorientador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfdOrientador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(72, 72, 72)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(OrientadorMasc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(OrientadorFem))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(CoorientadorMasc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CoorientadorFem)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrientadorMasc)
                    .addComponent(OrientadorFem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdCoorientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCoorientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CoorientadorMasc)
                    .addComponent(CoorientadorFem))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 154, 193)), "Informações do Trabalho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("*Título do Trabalho:");

        tfdTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdTituloActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Sub-Título do Trabalho:");

        cbxTrabalho.setPreferredSize(new java.awt.Dimension(56, 23));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("*Trabalho:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("*Número de folhas:");

        cbxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("*Curso:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("*Ano:");

        try {
            tfdAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tfdNumPaginas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tfdNumPaginas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfdNumPaginasFocusGained(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("*Ilustrações:");

        cbxIlustracao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Possui", "Preto e Branco", "Coloridas" }));

        jLabel12.setText("* 1 .");

        jLabel16.setText("2 .");

        jLabel17.setText("3 .");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Palavras-Chave:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 111, Short.MAX_VALUE))
                            .addComponent(tfdTitulo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfdSubTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addComponent(tfdAno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12))
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdPalavra1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdPalavra3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdPalavra2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxIlustracao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfdNumPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSubTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfdAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfdNumPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbxIlustracao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdPalavra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdPalavra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdPalavra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlFichaCalatograficaLayout = new javax.swing.GroupLayout(pnlFichaCalatografica);
        pnlFichaCalatografica.setLayout(pnlFichaCalatograficaLayout);
        pnlFichaCalatograficaLayout.setHorizontalGroup(
            pnlFichaCalatograficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaCalatograficaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFichaCalatograficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFichaCalatograficaLayout.createSequentialGroup()
                        .addGroup(pnlFichaCalatograficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFichaCalatograficaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(btnGerarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFichaCalatograficaLayout.setVerticalGroup(
            pnlFichaCalatograficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaCalatograficaLayout.createSequentialGroup()
                .addGroup(pnlFichaCalatograficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFichaCalatograficaLayout.createSequentialGroup()
                        .addGroup(pnlFichaCalatograficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlFichaCalatograficaLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(btnGerarFicha))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pnlComGuia.addTab("MFC", pnlFichaCalatografica);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Sobre.png"))); // NOI18N

        javax.swing.GroupLayout pnlSobreLayout = new javax.swing.GroupLayout(pnlSobre);
        pnlSobre.setLayout(pnlSobreLayout);
        pnlSobreLayout.setHorizontalGroup(
            pnlSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, Short.MAX_VALUE)
        );
        pnlSobreLayout.setVerticalGroup(
            pnlSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 479, Short.MAX_VALUE)
        );

        pnlComGuia.addTab("Sobre", null, pnlSobre, "");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlComGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlComGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarFichaActionPerformed
        String OriFem = ""+OrientadorFem.isSelected();
        String OriMasc = ""+OrientadorMasc.isSelected();
        String CooriFem = ""+CoorientadorFem.isSelected();
        String CooriMasc = ""+CoorientadorMasc.isSelected();
        int aux = 0;
        if(tfdCoorientador.getText().isEmpty()){

        }else{
            if(CooriFem.equals("false")&&CooriMasc.equals("false")){
            aux = 1;
            }
        }
        switch(aux)
        {
            case 1:{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                break;
            }

            default:{
        if(OriFem.equals("true")||OriMasc.equals("true")){
        if (tfdNome.getText().isEmpty() || tfdTitulo.getText().isEmpty()
                 || tfdAno.getText().isEmpty()  || tfdNumPaginas.getText().isEmpty()|| tfdOrientador.getText().isEmpty() 
                 || cbxTrabalho.getSelectedIndex() == 0  || cbxCurso.getSelectedIndex() == 0 
                 || tfdPalavra1.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        else
        {
            String nomediretorio = null;
            String nomepasta = "Ficha Catalografica"; // Informa o nome da pasta que armazenará o relatório
            String separador = java.io.File.separator;
            try 
            {
                nomediretorio = caminho + separador + nomepasta;
                
                String Nome = tfdNome.getText();
                String Orientador = tfdOrientador.getText();
                if (!new File(nomediretorio).exists()) 
                {
                    (new File(nomediretorio)).mkdir();
                }
                
                if(Nome.charAt(Nome.length()-1) != ' ')
                {
                    if(Orientador.charAt(Orientador.length()-1) != ' '){
                        gerarDocumento();
                    }
                    else{
                    JOptionPane.showMessageDialog( null, "Remova o espaço depois do seu ultimo nome do orientador!");
                    }
                }   
                else{
                    JOptionPane.showMessageDialog( null, "Remova o espaço depois do seu ultimo nome do aluno!");
                }

            } catch (Exception e) 
            {
                e.printStackTrace();
            }
        }}
        else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }}}
    }//GEN-LAST:event_btnGerarFichaActionPerformed

    private void tfdOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdOrientadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdOrientadorActionPerformed

    private void tfdNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdNomeMouseClicked
    
    }//GEN-LAST:event_tfdNomeMouseClicked

    private void tfdTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdTituloActionPerformed

    private void tfdNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdNomeActionPerformed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCursoActionPerformed

    private void OrientadorMascMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrientadorMascMouseClicked
    OrientadorFem.setSelected(false);
    if(OrientadorFem.isSelected() == true){
    OrientadorFem.setSelected(false);}
    }//GEN-LAST:event_OrientadorMascMouseClicked

    private void OrientadorFemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrientadorFemMouseClicked
    OrientadorMasc.setSelected(false);  
    if(OrientadorMasc.isSelected() == true){
    OrientadorMasc.setSelected(false);}// TODO add your handling code here:
    }//GEN-LAST:event_OrientadorFemMouseClicked

    private void CoorientadorMascMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoorientadorMascMouseClicked
    CoorientadorFem.setSelected(false);
    if(CoorientadorFem.isSelected() == true){
    CoorientadorFem.setSelected(false);}
    }//GEN-LAST:event_CoorientadorMascMouseClicked

    private void CoorientadorFemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoorientadorFemMouseClicked
    CoorientadorMasc.setSelected(false);
    if(CoorientadorMasc.isSelected() == true){
    CoorientadorMasc.setSelected(false);}
    }//GEN-LAST:event_CoorientadorFemMouseClicked

    private void OrientadorMascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrientadorMascActionPerformed
    OrientadorFem.setSelected(false);    // TODO add your handling code here:
    }//GEN-LAST:event_OrientadorMascActionPerformed

    private void OrientadorFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrientadorFemActionPerformed
    OrientadorMasc.setSelected(false);    // TODO add your handling code here:
    }//GEN-LAST:event_OrientadorFemActionPerformed

    private void CoorientadorMascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoorientadorMascActionPerformed
    CoorientadorFem.setSelected(false);    // TODO add your handling code here:
    }//GEN-LAST:event_CoorientadorMascActionPerformed

    private void CoorientadorFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoorientadorFemActionPerformed
    CoorientadorMasc.setSelected(false);    // TODO add your handling code here:
    }//GEN-LAST:event_CoorientadorFemActionPerformed

    private void tfdNumPaginasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdNumPaginasFocusGained
        
    }//GEN-LAST:event_tfdNumPaginasFocusGained
      public void gerarDocumento() throws IOException, DocumentException{
        
        File pdf = null;
        JFileChooser chooser = null;
        
        doc = new Document(PageSize.A4);
        
        String NomeCompleto = tfdNome.getText();
        String PrimeiroNome, UltimoNome;
        int cont1 = 0, i, cont2 = 0;
        for( i = 0; i < NomeCompleto.length(); i++){
            if(NomeCompleto.charAt(i) == ' '){
                cont1++;
                
                cont2 = i;
 
            }
        }
        PrimeiroNome = NomeCompleto.substring(0, cont2);
        UltimoNome = NomeCompleto.substring(cont2+1, NomeCompleto.length());
        
        String NomeCompletoOrientador = tfdOrientador.getText();
        String NomeOrientador, SobrenomeOrientador;
        cont1 = 0; i = 0; cont2 = 0;
        for( i = 0; i < NomeCompletoOrientador.length(); i++){
            if(NomeCompletoOrientador.charAt(i) == ' '){
                cont1++;
                
                cont2 = i;
 
            }
        }
        NomeOrientador = NomeCompletoOrientador.substring(0, cont2);
        SobrenomeOrientador = NomeCompletoOrientador.substring(cont2+1, NomeCompletoOrientador.length());
        
        
 	try {
            pdf = File.createTempFile(tfdNome.getText(),"");            
        } catch (IOException e1) {            
            e1.printStackTrace();
        }

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo PDF", "pdf");

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(pdf);
        chooser.setSelectedFile(pdf);
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setMultiSelectionEnabled(false);


        int retorno = chooser.showSaveDialog(null);
        if (retorno==JFileChooser.APPROVE_OPTION){
            caminho = chooser.getSelectedFile().getAbsolutePath();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!\n\nLocal: "+chooser.getSelectedFile().getAbsolutePath()+"\n ");
        }

        PdfWriter.getInstance(doc, new FileOutputStream(caminho+".pdf"));
        doc.open();
        Font fonte = new Font(Font.FontFamily.TIMES_ROMAN, 11);
        PdfPTable tabela = new PdfPTable(new float[]{0.07f, 0.85f});
            
        tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabela.setWidthPercentage(100f);
        tabela.setTotalWidth(350);
            
        tabela.setLockedWidth(true);
            
        Paragraph espacamento = new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        doc.add(espacamento);
            
        Paragraph p1 = new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",fonte);
        p1.setAlignment(Element.ALIGN_JUSTIFIED);
        PdfPCell col1 = new PdfPCell(p1);
        col1.setBorder(7);
            
        
            
        String paragrafo;
                paragrafo= "\n"+UltimoNome+", "+PrimeiroNome+"\n"
                    +"      " +tfdTitulo.getText();

        if(!tfdSubTitulo.getText().equals("")){
                 paragrafo += ": "+ tfdSubTitulo.getText();
        }
             
        paragrafo += " / "+tfdNome.getText();
             
        if(ckxMaisAutores.isSelected()){
                 paragrafo += "... [et al.]";
        }else{
                if(!tfdAutor2.getText().equals("")){
                    paragrafo += ", "+tfdAutor2.getText();
                }
                if(!tfdAutor3.getText().equals("")){
                    paragrafo += ", "+tfdAutor3.getText();
                }
             }
             
            paragrafo += ". - Frutal, "+tfdAno.getText()+".";
            
            paragrafo += "\n      "+tfdNumPaginas.getText()+" f.";                              
            if(cbxIlustracao.getSelectedIndex() == 1){
                paragrafo += " : il. ";
            }else if(cbxIlustracao.getSelectedIndex() == 2){
                paragrafo += " : il. color.";
            }
            if(OrientadorFem.isSelected()){
                paragrafo += "\n      Orientadora: "+cbxOrientador.getSelectedItem()+" "+tfdOrientador.getText()+"." ;
            }else{
                paragrafo += "\n      Orientador: "+cbxOrientador.getSelectedItem()+" "+tfdOrientador.getText()+".";
            }
            
            if(!tfdCoorientador.getText().equals("")){
                if(CoorientadorFem.isSelected()){
                    paragrafo += "\n      Coorientadora: "+cbxCoorientador.getSelectedItem()+" "+tfdCoorientador.getText()+"." ;
                }else{
                    paragrafo += "\n      Coorientador: "+cbxCoorientador.getSelectedItem()+" "+tfdCoorientador.getText()+".";
                } 
            }

            paragrafo += "\n      Trabalho de conclusão de curso (";
            if(cbxTrabalho.getSelectedIndex() == 1){
                paragrafo += "Bacharel)";
            }
            if(cbxTrabalho.getSelectedIndex() == 2){
                paragrafo += "Especialização - Lato Sensu)";
            }
            if(cbxTrabalho.getSelectedIndex() == 3){
                paragrafo += "Licenciatura)";
            }
            if(cbxTrabalho.getSelectedIndex() == 4){
                paragrafo += "Tecnólogo)";
            }
            else{
                
            }
            paragrafo += " - Universidade do Estado de Minas Gerais, UEMG. Unidade Frutal. ";
            if(cbxCurso.getSelectedIndex()<9){
            paragrafo+="Curso de "+cbxCurso.getSelectedItem();}
            else
            {paragrafo+=cbxCurso.getSelectedItem();}
            
            paragrafo+=", "+tfdAno.getText()+".";
            paragrafo += "\n\n      1. "+tfdPalavra1.getText()+". ";
            if(!tfdPalavra2.getText().equals("")){
                paragrafo += "2. "+tfdPalavra2.getText()+". ";
            }
            if(!tfdPalavra3.getText().equals("")){
                paragrafo += "3. "+tfdPalavra3.getText()+". ";
            }
            
            paragrafo += "I. "+SobrenomeOrientador +", "+NomeOrientador+".";
            paragrafo +=" II. Título.\n\n";
            Paragraph p3 = new Paragraph(paragrafo,fonte);
            p3.setAlignment(Element.ALIGN_JUSTIFIED);
            PdfPCell col3 = new PdfPCell(p3);
            col3.setBorder(11);
           
            tabela.addCell(col1);
            tabela.addCell(col3);
            
            doc.add(tabela);
            
            doc.close();
     }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CoorientadorFem;
    private javax.swing.JRadioButton CoorientadorMasc;
    private javax.swing.JRadioButton OrientadorFem;
    private javax.swing.JRadioButton OrientadorMasc;
    private javax.swing.JToggleButton btnGerarFicha;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxCoorientador;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxIlustracao;
    private javax.swing.JComboBox cbxOrientador;
    private javax.swing.JComboBox<String> cbxTrabalho;
    private javax.swing.JCheckBox ckxMaisAutores;
    private javax.swing.ButtonGroup grupoBotao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane pnlComGuia;
    private javax.swing.JPanel pnlFichaCalatografica;
    private javax.swing.JPanel pnlSobre;
    private javax.swing.JFormattedTextField tfdAno;
    private javax.swing.JTextField tfdAutor2;
    private javax.swing.JTextField tfdAutor3;
    private javax.swing.JTextField tfdCoorientador;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JFormattedTextField tfdNumPaginas;
    private javax.swing.JTextField tfdOrientador;
    private javax.swing.JTextField tfdPalavra1;
    private javax.swing.JTextField tfdPalavra2;
    private javax.swing.JTextField tfdPalavra3;
    private javax.swing.JTextField tfdSubTitulo;
    private javax.swing.JTextField tfdTitulo;
    // End of variables declaration//GEN-END:variables
}
