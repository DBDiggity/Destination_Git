package com.ama.tourism_svg.Fragments.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ama.tourism_svg.R;

import java.util.GregorianCalendar;

public class HomeRestaurantsFrag extends Fragment {

    public HomeRestaurantsFrag(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.frag_home_restaurants, container, false);

        return itemView;
    }
}
