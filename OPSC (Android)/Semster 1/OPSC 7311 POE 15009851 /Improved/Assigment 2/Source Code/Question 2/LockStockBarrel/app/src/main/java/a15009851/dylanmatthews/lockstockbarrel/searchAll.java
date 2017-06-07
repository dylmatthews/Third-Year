package a15009851.dylanmatthews.lockstockbarrel;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class searchAll extends base_activity {

    DbAdapter dbAdapter;
    TextView displayResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_all);
        dbAdapter = new DbAdapter(this);
        displayResults = (TextView) findViewById(R.id.tvDisplayResults);
        fullResults();
        super.onCreateDrawer();
    }



    public void fullResults()
    {


        dbAdapter.open();


        Cursor dbCursor = dbAdapter.getAllRepairs(); //gets all entries
        String allRepairRecords = "";
        int cnt =0;

        if(dbCursor.moveToFirst())
        {
            do
            {
                {
                    if(cnt>0) {
                        allRepairRecords += "Ticket Number: " + dbCursor.getInt(0) +
                                "\tName : " + dbCursor.getString(1) + "\n" +
                                "Repair : " + dbCursor.getString(2) + "\n" +
                                "RepairOther : " + dbCursor.getString(3) + "\n" +
                                "Number of items : " + dbCursor.getString(4) + "\n" +
                                "Cellphone Number : " + dbCursor.getString(5) + "\n" +
                                "Date : " + dbCursor.getString(6) + "\n" +
                                "Price : " + dbCursor.getString(7) + "\n---------------------------------------------------------------\n";
                    }
                    else
                    {
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
        displayResults.setText(allRepairRecords);

        dbAdapter.close();
    }


}
