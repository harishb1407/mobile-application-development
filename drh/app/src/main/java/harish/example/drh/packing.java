package harish.example.drh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class packing extends AppCompatActivity {

    EditText to_pack, name_pack, packnumber_pack, quantity_pack;
    Spinner spin1_pack, spin2_pack;
    Button confirm_pack, fill_lots_pack;
    DatabaseReference reff_pack;
    Intent lot_page;
    Pack pack;


    public static String productname_pack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packing);

        to_pack = (EditText)findViewById(R.id.to_pack);
        name_pack = (EditText)findViewById(R.id.name_pack);
        packnumber_pack = (EditText)findViewById(R.id.packnumber_pack);
        quantity_pack = (EditText)findViewById(R.id.quantity_pack);
        spin1_pack = (Spinner)findViewById(R.id.spin1_pack);
        confirm_pack = (Button)findViewById(R.id.confirm_pack);
        fill_lots_pack = (Button)findViewById(R.id.add_lot_pack);
        spin2_pack = (Spinner)findViewById(R.id.spin2_pack);
        spin2_pack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("1")){
                    lot_page = new Intent (packing.this, lot1.class);
                }
                if (parent.getItemAtPosition(position).equals("2")){
                    lot_page = new Intent (packing.this, lot2.class);
                }
                if (parent.getItemAtPosition(position).equals("3")){
                    lot_page = new Intent (packing.this, lot3.class);
                }
                if (parent.getItemAtPosition(position).equals("4")){
                    lot_page = new Intent (packing.this, lot4.class);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        fill_lots_pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(lot_page);
            }
        });



        spin1_pack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                productname_pack = spin1_pack.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        pack = new Pack();
        reff_pack = FirebaseDatabase.getInstance().getReference().child("Pack");

        confirm_pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int edit_text_packnumber_pack = Integer.parseInt(packnumber_pack.getText().toString().trim());
               float edit_text_quantity_pack = Float.parseFloat(quantity_pack.getText().toString().trim());

                pack.setEdit_text_to_pack(to_pack.getText().toString().trim());
                pack.setEdit_text_name_pack(name_pack.getText().toString().trim());
                pack.setProductname_pack(productname_pack);
                pack.setEdit_text_packnumber_pack(edit_text_packnumber_pack);
                pack.setEdit_text_quantity_pack(edit_text_quantity_pack);


                reff_pack.child("packing content").setValue(pack);
                Toast.makeText( packing.this, "Values confirmed", Toast.LENGTH_LONG).show();
            }
        });



    }

}