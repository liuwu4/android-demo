package cn.yj.dao;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public  class TestObservable {
    private  final ObservableField<String> firstName = new ObservableField<>();
    private  final ObservableField<String> lastName = new ObservableField<>();
    private  final ObservableInt age = new ObservableInt();
}
