package a15009851.dylanmatthews.lockstockbarrel;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class completedRepairs extends AppCompatActivity {


    DbAdapter dbAdapter;
    EditText etTicket;
    private long ticketNum;
    private String name;
    private String repair;
    private String items;
    private  String number;
    private  String repairOther;
    private  String Cost;
    private String DateIn;
    private  String Dateout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_repairs);
        dbAdapter = new DbAdapter(this);
        etTicket = (EditText) findViewById(R.id.etSearchTicketNum);
    }


    public void onCollected(View view)
    {
        try
        {
            dbAdapter.open();
            Cursor dbCursor = dbAdapter.getRepairTicket(Integer.parseInt(etTicket.getText().toString()));
            ticketNum =  dbCursor.getInt(0);
            name = dbCursor.getString(1);
            repair = dbCursor.getString(2);
            repairOther = dbCursor.getString(3);
            items = dbCursor.getString(4);
            number= dbCursor.getString(5);
            DateIn = dbCursor.getString(6);
            Cost = dbCursor.getString(7);
            Dateout = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            dbAdapter.deleteRepair(ticketNum);
            dbAdapter.insertIntoCompleted(ticketNum,name,repair, repairOther, items, number, DateIn, Dateout, Cost);
            Toast.makeText(this, "moved done", Toast.LENGTH_SHORT).show();













        }
        catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }
}
