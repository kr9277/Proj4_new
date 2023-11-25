package com.example.proj4_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
/** @author Created by karin on 21/11/2023.
 * @version 0.0
 * @since 25/11/2023
 *This Activity contains of two text views, and a button which sends you back to the main Activity.
 */

public class Credits_Activity extends AppCompatActivity {
    TextView tv1, tv2;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv1);
        btn2 = findViewById(R.id.btn2);
    }
    /**
     * go_main method
     * <p> Reacting the button
     * </p>
     *
     * @param view the view that triggered the method
     * The method sends the intent to the main activity
     */
    public void go_main(View view){
        Intent si = new Intent(Credits_Activity.this, MainActivity.class);
        startActivity(si);
    }
}