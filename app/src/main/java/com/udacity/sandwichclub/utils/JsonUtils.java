package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject startingJsonObject = new JSONObject(json);
            JSONObject nameJSONObject = startingJsonObject.getJSONObject("name");

            JSONArray alsoKnownAsJSONArray = nameJSONObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJSONArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsJSONArray.getString(i));
            }

            JSONArray ingredientJSONArray = startingJsonObject.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredientJSONArray.length(); i++) {
                ingredientsList.add(ingredientJSONArray.getString(i));
            }

            sandwich.setMainName(nameJSONObject.getString("mainName"));
            sandwich.setAlsoKnownAs(alsoKnownAsList);
            sandwich.setPlaceOfOrigin(startingJsonObject.getString("placeOfOrigin"));
            sandwich.setDescription(startingJsonObject.getString("description"));
            sandwich.setImage(startingJsonObject.getString("image"));
            sandwich.setIngredients(ingredientsList);

        } catch (JSONException e) {
            Log.e("JsonUtils", "A problem occurred when parsing the JSON file.", e);
        }

        return sandwich;
    }
}
