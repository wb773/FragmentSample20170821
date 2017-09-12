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

public class PinkFragment extends Fragment {

    public PinkFragment() {
        // Required empty public constructor
    }


    public static PinkFragment newInstance() {
        PinkFragment fragment = new PinkFragment();
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
        View view = inflater.inflate(R.layout.fragment_pink, container, false);

        //戻るボタンの実装
        Button backButton = (Button) view.findViewById(R.id.backButton);
        backButton.setText("戻る");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PinkFragment", "onClick");
                getFragmentManager().popBackStack();
            }
        });

        //進むボタンの実装
        Button nextButton = (Button) view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PinkFragment", "onClick Next");
                //FragmentManagerからFragmentTransactionを作成
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //Fragmentのインスタンスを取得
                Fragment fragment = YellowFragment.newInstance();

                //コンテナにフラグメントを追加
                fragmentTransaction.replace(R.id.main_container, fragment);

                //backstackに追加
                fragmentTransaction.addToBackStack(null);

                //Commit
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
