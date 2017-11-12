package br.com.italomendes.apoiodidatico;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by root on 12/11/2017.
 */

public class AgendamentoFragment extends Fragment {
    private static final String TAG = "Agendamento";

    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.agendamento_fragment,container,false);
        btnTEST = (Button) view.findViewById(R.id.btnAgendar);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "AGENDAMENTO!",Toast.LENGTH_SHORT).show();
            }
        });

        Spinner mySpinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.equipamentos));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        return view;
    }
}