package layout;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wb773.fragmentsample20170821.R;

public class BlueFragment extends Fragment {



    public BlueFragment() {
        // Required empty public constructor
    }


    public static BlueFragment newInstance() {
        BlueFragment fragment = new BlueFragment();
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
        View view = inflater.inflate(R.layout.fragment_blue, container, false);

        //戻るボタンの実装
        Button backButton = (Button) view.findViewById(R.id.backButton);
        backButton.setText("戻る");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BlueFragment", "onClick Back");
                getFragmentManager().beginTransaction().remove(BlueFragment.this).commit();
            }
        });

        //進むボタンの実装
        Button nextButton = (Button) view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BlueFragment", "onClick Next");
                //FragmentManagerからFragmentTransactionを作成
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //Fragmentのインスタンスを取得
                Fragment fragment = PinkFragment.newInstance();

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
