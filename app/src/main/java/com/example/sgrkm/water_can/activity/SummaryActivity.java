package com.example.sgrkm.water_can.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.sgrkm.water_can.R;
import java.util.Calendar;


public class SummaryActivity extends AppCompatActivity {

    TextView quantity, location, price, date, slot;
    int cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Your Order");
        setContentView(R.layout.activity_summary);
        // linking the widgets to the layout //
        quantity = (TextView) findViewById(R.id.quantity);
        location = (TextView) findViewById(R.id.location);
        price = (TextView) findViewById(R.id.price);
        date = (TextView) findViewById(R.id.date);
        slot = (TextView) findViewById(R.id.timeSlot);

        // GETTING AND SETTING SYSTEM DATE //
        Calendar c = Calendar.getInstance();

        String sDate = c.get(Calendar.YEAR) + "-"
                + c.get(Calendar.MONTH)
                + "-" + c.get(Calendar.DAY_OF_MONTH)
                + " at " + c.get(Calendar.HOUR_OF_DAY)
                + ":" + c.get(Calendar.MINUTE);
        date.setText(sDate);

        // EXTRACTING THE BUNDLED INFORMATION //
        Bundle order_data = getIntent().getExtras();
        quantity.setText(order_data.getString("canCount"));
        location.setText(order_data.getString("location"));
        // GETTING AND SETTING PRICE //
        int canNo = Integer.parseInt(order_data.getString("canCount"));
        switch(canNo){
            case 2: cost= 60;
                break;
            case 3: cost = 90;
                break;
            case 4: cost = 120;
                break;
        }
        price.setText("RS. "+cost);

        // GETTING AND SETTING TIME //
        String slot_data = order_data.getString("Time");
        if(slot_data =="slot1"){
            slot.setText("10AM-1PM");
        }
        else{
            slot.setText("5PM-9PM");
        }
    }

//    void backClick(View v){
//        Intent i = new Intent(this, BookingActivity.class);
//        startActivity(i);
//    }
}
