package Controller;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.esc.assignment1.Component;
import com.example.esc.assignment1.Main2ActivityFragment;
import com.example.esc.assignment1.MainActivityFragment;
import com.example.esc.assignment1.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Mohamed AbdEl Mohaimen Mohamed on 7/28/2016.
 */
public class PostController {

    public  PostController(){

    }

    public  static void getPost(Context context){
           new OpenConnection(context).execute("https://dl.dropboxusercontent.com/s/7rvknz9e6tfprun/facebookFeed.json");
    }

    public static class OpenConnection extends AsyncTask<String,Void, ArrayList<Component>>{

        private  Context context;
        public OpenConnection(Context context){
            this.context = context;
        }

        @Override
        protected ArrayList<Component> doInBackground(String... params) {
            URL url = null;
            HttpURLConnection connection = null;
            BufferedReader buffer = null;
            String result = null;
            try {
                url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream input = connection.getInputStream();
                buffer = new BufferedReader(new InputStreamReader(input));
                StringBuffer sbuffer = new StringBuffer();
                String  line;
                while ((line = buffer.readLine())!= null){
                    sbuffer.append(line);
                }
                result = sbuffer.toString();
                JsonParser parser = new JsonParser();
                ArrayList<Component>details = parser.parseJson(result);
                Log.v("here",details.get(0).getContent());
                return details;
            } catch (MalformedURLException e) {
                System.out.println("URL is wrong");
            } catch (IOException e) {
                System.out.println("Connection failed");
            } catch (JSONException e) {
                System.out.println("PARSE JSON failed");
            }
            return null;
        }
        @Override
        protected void onPostExecute(ArrayList<Component>details){
            //MainActivityFragment fragment = new MainActivityFragment();
            //fragment.updatePostView(details);
            TextView userName = (TextView)((Activity)context).findViewById(R.id.userName);
            TextView post1 = (TextView)((Activity)context).findViewById(R.id.post);
            TextView likes1 = (TextView)((Activity)context).findViewById(R.id.likes);
            TextView comments1 = (TextView)((Activity)context).findViewById(R.id.comments);
            TextView shares1 = (TextView)((Activity)context).findViewById(R.id.shares);
            ImageView profile1 = (ImageView) ((Activity)context).findViewById(R.id.userImage);
            ImageView postImage = (ImageView) ((Activity)context).findViewById(R.id.postImage);
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
                    Picasso.with(context).load(com.getContent())
                            .resize(100,100).centerCrop()
                            .into(profile1);
                }
                else if(com.getName().equals("postImage"))
                {
                    Picasso.with(context).load(com.getContent())
                            .resize(400,400).centerCrop()
                            .into(postImage);
                }
            }


        }
    }
}
