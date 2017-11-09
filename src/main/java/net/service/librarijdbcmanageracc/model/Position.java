
package net.service.librarijdbcmanageracc.model;

public class Position {
    
    public static final String TABLE_NAME = "position";
    public static final String ID_COLUMN = "id";
    public static final String POSITION_COLUMN = "position";
        
    private int id;
    private String Position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }
    
    
}
