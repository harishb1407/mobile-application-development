package harish.example.drh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class lot2 extends AppCompatActivity {


    EditText lot_pack_1, bag_pack_1, nobag_pack_1, gross_pack_1, tare_pack_1, net_pack_1, lot_pack_2, bag_pack_2, nobag_pack_2, gross_pack_2, tare_pack_2, net_pack_2;
    Button confirm_pack, view_pack;
    Intent view_lot2;
    DatabaseReference reff_pack_2lot;
    TwoLot twoLot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot2);

        lot_pack_1 = (EditText)findViewById(R.id.lot_pack_1);
        bag_pack_1 = (EditText)findViewById(R.id.bag_pack_1);
        nobag_pack_1 = (EditText)findViewById(R.id.nobag_pack_1);
        gross_pack_1 = (EditText)findViewById(R.id.gross_pack_1);
        tare_pack_1 = (EditText)findViewById(R.id.tare_pack_1);
        net_pack_1 = (EditText)findViewById(R.id.net_pack_1);

        lot_pack_2 = (EditText)findViewById(R.id.lot_pack_2);
        bag_pack_2 = (EditText)findViewById(R.id.bag_pack_2);
        nobag_pack_2 = (EditText)findViewById(R.id.nobag_pack_2);
        gross_pack_2 = (EditText)findViewById(R.id.gross_pack_2);
        tare_pack_2 = (EditText)findViewById(R.id.tare_pack_2);
        net_pack_2 = (EditText)findViewById(R.id.net_pack_2);

        confirm_pack = (Button) findViewById(R.id.confirm_pack);
        view_pack = (Button) findViewById(R.id.view_pack);

        twoLot = new TwoLot();
        reff_pack_2lot = FirebaseDatabase.getInstance().getReference().child("TwoLot");

        view_lot2 = new Intent(lot2.this, viewlot2.class);

        confirm_pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float edit_text_lot_pack_1 = Float.parseFloat(lot_pack_1.getText().toString().trim());
                float edit_text_bag_pack_1 = Float.parseFloat(bag_pack_1.getText().toString().trim());
                float edit_text_nobag_pack_1 = Float.parseFloat(nobag_pack_1.getText().toString().trim());
                float edit_text_gross_pack_1 = Float.parseFloat(gross_pack_1.getText().toString().trim());
                float edit_text_tare_pack_1 = Float.parseFloat(tare_pack_1.getText().toString().trim());
                float edit_text_net_pack_1 = Float.parseFloat(net_pack_1.getText().toString().trim());

                float edit_text_lot_pack_2 = Float.parseFloat(lot_pack_2.getText().toString().trim());
                float edit_text_bag_pack_2 = Float.parseFloat(bag_pack_2.getText().toString().trim());
                float edit_text_nobag_pack_2 = Float.parseFloat(nobag_pack_2.getText().toString().trim());
                float edit_text_gross_pack_2 = Float.parseFloat(gross_pack_2.getText().toString().trim());
                float edit_text_tare_pack_2 = Float.parseFloat(tare_pack_2.getText().toString().trim());
                float edit_text_net_pack_2 = Float.parseFloat(net_pack_2.getText().toString().trim());

                twoLot.setLot_pack_1(edit_text_lot_pack_1);
                twoLot.setBag_pack_1(edit_text_bag_pack_1);
                twoLot.setNobag_pack_1(edit_text_nobag_pack_1);
                twoLot.setGross_pack_1(edit_text_gross_pack_1);
                twoLot.setTare_pack_1(edit_text_tare_pack_1);
                twoLot.setNet_pack_1(edit_text_net_pack_1);

                twoLot.setLot_pack_2(edit_text_lot_pack_2);
                twoLot.setBag_pack_2(edit_text_bag_pack_2);
                twoLot.setNobag_pack_2(edit_text_nobag_pack_2);
                twoLot.setGross_pack_2(edit_text_gross_pack_2);
                twoLot.setTare_pack_2(edit_text_tare_pack_2);
                twoLot.setNet_pack_2(edit_text_net_pack_2);







                reff_pack_2lot.child("two lots dropdown").setValue(twoLot);
                Toast.makeText( lot2.this, "Lot values confirmed", Toast.LENGTH_LONG).show();

            }
        });

        view_pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(view_lot2); }
        });



    }
}