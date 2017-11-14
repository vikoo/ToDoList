package com.vikoo.todo.screens.todolist;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.vikoo.todo.db.AppDatabase;
import com.vikoo.todo.db.entity.TodoEntity;
import com.vikoo.todo.di.component.ApplicationComponent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vikoo on 14/11/17.
 */
@RunWith(AndroidJUnit4.class)
public class TodoListPresenterTest {

    private AppDatabase mDb;
    private TodoListPresenter mAgendaPresenter;
    @Mock
    ApplicationComponent mApplicationComponent;
    @Mock
    TodoListContract.View mView;


    @Before
    public void initDb() throws Exception {
        MockitoAnnotations.initMocks(this);
        mAgendaPresenter = new TodoListPresenter();
        mDb = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getTargetContext(), AppDatabase.class)
                .build();

        when(mApplicationComponent.getDatabase()).thenReturn(mDb);
        mAgendaPresenter.attach(mView, mApplicationComponent);
    }

    @After
    public void closeDb(){
        mDb.close();
    }

    @Test
    public void fetchEvents() throws Exception {
        List<TodoEntity> list = mDb.getTodoListDao().getAllEvents();
        mAgendaPresenter.fetchTodoList();
        verify(mView).showTodos(ArgumentMatchers.<TodoEntity>anyList());
    }

}