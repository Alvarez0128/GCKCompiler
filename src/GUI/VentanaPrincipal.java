package GUI;

import AnalisisLexico.ErrorToken;
import AnalisisLexico.Lexer;
import AnalisisLexico.Token;
import AnalisisSintactico.Grammar;
import TablasSimbolos.AnalizarFunciones;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
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
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.fife.ui.rsyntaxtextarea.folding.FoldParserManager;

/**
 *
 * @author cesar
 */
public class VentanaPrincipal extends javax.swing.JFrame {

   boolean dark = true;
   String rutaFuente = "src/assets/JetBrainsMono-Regular.ttf";
   Font fuente = cargarFuenteDesdeArchivo(rutaFuente).deriveFont(Font.PLAIN, 16);
   public ArrayList<Token> ComponentesLexicos = null;
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
      tablaIdentificadores = new javax.swing.JTable();
      ventanaTSFija = new javax.swing.JFrame();
      contenedorBaseTS1 = new javax.swing.JPanel();
      scrollTS1 = new javax.swing.JScrollPane();
      tablaFija = new javax.swing.JTable();
      ventanaTSIdFunciones = new javax.swing.JFrame();
      contenedorBaseTS2 = new javax.swing.JPanel();
      jScrollPane4 = new javax.swing.JScrollPane();
      tablaFunciones = new javax.swing.JTable();
      ventanaTSIdArreglos = new javax.swing.JFrame();
      contenedorBaseTS3 = new javax.swing.JPanel();
      jScrollPane5 = new javax.swing.JScrollPane();
      tablaArreglos = new javax.swing.JTable();
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
      compilationButton = new javax.swing.JButton();
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
      modoOscuroMenuItem = new javax.swing.JMenuItem();
      modoClaroMenuItem = new javax.swing.JMenuItem();
      jMenu7 = new javax.swing.JMenu();
      jMenu6 = new javax.swing.JMenu();
      jMenuItem3 = new javax.swing.JMenuItem();
      jMenuItem4 = new javax.swing.JMenuItem();
      jMenuItem1 = new javax.swing.JMenuItem();
      TSMenu = new javax.swing.JMenu();
      TSFijaMenu = new javax.swing.JMenuItem();
      TSFunciones = new javax.swing.JMenuItem();
      TSArreglos = new javax.swing.JMenuItem();
      jMenuItem18 = new javax.swing.JMenuItem();
      jSeparator5 = new javax.swing.JPopupMenu.Separator();
      jMenuItem19 = new javax.swing.JMenuItem();

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

      tablaIdentificadores.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Identificador", "Tipo", "Valor"
         }
      ) {
         boolean[] canEdit = new boolean [] {
            false, false, false
         };

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      scrollTS.setViewportView(tablaIdentificadores);

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

      ventanaTSFija.setTitle("Tabla Fija");

      tablaFija.setModel(new javax.swing.table.DefaultTableModel(
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
            {"13", "extends"},
            {"14", "Vector2"},
            {"15", "File"},
            {"16", "return"},
            {"17", "new"},
            {"18", "AABB"},
            {"19", "TimeSpan"},
            {"20", "Resource"},
            {"21", "Object"},
            {"22", "Start"},
            {"23", "PhysicsShape"},
            {"24", "in"},
            {"25", "class"},
            {"26", "range"},
            {"27", "void"},
            {"28", "print"},
            {"29", "PhysicsBody"},
            {"30", "func"},
            {"31", "Error"},
            {"32", "for"},
            {"33", "while"},
            {"34", "if"},
            {"35", "elif"},
            {"36", "else"},
            {"37", "break"}
         },
         new String [] {
            "ID", "Lexema"
         }
      ));
      tablaFija.setShowGrid(true);
      tablaFija.setSurrendersFocusOnKeystroke(true);
      scrollTS1.setViewportView(tablaFija);

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

      ventanaTSIdFunciones.setTitle("Tabla de funciones");

      tablaFunciones.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Identificador", "Cantidad de parámetros", "Tipos de parámetros", "Dirección"
         }
      ) {
         boolean[] canEdit = new boolean [] {
            false, false, false, false
         };

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      jScrollPane4.setViewportView(tablaFunciones);

      javax.swing.GroupLayout contenedorBaseTS2Layout = new javax.swing.GroupLayout(contenedorBaseTS2);
      contenedorBaseTS2.setLayout(contenedorBaseTS2Layout);
      contenedorBaseTS2Layout.setHorizontalGroup(
         contenedorBaseTS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(contenedorBaseTS2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
            .addContainerGap())
      );
      contenedorBaseTS2Layout.setVerticalGroup(
         contenedorBaseTS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(contenedorBaseTS2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addContainerGap())
      );

      ventanaTSIdFunciones.setSize(new java.awt.Dimension(500, 480));
      ventanaTSIdFunciones.setLocationRelativeTo(null);
      ventanaTSIdFunciones.setType(java.awt.Window.Type.POPUP);
      // Layout setup code - not shown here
      ventanaTSIdFunciones.setIconImage(new FlatSVGIcon("assets/TS.svg").getImage());

      javax.swing.GroupLayout ventanaTSIdFuncionesLayout = new javax.swing.GroupLayout(ventanaTSIdFunciones.getContentPane());
      ventanaTSIdFunciones.getContentPane().setLayout(ventanaTSIdFuncionesLayout);
      ventanaTSIdFuncionesLayout.setHorizontalGroup(
         ventanaTSIdFuncionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(contenedorBaseTS2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      ventanaTSIdFuncionesLayout.setVerticalGroup(
         ventanaTSIdFuncionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(contenedorBaseTS2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      ventanaTSIdArreglos.setTitle("Tabla de arreglos");

      tablaArreglos.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Nombre", "Dimension", "Tipo", "Elementos", "Direccion"
         }
      ));
      jScrollPane5.setViewportView(tablaArreglos);

      javax.swing.GroupLayout contenedorBaseTS3Layout = new javax.swing.GroupLayout(contenedorBaseTS3);
      contenedorBaseTS3.setLayout(contenedorBaseTS3Layout);
      contenedorBaseTS3Layout.setHorizontalGroup(
         contenedorBaseTS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
      );
      contenedorBaseTS3Layout.setVerticalGroup(
         contenedorBaseTS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
      );

      ventanaTSIdArreglos.setSize(new java.awt.Dimension(500, 480));
      ventanaTSIdArreglos.setLocationRelativeTo(null);
      ventanaTSIdArreglos.setType(java.awt.Window.Type.POPUP);
      // Layout setup code - not shown here
      ventanaTSIdArreglos.setIconImage(new FlatSVGIcon("assets/TS.svg").getImage());

      javax.swing.GroupLayout ventanaTSIdArreglosLayout = new javax.swing.GroupLayout(ventanaTSIdArreglos.getContentPane());
      ventanaTSIdArreglos.getContentPane().setLayout(ventanaTSIdArreglosLayout);
      ventanaTSIdArreglosLayout.setHorizontalGroup(
         ventanaTSIdArreglosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(ventanaTSIdArreglosLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(contenedorBaseTS3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );
      ventanaTSIdArreglosLayout.setVerticalGroup(
         ventanaTSIdArreglosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(ventanaTSIdArreglosLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(contenedorBaseTS3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
      txtResultado.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
         public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            txtResultadoMouseWheelMoved(evt);
         }
      });
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
            .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
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

      compilationButton.setText("Compilar");
      compilationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      compilationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      compilationButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            compilationButtonActionPerformed(evt);
         }
      });
      jToolBar1.add(compilationButton);

      javax.swing.GroupLayout panelContenedorPrincipalLayout = new javax.swing.GroupLayout(panelContenedorPrincipal);
      panelContenedorPrincipal.setLayout(panelContenedorPrincipalLayout);
      panelContenedorPrincipalLayout.setHorizontalGroup(
         panelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelContenedorPrincipalLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jSplitPane2))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorPrincipalLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      panelContenedorPrincipalLayout.setVerticalGroup(
         panelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorPrincipalLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

      modoOscuroMenuItem.setText("Modo Oscuro");
      modoOscuroMenuItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            modoOscuroMenuItemActionPerformed(evt);
         }
      });
      jMenu3.add(modoOscuroMenuItem);

      modoClaroMenuItem.setText("Modo Claro");
      modoClaroMenuItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            modoClaroMenuItemActionPerformed(evt);
         }
      });
      jMenu3.add(modoClaroMenuItem);

      jMenuBar1.add(jMenu3);

      jMenu7.setText("Ayuda");

      jMenu6.setText("Documentación");

      jMenuItem3.setText("Diseño de GCKScript");
      jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem3ActionPerformed(evt);
         }
      });
      jMenu6.add(jMenuItem3);

      jMenuItem4.setText("Manual Usuario");
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

      TSMenu.setText("Tablas de símbolos");

      TSFijaMenu.setText("TS Fija");
      TSFijaMenu.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            TSFijaMenuActionPerformed(evt);
         }
      });
      TSMenu.add(TSFijaMenu);

      TSFunciones.setText("TS Funciones");
      TSFunciones.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            TSFuncionesActionPerformed(evt);
         }
      });
      TSMenu.add(TSFunciones);

      TSArreglos.setText("TS Arreglos");
      TSArreglos.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            TSArreglosActionPerformed(evt);
         }
      });
      TSMenu.add(TSArreglos);

      jMenuItem18.setText("TS Identificadores");
      jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem18ActionPerformed(evt);
         }
      });
      TSMenu.add(jMenuItem18);
      TSMenu.add(jSeparator5);

      jMenuItem19.setText("Ver todas");
      jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem19ActionPerformed(evt);
         }
      });
      TSMenu.add(jMenuItem19);

      jMenuBar1.add(TSMenu);

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
       String tema;
       RSyntaxTextArea textArea = new RSyntaxTextArea(); // Crea una nueva instancia de RSyntaxTextArea
       RTextScrollPane scrollPane = new RTextScrollPane(textArea);
       scrollPane.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
          public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
             if (evt.isControlDown()) {
                int fontSize = textArea.getFont().getSize();
                fontSize += evt.getPreciseWheelRotation() > 0 ? -1 : 1;
                textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), fontSize));
             }
          }
       });
       panelContenedorPestañas.add("Script", scrollPane);
       directorio = new Directory(this, textArea, "GCKKKK", ".gck", panelContenedorPestañas);
       //textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_GO);

       textArea.setSyntaxEditingStyle("text/myLanguage");
       if (dark) {
          tema = "dark.xml";
       } else {
          tema = "light.xml";
       }
       textArea.setCodeFoldingEnabled(true);
       textArea.setAntiAliasingEnabled(true);
       textArea.setAnimateBracketMatching(true);
       changeStyleViaThemeXml(textArea, tema);
       textArea.setFont(fuente);
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

    private void menuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarActionPerformed
       directorio.Save();
    }//GEN-LAST:event_menuGuardarActionPerformed

    private void modoOscuroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoOscuroMenuItemActionPerformed
       dark = true;
       String tema;
       FlatAnimatedLafChange.showSnapshot();
       FlatMaterialDeepOceanIJTheme.setup();
       FlatLaf.updateUI();
       FlatAnimatedLafChange.hideSnapshotWithAnimation();

       if (dark) {
          tema = "dark.xml";
       } else {
          tema = "light.xml";
       }
       // Obtener todos los JTextArea
       List<JTextArea> textAreas = obtenerTextAreas(panelContenedorPestañas);

       // Aplicar cambios de estilo y fuente a cada JTextArea
       for (JTextArea textArea : textAreas) {
          // Cambios de estilo según el método changeStyleViaThemeXml
          changeStyleViaThemeXml((RSyntaxTextArea) textArea, tema);

          // Establecer la fuente
          textArea.setFont(fuente);
       }
    }//GEN-LAST:event_modoOscuroMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       try {
          Desktop.getDesktop().browse(new URI("https://docs.google.com/document/d/1seoKYCEsGI75csR81-TKETZ9cUdVXyy6pg3l5jwP8dw/edit?usp=sharing"));
       } catch (IOException | URISyntaxException ex) {
       }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       try {
          Desktop.getDesktop().browse(new URI("https://docs.google.com/document/d/1yc6FY7_Jf-wVLyMsxOwNdvWdntnXM8HANJwj1CX4o8I/edit?usp=sharing"));
       } catch (IOException | URISyntaxException ex) {
       }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

    }//GEN-LAST:event_jMenuItem2ActionPerformed

   private void txtResultadoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_txtResultadoMouseWheelMoved
      if (evt.isControlDown()) { // Verifica si la tecla Ctrl está presionada
         int fontSize = txtResultado.getFont().getSize();
         fontSize += evt.getPreciseWheelRotation() > 0 ? -1 : 1; // Aumenta o disminuye según la dirección de la rueda del mouse
         txtResultado.setFont(new Font(txtResultado.getFont().getName(), txtResultado.getFont().getStyle(), fontSize));
      }
   }//GEN-LAST:event_txtResultadoMouseWheelMoved

   private void compilationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compilationButtonActionPerformed
      analisisLexico();
      analisisSintactico();
      mostrarErrores();
   }//GEN-LAST:event_compilationButtonActionPerformed

   private void TSFijaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TSFijaMenuActionPerformed
      ventanaTSFija.setVisible(true);
   }//GEN-LAST:event_TSFijaMenuActionPerformed

   private void TSFuncionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TSFuncionesActionPerformed
      ventanaTSIdFunciones.setVisible(true);
   }//GEN-LAST:event_TSFuncionesActionPerformed

   private void TSArreglosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TSArreglosActionPerformed
      ventanaTSIdArreglos.setVisible(true);
   }//GEN-LAST:event_TSArreglosActionPerformed

   private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
      ventanaTS.setVisible(true);
   }//GEN-LAST:event_jMenuItem18ActionPerformed

   private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
      ventanaTS.setVisible(true);
      ventanaTSIdArreglos.setVisible(true);
      ventanaTSIdFunciones.setVisible(true);
      ventanaTSFija.setVisible(true);
   }//GEN-LAST:event_jMenuItem19ActionPerformed

   private void modoClaroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoClaroMenuItemActionPerformed
      dark = false;
      String tema;
      FlatAnimatedLafChange.showSnapshot();
      FlatMaterialLighterIJTheme.setup();
      FlatLaf.updateUI();
      FlatAnimatedLafChange.hideSnapshotWithAnimation();

      if (dark) {
         tema = "dark.xml";
      } else {
         tema = "light.xml";
      }
      // Obtener todos los JTextArea
      List<JTextArea> textAreas = obtenerTextAreas(panelContenedorPestañas);

      // Aplicar cambios de estilo y fuente a cada JTextArea
      for (JTextArea textArea : textAreas) {
         // Cambios de estilo según el método changeStyleViaThemeXml
         changeStyleViaThemeXml((RSyntaxTextArea) textArea, tema);

         // Establecer la fuente
         textArea.setFont(fuente);
      }
   }//GEN-LAST:event_modoClaroMenuItemActionPerformed

   private void changeStyleViaThemeXml(RSyntaxTextArea textArea, String xml) {
      try {
         Theme theme = Theme.load(new FileInputStream(xml));
         theme.apply(textArea);
      } catch (IOException ioe) {
      }
   }

   private void RSyntax() {
      RSyntaxTextArea textArea = new RSyntaxTextArea();
      RTextScrollPane scrollPane = new RTextScrollPane(textArea);
      String tema;

      //METODO PARA HACER ZOOM AL CODIGO
      scrollPane.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
         public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            if (evt.isControlDown()) {
               int fontSize = textArea.getFont().getSize();
               fontSize += evt.getPreciseWheelRotation() > 0 ? -1 : 1;
               textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), fontSize));
            }
         }
      });
      panelContenedorPestañas.add("Script", scrollPane);
      directorio = new Directory(this, textArea, "GCKKKK", ".gck");
      //textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_GO);

      textArea.setSyntaxEditingStyle("text/myLanguage");
      textArea.setCodeFoldingEnabled(true); //Para contraer partes del codigo

      if (dark) {
         tema = "dark.xml";
      } else {
         tema = "light.xml";
      }
      textArea.setAntiAliasingEnabled(true);
      textArea.setAnimateBracketMatching(true);
      changeStyleViaThemeXml(textArea, tema);
      textArea.setFont(fuente);

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
      }
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new VentanaPrincipal().setVisible(true);
         }
      });

   }
   
   private void analisisLexico() {
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
      DefaultTableModel TablaFunciones = (DefaultTableModel) tablaFunciones.getModel();
      vaciarTabla(TablaFunciones, tablaFunciones);
      DefaultTableModel TablaArreglos = (DefaultTableModel) tablaArreglos.getModel();
      vaciarTabla(TablaArreglos, tablaArreglos);
      DefaultTableModel TablaIdentificadores = (DefaultTableModel) tablaIdentificadores.getModel();
      vaciarTabla(TablaIdentificadores, tablaIdentificadores);
      
      AnalizarFunciones.analizarCodigo(texto, tablaFunciones, tablaArreglos,tablaIdentificadores);
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
               ComponentesLexicos = lexer.tablaToken.getTokens();
               errores = lexer.tablaError.getErrores();
               //llenarTSIdentificadores();
               llenarTabla();

               return;
            }
         }
      } catch (FileNotFoundException ex) {
         Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
         Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   private void analisisSintactico() {
      

      
   }

   private void llenarTSIdentificadores() {

      DefaultTableModel dm = (DefaultTableModel) tablaIdentificadores.getModel();
      dm.setRowCount(0);
      for (Token entry : ComponentesLexicos) {
         if (entry.grupoLexico.equals("Identificador")) {
            Object[] campos = {entry.lexema, entry.hashCode(), entry.linea, entry.columna};
            dm.addRow(campos);
         }
      }
      tablaIdentificadores.setModel(dm);
   }

   private void llenarTabla() {

      DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
      dm.setRowCount(0);

      for (Token entry : ComponentesLexicos) {
         Object[] campos = {entry.lexema, entry.grupoLexico};
         dm.addRow(campos);
      }
      jTable1.setModel(dm);
   }

   private void mostrarErrores() {
      int errorSize = errores.size();
      if (errorSize > 0) {
         txtResultado.setForeground(new Color(219, 88, 88));
         txtResultado.setText("");
         for (ErrorToken error : errores) {
            txtResultado.setText(txtResultado.getText() + "\n" + String.valueOf(error));
         }
         txtResultado.setText(txtResultado.getText() + "\n\n" + "-> Compilación finalizada con errores");
      } else {
         txtResultado.setForeground(new Color(120, 212, 110));
         txtResultado.setText("-> Compilación finalizada sin errores");
      }

   }

   public static void vaciarTabla(DefaultTableModel Modelo, JTable JT) {
      //Inicializamos la tabla con un modelo
      Modelo = (DefaultTableModel) JT.getModel();
      int i = 0;
      while (i < Modelo.getRowCount()) {
         Modelo.removeRow(i);
      }//metodo while para remover los renglones de la tabla
   }

   private Font cargarFuenteDesdeArchivo(String rutaArchivo) {
      try {
         // Cargar la fuente desde el archivo TTF
         return Font.createFont(Font.TRUETYPE_FONT, new BufferedInputStream(new FileInputStream(rutaArchivo)));
      } catch (FontFormatException | IOException e) {
         e.printStackTrace();
         // En caso de error, retornar una fuente predeterminada
         return new Font("Arial", Font.PLAIN, 16);
      }
   }

   private static List<JTextArea> obtenerTextAreas(JTabbedPane panelContenedorPestañas) {
      List<JTextArea> textAreas = new ArrayList<>();

      // Itera sobre todos los paneles en el JTabbedPane
      for (int i = 0; i < panelContenedorPestañas.getTabCount(); i++) {
         Component componente = panelContenedorPestañas.getComponentAt(i);

         // Verifica si el componente es un JScrollPane
         if (componente instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) componente;

            // Obtén el componente interno del JScrollPane
            Component componenteInterno = scrollPane.getViewport().getView();

            // Verifica si el componente interno es un JTextArea
            if (componenteInterno instanceof JTextArea) {
               JTextArea textArea = (JTextArea) componenteInterno;
               textAreas.add(textArea); // Agrega el JTextArea a la lista
            }
         }
      }

      return textAreas;
   }
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JMenuItem TSArreglos;
   private javax.swing.JMenuItem TSFijaMenu;
   private javax.swing.JMenuItem TSFunciones;
   private javax.swing.JMenu TSMenu;
   private javax.swing.JButton compilationButton;
   private javax.swing.JPanel contenedorBaseLexico;
   private javax.swing.JPanel contenedorBaseTS;
   private javax.swing.JPanel contenedorBaseTS1;
   private javax.swing.JPanel contenedorBaseTS2;
   private javax.swing.JPanel contenedorBaseTS3;
   private javax.swing.JMenu jMenu1;
   private javax.swing.JMenu jMenu2;
   private javax.swing.JMenu jMenu3;
   private javax.swing.JMenu jMenu6;
   private javax.swing.JMenu jMenu7;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JMenuItem jMenuItem1;
   private javax.swing.JMenuItem jMenuItem10;
   private javax.swing.JMenuItem jMenuItem11;
   private javax.swing.JMenuItem jMenuItem12;
   private javax.swing.JMenuItem jMenuItem13;
   private javax.swing.JMenuItem jMenuItem14;
   private javax.swing.JMenuItem jMenuItem18;
   private javax.swing.JMenuItem jMenuItem19;
   private javax.swing.JMenuItem jMenuItem2;
   private javax.swing.JMenuItem jMenuItem3;
   private javax.swing.JMenuItem jMenuItem4;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane3;
   private javax.swing.JScrollPane jScrollPane4;
   private javax.swing.JScrollPane jScrollPane5;
   private javax.swing.JPopupMenu.Separator jSeparator1;
   private javax.swing.JPopupMenu.Separator jSeparator2;
   private javax.swing.JPopupMenu.Separator jSeparator3;
   private javax.swing.JPopupMenu.Separator jSeparator4;
   private javax.swing.JPopupMenu.Separator jSeparator5;
   private javax.swing.JSplitPane jSplitPane2;
   private javax.swing.JSplitPane jSplitPane3;
   private javax.swing.JSplitPane jSplitPane4;
   private javax.swing.JTabbedPane jTabbedPane1;
   private javax.swing.JTabbedPane jTabbedPane2;
   private javax.swing.JTable jTable1;
   private javax.swing.JToolBar jToolBar1;
   private javax.swing.JTree jTree1;
   private javax.swing.JTree jTree2;
   private javax.swing.JMenuItem menuAbrir;
   private javax.swing.JMenuItem menuCerrar;
   private javax.swing.JMenuItem menuGuardar;
   private javax.swing.JMenuItem menuGuardarComo;
   private javax.swing.JMenuItem menuNuevo;
   private javax.swing.JMenuItem menuSalir;
   private javax.swing.JMenuItem modoClaroMenuItem;
   private javax.swing.JMenuItem modoOscuroMenuItem;
   private javax.swing.JPanel panelBaseDerecho;
   private javax.swing.JPanel panelBaseIzquierdo;
   private javax.swing.JPanel panelBasePestañas;
   private javax.swing.JTabbedPane panelContenedorPestañas;
   private javax.swing.JPanel panelContenedorPrincipal;
   private javax.swing.JInternalFrame pantalla;
   private javax.swing.JScrollPane scrollLexico;
   private javax.swing.JScrollPane scrollTS;
   private javax.swing.JScrollPane scrollTS1;
   private javax.swing.JTable tablaArreglos;
   private javax.swing.JTable tablaFija;
   private javax.swing.JTable tablaFunciones;
   private javax.swing.JTable tablaIdentificadores;
   private javax.swing.JTextPane txtResultado;
   private javax.swing.JFrame ventanaLexico;
   private javax.swing.JFrame ventanaTS;
   private javax.swing.JFrame ventanaTSFija;
   private javax.swing.JFrame ventanaTSIdArreglos;
   private javax.swing.JFrame ventanaTSIdFunciones;
   // End of variables declaration//GEN-END:variables
}
