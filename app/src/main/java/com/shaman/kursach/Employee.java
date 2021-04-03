package com.shaman.kursach;

import com.orm.SugarRecord;

public class Employee  extends SugarRecord {
    Integer DepartmentNumber;
    Integer EmployeeNumber;
    String Surname;
    Integer PositionCode;
    Integer SalaryAmount;

    public Employee(){
    }
    public Employee( Integer departmentNumber, Integer employeeNumber, String surname, Integer positionCode, Integer salaryAmount){
        DepartmentNumber=departmentNumber;
        EmployeeNumber=employeeNumber;
        Surname=surname;
        PositionCode=positionCode;
        SalaryAmount=salaryAmount;
    }

}
