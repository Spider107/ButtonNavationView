package com.azm.buttonnavgationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private  HomeFragment homeFragment;
    private  CartFragment cartFragment;
    private  MusicFragment musicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFragment=new HomeFragment();
        cartFragment=new CartFragment();
        musicFragment=new MusicFragment();
        setOurFragment(homeFragment);
        bottomNavigationView=findViewById(R.id.buttombar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.home:
                        bottomNavigationView.setItemBackgroundResource(R.color.home);
                        setOurFragment(homeFragment);
                         return true;

                    case  R.id.cart:
                        bottomNavigationView.setItemBackgroundResource(R.color.cart);
                        setOurFragment(cartFragment);
                        return true;

                    case R.id.music:
                        bottomNavigationView.setItemBackgroundResource(R.color.music);
                        setOurFragment(musicFragment);
                        return true;

                        default:
                            return false;

                }


            }
        });
    }

    public void setOurFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();

    }
}
