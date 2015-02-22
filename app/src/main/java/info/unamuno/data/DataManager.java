package info.unamuno.data;

import org.json.JSONException;
import android.content.Context;
import org.json.JSONObject;
import org.json.JSONTokener;

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

    public static JSONObject fetch(String source){
        //TODO fetch the payload for a particular source at the location
        // returns null if there is no data available
        try {
            return (JSONObject) new JSONTokener("{\"2005\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"1987\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2004\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"1989\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"1990\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2014\":{\"Three bedroom units\":\"-2\",\"One bedroom units\":\"-2\",\"Bachelor units\":\"-2\",\"Two bedroom units\":\"-2\"},\"2007\":{\"Three bedroom units\":\"-2\",\"One bedroom units\":\"-2\",\"Bachelor units\":\"-2\",\"Two bedroom units\":\"-2\"},\"1991\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2002\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2013\":{\"Three bedroom units\":\"-2\",\"One bedroom units\":\"-2\",\"Bachelor units\":\"-2\",\"Two bedroom units\":\"-2\"},\"2011\":{\"Three bedroom units\":\"-2\",\"One bedroom units\":\"-2\",\"Bachelor units\":\"-2\",\"Two bedroom units\":\"-2\"},\"2000\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2009\":{\"Three bedroom units\":\"-2\",\"One bedroom units\":\"-2\",\"Bachelor units\":\"-2\",\"Two bedroom units\":\"-2\"},\"1996\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2012\":{\"Three bedroom units\":\"-2\",\"One bedroom units\":\"-2\",\"Bachelor units\":\"-2\",\"Two bedroom units\":\"-2\"},\"1999\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"1993\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"1995\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2010\":{\"Three bedroom units\":\"-2\",\"One bedroom units\":\"-2\",\"Bachelor units\":\"-2\",\"Two bedroom units\":\"-2\"},\"2008\":{\"Three bedroom units\":\"-2\",\"One bedroom units\":\"-2\",\"Bachelor units\":\"-2\",\"Two bedroom units\":\"-2\"},\"1994\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"1988\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2001\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"1997\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"1998\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"1992\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2006\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"},\"2003\":{\"Three bedroom units\":\"-1\",\"One bedroom units\":\"-1\",\"Bachelor units\":\"-1\",\"Two bedroom units\":\"-1\"}}").nextValue();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
