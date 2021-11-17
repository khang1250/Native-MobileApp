package vn.edu.greenwich.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    private  Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        TextView tvPropName_cfm = findViewById(R.id.tvPropName_cfm);
        TextView tvPropAddress_cfm = findViewById(R.id.tvPropAddress_cfm);
        TextView tvPropType_cfm = findViewById(R.id.tvPropType_cfm);
        TextView tvBedrooms_cfm = findViewById(R.id.tvBedrooms_cfm);
        TextView tvDateAdd_cfm = findViewById(R.id.tvDateAdd_cfm);
        TextView tvPrice_cfm = findViewById(R.id.tvPrice_cfm);
        TextView tvFurType_cfm = findViewById(R.id.tvFurType_cfm);
        TextView tvNote_cfm = findViewById(R.id.tvNote_cfm);
        TextView tvRpName_cfm = findViewById(R.id.tvRpName_cfm);

        String PropName = "";
        String PropAddress = "";
        String PropType = "";
        String Bedrooms = "";
        String Date = "";
        String Price = "";
        String FurType = "";
        String Note = "";
        String RpName = "";

        Intent intent =  getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            PropName = bundle.getString("propname");
            PropAddress = bundle.getString("propaddress");
            PropType = bundle.getString("proptype");
            Bedrooms = bundle.getString("bedrooms");
            Date = bundle.getString("date");
            Price = bundle.getString("price");
            FurType = bundle.getString("furtype");
            Note = bundle.getString("note");
            RpName = bundle.getString("rpname");
        }

        tvPropName_cfm.setText(PropName);
        tvPropAddress_cfm.setText(PropAddress);
        tvPropType_cfm.setText(PropType);
        tvBedrooms_cfm.setText(Bedrooms);
        tvDateAdd_cfm.setText(Date);
        tvPrice_cfm.setText(Price);
        tvFurType_cfm.setText(FurType);
        tvNote_cfm.setText(Note);
        tvRpName_cfm.setText(RpName);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


}