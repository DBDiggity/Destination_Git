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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ama.tourism_svg.Adapters.PictureTextAdapter;
import com.ama.tourism_svg.Classes.StaticClasses;
import com.ama.tourism_svg.Objects.PictureText;
import com.ama.tourism_svg.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeasideFrag extends Fragment {

    @BindView(R.id.seaside_image)
    ImageView seasideBackdrop;

    @BindView(R.id.seaside_rv_discover)
    RecyclerView discoverRV;

    private List<PictureText> discoverList;
    private PictureTextAdapter discoverAdapter;

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

        initRecyclers();

        return itemView;
    }

    private void initRecyclers(){
        discoverList = new ArrayList<>();

        discoverAdapter = new PictureTextAdapter(this.getContext(), discoverList);
        RecyclerView.LayoutManager discoverManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        discoverRV.setLayoutManager(discoverManager);
        discoverRV.setItemAnimator(new DefaultItemAnimator());
        discoverRV.setAdapter(discoverAdapter);

        prepareCards();
    }

    private void prepareCards(){

        List<String> picUrls = new ArrayList<>();
        picUrls.add("http://nationalparks.gov.vc/nationalparks/images/photos/Beach%202.jpg");
        picUrls.add("https://media.afar.com/uploads/images/post_images/images/Fpu6iSGlG1/original_Beach_006_HR_2.jpg?1533583393");
        picUrls.add("https://lp-cms-production.imgix.net/2019-06/eb3fc1839abde92160c24bf724052855-st-vincent-the-grenadines.jpg?fit=crop&q=40&sharp=10&vib=20&auto=format&ixlib=react-8.6.4");
        picUrls.add("https://i.ytimg.com/vi/sukKP9TjI4I/maxresdefault.jpg");
        picUrls.add("https://media.afar.com/uploads/images/post_images/images/31ksx1Swh2/original_PSVBeach.jpeg?1532494618");
        picUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFVODDoyLp0npa81ZrroRma3U-7dHx17JKRqp0ZoLwxEkXPS6O3Q&s");
        picUrls.add("https://www.caribbeanandco.com/wp-content/uploads/2019/07/View-of-Young-Island-from-St-Vincent.jpg");

        List<String> picNames = new ArrayList<>();
        picNames.add("Famous Overnight");
        picNames.add("Best Beaches");
        picNames.add("Lonely Planet");
        picNames.add("Villa Beach");
        picNames.add("Another One");
        picNames.add("Pristine");
        picNames.add("Young Island");

        for (int i=0;i<picNames.size();i++){
            PictureText a = new PictureText(picNames.get(i), picUrls.get(i));
            discoverList.add(a);
        }

        discoverAdapter.notifyDataSetChanged();
    }


}
