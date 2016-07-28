package com.example.esc.assignment1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import Controller.PostController;

    /**
     * A placeholder fragment containing a simple view.
     */
    public class MainActivityFragment extends Fragment {
        public MainActivityFragment(){

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        PostController.getPost(this.getContext());
        return view;
    }
}
