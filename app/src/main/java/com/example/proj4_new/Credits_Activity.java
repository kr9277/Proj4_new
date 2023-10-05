package com.example.proj4_new;
/** @author Created by karin on 29/9/2023.
 * @version 0.0
 * @since 29/9/2023
 *The application Shows the first 20 members in the series and when you long press on one of the members the context menu appears
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Credits_Activity extends AppCompatActivity {
    TextView tv;
    ListView lv;
    Intent gi;
    String kind;
    double a1;
    double delta;
    double[] arr = new double[20];
    String[] arr_string = new String[20];
    double eser = 0;
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        tv = findViewById(R.id.tv);
        lv = (ListView) findViewById(R.id.lv);
        gi = getIntent();
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        kind = gi.getStringExtra("Type");
        a1 = gi.getDoubleExtra("First", 0.0);
        delta = gi.getDoubleExtra("delta", 0.0);
        arr[0]=a1;
        arr_string[0]= String.valueOf(a1);
        if(kind.equals("Invoicing")){
            for(int i=1;i<20;i++){
                arr[i]=arr[i-1]+delta;
                arr_string[i]= String.valueOf(arr[i]);
            }
        }
        else{
            for(int i=1;i<20;i++){
                arr[i]=arr[i-1]*delta;
                arr_string[i]=String.valueOf(arr[i]);
            }
        }
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr_string);
        lv.setAdapter(adp);
        lv.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) Credits_Activity.this);
        lv.setOnCreateContextMenuListener(Credits_Activity.this);
    }
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        n = position + 1;
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose one of the options below:");
        menu.add("the place of the choosen term");
        menu.add("the sum between the choosen term to the last term");
    }
}