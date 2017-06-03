package a15009851.dylanmatthews.lockstockbarrel;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class searchTicketNumber extends AppCompatActivity {

    DbAdapter dbAdapter;
    EditText etTicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ticket_number);

        etTicket = (EditText) findViewById(R.id.etTicketNum);
        dbAdapter = new DbAdapter(this);
    }

    public void onSearch(View view)
    {
        try {
            dbAdapter.open();

            //Toast.makeText(this,"Hello p", Toast.LENGTH_SHORT).show();
            Cursor dbCursor = dbAdapter.getRepairTicket(Integer.parseInt(etTicket.getText().toString()));
            String allRepairRecords = " ";
            int cnt = 0;

            if (dbCursor.moveToFirst()) {
                allRepairRecords = "";
                do {
                    {
                        if (cnt > 0) {
                            allRepairRecords += "Ticket Number: " + dbCursor.getInt(0) +
                                    "\tName : " + dbCursor.getString(1) + "\n" +
                                    "Repair : " + dbCursor.getString(2) + "\n" +
                                    "RepairOther : " + dbCursor.getString(3) + "\n" +
                                    "Number of items : " + dbCursor.getString(4) + "\n" +
                                    "Cellphone Number : " + dbCursor.getString(5) + "\n" +
                                    "Date : " + dbCursor.getString(6) + "\n" +
                                    "Price : " + dbCursor.getString(7) + "\n---------------------------------------------------------------\n";
                        } else {
                            allRepairRecords += "\nTicket Number: " + dbCursor.getInt(0) + "\n" +
                                    "Name : " + dbCursor.getString(1) + "\n" +
                                    "Repair : " + dbCursor.getString(2) + "\n" +
                                    "RepairOther : " + dbCursor.getString(3) + "\n" +
                                    "Number of items : " + dbCursor.getString(4) + "\n" +
                                    "Cellphone Number : " + dbCursor.getString(5) + "\n" +
                                    "Date : " + dbCursor.getString(6) + "\n" +
                                    "Price : " + dbCursor.getString(7) + "\n---------------------------------------------------------------\n";
                        }

                    }
                }
                while (dbCursor.moveToNext());
            }
            dbAdapter.close();
            //Toast.makeText(this, allRepairRecords+ "Hello", Toast.LENGTH_SHORT).show();
            Intent vr = new Intent(this, ViewResults.class);
            vr.putExtra("results", allRepairRecords);
            startActivity(vr);
        }
        catch (Exception e)
        {
            Log.e("shit", e.getMessage());
        }



    }
}
