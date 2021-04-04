package com.shaman.kursach;

import java.util.ArrayList;
import java.util.List;

public class SQLWrapper {

    public static ArrayList<Employee> GetAll(){
        try {
            ArrayList<Employee> employees =(ArrayList<Employee>) Employee.listAll(Employee.class);
            return employees;
        }catch (Exception e){
            return null;
        }
    }
    public static void Add(Employee employee){
        /*Employee employeeExample=new Employee(employee);
        employeeExample.save();*/
        employee.save();
    }
    public static Employee GetById(long id){
        return Employee.findById(Employee.class,id);
    }
    public static void Modify(Employee oldEmployee,Employee newEmployee)  {
        Employee employee=GetById(oldEmployee.getId());
        employee.SalaryAmount=newEmployee.SalaryAmount;
        employee.PositionCode=newEmployee.PositionCode;
        employee.Surname=newEmployee.Surname;
        employee.EmployeeNumber=newEmployee.EmployeeNumber;
        employee.DepartmentNumber=newEmployee.DepartmentNumber;
        employee.save();
    }
    public static void Delete(Employee employee){
        employee.delete();
    }

    public static List<Employee> MakeAQL(String query){
        return Employee.findWithQuery(Employee.class,query);
    }
    public static String MakeSQL(String query){
        StringBuilder result= new StringBuilder();
        try {
            List<Employee> employees= MakeAQL(query)/*Employee.findWithQuery(Employee.class,query)*/;

            result.append("[");
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                result.append("{");
                result.append("Прізвище та ініціали : ").append(employee.Surname).append(";");
                result.append("Номер відділу : ").append(employee.DepartmentNumber).append(";");
                result.append("Табельний номер працівника : ").append(employee.EmployeeNumber).append(";");
                result.append("Код посади : ").append(employee.PositionCode).append(";");
                result.append("Розмір зарплати : ").append(employee.SalaryAmount).append(";");
                result.append("}");
                if (employees.size()>1&&i<employees.size()-1) result.append(",");
            }
            result.append("]");
        }catch (Exception e){
            result.append(e.getMessage());
        }
        return result.toString();
    }

}
