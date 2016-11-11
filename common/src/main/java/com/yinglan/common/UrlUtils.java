package com.yinglan.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;

public class UrlUtils {
    /**
     * 默认的scheme跳转逻辑
     * @param context 
     * @param scheme
     */
    public void defaultSchemeJump(Context context, String scheme) {
        if (!TextUtils.isEmpty(scheme)) {
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(scheme));
            if (in.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(in);
            } else {
                Toast.makeText(context, R.string.common_not_install, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, R.string.common_not_install, Toast.LENGTH_SHORT).show();
        }
    }
}
