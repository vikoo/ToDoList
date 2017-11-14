package com.vikoo.todo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.vikoo.todo.R;
import com.vikoo.todo.TodoApplication;
import com.vikoo.todo.di.component.ApplicationComponent;

import butterknife.BindView;

/**
 * Created by vikoo on 14/11/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    public ApplicationComponent mApplicationComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplicationComponent = TodoApplication.get(this).getApplicationComponent();
    }

    public void setupToolBar(){
        setSupportActionBar(mToolbar);
    }

    public void setupToolBarWithBack(){
        setupToolBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
