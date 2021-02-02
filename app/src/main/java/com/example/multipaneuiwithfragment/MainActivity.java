package com.example.multipaneuiwithfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AndroidVersionInterface {
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.fragment_container);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentDemo FragmentDemo = new FragmentDemo();
        fragmentTransaction.add(frameLayout.getId(), FragmentDemo);
        fragmentTransaction.commit();
    }

    @Override
    public void onVersionItemClick(String versionName) {
        Toast.makeText(getApplicationContext(), "" + versionName, Toast.LENGTH_SHORT).show();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("versionName",versionName);
        FragmentDetail fragmentDetail = new FragmentDetail();
        fragmentDetail.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_detail_container,fragmentDetail);
        fragmentTransaction.commit();
    }

}