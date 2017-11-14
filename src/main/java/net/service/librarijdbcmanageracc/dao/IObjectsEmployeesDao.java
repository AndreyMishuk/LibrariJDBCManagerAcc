
package net.service.librarijdbcmanageracc.dao;

import java.util.Map;
import net.service.librarijdbcmanageracc.model.Employees;
import net.service.librarijdbcmanageracc.model.Objects;
import net.service.librarijdbcmanageracc.model.ObjectsEmployees;

public interface IObjectsEmployeesDao {
    
        public static final String SQL_FIND_ALL = "select * from " + ObjectsEmployees.TABLE_NAME;
    
    public static final String SQL_FIND_EMPLOYEES_BY_ID = SQL_FIND_ALL + " where " +
                                    ObjectsEmployees.EMPLOYEES_ID_COLUMN + " = ?";
    
    
    public static final String SQL_FIND_OBJECTS_BY_ID = SQL_FIND_ALL + " where " +
                                    ObjectsEmployees.OBJECTS_ID_COLUMN + " = ?";
    
    public static final String SQL_INSERT = "insert into " + ObjectsEmployees.TABLE_NAME + " (" +
                                                            ObjectsEmployees.EMPLOYEES_ID_COLUMN + ", " +
                                                            ObjectsEmployees.OBJECTS_ID_COLUMN + ") " +
                                            " values (?, ?)";
    
    public static final String SQL_UPDATE = "update " + ObjectsEmployees.TABLE_NAME + 
                                            " set " + ObjectsEmployees.EMPLOYEES_ID_COLUMN + " = ?," +
                                                      ObjectsEmployees.OBJECTS_ID_COLUMN + " = ?" +
                                            " where " + ObjectsEmployees.EMPLOYEES_ID_COLUMN + " = ?" + 
                                            " and " + ObjectsEmployees.OBJECTS_ID_COLUMN + " = ?";
                                            
    
    public static final String SQL_DELETE = "delete from " + ObjectsEmployees.TABLE_NAME + 
                                            " where " + ObjectsEmployees.EMPLOYEES_ID_COLUMN + " = ?" + 
                                            " and " + ObjectsEmployees.OBJECTS_ID_COLUMN + " = ?";
    
    public Map<Objects, Employees> findAll();
    
    public Map<Objects, Employees> findEmployeeAssWithObjects(Employees employees);
    public Map<Objects, Employees> findObjectsWithEmployees(Objects objects);
    
    public void insert(Employees employees, Objects objects);

    public void update(Employees employees, Objects objects, Employees emplEdit, Objects objEdit);
    
    public void delete(Employees employees, Objects objects);
    
}
