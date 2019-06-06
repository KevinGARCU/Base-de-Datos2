package base.de.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BaseDeDatos {

    Connection conex;

    public static void main(String[] args) {
        Interfaz ventana = new Interfaz();
    }

    //Conexion a MySQL de manera local
    void conectar() {
        //usamos una excepcion try-catch en caso de presetnar inconvenientes al conectar
        try {
            //objeto conex creado
            conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "?useTimezone=true&serverTimezone=UTC", "root", "mysql2019");
            JOptionPane.showMessageDialog(null, "Se ha conectado con exito!", "Conectado", 2);
        } catch (SQLException e) {
            System.out.println("error1 =" + e.toString()); //porque se pasa a string?
        }
    }

    //cse cierra la base de datos para finalizar la modificacion en la misma
    void desconectar() {
        try {
            conex.close();
            JOptionPane.showMessageDialog(null, "Se ha desconectado con exito!", "Desconectado", 2);
        } catch (SQLException e) {
            System.out.println("error2 =" + e.toString());
        }
    }

    //se crea base de datos
    void crea_bd(String nombre) {
        //argumento para crear
        String s = "create database " + nombre;

        //objeto para?
        java.sql.Statement st;

        try {
            st = conex.createStatement();
            st.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + nombre + " con exito!", "Base", 2);
        } catch (SQLException e) {
            System.out.println("error3 =" + e.toString());
        }
    }

    void borra_bd(String nombre) {
        String s1 = "use " + nombre;
        String s = "drop database " + nombre;
        java.sql.Statement st;
        try {
            st = conex.createStatement();
            st.executeUpdate(s1);
            st.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Se ha borrado la base de de datos " + nombre + " con exito!", "Base", 2);
        } catch (SQLException e) {
            System.out.println("error3 =" + e.toString());
        }
    }

    //Con la base de datos lista, se crea una tabla para la base de datos
    void crea_tabla(String nombrebs, String nombretb) {
        String s1 = "use " + nombrebs;
        String s = "create table " + nombretb + "(cod varchar(11), nombre varchar(25), nota1 decimal(10,3), nota2 decimal(10,3), nota3 dec(10,3), promedio decimal(10,3))";
        java.sql.Statement st;

        try {
            st = conex.createStatement();
            st.executeUpdate(s1);
            st.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla de datos " + nombretb + " con exito!", "Base", 2);
        } catch (SQLException e) {
            System.out.println("error4 =" + e.toString());
        }
    }

    void borra_tabla(String nombrebs, String nombretb) {
        String s1 = "use " + nombrebs;
        String s = "drop table " + nombretb;
        java.sql.Statement st;
        try {
            st = conex.createStatement();
            st.executeUpdate(s1);
            st.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Se ha borrado la tabla de datos " + nombretb + " con exito!", "Base", 2);
        } catch (SQLException e) {
            System.out.println("error4 =" + e.toString());
        }
    }

    // metodo para insertar datos dentro de la tabla en la base de datos
    void insertar(String nombreBs, String nombreTb, String cod, String nombre, float nota1, float nota2, float nota3) {
        String s1 = "use " + nombreBs;

        float aux = calcularPromedio(nota1, nota2, nota3);

        //los valores se reciben con parametros diferentes en java y en la base de datos, OJO nomenclaturqa ahi, comillas simples luego doble comilla
        String sql = "insert into " + nombreTb + "(cod,nombre,nota1,nota2,nota3,promedio)" + "values(' " + cod + " ',' " + nombre + " ',' " + nota1 + " ',' " + nota2 + " ',' " + nota3 + " ', ' " + aux + " ')";
        java.sql.Statement st;

        try {
            st = conex.createStatement();
            st.executeUpdate(s1);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Datos ingresados exitosamente");
        } catch (SQLException e) {
            System.out.println("error5 =" + e.toString());
        }
    }

    //Listar, es generar la listas de lo que se encuentra en la base de datos--guarda la informacion de la tabla
    public ArrayList<String[]> listar(String base, String tabla) {
        ArrayList<String[]> lista = new ArrayList();
        String s1 = "use " + base;
        //argumento base de datos para ver la tabla
        String sql = "select * from " + tabla;
        java.sql.Statement st;
        try {
            Connection jj;
            jj = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "?useTimezone=true&serverTimezone=UTC", "root", "mysql2019");
            st = jj.createStatement();
            st.executeUpdate(s1);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] datos = new String[6];
                datos[0] = (rs.getString("cod"));
                datos[1] = (rs.getString("nombre"));
                datos[2] = (rs.getString("nota1"));
                datos[3] = (rs.getString("nota2"));
                datos[4] = (rs.getString("nota3"));
                datos[5] = (rs.getString("promedio"));
                lista.add(datos);
            }

        } catch (SQLException d) {
            System.out.println("error al obtener los datos =" + d.toString());
        }
        return lista;
    }

    public ArrayList<String[]> solouno(String base, String tabla, String codigo) {
        ArrayList<String[]> lista = new ArrayList();
        String s1 = "use " + base;
        //argumento base de datos para ver la tabla
        String sql = "select * from " + tabla + " where cod = " + codigo;
        java.sql.Statement st;
        try {
            Connection jj;
            jj = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "?useTimezone=true&serverTimezone=UTC", "root", "mysql2019");
            st = jj.createStatement();
            st.executeUpdate(s1);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] datos = new String[6];
                datos[0] = (rs.getString("cod"));
                datos[1] = (rs.getString("nombre"));
                datos[2] = (rs.getString("nota1"));
                datos[3] = (rs.getString("nota2"));
                datos[4] = (rs.getString("nota3"));
                datos[5] = (rs.getString("promedio"));
                lista.add(datos);
            }

        } catch (SQLException d) {
            System.out.println("error al obtener los datos =" + d.toString());
        }
        return lista;
    }

    public void BorrarDatos(String base, String table, String codigo) {
        String s1 = "use " + base;
        
        String sql = " SET SQL_SAFE_UPDATES = 0";
        String sq2 = "delete from " + table + " where cod = " + codigo;
        
        java.sql.Statement st;
        try {
            Connection jj;
            jj = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "?useTimezone=true&serverTimezone=UTC", "root", "mysql2019");
            st = jj.createStatement();
            st.executeUpdate(s1);
            st.executeUpdate(sql);
            st.executeUpdate(sq2);
        }catch (SQLException d) {
            System.out.println("error al obtener los datos =" + d.toString());
        }
        
        JOptionPane.showMessageDialog(null, "El estudiante con el codigo "+ codigo);
    }

    //funcion calcular promedio notas
    public float calcularPromedio(float nota1, float nota2, float nota3) {
        return (nota1 + nota2 + nota3) / 3;
    }
}
