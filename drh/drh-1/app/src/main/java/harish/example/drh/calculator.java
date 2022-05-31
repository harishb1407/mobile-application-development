package harish.example.drh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.AdapterView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class calculator extends AppCompatActivity {

    EditText quantity;
    Button confirm_quantity;
    Button goto_table;
    Intent intent_product;


    DatabaseReference reff;
    Member member;
    Spinner product_spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        product_spin = (Spinner)findViewById(R.id.product_spin);
        product_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Product1")){
                     intent_product = new Intent (calculator.this, table1.class);
                }
                if (parent.getItemAtPosition(position).equals("Product2")){
                     intent_product = new Intent (calculator.this, table2.class);
                }
                if (parent.getItemAtPosition(position).equals("Product3")){
                    intent_product = new Intent (calculator.this, table3.class);
                }
                if (parent.getItemAtPosition(position).equals("Product4")){
                    intent_product = new Intent (calculator.this, table4.class);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        goto_table = (Button)findViewById(R.id.goto_table);
        goto_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_product);
            }
        });



        quantity = (EditText)findViewById(R.id.edit_order_quantity);
        confirm_quantity = (Button)findViewById(R.id.confirm_quantity);
        member =  new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        confirm_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float edit_text_quantity = Float.parseFloat(quantity.getText().toString().trim());

                member.setEdit_text_quantity(edit_text_quantity);

                reff.child("1").setValue(member);
                Toast.makeText( calculator.this, "Quantity confirmed", Toast.LENGTH_LONG).show();
            }
        });
    }
}