package com.oaksoftstudio.ourpride;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class ShohidDescribe extends AppCompatActivity {

    TextView nameSetId,taglineSetId;
TextView ageId,varsityId,dobId,deathId,placeId,lifestyleId,describeId;
ImageView imgSetId;

    public static String IMAGE = "";

    public static String NAME = "";
    public static String CARRIER = "";

    public static String AGE = "";
    public static String VARSITY = "";
    public static String DEATH = "";
    public static String PLACE = "";
    public static String LIFESTYLE = "";
    public static String DESCRIBE = "";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shohid_describe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        getWindow().setStatusBarColor(Color.parseColor("#091A2A"));


        imgSetId = findViewById(R.id.imgSetId);

        nameSetId = findViewById(R.id.nameSetId);
        taglineSetId = findViewById(R.id.taglineSetId);

        ageId = findViewById(R.id.ageId);
        varsityId = findViewById(R.id.varsityId);
        deathId = findViewById(R.id.deathId);
        placeId = findViewById(R.id.placeId);
        lifestyleId = findViewById(R.id.lifestyleId);
        describeId = findViewById(R.id.describeId);


        // img set kora online link theke ==================================
        Picasso.get()
                .load(IMAGE)
                .into(imgSetId);

        nameSetId.setText(NAME);
        taglineSetId.setText(CARRIER);

        ageId.setText(AGE);
        varsityId.setText(VARSITY);
        deathId.setText(DEATH);
        placeId.setText(PLACE);
        lifestyleId.setText(LIFESTYLE);
        describeId.setText(DESCRIBE);



















    }//======
}//============