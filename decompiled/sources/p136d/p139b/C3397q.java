package p136d.p139b;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: d.b.q */
/* compiled from: Part */
public @interface C3397q {
    /* renamed from: a */
    String mo28225a() default "";

    /* renamed from: b */
    String mo28226b() default "binary";
}
