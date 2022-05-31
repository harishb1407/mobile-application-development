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

public class viewlot1_cert extends AppCompatActivity {

    private TextView product, quantity;
    private TextView r02, r2, r3, r22, r32, r23, r33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlot1_cert);

        product = (TextView)findViewById(R.id.product);
        quantity = (TextView)findViewById(R.id.quantity);

        r02 = (TextView)findViewById(R.id.r02);
        r2 = (TextView)findViewById(R.id.r2);
        r3 = (TextView)findViewById(R.id.r3);
        r22 = (TextView)findViewById(R.id.r22);
        r32 = (TextView)findViewById(R.id.r32);
        r23 = (TextView)findViewById(R.id.r23);
        r33 = (TextView)findViewById(R.id.r33);

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

        DatabaseReference ref_lot_content_cert = FirebaseDatabase.getInstance().getReference().child("OneLot cert").child("one lot dropdown cert");
        ref_lot_content_cert.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String lot_cert = snapshot.child("edit_text_lot_cert").getValue().toString();
                r02.setText(lot_cert);
                String appearance_cert = snapshot.child("appearance_cert").getValue().toString();
                r2.setText(appearance_cert);
                String appearance_cert_spec = snapshot.child("edit_text_appearance_cert_spec").getValue().toString();
                r3.setText(appearance_cert_spec);
                String purity_cert = snapshot.child("edit_text_purity_cert").getValue().toString();
                r22.setText(purity_cert);
                String purity_cert_spec = snapshot.child("edit_text_purity_cert_spec").getValue().toString();
                r32.setText(purity_cert_spec);
                String tlc_cert = snapshot.child("tlc_cert").getValue().toString();
                r23.setText(tlc_cert);
                String tlc_cert_spec = snapshot.child("edit_text_tlc_cert_spec").getValue().toString();
                r33.setText(tlc_cert_spec);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}