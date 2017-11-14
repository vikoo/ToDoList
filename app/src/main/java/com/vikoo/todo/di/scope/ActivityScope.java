package com.vikoo.todo.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by vikoo on 14/11/17.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface ActivityScope {
}
