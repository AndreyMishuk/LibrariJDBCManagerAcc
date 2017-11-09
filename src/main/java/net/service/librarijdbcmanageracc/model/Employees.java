
package net.service.librarijdbcmanageracc.model;

import java.util.HashSet;
import java.util.Set;

public class Employees {
    
    public static final String TABLE_NAME = "employees";
    public static final String ID_COLUMN = "id";
    public static final String FIRSTNAME_COLUMN = "firstname";
    public static final String LASTNAME_COLUMN = "lastname";
    public static final String PATRONYMIC_COLUMN = "patronymic";
    public static final String POSITION_ID_COLUMN = "position_id";
    
    private int id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private Set<Position> positionSet = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }
    
}
