/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAOfactory;

import es.albarregas.DAO.IAlumnosDAO;

/**
 *
 * @author Francisco_Antonio
 */
public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DERBI = 3;

    public abstract IAlumnosDAO getAlumnosDAO();

    public static DAOFactory getDAOFactory(int tipo) {
        DAOFactory daof = null;

        switch (tipo) {
            case MYSQL:
                daof = new MySQLDAOFactory();
                break;
            case ORACLE:
                daof = new OracleDAOFactory();
                break;
            case DERBI:
                daof = new DerbiDAOFactory();
                break;
        }
        return daof;
    }
}
