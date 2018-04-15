package com.example.kirill.greenme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.here.android.mpa.mapping.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final static int REQUEST_CODE_ASK_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                runMapActivity();
//            }
//            });

        TextView bPlay = (TextView) findViewById(R.id.play);
        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runMapActivity();
            }
        });

        TextView bRating = (TextView) findViewById(R.id.rating);
        bRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runRatingActivity();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        requestPermissions();
    }

    private void runRatingActivity() {
        Intent intent = new Intent(this, RatingList.class);
        startActivity(intent);

    }
    private void runMapActivity() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void requestPermissions() {

        Toast.makeText(this, "REQUEST", Toast.LENGTH_LONG);
        String[] RUNTIME_PERMISSIONS = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_NETWORK_STATE};

        // check list of permissions
        boolean isPermissionsGranted = true;
        for (String permission : RUNTIME_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                isPermissionsGranted = false;
                break;
            }
        }

        Toast.makeText(this, "AFTER", Toast.LENGTH_LONG);
        // return if all permissions already granted
        if (isPermissionsGranted) {
           // createMapFragmentView();
            return;
        }

        // request permissions
        if (android.os.Build.VERSION.SDK_INT >= 23){
            ActivityCompat.requestPermissions(this,
                    RUNTIME_PERMISSIONS,
                    REQUEST_CODE_ASK_PERMISSIONS);

        }

    }


    /**
     * Create map fragment view.
     * !!! Please note: the HERE SDK requires all permissions defined above to operate properly. !!!
     */
//    void createMapFragmentView() {
//        //Toast.makeText(this, "RUN", Toast.LENGTH_LONG);
//        m_mapFragmentView = new MapFragmentView(this);
//        //Toast.makeText(this, "END", Toast.LENGTH_LONG);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
//            Toast.makeText(this, "RUN", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Prizes.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.scene_root);

        // You can also inflate a generate a Scene from a layout resource file.
        final Scene scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.main_scene1, this);
        TransitionSet set = new TransitionSet();
        set.addTransition(new Fade());
        // выполняться они будут одновременно
        set.setOrdering(TransitionSet.ORDERING_TOGETHER);
        // уставим свою длительность анимации
        set.setDuration(3000);
        // и изменим Interpolator
        set.setInterpolator(new AccelerateInterpolator());
        TransitionManager.go(scene2, set);
    }
}
