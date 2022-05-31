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

public class lot2_cert extends AppCompatActivity {

    EditText lot_cert, purity_cert, appearance_cert_spec, purity_cert_spec, tlc_cert_spec;
    EditText lot_cert_2, purity_cert_2;
    Spinner spin2_cert, spin3_cert;
    Spinner spin2_cert_2, spin3_cert_2;
    Button confirm_cert, view_cert;
    TwoLot_cert twoLot_cert;
    DatabaseReference reff_2lot_cert;
    Intent view_lot2_cert;

    public static String appearance_cert, tlc_cert, appearance_cert_2, tlc_cert_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot2_cert);

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

        confirm_cert = (Button)findViewById(R.id.confirm_cert);
        view_cert = (Button)findViewById(R.id.view_cert);

        view_lot2_cert = new Intent(lot2_cert.this, viewlot2_cert.class);

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

        twoLot_cert = new TwoLot_cert();
        reff_2lot_cert = FirebaseDatabase.getInstance().getReference().child("TwoLot cert");

        confirm_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float edit_text_lot_cert = Float.parseFloat(lot_cert.getText().toString().trim());
                float edit_text_purity_cert = Float.parseFloat(purity_cert.getText().toString().trim());
                float edit_text_lot_cert_2 = Float.parseFloat(lot_cert_2.getText().toString().trim());
                float edit_text_purity_cert_2 = Float.parseFloat(purity_cert_2.getText().toString().trim());

                twoLot_cert.setEdit_text_lot_cert(edit_text_lot_cert);
                twoLot_cert.setEdit_text_purity_cert(edit_text_purity_cert);
                twoLot_cert.setEdit_text_lot_cert_2(edit_text_lot_cert_2);
                twoLot_cert.setEdit_text_purity_cert_2(edit_text_purity_cert_2);

                twoLot_cert.setEdit_text_appearance_cert_spec(appearance_cert_spec.getText().toString().trim());
                twoLot_cert.setEdit_text_purity_cert_spec(purity_cert_spec.getText().toString().trim());
                twoLot_cert.setEdit_text_tlc_cert_spec(tlc_cert_spec.getText().toString());

                twoLot_cert.setAppearance_cert(appearance_cert);
                twoLot_cert.setTlc_cert(tlc_cert);
                twoLot_cert.setAppearance_cert_2(appearance_cert_2);
                twoLot_cert.setTlc_cert_2(tlc_cert_2);

                reff_2lot_cert.child("two lots dropdown cert").setValue(twoLot_cert);
                Toast.makeText( lot2_cert.this, "Lot values confirmed", Toast.LENGTH_LONG).show();


            }
        });

        view_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(view_lot2_cert);
            }
        });

    }
}