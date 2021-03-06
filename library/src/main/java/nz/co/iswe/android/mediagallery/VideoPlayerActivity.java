package nz.co.iswe.android.mediagallery;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * {describe the class purpose here}
 */
public class VideoPlayerActivity extends Activity {


    public static final String URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = getIntent().getExtras().getString(URL);
        setContentView(R.layout.video_fragment);
        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                View progress= findViewById(R.id.videoProgress);
                progress.setVisibility(View.GONE);

                videoView.requestFocus();
                MediaController vidControl = new MediaController(VideoPlayerActivity.this);
                vidControl.setAnchorView(videoView);
                videoView.setMediaController(vidControl);
                videoView.start();
            }
        });
        videoView.setVideoURI(Uri.parse(url));

        Button closeButton = (Button) findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
