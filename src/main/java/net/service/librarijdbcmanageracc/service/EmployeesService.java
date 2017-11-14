package net.service.librarijdbcmanageracc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.service.librarijdbcmanageracc.connection.Connector;
import net.service.librarijdbcmanageracc.dao.IEmployeesDao;
import net.service.librarijdbcmanageracc.model.Employees;
import net.service.librarijdbcmanageracc.model.Position;

public class EmployeesService implements IEmployeesDao {

    @Override
    public List<Employees> findAll() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Employees> employeesList = new ArrayList<>();

        try {
            con = Connector.getConnect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {
                Employees employees = new Employees();

                employees.setId(rs.getInt(Employees.ID_COLUMN));
                employees.setFirstname(rs.getString(Employees.FIRSTNAME_COLUMN));
                employees.setLastname(rs.getString(Employees.LASTNAME_COLUMN));
                employees.setPatronymic(rs.getString(Employees.PATRONYMIC_COLUMN));
                employees.setPosition(new Position());
                employees.getPosition().setPosition(rs.getString(Employees.POSITION_ID_COLUMN));

                employeesList.add(employees);

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

        return employeesList;
    }

    @Override
    public Employees findById(int id) {
        
        Connection con = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;
        Employees employees = new Employees();

        try {
            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_FIND_BY_ID);
            prstmt.setInt(1, id);
            rs = prstmt.executeQuery();

            while (rs.next()) {
                
                employees.setId(rs.getInt(Employees.ID_COLUMN));
                employees.setFirstname(rs.getString(Employees.FIRSTNAME_COLUMN));
                employees.setLastname(rs.getString(Employees.LASTNAME_COLUMN));
                employees.setPatronymic(rs.getString(Employees.PATRONYMIC_COLUMN));
                employees.setPosition(new Position());
                employees.getPosition().setId(rs.getInt(Employees.POSITION_ID_COLUMN));

            }

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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
        }

        return employees;

    }

    @Override
    public void insert(Employees employees) {

        Connection con = null;
        PreparedStatement prstmt = null;

        try {

            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_INSERT);
            prstmt.setString(1, employees.getLastname());
            prstmt.setString(2, employees.getFirstname());
            prstmt.setString(3, employees.getPatronymic());
            prstmt.setInt(4, employees.getPosition().getId());
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
    public void update(Employees employees) {
        
        Connection con = null;
        PreparedStatement prstmt = null;

        try {

            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_UPDATE);
            prstmt.setString(1, employees.getLastname());
            prstmt.setString(2, employees.getFirstname());
            prstmt.setString(3, employees.getPatronymic());
            prstmt.setInt(4, employees.getPosition().getId());
            prstmt.setInt(5, employees.getId());
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
    public void delete(Employees employees) {
        
        Connection con = null;
        PreparedStatement prstmt = null;

        try {
            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_DELETE);
            prstmt.setInt(1, employees.getId());
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
