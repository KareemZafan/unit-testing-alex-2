package org.iti.mobile;

public class Employee {
    private long id;
    private double salary;
    private String name;
    private String department;
    private byte age;
    private static int counter = 0;

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
        this.id = ++counter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public double getSalaryForEmployee(long id){
        return this.salary;
    }
}
