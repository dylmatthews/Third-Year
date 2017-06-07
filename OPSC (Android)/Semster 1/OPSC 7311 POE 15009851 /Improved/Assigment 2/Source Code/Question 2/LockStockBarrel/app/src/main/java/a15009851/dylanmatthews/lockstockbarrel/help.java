package a15009851.dylanmatthews.lockstockbarrel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class help extends base_activity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        tv = (TextView)  findViewById(R.id.help) ;
        super.onCreateDrawer();
        tv.setText("I got this idea for my dad's shop, he does repairs and currently uses a book system. Once people come in to get repairs " +
                "done (ie like soles, heels, zips ect)\nThey get issued with a ticket. I've worked there a few times and sometimes people lose " +
                "their tickets.\n" +
                "I then made sure to include lots of ways to search for their ticket number.\nOnce somebody comes to collect their repair, the people at the shop " +
                "stamp the ticket in the book to say its been fetched. For this i made it so it moves the repair info into a completed repairs table.\n" +
                "On inserting doesn't matter if cost is empty, part of the business strategy if the person doesn't know then the person who serves charges on the collection. Repairs other is an extra field can be empty it's for if they want it done by an date or another repair\n");
    }
}
