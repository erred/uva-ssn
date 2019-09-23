package p136d.p139b;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: d.b.t */
/* compiled from: Query */
public @interface C3400t {
    /* renamed from: a */
    String mo28230a();

    /* renamed from: b */
    boolean mo28231b() default false;
}
