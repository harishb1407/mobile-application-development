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

public class lot4 extends AppCompatActivity {

    EditText lot_pack_1, bag_pack_1, nobag_pack_1, gross_pack_1, tare_pack_1, net_pack_1, lot_pack_2, bag_pack_2, nobag_pack_2, gross_pack_2, tare_pack_2, net_pack_2;
    EditText lot_pack_3, bag_pack_3, nobag_pack_3, gross_pack_3, tare_pack_3, net_pack_3, lot_pack_4, bag_pack_4, nobag_pack_4, gross_pack_4, tare_pack_4, net_pack_4;
    Button confirm_pack, view_pack;
    Intent view_lot4;
    DatabaseReference reff_pack_4lot;
    FourLot fourLot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot4);

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

        lot_pack_3 = (EditText)findViewById(R.id.lot_pack_3);
        bag_pack_3 = (EditText)findViewById(R.id.bag_pack_3);
        nobag_pack_3 = (EditText)findViewById(R.id.nobag_pack_3);
        gross_pack_3 = (EditText)findViewById(R.id.gross_pack_3);
        tare_pack_3 = (EditText)findViewById(R.id.tare_pack_3);
        net_pack_3 = (EditText)findViewById(R.id.net_pack_3);

        lot_pack_4 = (EditText)findViewById(R.id.lot_pack_4);
        bag_pack_4 = (EditText)findViewById(R.id.bag_pack_4);
        nobag_pack_4 = (EditText)findViewById(R.id.nobag_pack_4);
        gross_pack_4 = (EditText)findViewById(R.id.gross_pack_4);
        tare_pack_4 = (EditText)findViewById(R.id.tare_pack_4);
        net_pack_4 = (EditText)findViewById(R.id.net_pack_4);

        confirm_pack = (Button) findViewById(R.id.confirm_pack);
        view_pack = (Button) findViewById(R.id.view_pack);


        fourLot = new FourLot();
        reff_pack_4lot = FirebaseDatabase.getInstance().getReference().child("FourLot");

        view_lot4 = new Intent(lot4.this, viewlot4.class);

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

                float edit_text_lot_pack_3 = Float.parseFloat(lot_pack_3.getText().toString().trim());
                float edit_text_bag_pack_3 = Float.parseFloat(bag_pack_3.getText().toString().trim());
                float edit_text_nobag_pack_3 = Float.parseFloat(nobag_pack_3.getText().toString().trim());
                float edit_text_gross_pack_3 = Float.parseFloat(gross_pack_3.getText().toString().trim());
                float edit_text_tare_pack_3 = Float.parseFloat(tare_pack_3.getText().toString().trim());
                float edit_text_net_pack_3 = Float.parseFloat(net_pack_3.getText().toString().trim());

                float edit_text_lot_pack_4 = Float.parseFloat(lot_pack_4.getText().toString().trim());
                float edit_text_bag_pack_4 = Float.parseFloat(bag_pack_4.getText().toString().trim());
                float edit_text_nobag_pack_4 = Float.parseFloat(nobag_pack_4.getText().toString().trim());
                float edit_text_gross_pack_4 = Float.parseFloat(gross_pack_4.getText().toString().trim());
                float edit_text_tare_pack_4 = Float.parseFloat(tare_pack_4.getText().toString().trim());
                float edit_text_net_pack_4 = Float.parseFloat(net_pack_4.getText().toString().trim());

                fourLot.setLot_pack_1(edit_text_lot_pack_1);
                fourLot.setBag_pack_1(edit_text_bag_pack_1);
                fourLot.setNobag_pack_1(edit_text_nobag_pack_1);
                fourLot.setGross_pack_1(edit_text_gross_pack_1);
                fourLot.setTare_pack_1(edit_text_tare_pack_1);
                fourLot.setNet_pack_1(edit_text_net_pack_1);

                fourLot.setLot_pack_2(edit_text_lot_pack_2);
                fourLot.setBag_pack_2(edit_text_bag_pack_2);
                fourLot.setNobag_pack_2(edit_text_nobag_pack_2);
                fourLot.setGross_pack_2(edit_text_gross_pack_2);
                fourLot.setTare_pack_2(edit_text_tare_pack_2);
                fourLot.setNet_pack_2(edit_text_net_pack_2);

                fourLot.setLot_pack_3(edit_text_lot_pack_3);
                fourLot.setBag_pack_3(edit_text_bag_pack_3);
                fourLot.setNobag_pack_3(edit_text_nobag_pack_3);
                fourLot.setGross_pack_3(edit_text_gross_pack_3);
                fourLot.setTare_pack_3(edit_text_tare_pack_3);
                fourLot.setNet_pack_3(edit_text_net_pack_3);

                fourLot.setLot_pack_4(edit_text_lot_pack_4);
                fourLot.setBag_pack_4(edit_text_bag_pack_4);
                fourLot.setNobag_pack_4(edit_text_nobag_pack_4);
                fourLot.setGross_pack_4(edit_text_gross_pack_4);
                fourLot.setTare_pack_4(edit_text_tare_pack_4);
                fourLot.setNet_pack_4(edit_text_net_pack_4);







                reff_pack_4lot.child("four lots dropdown").setValue(fourLot);
                Toast.makeText( lot4.this, "Lot values confirmed", Toast.LENGTH_LONG).show();

            }
        });

        view_pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(view_lot4); }
        });
    }
}