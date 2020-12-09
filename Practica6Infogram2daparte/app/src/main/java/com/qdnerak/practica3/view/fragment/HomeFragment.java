package com.qdnerak.practica3.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qdnerak.practica3.R;
import com.qdnerak.practica3.adapter.CardViewAdapter;
import com.qdnerak.practica3.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //toolbar
        showToolBar(getString(R.string.title_home_fragment), false, view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        //layaout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(), R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);
        return view;
    }
    public void showToolBar(String titulo, boolean botonSubir, View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //creamos lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://d2m1kqghccc19k.cloudfront.net/wp-content/uploads/2018/08/02182417/titicaca.jpg", "Carlos Valdivia", "2 dias", "1 me gusta"));
        images.add(new Image("https://www.lostiempos.com/sites/default/files/styles/noticia_detalle/public/media_imagen/2018/1/13/1-_roma_2-_hector_arnez.jpg?itok=E9jbs43e", "Luis Perez", "3 dias", "5 me gusta"));
        images.add(new Image("https://d2m1kqghccc19k.cloudfront.net/wp-content/uploads/2018/08/02182417/titicaca.jpg", "Fernando Torrico", "6 dias", "4 me gusta"));
        images.add(new Image("https://upload.wikimedia.org/wikipedia/commons/f/f3/Bolivia_north.jpg", "Maria FLores", "5 dias", "6 me gusta"));
        images.add(new Image("https://i.pinimg.com/originals/e2/0f/30/e20f30ae41f17f956e9c88542e7ae1f1.jpg", "Rolando Morales", "3 dias", "2 me gusta"));
        images.add(new Image("https://www.lostiempos.com/sites/default/files/styles/noticia_detalle/public/media_imagen/2018/7/28/pag7foto6elfuerte.jpg?itok=URvCBG1l", "William James", "4 dias", "5 me gusta"));
        images.add(new Image("https://media-cdn.tripadvisor.com/media/photo-s/0b/48/2c/fb/torres.jpg", "Roberto Paniagua", "2 dias", "3 me gusta"));
        images.add(new Image("https://www.incaworldbolivia.com/fotos/11102016111643-Templo-de-Kalasasaya-tiwanaku.jpg", "Lorena Herrera", "2 dias", "8 me gusta"));
        images.add(new Image("https://boliviadventure.com/wp-content/uploads/2018/09/bolivia-tours.jpg", "Laura Caceres", "6 dias", "3 me gusta"));
        images.add(new Image("https://boliviadventure.com/wp-content/uploads/2019/01/torotoro.jpg", "Marcelo Rojas", "9 dias", "1 me gusta"));

        return images;
    }
}