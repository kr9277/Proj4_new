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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Show_Activity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, View.OnCreateContextMenuListener {
    TextView tv;
    ListView lv;
    Intent gi; // This parameter is of intent type and it receives the intent that is assigned from the first activity
    String kind; // This parameter refers to the type of the series
    double a1; // This parameter refers to the first term of the series
    double delta; // This parameter refers to the difference of the series
    double[] arr = new double[20];
    String[] arr_string = new String[20];
    double sum = 0;
    String chosen;
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
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
        lv.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) Show_Activity.this);
        lv.setOnCreateContextMenuListener(Show_Activity.this);
    }
    /**
     * The operation accepts as a variable parameter an AdapterView, View, the position of the term and the id of the choosen term
     * The action changes the value of n according to the the term's possiont and add one because it starts in zero, and returns false
     */
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        n = position + 1;
        return false;
    }
    /**
     * The operation accepts as a variable parameter a menu item type selected by the user
     * The function calculates and shows the sum between the first term and the choosen term or shows the possition ot the term according to the selected option
     */
    public boolean onContextItemSelected(MenuItem item){
        chosen = item.getTitle().toString();
        if(chosen.equals("the place of the choosen term")){
            tv.setText("The place is: " + n);
        }
        else{
            if(kind.equals("Invoicing")){
                sum = (n * (2*a1 + delta*(n-1)))/2;
            }
            else{
                sum = a1 * (Math.pow(delta, n)-1)/(delta-1);
            }
            tv.setText("The sum is: " + sum);
        }
        return super.onContextItemSelected(item);
    }
    @Override
    /**
     * The function accepts a parameters of type menu, view and ContextMenuInfo
     * The function sets a title to the menu and two choices
     */
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose one of the options below:");
        menu.add("the place of the choosen term");
        menu.add("sum from the firs term to this:");
    }
}