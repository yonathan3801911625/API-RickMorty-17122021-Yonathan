package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myapplication.API_manager.RetrofitClient;
import com.myapplication.Models.Character;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterDetail extends AppCompatActivity {

    private String id;
    private TextView status;
    private TextView species;
    private TextView gender;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        Bundle in = getIntent().getExtras();
        id = in.getString("id");
        getCharacterById(id);
        status = findViewById(R.id.textViewSta);
        species = findViewById(R.id.textViewSpe);
        gender = findViewById(R.id.textViewGen);
        img = findViewById(R.id.imgViewChaDetail);
    }

    private void getCharacterById(String id ){
        Call<Character> call = RetrofitClient.getInstance().getMyApi().getCharacter(id);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                Character myCharacter = response.body();
                status.setText(myCharacter.getStatusCharacter());
                species.setText(myCharacter.getSpeciesCharacter());
                gender.setText(myCharacter.getGenderCharacter());
                Picasso.get().load(myCharacter.getImageCharacter()).into(img);
                Toast.makeText(getApplicationContext(), myCharacter.getNameCharacter(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}