package info.unamuno.widgets;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        DataWidget fragment = new DataWidget();
        Bundle args = new Bundle();
        args.putString(ARG_SOURCE, source);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_general_data_widget, container, false);

        //TODO show JSON object as a table

        return root;
    }


}
