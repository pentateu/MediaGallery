# Media Gallery

Android library for displaying images and videos in a media gallery with thumbnails on bottom of the screen. 
Just add your media using a simple API.

This project was forked and inspired by http://github.com/VEINHORN/ScrollGalleryView

![Media Gallery](http://i.imgur.com/xrBt4Xx.gif)

##Features
- Easy way to select images in gallery (thumbnails)
- Zooming
- Simple API
- Video support
- Thumbnail borders

##Usage
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <nz.co.iswe.android.mediagallery.MediaGalleryView
        android:id="@+id/media_gallery_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#000"/>
</LinearLayout>
```

```java
public class MainActivity extends FragmentActivity {
    private MediaGalleryView mMediaGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaGalleryView = (MediaGalleryView) findViewById(R.id.scroll_gallery_view);
        mMediaGalleryView
                .setThumbnailSize(100)
                .setZoom(true)
                .setFragmentManager(getSupportFragmentManager())
                //load a bitmap directly
                .addMedia(MediaInfo.imageLoader(bitmap))
                //provide your own loader
                .addMedia(MediaInfo.mediaLoader(new MediaInfo.MediaLoader() {
                    @Override
                    public Bitmap loadBitmap(Activity activity) {
                        return convertDrawableToBitmap(R.drawable.wallpaper3);
                    }
                }))
                //load a video from a remote or Local file URL
                .addMedia(MediaInfo
                        .url("http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_1mb.mp4"))
                .setCurrentItem(2);
    }

    private Bitmap convertDrawableToBitmap(int image) {
        return ((BitmapDrawable)getResources().getDrawable(image)).getBitmap();
    }
}

```

## Gradle integration
```gradle
compile 'nz.co.iswe.android.mediagallery:library:1.0.0'
```

## Dependencies
[Android Support Library](http://developer.android.com/tools/support-library/index.html)

[PhotoView](https://github.com/chrisbanes/PhotoView)

## License

    Copyright 2015

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
