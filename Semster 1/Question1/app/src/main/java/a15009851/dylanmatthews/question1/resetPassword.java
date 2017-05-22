package a15009851.dylanmatthews.question1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class resetPassword extends AppCompatActivity {


    ArrayList<String> user = new ArrayList<String>();
    ArrayList <String> password = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
    }

    public void onClickResetPassword(View view)
    {
        EditText nwpass = (EditText) findViewById(R.id.etNewPassword);
        EditText comnwpass = (EditText) findViewById(R.id.etComNewPassword);
        EditText usr = (EditText) findViewById(R.id.etResetPasswordName);

        String newpass = nwpass.getText().toString();
        String connewpass = comnwpass.getText().toString();
        String name  = usr.getText().toString();

        if (newpass.equals(connewpass) && !(name.equals("")))
        {
            boolean found = false;
                for(int i=0;i<user.size() && !found;i++)
                {
                    if (name.equals(user.get(i)))
                    {
                        password.set(i,newpass) ;
                        found = true;

                    }
                }

            if (found)
            {
                Toast.makeText(this, "Password Updated!!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "no user found", Toast.LENGTH_SHORT).show();
            }

            try {
                FileOutputStream fOut = openFileOutput("login.txt", MODE_APPEND);
                OutputStreamWriter osw = new OutputStreamWriter(fOut);
                for(int i=0;i<user.size() && !found;i++) {
                    osw.write(user.get(i) + "#" + password.get(i) + "\n");
                }

                osw.close();
                Toast.makeText(this, "File Saved Successfully", Toast.LENGTH_SHORT).show();

            } catch (IOException ioe) {
                ioe.printStackTrace();
                Toast.makeText(this, ioe.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
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


        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
    }
}
