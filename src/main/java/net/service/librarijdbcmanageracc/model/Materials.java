
package net.service.librarijdbcmanageracc.model;

import java.util.HashSet;
import java.util.Set;

public class Materials {
    
    public static final String TABLE_NAME = "materials";
    public static final String ID_COLUMN = "id";
    public static final String MATERIAL_COLUMN = "material";
    public static final String QUANTITY_COLUMN = "quantity";
    public static final String EMPLOYEES_ID_COLUMN = "employees_id";
    public static final String OBJECT_ID_COLUMN = "object_id";
    
    private int id;
    private String material;
    private String quantity;
    private Set<Employees> employeesSet = new HashSet<>();
    private Set<Objects> objectsSet = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Set<Employees> getEmployeesSet() {
        return employeesSet;
    }

    public void setEmployeesSet(Set<Employees> employeesSet) {
        this.employeesSet = employeesSet;
    }

    public Set<Objects> getObjectsSet() {
        return objectsSet;
    }

    public void setObjectsSet(Set<Objects> objectsSet) {
        this.objectsSet = objectsSet;
    }
    
    
    
}
