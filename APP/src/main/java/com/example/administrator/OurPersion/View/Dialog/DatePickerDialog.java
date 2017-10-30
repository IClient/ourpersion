package com.example.administrator.OurPersion.View.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/9/18 0018.
 */

public class DatePickerDialog extends Dialog {
    Context context;
    int layout;

    public DatePickerDialog(Context context, int theme, int layout) {
        super(context, theme);
        setCanceledOnTouchOutside(false);
        this.context = context;
        this.layout = layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker_dialog);
    }
}
