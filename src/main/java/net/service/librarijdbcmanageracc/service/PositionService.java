package net.service.librarijdbcmanageracc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.service.librarijdbcmanageracc.connection.Connector;
import net.service.librarijdbcmanageracc.dao.IPositionDao;
import net.service.librarijdbcmanageracc.model.Position;

public class PositionService implements IPositionDao {

    @Override
    public List<Position> findAll() {
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Position> positionList = new ArrayList<>();
        
        
        try {
            con = Connector.getConnect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {
                Position position = new Position();
                position.setId(rs.getInt(Position.ID_COLUMN));
                position.setPosition(rs.getString(Position.POSITION_COLUMN));
                
                positionList.add(position);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        return positionList;
    }

    @Override
    public Position findById(int id) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Position position = new Position();
        
        
        try {
            con = Connector.getConnect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {
                
                position.setId(rs.getInt(Position.ID_COLUMN));
                position.setPosition(rs.getString(Position.POSITION_COLUMN));
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        return position;
    }

    @Override
    public void insert(Position position) {
        
        Connection con = null;
        PreparedStatement prstmt = null;
        
        try {
            
            String namePosition = position.getPosition();
            
            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_INSERT);
            prstmt.setString(1, namePosition);
            prstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (prstmt != null) {
                try {
                    prstmt.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }

    }

    @Override
    public void update(Position position) {
        
        Connection con = null;
        PreparedStatement prstmt = null;
        String namePosition = position.getPosition();
        int id = position.getId();
        
        try {
            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_UPDATE);
            prstmt.setString(1, namePosition);
            prstmt.setInt(2, id);
            prstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (prstmt != null) {
                try {
                    prstmt.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        
    }

    @Override
    public void delete(Position position) {
        
        Connection con = null;
        PreparedStatement prstmt = null;
        
        try {
            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_DELETE);
            prstmt.setInt(1, position.getId());
            prstmt.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (prstmt != null) {
                try {
                    prstmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
