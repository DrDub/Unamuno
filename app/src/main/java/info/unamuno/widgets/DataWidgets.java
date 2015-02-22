package info.unamuno.widgets;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pablo on 22/02/15.
 */
public class DataWidgets {

    public static abstract class WidgetFactory {
        public DataWidget newInstance(String source);
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
        for (String source : widgets) {
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
