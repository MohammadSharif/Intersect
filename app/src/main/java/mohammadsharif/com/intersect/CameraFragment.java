package mohammadsharif.com.intersect;



import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import jp.co.nec.gazirur.rtsearch.lib.bean.SearchResult;
import jp.co.nec.gazirur.rtsearch.lib.clientapi.RTFeatureSearcher;

public class CameraFragment extends Fragment implements SurfaceHolder.Callback {

    public static final String TAG = "CameraFragment";

    private SurfaceView surfaceView;        // renders camera preview
    private Camera camera;                  // camera that scans
    private RTFeatureSearcher searcher;     // searchers for artifacts in frame
    private SearchResult result;            // holds result of searcher
    private CameraFragmentCallbacks callback;

    public static CameraFragment newInstance(CameraFragmentCallbacks callback) {
        CameraFragment fragment = new CameraFragment();
        fragment.callback = callback;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_preview, container, false);

        // Service authentication
        new ArcheAuth(getActivity().getApplicationContext()).execute();

        // Create searcher instance
        ArcheCreateSearcher CreateSearcher = new ArcheCreateSearcher(
                getActivity().getApplicationContext(),
                new ArcheCreateSearcherCallbacks() {
                    public void postExecute(RTFeatureSearcher result) {
                        searcher = result;
                    }
                }
        );
        CreateSearcher.execute();

        // Get handle on SurfaceView and let this object be a callback
        surfaceView = (SurfaceView) view.findViewById(R.id.surfaceView);
        surfaceView.getHolder().addCallback(this);
        surfaceView.setOnClickListener(onSurfaceClickListener);

        return view;
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        // Initialize camera
        camera = Camera.open();
        camera.setDisplayOrientation(90); // make portrait camera

        // Hook up camera feed
        try {
            camera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            Log.e(TAG, "setting camera preview display failed");
        }
    }


    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int w, int h) {

        // Get available camera sizes
        Camera.Parameters params = camera.getParameters();
        List<Camera.Size> sizes = params.getSupportedPreviewSizes();

        // Determine best camera size
//        Camera.Size optimalSize = getOptimalPreviewSize(sizes, w, h);
//        params.setPreviewSize(optimalSize.width, optimalSize.height);
        params.setPreviewSize(320,240);
        camera.setParameters(params);

        // Start rolling
        camera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        // Release camera
        camera.release();
        camera = null;

        searcher.CloseFeatureSearcher();
    }

    private View.OnClickListener onSurfaceClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view){
            // First focus camera
            if(camera != null){
                camera.autoFocus(autoFocusCallback);
            }
        }

    };

    private Camera.AutoFocusCallback autoFocusCallback = new Camera.AutoFocusCallback() {

        @Override
        public void onAutoFocus(boolean b, Camera camera) {
            // After focusing camera, take one snapshot
            camera.setOneShotPreviewCallback(previewCallback);
        }

    };

    private Camera.PreviewCallback previewCallback = new Camera.PreviewCallback(){

        @Override
        public void onPreviewFrame(byte[] frame, Camera camera) {

            //Identify
            ArcheSearch Search = new ArcheSearch(
                    searcher,
                    frame,
                    new ArcheSearchCallbacks() {
                        public void postExecute(SearchResult result) {
                            CameraFragment.this.result = result;
                        }
                    }
            );
            Search.execute();

            // Toast!
            if (result != null) {
                List<String> appendInfo = result.getAppendInfo();
                Toast.makeText(getActivity().getApplicationContext(), appendInfo.get(3),
                        Toast.LENGTH_SHORT).show();
                String id = appendInfo.get(2);
                String name = appendInfo.get(3);
                if (callback != null) callback.postRecognition(id, name);
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Not found",
                        Toast.LENGTH_SHORT).show();
            }

            result = null; // reset result
        }
    };

    private Camera.Size getOptimalPreviewSize(List<Camera.Size> sizes, int w, int h) {

        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) h / w;

        if (sizes == null) return null;

        Camera.Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        for (Camera.Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) continue;
            if (Math.abs(size.height - h) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - h);
            }
        }

        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Camera.Size size : sizes) {
                if (Math.abs(size.height - h) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - h);
                }
            }
        }
        return optimalSize;
    }

}
