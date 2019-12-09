package cn.yj.store.navigation;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import cn.yj.store.R;
import cn.yj.store.client.ClientFragment;
import cn.yj.store.order.OrderContextFragment;
import cn.yj.store.product.ProductFragment;
import cn.yj.store.profile.ProfileFragment;

public class NavigationMain extends AppCompatActivity implements View.OnClickListener {
    private String TAG = getClass().getSimpleName();
    private TextView order, client, product, profile;
    private String selectedText = "#ffffff";
    private String selectedBg = "#ff2244";
    private String unSelectedText = "#000000";
    private String unSelectedBg = "#fffccc";
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private List<TextView> navigationList;
    private Fragment orderFragment;
    private Fragment clientFragment;
    private Fragment productFragment;
    private TextView headerTitle;
    private Fragment profileFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigationList = new ArrayList<>();
        setContentView(R.layout.navigation_main);
        order = findViewById(R.id.navigation_order);
        client = findViewById(R.id.navigation_client);
        product = findViewById(R.id.navigation_product);
        profile = findViewById(R.id.navigation_profile);
        headerTitle = findViewById(R.id.header_title);
        fragmentManager = getSupportFragmentManager();
        navigationList.add(order);
        navigationList.add(client);
        navigationList.add(product);
        navigationList.add(profile);
        order.setOnClickListener(this);
        client.setOnClickListener(this);
        product.setOnClickListener(this);
        profile.setOnClickListener(this);
        addFragment();
        selectNavigation(orderFragment, order);
    }

    private void addFragment() {
        transaction = fragmentManager.beginTransaction();
        orderFragment = new OrderContextFragment();
        clientFragment = new ClientFragment();
        productFragment = new ProductFragment();
        profileFragment = new ProfileFragment();
        transaction.add(R.id.fragment_show, orderFragment);
        transaction.add(R.id.fragment_show, clientFragment);
        transaction.add(R.id.fragment_show, productFragment);
        transaction.add(R.id.fragment_show, profileFragment);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        transaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.navigation_order:
                selectNavigation(orderFragment, order);
                headerTitle.setText(R.string.navigation_order);
                break;
            case R.id.navigation_client:
                selectNavigation(clientFragment, client);
                headerTitle.setText(R.string.navigation_client);
                break;
            case R.id.navigation_product:
                selectNavigation(productFragment, product);
                headerTitle.setText(R.string.navigation_product);
                break;
            case R.id.navigation_profile:
                selectNavigation(profileFragment, profile);
                headerTitle.setText(R.string.navigation_profile);
                break;
            default:
                break;
        }

    }

    /**
     * 改变选中的背景, 字体颜色
     *
     * @param fragment fragment
     * @param textView TextView
     */
    private void selectNavigation(Fragment fragment, TextView textView) {
        hideFragment();
        for (TextView x : navigationList) {
            if (textView == x) {
                textView.setTextColor(Color.parseColor(selectedText));
                textView.setBackgroundColor(Color.parseColor(selectedBg));
            } else {
                x.setTextColor(Color.parseColor(unSelectedText));
                x.setBackgroundColor(Color.parseColor(unSelectedBg));
            }
        }
        transaction.show(fragment);
        transaction.commit();
    }

    private void hideFragment() {
        transaction.hide(orderFragment);
        transaction.hide(clientFragment);
        transaction.hide(productFragment);
        transaction.hide(profileFragment);
    }

}
