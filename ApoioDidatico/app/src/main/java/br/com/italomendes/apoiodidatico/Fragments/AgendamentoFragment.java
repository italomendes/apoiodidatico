package br.com.italomendes.apoiodidatico.Fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.italomendes.apoiodidatico.R;
import br.com.italomendes.apoiodidatico.Views.AgendamentoActivity;

/**
 * Created by root on 12/11/2017.
 */

public class AgendamentoFragment extends Fragment {
    private static final String TAG = "Agendamento";

    private Button btnAgendar;
    private EditText editData;
    private EditText editRetirada;
    private EditText editDevolucao;
    private Spinner mySpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.agendamento_fragment,container,false);

        findById(view);
        startSpinner(view, mySpinner);
        editData.setOnClickListener(getData());
        editRetirada.setOnClickListener(getTime(editRetirada));
        editDevolucao.setOnClickListener(getTime(editDevolucao));

        btnAgendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showCadastroAgendamento();
            }
        });

        return view;
    }

    private void showCadastroAgendamento() {
        Intent intent = new Intent(getActivity(), AgendamentoActivity.class);
        startActivity(intent);
    }

    private void startSpinner(View view, Spinner mySpinner) {

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.equipamentos));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
    }


    private View.OnClickListener getData() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Instancia um novo calendário
                final Calendar calendario = Calendar.getInstance();

                // Abre um dialog com um Calendário para selecionar uma data
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

                        calendario.set(year, month, dayOfMonth);

                        String dataFormatada = getDateFormat().format(calendario.getTime());
                        editData.setText(dataFormatada);

                    }
                }, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH)).show();

            }
        };
    }

    private View.OnClickListener getTime(final EditText time) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time.setText( (selectedHour < 10 ? "0" + selectedHour : selectedHour) + ":" + (selectedMinute < 10 ? "0" + selectedMinute : selectedMinute));
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Selecione a hora");
                mTimePicker.show();

            }
        };
    }

    private void findById(View view) {
        btnAgendar = (Button) view.findViewById(R.id.btnAgendar);
        editData = (EditText) view.findViewById(R.id.editData);
        editRetirada = (EditText) view.findViewById(R.id.editRetirada);
        editDevolucao = (EditText) view.findViewById(R.id.editDevolucao);
        mySpinner = (Spinner) view.findViewById(R.id.spinner);
    }

    private SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    }
}