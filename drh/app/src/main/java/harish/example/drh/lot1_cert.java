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

public class lot1_cert extends AppCompatActivity {

    EditText lot_cert, purity_cert, appearance_cert_spec, purity_cert_spec, tlc_cert_spec;
    Button confirm_cert, view_cert;
    Spinner spin2_cert, spin3_cert;
    Intent view_lot1_cert;
    OneLot_cert oneLot_cert;
    DatabaseReference reff_1lot_cert;

    public static String appearance_cert, tlc_cert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot1_cert);

        lot_cert = (EditText)findViewById(R.id.lot_cert);
        purity_cert = (EditText)findViewById(R.id.purity_cert);
        appearance_cert_spec = (EditText)findViewById(R.id.appearance_cert_spec);
        purity_cert_spec = (EditText)findViewById(R.id.purity_cert_spec);
        tlc_cert_spec = (EditText)findViewById(R.id.tlc_cert_spec);
        confirm_cert = (Button)findViewById(R.id.confirm_cert);
        view_cert = (Button)findViewById(R.id.view_cert);
        spin2_cert = (Spinner)findViewById(R.id.spin2_cert);
        spin3_cert = (Spinner)findViewById(R.id.spin3_cert);

        view_lot1_cert = new Intent(lot1_cert.this, viewlot1_cert.class);

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

        oneLot_cert = new OneLot_cert();
        reff_1lot_cert = FirebaseDatabase.getInstance().getReference().child("OneLot cert");

        confirm_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float edit_text_lot_cert = Float.parseFloat(lot_cert.getText().toString().trim());
                float edit_text_purity_cert = Float.parseFloat(purity_cert.getText().toString().trim());

                oneLot_cert.setEdit_text_lot_cert(edit_text_lot_cert);
                oneLot_cert.setEdit_text_purity_cert(edit_text_purity_cert);

                oneLot_cert.setEdit_text_appearance_cert_spec(appearance_cert_spec.getText().toString().trim());
                oneLot_cert.setEdit_text_purity_cert_spec(purity_cert_spec.getText().toString().trim());
                oneLot_cert.setEdit_text_tlc_cert_spec(tlc_cert_spec.getText().toString());

                oneLot_cert.setAppearance_cert(appearance_cert);
                oneLot_cert.setTlc_cert(tlc_cert);

                reff_1lot_cert.child("one lot dropdown cert").setValue(oneLot_cert);
                Toast.makeText( lot1_cert.this, "Lot values confirmed", Toast.LENGTH_LONG).show();

            }
        });

        view_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(view_lot1_cert);
            }
        });


    }
}