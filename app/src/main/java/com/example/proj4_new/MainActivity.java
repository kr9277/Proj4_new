package com.example.proj4_new;
/** @author Created by karin on 29/9/2023.
 * @version 0.0
 * @since 29/9/2023
 *The application is getting from the user the type of the series, the first term and the difference of the series and transfers this information to the next screen
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et1, et2, et3;
    String type = "";
    double first;
    double d = 0.0;
    Boolean bool1=false;
    Boolean bool2=false;
    Boolean bool3=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
    }
    /**
     * This function will be called when the user will press the button
     * It checks if all the parameters are normal and if so calls the next function "go"
     */
    public void next(View view) {
        if((et1.getText().toString().equals("")==false) && (et2.getText().toString().equals("")==false) && (et2.getText().toString().equals("")==false)){
            type = et1.getText().toString();
            first = Double.parseDouble(et2.getText().toString());
            d = Double.parseDouble(et3.getText().toString());
            if(type.equals("Invoicing")==true || type.equals("Engineering")==true){
                bool1 = true;
            }
            else{
                Toast.makeText(this, "you need to choose between Invoicing or Engineering", Toast.LENGTH_SHORT).show();
                type = et1.getText().toString();
            }
            if(first>-1000000.0 && first<1000000.0){
                bool2=true;
            }
            else{
                Toast.makeText(this, "you need to choose a number between -1000000 to 1000000", Toast.LENGTH_SHORT).show();
                first = Double.parseDouble(et2.getText().toString());
            }
            if(d>-1000000.0 && d<1000000.0){
                bool3=true;
            }
            else{
                Toast.makeText(this, "you need to choose a number between -1000000 to 1000000", Toast.LENGTH_SHORT).show();
                d = Double.parseDouble(et3.getText().toString());
            }
            if(bool1 && bool2 && bool3){
                go();
            }
        }
        else{
            Toast.makeText(this, "you did not enter everything requested", Toast.LENGTH_SHORT).show();
        }

    }
    /**
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