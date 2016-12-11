package com.hangapps.herome.Activities;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hangapps.herome.Fragments.BackstoryFragment;
import com.hangapps.herome.Fragments.MainFragment;
import com.hangapps.herome.Fragments.PickPowerFragment;
import com.hangapps.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener, BackstoryFragment.BackstoryInteractionListener {

    public static final String ORIGIN_ACCIDENT = "accident";
    public static final String ORIGIN_MUTATION = "mutation";
    public static final String ORIGIN_BORN = "born";

    public static final String POWER_TURTLE = "turtle";
    public static final String POWER_LIGHTNING = "lightning";
    public static final String POWER_FLIGHT = "flight";
    public static final String POWER_WEB_SLINGING = "web slinging";
    public static final String POWER_LASER_VISION = "laser vision";
    public static final String POWER_SUPER_STRENGTH = "super strength";

    private String originSelected = "";
    private String powerSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        // if fragment does not exist let's create it
        if (fragment == null) {
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }


    }

    public void loadPickPowerScreen() {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }

    public void loadBackstoryScreen() {
        BackstoryFragment backstoryFragment = new BackstoryFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, backstoryFragment).addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackstoryInteraction(Uri uri) {

    }

    public String getOriginSelected() {
        return originSelected;
    }

    public void setOriginSelected(String originSelected) {
        this.originSelected = originSelected;
    }

    public String getPowerSeleceted() {
        return powerSelected;
    }

    public void setPowerSeleceted(String powerSeleceted) {
        this.powerSelected = powerSeleceted;
    }


}
