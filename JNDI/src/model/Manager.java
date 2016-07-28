package model;

import java.util.List;

public class Manager {
    
	private List<Employee> employeeList;
    
    public Manager(){
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }
}
