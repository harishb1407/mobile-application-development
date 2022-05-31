package harish.example.drh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class table2 extends AppCompatActivity {

    TextView element1_quantity, element1_cost, element2_quantity, element2_cost, element3_quantity, element3_cost, element4_quantity, element4_cost, element5_quantity, element5_cost, total_cost;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table2);

        element1_quantity = (TextView)findViewById(R.id.t2_element1_quantity);
        element1_cost = (TextView)findViewById(R.id.t2_element1_cost);
        element2_quantity = (TextView)findViewById(R.id.t2_element2_quantity);
        element2_cost = (TextView)findViewById(R.id.t2_element2_cost);
        element3_quantity = (TextView)findViewById(R.id.t2_element3_quantity);
        element3_cost = (TextView)findViewById(R.id.t2_element3_cost);
        element4_quantity = (TextView)findViewById(R.id.t2_element4_quantity);
        element4_cost = (TextView)findViewById(R.id.t2_element4_cost);
        element5_quantity = (TextView)findViewById(R.id.t2_element5_quantity);
        element5_cost = (TextView)findViewById(R.id.t2_element5_cost);

        total_cost = (TextView)findViewById(R.id.total_cost);



                reff = FirebaseDatabase.getInstance().getReference().child("Member").child("1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        String quantity = snapshot.child("edit_text_quantity").getValue().toString(); //Retrieving value from firebase db
                        Double quantity_double = Double.parseDouble(quantity); //Converting value into double for calculation purposes

                        /* Multiplying value with respective ratios and then converting them back to string */
                        Double quantity_element1 = quantity_double*0.3;
                        String quantity_element1_string = Double.toString(quantity_element1);
                        Double quantity_element2 = quantity_double*0.2;
                        String quantity_element2_string = Double.toString(quantity_element2);
                        Double quantity_element3 = quantity_double*0.1;
                        String quantity_element3_string = Double.toString(quantity_element3);
                        Double quantity_element4 = quantity_double*0.25;
                        String quantity_element4_string = Double.toString(quantity_element4);
                        Double quantity_element5 = quantity_double*0.25;
                        String quantity_element5_string = Double.toString(quantity_element5);
                        /* Setting the text values as respective string values for element quantity */
                        element1_quantity.setText(quantity_element1_string);
                        element2_quantity.setText(quantity_element2_string);
                        element3_quantity.setText(quantity_element3_string);
                        element4_quantity.setText(quantity_element4_string);
                        element5_quantity.setText(quantity_element5_string);



                        /* Multiplying value with respective ratios and then converting them back to string */
                        Double cost_element1 = quantity_element1*10;
                        String cost_element1_string = Double.toString(cost_element1);
                        Double cost_element2 = quantity_element2*20;
                        String cost_element2_string = Double.toString(cost_element2);
                        Double cost_element3 = quantity_element3*30;
                        String cost_element3_string = Double.toString(cost_element3);
                        Double cost_element4 = quantity_element3*10;
                        String cost_element4_string = Double.toString(cost_element4);
                        Double cost_element5 = quantity_element3*15;
                        String cost_element5_string = Double.toString(cost_element5);
                        /* Setting the text values as respective string values for element cost */
                        element1_cost.setText(cost_element1_string);
                        element2_cost.setText(cost_element2_string);
                        element3_cost.setText(cost_element3_string);
                        element4_cost.setText(cost_element4_string);
                        element5_cost.setText(cost_element5_string);

                        String sum_cost = Double.toString(Double.parseDouble(element1_cost.getText().toString()) + Double.parseDouble(element2_cost.getText().toString()) + Double.parseDouble(element3_cost.getText().toString()) + Double.parseDouble(element4_cost.getText().toString()) + Double.parseDouble(element5_cost.getText().toString()));
                        total_cost.setText(sum_cost);





                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }
}