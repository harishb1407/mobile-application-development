package harish.example.drh;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class viewlot1 extends AppCompatActivity {


    private TextView to, name, pro, packno, quantity;
    private TextView r1, r2, r3, r4, r5, r6;
    private TextView s3, s4, s5, s6;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlot1);




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



        DatabaseReference ref_lot_content = FirebaseDatabase.getInstance().getReference().child("OneLot").child("one lot dropdown");
        ref_lot_content.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String lot_pack = snapshot.child("lot_pack").getValue().toString();
                r1.setText(lot_pack);
                String bag_pack = snapshot.child("bag_pack").getValue().toString();
                r2.setText(bag_pack);
                String nobag_pack = snapshot.child("nobag_pack").getValue().toString();
                r3.setText(nobag_pack);
                s3.setText(nobag_pack);
                String gross_pack = snapshot.child("gross_pack").getValue().toString();
                r4.setText(gross_pack);
                s4.setText(gross_pack);
                String tare_pack = snapshot.child("tare_pack").getValue().toString();
                r5.setText(tare_pack);
                s5.setText(tare_pack);
                String net_pack = snapshot.child("net_pack").getValue().toString();
                r6.setText(net_pack);
                s6.setText(net_pack);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

















    }
}
