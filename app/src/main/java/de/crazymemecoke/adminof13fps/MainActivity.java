package de.crazymemecoke.adminof13fps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        Startseite startseiteF = new Startseite();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.flcontent, startseiteF).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Startseite startseiteF = new Startseite();
        Info infoF = new Info();
        Settings settingsF = new Settings();
        Changelog changelogF = new Changelog();
        ACP acpF = new ACP();
        FragmentManager manager = getSupportFragmentManager();

        switch (menuItem.getItemId()) {
            case R.id.forum:
                manager.beginTransaction().replace(R.id.flcontent, startseiteF).commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.credits:
                manager.beginTransaction().replace(R.id.flcontent, infoF).commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.settings:
                manager.beginTransaction().replace(R.id.flcontent, settingsF).commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.changelog:
                manager.beginTransaction().replace(R.id.flcontent, changelogF).commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.acp:
                manager.beginTransaction().replace(R.id.flcontent, acpF).commit();
                drawerLayout.closeDrawers();
                break;
        }

        return false;
    }
}
