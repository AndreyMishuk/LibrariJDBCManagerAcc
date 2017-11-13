
package net.service.librarijdbcmanageracc.dao;

import net.service.librarijdbcmanageracc.model.Materials;

public interface IMaterialsDao extends IGenericDao<Materials> {
    
    public static final String SQL_FIND_ALL = "select * from " + Materials.TABLE_NAME;
    
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Materials.ID_COLUMN + " = ?";
    
    public static final String SQL_INSERT = "insert into " + Materials.TABLE_NAME + " (" +
                                                            Materials.MATERIAL_COLUMN + ", " + 
                                                            Materials.QUANTITY_COLUMN + ", " +
                                                            Materials.EMPLOYEES_ID_COLUMN + ", " + 
                                                            Materials.OBJECT_ID_COLUMN + ") " +
                                            "values (?, ?, ?, ?)";
    
    public static final String SQL_UPDATE = "update " + Materials.TABLE_NAME + 
                                            " set "   + Materials.MATERIAL_COLUMN +     " = ?, " +
                                                        Materials.QUANTITY_COLUMN +     " = ?, " +
                                                        Materials.EMPLOYEES_ID_COLUMN + " = ?, " + 
                                                        Materials.OBJECT_ID_COLUMN +    " = ? "  +
                                            "where "  + Materials.ID_COLUMN +           " = ?" ;
    
    public static final String SQL_DELETE = "delete from " + Materials.TABLE_NAME + 
                                            " where " +      Materials.ID_COLUMN + " = ?";
}
