package com.shaman.kursach;

import com.orm.SugarRecord;

public class Employee  extends SugarRecord {
    Integer Id;
    Integer DepartmentNumber;
    Integer EmployeeNumber;
    String Surname;
    Integer PositionCode;
    Integer SalaryAmount;

    public Employee(){
    }
    public Employee(Integer id, Integer departmentNumber, Integer employeeNumber, String surname, Integer positionCode, Integer salaryAmount){
        Id=id;
        DepartmentNumber=departmentNumber;
        EmployeeNumber=employeeNumber;
        Surname=surname;
        PositionCode=positionCode;
        SalaryAmount=salaryAmount;
    }
}
