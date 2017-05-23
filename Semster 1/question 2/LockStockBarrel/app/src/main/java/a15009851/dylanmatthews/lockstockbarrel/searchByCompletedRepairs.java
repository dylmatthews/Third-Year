package a15009851.dylanmatthews.lockstockbarrel;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class searchByCompletedRepairs extends AppCompatActivity {

    DbAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_completed_repairs);
        dbAdapter = new DbAdapter(this);
    }

    public void onShowCompleted(View view) {
        try {
            Cursor dbCursor = dbAdapter.getAllCompleted();
            String allRepairRecords = "";
            int cnt = 0;

            if (dbCursor.moveToFirst()) {
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
            Intent vr = new Intent(this, ViewResults.class);
            vr.putExtra("results", allRepairRecords);
            startActivity(vr);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
