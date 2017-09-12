package com.example.wb773.fragmentsample20170821;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import layout.BlueFragment;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button backButton = (Button) findViewById(R.id.button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //FragmentManagerからFragmentTransactionを作成
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //Fragmentのインスタンスを取得
                Fragment fragment = BlueFragment.newInstance();

                //コンテナにフラグメントを追加
                fragmentTransaction.replace(R.id.main_container, fragment, "tag");

                //backstackに追加
//                fragmentTransaction.addToBackStack(null);

                //Commit
                fragmentTransaction.commit();

            }
        });







    }


}
