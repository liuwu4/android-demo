package cn.yj.first;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import cn.yj.dao.Person;
import cn.yj.first.databinding.DataBindTestBinding;
import cn.yj.first.databinding.ViewBindTestBinding;

/**
 * 主页
 *
 * @author yujie
 */
public class MainActivity extends Activity {
    private final static String TAG = MainActivity.class.getName();
    private DataBindTestBinding dataBindBinding;
    private ViewBindTestBinding viewBindTestBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        addViewBinding();
        addDataBinding();
    }

    private void addDataBinding() {
        dataBindBinding = DataBindingUtil.setContentView(this, R.layout.data_bind_test);
        Person person = new Person("李", "四", 20);
        dataBindBinding.setPerson(person);
    }

    private void addViewBinding() {
        viewBindTestBinding = ViewBindTestBinding.inflate(getLayoutInflater());
        View view = viewBindTestBinding.getRoot();
        setContentView(view);
    }
}
