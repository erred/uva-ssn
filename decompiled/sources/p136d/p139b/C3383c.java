package p136d.p139b;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: d.b.c */
/* compiled from: Field */
public @interface C3383c {
    /* renamed from: a */
    String mo28211a();

    /* renamed from: b */
    boolean mo28212b() default false;
}