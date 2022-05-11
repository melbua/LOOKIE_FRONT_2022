package com.example.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment.R;
import com.example.fragment.fragment1;
import com.example.fragment.fragment2;
import com.example.fragment.fragment3;
import com.example.fragment.fragment4;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager manager;
    FragmentTransaction ft;

    fragment1 fragmentOne;
    fragment2 fragmentTwo;
    fragment3 fragmentThree;
    fragment4 fragmentFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);

        fragmentOne = new fragment1();
        fragmentTwo = new fragment2();
        fragmentThree = new fragment3();
        fragmentFour = new fragment4();

        ft = manager.beginTransaction();
        ft.add(R.id.fragment_container, fragmentOne);
        ft.addToBackStack(null);
        ft.commit();

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ft = manager.beginTransaction();

        int id = v.getId();
        switch (id) {
            case R.id.one:
                ft.replace(R.id.fragment_container, fragmentOne);
                ft.commit();
                break;
            case R.id.two:
                ft.replace(R.id.fragment_container, fragmentTwo);
                ft.commit();
                break;
            case R.id.three:
                ft.replace(R.id.fragment_container, fragmentThree);
                ft.commit();
                break;
            case R.id.four:
                ft.replace(R.id.fragment_container, fragmentFour);
                ft.commit();
                break;
        }
    }
}

