package layout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wb773.fragmentsample20170821.R;

public class YellowFragment extends Fragment {

    public YellowFragment() {
        // Required empty public constructor
    }


    public static YellowFragment newInstance() {
        YellowFragment fragment = new YellowFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yellow, container, false);

        //戻るボタンの実装
        Button backButton = (Button) view.findViewById(R.id.backButton);
        backButton.setText("戻る");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("YellowFragment", "onClick");
                getFragmentManager().popBackStack();
            }
        });


        //進むボタンの実装
        Button nextButton = (Button) view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("YellowFragment", "onClick Next");
                getFragmentManager().beginTransaction().remove(YellowFragment.this).commit();
            }
        });

        return view;


    }

}
