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

public class lot6_cert extends AppCompatActivity {

    EditText lot_cert, purity_cert, appearance_cert_spec, purity_cert_spec, tlc_cert_spec, lot_cert_2, purity_cert_2;
    EditText lot_cert_3, purity_cert_3, lot_cert_4, purity_cert_4;
    EditText lot_cert_5, purity_cert_5, lot_cert_6, purity_cert_6;
    Spinner spin2_cert, spin3_cert, spin2_cert_2, spin3_cert_2, spin2_cert_3, spin3_cert_3, spin2_cert_4, spin3_cert_4, spin2_cert_5, spin3_cert_5, spin2_cert_6, spin3_cert_6;
    SixLot_cert sixLot_cert;
    DatabaseReference reff_6lot_cert;

    Button confirm_cert, view_cert;

    Intent view_lot6_cert;

    public static String appearance_cert, tlc_cert, appearance_cert_2, tlc_cert_2, appearance_cert_3, tlc_cert_3, appearance_cert_4, tlc_cert_4, appearance_cert_5, tlc_cert_5, appearance_cert_6, tlc_cert_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot6_cert);

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

        lot_cert_4 = (EditText)findViewById(R.id.lot_cert_4);
        purity_cert_4 = (EditText)findViewById(R.id.purity_cert_4);

        spin2_cert_4 = (Spinner)findViewById(R.id.spin2_cert_4);
        spin3_cert_4 = (Spinner)findViewById(R.id.spin3_cert_4);

        lot_cert_5 = (EditText)findViewById(R.id.lot_cert_5);
        purity_cert_5 = (EditText)findViewById(R.id.purity_cert_5);

        spin2_cert_5 = (Spinner)findViewById(R.id.spin2_cert_5);
        spin3_cert_5 = (Spinner)findViewById(R.id.spin3_cert_5);

        lot_cert_6 = (EditText)findViewById(R.id.lot_cert_6);
        purity_cert_6 = (EditText)findViewById(R.id.purity_cert_6);

        spin2_cert_6 = (Spinner)findViewById(R.id.spin2_cert_6);
        spin3_cert_6 = (Spinner)findViewById(R.id.spin3_cert_6);

        confirm_cert = (Button)findViewById(R.id.confirm_cert);
        view_cert = (Button)findViewById(R.id.view_cert);

        view_lot6_cert = new Intent(lot6_cert.this, viewlot6_cert.class);

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

        spin2_cert_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appearance_cert_4 = spin2_cert_4.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin3_cert_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tlc_cert_4 = spin3_cert_4.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin2_cert_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appearance_cert_5 = spin2_cert_5.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin3_cert_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tlc_cert_5 = spin3_cert_5.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin2_cert_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appearance_cert_6 = spin2_cert_6.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin3_cert_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tlc_cert_6 = spin3_cert_6.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sixLot_cert = new SixLot_cert();
        reff_6lot_cert = FirebaseDatabase.getInstance().getReference().child("SixLot cert");

        confirm_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float edit_text_lot_cert = Float.parseFloat(lot_cert.getText().toString().trim());
                float edit_text_purity_cert = Float.parseFloat(purity_cert.getText().toString().trim());
                float edit_text_lot_cert_2 = Float.parseFloat(lot_cert_2.getText().toString().trim());
                float edit_text_purity_cert_2 = Float.parseFloat(purity_cert_2.getText().toString().trim());
                float edit_text_lot_cert_3 = Float.parseFloat(lot_cert_3.getText().toString().trim());
                float edit_text_purity_cert_3 = Float.parseFloat(purity_cert_3.getText().toString().trim());
                float edit_text_lot_cert_4 = Float.parseFloat(lot_cert_4.getText().toString().trim());
                float edit_text_purity_cert_4 = Float.parseFloat(purity_cert_4.getText().toString().trim());
                float edit_text_lot_cert_5 = Float.parseFloat(lot_cert_5.getText().toString().trim());
                float edit_text_purity_cert_5 = Float.parseFloat(purity_cert_5.getText().toString().trim());
                float edit_text_lot_cert_6 = Float.parseFloat(lot_cert_6.getText().toString().trim());
                float edit_text_purity_cert_6 = Float.parseFloat(purity_cert_6.getText().toString().trim());

                sixLot_cert.setEdit_text_lot_cert(edit_text_lot_cert);
                sixLot_cert.setEdit_text_purity_cert(edit_text_purity_cert);
                sixLot_cert.setEdit_text_lot_cert_2(edit_text_lot_cert_2);
                sixLot_cert.setEdit_text_purity_cert_2(edit_text_purity_cert_2);
                sixLot_cert.setEdit_text_lot_cert_3(edit_text_lot_cert_3);
                sixLot_cert.setEdit_text_purity_cert_3(edit_text_purity_cert_3);
                sixLot_cert.setEdit_text_lot_cert_4(edit_text_lot_cert_4);
                sixLot_cert.setEdit_text_purity_cert_4(edit_text_purity_cert_4);
                sixLot_cert.setEdit_text_lot_cert_5(edit_text_lot_cert_5);
                sixLot_cert.setEdit_text_purity_cert_5(edit_text_purity_cert_5);
                sixLot_cert.setEdit_text_lot_cert_6(edit_text_lot_cert_6);
                sixLot_cert.setEdit_text_purity_cert_6(edit_text_purity_cert_6);

                sixLot_cert.setEdit_text_appearance_cert_spec(appearance_cert_spec.getText().toString().trim());
                sixLot_cert.setEdit_text_purity_cert_spec(purity_cert_spec.getText().toString().trim());
                sixLot_cert.setEdit_text_tlc_cert_spec(tlc_cert_spec.getText().toString());


                sixLot_cert.setAppearance_cert(appearance_cert);
                sixLot_cert.setTlc_cert(tlc_cert);
                sixLot_cert.setAppearance_cert_2(appearance_cert_2);
                sixLot_cert.setTlc_cert_2(tlc_cert_2);
                sixLot_cert.setAppearance_cert_3(appearance_cert_3);
                sixLot_cert.setTlc_cert_3(tlc_cert_3);
                sixLot_cert.setAppearance_cert_4(appearance_cert_4);
                sixLot_cert.setTlc_cert_4(tlc_cert_4);
                sixLot_cert.setAppearance_cert_5(appearance_cert_5);
                sixLot_cert.setTlc_cert_5(tlc_cert_5);
                sixLot_cert.setAppearance_cert_6(appearance_cert_6);
                sixLot_cert.setTlc_cert_6(tlc_cert_6);

                reff_6lot_cert.child("six lots dropdown cert").setValue(sixLot_cert);
                Toast.makeText( lot6_cert.this, "Lot values confirmed", Toast.LENGTH_LONG).show();

            }
        });

        view_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(view_lot6_cert);
            }
        });

    }
}