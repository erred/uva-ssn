package p136d.p139b;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: d.b.h */
/* compiled from: HTTP */
public @interface C3388h {
    /* renamed from: a */
    String mo28216a();

    /* renamed from: b */
    String mo28217b() default "";

    /* renamed from: c */
    boolean mo28218c() default false;
}
