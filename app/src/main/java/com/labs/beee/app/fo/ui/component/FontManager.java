package com.labs.beee.app.fo.ui.component;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by arysuryawan on 7/23/17.
 */

public class FontManager {

    public static final String ROOT = "fonts/",
            FONTAWESOME = ROOT + "fontawesome-webfont.ttf";

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }
}
