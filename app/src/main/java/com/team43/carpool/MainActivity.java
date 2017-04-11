package com.team43.carpool;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar1;
    DrawerLayout drawer_Layout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_main);

        toolbar1 = (Toolbar)findViewById(R.id.toolbar);
        try {

            setSupportActionBar(toolbar1);
            setTitle("V-Pool");


        } catch (Throwable t) {

            // WTF
        }

        //navigation drawer
        drawer_Layout = (DrawerLayout) findViewById(R.id.drawer_layout);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer_Layout,toolbar1,R.string.drawer_open,R.string.drawer_close);
        drawer_Layout.setDrawerListener(actionBarDrawerToggle);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //long num;
                switch (menuItem.getItemId()) {
                    case R.id.myProfile: {
                        //Intent in = new Intent(MainActivity.this,RVshow.class);
                        //in.putParcelableArrayListExtra("list",list);
                        //num = 1;
                        //in.putExtra("North",num);
                        //in.putExtra("Region_NAME", "North");
                        //startActivity(in);
                        drawer_Layout.closeDrawers();
                        break;
                    }
                    case R.id.pref: {
                        //Toast.makeText(getApplicationContext(), "I am East", Toast.LENGTH_LONG).show();
//                        Intent in = new Intent(MainActivity.this,RVshow.class);
//                        //in.putParcelableArrayListExtra("list",list);
//                        //num = 2;
//                        //in.putExtra("East",num);
//                        in.putExtra("Region_NAME", "East");
//                        startActivity(in);
                        drawer_Layout.closeDrawers();
                        break;
                    }
                    case R.id.history: {
                        //Toast.makeText(getApplicationContext(), "I am West", Toast.LENGTH_LONG).show();
//                        Intent in = new Intent(MainActivity.this,RVshow.class);
//                        //in.putParcelableArrayListExtra("list",list);
//                        //num = 3;
//                        //in.putExtra("West",num);
//                        in.putExtra("Region_NAME", "West");
//                        startActivity(in);
                        drawer_Layout.closeDrawers();
                        break;
                    }
                    case R.id.track: {
                        //Toast.makeText(getApplicationContext(), "I am South", Toast.LENGTH_LONG).show();
//                        Intent in = new Intent(MainActivity.this,RVshow.class);
//                        //in.putParcelableArrayListExtra("list",list);
//                        // num = 4;
//                        //in.putExtra("South",num);
//                        in.putExtra("Region_NAME", "South");
//                        startActivity(in);
                        drawer_Layout.closeDrawers();
                        break;
                    }
                    case R.id.notifications: {
                        // Toast.makeText(getApplicationContext(), "I am Facebook", Toast.LENGTH_LONG).show();
//                        String message = "Hey!I am using this awesome app and I thought you would like it. Download link : wwww.koochipoochi.com";
//                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//                        sharingIntent.setType("text/plain");
//                        sharingIntent.putExtra(Intent.EXTRA_TEXT, message);
//                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Sharing is caring");
//                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
//                        startActivity(Intent.createChooser(sharingIntent, "Share via"));

                        drawer_Layout.closeDrawers();
                        break;
                    }
                    case R.id.feedback: {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto", "shreya.sinha95@gmail.com", null));
                        intent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack");
                        intent.putExtra(Intent.EXTRA_TEXT, "");
                        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                        drawer_Layout.closeDrawers();
                        break;
                    }
                    default:
                        break;
                }
                return true;

            }

        });
    }
}
