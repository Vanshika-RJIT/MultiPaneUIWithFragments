package com.example.multipaneuiwithfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDemo extends Fragment {
    AndroidVersionInterface androidVersionInterface;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
           androidVersionInterface = (AndroidVersionInterface) context;
        }catch (ClassCastException e){
            Log.e("ClassCastException",e.getMessage());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout,container,false);
        String[] strings = {"Cupcake", "Donuts", "Eclairs", "Froyo", "GingerBread", "HoneyComb", "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, strings);
        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((parent, view1, position, id) -> {
           String versionName = ((TextView) view1).getText().toString();
            androidVersionInterface.onVersionItemClick(versionName);
        });

        return view;
    }
}
