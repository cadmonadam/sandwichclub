package com.udacity.sandwichclub.utils;

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
            JSONObject sandwichJsonObject = new JSONObject(json);
            JSONObject nameJSONObject = sandwichJsonObject.getJSONObject("name");

            JSONArray alsoKnownAsJSONArray = nameJSONObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJSONArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsJSONArray.getString(i));
            }

            JSONArray ingredientJSONArray = sandwichJsonObject.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredientJSONArray.length(); i++) {
                ingredientsList.add(ingredientJSONArray.getString(i));
            }

            sandwich.setMainName(nameJSONObject.getString("mainName"));
            sandwich.setAlsoKnownAs(alsoKnownAsList);
            sandwich.setPlaceOfOrigin(sandwichJsonObject.getString("placeOfOrigin"));
            sandwich.setDescription(sandwichJsonObject.getString("description"));
            sandwich.setImage(sandwichJsonObject.getString("image"));
            sandwich.setIngredients(ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
