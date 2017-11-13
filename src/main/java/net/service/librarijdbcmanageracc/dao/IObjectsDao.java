
package net.service.librarijdbcmanageracc.dao;

import net.service.librarijdbcmanageracc.model.Objects;

public interface IObjectsDao extends IGenericDao<Objects> {
    
    public static final String SQL_FIND_ALL = "select * from " + Objects.TABLE_NAME;
   
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Objects.ID_COLUMN + " = ?";
    
    public static final String SQL_INSERT = "insert into " + Objects.TABLE_NAME + " ( " + 
                                                             Objects.NAME_COLUMN + ", " + 
                                                             Objects.ADDRESS_COLUMN + 
                                            " ) values (?,?)";
    
    public static final String SQL_UPDATE = "update " + Objects.TABLE_NAME +
                                            " set " +   Objects.NAME_COLUMN + " = ?," + 
                                                        Objects.ADDRESS_COLUMN + " = ?" + 
                                            "  where "+ Objects.ID_COLUMN + " = ?";
    
    public static final String SQL_DELETE = "delete from " + Objects.TABLE_NAME + 
                                            " where " +      Objects.ID_COLUMN + " = ?";
    
}
