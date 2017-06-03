package a15009851.dylanmatthews.lockstockbarrel;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class searchDate extends Activity implements View.OnClickListener{

    EditText txtDate;
    DatePickerDialog date;
    SimpleDateFormat dateFormatter;
    DbAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_date);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        txtDate = (EditText) findViewById(R.id.txtDat);
        dbAdapter = new DbAdapter(this);
        txtDate.setInputType(0);
        txtDate.requestFocus();

cal();
    }
    public void cal() {
        txtDate.setOnClickListener(this);
       Calendar newCalendar = Calendar.getInstance();
        date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
              txtDate.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    public void onClick(View v) {
        if (v == this.txtDate) {
            this.date.show();
        }
    }


    public void searchDate(View view)
    {
        dbAdapter.open();

        //Toast.makeText(this,"Hello p", Toast.LENGTH_SHORT).show();
        Cursor dbCursor = dbAdapter.getRepairDate(txtDate.getText().toString());
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
        dbAdapter.close();
      //Toast.makeText(this, allRepairRecords+ "Hello", Toast.LENGTH_SHORT).show();
        Intent vr = new Intent(this, ViewResults.class);
        vr.putExtra("results",allRepairRecords);
        startActivity(vr);



    }

}
