package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.myapplication.API_manager.RetrofitClient;
import com.myapplication.Models.Character;
import com.myapplication.Models.Characters;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listCharacters;
    Characters myCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCharacters = findViewById(R.id.lstCharacter);
        getFromInternetCharacters();
        listCharacters.setOnItemClickListener(this);
    }

    private void getFromInternetCharacters(){
        Call<Characters> call = RetrofitClient.getInstance().getMyApi().getCharacters();
        call.enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                myCharacters = response.body();
                String message ="";
                CharacterAdapter adapter = new CharacterAdapter(MainActivity.this, myCharacters.getCharacterList());
                listCharacters.setAdapter(adapter);

            }
            @Override
            public void onFailure(Call<Characters> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in = new Intent(this , CharacterDetail.class);
        in.putExtra("id", myCharacters.getCharacterList().get(position).getIdCharacter() );
        startActivity(in);

    }
}