package in.bitcode.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    private TextView txtInfo;
    private EditText edtInfo;
    private Button btnSet, btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("onCreate called...");

        LinearLayout linearLayout = new LinearLayout( this );
        linearLayout.setOrientation( LinearLayout.VERTICAL );

        //Set up UI
        txtInfo = new TextView( this );
        txtInfo.setText("Hello Android!");
        txtInfo.setTextColor( Color.rgb( 255, 0, 0 ) );
        txtInfo.setTextSize( 40 );
        linearLayout.addView( txtInfo );

        edtInfo = new EditText( this );
        edtInfo.setHint("Enter some text");
        linearLayout.addView( edtInfo );

        btnSet = new Button( this );
        btnSet.setText("Set Info");
        linearLayout.addView( btnSet );


        btnNext = new Button( this );
        btnNext.setText("Next Activity");
        linearLayout.addView( btnNext );

        btnNext.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code to start ActNext
                Intent intent = new Intent( MainActivity.this, ActNew.class );
                startActivity( intent );
            }
        });

        //set up listener to button
        //separate listener
        btnSet.setOnClickListener( new BtnSetClickListener() );

        //set up listener to textView
        //separate listener
        //txtInfo.setOnClickListener( new TxtInfoClickListener() );
        txtInfo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtInfo.setText("");
            }
        });

        /*CommonClickListener commonClickListener = new CommonClickListener();
        btnSet.setOnClickListener( commonClickListener );
        txtInfo.setOnClickListener( commonClickListener );*/

        setContentView( linearLayout );
        //setContentView( txtInfo );
    }

    class CommonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if( view == btnSet ) {
                txtInfo.setText(edtInfo.getText() );
            }
            if( view == txtInfo ) {
                txtInfo.setText("");
            }

        }
    }


    class BtnSetClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txtInfo.setText( edtInfo.getText() );
        }
    }

    class TxtInfoClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txtInfo.setText("");
        }
    }
}