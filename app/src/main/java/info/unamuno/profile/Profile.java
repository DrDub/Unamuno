package info.unamuno.profile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pablo on 21/02/15.
 * <p/>
 * A data profile
 */
public class Profile {
    private String mName;

    private String mDescription;

    private Bitmap mIcon;

    private String[] mSources;

    public Profile(JSONObject obj) throws JSONException {
        this.mName = obj.getString("name");
        this.mDescription = obj.getString("description");
        byte[] iconBytes = Base64.decode(obj.getString("icon"), Base64.DEFAULT);
        this.mIcon = BitmapFactory.decodeByteArray(iconBytes,
                0, iconBytes.length);
        JSONArray sources = obj.getJSONArray("sources");
        this.mSources = new String[sources.length()];
        for (int i = 0; i < mSources.length; i++)
            this.mSources[i] = sources.getString(i);
    }

    public Bitmap getIcon() {
        return mIcon;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getName() {
        return mName;
    }

    public String[] getSources() {
        return mSources;
    }
}
