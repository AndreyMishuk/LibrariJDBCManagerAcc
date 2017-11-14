
package net.service.librarijdbcmanageracc.model;

public class Materials {
    
    public static final String TABLE_NAME = "materials";
    public static final String ID_COLUMN = "id";
    public static final String MATERIAL_COLUMN = "material";
    public static final String QUANTITY_COLUMN = "quantity";
    public static final String EMPLOYEES_ID_COLUMN = "employees_id";
    public static final String OBJECT_ID_COLUMN = "object_id";
    
    private int id;
    private String material;
    private int quantity;
    private Employees employees = new Employees();
    private Objects objects = new Objects();

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployee(Employees employees) {
        this.employees = employees;
    }

    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "Materials{" + "id=" + id + ", material=" + material + ", quantity=" + quantity + ", employees=" + employees.getId()+ ", objects=" + objects.getId()+ '}';
    }
    
    
    
}
