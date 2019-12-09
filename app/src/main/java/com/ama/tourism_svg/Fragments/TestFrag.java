package com.ama.tourism_svg.Fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.ama.tourism_svg.R;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestFrag extends Fragment {

    @BindView(R.id.mainToolbar)
    NavigationTabStrip navStrip;

    Context context;

    public TestFrag(){}

    public static TestFrag newInstance(){
        TestFrag testFrag = new TestFrag();
        Bundle args = new Bundle();
        testFrag.setArguments(args);
        return testFrag;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.frag_test, container, false);
        ButterKnife.bind(this, itemView);

        context = itemView.getContext();

        Typeface roboto = ResourcesCompat.getFont(context, R.font.roboto_italic);
        navStrip.setTypeface(roboto);
        navStrip.setElevation(3f);

        //TODO Idea#2: Have featured attractions that can show directions by the simple click of a button

        return itemView;
    }
}
