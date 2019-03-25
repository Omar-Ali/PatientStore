package patientstore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Omar
 */
public class Record {
    int patient_id;
    String department;
    String time;
    String count;
    
    public Record(){
        
    }
    
    public Record(int patient_id, String department, int count) throws SQLException, ClassNotFoundException{
        this.patient_id = patient_id;
        this.department = department;
        this.count = count + "";
        save();
    }
    
    public Record(String department, int count, Timestamp time){
        this.department = department;
        this.count = count + "";
        this.time = time.toString();
    }
    
    public void save() throws SQLException, ClassNotFoundException{
        new Database().executeRecordUpdate(patient_id, department, count);
    }
    
    public ObservableList<String> getByPatientId(String id) throws SQLException{
        
        if(id.isEmpty()) return null;
        Vector<String> records = new Vector<String>();

        ResultSet rs = new Database().executeRecordQuery("select * from Record where `patient_id` = '" + id + "';");
        while (rs.next()){
            records.add(new Record(rs.getString("department"), rs.getInt("count"), rs.getTimestamp("inserted_at")).toString());
        }
        ObservableList<String> data = FXCollections.observableArrayList(records);
        return data;
    }
    
    public String toString(){
        return this.department + "      " + this.count + "      " + this.time;
    }
}
