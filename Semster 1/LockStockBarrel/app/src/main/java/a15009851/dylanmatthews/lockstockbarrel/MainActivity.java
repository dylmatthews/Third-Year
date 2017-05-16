package a15009851.dylanmatthews.lockstockbarrel;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DbAdapter dbAdapter;
    EditText name;
    EditText repair;
    EditText repairOther;
    EditText numItems;
    EditText number;
    EditText co;

    String nam;
    String repai;
    String ro;
    int numI;
    String date= "";
    String cost = "R";
    String num;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbAdapter = new DbAdapter(this);
        name = (EditText) findViewById(R.id.etName);
        repair = (EditText) findViewById(R.id.etRepair);
        repairOther = (EditText) findViewById(R.id.etRepairExtra);
        numItems = (EditText) findViewById(R.id.etNumItems);
        number = (EditText) findViewById(R.id.etNumber);
        co = (EditText) findViewById(R.id.etCost);
    }

    public void addRepair(View view)
    {
        try {
            nam = name.getText().toString();
            repai = repair.getText().toString();
            ro = repairOther.getText().toString();
            numI = Integer.parseInt(numItems.getText().toString());
            date  = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            cost = "R"+ co.getText().toString();
            num = number.getText().toString();
            dbAdapter.open();
            dbAdapter.insertRepair(nam, repai, ro, numI, num, date, cost);
            Toast.makeText(this, "Add Successfull", Toast.LENGTH_SHORT).show();

            Cursor dbCursor = dbAdapter.getAllRepairs();
            String allTeamRecords = "";

            if(dbCursor.moveToFirst())
            {
                do
                {
                    {
                        allTeamRecords += "id: " + dbCursor.getInt(0) +
                                " Name : " + dbCursor.getString(1) +
                                " Repair : " +dbCursor.getString(2) +
                                " RepairOther : " +  dbCursor.getString(3) +
                                "Number of items : "+ dbCursor.getString(4)   +
                                "Cellphone Number : "+ dbCursor.getString(5)+
                                "Date : " + dbCursor.getString(6) +
                                "Price : " + dbCursor.getString(7)+"\n";
                    }
                }
                while (dbCursor.moveToNext());
            }
           // DisplayRepairs(allTeamRecords);
            dbAdapter.close();
            //dbAdapter.close();
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();;
        }


    }

    public void DisplayRepairs(String teams)
    {
        Toast.makeText(this,teams,Toast.LENGTH_SHORT).show();
    }

    public void onSearch(View view)
    {
        Intent search = new Intent(this, activity_searchBY.class);
        startActivity(search);
    }



}
