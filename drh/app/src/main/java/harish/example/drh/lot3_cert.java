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

public class lot3_cert extends AppCompatActivity {

    EditText lot_cert, purity_cert, appearance_cert_spec, purity_cert_spec, tlc_cert_spec;
    EditText lot_cert_2, purity_cert_2;
    EditText lot_cert_3, purity_cert_3;
    Spinner spin2_cert, spin3_cert;
    Spinner spin2_cert_2, spin3_cert_2;
    Spinner spin2_cert_3, spin3_cert_3;
    ThreeLot_cert threeLot_cert;
    DatabaseReference reff_3lot_cert;

    Button confirm_cert, view_cert;

    Intent view_lot3_cert;

    public static String appearance_cert, tlc_cert, appearance_cert_2, tlc_cert_2, appearance_cert_3, tlc_cert_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot3_cert);

        lot_cert = (EditText)findViewById(R.id.lot_cert);
        purity_cert = (EditText)findViewById(R.id.purity_cert);
        appearance_cert_spec = (EditText)findViewById(R.id.appearance_cert_spec);
        purity_cert_spec = (EditText)findViewById(R.id.purity_cert_spec);
        tlc_cert_spec = (EditText)findViewById(R.id.tlc_cert_spec);
        spin2_cert = (Spinner)findViewById(R.id.spin2_cert);
        spin3_cert = (Spinner)findViewById(R.id.spin3_cert);

        lot_cert_2 = (EditText)findViewById(R.id.lot_cert_2);
        purity_cert_2 = (EditText)findViewById(R.id.purity_cert_2);

        spin2_cert_2 = (Spinner)findViewById(R.id.spin2_cert_2);
        spin3_cert_2 = (Spinner)findViewById(R.id.spin3_cert_2);

        lot_cert_3 = (EditText)findViewById(R.id.lot_cert_3);
        purity_cert_3 = (EditText)findViewById(R.id.purity_cert_3);

        spin2_cert_3 = (Spinner)findViewById(R.id.spin2_cert_3);
        spin3_cert_3 = (Spinner)findViewById(R.id.spin3_cert_3);

        confirm_cert = (Button)findViewById(R.id.confirm_cert);
        view_cert= (Button)findViewById(R.id.view_cert);

        view_lot3_cert = new Intent(lot3_cert.this, viewlot3_cert.class);

        spin2_cert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appearance_cert = spin2_cert.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin3_cert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tlc_cert = spin3_cert.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin2_cert_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appearance_cert_2 = spin2_cert_2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin3_cert_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tlc_cert_2 = spin3_cert_2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin2_cert_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appearance_cert_3 = spin2_cert_3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin3_cert_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tlc_cert_3 = spin3_cert_3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        threeLot_cert = new ThreeLot_cert();
        reff_3lot_cert = FirebaseDatabase.getInstance().getReference().child("ThreeLot cert");

        confirm_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float edit_text_lot_cert = Float.parseFloat(lot_cert.getText().toString().trim());
                float edit_text_purity_cert = Float.parseFloat(purity_cert.getText().toString().trim());
                float edit_text_lot_cert_2 = Float.parseFloat(lot_cert_2.getText().toString().trim());
                float edit_text_purity_cert_2 = Float.parseFloat(purity_cert_2.getText().toString().trim());
                float edit_text_lot_cert_3 = Float.parseFloat(lot_cert_3.getText().toString().trim());
                float edit_text_purity_cert_3 = Float.parseFloat(purity_cert_3.getText().toString().trim());

                threeLot_cert.setEdit_text_lot_cert(edit_text_lot_cert);
                threeLot_cert.setEdit_text_purity_cert(edit_text_purity_cert);
                threeLot_cert.setEdit_text_lot_cert_2(edit_text_lot_cert_2);
                threeLot_cert.setEdit_text_purity_cert_2(edit_text_purity_cert_2);
                threeLot_cert.setEdit_text_lot_cert_3(edit_text_lot_cert_3);
                threeLot_cert.setEdit_text_purity_cert_3(edit_text_purity_cert_3);

                threeLot_cert.setEdit_text_appearance_cert_spec(appearance_cert_spec.getText().toString().trim());
                threeLot_cert.setEdit_text_purity_cert_spec(purity_cert_spec.getText().toString().trim());
                threeLot_cert.setEdit_text_tlc_cert_spec(tlc_cert_spec.getText().toString());


                threeLot_cert.setAppearance_cert(appearance_cert);
                threeLot_cert.setTlc_cert(tlc_cert);
                threeLot_cert.setAppearance_cert_2(appearance_cert_2);
                threeLot_cert.setTlc_cert_2(tlc_cert_2);
                threeLot_cert.setAppearance_cert_3(appearance_cert_3);
                threeLot_cert.setTlc_cert_3(tlc_cert_3);

                reff_3lot_cert.child("three lots dropdown cert").setValue(threeLot_cert);
                Toast.makeText( lot3_cert.this, "Lot values confirmed", Toast.LENGTH_LONG).show();


            }
        });

        view_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(view_lot3_cert);
            }
        });


    }
}