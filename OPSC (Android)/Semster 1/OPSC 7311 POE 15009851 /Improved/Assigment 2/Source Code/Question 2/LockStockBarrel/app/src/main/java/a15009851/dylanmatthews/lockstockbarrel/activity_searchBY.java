package a15009851.dylanmatthews.lockstockbarrel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_searchBY extends base_activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by);
        super.onCreateDrawer();

    }

    public void searchName(View view) //switches activities
    {
        Intent searchName = new Intent(this, searchName.class);
        startActivity(searchName);
    }

    public void searchNumber(View view) //switches activities
    {
        Intent searchNumber = new Intent(this, searchNumber.class);
        startActivity(searchNumber);
    }

    public void searchDate(View view) //switches activities
    {
        Intent searchDate = new Intent(this, searchDate.class);
        startActivity(searchDate);
    }

    public void searchTicketNumber(View view) //switches activities
    {
        Intent searchTicketNum = new Intent(this, searchTicketNumber.class);
        startActivity(searchTicketNum);
    }

    public void searchALL(View view) //switches activities
    {
        Intent search = new Intent(this, searchAll.class);
        startActivity(search);
    }
}
