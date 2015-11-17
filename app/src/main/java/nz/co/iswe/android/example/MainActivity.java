package nz.co.iswe.android.example;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import nz.co.iswe.android.mediagallery.MediaInfo;
import nz.co.iswe.android.mediagallery.MediaGalleryView;

public class MainActivity extends FragmentActivity {

    private MediaGalleryView mMediaGalleryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bitmap = convertDrawableToBitmap(R.drawable.wallpaper7);

        mMediaGalleryView = (MediaGalleryView) findViewById(R.id.scroll_gallery_view);
        mMediaGalleryView
                .setThumbnailSize(100)
                .setZoom(true)
                .setFragmentManager(getSupportFragmentManager())
                .addMedia(MediaInfo.imageLoader(bitmap))
                .addMedia(MediaInfo.mediaLoader(new MediaInfo.MediaLoader() {
                    @Override
                    public Bitmap loadBitmap(Activity activity) {
                        return convertDrawableToBitmap(R.drawable.wallpaper3);
                    }
                }))
                .addMedia(MediaInfo
                        .url("http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_1mb.mp4"));

    }

    private Bitmap convertDrawableToBitmap(int image) {
        return ((BitmapDrawable) getResources().getDrawable(image)).getBitmap();
    }
}
