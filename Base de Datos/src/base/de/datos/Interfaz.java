/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.de.datos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Estudiantes
 */
public class Interfaz extends JFrame implements ActionListener {

    JButton botonConectar, botonDesconectar, botonCrearB, botonBorrarB, botonCrearT, botonBorrarT, botonIngresarD, botonConsultar;
    JTabbedPane pestañas = new JTabbedPane();
    JTable tabla = new JTable();
    JScrollPane sTabla=new JScrollPane(tabla);
    
    
    
    boolean estado = false;
    boolean estadobs = true;
    boolean estadoTb = true;

    BaseDeDatos BDD = new BaseDeDatos();

    JTextField nombrebase;
    JTextField nombretabla;
    JTextField estudiante;
    JTextField codigo;
    JTextField basedatos;
    JTextField not1;
    JTextField not3;
    JTextField not2;
    JTextField nombreBD;
    JTextField nombreTB, nombreTBconsult;
    JTextField datoConsultar;

    public Interfaz() {
        ventana();
        pestanaConectar();
        pestanaBaseDatos();
        pestanaTabla();
        pestanaIngresarDatos();
        pestanaCosultar();
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Nombre", "Nota 1", "Nota 2", "Nota 3", "Promedio"
                }
        ));
        
    }

    private void ventana() {
        //Parametros asociados a la ventana
        setBounds(500, 500, 700, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Base de Datos");
        add(pestañas);
    }

    private void pestanaConectar() {
        JPanel panelconect = new JPanel();
        panelconect.setLayout(null);
        botonConectar = new JButton("Conectar");
        botonConectar.setBounds(30, 380, 100, 25);
        botonConectar.addActionListener(this);
        botonDesconectar = new JButton("Desconectar");
        botonDesconectar.setBounds(145, 380, 110, 25);
        botonDesconectar.addActionListener(this);
        panelconect.add(botonConectar);
        panelconect.add(botonDesconectar);
        pestañas.addTab("CONECTAR", panelconect);
    }

    private void pestanaBaseDatos() {
        JPanel panelBase = new JPanel();
        panelBase.setLayout(null);
        botonCrearB = new JButton("Crear");
        botonCrearB.setBounds(30, 380, 100, 25);
        botonCrearB.addActionListener(this);
        botonBorrarB = new JButton("Borrar");
        botonBorrarB.setBounds(145, 380, 100, 25);
        botonBorrarB.addActionListener(this);
        JLabel mensajeCrearB = new JLabel("Ingrese el nombre de la base de datos.");
        mensajeCrearB.setBounds(30, 30, 250, 50);
        nombrebase = new JTextField();
        nombrebase.setBounds(30, 70, 150, 25);
        panelBase.add(botonCrearB);
        panelBase.add(botonBorrarB);
        panelBase.add(mensajeCrearB);
        panelBase.add(nombrebase);
        pestañas.addTab("BASE DE DATOS", panelBase);
    }

    private void pestanaTabla() {//falta mirar como se pide la cantidad de atributos para la tabla
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(null);
        botonCrearT = new JButton("Crear Tabla");
        botonCrearT.setBounds(30, 380, 100, 25);
        botonCrearT.addActionListener(this);
        botonBorrarT = new JButton("Borrar Tabla");
        botonBorrarT.setBounds(145, 380, 125, 25);
        botonBorrarT.addActionListener(this);
        JLabel mensajeCrearT = new JLabel("Ingrese el nombre de la tabla.");
        mensajeCrearT.setBounds(30, 30, 250, 50);
        nombretabla = new JTextField();
        nombretabla.setBounds(30, 70, 150, 25);
        panelTabla.add(botonCrearT);
        panelTabla.add(botonBorrarT);
        panelTabla.add(mensajeCrearT);
        panelTabla.add(nombretabla);
        pestañas.addTab("TABLA", panelTabla);
    }

    private void pestanaIngresarDatos() {
        JPanel panelIngresar = new JPanel();
        panelIngresar.setLayout(null);
        botonIngresarD = new JButton("Ingresar datos");
        botonIngresarD.setBounds(30, 380, 150, 25);
        botonIngresarD.addActionListener(this);
        
        JLabel mensajeingresoE = new JLabel("Ingrese el nombre del estudiante");
        mensajeingresoE.setBounds(10, 80, 250, 50);
        
        estudiante = new JTextField();
        estudiante.setBounds(10, 135, 190, 25);
        
        JLabel mensajeingresoC = new JLabel("Ingrese el codigo del estudiante");
        mensajeingresoC.setBounds(290, 80, 250, 50);
        
        codigo = new JTextField();
        codigo.setBounds(290, 135, 190, 25);
        
        JLabel nota1 = new JLabel("35%");
        JLabel nota2 = new JLabel("35%");
        JLabel nota3 = new JLabel("30%");
        
        JLabel nombreBs = new JLabel("Ingrese el nombre de la base de datos a usar");
        JLabel nombreTb = new JLabel("Ingrese el nombre de la tabla a usar");
        
        nombreBs.setBounds(10, 5, 270, 50);
        nombreTb.setBounds(290, 5, 250, 50); 
        
        nota1.setBounds(40, 185, 30, 30);
        nota2.setBounds(200, 185, 30, 30);
        nota3.setBounds(360, 185, 30, 30);
        
        not1 = new JTextField();
        not3 = new JTextField();
        not2 = new JTextField();
        nombreBD = new JTextField();
        nombreTB = new JTextField();
        
        not1.setBounds(40, 210, 30, 30);
        not2.setBounds(200, 210, 30, 30);
        not3.setBounds(360, 210, 30, 30);
        nombreBD.setBounds(10, 60, 100, 25);
        nombreTB.setBounds(290, 60, 100, 25);
        
        panelIngresar.add(botonIngresarD);
        panelIngresar.add(mensajeingresoE);
        panelIngresar.add(estudiante);
        panelIngresar.add(mensajeingresoC);
        panelIngresar.add(codigo);
        panelIngresar.add(nota1);
        panelIngresar.add(nota2);
        panelIngresar.add(nota3);
        panelIngresar.add(not1);
        panelIngresar.add(not2);
        panelIngresar.add(not3);
        panelIngresar.add(nombreBs);
        panelIngresar.add(nombreTb);
        panelIngresar.add(nombreBD);
        panelIngresar.add(nombreTB);
        
        
        
        pestañas.add("REGISTRAR", panelIngresar);

    }

    private void pestanaCosultar() {
        JPanel panelConsultar = new JPanel();
        panelConsultar.setLayout(null);
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(450, 195, 100, 25);
        botonConsultar.addActionListener(this);
        JLabel mensajeingresoD = new JLabel("Ingrese la base de datos a consultar");
        mensajeingresoD.setBounds(30, 30, 250, 50);
        basedatos = new JTextField();
        basedatos.setBounds(30, 70, 100, 25);
        JLabel nombreTb = new JLabel("Ingrese el nombre de la tabla a usar");
        nombreTb.setBounds(30, 90, 225, 50);
        nombreTBconsult=new JTextField();
        nombreTBconsult.setBounds(30, 130, 100,25);
        JLabel ingreseDatoMens= new JLabel("Ingrese el dato que desea buscar");
        ingreseDatoMens.setBounds(30, 160, 200, 25);
        datoConsultar = new JTextField();
        datoConsultar.setBounds(30, 195, 100, 25);
        sTabla.setBounds(30, 270, 600, 350);
                tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Nombre", "Nota 1", "Nota 2", "Nota 3", "Promedio"
                }
        ));
        panelConsultar.add(botonConsultar);
        panelConsultar.add(mensajeingresoD);
        panelConsultar.add(basedatos);
        panelConsultar.add(nombreTb);
        panelConsultar.add(nombreTBconsult);
        panelConsultar.add(ingreseDatoMens);
        panelConsultar.add(datoConsultar);
        panelConsultar.add(sTabla);
        pestañas.add("CONSULTAR", panelConsultar);
    }
    
    public void mostrar_tabla(String bas,String tabla1) {

        ArrayList<String[]> lista = new ArrayList();
        BaseDeDatos BDD = new BaseDeDatos();
        lista = BDD.listar(bas,tabla1);

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int rows = model.getDataVector().size();
        for (int i = 0; i < rows; i++) {
            model.removeRow(0);
        }
        String[] filas = new String[6];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i)[0];
            filas[1] = lista.get(i)[1];
            filas[2] = lista.get(i)[2];
            filas[3] = lista.get(i)[3];
            filas[4] = lista.get(i)[4];
            filas[5] = lista.get(i)[5];
            model.addRow(filas);
        }
        tabla.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Base = nombrebase.getText();
        
        // acciones para conectar o desconectar el servidor
        if (e.getSource().equals(botonConectar)) {
            BDD.conectar();
            estado = true;
        }
        if (e.getSource().equals(botonDesconectar)) {
            BDD.desconectar();
            estado = false;
        }
        
        //acciones para los botenes de crear o borrar base de datos
        if (e.getSource().equals(botonCrearB)) {
            if (estado) {
                Base = nombrebase.getText();
                BDD.crea_bd(Base);
                estadobs = true;
            } else {

                JOptionPane.showMessageDialog(null, "No esta conectado a una base de datos");

            }
        }
        if (e.getSource().equals(botonBorrarB)) {
            if (estado) {
                Base = nombrebase.getText();
                BDD.borra_bd(Base);
                estadobs = true;
                
            } else {

                JOptionPane.showMessageDialog(null, "No esta conectado a una base de datos");

            }
        }
        
        //acciones para los botones de crear o borrar tabla
        if (e.getSource().equals(botonCrearT)) {
            if (estado && estadobs) {
                BDD.crea_tabla(Base, nombretabla.getText());
                estadoTb = true;
                
            } 
            else {
                JOptionPane.showMessageDialog(null, "No esta conectado a un servidor");
            }
        }
        if (e.getSource().equals(botonBorrarT)) {
            if (estado && estadobs) {
                BDD.borra_tabla(Base, nombretabla.getText());
                estadoTb = true;
            } 
            else {
                JOptionPane.showMessageDialog(null, "No existe base para borrar");
            }
        }
        
        //acciones para los botones de ingresar datos
        if (e.getSource().equals(botonIngresarD)) {
            if (estadoTb){
                
                BDD.insertar(nombreBD.getText(), nombreTB.getText(),  codigo.getText() , estudiante.getText(), Float.parseFloat(not1.getText()),  Float.parseFloat(not2.getText()),  Float.parseFloat(not3.getText()));
                
            } else {
                JOptionPane.showMessageDialog(null, "No esta conectado a un servidor");
            }
        }
        //acciones para el boton consultar
        if(e.getSource().equals(botonConsultar)){
            if(estado){
                mostrar_tabla(basedatos.getText(), nombreTBconsult.getText());
            }
            else{
                JOptionPane.showMessageDialog(null, "No esta conectado a un servidor");
            }
        }
        }
    }
