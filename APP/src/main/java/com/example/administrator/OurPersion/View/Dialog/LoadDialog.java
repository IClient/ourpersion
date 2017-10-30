package com.example.administrator.OurPersion.View.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/7/19 0019.
 */

public class LoadDialog extends Dialog {

    Context context;
    int layout;

    public LoadDialog(Context context, int theme, int layout) {
        super(context, theme);
        setCanceledOnTouchOutside(false);
        this.context = context;
        this.layout = layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_dialog);

    }
}
