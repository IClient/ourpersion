package com.example.administrator.OurPersion.View.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/9/22 0022.
 */

public class BedAdminAddiconDialog extends Dialog {
    Context context;
    int layout;

    public BedAdminAddiconDialog(Context context, int theme, int layout) {
        super(context, theme);
        this.context = context;
        this.layout = layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bedadmin_addicon_dialog);
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.RIGHT | Gravity.TOP);
        dialogWindow.setAttributes(lp);
    }
}
