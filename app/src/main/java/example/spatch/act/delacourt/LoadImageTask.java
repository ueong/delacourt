package example.spatch.act.delacourt;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

public class LoadImageTask extends AsyncTask<DelacourtMenu, Void, Bitmap> {
    private ImageView imageView;
    private Context context;
    public LoadImageTask(Context context, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(DelacourtMenu... params) {
        DelacourtMenu item = params[0];
        try {
            URL url = new URL(item.getImgSrc());
            return BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch(IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageDrawable(context.getDrawable(R.drawable.no_image_available));
        }
    }
}

