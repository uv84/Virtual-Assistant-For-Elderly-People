package com.example.vaep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vaep.recognition.FaceRec;
import com.google.firebase.auth.FirebaseAuth;

public class index extends AppCompatActivity {
    private Button remainder, signout, update,faceidentity,locate;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        sharedPreferences = getSharedPreferences("autoLogin", Context.MODE_PRIVATE);

        remainder=(Button) findViewById(R.id.rem);
        signout=(Button) findViewById(R.id.logout);
        update=(Button) findViewById(R.id.update);
        faceidentity=(Button) findViewById(R.id.faceid);
        locate=(Button) findViewById(R.id.locate);

        remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(index.this, remainder.class);
                startActivity(intent);


            }

        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("key", 0);
                editor.apply();

                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(index.this, signin.class);
                startActivity(intent);


            }

        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(index.this, familyInfo.class);
                startActivity(intent);


            }

        });

        faceidentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(index.this, FaceRec.class));

            }

        });

        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(index.this, MapsActivity.class);
                startActivity(intent);


            }

        });

    }
}