/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import excepciones.PersistenciaException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetoNegocio.Genero;
import persistencia.Conexion;
import persistencia.Generos;
import persistencia.Peliculas;

/**
 *
 * @author Francisco
 */
public class VentanaGeneros extends javax.swing.JFrame {

    /**
     * Creates new form VentanaGeneros
     */
    public VentanaGeneros() {
        initComponents();
        this.setLocationRelativeTo(null);
        botonActualizar.setEnabled(false);
        botonEliminar.setEnabled(false);
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }

    public void limpiarCampos() {
        campoClave.setText("");
        campoNombre.setText("");
        campoTipoMedio.setText("");
        campoClave.setEnabled(true);
    }

    public void mostrarDatos(String valor) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Clave");
            modelo.addColumn("Nombre");
            modelo.addColumn("Tipo Medio");

            tablaGeneros.setModel(modelo);
            String sql = "";
            if (valor.equals("")) {
                sql = "SELECT * FROM generos";
            } else {
                sql = "SELECT * FROM generos WHERE clave='" + valor + "'";
            }
            String[] datos = new String[3];
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConexion();
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    modelo.addRow(datos);
                }
                tablaGeneros.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(Peliculas.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(Peliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        botonAgregar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoClave2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoTipoMedio = new javax.swing.JTextField();
        tablaGeneros = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();
        campoClave = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        botonMostrarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GENEROS");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel9.setText("OPCIONES");

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(botonAgregar)
                .addGap(64, 64, 64)
                .addComponent(botonActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(botonRegresar)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CLAVE:");

        campoClave2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoClave2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoClave2KeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("NOMBRE:");

        campoNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("TIPO MEDIO:");

        campoTipoMedio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoTipoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTipoMedioActionPerformed(evt);
            }
        });
        campoTipoMedio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTipoMedioKeyTyped(evt);
            }
        });

        tablaGeneros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
            }
        ));
        tablaGeneros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaGenerosFocusGained(evt);
            }
        });
        tablaGeneros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGenerosMouseClicked(evt);
            }
        });

        botonBuscar.setText("Buscar Por Clave");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        campoClave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("CLAVE:");

        botonMostrarDatos.setText("Mostrar Todo");
        botonMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoTipoMedio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonMostrarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addGap(97, 97, 97))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(botonBuscar)
                                .addGap(60, 60, 60))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tablaGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoClave2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(campoTipoMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoClave2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(botonMostrarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(tablaGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        if (campoClave.getText().trim().length() == 0 || campoNombre.getText().trim().length() == 0
                || campoTipoMedio.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFQUE QUE NO HAYA CAMPOS VACIOS");
        } else {
            try {
                Conexion conexion = new Conexion();
                Generos generos = new Generos();
                generos.setConexion(conexion.getConexion());

                Genero genero = new Genero();
                genero.setCveGenero(campoClave.getText());
                genero.setNombre(campoNombre.getText());
                genero.setTipoMedio(campoTipoMedio.getText());

                generos.agrega(genero);

                conexion.close();

                limpiarCampos();
                mostrarDatos("");
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(null, "EL GENERO YA EXISTE ", "¡ERROR!", 0);
                limpiarCampos();
                mostrarDatos("");
            }
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if (campoClave.getText().trim().length() == 0 || campoNombre.getText().trim().length() == 0
                || campoTipoMedio.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFQUE QUE NO HAYA CAMPOS VACIOS");
        } else {
            try {
                Conexion conexion = new Conexion();
                Generos generos = new Generos();
                generos.setConexion(conexion.getConexion());

                Genero genero = new Genero();
                genero.setCveGenero(campoClave.getText());
                genero.setNombre(campoNombre.getText());
                genero.setTipoMedio(campoTipoMedio.getText());

                generos.actualiza(genero);

                conexion.close();

                limpiarCampos();
                mostrarDatos("");
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(null, "EL GENERO YA EXISTE Y NO PUEDO SER ACTUALIZADO ", "¡ERROR!", 0);
                limpiarCampos();
                mostrarDatos("");
            }
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        int fila = tablaGeneros.getSelectedRow();
        try {
            Conexion conexion = new Conexion();
            Generos generos = new Generos();
            generos.setConexion(conexion.getConexion());

            String cod = tablaGeneros.getValueAt(fila, 0).toString();

            Genero genero = new Genero();
            genero.setCveGenero(cod);

            generos.elimina(genero);

            conexion.close();

            limpiarCampos();
            mostrarDatos("");
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "EL GENERO NO PUDO SER ELIMINADO", "¡Error!", 0);

            limpiarCampos();
            mostrarDatos("");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void campoClave2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoClave2KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            mostrarDatos(campoClave2.getText());
        }
    }//GEN-LAST:event_campoClave2KeyPressed

    private void tablaGenerosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaGenerosFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGenerosFocusGained

    private void tablaGenerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGenerosMouseClicked
        int fila = tablaGeneros.getSelectedRow();
        if (fila >= 0) {
            campoClave.setText(tablaGeneros.getValueAt(fila, 0).toString());
            campoNombre.setText(tablaGeneros.getValueAt(fila, 1).toString());
            campoTipoMedio.setText(tablaGeneros.getValueAt(fila, 2).toString());
            campoClave2.setEnabled(false);
            botonActualizar.setEnabled(true);
            botonEliminar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO NINGUN GENERO");
        }
    }//GEN-LAST:event_tablaGenerosMouseClicked

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if (campoClave2.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFQUE QUE NO HAYA CAMPOS VACIOS");
        } else {
            mostrarDatos(campoClave2.getText());
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarDatosActionPerformed
        mostrarDatos("");
    }//GEN-LAST:event_botonMostrarDatosActionPerformed

    private void campoTipoMedioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTipoMedioKeyTyped
        if (campoTipoMedio.getText().trim().length() >= 1) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITE 1 DIGITO");
        }

    }//GEN-LAST:event_campoTipoMedioKeyTyped

    private void campoTipoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTipoMedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTipoMedioActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonMostrarDatos;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoClave2;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTipoMedio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable tablaGeneros;
    // End of variables declaration//GEN-END:variables
}