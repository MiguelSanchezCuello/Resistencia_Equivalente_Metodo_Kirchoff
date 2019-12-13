
import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Coto
 */
public class ResistenciaGUI extends javax.swing.JFrame {
    // Algunas variables de utilidad. declaradas publicas por simplicidad
    public static int nodos = 0;
    public static double valorFuente = 1;
    public static double[][] matrizEcuaciones;
    public static double[] matrizResultados;
    public static double[] matrizSolucion;
    public static LinearSystemSolver ResuelveSistema;
    //public static ArrayList<Double> resistencias = new ArrayList<Double>();
    public static Vector<Double> resistencias = new Vector<Double>();
    public static agregarResistenciaForm agregar = new agregarResistenciaForm();
    
    // Modelo de lista para hacer acciones con la lista.
    public static DefaultListModel listModel = new DefaultListModel();

    // Metodo auxiliar que valida los datos antes de ser agregados.
    private static boolean validaDatosIngresados(int nodoA, int nodoB, double resValue) {
        if (nodoA == nodoB){ 
            JOptionPane.showMessageDialog(null, "Error. No puede conectar las "
                    + "dos terminales del componente al mismo nodo.\nPor favor"
                    + "Ingrese valores validos", 
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return false; 
        }
        if (nodoA <= 0 || nodoB <=0 || resValue <= 0 || nodos < 1){
            JOptionPane.showMessageDialog(null, "Error. Datos no validos.\nPor "
                    + "favor verifique los datos.", 
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        if (nodoA > nodos || nodoB > nodos){
            JOptionPane.showMessageDialog(null, "Error. Ninguno de los nodos puede ser "
                    + "mayor al total de nodos.\nPor favor verifique los datos.", 
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
        
        
        
    }
    
    /**
     * Creates new form ResistenciaGUI
     */
    public ResistenciaGUI() {
        initComponents();
        this.setResizable(false);
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
        btnAddResistor = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaResistencia = new javax.swing.JList(resistencias);
        jLabel2 = new javax.swing.JLabel();
        lblNodos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnVerMatriz = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resistencia Equivalente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Calculador de Resistencia equivalente usando Kirckhoff"));

        btnAddResistor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resistencia_2.png"))); // NOI18N
        btnAddResistor.setText("AGREGAR");
        btnAddResistor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddResistorMouseClicked(evt);
            }
        });
        btnAddResistor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddResistorActionPerformed(evt);
            }
        });

        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel1.setText("ELEMENTOS");

        listaResistencia.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaResistencia);

        jLabel2.setText("NODOS:");

        lblNodos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNodos.setText("0");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        btnVerMatriz.setText("ver Matriz");
        btnVerMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMatrizActionPerformed(evt);
            }
        });

        btnResolver.setText("Resolver");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblNodos)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVerMatriz)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(btnResolver)
                            .addComponent(btnAddResistor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddResistor, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerMatriz)
                        .addGap(18, 18, 18)
                        .addComponent(btnResolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNodos)
                        .addGap(38, 38, 38))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddResistorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddResistorMouseClicked
        // TODO add your handling code here:  
    }//GEN-LAST:event_btnAddResistorMouseClicked

    private void btnAddResistorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddResistorActionPerformed
        // TODO add your handling code here:
        if (nodos == 0){
            agregar.txtNodoInicial.enable(false);
            agregar.txtNodoFinal.enable(false);
            JOptionPane.showMessageDialog(null, "Error. Debe ingresar "
                    + "un numero valido de nodos", 
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            agregar.setVisible(true);
            agregar.txtNodoInicial.setText(null);
            agregar.txtNodoFinal.setText(null);
            agregar.txtValorResistencia.setText(null);
        }
    }//GEN-LAST:event_btnAddResistorActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        // Reiniciar todos los componentes que almacenan datos
        nodos = 0; // Inicializar los nodos a 0 nuevamente.
        String strlblNodos = "0";
        boolean valido = false;
        agregar = new agregarResistenciaForm();
        //listModel = new DefaultListModel();
        listaResistencia.setModel(new DefaultListModel());
        jTextArea1.setText("");
        jTextArea2.setText("");
        lblNodos.setText(strlblNodos);
        
        // Pedir la cantidad de Nodos.
        try{
            strlblNodos =JOptionPane.showInputDialog("Entre la "
                    + "cantidad de nodos");
            nodos = Integer.parseInt(strlblNodos);
            
            valido = true;
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error. Ingrese un "
                 + "numero valido", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
        // Asignar el tamaño a la matriz que sera del orden al numero de nodos.
        matrizEcuaciones = new double[nodos-1][nodos-1];
        for (int i = 0; i < matrizEcuaciones.length; i++){
            for (int j = 0; j < matrizEcuaciones.length; j++){
                matrizEcuaciones[i][j] = 0;
            }
        }
        matrizResultados = new double[nodos -1]; 
        // Llenar la matriz resultado
        for (int i = 0; i < matrizResultados.length; i++){
            matrizResultados[i] = 0;
            // Asi se tiene una matriz cuyo unico valor 
            // es el primer valor y es 1(la corriente)
            if (i == 0){
                matrizResultados[i] = valorFuente;
            }
        }
        // Se inicializa la matriz solucion. Para asignar el tamaño.
        matrizSolucion = new double[nodos-1]; 
        resistencias = new Vector<Double>();
                
        if (valido == true){
            lblNodos.setText(strlblNodos);
        } else
        {
            lblNodos.setText("0");
        }
        
        
    }//GEN-LAST:event_btnIniciarActionPerformed
    
    // Metodo que permite ver la matriz de datos ( sistema de ecuaciones)
    private void btnVerMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMatrizActionPerformed
       
        String txt = "";
        if ( matrizEcuaciones == null) {
            JOptionPane.showMessageDialog(null, "Error. No hay datos validos.\n"
                 + "verifique los datos", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            double aux;
            // Este ciclo es para redondear los valores de la matriz para mejor visualizacion.
            for (int i = 0; i < matrizEcuaciones.length; i++){
                for (int j = 0; j < matrizEcuaciones.length; j++){
                     aux = matrizEcuaciones[i][j];
                     aux = Math.round(aux*10.0)/10.0;
                     txt = txt + Double.toString(aux) + "      ";
                }
                txt = txt + "\n";
            } 
            jTextArea1.setText(txt);  
        }
    }//GEN-LAST:event_btnVerMatrizActionPerformed

    // Aca se resuelve el sistema de ecuaciones (la matriz)
    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        
        // En estas dos lineas se resuelven las ecuaciones.
        ResuelveSistema = new LinearSystemSolver(matrizEcuaciones,matrizResultados);
        matrizSolucion = ResuelveSistema.solveSystem(matrizEcuaciones, matrizResultados);
        
        
        // Lo demas es solo para mostrar los datos.
        String txt = "";
        
        double aux;
        aux = matrizSolucion[0];
        txt = Double.toString(aux);
        // Probando con todos los valores del vector, aunque solo se necesita el primero.
        /*for (int i = 0; i < matrizSolucion.length; i++){
            aux = matrizSolucion[i];
            aux = Math.round(aux*100.0)/100.0;
            txt = txt +Double.toString(aux) + "  ";
        }*/
        
        jTextArea2.setText(txt);
    }//GEN-LAST:event_btnResolverActionPerformed
    

    // Este metodo agrega la resistencia al arraylist de valores de las 
    // resistencias y ademas agrega el valor a la matriz de valores
    public static void agregarResistencia(int nodoA, int nodoB, double resValue){       
        if ( validaDatosIngresados(nodoA, nodoB, resValue) ) {
            resistencias.add(resValue);
        
            listModel = new DefaultListModel();
            // Agrega las resistencias del lado izquierdo para que se vea la 
            // lista de las ya añadidas
            for (int i = 0; i < resistencias.size(); i++){
                listModel.addElement("R " + (i+1) + ": "+resistencias.get(i));
            }

            listaResistencia.setModel(listModel);
            agregar.hide();

            int contador = 0;
            // Agrega las resistencias en la diagonal principal.
            for (int fil = 0; fil < nodos - 1; fil++){
                for (int col = 0; col < nodos - 1; col++){
                    // Para llenar la diagonal principal
                    if (nodoA-1 == fil && nodoA-1 == col){
                        matrizEcuaciones[fil][col] += (1/resValue);
                    }
                    if (nodoB-1 == fil && nodoB-1 == col){
                        matrizEcuaciones[fil][col] += (1/resValue);
                    }
                }
            } // Fin del for para llenar la diagonal principal.

            // For para llenar las diagonales al lado de la principal.
            for (int filas = 0; filas < matrizEcuaciones.length; filas++){
                for (int columnas = 0; columnas < matrizEcuaciones.length; columnas++){
                    if ((nodoB - nodoA == 1 || nodoA - nodoB == 1)){
                        if (contador < 1 && (nodoA-1 <= filas || nodoB <= columnas)){
                            contador++;
                            matrizEcuaciones[nodoA-1][nodoB-1] = -(1/resValue);
                            matrizEcuaciones[nodoB-1][nodoA-1] = -(1/resValue);
                        }
                    }
                }
            }

            // Para llenar 2 diagonal exterior a la principal.
            for (int filas = 0; filas < matrizEcuaciones.length; filas++){
                for (int columnas = 0; columnas < matrizEcuaciones.length; columnas++){
                    if ((nodoB - nodoA == 2 || nodoA - nodoB == 2)){
                        if (contador < 1 && (nodoA-1 <= filas || nodoB <= columnas)){
                            contador++;
                            matrizEcuaciones[nodoA-1][nodoB-1] = -(1/resValue);
                            matrizEcuaciones[nodoB-1][nodoA-1] = -(1/resValue);
                        }
                    }
                }
            }
            
            
            // Para llegar la 3ra diagonal exterior a la principal
            for (int filas = 0; filas < matrizEcuaciones.length; filas++){
                for (int columnas = 0; columnas < matrizEcuaciones.length; columnas++){
                    if ((nodoB - nodoA == 3 || nodoA - nodoB == 3)){
                        if (contador < 1 && (nodoA-1 <= filas || nodoB <= columnas)){
                            contador++;
                            matrizEcuaciones[nodoA-1][nodoB-1] = -(1/resValue);
                            matrizEcuaciones[nodoB-1][nodoA-1] = -(1/resValue);
                        }
                    }
                }
            }
            
            // Para llegar la 4ta diagonal exterior a la principal
            for (int filas = 0; filas < matrizEcuaciones.length; filas++){
                for (int columnas = 0; columnas < matrizEcuaciones.length; columnas++){
                    if ((nodoB - nodoA == 4 || nodoA - nodoB == 4)){
                        if (contador < 1 && (nodoA-1 <= filas || nodoB <= columnas)){
                            contador++;
                            matrizEcuaciones[nodoA-1][nodoB-1] = -(1/resValue);
                            matrizEcuaciones[nodoB-1][nodoA-1] = -(1/resValue);
                        }
                    }
                }
            }
            
            // Para llegar la 5ta diagonal exterior a la principal
            for (int filas = 0; filas < matrizEcuaciones.length; filas++){
                for (int columnas = 0; columnas < matrizEcuaciones.length; columnas++){
                    if ((nodoB - nodoA == 5 || nodoA - nodoB == 5)){
                        if (contador < 1 && (nodoA-1 <= filas || nodoB <= columnas)){
                            contador++;
                            matrizEcuaciones[nodoA-1][nodoB-1] = -(1/resValue);
                            matrizEcuaciones[nodoB-1][nodoA-1] = -(1/resValue);
                        }
                    }
                }
            }
            
            // Mas de 5 diagonales seria un exceso, sin embargo se esta trabajando
            // en un algoritmo que no tenga esta limitacion.
           
            //Ahora habilita los botones verMatriz y resolverMatriz
            btnVerMatriz.enable(true);
            btnResolver.enable();
        
        // Luego agregare otros ciclos para llegar la tercera diagonal principal y la cuarta.
        // por si el profe quiere que explote. Cuando tenga el tiempo diseño el algoritmo para que
        // sea generico y no tenga tanto codigo repetido.
      
        }  // Fin de la condicion if validaDatosIngresados
    } // Fin del metodo agregarResistencia.
    
    
   
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
            java.util.logging.Logger.getLogger(ResistenciaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResistenciaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResistenciaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResistenciaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResistenciaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddResistor;
    private javax.swing.JButton btnIniciar;
    private static javax.swing.JButton btnResolver;
    private static javax.swing.JButton btnVerMatriz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblNodos;
    public static javax.swing.JList listaResistencia;
    // End of variables declaration//GEN-END:variables
}
