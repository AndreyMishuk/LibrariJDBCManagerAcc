
package net.service.librarijdbcmanageracc.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ObjectsEmployees {
    
    public static final String TABLE_NAME = "temp";
    public static final String EMPLOYEES_ID_COLUMN = "emp_id";
    public static final String OBJECTS_ID_COLUMN = "obj_id";
    
    
    private Employees employees;
    private Objects objects;
    
    private Map<Objects, Employees> objEpl = new HashMap<>();
    private Set<Employees> empSet = new HashSet<>();
    private Set<Objects> objSet = new HashSet<>();

    public ObjectsEmployees() {
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    public Set<Employees> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Employees> empSet) {
        this.empSet = empSet;
    }

    public Set<Objects> getObjSet() {
        return objSet;
    }

    public void setObjSet(Set<Objects> objSet) {
        this.objSet = objSet;
    }

    public Map<Objects, Employees> getObjEpl() {
        return objEpl;
    }

    public void setObjEpl(Map<Objects, Employees> objEpl) {
        this.objEpl = objEpl;
    }

    @Override
    public String toString() {
        return "ObjectsEmployees{" + "objEpl=" + objEpl + '}';
    }
    
    
    
}
