package dylanmatthews15009851.com.prj15009851assignment1;

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

    public void onPlay(View view) //switches activities
    {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void onRules(View view) //switches activities
    {
        startActivity(new Intent(getApplicationContext(), rules.class));
    }
}
