package a15009851.dylanmatthews.lockstockbarrel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewResults extends AppCompatActivity {

    TextView displayResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);
        displayResults = (TextView) findViewById(R.id.tvDisplayResults);

        String results = getIntent().getStringExtra("results");
        if (results.equals(""))
        {
            displayResults.setText("No results found");
        }
        else {
            displayResults.setText(results);
        }
    }



}
