package br.com.italomendes.apoiodidatico;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by root on 12/11/2017.
 */

public class HistoricoFragment extends Fragment {
    private static final String TAG = "Historico";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.historico_fragment,container,false);


        return view;
    }
}