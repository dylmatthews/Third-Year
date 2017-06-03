package a15009851.dylanmatthews.question1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class display extends AppCompatActivity {
 private  String output;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        tv = (TextView) findViewById(R.id.tvResults) ;
        BufferedReader objRead;
        //String textFileData="";
        String line;

        try {
            FileInputStream objInput = openFileInput("login.txt");

            objRead = new BufferedReader(new InputStreamReader((objInput)));
            while((line=objRead.readLine())!=null)
            {
               output+= line + "\n";

                //textFileData += line + "\n";

            }
            tv.setText(output);


        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
    }
}
