package com.example.android.myappportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindViews({R.id.popular_movies, R.id.stock_hawk, R.id.xyz_reader, R.id.best_news, R.id.capstone_design})
    protected List<Button> appButton;
    private Toast launchMsgToast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * This method is called when any app button is clicked.
     * Use ButterKnife way to set event listener.
     *
     * @param view
     */
    @OnClick({R.id.popular_movies, R.id.stock_hawk, R.id.xyz_reader, R.id.best_news, R.id.capstone_design})
    public void buttonClick(View view) {
        for (int i = 0; i < appButton.size(); i++) {
            if (view.getId() == appButton.get(i).getId()) {
                toastShow(getString(R.string.launch_message, ((Button) view).getText()));
                break;
            }
        }
    }

    /**
     * This method display a toast.
     *
     * @param msg is toast message.
     */
    private void toastShow(String msg) {
        if (launchMsgToast == null) {
            launchMsgToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {
            launchMsgToast.setText(msg);
        }
        launchMsgToast.show();
    }
}