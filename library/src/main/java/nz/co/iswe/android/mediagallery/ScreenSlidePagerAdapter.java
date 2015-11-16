package nz.co.iswe.android.mediagallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by veinhorn on 29.8.15.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<MediaInfo> mListOfMedia;

    private boolean isZoom = false;

    public ScreenSlidePagerAdapter(FragmentManager fm, List<MediaInfo> listOfMedia,
            boolean isZoom) {
        super(fm);
        this.mListOfMedia = listOfMedia;
        this.isZoom = isZoom;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position < mListOfMedia.size()) {
            MediaInfo mediaInfo = mListOfMedia.get(position);
            fragment = loadImageFragment(mediaInfo);
        }
        return fragment;
    }

    private Fragment loadImageFragment(MediaInfo mediaInfo) {
        ImageFragment fragment = new ImageFragment();
        fragment.setMediaInfo(mediaInfo);
        Bundle bundle = new Bundle();
        bundle.putBoolean("zoom", isZoom);
        if(mediaInfo.isVideo()) {
            bundle.putBoolean("isVideo", true);
            bundle.putCharSequence("url", mediaInfo.getURL());
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return mListOfMedia.size();
    }
}
