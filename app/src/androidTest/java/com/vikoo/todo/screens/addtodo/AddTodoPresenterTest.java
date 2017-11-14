package com.vikoo.todo.screens.addtodo;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.vikoo.todo.db.AppDatabase;
import com.vikoo.todo.db.entity.TodoEntity;
import com.vikoo.todo.di.component.ApplicationComponent;
import com.vikoo.todo.screens.addtodo.AddTodoContract;
import com.vikoo.todo.screens.addtodo.AddTodoPresenter;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vikoo on 14/11/17.
 */
@RunWith(AndroidJUnit4.class)
public class AddTodoPresenterTest {

    private AppDatabase mDb;
    private AddTodoPresenter mAddEventPresenter;

    @Mock
    ApplicationComponent mApplicationComponent;
    @Mock
    AddTodoContract.View mView;

    @Before
    public void initDb() throws Exception {
        MockitoAnnotations.initMocks(this);
        mAddEventPresenter = new AddTodoPresenter();
        mDb = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getTargetContext(), AppDatabase.class)
                .build();

        when(mApplicationComponent.getDatabase()).thenReturn(mDb);
        mAddEventPresenter.attach(mView, mApplicationComponent);

    }

    @After
    public void closeDb(){
        mDb.close();
    }

    @Test
    public void addEvent_validArgs() throws Exception {
        List<TodoEntity> list = mDb.getTodoListDao().getAllEvents();
        int before = list.size();
        mAddEventPresenter.validate("test", "test");
        list = mDb.getTodoListDao().getAllEvents();
        int after = list.size();
        Assert.assertTrue(after > before);
    }

    @Test
    public void addEvent_invalidArgsTitle() throws Exception {
        List<TodoEntity> list = mDb.getTodoListDao().getAllEvents();
        int before = list.size();
        mAddEventPresenter.validate("", "test");
        list = mDb.getTodoListDao().getAllEvents();
        int after = list.size();
        Assert.assertTrue(after == before);
    }

    @Test
    public void addEvent_invalidArgsDesc() throws Exception {
        List<TodoEntity> list = mDb.getTodoListDao().getAllEvents();
        int before = list.size();
        mAddEventPresenter.validate("Test", "");
        list = mDb.getTodoListDao().getAllEvents();
        int after = list.size();
        Assert.assertTrue(after == before);
    }

    @Test
    public void addEvent() throws Exception {
        mAddEventPresenter.validate("test", "test");
        verify(mView).onTodoAdded();
    }

    @Test
    public void addEvent_error() throws Exception {
        mAddEventPresenter.validate("", "test");
        verify(mView, never()).onTodoAdded();
    }

}