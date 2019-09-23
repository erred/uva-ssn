package p136d.p139b;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: d.b.s */
/* compiled from: Path */
public @interface C3399s {
    /* renamed from: a */
    String mo28228a();

    /* renamed from: b */
    boolean mo28229b() default false;
}
