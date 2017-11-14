package com.vikoo.todo.screens.addtodo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.vikoo.todo.R;
import com.vikoo.todo.TodoApplication;
import com.vikoo.todo.base.BaseActivity;
import com.vikoo.todo.di.component.DaggerActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by vikoo on 14/11/17.
 */

public class AddTodoActivity extends BaseActivity implements AddTodoContract.View{

    @Inject
    AddTodoContract.Presenter mPresenter;

    @BindView(R.id.input_layout_title)
    TextInputLayout mIlTitle;

    @BindView(R.id.input_title)
    EditText mEtTitle;

    @BindView(R.id.input_layout_desc)
    TextInputLayout mIlDesc;

    @BindView(R.id.input_desc)
    EditText mEtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        ButterKnife.bind(this);

        setupToolBarWithBack();
        DaggerActivityComponent.builder()
                .applicationComponent(TodoApplication.get(this).getApplicationComponent())
                .build()
                .inject(this);
        mPresenter.attach(this, mApplicationComponent);

    }

    @Override
    public void onValidationFailed(int errorCode) {
        switch (errorCode){
            case AddTodoPresenter.ERROR_TITLE:
                mIlTitle.setError(getResources().getString(R.string.error_todo_title));
                break;
            case AddTodoPresenter.ERROR_DESC:
                mIlDesc.setError(getResources().getString(R.string.error_todo_desc));
                break;
        }
    }

    private void clearErrors(){
        mIlTitle.setError("");
        mIlDesc.setError("");
    }

    @Override
    public void onTodoAdded() {
        Toast.makeText(getApplicationContext(), R.string.todo_add_success, Toast.LENGTH_SHORT).show();
        finish();
    }

    @OnClick({R.id.btn_add_todo})
    public void onAddTodoClick(View view){
        clearErrors();
        mPresenter.validate(mEtTitle.getText().toString(),
                mEtDesc.getText().toString()
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}
