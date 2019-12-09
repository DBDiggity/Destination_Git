package com.ama.tourism_svg.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ama.tourism_svg.R;

public class MapFrag extends Fragment {


    public MapFrag(){}

    public static MapFrag newInstance(){
        MapFrag mapFrag = new MapFrag();
        Bundle args = new Bundle();
        mapFrag.setArguments(args);
        return mapFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.frag_map, container, false);

        return itemView;
    }

}

