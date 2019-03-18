package patientstore;

import java.sql.SQLException;

/**
 *
 * @author Omar
 */
public class Record {
    int patient_id, count;
    String department;
    
    public Record(int patient_id, String department, int count) throws SQLException, ClassNotFoundException{
        this.patient_id = patient_id;
        this.department = department;
        this.count = count;
        save();
    }
    
    public void save() throws SQLException, ClassNotFoundException{
        new Database().executeRecordUpdate(patient_id, department, count);
    }
}
