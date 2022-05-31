package harish.example.drh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    Button button1;
    TextView textView2;
    Button button2;
    TextView textView3;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(v -> startActivity(new Intent(this, calculator.class)));
        findViewById(R.id.button2).setOnClickListener(v -> startActivity(new Intent(this, packing.class)));
        findViewById(R.id.button3).setOnClickListener(v -> startActivity(new Intent(this, certificate.class)));

        Toast.makeText( MainActivity.this, "firebase connection success", Toast.LENGTH_LONG).show();
    }
}