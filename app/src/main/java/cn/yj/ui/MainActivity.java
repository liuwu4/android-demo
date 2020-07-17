package cn.yj.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayMap;

import cn.yj.dao.Person;
import cn.yj.dao.TextBase;
import cn.yj.events.Handles;
import cn.yj.first.R;
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
        addDataBinding();
    }

    private void addDataBinding() {
        dataBindBinding = DataBindingUtil.setContentView(this, R.layout.data_bind_test);
        Person person = new Person("李", "四", 20);
        ObservableArrayMap<String, Object> arrayMap = new ObservableArrayMap<>();
        arrayMap.put("firstName", "Tome");
        arrayMap.put("lastName", "Jonn");
        arrayMap.put("age", 29);
        TextBase textBase = new TextBase();
        textBase.setFirstName("可观察tome");
        dataBindBinding.setTextBase(textBase);
        dataBindBinding.setPerson(person);
        dataBindBinding.setObservable(arrayMap);
        dataBindBinding.setHandlers(new Handles());

    }

    private void addViewBinding() {
        viewBindTestBinding = ViewBindTestBinding.inflate(getLayoutInflater());
        View view = viewBindTestBinding.getRoot();
        setContentView(view);
    }
}
