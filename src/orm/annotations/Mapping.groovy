package orm.annotations

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Mapping {
    Class type()
    //delimeter used to separate entities in the result set. if we found delimeter, than entity fields is over.
    String delimeter() default ":"
    collection[] collections() default []
    association[] associations() default []
}