package excelmec.dalalbull;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by sherlock on 27/9/16.
 */
public class fragment_leaderboard extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_leaderboard, container, false);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.ll);
        return rootView;
    }
}
