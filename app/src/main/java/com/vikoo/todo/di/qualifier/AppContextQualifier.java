package com.vikoo.todo.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by vikoo on 14/11/17.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface AppContextQualifier {
}
