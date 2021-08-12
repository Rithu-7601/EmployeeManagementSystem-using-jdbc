package co.edureka.emps.config;

import co.edureka.emps.dao.EmployeeDAO;
import co.edureka.emps.dao.EmployeeDAOImpl;


public class EmployeeDAOFactory {
    private static EmployeeDAO dao = null;

    public static EmployeeDAO getEMployeeDAO() throws Exception{
        if(dao == null){
            dao = new EmployeeDAOImpl();

        }
        return dao;
    }
}
