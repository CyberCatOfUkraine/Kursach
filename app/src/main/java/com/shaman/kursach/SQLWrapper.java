package com.shaman.kursach;

import android.widget.Toast;

import java.util.ArrayList;

public class SQLWrapper {

    private static final ArrayList<Employee> _employees=new ArrayList<>();
    public static ArrayList<Employee> GetAll(){
        return _employees;
    }
    public static void Add(Employee employee){
        _employees.add(employee);
    }
    public static Employee GetById(int id){
        Employee employee=null;
        for (Employee employeeValue:_employees) {
            if (employeeValue.Id==id)
                employee=employeeValue;
        }

        return employee;
    }
    public static void Modify(int id,Employee newEmployee)  {
        _employees.remove(GetById(id));
        _employees.add(newEmployee);
    }
    public static void Delete(int id){
        _employees.remove(GetById(id));
    }
    public static String MakeSQL(String query){
        return null;
    }
    public static int GetSize(){
        return  _employees.size();
    }

}
