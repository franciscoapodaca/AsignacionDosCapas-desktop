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
import objetoNegocio.Pelicula;
import objetosServicio.Fecha;
import persistencia.Conexion;
import persistencia.Peliculas;

/**
 *
 * @author Francisco
 */
public class VentanaPeliculas extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPeliculas
     */
    public VentanaPeliculas() {
        initComponents();
        this.setLocationRelativeTo(null);
        botonActualizar.setEnabled(false);
        botonEliminar.setEnabled(false);
        campoFecha.setText(new Fecha().toString());
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }

    public void limpiarCampos() {
        campoClave2.setText("");
        campoTitulo.setText("");
        campoActor1.setText("");
        campoActor2.setText("");
        campoDirector.setText("");
        campoDuracion.setText("");
        campoFecha.setText("");
        campoClave2.setEnabled(true);
    }

    public void mostrarDatos(String valor) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Clave");
            modelo.addColumn("Titulo");
            modelo.addColumn("Actor 1");
            modelo.addColumn("Actor 2");
            modelo.addColumn("Director");
            modelo.addColumn("Duración");
            modelo.addColumn("Fecha");
            tablaPeliculas.setModel(modelo);
            String sql = "";
            if (valor.equals("")) {
                sql = "SELECT * FROM peliculas";
            } else {
                sql = "SELECT * FROM peliculas WHERE clave='" + valor + "'";
            }
            String[] datos = new String[7];
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConexion();
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    datos[5] = rs.getString(6);
                    datos[6] = rs.getString(7);
                    modelo.addRow(datos);
                }
                tablaPeliculas.setModel(modelo);
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
        campoTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoActor1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoActor2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoDirector = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoDuracion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoFecha = new javax.swing.JTextField();
        tablaPeliculas = new javax.swing.JTable();
        botonBuscarPorClave = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        botonMostrarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PELICULAS");
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
        jLabel2.setText("TITULO:");

        campoTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ACTOR 1:");

        campoActor1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("ACTOR 2:");

        campoActor2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("DIRECTOR:");

        campoDirector.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("DURACIÓN:");

        campoDuracion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDuracionKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("FECHA:");

        campoFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        tablaPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
            }
        ));
        tablaPeliculas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaPeliculasFocusGained(evt);
            }
        });
        tablaPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPeliculasMouseClicked(evt);
            }
        });

        botonBuscarPorClave.setText("Buscar Por Clave");
        botonBuscarPorClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarPorClaveActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("hrs.");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoDirector, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(campoActor2)
                            .addComponent(campoActor1)
                            .addComponent(campoTitulo)
                            .addComponent(campoClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(97, 97, 97))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonBuscarPorClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonMostrarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tablaPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoActor1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoClave2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoActor2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarPorClave, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(campoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(botonMostrarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addComponent(tablaPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPeliculasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaPeliculasFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaPeliculasFocusGained

    private void tablaPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPeliculasMouseClicked
        int fila = tablaPeliculas.getSelectedRow();
        if (fila >= 0) {
            campoClave.setText(tablaPeliculas.getValueAt(fila, 0).toString());
            campoTitulo.setText(tablaPeliculas.getValueAt(fila, 1).toString());
            campoActor1.setText(tablaPeliculas.getValueAt(fila, 2).toString());
            campoActor2.setText(tablaPeliculas.getValueAt(fila, 3).toString());
            campoDirector.setText(tablaPeliculas.getValueAt(fila, 4).toString());
            campoDuracion.setText(tablaPeliculas.getValueAt(fila, 5).toString());
            campoFecha.setText(tablaPeliculas.getValueAt(fila, 6).toString());
            campoClave2.setEnabled(false);
            botonActualizar.setEnabled(true);
            botonEliminar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO NINGUNA PELICULA");
        }
    }//GEN-LAST:event_tablaPeliculasMouseClicked

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed

        if (campoClave2.getText().trim().length() == 0 || campoTitulo.getText().trim().length() == 0
                || campoActor1.getText().trim().length() == 0 || campoDirector.getText().trim().length() == 0
                || campoActor2.getText().trim().length() == 0 || campoDuracion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFIQUE QUE NO HAYA CAMPOS VACIOS");
        } else {
            try {

                Conexion conexion = new Conexion();
                Peliculas peliculas = new Peliculas();
                peliculas.setConexion(conexion.getConexion());

                Pelicula pelicula = new Pelicula();
                pelicula.setClave(campoClave2.getText());
                pelicula.setTitulo(campoTitulo.getText());
                pelicula.setActor1(campoActor1.getText());
                pelicula.setActor2(campoActor2.getText());
                pelicula.setDirector(campoDirector.getText());
                pelicula.setDuracion(Integer.parseInt(campoDuracion.getText()));
                pelicula.setFecha(new Fecha(campoFecha.getText()));

                peliculas.agrega(pelicula);

                conexion.close();

                limpiarCampos();
                mostrarDatos("");
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(null, "LA PELICULA YA EXISTE ", "¡ERROR!", 0);
                limpiarCampos();
                mostrarDatos("");

            }
        }


    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if (campoClave2.getText().trim().length() == 0 || campoTitulo.getText().trim().length() == 0
                || campoActor1.getText().trim().length() == 0 || campoDirector.getText().trim().length() == 0
                || campoActor2.getText().trim().length() == 0 || campoDuracion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFQUE QUE NO HAYA CAMPOS VACIOS");
        } else {
            try {
                Conexion conexion = new Conexion();
                Peliculas peliculas = new Peliculas();
                peliculas.setConexion(conexion.getConexion());

                Pelicula pelicula = new Pelicula();
                pelicula.setClave(campoClave.getText());
                pelicula.setTitulo(campoTitulo.getText());
                pelicula.setActor1(campoActor1.getText());
                pelicula.setActor2(campoActor2.getText());
                pelicula.setDirector(campoDirector.getText());
                pelicula.setDuracion(Integer.parseInt(campoDuracion.getText()));
                pelicula.setFecha(new Fecha(campoFecha.getText()));

                peliculas.actualiza(pelicula);

                conexion.close();

                limpiarCampos();
                mostrarDatos("");
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(null, "LA CANCIÓN YA EXISTE Y NO PUEDO SER ACTUALIZADA ", "¡ERROR!", 0);
                limpiarCampos();
                mostrarDatos("");
            }
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        int fila = tablaPeliculas.getSelectedRow();
        try {
            Conexion conexion = new Conexion();
            Peliculas peliculas = new Peliculas();
            peliculas.setConexion(conexion.getConexion());

            String cod = tablaPeliculas.getValueAt(fila, 0).toString();

            Pelicula pelicula = new Pelicula();
            pelicula.setClave(cod);

            peliculas.elimina(pelicula);

            conexion.close();

            limpiarCampos();
            mostrarDatos("");
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "LA CANCIÓN NO PUEDE SER ELIMINADA", "¡Error!", 0);

            limpiarCampos();
            mostrarDatos("");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonBuscarPorClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarPorClaveActionPerformed
        if (campoClave2.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "VERIFIQUE QUE EL CAMPO CLAVE DE BUSQUEDA NO ESTA VACIO");
        } else {
            mostrarDatos(campoClave2.getText());
        }
    }//GEN-LAST:event_botonBuscarPorClaveActionPerformed

    private void botonMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarDatosActionPerformed
        mostrarDatos("");
    }//GEN-LAST:event_botonMostrarDatosActionPerformed

    private void campoClave2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoClave2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            mostrarDatos(campoClave2.getText());

        }
    }//GEN-LAST:event_campoClave2KeyPressed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void campoDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDuracionKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "SOLO SE PERMITEN NÚMEROS", "¡Error Validación!", 0);
        }
    }//GEN-LAST:event_campoDuracionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscarPorClave;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonMostrarDatos;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campoActor1;
    private javax.swing.JTextField campoActor2;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoClave2;
    private javax.swing.JTextField campoDirector;
    private javax.swing.JTextField campoDuracion;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable tablaPeliculas;
    // End of variables declaration//GEN-END:variables
}