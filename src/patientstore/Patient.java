package patientstore;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Omar
 */
public class Patient {
    public int id = -1;
    public String name, type, rank;
    public Patient(int id, String name, String type, String rank){
        this.id = id;
        this.name = name;
        this.type = type;
        this.rank = rank;
    }
    public Patient(){}
    
    public Patient getById(String id) throws SQLException{
        if(id.isEmpty()) return this;
        ResultSet rs = new Database().executeQuery("select * from Patient where `id` = '" + id + "' limit 1;");
        if (rs.next()){
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.type = rs.getString("type");
            this.rank = rs.getString("rank");
        }
        return this;
    }
    
    public boolean found(){
        return this.id != -1;
    }
}
