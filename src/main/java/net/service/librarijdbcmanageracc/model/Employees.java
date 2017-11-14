
package net.service.librarijdbcmanageracc.model;

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
    private Position position;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }    

    @Override
    public String toString() {
        return "Employees{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", patronymic=" + patronymic + ", position=" + position.getPosition() + '}';
    }
    
}
