package a15009851.dylanmatthews.lockstockbarrel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onSearch(View view)
    {
        Intent search = new Intent(this, activity_searchBY.class);
        startActivity(search);
    }

    public  void onRepairFetched(View view)
    {
        Intent fetched = new Intent(this, completedRepairs.class);
        startActivity(fetched);
    }

    public void onInsert(View view)
    {
        Intent fetched = new Intent(this, insertRepair.class);
        startActivity(fetched);
    }

    public void onSearchFetched(View view)
    {
       Intent com = new Intent(this, searchByCompletedRepairs.class);
        startActivity(com);
    }

    public void onUpdatebtn(View view)
    {
        Intent update = new Intent(this, updateRepair.class);
        startActivity(update);
    }
}
