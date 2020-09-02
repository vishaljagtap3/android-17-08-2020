package in.bitcode.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ActNew extends Activity {

    private Button btnSet, btnSetAndFinish;
    private TextView txtData;
    private EditText edtData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.actnew_layout );

        //Obtain references to the View Objects
        txtData = findViewById( R.id.txtData);
        edtData = findViewById( R.id.edtData );
        btnSet = findViewById( R.id.btnSetData );
        btnSetAndFinish = findViewById( R.id.btnSetAndFinish);

        btnSet.setOnClickListener( new BtnSetClickListener() );

        //Get the data coming from MainActivity
        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name", "Not Found");
        int phone = bundle.getInt("phone", 900);

        txtData.setText( name + "\n" + phone );

        btnSetAndFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResults = new Intent();
                intentResults.putExtra("result", edtData.getText().toString() );

                setResult( 1, intentResults );
                finish();
            }
        });



    }

    private class BtnSetClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            txtData.setText( edtData.getText() );

        }
    }
}
