package com.example.localisermonenfant;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Drawer
    private DrawerLayout drawerLayout;
   private NavigationView navigationView;
   private Toolbar toolbar;
private FirebaseAuth auth;
private Button map;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_acivity);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
    toolbar = findViewById(R.id.topAppBar);
navigationView.bringToFront();
navigationView.setNavigationItemSelectedListener(this);
toolbar.setNavigationOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START); });
        auth = FirebaseAuth.getInstance();
map = findViewById(R.id.button_map_home);
map.setOnClickListener(v->{
    Intent intent = new Intent(this , MapsActivity.class );
    startActivity(intent);
});
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);

        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homemenuItem:
                openHome();
                break;
            case R.id.appelmenuItem:
                openAppel();
                break;
            case R.id.meesagemenuItem:
                openMeassages();
                break;
            case R.id.parlemenuItem:
                openParler();
                break;
            case R.id.tracemenuItem:
                openTrace();
                break;
            case R.id.logoutmenuItem:
                logout();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }




    private void openHome() {
        Intent intent = new Intent(this , Home.class);
        startActivity(intent);
    }
    private void openAppel() {
        Intent intent = new Intent(this , AppelActivity.class);
        startActivity(intent);
    }

    private void openParler() {
        Intent intent = new Intent(this , ParlerActivity.class);
        startActivity(intent);
    }

    private void openMeassages() {
        Intent intent = new Intent(this , MessagesActivity.class);
        startActivity(intent);
    }
    private void openTrace() {
        Intent intent = new Intent(this , TraceActivity.class);
        startActivity(intent);
    }
    private void logout() {
        auth.signOut();
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);

    }


}

