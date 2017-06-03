package a15009851.dylanmatthews.question1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class activitySignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void toast(String t)
    {
        Toast output= Toast.makeText(this, t, Toast.LENGTH_SHORT);
        output.setGravity(Gravity.CENTER,0,0);
        output.show();
    }

    public void writeTOFile (String name, String password, String conPassword){

        if (name.equals("") || password.equals("") || conPassword.equals(""))
        {
            toast("You left a field empty");
        }
        else {
            try {
                FileOutputStream fOut = openFileOutput("login.txt", MODE_APPEND);
                OutputStreamWriter osw = new OutputStreamWriter(fOut);

                osw.write(name + "#" + password + "\n");
                osw.close();
                toast("File Saved Successfully");

            } catch (IOException ioe) {
                ioe.printStackTrace();
                toast(ioe.getMessage());
            }
        }
    }

    public void onClickSignUp(View view)
    {
        EditText na = (EditText) findViewById(R.id.etSignUpName);
        EditText pass  = (EditText) findViewById(R.id.etSignUpPassword);
        EditText cpass = (EditText) findViewById(R.id.etConfirmPassword);

        String name = na.getText().toString();
        String passwo = pass.getText().toString();
        String conpass = cpass.getText().toString();
        if (passwo.equals(conpass))
        {
            writeTOFile(name,passwo, conpass);
        }
        else
        {
            toast("Passwords don't match");
        }

    }

}
