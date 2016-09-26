package wenke.makelove.bottomtabexample.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wenke.makelove.bottomtabexample.R;


/**
 * Created by wenke on 08/31/2016.
 */
public class Fragment3 extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view==null){
            view = inflater.inflate(R.layout.test3, null);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }
        return view;
    }
}
