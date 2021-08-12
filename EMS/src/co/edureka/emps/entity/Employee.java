package co.edureka.emps.entity;

public class Employee {
    private Integer empno;
    private String ename;
    private Float salary;

    public Employee(){
        super();
    }

    public Employee(Integer empno, String ename, Float salary) {
        super();
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                '}';
    }


}
