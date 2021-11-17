package vn.edu.greenwich.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Link to the layout "activity_main.xml".
        setContentView(R.layout.activity_main);



        //Get the content of string "btn_login" in "string.xml"
        String btnLoginName = getResources().getString(R.string.btn_create);
        //Get the content of string "notification_01" in "string.xml"
        String notification_01 = getResources().getString(R.string.notification_01);


        //Like "alert" in JavaScript
        Toast.makeText(this, notification_01, Toast.LENGTH_LONG).show( );

        //get button from Layout curent Layout using id of button.
        Button btnCreate = findViewById(R.id.btnCreate);
        //Set the name of the button.
        btnCreate.setText(btnLoginName);
        //Add an event "Click" to the button.
        btnCreate.setOnClickListener(btnLogin_Click);
    }

    private View.OnClickListener btnLogin_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean isValid = true;
            TextView tvError = findViewById(R.id.tvError);
            TextView tvPropName = findViewById(R.id.tvPropName);
            TextView tvPropAddress = findViewById(R.id.tvPropAddress);
            TextView tvPropType = findViewById(R.id.tvPropType);
            TextView tvBedrooms = findViewById(R.id.tvBedrooms);
            TextView tvDateAdd = findViewById(R.id.tvDateAdd);
            TextView tvPrice = findViewById(R.id.tvPrice);
            TextView tvFurType = findViewById(R.id.tvFurType);
            TextView tvNote = findViewById(R.id.tvNote);
            TextView tvRpName = findViewById(R.id.tvRpName);

            String error = "";
            // Get content of textview "Property Name".
            String propname = tvPropName.getText().toString();
            // Get content of textview "Property Address".
            String propaddress = tvPropAddress.getText().toString();

            String proptype = tvPropType.getText().toString();

            String bedrooms = tvBedrooms.getText().toString();

            String date = tvDateAdd.getText().toString();

            String price = tvPrice.getText().toString();

            String furtype = tvFurType.getText().toString();

            String note = tvNote.getText().toString();

            String rpname = tvRpName.getText().toString();


            // Check whether property name is empty or not
            if (TextUtils.isEmpty((propname))) {
                isValid = false;
                error += "* Property's Name cannot be blank.\n";
            }

            // Check Wether password is empty or not
            if (TextUtils.isEmpty(propaddress)) {
                isValid = false;
                error += "*  Property's Address cannot be blank.\n";
            }

            if (TextUtils.isEmpty(proptype)) {
                isValid = false;
                error += "*  Property's Type cannot be blank.\n";
            }

            if (TextUtils.isEmpty(bedrooms)) {
                isValid = false;
                error += "*  Bedrooms cannot be blank.\n";
            }

            if (TextUtils.isEmpty(date)) {
                isValid = false;
                error += "*  Date cannot be blank.\n";
            }

            if (TextUtils.isEmpty(price)) {
                isValid = false;
                error += "*  Monthly Price cannot be blank.\n";
            }

            if (TextUtils.isEmpty(furtype)) {
                isValid = false;
                error += "*  Furniture's Type cannot be blank.\n";
            }

            if (TextUtils.isEmpty(rpname)) {
                isValid = false;
                error += "*  Reporter's Name cannot be blank.\n";
            }

            // Check wether form is valid or not.
            if (isValid) {
                Toast.makeText(v.getContext(), "Create Success", Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), propname, Toast.LENGTH_LONG).show();
                //Toast.makeText(v.getContext(), propaddress, Toast.LENGTH_LONG).show();
                //Toast.makeText(v.getContext(), proptype, Toast.LENGTH_LONG).show();
                //Toast.makeText(v.getContext(), bedrooms, Toast.LENGTH_LONG).show();
                //Toast.makeText(v.getContext(), date, Toast.LENGTH_LONG).show();
                //Toast.makeText(v.getContext(), price, Toast.LENGTH_LONG).show();
                //Toast.makeText(v.getContext(), furtype, Toast.LENGTH_LONG).show();
                //Toast.makeText(v.getContext(), rpname, Toast.LENGTH_LONG).show();

                Bundle propInfo = new Bundle();
                propInfo.putString("propname", propname);
                propInfo.putString("propaddress", propaddress);
                propInfo.putString("proptype", proptype);
                propInfo.putString("bedrooms", bedrooms);
                propInfo.putString("date", date);
                propInfo.putString("price", price);
                propInfo.putString("furtype", furtype);
                propInfo.putString("note", note);
                propInfo.putString("rpname", rpname);

                Intent testActivity = new Intent(v.getContext(), TestActivity.class);
                testActivity.putExtras(propInfo);
                startActivity(testActivity);
            }
            else {
                // Display error in textview.
                tvError.setText(error);

                // Display erropr in logs.
                Log.e("Main Activity", error);
            }
        }
    };
}