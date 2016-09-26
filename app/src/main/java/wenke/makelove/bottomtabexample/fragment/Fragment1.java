package wenke.makelove.bottomtabexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wenke.makelove.bottomtabexample.R;


/**
 * Created by wenke on 08/31/2016.
 */
public class Fragment1 extends Fragment {

    private View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("makelove", "onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("makelove", "onCreateView");


        if (rootView == null)
        {
            rootView = inflater.inflate(R.layout.test1, null);
        }
        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null)
        {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("makelove", "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("makelove", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("makelove", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("makelove", "onResume");
    }

    @Override
    public void onPause() {
        Log.e("makelove","onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("makelove", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("makelove", "onDestoryView");
    }
}
