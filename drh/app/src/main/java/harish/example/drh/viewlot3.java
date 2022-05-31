package harish.example.drh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewlot3 extends AppCompatActivity {


    private TextView to, name, pro, packno, quantity;
    private TextView r1, r2, r3, r4, r5, r6, r12, r22, r32, r42, r52, r62, r13, r23, r33, r43, r53, r63;
    private TextView s3, s4, s5, s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlot3);

        to = (TextView)findViewById(R.id.to);
        name = (TextView)findViewById(R.id.name);
        pro = (TextView)findViewById(R.id.pro);
        packno = (TextView)findViewById(R.id.packno);
        quantity = (TextView)findViewById(R.id.quantity);

        r1 = (TextView)findViewById(R.id.r1);
        r2 = (TextView)findViewById(R.id.r2);
        r3 = (TextView)findViewById(R.id.r3);
        r4 = (TextView)findViewById(R.id.r4);
        r5 = (TextView)findViewById(R.id.r5);
        r6 = (TextView)findViewById(R.id.r6);
        r12 = (TextView)findViewById(R.id.r12);
        r22 = (TextView)findViewById(R.id.r22);
        r32 = (TextView)findViewById(R.id.r32);
        r42 = (TextView)findViewById(R.id.r42);
        r52 = (TextView)findViewById(R.id.r52);
        r62 = (TextView)findViewById(R.id.r62);
        r13 = (TextView)findViewById(R.id.r13);
        r23 = (TextView)findViewById(R.id.r23);
        r33 = (TextView)findViewById(R.id.r33);
        r43 = (TextView)findViewById(R.id.r43);
        r53 = (TextView)findViewById(R.id.r53);
        r63 = (TextView)findViewById(R.id.r63);

        s3 = (TextView)findViewById(R.id.s3);
        s4 = (TextView)findViewById(R.id.s4);
        s5 = (TextView)findViewById(R.id.s5);
        s6 = (TextView)findViewById(R.id.s6);


        DatabaseReference ref_packing_content = FirebaseDatabase.getInstance().getReference().child("Pack").child("packing content");
        ref_packing_content.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String edit_text_to_pack = snapshot.child("edit_text_to_pack").getValue().toString();
                to.setText(edit_text_to_pack);
                String edit_text_name_pack = snapshot.child("edit_text_name_pack").getValue().toString();
                name.setText(edit_text_name_pack);
                String productname_pack = snapshot.child("productname_pack").getValue().toString();
                pro.setText(productname_pack);
                String edit_text_packnumber_pack = snapshot.child("edit_text_packnumber_pack").getValue().toString();
                packno.setText(edit_text_packnumber_pack);
                String edit_text_quantity_pack = snapshot.child("edit_text_quantity_pack").getValue().toString();
                quantity.setText(edit_text_quantity_pack);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference ref_lot_content = FirebaseDatabase.getInstance().getReference().child("ThreeLot").child("three lots dropdown");
        ref_lot_content.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String lot_pack_1 = snapshot.child("lot_pack_1").getValue().toString();
                r1.setText(lot_pack_1);
                String bag_pack_1 = snapshot.child("bag_pack_1").getValue().toString();
                r2.setText(bag_pack_1);
                String nobag_pack_1 = snapshot.child("nobag_pack_1").getValue().toString();
                r3.setText(nobag_pack_1);
                String gross_pack_1 = snapshot.child("gross_pack_1").getValue().toString();
                r4.setText(gross_pack_1);
                String tare_pack_1 = snapshot.child("tare_pack_1").getValue().toString();
                r5.setText(tare_pack_1);
                String net_pack_1 = snapshot.child("net_pack_1").getValue().toString();
                r6.setText(net_pack_1);

                String lot_pack_2 = snapshot.child("lot_pack_2").getValue().toString();
                r12.setText(lot_pack_2);
                String bag_pack_2 = snapshot.child("bag_pack_2").getValue().toString();
                r22.setText(bag_pack_2);
                String nobag_pack_2 = snapshot.child("nobag_pack_2").getValue().toString();
                r32.setText(nobag_pack_2);
                String gross_pack_2 = snapshot.child("gross_pack_2").getValue().toString();
                r42.setText(gross_pack_2);
                String tare_pack_2 = snapshot.child("tare_pack_2").getValue().toString();
                r52.setText(tare_pack_2);
                String net_pack_2 = snapshot.child("net_pack_2").getValue().toString();
                r62.setText(net_pack_2);

                String lot_pack_3 = snapshot.child("lot_pack_3").getValue().toString();
                r13.setText(lot_pack_3);
                String bag_pack_3 = snapshot.child("bag_pack_3").getValue().toString();
                r23.setText(bag_pack_3);
                String nobag_pack_3 = snapshot.child("nobag_pack_3").getValue().toString();
                r33.setText(nobag_pack_3);
                String gross_pack_3 = snapshot.child("gross_pack_3").getValue().toString();
                r43.setText(gross_pack_3);
                String tare_pack_3 = snapshot.child("tare_pack_3").getValue().toString();
                r53.setText(tare_pack_3);
                String net_pack_3 = snapshot.child("net_pack_3").getValue().toString();
                r63.setText(net_pack_3);

                String sum_nobag_pack = Double.toString(Double.parseDouble(r3.getText().toString()) + Double.parseDouble(r32.getText().toString()) + Double.parseDouble(r33.getText().toString()));
                s3.setText(sum_nobag_pack);
                String sum_gross_pack = Double.toString(Double.parseDouble(r4.getText().toString()) + Double.parseDouble(r42.getText().toString()) + Double.parseDouble(r43.getText().toString()));
                s4.setText(sum_gross_pack);
                String sum_tare_pack = Double.toString(Double.parseDouble(r5.getText().toString()) + Double.parseDouble(r52.getText().toString()) + Double.parseDouble(r53.getText().toString()));
                s5.setText(sum_tare_pack);
                String sum_net_pack = Double.toString(Double.parseDouble(r6.getText().toString()) + Double.parseDouble(r62.getText().toString()) + Double.parseDouble(r63.getText().toString()));
                s6.setText(sum_net_pack);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}