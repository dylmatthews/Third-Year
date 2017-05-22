package a15009851.dylanmatthews.lockstockbarrel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static java.lang.Long.parseLong;

public class updateRepair extends AppCompatActivity {

    DbAdapter dbAdapter;
    EditText name;
    EditText repair;
    EditText repairOther;
    EditText numItems;
    EditText number;
    EditText co;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_repair);
        dbAdapter = new DbAdapter(this);
        name = (EditText) findViewById(R.id.etUpdateName);
        repair = (EditText) findViewById(R.id.etUpdateRepair);
        repairOther = (EditText) findViewById(R.id.etUpdateRepairExtra);
        numItems = (EditText) findViewById(R.id.etNumItems);
        number = (EditText) findViewById(R.id.etUpdateNumber);
        co = (EditText) findViewById(R.id.etUpdateCost);
        id = (EditText) findViewById(R.id.etUpdateNumber);
    }



    public void onUpdate(View view)
    {
        long i= parseLong(id.getText().toString());
        String na = name.getText().toString();
        String re = repair.getText().toString();
        String reo = repairOther.getText().toString();
        String numI = numItems.getText().toString();
        String cell = number.getText().toString();
        String cos = co.getText().toString();


        dbAdapter.updateRepair(i,na, re, reo,numI,cell, cos);
    }


}
