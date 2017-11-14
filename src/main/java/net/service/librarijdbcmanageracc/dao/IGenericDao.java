package net.service.librarijdbcmanageracc.dao;

import java.sql.SQLException;
import java.util.List;

interface IGenericDao<T> {

    public List<T> findAll() throws SQLException;

    public T findById(int id) throws SQLException;

    public void insert(T values) throws SQLException;

    public void update(T values) throws SQLException;

    public void delete(T values) throws SQLException;

}
