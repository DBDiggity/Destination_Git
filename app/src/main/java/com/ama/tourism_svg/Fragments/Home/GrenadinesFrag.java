package com.ama.tourism_svg.Fragments.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ama.tourism_svg.R;

public class GrenadinesFrag extends Fragment {

    public static GrenadinesFrag newInstance(){
        GrenadinesFrag  grenadinesFrag = new GrenadinesFrag();
        Bundle args = new Bundle();
        grenadinesFrag.setArguments(args);
        return grenadinesFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.frag_home_grenadines, container, false);

        return itemView;
    }
}
