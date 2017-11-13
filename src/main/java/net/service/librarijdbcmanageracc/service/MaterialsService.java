package net.service.librarijdbcmanageracc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.service.librarijdbcmanageracc.connection.Connector;
import net.service.librarijdbcmanageracc.dao.IMaterialsDao;
import net.service.librarijdbcmanageracc.model.Employees;
import net.service.librarijdbcmanageracc.model.Materials;
import net.service.librarijdbcmanageracc.model.Objects;

public class MaterialsService implements IMaterialsDao {

    @Override
    public List<Materials> findAll() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Materials> materialsList = new ArrayList<>();

        try {
            con = Connector.getConnect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {
                Materials materials = new Materials();

                materials.setId(rs.getInt(Materials.ID_COLUMN));
                materials.setMaterial(rs.getString(Materials.MATERIAL_COLUMN));
                materials.setQuantity(rs.getInt(Materials.QUANTITY_COLUMN));
                materials.setEmployee(new Employees());
                materials.getEmployees().setId(rs.getInt(Materials.EMPLOYEES_ID_COLUMN));
                materials.setObjects(new Objects());
                materials.getObjects().setId(rs.getInt(Materials.OBJECT_ID_COLUMN));

                materialsList.add(materials);

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

        return materialsList;
    }

    @Override
    public Materials findById(int id) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Materials materials = new Materials();

        try {
            con = Connector.getConnect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {

                materials.setId(rs.getInt(Materials.ID_COLUMN));
                materials.setMaterial(rs.getString(Materials.MATERIAL_COLUMN));
                materials.setQuantity(rs.getInt(Materials.QUANTITY_COLUMN));
                materials.setEmployee(new Employees());
                materials.getEmployees().setId(rs.getInt(Materials.EMPLOYEES_ID_COLUMN));
                materials.setObjects(new Objects());
                materials.getObjects().setId(rs.getInt(Materials.OBJECT_ID_COLUMN));

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

        return materials;

    }

    @Override
    public void insert(Materials materials) {
        
        Connection con = null;
        PreparedStatement prstmt = null;

        try {

            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_INSERT);
            prstmt.setString(1, materials.getMaterial());
            prstmt.setInt(2, materials.getQuantity());
            prstmt.setInt(3, materials.getEmployees().getId());
            prstmt.setInt(4, materials.getObjects().getId());
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
    public void update(Materials materials) {
        
        Connection con = null;
        PreparedStatement prstmt = null;

        try {

            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_UPDATE);
            prstmt.setString(1, materials.getMaterial());
            prstmt.setInt(2, materials.getQuantity());
            prstmt.setInt(3, materials.getEmployees().getId());
            prstmt.setInt(4, materials.getObjects().getId());
            prstmt.setInt(5, materials.getId());
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
    public void delete(Materials materials) {

        Connection con = null;
        PreparedStatement prstmt = null;

        try {
            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_DELETE);
            prstmt.setInt(1, materials.getId());
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
