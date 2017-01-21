package com.example.android.myappportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindViews({R.id.popular_movies, R.id.stock_hawk, R.id.xyz_reader, R.id.best_news, R.id.capstone_design})
    protected List<Button> appButton;
    private Toast launchMsgToast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Normal way of setting event listener
        // Set OnClickListener attaching to all app button.
        for (int i = 0; i < appButton.size(); i++) {
            appButton.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < appButton.size(); i++) {
                        if (v.getId() == appButton.get(i).getId()) {
                            toastShow(getString(R.string.launch_message, ((Button) v).getText()));
                            break;
                        }
                    }
                }
            });
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