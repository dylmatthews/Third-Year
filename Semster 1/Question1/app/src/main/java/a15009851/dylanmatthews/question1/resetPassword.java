package a15009851.dylanmatthews.question1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class resetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
    }

    public void onClickResetPassword(View view)
    {
        EditText nwpass = (EditText) findViewById(R.id.etNewPassword);
        EditText comnwpass = (EditText) findViewById(R.id.etComNewPassword);
        EditText user = (EditText) findViewById(R.id.etResetPasswordName);

        String newpass = nwpass.getText().toString();
        String connewpass = comnwpass.getText().toString();
        String name  = user.getText().toString();

        if (newpass.equals(connewpass) && !(name.equals("")))
        {

        }
    }
}
