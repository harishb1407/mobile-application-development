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

public class lot1 extends AppCompatActivity {


    EditText lot_pack, bag_pack, nobag_pack, gross_pack, tare_pack, net_pack;
    Button confirm_pack, view_pack;
    Intent view_lot1;
    DatabaseReference reff_pack_1lot;
    OneLot oneLot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot1);

        lot_pack = (EditText)findViewById(R.id.lot_pack);
        bag_pack = (EditText)findViewById(R.id.bag_pack);
        nobag_pack = (EditText)findViewById(R.id.nobag_pack);
        gross_pack = (EditText)findViewById(R.id.gross_pack);
        tare_pack = (EditText)findViewById(R.id.tare_pack);
        net_pack = (EditText)findViewById(R.id.net_pack);
        confirm_pack = (Button) findViewById(R.id.confirm_pack);
        view_pack = (Button) findViewById(R.id.view_pack);

        oneLot = new OneLot();
        reff_pack_1lot = FirebaseDatabase.getInstance().getReference().child("OneLot");

        view_lot1 = new Intent(lot1.this, viewlot1.class);

        confirm_pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float edit_text_lot_pack = Float.parseFloat(lot_pack.getText().toString().trim());
                float edit_text_bag_pack = Float.parseFloat(bag_pack.getText().toString().trim());
                float edit_text_nobag_pack = Float.parseFloat(nobag_pack.getText().toString().trim());
                float edit_text_gross_pack = Float.parseFloat(gross_pack.getText().toString().trim());
                float edit_text_tare_pack = Float.parseFloat(tare_pack.getText().toString().trim());
                float edit_text_net_pack = Float.parseFloat(net_pack.getText().toString().trim());

                oneLot.setLot_pack(edit_text_lot_pack);
                oneLot.setBag_pack(edit_text_bag_pack);
                oneLot.setNobag_pack(edit_text_nobag_pack);
                oneLot.setGross_pack(edit_text_gross_pack);
                oneLot.setTare_pack(edit_text_tare_pack);
                oneLot.setNet_pack(edit_text_net_pack);

                reff_pack_1lot.child("one lot dropdown").setValue(oneLot);
                Toast.makeText( lot1.this, "Lot values confirmed", Toast.LENGTH_LONG).show();

            }
        });


        view_pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(view_lot1);
            }
        });




    }
}