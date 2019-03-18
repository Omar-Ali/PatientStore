/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;
import java.awt.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
/**
 *
 * @author Omar
 */
public class LabelPrinter  {
    Patient patient;
    public LabelPrinter(Patient patient){
        this.patient = patient;
    }
    
    public void print(int count) {
        for(int i = 0; i < count; i++){
            PrintService pservice = PrintServiceLookup.lookupDefaultPrintService();  // acquire print service of your printer
            DocPrintJob job = pservice.createPrintJob();  
            String relativeSize = "", relativeDis = "";
            if (patient.name.length() <= 23)
                relativeSize = "20";
            else relativeSize = "17";

            if (patient.name.length() <= 23)
                relativeDis = "10";
            else relativeDis = "3";
            String esmString = "الاسم : ";
            String rkmString = "الرقم : ";
            String mostashfaString = "Hospital of Armed Forces in Alexandria";
            ByteBuffer name = Charset.forName("UTF-8").encode(patient.name);
            ByteBuffer rank = Charset.forName("UTF-8").encode(patient.rank);
            ByteBuffer nameBuffer =  Charset.forName("UTF-8").encode(esmString + " " + patient.name);
            ByteBuffer idBuffer =  Charset.forName("UTF-8").encode(rkmString + " " + patient.id);
            ByteBuffer headBuffer =  Charset.forName("UTF-8").encode(mostashfaString);



            String zpl=
                "^XA^LRN^CI0^CWZ,E:TT0003M_.FNT^FS" + "\n" +
                    "^PA1,1,1,1" +
                "^FO050,40^CI28^AZN,35,20^F16^FD" + new String (headBuffer.array()) + "^FS\n" +
                "^PQ1\n" +

                "^FO0" + (new Integer(200 - ((patient.id +"").length() + 8) * 8).toString()) + ",90^CI28^AZN,35,25^F16^FD" + new String (idBuffer.array()) +"^FS\n" +
                "^PQ1\n" +

                "^FO0" + (new Integer(200 - (patient.rank.length() + 8) * 8).toString()) + ",130^CI28^AZN,35,20^F16^FD" + new String (rank.array()) +"^FS\n" +
                "^PQ1\n" +

                "^FO0" + "50" /*(new Integer(300 - (patient.name.length() + Integer.parseInt(relativeDis)) * 8).toString())*/ + ",170^CI28^AZN,35," + relativeSize + "^F16^FD" + new String (nameBuffer.array()) +"^FS\n" +
                "^PQ1\n" +

                "^XZ";
            System.out.println((new Integer(300 - ((patient.id +"").length() + 8)).toString()));
            Locale arabicLocale = new Locale.Builder().setLanguageTag("ar-SA-u-nu-arab").build();
            //Locale.setDefault(new Locale("ar-EG"));
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

            System.out.println("locale: " + Locale.getDefault());
            Doc doc = new SimpleDoc(zpl.getBytes(), flavor , null);
            try {

                System.out.println(doc.getPrintData().toString());
                job.print(doc, null);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
