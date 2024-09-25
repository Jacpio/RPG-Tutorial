package pl.jacpio.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import pl.jacpio.entities.components.DialogueData;

public class JsonLoader {
    private static final Json json = new Json();
    private static final JsonReader jsonReader = new JsonReader();
    private static JsonValue jsonValue;
    public static DialogueData loadDialogues(String path){
        jsonValue = jsonReader.parse(Gdx.files.internal(path));
        return json.fromJson(DialogueData.class, jsonValue.toString());
    }
}
