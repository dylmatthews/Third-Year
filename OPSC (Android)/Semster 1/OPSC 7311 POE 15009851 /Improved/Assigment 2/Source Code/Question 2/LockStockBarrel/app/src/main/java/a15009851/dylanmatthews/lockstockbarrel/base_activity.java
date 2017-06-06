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
      //  drawerLayout = (DrawerLayout) findViewById(R.id.nav_view);
       navigationView.setNavigationItemSelectedListener(this);
        //tongle = new ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close);
        //drawerLayout.addDrawerListener(tongle);
        //tongle.syncState();
      //getActionBar().setDisplayHomeAsUpEnabled(true);
    }







    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Toast.makeText(this, "going to " + id, Toast.LENGTH_SHORT).show();
        if (id==R.id.nav_home)
        {
            Toast.makeText(this, "going to " + id, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), home.class));
        }
        return true;

    }
}
