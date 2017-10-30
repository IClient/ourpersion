package com.example.administrator.OurPersion.View.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/6/21 0021.
 */


/**
 * Created by Administrator on 2017/5/31 0031.
 */

public class MeAddiconDialog extends Dialog {
    Context context;
    int layout;

    public MeAddiconDialog(Context context, int theme, int layout) {
        super(context, theme);
        this.context = context;
        this.layout = layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_addicon_dialog);
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.RIGHT | Gravity.TOP);
        dialogWindow.setAttributes(lp);
    }
}
