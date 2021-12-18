package com.myapplication.API_manager;

import com.myapplication.Models.Character;
import com.myapplication.Models.Characters;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface API {
    String BASE_URL = "https://rickandmortyapi.com/api/";

    @GET("character")
    Call<Characters> getCharacters();

    @GET("character/{id}")
    Call<Character> getCharacter(@Path("id") String id);

}
