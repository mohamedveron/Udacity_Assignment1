package Controller;

import com.example.esc.assignment1.Component;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mohamed AbdEl Mohaimen Mohamed on 7/28/2016.
 */
public class JsonParser {
    public JsonParser(){

    }

    public ArrayList<Component> parseJson(String json) throws JSONException {
        ArrayList<Component>postDetails = new ArrayList<>();
        JSONObject Json =  new JSONObject(json);
        Component comp = new Component();
        Component comp1 = new Component();
        Component comp2 = new Component();
        Component comp3 = new Component();
        Component comp4 = new Component();
        Component comp5 = new Component();
        Component comp6 = new Component();
        comp.setName("comments");
        comp.setContent(Json.getString("comments"));
        postDetails.add(comp);
        comp1.setName("likes");
        comp1.setContent(Json.getString("likes"));
        postDetails.add(comp1);
        comp2.setName("post");
        comp2.setContent(Json.getString("postText"));
        postDetails.add(comp2);
        comp3.setName("shares");
        comp3.setContent(Json.getString("shares"));
        postDetails.add(comp3);
        comp4.setName("name");
        comp4.setContent(Json.getString("userName"));
        postDetails.add(comp4);
        comp5.setName("postImage");
        comp5.setContent(Json.getString("postImage"));
        postDetails.add(comp5);
        comp6.setName("userImage");
        comp6.setContent(Json.getString("userPic"));
        postDetails.add(comp6);

        return postDetails;
    }
}
