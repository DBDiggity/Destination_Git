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
import androidx.fragment.app.FragmentTransaction;

import com.ama.tourism_svg.Fragments.Home.HomeFrag;
import com.ama.tourism_svg.Fragments.Home.SeasideFrag;
import com.ama.tourism_svg.R;

import butterknife.ButterKnife;

public class MainFrag extends Fragment {

    private OnFragmentInteractionListener mListener;

    public MainFrag(){
    }

    public static MainFrag newInstance(){
        MainFrag mainFrag = new MainFrag();
        Bundle args = new Bundle();
        mainFrag.setArguments(args);
        return mainFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.frag_main, container, false);
        ButterKnife.bind(this, itemView);

        //TODO Idea#1: Have a viewpager that has different suggestions, such as, "Love the seaside? check out these hotels and attractions"

        return itemView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Fragment childFragment = SeasideFrag.newInstance();
        FragmentTransaction fm = getChildFragmentManager().beginTransaction();
        fm.replace(R.id.main_frag_viewpager, childFragment).commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void messageFromMainFragment(Uri uri);
    }
}
