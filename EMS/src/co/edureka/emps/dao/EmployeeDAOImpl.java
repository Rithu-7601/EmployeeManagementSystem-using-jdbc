package co.edureka.emps.dao;

import co.edureka.emps.config.ConnectionFactory;
import co.edureka.emps.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static Statement st = null;

    public EmployeeDAOImpl() throws Exception {
        Connection con = ConnectionFactory.getDbConnection();
        st = con.createStatement();
    }

    @Override
    public void saveEmp(Employee emp) throws Exception {
        String sql = "insert into emp values("+emp.getEmpno()+",'"+emp.getEname()+"',"+emp.getSalary()+")";
        int n = st.executeUpdate(sql);
        System.out.println("Employee saved");

    }

    @Override
    public void updateEmp(Employee emp) throws Exception {
        String sql = "update emp set ename='"+emp.getEname()+"',salary="+emp.getSalary()+" where empno="+emp.getEmpno();
        int n = st.executeUpdate(sql);
        if(n>0) {
            System.out.println("Employee updated");
        }
    }

    @Override
    public Employee searchEmp(int eno) throws Exception {
        Employee emp = null;
        String sql = "select ename,salary from emp where empno="+eno;
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            String name = rs.getString(1);
            float salary = rs.getFloat(2);
            emp = new Employee(eno,name,salary);

        }
        return emp;

    }

    @Override
    public void deleteEmp(int eno) throws Exception {
        String sql = "delete from emp where empno="+eno;
        int n = st.executeUpdate(sql);
        if(n>0) {
            System.out.println("Employee deleted");
        }
        else{
            System.out.println("No matching employee to delete");
        }

    }

    @Override
    public List<Employee> getEmployees() throws Exception {
        List<Employee> emps = new ArrayList<>();
        String sql ="select * from emp";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            int eno = rs.getInt(1);
            String ename = rs.getString(2);
            float salary = rs.getFloat(3);
           Employee emp = new Employee(eno,ename,salary);
           emps.add(emp);
        }
        return emps;
    }
}
