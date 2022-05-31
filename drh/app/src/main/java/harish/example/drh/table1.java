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

public class table1 extends AppCompatActivity {
    TextView element1_quantity, element1_cost, element2_quantity, element2_cost, element3_quantity, element3_cost, total_cost;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table1);

        element1_quantity = (TextView)findViewById(R.id.t1_element1_quantity);
        element1_cost = (TextView)findViewById(R.id.t1_element1_cost);
        element2_quantity = (TextView)findViewById(R.id.t1_element2_quantity);
        element2_cost = (TextView)findViewById(R.id.t1_element2_cost);
        element3_quantity = (TextView)findViewById(R.id.t1_element3_quantity);
        element3_cost = (TextView)findViewById(R.id.t1_element3_cost);
        total_cost = (TextView)findViewById(R.id.total_cost);




                reff = FirebaseDatabase.getInstance().getReference().child("Member").child("1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        String quantity = snapshot.child("edit_text_quantity").getValue().toString(); //Retrieving value from firebase db
                        Double quantity_double = Double.parseDouble(quantity); //Converting value into double for calculation purposes

                        /* Multiplying quantity values with respective ratios and then converting them back to string */
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



                        /* Multiplying cost values with respective ratios and then converting them back to string */
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


                        String sum_cost = Double.toString(Double.parseDouble(element1_cost.getText().toString()) + Double.parseDouble(element2_cost.getText().toString()) + Double.parseDouble(element3_cost.getText().toString()));
                        total_cost.setText(sum_cost);





                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


    }
}