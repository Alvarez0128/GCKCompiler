package GUI;

import AnalisisLexico.ErrorToken;
import AnalisisLexico.Lexer;
import AnalisisLexico.Token;
import com.formdev.flatlaf.icons.FlatTabbedPaneCloseIcon;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.*;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import org.fife.ui.rsyntaxtextarea.folding.CurlyFoldParser;
import org.fife.ui.rsyntaxtextarea.folding.FoldParserManager;

/**
 *
 * @author cesar
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    public ArrayList<Token> simbolos = null;
    public ArrayList<ErrorToken> errores = null;
    private Directory directorio;
    
    public VentanaPrincipal() {
        initComponents();
        setupTabTraversalKeys(panelContenedorPestañas);
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/myLanguage", "Colores.Color");
        
        FoldParserManager.get().addFoldParserMapping("text/myLanguage", new Plegado());
        //Inicializacion de una ventana para el jTabbedPane con un RSyntaxTextArea
        RSyntax();
        //Para centrar la ventana
        setLocationRelativeTo(null);
        setTitle("GCK Compiler");

        //Para navegar por las pestañas con Ctrl+tab, pero no funciona correctamente aún
        setupTabTraversalKeys(panelContenedorPestañas);
        //Establecer icono para la ventana
        setIconImage(new FlatSVGIcon("assets/GCK.svg").getImage());

        pantalla.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventanaLexico = new javax.swing.JFrame();
        contenedorBaseLexico = new javax.swing.JPanel();
        scrollLexico = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ventanaTS = new javax.swing.JFrame();
        contenedorBaseTS = new javax.swing.JPanel();
        scrollTS = new javax.swing.JScrollPane();
        jTableTS = new javax.swing.JTable();
        ventanaTSFija = new javax.swing.JFrame();
        contenedorBaseTS1 = new javax.swing.JPanel();
        scrollTS1 = new javax.swing.JScrollPane();
        jTableTS1 = new javax.swing.JTable();
        panelContenedorPrincipal = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        panelBaseIzquierdo = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        panelBaseDerecho = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        panelBasePestañas = new javax.swing.JPanel();
        panelContenedorPestañas = new javax.swing.JTabbedPane();
        pantalla = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        anLexButton = new javax.swing.JButton();
        tsButton = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNuevo = new javax.swing.JMenuItem();
        menuAbrir = new javax.swing.JMenuItem();
        menuGuardar = new javax.swing.JMenuItem();
        menuGuardarComo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuCerrar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        ventanaLexico.setTitle("Análisis Léxico");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Lexema", "Componente Léxico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollLexico.setViewportView(jTable1);

        javax.swing.GroupLayout contenedorBaseLexicoLayout = new javax.swing.GroupLayout(contenedorBaseLexico);
        contenedorBaseLexico.setLayout(contenedorBaseLexicoLayout);
        contenedorBaseLexicoLayout.setHorizontalGroup(
            contenedorBaseLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollLexico, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        contenedorBaseLexicoLayout.setVerticalGroup(
            contenedorBaseLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollLexico, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        ventanaLexico.setSize(new java.awt.Dimension(400, 450));
        ventanaLexico.setLocationRelativeTo(null);
        ventanaLexico.setType(java.awt.Window.Type.POPUP);

        javax.swing.GroupLayout ventanaLexicoLayout = new javax.swing.GroupLayout(ventanaLexico.getContentPane());
        ventanaLexico.getContentPane().setLayout(ventanaLexicoLayout);
        ventanaLexicoLayout.setHorizontalGroup(
            ventanaLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaLexicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorBaseLexico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ventanaLexicoLayout.setVerticalGroup(
            ventanaLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaLexicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorBaseLexico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ventanaLexico.setIconImage(new FlatSVGIcon("assets/AnLEX.svg").getImage());

        ventanaTS.setTitle("Tabla de símbolos");

        jTableTS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Lexema", "Dirección", "Linea", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTS.setViewportView(jTableTS);
        if (jTableTS.getColumnModel().getColumnCount() > 0) {
            jTableTS.getColumnModel().getColumn(2).setHeaderValue("Linea");
            jTableTS.getColumnModel().getColumn(3).setHeaderValue("Columna");
        }

        javax.swing.GroupLayout contenedorBaseTSLayout = new javax.swing.GroupLayout(contenedorBaseTS);
        contenedorBaseTS.setLayout(contenedorBaseTSLayout);
        contenedorBaseTSLayout.setHorizontalGroup(
            contenedorBaseTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTS, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );
        contenedorBaseTSLayout.setVerticalGroup(
            contenedorBaseTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTS, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );

        ventanaTS.setSize(new java.awt.Dimension(436, 448));
        ventanaTS.setLocationRelativeTo(null);
        ventanaTS.setType(java.awt.Window.Type.POPUP);

        javax.swing.GroupLayout ventanaTSLayout = new javax.swing.GroupLayout(ventanaTS.getContentPane());
        ventanaTS.getContentPane().setLayout(ventanaTSLayout);
        ventanaTSLayout.setHorizontalGroup(
            ventanaTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaTSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorBaseTS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ventanaTSLayout.setVerticalGroup(
            ventanaTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaTSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorBaseTS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ventanaTS.setIconImage(new FlatSVGIcon("assets/TS.svg").getImage());

        jTableTS1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "int"},
                {"2", "float"},
                {"3", "const"},
                {"4", "char"},
                {"5", "String"},
                {"6", "bool"},
                {"7", "true"},
                {"8", "false"},
                {"9", "Array"},
                {"10", "Color"},
                {"11", "Rect2"},
                {"12", "importAll"},
                {"13", "Dictionary"},
                {"14", "extends"},
                {"15", "Vector2"},
                {"16", "File"},
                {"17", "return"},
                {"18", "new"},
                {"19", "AABB"},
                {"20", "TimeSpan"},
                {"21", "Resource"},
                {"22", "Object"},
                {"23", "Start"},
                {"24", "SceneTree"},
                {"25", "PhysicsShape"},
                {"26", "in"},
                {"27", "class"},
                {"28", "range"},
                {"29", "void"},
                {"30", "print"},
                {"31", "PhysicsBody"},
                {"32", "func"},
                {"33", "Error"},
                {"34", "for"},
                {"35", "while"},
                {"36", "if"},
                {"37", "elif"},
                {"38", "else"},
                {"38", "break"}
            },
            new String [] {
                "ID", "Lexema"
            }
        ));
        jTableTS1.setShowGrid(true);
        jTableTS1.setSurrendersFocusOnKeystroke(true);
        scrollTS1.setViewportView(jTableTS1);

        javax.swing.GroupLayout contenedorBaseTS1Layout = new javax.swing.GroupLayout(contenedorBaseTS1);
        contenedorBaseTS1.setLayout(contenedorBaseTS1Layout);
        contenedorBaseTS1Layout.setHorizontalGroup(
            contenedorBaseTS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTS1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );
        contenedorBaseTS1Layout.setVerticalGroup(
            contenedorBaseTS1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTS1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        ventanaTSFija.setSize(new java.awt.Dimension(250, 480));
        ventanaTSFija.setLocationRelativeTo(null);
        ventanaTSFija.setType(java.awt.Window.Type.POPUP);
        // Layout setup code - not shown here
        ventanaTSFija.setIconImage(new FlatSVGIcon("assets/TS.svg").getImage());

        javax.swing.GroupLayout ventanaTSFijaLayout = new javax.swing.GroupLayout(ventanaTSFija.getContentPane());
        ventanaTSFija.getContentPane().setLayout(ventanaTSFijaLayout);
        ventanaTSFijaLayout.setHorizontalGroup(
            ventanaTSFijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaTSFijaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorBaseTS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ventanaTSFijaLayout.setVerticalGroup(
            ventanaTSFijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaTSFijaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorBaseTS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Caja");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Sprite2D");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("blue");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("violet");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("red");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("yellow");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("CollisionShape2D");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("basketball");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("soccer");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("football");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hockey");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree2.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree2);

        jTabbedPane2.addTab("Escenas", jScrollPane2);

        jSplitPane3.setLeftComponent(jTabbedPane2);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(128, 200));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("res://");
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("gráficos");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("blue");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("violet");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("red");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("yellow");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("scripts");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("basketball");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("soccer");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("football");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hockey");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("iconos");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hot dogs");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("pizza");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("ravioli");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("bananas");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        jTabbedPane1.addTab("Sistema de archivos", jScrollPane1);

        jSplitPane3.setRightComponent(jTabbedPane1);

        javax.swing.GroupLayout panelBaseIzquierdoLayout = new javax.swing.GroupLayout(panelBaseIzquierdo);
        panelBaseIzquierdo.setLayout(panelBaseIzquierdoLayout);
        panelBaseIzquierdoLayout.setHorizontalGroup(
            panelBaseIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseIzquierdoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane3)
                .addGap(0, 0, 0))
        );
        panelBaseIzquierdoLayout.setVerticalGroup(
            panelBaseIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBaseIzquierdoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(panelBaseIzquierdo);

        jSplitPane4.setDividerSize(3);
        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane4.setResizeWeight(1.0);
        jSplitPane4.setFocusTraversalPolicyProvider(true);

        panelBasePestañas.setLayout(new java.awt.CardLayout());
        panelBasePestañas.add(panelContenedorPestañas, "card2");

        jSplitPane4.setLeftComponent(panelBasePestañas);

        pantalla.setBorder(null);
        pantalla.setClosable(true);
        pantalla.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        pantalla.setTitle("Output");
        pantalla.setFrameIcon(null);
        pantalla.setVisible(true);

        txtResultado.setEditable(false);
        txtResultado.setBorder(null);
        txtResultado.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jScrollPane3.setViewportView(txtResultado);

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla.getContentPane());
        pantalla.getContentPane().setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3)
                .addGap(0, 0, 0))
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jSplitPane4.setRightComponent(pantalla);
        try {
            pantalla.setIcon(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        javax.swing.GroupLayout panelBaseDerechoLayout = new javax.swing.GroupLayout(panelBaseDerecho);
        panelBaseDerecho.setLayout(panelBaseDerechoLayout);
        panelBaseDerechoLayout.setHorizontalGroup(
            panelBaseDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseDerechoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBaseDerechoLayout.setVerticalGroup(
            panelBaseDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseDerechoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jSplitPane2.setRightComponent(panelBaseDerecho);

        jToolBar1.setRollover(true);

        anLexButton.setText("Análisis Léxico");
        anLexButton.setFocusable(false);
        anLexButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        anLexButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        anLexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anLexButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(anLexButton);

        tsButton.setText("Tabla de símbolos");
        tsButton.setFocusable(false);
        tsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tsButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(tsButton);

        jToolBar2.setRollover(true);

        jButton1.setText("TS Fija");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);

        javax.swing.GroupLayout panelContenedorPrincipalLayout = new javax.swing.GroupLayout(panelContenedorPrincipal);
        panelContenedorPrincipal.setLayout(panelContenedorPrincipalLayout);
        panelContenedorPrincipalLayout.setHorizontalGroup(
            panelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorPrincipalLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelContenedorPrincipalLayout.setVerticalGroup(
            panelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSplitPane2)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        menuNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuNuevo.setText("Nuevo");
        menuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(menuNuevo);

        menuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuAbrir.setText("Abrir...");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrir);

        menuGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuGuardar.setText("Guardar");
        menuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(menuGuardar);

        menuGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuGuardarComo.setText("Guardar como...");
        menuGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(menuGuardarComo);
        jMenu1.add(jSeparator1);

        menuCerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuCerrar.setText("Cerrar");
        menuCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarActionPerformed(evt);
            }
        });
        jMenu1.add(menuCerrar);
        jMenu1.add(jSeparator2);

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Deshacer");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem10.setText("Rehacer");
        jMenu2.add(jMenuItem10);
        jMenu2.add(jSeparator3);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem11.setText("Cortar");
        jMenu2.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem12.setText("Copiar");
        jMenu2.add(jMenuItem12);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem13.setText("Pegar");
        jMenu2.add(jMenuItem13);
        jMenu2.add(jSeparator4);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem14.setText("Eliminar");
        jMenu2.add(jMenuItem14);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ver");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setText("jMenuItem9");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Fuente");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Opciones");
        jMenuBar1.add(jMenu5);

        jMenu7.setText("Ayuda");

        jMenu6.setText("Documentación");

        jMenuItem3.setText("Diseño de GCKScript");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem4.setText("Manual técnico");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenu7.add(jMenu6);

        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedorPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarComoActionPerformed
        directorio.SaveAs();
    }//GEN-LAST:event_menuGuardarComoActionPerformed

    private static void setupTabTraversalKeys(JTabbedPane tabbedPane) {
        KeyStroke ctrlTab = KeyStroke.getKeyStroke("ctrl TAB");
        KeyStroke ctrlShiftTab = KeyStroke.getKeyStroke("ctrl shift TAB");

        // Remove ctrl-tab from normal focus traversal
        Set<AWTKeyStroke> forwardKeys = new HashSet<AWTKeyStroke>(tabbedPane.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.remove(ctrlTab);
        tabbedPane.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        // Remove ctrl-shift-tab from normal focus traversal
        Set<AWTKeyStroke> backwardKeys = new HashSet<AWTKeyStroke>(tabbedPane.getFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));
        backwardKeys.remove(ctrlShiftTab);
        tabbedPane.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, backwardKeys);

        // Add keys to the tab's input map
        InputMap inputMap = tabbedPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(ctrlTab, "navigateNext");
        inputMap.put(ctrlShiftTab, "navigatePrevious");
    }
    private void menuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoActionPerformed
        RSyntaxTextArea textArea = new RSyntaxTextArea(); // Crea una nueva instancia de RSyntaxTextArea
        RTextScrollPane scrollPane = new RTextScrollPane(textArea);
        panelContenedorPestañas.add("Script", scrollPane);
        directorio = new Directory(this, textArea, "GCKKKK", ".gck", panelContenedorPestañas);
        //textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_GO);
        
        textArea.setSyntaxEditingStyle("text/myLanguage");

        textArea.setCodeFoldingEnabled(true);
        textArea.setAntiAliasingEnabled(true);
        textArea.setAnimateBracketMatching(true);
        changeStyleViaThemeXml(textArea);
        textArea.setFont(new Font("Segoe UI", Font.BOLD, 18));
        /*CompletionProvider provider = createCompletionProvider();
        AutoCompletion ac = new AutoCompletion(provider);
        ac.install(textArea);*/
    }//GEN-LAST:event_menuNuevoActionPerformed


    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
        directorio.Open();
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void menuCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarActionPerformed
        if (panelContenedorPestañas.getTabCount() >= 0) {
            Object[] options = {"Sí", "No"};
            int option = JOptionPane.showOptionDialog(this, "¿Guardar antes de cerrar la pestaña?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (option == 0) { // 0 representa "Sí" en el array de opciones
                directorio.Save();
                panelContenedorPestañas.removeTabAt(panelContenedorPestañas.getSelectedIndex());
            } else {
                panelContenedorPestañas.removeTabAt(panelContenedorPestañas.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_menuCerrarActionPerformed

    private void tsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tsButtonActionPerformed
        ventanaTS.setVisible(true);
    }//GEN-LAST:event_tsButtonActionPerformed

    private void anLexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anLexButtonActionPerformed
        String texto = "";
        int indicePanelActivo = panelContenedorPestañas.getSelectedIndex(); // Obtiene el índice del panel activo
        if (indicePanelActivo != -1) { // Asegúrate de que haya un panel activo seleccionado
            Component componente = panelContenedorPestañas.getComponentAt(indicePanelActivo); // Obtiene el componente en el panel activo
            if (componente instanceof JScrollPane) { // Comprueba si el componente es un JScrollPane
                JScrollPane scrollPane = (JScrollPane) componente; // Convierte el componente en JScrollPane
                Component componenteInterno = scrollPane.getViewport().getView(); // Obtiene el componente interno (en este caso, el JTextArea)
                if (componenteInterno instanceof JTextArea) { // Comprueba si el componente interno es un JTextArea
                    JTextArea textArea = (JTextArea) componenteInterno; // Convierte el componente interno en JTextArea
                    texto += textArea.getText(); // Obtiene el texto del JTextArea
                    // Ahora, 'texto' contiene el texto del JTextArea en el panel activo

                }
            }
        }
        //simbolos.clear();
        File archivo = new File("codigo.txt");
        PrintWriter escribir;
        DefaultTableModel Tabla = (DefaultTableModel) jTable1.getModel();
        vaciarTabla(Tabla, jTable1);
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(texto);
            escribir.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Reader lector = new BufferedReader(new FileReader("codigo.txt"));
            Lexer lexer = new Lexer(lector);
            txtResultado.setForeground(Color.green);

            Object[] row = new Object[2];

            jSplitPane4.setDividerLocation(0.75);

            pantalla.setVisible(true);
            ventanaLexico.setVisible(true);

            while (true) {

                if (lexer.yylex() == null) {
                    simbolos = lexer.tablaToken.getTokens();
                    errores = lexer.tablaError.getErrores();
                    llenarTS();
                    llenarTabla();

                    if (errores.isEmpty()) {
                        txtResultado.setForeground(new Color(120, 212, 110));
                        txtResultado.setText("-> Análisis finalizado sin errores");
                    } else {
                        txtResultado.setForeground(new Color(219, 88, 88));
                        mostrarErrores();
                    }

                    return;
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_anLexButtonActionPerformed

    private void menuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarActionPerformed
        directorio.Save();
    }//GEN-LAST:event_menuGuardarActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ventanaTSFija.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://docs.google.com/document/d/1seoKYCEsGI75csR81-TKETZ9cUdVXyy6pg3l5jwP8dw/edit?usp=sharing"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://docs.google.com/document/d/1qeY6uYMQqamKzeFeyg6Z0P87JS65njK4om06n904f1Q/edit?usp=sharing"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void changeStyleViaThemeXml(RSyntaxTextArea textArea) {
        try {
            Theme theme = Theme.load(new FileInputStream("byMe.xml"));
            theme.apply(textArea);
        } catch (IOException ioe) { // Never happens
            ioe.printStackTrace();
        }
    }

    public void RSyntax() {
        RSyntaxTextArea textArea = new RSyntaxTextArea();
        RTextScrollPane scrollPane = new RTextScrollPane(textArea);

        panelContenedorPestañas.add("Script",scrollPane);
        directorio = new Directory(this, textArea, "GCKKKK", ".gck");
        //textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_GO);
        
        textArea.setSyntaxEditingStyle("text/myLanguage");
        textArea.setCodeFoldingEnabled(true); //Para contraer partes del codigo
        
        textArea.setAntiAliasingEnabled(true);
        textArea.setAnimateBracketMatching(true);
        changeStyleViaThemeXml(textArea);
        textArea.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        panelContenedorPestañas.putClientProperty("JTabbedPane.tabClosable", true);
        panelContenedorPestañas.putClientProperty("JTabbedPane.tabCloseCallback", (IntConsumer) tabIndex -> {
            if (tabIndex >= 0) {
                Object[] options = {"Sí", "No"};
                int option = JOptionPane.showOptionDialog(this, "¿Desea guardar antes de cerrar la pestaña?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (option == 0) { // 0 representa "Sí" en el array de opciones
                    directorio.Save();
                    panelContenedorPestañas.removeTabAt(tabIndex);
                } else {
                    panelContenedorPestañas.removeTabAt(tabIndex);
                }
            }
        });
        
    }

    public static void main(String args[]) {
        try {
            FlatMaterialDeepOceanIJTheme.setup();
            //Boton circular Cerrar pestaña 
            UIManager.put("TabbedPane.closeArc", Integer.valueOf(999));
            UIManager.put("TabbedPane.closeCrossFilledSize", Float.valueOf(5.5F));
            UIManager.put("TabbedPane.closeIcon", new FlatTabbedPaneCloseIcon());

            //Estilo underlined para los menuItems
            UIManager.put("MenuItem.selectionType", "underline");

            //Botones redondeados
            UIManager.put("Button.arc", 999);

            //Grosor de los bordes de focus de los componentes
            UIManager.put("Component.focusWidth", 0);
            UIManager.put("Component.innerFocusWidth", 0);

            //Barra de scroll redondeada
            UIManager.put("ScrollBar.thumbArc", 999);
            UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));

        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    private void llenarTS() {

        DefaultTableModel dm = (DefaultTableModel) jTableTS.getModel();
        dm.setRowCount(0);
        for (Token entry : simbolos) {
            if (entry.grupoLexico.equals("Identificador")) {
                Object[] campos = {entry.lexema, "@" + entry.toString().split("@")[1], entry.linea, entry.columna};
                dm.addRow(campos);
            }
        }
        jTableTS.setModel(dm);
    }

    private void llenarTabla() {

        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);

        for (Token entry : simbolos) {
            Object[] campos = {entry.lexema, entry.grupoLexico};
            dm.addRow(campos);
        }
        jTable1.setModel(dm);
    }

    private void mostrarErrores() {

        txtResultado.setText("");
        for (ErrorToken entry : errores) {
            txtResultado.setText(txtResultado.getText() + "\n" + entry.toString());
        }
        txtResultado.setText(txtResultado.getText() + "\n\n" + "-> Análisis finalizado con errores");
    }

    public static void vaciarTabla(DefaultTableModel Modelo, JTable JT) {
        //Inicializamos la tabla con un modelo
        Modelo = (DefaultTableModel) JT.getModel();
        int i = 0;
        while (i < Modelo.getRowCount()) {
            Modelo.removeRow(i);
        }//metodo while para remover los renglones de la tabla
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anLexButton;
    private javax.swing.JPanel contenedorBaseLexico;
    private javax.swing.JPanel contenedorBaseTS;
    private javax.swing.JPanel contenedorBaseTS1;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableTS;
    private javax.swing.JTable jTableTS1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTree jTree2;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenuItem menuCerrar;
    private javax.swing.JMenuItem menuGuardar;
    private javax.swing.JMenuItem menuGuardarComo;
    private javax.swing.JMenuItem menuNuevo;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panelBaseDerecho;
    private javax.swing.JPanel panelBaseIzquierdo;
    private javax.swing.JPanel panelBasePestañas;
    private javax.swing.JTabbedPane panelContenedorPestañas;
    private javax.swing.JPanel panelContenedorPrincipal;
    private javax.swing.JInternalFrame pantalla;
    private javax.swing.JScrollPane scrollLexico;
    private javax.swing.JScrollPane scrollTS;
    private javax.swing.JScrollPane scrollTS1;
    private javax.swing.JButton tsButton;
    private javax.swing.JTextPane txtResultado;
    private javax.swing.JFrame ventanaLexico;
    private javax.swing.JFrame ventanaTS;
    private javax.swing.JFrame ventanaTSFija;
    // End of variables declaration//GEN-END:variables
}
