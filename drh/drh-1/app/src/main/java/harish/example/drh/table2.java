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

    TextView element1_quantity, element1_cost, element2_quantity, element2_cost, element3_quantity, element3_cost;
    Button load_data;
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
        load_data = (Button)findViewById(R.id.t2_load_data);

        load_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("Member").child("1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        String quantity = snapshot.child("edit_text_quantity").getValue().toString(); //Retrieving value from firebase db
                        Double quantity_double = Double.parseDouble(quantity); //Converting value into double for calculation purposes

                        /* Multiplying value with respective ratios and then converting them back to string */
                        Double quantity_element1 = quantity_double*0.25;
                        String quantity_element1_string = Double.toString(quantity_element1);
                        Double quantity_element2 = quantity_double*0.25;
                        String quantity_element2_string = Double.toString(quantity_element2);
                        Double quantity_element3 = quantity_double*0.5;
                        String quantity_element3_string = Double.toString(quantity_element3);
                        /* Setting the text values as respective string values for element quantity */
                        element1_quantity.setText(quantity_element1_string);
                        element2_quantity.setText(quantity_element2_string);
                        element3_quantity.setText(quantity_element3_string);



                        /* Multiplying value with respective ratios and then converting them back to string */
                        Double cost_element1 = quantity_element1*10;
                        String cost_element1_string = Double.toString(cost_element1);
                        Double cost_element2 = quantity_element2*20;
                        String cost_element2_string = Double.toString(cost_element2);
                        Double cost_element3 = quantity_element3*30;
                        String cost_element3_string = Double.toString(cost_element3);
                        /* Setting the text values as respective string values for element cost */
                        element1_cost.setText(cost_element1_string);
                        element2_cost.setText(cost_element2_string);
                        element3_cost.setText(cost_element3_string);





                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}