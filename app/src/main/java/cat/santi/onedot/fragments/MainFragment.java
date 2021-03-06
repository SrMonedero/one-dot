package cat.santi.onedot.fragments;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cat.santi.mod.onedot.OneDotView;
import cat.santi.onedot.R;

/**
 *
 */
public class MainFragment extends Fragment implements
        OneDotView.OneDotCallbacks {

    private static final String TAG = MainFragment.class.getSimpleName();

    // Note: Find usages of #mOneDotView to see callback and lifecycle interaction

    @InjectView(R.id.od__main__one_dot_view)
    OneDotView mOneDotView;

    // Just for debug purposes...
    private Toast mToast;

    public static Fragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.od__main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.od__action_pause:
                return actionPause();
            case R.id.od__action_resume:
                return actionResume();
            case R.id.od__action_restart:
                return actionRestart();
            case R.id.od__action_destroy:
                return actionStop();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.od__fragment_main, container, false);
        ButterKnife.inject(this, view);
        mOneDotView.setCallbacks(this);
        return view;
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Let the logic start by calling this method
        mOneDotView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        // Pause the logic by calling this method
        mOneDotView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Unregister callbacks
        mOneDotView.setCallbacks(null);
        // Destroy the game, ending the loop (returns the total score)
        final int score = mOneDotView.onDestroy();
        Log.i(TAG, ">> final score: " + score);

        ButterKnife.reset(this);
    }

    // Toolbar actions

    private boolean actionPause() {
        mOneDotView.onPause();
        return true;
    }

    private boolean actionResume() {
        mOneDotView.onResume();
        return true;
    }

    private boolean actionRestart() {
        mOneDotView.newGame(10);
        return true;
    }

    private boolean actionStop() {
        mOneDotView.onDestroy();
        return true;
    }

    // OneDotView callbacks

    @Override
    public void onScoreChanged(int score, int delta) {
//        toast("Score changed | score:" + score + " delta:" + delta);
        Log.d(TAG, "Total score: " + score);
    }

    // Just for debug purposes
    @SuppressWarnings("unused")
    private void toast(String message) {
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
