package com.example.sgrkm.water_can.activity;

import com.example.sgrkm.water_can.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BookingActivity extends AppCompatActivity {

    TextView canCount;
    TextView price;
    Spinner location;
    RadioButton slot1, slot2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        // Populates the spinner with the location in which the service is available //
        Spinner list = (Spinner) findViewById(R.id.locationSpinner);
        ArrayAdapter<CharSequence> list_adapter = ArrayAdapter.createFromResource(this,R.array.location,android.R.layout.simple_spinner_item);
        list.setAdapter(list_adapter);
    }

    @Override
    public void onBackPressed() {

    }

    void increaseFunction(View v){
         price = (TextView) findViewById(R.id.price);
         canCount = (TextView) findViewById(R.id.canCount);
         int count = Integer.parseInt(canCount.getText().toString());
         int cost = Integer.parseInt(price.getText().toString());
         if(count!=4) {
             count++;
             cost=cost+30;
             canCount.setText(String.valueOf(count));
             price.setText(String.valueOf(cost));
         }
    }

    void decreaseFunction(View v){
        price = (TextView) findViewById(R.id.price);
        canCount = (TextView) findViewById(R.id.canCount);
        int count = Integer.parseInt(canCount.getText().toString());
        int cost = Integer.parseInt(price.getText().toString());
        if(count!=2){
            count--;
            cost=cost-30;
            canCount.setText(String.valueOf(count));
            price.setText(String.valueOf(cost));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater_menu = getMenuInflater();
        inflater_menu.inflate(R.menu.menu_booking,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if(res_id==R.id.orderSummary){
            slot1 = (RadioButton) findViewById(R.id.slot1);
            slot2 = (RadioButton) findViewById(R.id.slot2);
            if(slot1.isChecked()){
                Intent i = new Intent(BookingActivity.this, SummaryActivity.class);

                canCount = (TextView) findViewById(R.id.canCount);
                location = (Spinner) findViewById(R.id.locationSpinner);
                i.putExtra("canCount",canCount.getText().toString());
                i.putExtra("location",location.getSelectedItem().toString());
                i.putExtra("Time","slot1");
                startActivity(i);
            }
            else if(slot2.isChecked()){
                Intent i = new Intent(BookingActivity.this, SummaryActivity.class);

                canCount = (TextView) findViewById(R.id.canCount);
                location = (Spinner) findViewById(R.id.locationSpinner);
                i.putExtra("canCount",canCount.getText().toString());
                i.putExtra("location",location.getSelectedItem().toString());
                i.putExtra("Time","slot2");
                startActivity(i);

            }
            else{
                Toast.makeText(getApplicationContext(),"Time Slot Not Selected!!", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
