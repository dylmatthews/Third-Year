package dylanmatthews15009851.com.prj15009851assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Boolean p1Ones, p2Ones, p1Twos, p2Twos, p1Threes, p2Threes, p1Fours, p2Fours, p1Fives, p2Fives, p1Sixs, p2Sixs, p1ThreeKind,p2ThreeKind, p1FourKind, p2FourKind, p1FullHouse, p2FullHouse, p1smlStraight, p2smlStraight, p1LongStraight, p2LongStraight, p1Yahtzee, p2Yahtzee;
   int [] rolls = new int [5];
    Boolean [] stay;
    private ImageButton one ;
    private ImageButton two ;
    private ImageButton three ;
    private ImageButton four ;
    private ImageButton five;

    private int scorep1=0;
    private int scorep2=0;

    private int[] ImageID ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stay  = new Boolean[5];
        //setting the values to widgets
        one =  (ImageButton)findViewById(R.id.image1);
        two= (ImageButton)findViewById(R.id.image2);
        three = (ImageButton)findViewById(R.id.image3);
        four =  (ImageButton)findViewById(R.id.image4);
        five = (ImageButton)findViewById(R.id.image5);
        ImageID = new int[] //image array
                {
                        R.drawable.one,
                        R.drawable.two,
                        R.drawable.three,
                        R.drawable.four,
                        R.drawable.five,
                        R.drawable.six


                };






    }

    public void onNextRoll(View v)  //roll
    {
        try {

        for (int i=0;i<5;i++)
        {

                Random r  = new Random();
                int rand = r.nextInt(7 )+1; //random number for value
         //   Toast.makeText(this, "Random number is " + rand, Toast.LENGTH_SHORT).show();
                rolls[i] = rand;

                if (i==0) { //sets dice 1 to correct image
                    if (rand == 1) {
                        one.setImageResource(ImageID[0]);
                    } else if (rand == 2) {
                        one.setImageResource(ImageID[1]);
                    } else if (rand == 3) {
                        one.setImageResource(ImageID[2]);
                    } else if (rand == 4) {
                        one.setImageResource(ImageID[3]);
                    } else if (rand == 5) {
                        one.setImageResource(ImageID[4]);
                    } else if (rand == 6) {
                        one.setImageResource(ImageID[5]);
                    }
                }

            if(i==1) //sets dice 2 to correct image
                {
                    if (rand == 1) {
                        two.setImageResource(ImageID[0]);
                    } else if (rand ==2) {
                        two.setImageResource(ImageID[1]);
                    } else if (rand == 3) {
                        two.setImageResource(ImageID[2]);
                    } else if (rand == 4) {
                        two.setImageResource(ImageID[3]);
                    } else if (rand == 5) {
                        two.setImageResource(ImageID[4]);
                    } else if (rand == 6) {
                        two.setImageResource(ImageID[5]);
                    }

                }

              if(i==2) //sets dice 3 to correct image
                {
                    if (rand == 1) {
                        three.setImageResource(ImageID[0]);
                    } else if (rand == 2) {
                        three.setImageResource(ImageID[1]);
                    } else if (rand == 3) {
                        three.setImageResource(ImageID[2]);
                    } else if (rand == 4) {
                        three.setImageResource(ImageID[3]);
                    } else if (rand == 5) {
                        three.setImageResource(ImageID[4]);
                    } else if (rand == 6) {
                        three.setImageResource(ImageID[5]);
                    }

                }

            if(i==3) //sets dice 4 to correct image
                {
                    if (rand == 1) {
                        four.setImageResource(ImageID[0]);
                    } else if (rand == 2) {
                        four.setImageResource(ImageID[1]);
                    } else if (rand == 3) {
                        four.setImageResource(ImageID[2]);
                    } else if (rand == 4) {
                        four.setImageResource(ImageID[3]);
                    } else if (rand == 5) {
                        four.setImageResource(ImageID[4]);
                    } else if (rand == 6) {
                        four.setImageResource(ImageID[5]);
                    }

                }

                 if(i==4) //sets dice 5 to correct image
                {
                    if (rand == 1) {
                        five.setImageResource(ImageID[0]);
                    } else if (rand == 2) {
                        five.setImageResource(ImageID[1]);
                    } else if (rand == 3) {
                        five.setImageResource(ImageID[2]);
                    } else if (rand == 4) {
                        five.setImageResource(ImageID[3]);
                    } else if (rand == 5) {
                        five.setImageResource(ImageID[4]);
                    } else if (rand == 6) {
                        five.setImageResource(ImageID[5]);
                    }

                }
            }



        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }


    }

    public void onp1One(View v)
    {
        try {


            Button p1One = (Button) (findViewById(R.id.btn1P1));
            p1One.setText(Ones()); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(Ones());
        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }

    }

    public void onp2One(View v)
    {
        try {


            Button p2One = (Button) (findViewById(R.id.btn1P2));
            p2One.setText(Ones()); //gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(Ones());
        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String Ones()
    {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {


            if (rolls[i] == 1) {
                cnt++;
            }

            Log.i("blah", ""+i);

        }

     return ("" + cnt);
    }

    public String Twos()
    {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {


            if (rolls[i] == 2) {
                cnt++;
            }

            Log.i("blah", ""+i);

        }

        return ("" + cnt*2);
    }

    public void onp1Two(View v)
    {
        try {


            Button p1Twos = (Button) (findViewById(R.id.btn2P2));
            p1Twos.setText(Twos());//gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(Twos());
        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }
    }


    public void onp2Two(View v)
    {
        try {


            Button p2Twos = (Button) (findViewById(R.id.btn2P1));
            p2Twos.setText(Twos()); //gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(Twos());
        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String Threes()
    {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {


            if (rolls[i] == 3) {
                cnt++;
            }

            Log.i("blah", ""+i);

        }

        return ("" + cnt*3);
    }
    public void onp1Three(View v)
    {
        try {


            Button btn = (Button) (findViewById(R.id.btn3P1));
            btn.setText(Threes()); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(Threes());
        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public void onp2Three(View v)
    {
        try {


            Button btn = (Button) (findViewById(R.id.btn3P2));
            btn.setText(Threes()); //gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(Threes());
        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }
    }


    public String Fours()
    {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {


            if (rolls[i] == 4) {
                cnt++;
            }

            Log.i("blah", ""+i);

        }

        return ("" + cnt*4);
    }

    public void onp1Four(View v)
    {
        try {


            Button btn = (Button) (findViewById(R.id.btn4P1));
            btn.setText(Fours()); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(Fours());
        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public void onp2Four(View v)
    {
        try {


            Button btn = (Button) (findViewById(R.id.btn4P2));
            btn.setText(Fours());
            scorep2= scorep2 + Integer.parseInt(Fours());
        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String Fives()
    {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {


            if (rolls[i] == 5) {
                cnt++;
            }

            Log.i("blah", ""+i);

        }

        return ("" + cnt*5);
    }

    public void onp1Five(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btn5P1));
            btn.setText(Fives()); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(Fives());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }
    public void onp2Five(View v)
    {
        try {


            Button btn = (Button) (findViewById(R.id.btn5P2));
            btn.setText(Fives()); //gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(Fives());
        } catch (Exception e)
        {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String Sixs()
    {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {


            if (rolls[i] == 6) {
                cnt++;
            }

            Log.i("blah", ""+i);

        }

        return ("" + cnt*6);
    }

    public void onp1Six(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btn6P1));
            btn.setText(Sixs()); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(Sixs());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }


    public void onp2Six(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btn6P2));
            btn.setText(Sixs()); //gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(Sixs());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String threeOfKind()
    {


        int score=0;
        int cnt1 =0;
        int cnt2 =0;
        int cnt3 = 0;
        int cnt4 = 0;
        int cnt5 = 0;
        int cnt6 =0;
        boolean threeKind=false;
        for (int i =0; i<5;i++)
        {

            if (rolls[i]==1)
            cnt1++;
            else if (rolls[i]==2)
                cnt2++;
            else if (rolls[i]==3)
                cnt3++;
            else if (rolls[i]==4)
                cnt4++;
            else if (rolls[i]==5)
                cnt5++;
            else if (rolls[i]==6)
                cnt6++;
        }

        if (cnt1>=3)
        {
            Toast.makeText(this, "Three Ones", Toast.LENGTH_SHORT).show();
            threeKind = true;
        }
        else if (cnt2>=3)
        {
            Toast.makeText(this, "Three 2s", Toast.LENGTH_SHORT).show();
            threeKind = true;
        }
        else if  (cnt3>=3)
        {
            threeKind = true;
            Toast.makeText(this, "Three 3s", Toast.LENGTH_SHORT).show();
        }
        else if (cnt4>=3)
        {
            threeKind = true;
            Toast.makeText(this, "Three 4s", Toast.LENGTH_SHORT).show();
        }
        else if (cnt5>=3)
        {
            threeKind = true;
            Toast.makeText(this, "Three 5s", Toast.LENGTH_SHORT).show();
        }
        else if (cnt6>=3)
        {
            threeKind = true;
            Toast.makeText(this, "Three 6s", Toast.LENGTH_SHORT).show();
        }

        if (threeKind)
        {
            for (int i=0;i<5;i++)
            {
                int temp = rolls[i];
                score = score + temp;
            }
        }


//to search for three of a kind
        /*for (int i=0; i<6;i++)
        {
            for (int y=i+1;y<6;y++)
            {
                for (int z=y+1;z<6;z++)
                {
                    if (rolls[i]==rolls[y] && rolls[i]==rolls[z])
                    {
                        found  =true;
                        break;

                    }
                }
            }
        }
        if (found)
        {
            score =rolls[0]+rolls[1] + rolls[2] + rolls[3] + rolls[4];
        }
        else {
            score=0;
        }*/

        return score+"";

    }

    public void onp13Kind(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btn3KindP1));
            btn.setText((threeOfKind())); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(threeOfKind());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public void onp23Kind(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btn3KindP2));
            btn.setText((threeOfKind())); //gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(threeOfKind());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String fourOfKind()
    {

        int score=0;
        int cnt1 =0;
        int cnt2 =0;
        int cnt3 = 0;
        int cnt4 = 0;
        int cnt5 = 0;
        int cnt6 =0;
        boolean  fourKind=false;
        for (int i =0; i<5;i++)
        {

            if (rolls[i]==1)
                cnt1++;
            else if (rolls[i]==2)
                cnt2++;
            else if (rolls[i]==3)
                cnt3++;
            else if (rolls[i]==4)
                cnt4++;
            else if (rolls[i]==5)
                cnt5++;
            else if (rolls[i]==6)
                cnt6++;
        }

        if (cnt1>=4)
        {
            Toast.makeText(this, "Four Ones", Toast.LENGTH_SHORT).show();
            fourKind = true;
        }
        else if (cnt2>=4)
        {
            Toast.makeText(this, "Four 2s", Toast.LENGTH_SHORT).show();
            fourKind = true;
        }
        else if  (cnt3>=4)
        {
            fourKind = true;
            Toast.makeText(this, "Four 3s", Toast.LENGTH_SHORT).show();
        }
        else if (cnt4>=4)
        {
            fourKind = true;
            Toast.makeText(this, "Four 4s", Toast.LENGTH_SHORT).show();
        }
        else if (cnt5>=4)
        {
            fourKind = true;
            Toast.makeText(this, "four 5s", Toast.LENGTH_SHORT).show();
        }
        else if (cnt6>=4)
        {
            fourKind = true;
            Toast.makeText(this, "Four 6s", Toast.LENGTH_SHORT).show();
        }

        if (fourKind)
        {
            for (int i=0;i<5;i++)
            {
                int temp = rolls[i];
                score = score + temp;
            }
        }




        //to search for four of a kind first attempt to do it
        /*for (int i=0; i<6;i++)
        {
            for (int y=i+1;y<6;y++)
            {
                for (int z=y+1;z<6;z++)
                {
                    for (int p=z+1; z<6;z++) {

                        if (rolls[i] == rolls[y] && rolls[i] == rolls[z] && rolls[i] ==rolls[p]) {
                            found = true;

                            break;
                        }

                    }
                }
            }
        }
        if (found)
        {
            score = rolls[0] + rolls[1] + rolls[2] + rolls[3] + rolls[4];

        }
        else {
         score = 0;
        }*/
        return score+"";

    }

    public void onp14Kind(View v) {
        try {

            Button btn = (Button) (findViewById(R.id.btn4KindP1));
            btn.setText(fourOfKind()); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(fourOfKind());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public void onp24Kind(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btn4KindP2));
            btn.setText(fourOfKind()); //gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(fourOfKind());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String smallStraight()
    {
        Boolean found;
        int score;
        int [] temp = new int [5];

        for(int i=0; i<5 ;i++)
        temp = rolls;


        int cnt =0;
        for (int i=0; i<5-1;i++)
        {
            if(temp[i]-temp[i+1]==-1)
            {
                cnt++;
            }
        }

        if (cnt==4)
        {
            score = 30;
        }
        else {
            score =0;
        }

        return score+"";

    }

    public void onp1SmallStraight(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btnp1SmallStraight));
            btn.setText(smallStraight());  //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(smallStraight());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public void onp2SmallStraight(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btnp2SmallStraight));
            btn.setText(smallStraight());//gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(smallStraight());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String largeStraight()
    {
        Boolean found;
        int score;
        int [] temp = new int [5];
        temp = rolls;
        Arrays.sort(temp);
        int cnt =0;
        for (int i=0; i<5-1;i++)
        {
            if(temp[i]-temp[i+1]==-1)
            {
                cnt++;
            }
        }

        if (cnt==5)
        {
            score = 30;
        }
        else {
            score =0;
        }

        return score+"";

    }

    public void onp1largeStraight(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btnp1largStraight));
            btn.setText(largeStraight()); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(largeStraight());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public void onp2largeStraight(View v) {
        try {


            Button btn = (Button) (findViewById(R.id.btnp2largStraight));
            btn.setText(largeStraight()); //gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(largeStraight());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String yahtzee ()
    {
        int count =0;
        int score = 0;
        for (int i=0;i<5-1;i++)
        {
            if (rolls[i]==rolls[i+1]) {
                count++;
            }
        }

        if (count==5)
        {
            score = 50;
        }
        else {
            score = 0;
        }

        return  score +"";
    }


    public void onp1Yahtzee(View v)
    {
        try {


            Button btn = (Button) (findViewById(R.id.btnp1Yahtzee));
            btn.setText(yahtzee()); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(yahtzee());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }

    }
    public void onp2Yahtzee(View v)
    {
        try {


            Button btn = (Button) (findViewById(R.id.btnp2Yahtzee));
            btn.setText(yahtzee()); //gets score and set it in the button
            scorep2= scorep2 + Integer.parseInt(yahtzee());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public String fullHouse()
    {
        int score =0;
        return score+"";
    }

    public void onp1FullHouse(View v)
    {
        try {


            Button btn = (Button) (findViewById(R.id.btnFullHouseP1));
            btn.setText(fullHouse()); //gets score and set it in the button
            scorep1 = scorep1 + Integer.parseInt(fullHouse());
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public void onp2FullHouse(View v)
    {
        try {


            Button btn = (Button) (findViewById(R.id.btnFullHouseP2));
            btn.setText(fullHouse()); //gets score and set it in the button
        } catch (Exception e) {
            Log.e("blah", e.getMessage().toString());
        }
    }

    public void btnFinish(View v)
    {
        if (scorep1==scorep2)
        {
            Toast.makeText(this, "Draw!!!", Toast.LENGTH_LONG).show();

        }
        else if (scorep1>scorep2)
        {
            Toast.makeText(this, "Player 1 won!!!!", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(this, "Player 2 won!!!!", Toast.LENGTH_LONG).show();
        }

        startActivity(new Intent(MainActivity.this,MainActivity.class));
    }


    public void Clear(View v)
    {
        startActivity(new Intent(MainActivity.this,MainActivity.class));
    }
















}
