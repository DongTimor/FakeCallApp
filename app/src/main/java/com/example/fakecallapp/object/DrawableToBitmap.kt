package com.example.fakecallapp.`object`

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

fun drawableToBitmap(drawable : Drawable?) : Bitmap? {
    if (drawable == null) {
        return null;
    }

    // Get the intrinsic width and height of the Drawable
    val width = drawable.getIntrinsicWidth();
    val height = drawable.getIntrinsicHeight();

    // Create a Bitmap with the same dimensions
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

    // Create a Canvas to draw the Drawable onto the Bitmap
    val canvas = Canvas(bitmap);

    // Set the bounds of the Drawable to match the dimensions of the Bitmap
    drawable.setBounds(0, 0, width, height);

    // Draw the Drawable onto the Canvas
    drawable.draw(canvas);

    return bitmap;
}
