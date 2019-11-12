/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author franciscoantonio
 */
public class AlumnosDAO implements IAlumnosDAO{

    public ArrayList<Alumno> getAlumnos(String limit) {
        ArrayList<Alumno> lista = new ArrayList();
        String consulta = "select nombre,grupo from alumnos " + limit;

        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                lista.add(alumno);
            }

            resultado.close();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentenia.");
            ex.printStackTrace();
        }finally{//cierra el hilo del datasource.
            this.closeConnection();
        }

        return lista;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }

    @Override
    public ArrayList<Alumno> getAlumnosEquipo() {
        ArrayList<Alumno> lista = new ArrayList();
        String consulta = "Select a.nombre,a.grupo,e.marca,e.numSerie from alumnos as a inner join equipos as e using(idEquipo)";
        //todos los alumnos que tienen un equipo asignado.
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setNombre(resultado.getString("grupo"));
                Equipo equipo = new Equipo();
                equipo.setMarca(resultado.getString("marca"));
                equipo.setNumSerie(resultado.getString("numSerie"));
                alumno.setEquipo(equipo);
                lista.add(alumno);
            }

            resultado.close();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecnia");
            ex.printStackTrace();
        }

        return lista;
    }
}
