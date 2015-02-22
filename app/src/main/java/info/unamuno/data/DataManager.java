package info.unamuno.data;

import android.content.Context;

import org.json.JSONObject;

/**
 * Created by pablo on 22/02/15.
 */
public class DataManager {

    private static DataSource dataSource;

    public static void start(Context context){
        dataSource = new DataSource(context);
       dataSource.open();
    }

    public static void close() {
        dataSource.close();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void locate() {

    }

    public JSONObject fetch(String source){
        //TODO fetch the payload for a particular source at the location
        // returns null if there is no data available
        return null;
    }
}
