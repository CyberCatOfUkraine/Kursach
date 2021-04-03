package com.shaman.kursach;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Map;

public class CustomDialogFragment extends DialogFragment {

    TableLayout _tableLayout;
    TableRow _tableRow;
    Employee _employee;
    MainActivity _mainActivity;
    public CustomDialogFragment(TableLayout tableLayout,TableRow tableRow,Employee employee,MainActivity mainActivity){
        _tableLayout=tableLayout;
        _tableRow=tableRow;
        _employee=employee;
        _mainActivity=mainActivity;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Вибрано співробітника")
                .setMessage("Прізвище та ініціали: "+_employee.Surname)
                .setIcon(R.drawable.ic_launcher_background)
                .setNegativeButton("Видалити", (dialog, id) -> {
                    SQLWrapper.Delete(_employee);
                    //_mainActivity.UpdateScrollBar();
                    _tableLayout.removeView(_tableRow);
                    // Закрываем окно
                    dialog.cancel();
                })
                .setNeutralButton("Редактувати", (dialog, id) -> {

                    Intent intent = new Intent(_mainActivity,EditEmployeeActivity.class);
                    intent.putExtra("employeeId", _employee.getId());
                    startActivity(intent);
                    // Закрываем окно
                    dialog.cancel();
                })
                .setPositiveButton("Закрити без змін", (dialog, id) -> {
                    // Закрываем окно
                    dialog.cancel();
                });
        return builder.create();
    }

}