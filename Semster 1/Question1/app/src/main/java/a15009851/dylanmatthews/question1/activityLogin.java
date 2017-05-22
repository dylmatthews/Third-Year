package a15009851.dylanmatthews.question1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class activityLogin extends AppCompatActivity {

    ArrayList <String> user = new ArrayList<String>();
    ArrayList <String> password = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void display(String toast)
    {
        Toast output= Toast.makeText(this, toast, Toast.LENGTH_SHORT);
        output.setGravity(Gravity.CENTER,0,0);
        output.show();
    }

    public void readFromFile()
    {
        BufferedReader objRead;
        //String textFileData="";
        String line;

        try {
            FileInputStream objInput = openFileInput("login.txt");

            objRead = new BufferedReader(new InputStreamReader((objInput)));
            while((line=objRead.readLine())!=null)
            {
                String [] temp = line.split("#");
                user.add(temp[0]);
                password.add(temp[1]);
               //textFileData += line + "\n";

            }
           display("File Loaded Successfully");

        }
        catch (IOException e)
        {
            e.printStackTrace();
            display(e.getMessage());
        }
    }

    public void onClickLogin(View view)
    {
        readFromFile();
        EditText name = (EditText) findViewById(R.id.etLoginName);
        EditText passwor = (EditText) findViewById(R.id.etLoginPassword);
        boolean found= false;

        String na = name.getText().toString();
        String pa  = passwor.getText().toString();
        for (int i=0; i<user.size()&&!found;i++)
        {
            if (user.get(i).equals(na))
            {

                if (password.get(i).equals(pa))
                {

                    found=true;
                }
                else {
                    found=false;
                    display("Password Is Incorrect");
                }
            }

        }

        if(found)
        {
            display("Login Successful");
            Intent dis = new Intent(this, display.class);
            startActivity(dis);
        }
        else
        {
            display("Login UnSuccessful");
        }
    }

}
