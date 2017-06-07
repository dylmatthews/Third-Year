package a15009851.dylanmatthews.lockstockbarrel;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Date;

public class insertRepair extends base_activity {

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
    String num="";
    String RepairRecord = "";
    String no="";;



    @Override
    protected void onCreate(Bundle savedInstanceState) { //declares
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbAdapter = new DbAdapter(this);
        name = (EditText) findViewById(R.id.etUpdateName);
        repair = (EditText) findViewById(R.id.etUpdateRepair);
        repairOther = (EditText) findViewById(R.id.etUpdateRepairExtra);
        numItems = (EditText) findViewById(R.id.etNumItems);
        number = (EditText) findViewById(R.id.etUpdateNumber);
        co = (EditText) findViewById(R.id.etUpdateCost);
        try {

            super.onCreateDrawer();
        }
        catch (Exception e)
        {
            Log.e("Error", e.getMessage());
        }


    }
    public void toast(String t)
    {
        Toast output= Toast.makeText(this, t, Toast.LENGTH_SHORT);
        output.setGravity(Gravity.CENTER,0,0);
        output.show();
    }


    public void addRepair(View view)
    {

        try {
            nam = name.getText().toString();
            repai = repair.getText().toString();
            ro = repairOther.getText().toString();
            numI = Integer.parseInt(numItems.getText().toString());
            date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            cost = "R" + co.getText().toString();
            num = number.getText().toString();

            if (name.equals("") || repai.equals("")  || date.equals("") || number.getText().toString().equals("") || num.equals("")) {

                toast("there are some fields which are empty");
            } else {
                dbAdapter.open();
                dbAdapter.insertRepair(nam, repai, ro, numI, num, date, cost); //inserts
                toast("Add Successfully");

                    Cursor dbCursor = dbAdapter.getAllRepairs();

                    if (dbCursor.moveToFirst()) {
                        do {
                            {

                                RepairRecord = "Ticket Number: " + dbCursor.getInt(0) +
                                        "\tName : " + dbCursor.getString(1) + "\n" +
                                        "Repair : " + dbCursor.getString(2) + "\n" +
                                        "RepairOther : " + dbCursor.getString(3) + "\n" +
                                        "Number of items : " + dbCursor.getString(4) + "\n" +
                                        "Cellphone Number : " + dbCursor.getString(5) + "\n" +
                                        "Date : " + dbCursor.getString(6) + "\n"
                                        + "Price : " + dbCursor.getString(7);

                                no = dbCursor.getString(5);


                            }
                        }
                        while (dbCursor.moveToNext());
                    }


                }



                // DisplayRepairs(allTeamRecords);
                dbAdapter.close();

                //dbAdapter.close();

            }
            catch(Exception e)
            {
                toast(e.getMessage());
                e.printStackTrace();
                ;
            }
        sendSMS();




    }

    public void sendSMS()
    {
        try {
            String mess = RepairRecord;
         //   toast(mess);
            SmsManager smsManager = SmsManager.getDefault();

            no = "+27" + no.substring(1); //substring at 1 to get rid of the 0, needs to be intentional number


          //  toast(no);


            smsManager.sendTextMessage(no, null, mess, null, null); //sends out an sms to the number and the ticket details
        }
        catch (Exception e)
        {
            toast("Error sending sms, please check app permissions and allow to access sms");
        }
    }





}
