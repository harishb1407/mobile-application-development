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

public class certificate extends AppCompatActivity {


    Spinner spin1_cert, spin4_cert;
    EditText quantity_cert;
    Button confirm_cert, add_lot_cert;
    DatabaseReference reff_cert;
    Intent lot_page_cert;
    Cert cert;

    public static String productname_cert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);

        spin1_cert = (Spinner)findViewById(R.id.spin1_cert);

        quantity_cert = (EditText)findViewById(R.id.quantity_cert);
        confirm_cert = (Button)findViewById(R.id.confirm_cert);
        add_lot_cert = (Button)findViewById(R.id.add_lot_cert);


        spin4_cert = (Spinner)findViewById(R.id.spin4_cert);

        spin4_cert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("1")){
                    lot_page_cert = new Intent (certificate.this, lot1_cert.class);
                }
                if (parent.getItemAtPosition(position).equals("2")){
                    lot_page_cert = new Intent (certificate.this, lot2_cert.class);
                }
                if (parent.getItemAtPosition(position).equals("3")){
                    lot_page_cert = new Intent (certificate.this, lot3_cert.class);
                }
                if (parent.getItemAtPosition(position).equals("4")){
                    lot_page_cert = new Intent (certificate.this, lot4_cert.class);
                }
                if (parent.getItemAtPosition(position).equals("5")){
                    lot_page_cert = new Intent (certificate.this, lot5_cert.class);
                }
                if (parent.getItemAtPosition(position).equals("6")){
                    lot_page_cert = new Intent (certificate.this, lot6_cert.class);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        add_lot_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(lot_page_cert);
            }
        });


        spin1_cert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                productname_cert = spin1_cert.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        cert = new Cert();
        reff_cert = FirebaseDatabase.getInstance().getReference().child("Cert");

        confirm_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float edit_text_quantity_cert = Float.parseFloat((quantity_cert.getText().toString().trim()));




                cert.setEdit_text_quantity_cert(edit_text_quantity_cert);


                cert.setProductname_cert(productname_cert);


                reff_cert.child("certificate content").setValue(cert);
                Toast.makeText( certificate.this, "Values confirmed", Toast.LENGTH_LONG).show();

            }
        });
    }
}