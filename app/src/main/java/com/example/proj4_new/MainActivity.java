package com.example.proj4_new;
/** @author Created by karin on 29/9/2023.
 * @version 0.0
 * @since 25/11/2023
 *The application is getting from the user the type of the series, the first term and the difference of the series and transfers this information to the next screen when the user presses the button
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et1, et_2, et_3;
    Switch sw;
    TextView tv_1, tv_2;
    String type = "";
    double first;
    double d = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        sw = findViewById(R.id.sw);
        et_2 = findViewById(R.id.et_2);
        et_3 = findViewById(R.id.et_3);
    }
    /**
     * This function will be called when the user will press the button
     * It checks if all the parameters are normal and if so, calls the next function "go"
     */
    public void next(View view) {
        if((et_3.getText().toString().equals("")==false) && (et_2.getText().toString().equals("")==false) && (et_3.getText().toString().equals("")==false)){
            if(sw.isChecked()==false){
                type = "Invoicing";
            }
            else{
                type = "Engineering";
            }
            first = Double.parseDouble(et_2.getText().toString());
            d = Double.parseDouble(et_3.getText().toString());
            go();
        }
        else{
            Toast.makeText(this, "you did not enter everything requested", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * go method
     * This function will be called after the user will press the button if all the inputs are  normal
     * It sends the intent with 3 needed parameters to the next activity
     */
    public void go(){
        Intent si = new Intent(MainActivity.this, Show_Activity.class);
        si.putExtra("Type", type);
        si.putExtra("First", first);
        si.putExtra("delta", d);
        startActivity(si);
    }
}