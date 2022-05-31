package harish.example.drh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class viewlot4_cert extends AppCompatActivity {

    private TextView product, quantity;
    private TextView r02, r03, r04, r05, r2, r3, r4, r5, r6, r22, r32, r42, r52, r62, r23, r33, r43, r53, r63;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlot4_cert);

        product = (TextView)findViewById(R.id.product);
        quantity = (TextView)findViewById(R.id.quantity);

        r02 = (TextView)findViewById(R.id.r02);
        r03 = (TextView)findViewById(R.id.r03);
        r04 = (TextView)findViewById(R.id.r04);
        r05 = (TextView)findViewById(R.id.r05);
        r2 = (TextView)findViewById(R.id.r2);
        r3 = (TextView)findViewById(R.id.r3);
        r4 = (TextView)findViewById(R.id.r4);
        r5 = (TextView)findViewById(R.id.r5);
        r6 = (TextView)findViewById(R.id.r6);
        r22 = (TextView)findViewById(R.id.r22);
        r32 = (TextView)findViewById(R.id.r32);
        r42 = (TextView)findViewById(R.id.r42);
        r52 = (TextView)findViewById(R.id.r52);
        r62 = (TextView)findViewById(R.id.r62);
        r23 = (TextView)findViewById(R.id.r23);
        r33 = (TextView)findViewById(R.id.r33);
        r43 = (TextView)findViewById(R.id.r43);
        r53 = (TextView)findViewById(R.id.r53);
        r63 = (TextView)findViewById(R.id.r63);

        DatabaseReference ref_certificate_content = FirebaseDatabase.getInstance().getReference().child("Cert").child("certificate content");
        ref_certificate_content.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String edit_text_productname_cert = snapshot.child("productname_cert").getValue().toString();
                product.setText(edit_text_productname_cert);
                String edit_text_quantity_cert = snapshot.child("edit_text_quantity_cert").getValue().toString();
                quantity.setText(edit_text_quantity_cert);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference ref_lot_content_cert = FirebaseDatabase.getInstance().getReference().child("FourLot cert").child("four lots dropdown cert");
        ref_lot_content_cert.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String lot_cert = snapshot.child("edit_text_lot_cert").getValue().toString();
                r02.setText(lot_cert);
                String lot_cert_2 = snapshot.child("edit_text_lot_cert_2").getValue().toString();
                r03.setText(lot_cert_2);
                String lot_cert_3 = snapshot.child("edit_text_lot_cert_3").getValue().toString();
                r04.setText(lot_cert_3);
                String lot_cert_4 = snapshot.child("edit_text_lot_cert_4").getValue().toString();
                r05.setText(lot_cert_4);
                String appearance_cert = snapshot.child("appearance_cert").getValue().toString();
                r2.setText(appearance_cert);
                String appearance_cert_2 = snapshot.child("appearance_cert_2").getValue().toString();
                r3.setText(appearance_cert_2);
                String appearance_cert_3 = snapshot.child("appearance_cert_3").getValue().toString();
                r4.setText(appearance_cert_3);
                String appearance_cert_4 = snapshot.child("appearance_cert_4").getValue().toString();
                r5.setText(appearance_cert_4);
                String appearance_cert_spec = snapshot.child("edit_text_appearance_cert_spec").getValue().toString();
                r6.setText(appearance_cert_spec);
                String purity_cert = snapshot.child("edit_text_purity_cert").getValue().toString();
                r22.setText(purity_cert);
                String purity_cert_2 = snapshot.child("edit_text_purity_cert_2").getValue().toString();
                r32.setText(purity_cert_2);
                String purity_cert_3 = snapshot.child("edit_text_purity_cert_3").getValue().toString();
                r42.setText(purity_cert_3);
                String purity_cert_4 = snapshot.child("edit_text_purity_cert_4").getValue().toString();
                r52.setText(purity_cert_4);
                String purity_cert_spec = snapshot.child("edit_text_purity_cert_spec").getValue().toString();
                r62.setText(purity_cert_spec);
                String tlc_cert = snapshot.child("tlc_cert").getValue().toString();
                r23.setText(tlc_cert);
                String tlc_cert_2 = snapshot.child("tlc_cert_2").getValue().toString();
                r33.setText(tlc_cert_2);
                String tlc_cert_3 = snapshot.child("tlc_cert_3").getValue().toString();
                r43.setText(tlc_cert_3);
                String tlc_cert_4 = snapshot.child("tlc_cert_4").getValue().toString();
                r53.setText(tlc_cert_4);
                String tlc_cert_spec = snapshot.child("edit_text_tlc_cert_spec").getValue().toString();
                r63.setText(tlc_cert_spec);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}