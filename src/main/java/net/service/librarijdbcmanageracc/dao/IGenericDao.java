
package net.service.librarijdbcmanageracc.dao;

import java.util.List;
import net.service.librarijdbcmanageracc.model.Position;

public interface PositionDao {
    
    public static final String SQL_FIND_ALL = "select * from " + Position.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + "where" + Position.ID_COLUMN + " = ?";
    public static final String SQL_INSERT = "insert into " + Position.TABLE_NAME + " (" + 
            Position.POSITION_COLUMN + " ) values (?,?)" ;
    public static final String SQL_UPDATE = "update " + Position.TABLE_NAME + " set " + 
            Position.POSITION_COLUMN + " where " + Position.ID_COLUMN + " = ?" ;
    public static final String SQL_DELETE = "delete from " + Position.TABLE_NAME + " where " + 
            Position.ID_COLUMN + " = ?";
    
    public List<Position> findAll();
    public Position findById(int id);
    public void insertPosition(Position position);
    public void updatePosition(Position position);
    public void deletePosition(Position position);
    
}
