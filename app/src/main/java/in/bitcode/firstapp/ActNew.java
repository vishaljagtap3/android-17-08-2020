package in.bitcode.firstapp;

import android.app.Activity;
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

        btnSet.setOnClickListener( new BtnSetClickListener() );


    }

    private class BtnSetClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            txtData.setText( edtData.getText() );

        }
    }
}
