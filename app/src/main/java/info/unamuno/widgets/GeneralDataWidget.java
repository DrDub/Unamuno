package info.unamuno.widgets;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import info.unamuno.data.DataManager;
import info.unamuno.unamuno.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralDataWidget extends DataWidget {


    public GeneralDataWidget() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static DataWidget newInstance(String source) {
        GeneralDataWidget fragment = new GeneralDataWidget();
        Bundle args = new Bundle();
        args.putString(ARG_SOURCE, source);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_general_data_widget, container, false);

        Log.d("GeneraWidget", mSource);

        TextView textView = (TextView) rootView.findViewById(R.id.widget_title);
        TextView jsonView = (TextView) rootView.findViewById(R.id.json_text);

        textView.append(mSource);
        String jsonText = jsonToStr(DataManager.fetch(mSource));

        //Log.d("widget" + mSource, jsonText);

        jsonView.append(jsonText.substring(0,1000));

        return rootView;
    }

    private String jsonToStr(JSONObject obj, String... path) {
        Iterator<String> keys = obj.keys();
        List<String> sortedKeys = new ArrayList<>();
        while (keys.hasNext()) {
            sortedKeys.add(keys.next());
        }
        Collections.sort(sortedKeys);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length; i++) {
            if (i != 0)
                sb.append(' ');
            sb.append(path[i]);
        }
        String prefix = sb.toString();
        sb.setLength(0);
        try {
            for (String key : sortedKeys) {
                if (obj.get(key) instanceof JSONObject) {
                    String[]newPath = new String[path.length+1];
                    System.arraycopy(path,0,newPath,0,path.length);
                    newPath[path.length] = key;
                    sb.append(jsonToStr((JSONObject) obj.get(key), newPath));
                }else
                    sb.append(prefix).append(' ').append(key).append('=').append(obj.get(key).toString()).append('\n');
            }
        }catch (JSONException e){
            sb.append(e.getMessage());
        }
        return sb.toString();
    }

}
