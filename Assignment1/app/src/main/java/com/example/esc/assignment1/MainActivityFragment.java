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
        public TextView userName;
        public TextView post;
        public TextView likes;
        public TextView comments;
        public TextView shares;
        public ImageView profile;
        public ImageView postImage;
    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        userName = (TextView)view.findViewById(R.id.userName);
        post = (TextView)view.findViewById(R.id.post);
        likes = (TextView)view.findViewById(R.id.likes);
        comments = (TextView)view.findViewById(R.id.comments);
        shares = (TextView)view.findViewById(R.id.shares);
        profile = (ImageView) view.findViewById(R.id.userImage);
        postImage = (ImageView) view.findViewById(R.id.postImage);
        Main2ActivityFragment fragment = new Main2ActivityFragment();
        comments.setText(fragment.comments);
        likes.setText(fragment.likes);
        shares.setText(fragment.shares);
        userName.setText(fragment.name);
        post.setText(fragment.post);
        return view;
    }
}
