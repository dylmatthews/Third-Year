package a15009851.dylanmatthews.question1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLogin(View view)
    {
        Intent login = new Intent(this,activityLogin.class) ;
        startActivity(login);

    }

    public void onClickSignUp(View view)
    {
        Intent signUp = new Intent(this, activitySignUp.class);
        startActivity(signUp);
    }


    public void onForgotPassword(View view)
    {
        Intent resetpass = new Intent(this, resetPassword.class);
        startActivity(resetpass);
    }
}
