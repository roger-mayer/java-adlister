package models;

public class EmployeeBean {
    //attributes
    private long emp_no;
    private String date;
    private String first_name;
    private String last_name;
    private char gender;
    private String hire_Date;

    //zero argument
    public EmployeeBean(){

    }

    public long getEmp_no() {
        return emp_no;
    }

    public String getDate() {
        return date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public char getGender() {
        return gender;
    }

    public String getHire_Date() {
        return hire_Date;
    }

    public void setEmp_no(long emp_no) {
        this.emp_no = emp_no;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setHire_Date(String hire_Date) {
        this.hire_Date = hire_Date;
    }
}
