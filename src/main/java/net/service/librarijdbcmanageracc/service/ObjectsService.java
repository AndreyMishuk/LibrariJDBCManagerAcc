package net.service.librarijdbcmanageracc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.service.librarijdbcmanageracc.connection.Connector;
import net.service.librarijdbcmanageracc.dao.IObjectsDao;
import net.service.librarijdbcmanageracc.model.Objects;

public class ObjectsService implements IObjectsDao {

    @Override
    public List<Objects> findAll() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Objects> objectsList = new ArrayList<>();

        try {
            con = Connector.getConnect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {
                Objects objects = new Objects();

                objects.setId(rs.getInt(Objects.ID_COLUMN));
                objects.setName(rs.getString(Objects.NAME_COLUMN));
                objects.setAddress(rs.getString(Objects.ADDRESS_COLUMN));

                objectsList.add(objects);

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

        return objectsList;
    }

    @Override
    public Objects findById(int id) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Objects objects = new Objects();

        try {
            con = Connector.getConnect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {

                objects.setId(rs.getInt(Objects.ID_COLUMN));
                objects.setName(rs.getString(Objects.NAME_COLUMN));
                objects.setAddress(rs.getString(Objects.ADDRESS_COLUMN));

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

        return objects;

    }

    @Override
    public void insert(Objects objects) {
        Connection con = null;
        PreparedStatement prstmt = null;

        try {

            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_INSERT);
            prstmt.setString(1, objects.getName());
            prstmt.setString(2, objects.getAddress());
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
    public void update(Objects objects) {
        Connection con = null;
        PreparedStatement prstmt = null;

        try {

            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_UPDATE);
            prstmt.setString(1, objects.getName());
            prstmt.setString(2, objects.getAddress());
            prstmt.setInt(3, objects.getId());
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
    public void delete(Objects objects) {

        Connection con = null;
        PreparedStatement prstmt = null;

        try {
            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_DELETE);
            prstmt.setInt(1, objects.getId());
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
