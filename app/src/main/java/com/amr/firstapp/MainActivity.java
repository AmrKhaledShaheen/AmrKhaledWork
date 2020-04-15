package com.amr.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView= findViewById(R.id.navbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        NavigationView navView =findViewById(R.id.navview);
        navView.setNavigationItemSelectedListener(navViewListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new homefregment()).commit();

        DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        Toolbar toolbar =findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    private NavigationView.OnNavigationItemSelectedListener navViewListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
            switch (item.getItemId())
            {

                case R.id.about:
                    Intent intent=new Intent(MainActivity.this, about_activity.class);
                    startActivity(intent);
                    break;
                case R.id.account:
                    intent=new Intent(MainActivity.this, account_activity.class);
                    startActivity(intent);
                    break;
                case R.id.notifications:
                    intent=new Intent(MainActivity.this, notification_activity.class);
                    startActivity(intent);
                    break;

            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment ;
            switch (menuItem.getItemId())
            {
                case R.id.home:
                    fragment = new homefregment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                    break;
                case R.id.search:
                    fragment = new searchfragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                    break;
                case R.id.library:
                    fragment = new libraryfragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                    break;
                case R.id.premium:
                    fragment = new premiumfragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                    break;

            }

            return true;
        }

    };
}
