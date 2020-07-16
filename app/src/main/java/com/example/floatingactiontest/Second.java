package com.example.floatingactiontest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Second extends AppCompatActivity {

    FloatingActionButton fbMain, fbOne, fbTwo, fbThree, fbFour;

    Float translationy = 100f;
    Float translationx = -100f;

    Boolean isMenuOpen = false;

    OvershootInterpolator interpolator = new OvershootInterpolator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fbMain = findViewById(R.id.fbMain);
        fbOne = findViewById(R.id.fbOne);
        fbTwo = findViewById(R.id.fbTwo);
        fbThree = findViewById(R.id.fbThree);
        fbFour = findViewById(R.id.fbFour);


        fbOne.setTranslationX(translationy);
        fbTwo.setTranslationX(translationy);
        fbThree.setTranslationX(translationx);
        fbFour.setTranslationX(translationx);
    }

    private void openMenu() {

        isMenuOpen = !isMenuOpen;

        fbOne.setVisibility(View.VISIBLE);
        fbTwo.setVisibility(View.VISIBLE);
        fbThree.setVisibility(View.VISIBLE);
        fbFour.setVisibility(View.VISIBLE);

        fbMain.animate().setInterpolator(interpolator).rotation(45f).setDuration(500).start();

        fbOne.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(500).start();
        fbTwo.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(500).start();
        fbThree.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(500).start();
        fbFour.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(500).start();


    }

    private void closeMenu() {
        isMenuOpen = !isMenuOpen;


        fbMain.animate().setInterpolator(interpolator).rotation(0f).setDuration(500).start();

        fbOne.animate().translationX(translationy).alpha(0f).setInterpolator(interpolator).setDuration(500).start();
        fbTwo.animate().translationX(translationy).alpha(0f).setInterpolator(interpolator).setDuration(500).start();
        fbThree.animate().translationX(translationx).alpha(0f).setInterpolator(interpolator).setDuration(500).start();
        fbFour.animate().translationX(translationx).alpha(0f).setInterpolator(interpolator).setDuration(500).start();

        fbMain.postDelayed(new Runnable() {
            @Override
            public void run() {

                fbOne.setVisibility(View.INVISIBLE);
                fbTwo.setVisibility(View.INVISIBLE);
                fbThree.setVisibility(View.INVISIBLE);
                fbFour.setVisibility(View.INVISIBLE);
            }
        }, 600);


    }

    public void Clicking(View view) {

        // Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();

        switch (view.getId()) {
            case R.id.fbMain:
                Toast.makeText(this, "main", Toast.LENGTH_SHORT).show();

                if (isMenuOpen) {

                    closeMenu();


                } else {

                    openMenu();


                }

                break;
            case R.id.fbOne:

                Toast.makeText(this, "one", Toast.LENGTH_SHORT).show();

                if (isMenuOpen) {

                    closeMenu();

                } else {

                    openMenu();
                }
                break;
            case R.id.fbTwo:
                Toast.makeText(this, "two", Toast.LENGTH_SHORT).show();
                if (isMenuOpen) {

                    closeMenu();

                } else {

                    openMenu();
                }
                break;
            case R.id.fbThree:
                Toast.makeText(this, "three", Toast.LENGTH_SHORT).show();
                if (isMenuOpen) {

                    closeMenu();

                } else {

                    openMenu();
                }
                break;


            case R.id.fbFour:
                Toast.makeText(this, "founr", Toast.LENGTH_SHORT).show();
                if (isMenuOpen) {

                    closeMenu();

                } else {

                    openMenu();
                }
        }

    }


}
