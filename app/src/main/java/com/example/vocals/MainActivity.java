package com.example.vocals;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Toolbar nToolbar;
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private ChatFragment chatFragment;
    private ContactFragment contactFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // SplashTheme

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase
        mAuth = FirebaseAuth.getInstance();

        //toolbar
        nToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(nToolbar);
        getSupportActionBar().setTitle("VOCALS");

        //bottombar
        mMainFrame=(FrameLayout) findViewById(R.id.main_frame);
        mMainNav=(BottomNavigationView) findViewById(R.id.bottom_navigation);
        chatFragment= new ChatFragment();
        contactFragment=new ContactFragment();
        setFragment(chatFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_chat:
                        setFragment(chatFragment);
                        return true;

                    case R.id.nav_contact:
                        setFragment(contactFragment);
                        return true;

                    default:
                        return false;

                }

            }
        });

    }

    private void setFragment(Fragment fragment) {
        //switching fragment

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame, fragment)
                    .commit();


    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    if(currentUser == null){
      sendToStart();

    }
    }

    private void sendToStart() {
        Intent startIntent = new Intent(MainActivity.this,OnboardingScreen.class);
        startActivity(startIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.main_logout_btn){
            FirebaseAuth.getInstance().signOut();
            sendToStart();

        }
        if(item.getItemId()==R.id.account_settings){
            Intent settingsIntent= new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(settingsIntent);

        }
        return true;
    }
}
