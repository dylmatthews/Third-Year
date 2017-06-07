package a15009851.dylanmatthews.lockstockbarrel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends base_activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        super.onCreateDrawer();
    }

    public void onSearch(View view) //switches activities
    {
        Intent search = new Intent(this, activity_searchBY.class);
        startActivity(search);
    }

    public  void onRepairFetched(View view) //switches activities
    {
        Intent fetched = new Intent(this, completedRepairs.class);
        startActivity(fetched);
    }

    public void onInsert(View view) //switches activities
    {
        Intent fetched = new Intent(this, insertRepair.class);
        startActivity(fetched);
    }

    public void onSearchFetched(View view) //switches activities
    {
       Intent com = new Intent(this, searchByCompletedRepairs.class);
        startActivity(com);
    }

    public void onUpdatebtn(View view)//switches activities
    {
        Intent update = new Intent(this, updateRepair.class);
        startActivity(update);
    }


}
