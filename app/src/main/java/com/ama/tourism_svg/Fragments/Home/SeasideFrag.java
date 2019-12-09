package com.ama.tourism_svg.Fragments.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ama.tourism_svg.Classes.StaticClasses;
import com.ama.tourism_svg.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeasideFrag extends Fragment {

    @BindView(R.id.seaside_image)
    ImageView seasideBackdrop;

//    @BindView(R.id.seaside_intro)
//    TextView introText;

    public SeasideFrag(){}

    public static SeasideFrag newInstance(){
        SeasideFrag seasideFrag = new SeasideFrag();
        Bundle args = new Bundle();
        seasideFrag.setArguments(args);
        return seasideFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.frag_home_seaside, container, false);
        ButterKnife.bind(this, itemView);

        Glide.with(itemView.getContext()).load("https://media.afar.com/uploads/images/post_images/images/WCQaX5enff/original_BR5I4549_Princess_Margaret_%281%29.jpg?1533582876").into(seasideBackdrop);
//        StaticClasses.justify(introText);


        return itemView;
    }
}
