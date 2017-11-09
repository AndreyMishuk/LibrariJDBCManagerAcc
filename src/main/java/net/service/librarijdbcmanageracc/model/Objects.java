
package net.service.librarijdbcmanageracc.model;

import java.util.HashSet;
import java.util.Set;

public class Objects {
    
    public static final String TABLE_NAME = "objects";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String ADDRESS_COLUMN = "name";
    
    private int id;
    private String name;
    private String address;
    private Set<Employees> employeesSet = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Employees> getEmployeesSet() {
        return employeesSet;
    }

    public void setEmployeesSet(Set<Employees> employeesSet) {
        this.employeesSet = employeesSet;
    }
    
    
    
}
