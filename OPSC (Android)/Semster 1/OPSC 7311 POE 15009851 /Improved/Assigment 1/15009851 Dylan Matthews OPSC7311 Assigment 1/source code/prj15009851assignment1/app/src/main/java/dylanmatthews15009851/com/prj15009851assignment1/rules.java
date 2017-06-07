package dylanmatthews15009851.com.prj15009851assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class rules extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        tv = (TextView) findViewById(R.id.tvRules);
        tv.setText("Yahtzee is a dice game that’s very simple to learn and play. The rules are straightforward, and this game is based mostly on luck. The skill involved has to do with deciding how to score your rolls.\n" +
                "\n" +
                "As such Yahtzee is popular with people of all ages, including children, and is played all over the world. Most people play for fun, but it can be played for stakes and some people do gamble on it when playing.\n" +
                "On each turn a player rolls the five dice. After they have rolled, they can choose what they want to use to score for.\n" +
                "\n" +
                "Once a player selects what he/she wants to use the dice throw for points the device must be passed over to the next user.\n" +
                "\n" +
                "Only one move must be made at a time players move.\n"); //displays rules
    }
}
