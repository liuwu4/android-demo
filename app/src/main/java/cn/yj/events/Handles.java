package cn.yj.events;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import cn.yj.dao.TextBase;
import cn.yj.ui.TestKtActivity;

/**
 * @author liwuu4
 * @date 2020/07/16
 * @description 处理事件
 */
public class Handles {
    private final static String TAG = Handles.class.getName();

    public void onClickFriend(View view, TextBase textBase, String msg) {
        view.setBackgroundColor(Color.BLUE);
        textBase.setAge(textBase.getAge() + 1);
        textBase.setFirstName("点击事件触发" + textBase.getAge());
        Intent intent = new Intent(view.getContext(), TestKtActivity.class);
        view.getContext().startActivity(intent);
    }
}
