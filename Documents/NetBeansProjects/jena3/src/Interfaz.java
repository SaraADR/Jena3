import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import jena3.Jena3;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;


public class Interfaz extends javax.swing.JFrame {

    Jena3 jena;
    public Interfaz() {
        this.jena = new Jena3();
        LogCtl.setCmdLogging();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textoConsulta = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        solConsulta = new javax.swing.JTextArea();
        URL = new javax.swing.JTextField();
        archivoLocal = new javax.swing.JButton();
        aceptarURL = new javax.swing.JButton();
        GuardarConsulta = new javax.swing.JButton();
        consulta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoConsulta.setColumns(20);
        textoConsulta.setRows(5);
        jScrollPane1.setViewportView(textoConsulta);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Generador de consultas SPARQL");

        jLabel2.setText("Ingrese aqui su consulta:");

        solConsulta.setEditable(false);
        solConsulta.setColumns(20);
        solConsulta.setRows(5);
        jScrollPane2.setViewportView(solConsulta);

        archivoLocal.setText("Elegir archivo de datos local");
        archivoLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoLocalActionPerformed(evt);
            }
        });

        aceptarURL.setText("Cargar URL");
        aceptarURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarURLActionPerformed(evt);
            }
        });

        GuardarConsulta.setText("Guardar solución");
        GuardarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarConsultaActionPerformed(evt);
            }
        });

        consulta.setText("Probar consulta");
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });

        jLabel4.setText("Escriba URL o escoja elegir archivos de datos local");

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(consulta)
                                .addGap(18, 18, 18)
                                .addComponent(GuardarConsulta)
                                .addGap(18, 18, 18)
                                .addComponent(Limpiar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(archivoLocal)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(URL, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(aceptarURL)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(archivoLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(URL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptarURL))
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Limpiar)
                    .addComponent(GuardarConsulta)
                    .addComponent(consulta))
                .addGap(11, 11, 11))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarConsultaActionPerformed
        botonURI = false;
        JFileChooser fc = new JFileChooser(".");
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int res = fc.showSaveDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            String destino = fc.getSelectedFile().getPath();      
            BufferedWriter writer =null;
            try {
                writer = new BufferedWriter( new FileWriter( destino + ".rdf" ));
                writer.write(solConsulta.getText());
                writer.close();
                JOptionPane.showMessageDialog(null, "Encontrará su archivo en el destino indicado",
                                                "Guardado", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_GuardarConsultaActionPerformed

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
            String mensaje = textoConsulta.getText();
            if("".equals(mensaje)){
                JOptionPane.showMessageDialog(null, "Indique consulta",
                                                "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                String resultados = "";
                if (botonURI == false){
                    resultados = jena.hacerConsulta(mensaje);
                }else{
                resultados = jena.hacerConsultaRemota(mensaje);
                }
                if("".equals(resultados)){
                    resultados = "La consulta no ha dado resultados";
                }
                solConsulta.setText(resultados);
            }      
    }//GEN-LAST:event_consultaActionPerformed

    private void aceptarURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarURLActionPerformed
            botonURI = false;
            String remoto = URL.getText();
            boolean set = jena.setURL(remoto);
            if(set == true){
            botonURI =true;    
            JOptionPane.showMessageDialog(textoConsulta,   "Escriba su consulta","URI seleccionada",
                    INFORMATION_MESSAGE );
            }else{
              JOptionPane.showMessageDialog(textoConsulta,   "La URL no es valida ","URI seleccionada",
                    ERROR_MESSAGE );  
            }
            
    }//GEN-LAST:event_aceptarURLActionPerformed

    private void archivoLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoLocalActionPerformed
       JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            try {
            String path = fc.getSelectedFile().getAbsolutePath();
            Model datos = RDFDataMgr.loadModel(path);
            //URL.setText(path);
            jena.setModel(datos);
            JOptionPane.showMessageDialog(textoConsulta, "Escriba su consulta","Archivo cargado",
                       INFORMATION_MESSAGE);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(textoConsulta, "archivo no válido",
                        "Fallo al abrir", ERROR_MESSAGE);
            }

        }
        
    }//GEN-LAST:event_archivoLocalActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        solConsulta.setText("");
        textoConsulta.setText("");
        jena.setModel(null);
        jena.setURL("");
        URL.setText("");
    }//GEN-LAST:event_LimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    boolean botonURI = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GuardarConsulta;
    private javax.swing.JButton Limpiar;
    private javax.swing.JTextField URL;
    private javax.swing.JButton aceptarURL;
    private javax.swing.JButton archivoLocal;
    private javax.swing.JButton consulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea solConsulta;
    private javax.swing.JTextArea textoConsulta;
    // End of variables declaration//GEN-END:variables
}
