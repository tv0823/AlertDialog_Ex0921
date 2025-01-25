package com.example.alertdialog_ex0921;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

/**
 * The type Main activity.
 *
 * @author      Tal Weintraub <tv0823@bs.amalnet.k12.il>
 * @version	    1
 * @since		13/1/2025
 * short description:
 *      Creates 5 results for 5 buttons and creates an alertDialog for each.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The Abd.
     */
    AlertDialog.Builder abd;

    /**
     * The Linear layout.
     */
    LinearLayout linearLayout;

    /**
     * The Rnd.
     */
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.LinearLayout);
        rnd = new Random();
    }

    /**
     * AlertDialog: Message only.
     *
     * @param view the view
     */
    public void messageOnly(View view) {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("P1");
        abd.setMessage("Simple message only");

        AlertDialog ad = abd.create();
        ad.show();
    }


    /**
     * AlertDialog: Message and icon.
     *
     * @param view the view
     */
    public void messageAndIcon(View view) {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("P2");
        abd.setMessage("Simple message and icon");
        abd.setIcon(R.drawable.minionsicon);

        AlertDialog ad = abd.create();
        ad.show();
    }

    /**
     * AlertDialog: Message, icon and one exit.
     *
     * @param view the view
     */
    public void messageAndIconAnd1Exit(View view) {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("P3");
        abd.setMessage("Simple message, icon and one exit");
        abd.setIcon(R.drawable.minionsicon);
        abd.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });

        AlertDialog ad = abd.create();
        ad.show();
    }

    /**
     * AlertDialog: Change background color.
     *
     * @param view the view
     */
    public void changeBgBtn(View view) {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("P4");
        abd.setMessage("Change background color");
        abd.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        abd.setNegativeButton("Random color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                linearLayout.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });

        AlertDialog ad = abd.create();
        ad.show();
    }

    /**
     * AlertDialog: Change bg color and back.
     *
     * @param view the view
     */
    public void changeBgColorAndBackBtn(View view) {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("P5");
        abd.setMessage("Change background color and back");
        abd.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        abd.setNegativeButton("Random color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                linearLayout.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        abd.setNeutralButton("white color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                linearLayout.setBackgroundColor(Color.WHITE);
            }
        });

        AlertDialog ad = abd.create();
        ad.show();
    }


    /**
     * Creates the options menu on screen
     *
     * @param menu the menu
     * @return ture
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Checks if the clicked menuItem is R.id.menuCred
     *
     * @param item a menuItem
     * @return ture
     */
    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menuCred) {
            Intent si = new Intent(this, CreditsActivity.class);
            startActivity(si);
        }

        return true;
    }
}