package info.unamuno.widgets;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by pablo on 22/02/15.
 */
public class DataWidgets {

    public static abstract class WidgetFactory {
        public abstract DataWidget newInstance(String source);
    }

    private static WidgetFactory generic = new WidgetFactory() {
        @Override
        public DataWidget newInstance(String source) {
            return GeneralDataWidget.newInstance(source);
        }
    };

    private static Map<String, WidgetFactory> mWidgets = new HashMap<>();

    public static void load(String widgetsInJson) throws JSONException {
        JSONObject widgets = (JSONObject) new JSONTokener(widgetsInJson).nextValue();
        Iterator<String> keys = widgets.keys();
        while (keys.hasNext()) {
            String source = keys.next();
            WidgetFactory factory = generic;
            if (source.equalsIgnoreCase("generic")) {
                factory = new WidgetFactory() {
                    @Override
                    public DataWidget newInstance(String source) {
                        return GeneralDataWidget.newInstance(source);
                    }
                };
            }
            //else { TODO add for other widgets
            mWidgets.put(source, factory);
        }
    }

    public static DataWidget forSource(String source) {
        if (mWidgets.containsKey(source))
            return mWidgets.get(source).newInstance(source);
        return generic.newInstance(source);
    }

}
