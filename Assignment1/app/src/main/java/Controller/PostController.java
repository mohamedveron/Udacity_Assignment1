package Controller;

import android.os.AsyncTask;
import android.util.Log;

import com.example.esc.assignment1.Component;
import com.example.esc.assignment1.Main2ActivityFragment;
import com.example.esc.assignment1.MainActivityFragment;

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

    public  static void getPost(){
           new OpenConnection().execute("https://dl.dropboxusercontent.com/s/7rvknz9e6tfprun/facebookFeed.json");
    }

    public static class OpenConnection extends AsyncTask<String,Void, ArrayList<Component>>{

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
            Main2ActivityFragment fragment = new Main2ActivityFragment();
            String comments=null,likes=null,shares=null,name=null,post=null,profile=null,image=null;
            for(Component com : details){
                if(com.getName().equals("comments"))
                    comments = com.getContent();
                else if(com.getName().equals("likes"))
                    likes = com.getContent();
                else if(com.getName().equals("shares"))
                    shares = com.getContent();
                else if(com.getName().equals("post"))
                    post = com.getContent();
                else if(com.getName().equals("name"))
                    name = com.getContent();
                else if(com.getName().equals("userImage"))
                    profile = com.getContent();
                else if(com.getName().equals("postImage"))
                    image = com.getContent();
            }
            fragment.comments = comments;
            fragment.likes = likes;
            fragment.shares = shares;
            fragment.post = post;
            fragment.name = name;
            fragment.profile = profile;
            fragment.image = image;
        }
    }
}
