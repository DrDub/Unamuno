package info.unamuno.profile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by pablo on 21/02/15.
 */
public class Profiles {
    private static List<Profile> mProfiles = new ArrayList<>();

    public static void load(String profilesInJson) throws JSONException {
        JSONArray profiles = (JSONArray) new JSONTokener(profilesInJson).nextValue();
        for (int i = 0; i < profiles.length(); i++) {
            mProfiles.add(new Profile(profiles.getJSONObject(i)));
        }
    }

    public static Collection<Profile> profiles() {
        return Collections.unmodifiableCollection(mProfiles);
    }

    public static Profile profile(int i){
        return mProfiles.get(i);
    }
}

