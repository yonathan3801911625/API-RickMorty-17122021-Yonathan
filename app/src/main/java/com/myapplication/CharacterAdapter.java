package com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myapplication.Models.Character;

import java.util.List;

public class CharacterAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Character> myCharacters;

    public CharacterAdapter(Activity activity, List<Character> characterList){
        this.activity = activity;
        this.myCharacters = characterList;
    }

    @Override
    public int getCount() {
        return myCharacters.size();
    }

    @Override
    public Object getItem(int position) {
        return myCharacters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.character_item, null);
        }

        Character character = myCharacters.get(position);

        TextView nameCharacter = v.findViewById(R.id.txtViewNameChaItem);
        nameCharacter.setText(character.getNameCharacter());

        TextView idCharacter = v.findViewById(R.id.txtViewIdChaItem);
        idCharacter.setText(character.getIdCharacter());

        return v;
    }
}
