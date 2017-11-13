
package net.service.librarijdbcmanageracc.dao;

import net.service.librarijdbcmanageracc.model.Employees;

public interface IEmployeesDao extends IGenericDao<Employees> {
    
    public static final String SQL_FIND_ALL = "select * from " + Employees.TABLE_NAME;
    
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Employees.ID_COLUMN + " = ?";
    
        public static final String SQL_INSERT = "insert into " + Employees.TABLE_NAME + " (" + 
                                                            Employees.LASTNAME_COLUMN + ", " +
                                                            Employees.FIRSTNAME_COLUMN + ", " + 
                                                            Employees.PATRONYMIC_COLUMN + ", " +
                                                            Employees.POSITION_ID_COLUMN + ")" + 
                                            " values (?, ?, ?, ?)";
    
    public static final String SQL_UPDATE = "update " + Employees.TABLE_NAME + 
                                            " set " +   Employees.LASTNAME_COLUMN +   " = ?, " +
                                                        Employees.FIRSTNAME_COLUMN +  " = ?, " +
                                                        Employees.PATRONYMIC_COLUMN + " = ?, " + 
                                                        Employees.POSITION_ID_COLUMN +" = ?" + 
                                            " where " + Employees.ID_COLUMN +         " = ?";
    
    public static final String SQL_DELETE = "delete from " + Employees.TABLE_NAME + 
                                            " where " +      Employees.ID_COLUMN + " = ?";
    
}
