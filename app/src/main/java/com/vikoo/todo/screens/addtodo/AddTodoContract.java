package com.vikoo.todo.screens.addtodo;

import com.vikoo.todo.base.BasePresenter;
import com.vikoo.todo.base.BaseView;

/**
 * Created by vikoo on 14/11/17.
 */

public class AddTodoContract {

    public interface View extends BaseView<Presenter>{
        void onValidationFailed(int errorCode);
        void onTodoAdded();
    }

    public interface Presenter extends BasePresenter<View>{
        void validate(String title, String desc);
    }
}
