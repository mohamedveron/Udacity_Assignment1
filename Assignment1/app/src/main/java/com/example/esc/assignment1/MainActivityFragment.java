package com.example.esc.assignment1;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Controller.PostController;

    /**
     * A placeholder fragment containing a simple view.
     */
    public class MainActivityFragment extends Fragment {
        public View view;
        public MainActivityFragment(){

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        PostController.getPost(this.getContext());
        return view;
    }
       /* public void updatePostView(ArrayList<Component>details){
            TextView userName = (TextView)((Activity)this.getContext()).findViewById(R.id.userName);
            TextView post1 = (TextView)view.findViewById(R.id.post);
            TextView likes1 = (TextView)view.findViewById(R.id.likes);
            TextView comments1 = (TextView)view.findViewById(R.id.comments);
            TextView shares1 = (TextView)view.findViewById(R.id.shares);
            ImageView profile1 = (ImageView) view.findViewById(R.id.userImage);
            ImageView postImage = (ImageView) view.findViewById(R.id.postImage);
            for(Component com : details){
                if(com.getName().equals("comments"))
                    comments1.setText(com.getContent());
                else if(com.getName().equals("likes"))
                    likes1.setText(com.getContent());
                else if(com.getName().equals("shares"))
                    shares1.setText(com.getContent());
                else if(com.getName().equals("post"))
                    post1.setText(com.getContent());
                else if(com.getName().equals("name"))
                    userName.setText(com.getContent());
                else if(com.getName().equals("userImage")){
                    Picasso.with(getContext()).load(com.getContent())
                            .resize(100,100).centerCrop()
                            .into(profile1);
                }
                else if(com.getName().equals("postImage"))
                {
                    Picasso.with(getContext()).load(com.getContent())
                            .resize(400,400).centerCrop()
                            .into(postImage);
                }
            }
        }*/
}
