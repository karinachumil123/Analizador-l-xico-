
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

  
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "RoboMind";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".ka");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(51, 0, 102));
        rootPanel.setForeground(new java.awt.Color(51, 0, 102));

        buttonsFilePanel.setBackground(new java.awt.Color(102, 0, 102));
        buttonsFilePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        buttonsFilePanel.setForeground(new java.awt.Color(153, 0, 153));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarC)
                    .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar)
                            .addComponent(btnAbrir)
                            .addComponent(btnNuevo))))
                .addContainerGap())
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(34, 34, 34)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(29, 29, 29)
                .addComponent(btnGuardarC)
                .addGap(14, 14, 14))
        );

        jtpCode.setForeground(new java.awt.Color(255, 0, 0));
        jtpCode.setCaretColor(new java.awt.Color(255, 204, 0));
        jtpCode.setSelectionColor(new java.awt.Color(102, 255, 102));
        jScrollPane1.setViewportView(jtpCode);

        panelButtonCompilerExecute.setBackground(new java.awt.Color(102, 0, 102));
        panelButtonCompilerExecute.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        panelButtonCompilerExecute.setForeground(new java.awt.Color(102, 0, 102));

        btnCompilar.setBackground(new java.awt.Color(51, 0, 51));
        btnCompilar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCompilar.setForeground(new java.awt.Color(255, 255, 255));
        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCompilar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnCompilar)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(51, 0, 51));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setForeground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setBackground(new java.awt.Color(204, 204, 255));
        tblTokens.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblTokens);

        jLabel1.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FASES DEL COMPILADOR");

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonsFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void executeCode(ArrayList<String> blocksOfCode, int repeats) {
        for (int j = 1; j <= repeats; j++) {
            int repeatCode = -1;
            for (int i = 0; i < blocksOfCode.size(); i++) {
                String blockOfCode = blocksOfCode.get(i);
                if (repeatCode != 1) {
                    int[] posicionMarcador = CodeBlock.getPositionOfBothMarkers(blocksOfCode, blockOfCode);
                    executeCode(new ArrayList<>(blocksOfCode.subList(posicionMarcador[0], posicionMarcador[1])), repeatCode);
                    repeatCode = -1;
                    i = posicionMarcador[1];
                }
                else{
                    String[] sentences = blockOfCode.split(";");
                    for(String sentence: sentences){
                        sentence = sentence.trim();
                        if(sentence.startsWith("pintar")){
                            String parametro;
                            if(sentence.contains("$")){
                                parametro = identificadores.get(sentence.substring(9, sentence.length()-2));
                            }
                            else{
                                parametro = sentence.substring(9, sentence.length()-2);
                            }
                            System.out.println("Pintando de color"+ parametro+"...");
                        }
                        else if(sentence.startsWith("izquierda")){
                            System.out.println("Movimiendose a la izquierda");
                        }
                        else if(sentence.startsWith("derecha")){
                            System.out.println("Movimiendose a la derecha");
                        }
                        else if(sentence.startsWith("adelante")){
                            System.out.println("Movimiendose hacia adelante");
                        }
                        else if(sentence.contains("-->")){
                            System.out.println("Declarando identificador...");
                        }
                        else if(sentence.contains("atras")){
                            System.out.println("Moviendose hacia atras...");
                        }
                        else if(sentence.startsWith("repetir")){
                            String parametro;
                            if(sentence.contains("$")){
                                parametro = identificadores.get(sentence.substring(10, sentence.length()-2));
                            }
                            else{
                                parametro = sentence.substring(10, sentence.length() -2);
                            }
                            repeatCode = Integer.parseInt(parametro);
                        }
                    }
                
                }
            }
        }
    }

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);

        /* Eliminacion de Errores*/
        gramatica.delete(new String[]{"ERROR", "ERROR_1", "ERROR_2"}, 1);

        /* agrupacion de valores*/
        gramatica.group("VALOR", "(NUMERO | COLOR)", true);

        /*Declaracion de variables*/
        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR OPERADOR_ASIG VALOR", true, identProd);
        gramatica.group("VARIABLE", "TIPO_DATO OPERADOR_ASIG VALOR", true,
                2, "error sintáctico {}: falta el identificador en la variable [#, %]");

        gramatica.finalLineColumn();

        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR OPERADOR_ASIG", 3,
                "error sintáctico {}: falta el valor de la declaracion [#,%]");

        gramatica.initialLineColumn();

        /* Eliminacion de tipo de dato y operadores de asignacion*/
        gramatica.delete("TIPO_DATO", 4,
                "Error sintáctico {}: el tipo de dato no esta en una declaracion [#,%]");

        gramatica.delete("OPERADOR_ASIG", 5,
                "Error sintáctico {}: el tipo de dato no esta en una declaracion [#,%]");

        /* Agrupar de identificadores y definicion de parámetros */
        gramatica.group("VALOR", "IDENTIFICADOR", true);
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

        /*Agrupacion de funciones*/
        gramatica.group("FUNCION", "(MOVIMIENTO | PINTAR | DETENER_PINTAR | TOMAR | "
                + "LANZAR_MONEDA | VER | DETENER_REPETIR)", true);
        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)? PARENTESIS_C", true);
        gramatica.group("FUNCION_COMP", "FUNCION (VALOR | PARAMETROS)? PARENTESIS_C", true,
                6, "error sintáctico {}: falta el parentesis que abre en la funcion [#, %]");

        gramatica.finalLineColumn();
        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)", true,
                7, "error sintáctico {}: falta el parentesis que cierre en la funcion [#, %]");

        gramatica.initialLineColumn();

        /* Eliminacion de funciones incompletas*/
        gramatica.delete("FUNCION", 8, "erro sintáctico {}: la funcion no está declarada correctamente");

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {

            gramatica.group("EXP_LOGICA", "(FUNCION_COMP | EXP_LOGICA) (OPER_LOG (FUNCION_COMP | EXP_LOGICA))+");
            gramatica.group("EXP_LOGICA", "PARENTESIS_A (EXP_LOGICA | FUNCION_COMP) PARENTESIS_C");

        });

        /*Eliminacion de operadores logicos*/
        gramatica.delete("OPER_LOG", 10,
                "error sintáctico {}: el operador lógico no esta contenido en una expresion");
        /*Agrupacion de Expresiones logicas como valor y parametros*/
        gramatica.group("VALOR", "EXP_LOGICA");
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

        /*Agrupacion de estructuras de control*/
        gramatica.group("EST_CONTROL", "(REPETIR | ESTRUCTURA_SI)");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A PARENTESIS_C");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL (VALOR | PARAMETROS");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A (VALOR | PARAMETROS) PARENTESIS_C ");

        /*ELIMINACION DE ESTRUCTURAS DE CONTROL INCOMPLETAS*/
        gramatica.delete("EST_CONTROL", 11,
                "error sintactico {}: la estructura de control no esta declarada correctamente [#, %]");

        /*ELIMINACION DE PARENTESIS*/
        gramatica.delete(new String[]{"PARENTESIS_A", "PARENTESIS_C"}, 12,
                "error sintactico {}: el parentesis [] no esta contenido en una agrupacion [#, %]");

        gramatica.finalLineColumn();
        /*Verificacion de punto y coma al final de una sentencia*/
        //identificadores o variables
        gramatica.group("VARIABLE_PC", "VARIABLE PUNTO_COMA", true);
        gramatica.group("VARIABLE_PC", "VARIABLE", true,
                13, "error sintactico{}: falta el punto y coma al final de la variable [#, %]");

        /*funciones*/
        gramatica.group("FUNCION_COMP_PC", "FUNCION_COMP PUNTO_COMA");
        gramatica.group("FUNCION_COMP_PC", "FUNCION_COMP", 14,
                "error sintáctico {}: falta el punto y coma al final de la declaracion de funcion");

        gramatica.initialLineColumn();
        /*eliminaion el punto y coma*/
        gramatica.delete("PUNTO_COMA", 15,
                "error sintactico {}: el punto y coma no está al final de una sentencia");

        /*SENTENCIAS*/
        gramatica.group("SENTENCIAS", "(VARIABLE_PC | FUNCION_COMP_PC)+");

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP LLAVE_A (SENTENCIAS)? LLAVE_C", true);
            gramatica.group("SENTENCIAS", "(SENTENCIAS | EST_CONTROL_COMP_LASLC)+");

        });

      
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.initialLineColumn();

            gramatica.group("ESTE_CONTROL_COMP_LASLC", "EST_CONTROL_COMP(SENTECIAS)? LLAVE_C", true,
                    15, "error sintactico {}: falta la llave que abre en la estructura de control");

            gramatica.finalLineColumn();

            gramatica.group("ESTE_CONTROL_COMP_LASLC", "EST_CONTROL_COMP LLAVE_A (SENTECIAS)", true,
                    15, "error sintactico {}: falta la llave que cierra en la estructura de control");

            gramatica.group("SENTENCIAS", "(SENTENCIAS | EST_CONTROL_COMP_LASLC)");
        });

        gramatica.delete(new String[]{"LLAVE_A", "LLAVE_C"}, 16,
                "error sintáctico {}: la llave [] no esta contenida en una agrupacion [#, %]");

        gramatica.show();
    }

    private void semanticAnalysis() {
        HashMap<String, String> identDataType = new HashMap<>();
        identDataType.put("color", "COLOR");
        identDataType.put("número", "NUMERO");
        for (Production id : identProd) {
            if (!identDataType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1))) {
                errors.add(new ErrorLSSL(1, "error semantico {}: valor no compatible con el tipo de dato [#, %]", id, true));
            } else if (id.lexicalCompRank(-1).equals("COLOR") && !id.lexemeRank(-1).matches("#[0-9a-fA-F]+")) {
                errors.add(new ErrorLSSL(2, "error semantico {}: El color no es un numero hexadecimal [#, %]", id, false));

            } else {
                identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
            }

        }
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
