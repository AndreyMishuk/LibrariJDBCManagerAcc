package net.service.librarijdbcmanageracc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.service.librarijdbcmanageracc.connection.Connector;
import net.service.librarijdbcmanageracc.dao.IObjectsEmployeesDao;
import net.service.librarijdbcmanageracc.model.Employees;
import net.service.librarijdbcmanageracc.model.Objects;
import net.service.librarijdbcmanageracc.model.ObjectsEmployees;

public class ObjectsEmployeesService implements IObjectsEmployeesDao {

    @Override
    public Map<Objects, Employees> findAll() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Map<Objects, Employees> objEmp = new HashMap<>();

        try {

            EmployeesService emplService = new EmployeesService();
            ObjectsService objService = new ObjectsService();

            con = Connector.getConnect();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL);
            Employees employees;
            Objects objects;
            

            while (rs.next()) {

                employees = emplService.findById(rs.getInt(ObjectsEmployees.EMPLOYEES_ID_COLUMN));
                objects = objService.findById(rs.getInt(ObjectsEmployees.OBJECTS_ID_COLUMN));

                objEmp.put(objects, employees);

            }
            
            con.commit();

        } catch (SQLException ex) {
            try {
                ex.printStackTrace();
                con.rollback();
            } catch (SQLException ex1) {
            }
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
        return objEmp;
    }

    @Override
    public Map<Objects, Employees> findEmployeeAssWithObjects(Employees employees) {
        Connection con = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;
        Map<Objects, Employees> objEmp = new HashMap<>();

        try {

            EmployeesService emplService = new EmployeesService();
            ObjectsService objService = new ObjectsService();

            con = Connector.getConnect();
            con.setAutoCommit(false);
            prstmt = con.prepareStatement(SQL_FIND_EMPLOYEES_BY_ID);
            prstmt.setInt(1, employees.getId());
            rs = prstmt.executeQuery();

            Employees empl;
            Objects objects;

            while (rs.next()) {

                empl = emplService.findById(rs.getInt(ObjectsEmployees.EMPLOYEES_ID_COLUMN));
                objects = objService.findById(rs.getInt(ObjectsEmployees.OBJECTS_ID_COLUMN));

                objEmp.put(objects, empl);

            }
            con.commit();

        } catch (SQLException ex) {
            try {
                ex.printStackTrace();
                con.rollback();
            } catch (SQLException ex1) {
            }
        } finally {
            if (prstmt != null) {
                try {
                    prstmt.close();
                } catch (SQLException ex1) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex1) {
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex1) {
                }
            }
        }
        return objEmp;
    }

    @Override
    public Map<Objects, Employees> findObjectsWithEmployees(Objects objects) {

        Connection con = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;
        Map<Objects, Employees> objEmp = new HashMap<>();

        try {

            EmployeesService emplService = new EmployeesService();
            ObjectsService objService = new ObjectsService();

            con = Connector.getConnect();
            con.setAutoCommit(false);
            prstmt = con.prepareStatement(SQL_FIND_EMPLOYEES_BY_ID);
            prstmt.setInt(1, objects.getId());
            rs = prstmt.executeQuery();

            Objects obj;
            Employees employees;

            while (rs.next()) {

                employees = emplService.findById(rs.getInt(ObjectsEmployees.EMPLOYEES_ID_COLUMN));
                obj = objService.findById(rs.getInt(ObjectsEmployees.OBJECTS_ID_COLUMN));

                objEmp.put(obj, employees);

            }
            con.commit();

        } catch (SQLException ex) {
            try {
                con.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
            }
            
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
        return objEmp;

    }

    @Override
    public void insert(Employees employees, Objects objects) {

        Connection con = null;
        PreparedStatement prstmt = null;

        try {

            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_INSERT);
            prstmt.setInt(1, employees.getId());
            prstmt.setInt(2, objects.getId());
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
    public void update(Employees employees, Objects objects, Employees empl, Objects obj) {

        Connection con = null;
        PreparedStatement prstmt = null;

        try {

            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_INSERT);
            prstmt.setInt(1, employees.getId());
            prstmt.setInt(2, objects.getId());
            prstmt.setInt(3, empl.getId());
            prstmt.setInt(4, obj.getId());
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
    public void delete(Employees employees, Objects objects) {
        
         Connection con = null;
        PreparedStatement prstmt = null;

        try {

            con = Connector.getConnect();
            prstmt = con.prepareStatement(SQL_INSERT);
            prstmt.setInt(1, employees.getId());
            prstmt.setInt(2, objects.getId());

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

}
