package com.example.floatingactiontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fbMain, fbOne, fbTwo, fbThree;

    Float translationy = 100f;

    Boolean isMenuOpen = false;

    OvershootInterpolator interpolator = new OvershootInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbMain = findViewById(R.id.fabMain);
        fbOne = findViewById(R.id.fabOne);
        fbTwo = findViewById(R.id.fabTwo);
        fbThree = findViewById(R.id.fabThree);


        fbOne.setTranslationY(translationy);
        fbTwo.setTranslationY(translationy);
        fbThree.setTranslationY(translationy);

    }

    private void openMenu() {

        isMenuOpen = !isMenuOpen;

        fbOne.setVisibility(View.VISIBLE);
        fbTwo.setVisibility(View.VISIBLE);
        fbThree.setVisibility(View.VISIBLE);

        fbMain.animate().setInterpolator(interpolator).rotation(45f).setDuration(500).start();

        fbOne.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(500).start();
        fbTwo.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(500).start();
        fbThree.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(500).start();


    }

    private void closeMenu() {
        isMenuOpen = !isMenuOpen;

        fbMain.animate().setInterpolator(interpolator).rotation(0f).setDuration(500).start();

        fbOne.animate().translationY(translationy).alpha(0f).setInterpolator(interpolator).setDuration(500).start();
        fbTwo.animate().translationY(translationy).alpha(0f).setInterpolator(interpolator).setDuration(500).start();
        fbThree.animate().translationY(translationy).alpha(0f).setInterpolator(interpolator).setDuration(500).start();

        fbMain.postDelayed(new Runnable() {
            @Override
            public void run() {

                fbOne.setVisibility(View.INVISIBLE);
                fbTwo.setVisibility(View.INVISIBLE);
                fbThree.setVisibility(View.INVISIBLE);
            }
        }, 600);


    }

    public void Clicking(View view) {

        // Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();

        switch (view.getId()) {
            case R.id.fabMain:
                // Toast.makeText(this, "main", Toast.LENGTH_SHORT).show();

                if (isMenuOpen) {

                    closeMenu();

                } else {

                    openMenu();
                }

                break;
            case R.id.fabOne:

                Toast.makeText(this, "one", Toast.LENGTH_SHORT).show();

                if (isMenuOpen) {

                    closeMenu();

                } else {

                    openMenu();
                }
                break;
            case R.id.fabTwo:
                Toast.makeText(this, "two", Toast.LENGTH_SHORT).show();
                if (isMenuOpen) {

                    closeMenu();

                } else {

                    openMenu();
                }
                break;
            case R.id.fabThree:
                Toast.makeText(this, "three", Toast.LENGTH_SHORT).show();
                if (isMenuOpen) {

                    closeMenu();

                } else {

                    openMenu();
                }
                break;

        }

    }


}
