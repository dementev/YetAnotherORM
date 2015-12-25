package orm.annotations

import orm.DataHandler

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface CrudField {

    String columnName()
    Class dataHandler() default  DataHandler.NoHandler.class
    boolean pk() default false

}