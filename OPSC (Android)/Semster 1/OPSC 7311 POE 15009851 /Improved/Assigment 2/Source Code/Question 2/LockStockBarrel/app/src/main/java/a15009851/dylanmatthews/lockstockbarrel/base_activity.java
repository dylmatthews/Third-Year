package a15009851.dylanmatthews.lockstockbarrel;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by dylanmatthews on 2017/06/06.
 */

public class base_activity extends Activity   implements NavigationView.OnNavigationItemSelectedListener{


    private NavigationView navigationView;
   // private DrawerLayout drawerLayout;
    //private ActionBarDrawerToggle tongle;

    protected void onCreateDrawer() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
       navigationView.setNavigationItemSelectedListener(this);
    }







    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //Toast.makeText(this, "going to " + id, Toast.LENGTH_SHORT).show();
        if (id==R.id.nav_home)
        {
            startActivity(new Intent(getApplicationContext(), home.class));
        }
        else if (id==R.id.nav_insert)
        {
            startActivity(new Intent(getApplicationContext(), insertRepair.class));
        }
        else if (id==R.id.nav_searchPhone)
        {
            startActivity(new Intent(getApplicationContext(), searchNumber.class));
        }
        else if (id==R.id.nav_searchDate)
        {
            startActivity(new Intent(getApplicationContext(), searchDate.class));
        }
        else if (id==R.id.nav_update)
        {
            startActivity(new Intent(getApplicationContext(), updateRepair.class));
        }
        else if (id==R.id.nav_ticket)
        {
            startActivity(new Intent(getApplicationContext(), searchTicketNumber.class));
        }
        else if(id==R.id.nav_name)
        {
            startActivity(new Intent(getApplicationContext(), searchName.class));

        }
        else if (id==R.id.nav_collected)
        {
            startActivity(new Intent(getApplicationContext(), completedRepairs.class));
        }
        else if (id==R.id.nav_all)
        {
            startActivity(new Intent(getApplicationContext(), searchAll.class));
        }
        else if (id==R.id.nav_viewCompleted)
        {
            startActivity(new Intent(getApplicationContext(), searchByCompletedRepairs.class));
        }
        return true;

    }
}
