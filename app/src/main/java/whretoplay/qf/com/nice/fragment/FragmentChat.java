package whretoplay.qf.com.nice.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import whretoplay.qf.com.nice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentChat extends Fragment {


    public FragmentChat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_fragment_chat,container,false);

        return view;
    }

}
