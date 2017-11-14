package com.vikoo.todo.base;

import com.vikoo.todo.di.component.ApplicationComponent;

/**
 * Created by vikoo on 14/11/17.
 */

public interface BasePresenter<T> {

    void attach(T view, ApplicationComponent applicationComponent);
    void detach();

}
