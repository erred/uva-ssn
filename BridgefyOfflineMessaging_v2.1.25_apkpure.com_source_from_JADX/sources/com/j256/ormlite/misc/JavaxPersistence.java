package com.j256.ormlite.misc;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataPersisterManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.p127db.DatabaseType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Collection;

public class JavaxPersistence {
    public static DatabaseFieldConfig createFieldConfig(DatabaseType databaseType, Field field) throws SQLException {
        Annotation[] annotations;
        Field field2 = field;
        Annotation annotation = null;
        Annotation annotation2 = null;
        Annotation annotation3 = null;
        Annotation annotation4 = null;
        Annotation annotation5 = null;
        Annotation annotation6 = null;
        Annotation annotation7 = null;
        Annotation annotation8 = null;
        Annotation annotation9 = null;
        for (Annotation annotation10 : field.getAnnotations()) {
            Class annotationType = annotation10.annotationType();
            if (annotationType.getName().equals("javax.persistence.Column")) {
                annotation = annotation10;
            }
            if (annotationType.getName().equals("javax.persistence.Basic")) {
                annotation2 = annotation10;
            }
            if (annotationType.getName().equals("javax.persistence.Id")) {
                annotation3 = annotation10;
            }
            if (annotationType.getName().equals("javax.persistence.GeneratedValue")) {
                annotation8 = annotation10;
            }
            if (annotationType.getName().equals("javax.persistence.OneToOne")) {
                annotation4 = annotation10;
            }
            if (annotationType.getName().equals("javax.persistence.ManyToOne")) {
                annotation5 = annotation10;
            }
            if (annotationType.getName().equals("javax.persistence.JoinColumn")) {
                annotation9 = annotation10;
            }
            if (annotationType.getName().equals("javax.persistence.Enumerated")) {
                annotation6 = annotation10;
            }
            if (annotationType.getName().equals("javax.persistence.Version")) {
                annotation7 = annotation10;
            }
        }
        if (annotation == null && annotation2 == null && annotation3 == null && annotation4 == null && annotation5 == null && annotation6 == null && annotation7 == null) {
            return null;
        }
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
        String name = field.getName();
        if (databaseType.isEntityNamesMustBeUpCase()) {
            name = name.toUpperCase();
        }
        databaseFieldConfig.setFieldName(name);
        if (annotation != null) {
            try {
                String str = (String) annotation.getClass().getMethod("name", new Class[0]).invoke(annotation, new Object[0]);
                if (str != null && str.length() > 0) {
                    databaseFieldConfig.setColumnName(str);
                }
                String str2 = (String) annotation.getClass().getMethod("columnDefinition", new Class[0]).invoke(annotation, new Object[0]);
                if (str2 != null && str2.length() > 0) {
                    databaseFieldConfig.setColumnDefinition(str2);
                }
                databaseFieldConfig.setWidth(((Integer) annotation.getClass().getMethod("length", new Class[0]).invoke(annotation, new Object[0])).intValue());
                Boolean bool = (Boolean) annotation.getClass().getMethod("nullable", new Class[0]).invoke(annotation, new Object[0]);
                if (bool != null) {
                    databaseFieldConfig.setCanBeNull(bool.booleanValue());
                }
                Boolean bool2 = (Boolean) annotation.getClass().getMethod("unique", new Class[0]).invoke(annotation, new Object[0]);
                if (bool2 != null) {
                    databaseFieldConfig.setUnique(bool2.booleanValue());
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Problem accessing fields from the @Column annotation for field ");
                sb.append(field2);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        }
        if (annotation2 != null) {
            try {
                Boolean bool3 = (Boolean) annotation2.getClass().getMethod("optional", new Class[0]).invoke(annotation2, new Object[0]);
                if (bool3 == null) {
                    databaseFieldConfig.setCanBeNull(true);
                } else {
                    databaseFieldConfig.setCanBeNull(bool3.booleanValue());
                }
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Problem accessing fields from the @Basic annotation for field ");
                sb2.append(field2);
                throw SqlExceptionUtil.create(sb2.toString(), e2);
            }
        }
        if (annotation3 != null) {
            if (annotation8 == null) {
                databaseFieldConfig.setId(true);
            } else {
                databaseFieldConfig.setGeneratedId(true);
            }
        }
        if (!(annotation4 == null && annotation5 == null)) {
            if (Collection.class.isAssignableFrom(field.getType()) || ForeignCollection.class.isAssignableFrom(field.getType())) {
                databaseFieldConfig.setForeignCollection(true);
                if (annotation9 != null) {
                    try {
                        String str3 = (String) annotation9.getClass().getMethod("name", new Class[0]).invoke(annotation9, new Object[0]);
                        if (str3 != null && str3.length() > 0) {
                            databaseFieldConfig.setForeignCollectionColumnName(str3);
                        }
                        Object invoke = annotation9.getClass().getMethod("fetch", new Class[0]).invoke(annotation9, new Object[0]);
                        if (invoke != null && invoke.toString().equals("EAGER")) {
                            databaseFieldConfig.setForeignCollectionEager(true);
                        }
                    } catch (Exception e3) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Problem accessing fields from the @JoinColumn annotation for field ");
                        sb3.append(field2);
                        throw SqlExceptionUtil.create(sb3.toString(), e3);
                    }
                }
            } else {
                databaseFieldConfig.setForeign(true);
                if (annotation9 != null) {
                    try {
                        String str4 = (String) annotation9.getClass().getMethod("name", new Class[0]).invoke(annotation9, new Object[0]);
                        if (str4 != null && str4.length() > 0) {
                            databaseFieldConfig.setColumnName(str4);
                        }
                        Boolean bool4 = (Boolean) annotation9.getClass().getMethod("nullable", new Class[0]).invoke(annotation9, new Object[0]);
                        if (bool4 != null) {
                            databaseFieldConfig.setCanBeNull(bool4.booleanValue());
                        }
                        Boolean bool5 = (Boolean) annotation9.getClass().getMethod("unique", new Class[0]).invoke(annotation9, new Object[0]);
                        if (bool5 != null) {
                            databaseFieldConfig.setUnique(bool5.booleanValue());
                        }
                    } catch (Exception e4) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Problem accessing fields from the @JoinColumn annotation for field ");
                        sb4.append(field2);
                        throw SqlExceptionUtil.create(sb4.toString(), e4);
                    }
                }
            }
        }
        if (annotation6 != null) {
            try {
                Object invoke2 = annotation6.getClass().getMethod(Param.VALUE, new Class[0]).invoke(annotation6, new Object[0]);
                if (invoke2 == null || !invoke2.toString().equals("STRING")) {
                    databaseFieldConfig.setDataType(DataType.ENUM_INTEGER);
                } else {
                    databaseFieldConfig.setDataType(DataType.ENUM_STRING);
                }
            } catch (Exception e5) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Problem accessing fields from the @Enumerated annotation for field ");
                sb5.append(field2);
                throw SqlExceptionUtil.create(sb5.toString(), e5);
            }
        }
        if (annotation7 != null) {
            databaseFieldConfig.setVersion(true);
        }
        if (databaseFieldConfig.getDataPersister() == null) {
            databaseFieldConfig.setDataPersister(DataPersisterManager.lookupForField(field));
        }
        boolean z = false;
        if (!(DatabaseFieldConfig.findGetMethod(field2, false) == null || DatabaseFieldConfig.findSetMethod(field2, false) == null)) {
            z = true;
        }
        databaseFieldConfig.setUseGetSet(z);
        return databaseFieldConfig;
    }

    public static String getEntityName(Class<?> cls) {
        Annotation[] annotations;
        Annotation annotation = null;
        for (Annotation annotation2 : cls.getAnnotations()) {
            if (annotation2.annotationType().getName().equals("javax.persistence.Entity")) {
                annotation = annotation2;
            }
        }
        if (annotation == null) {
            return null;
        }
        try {
            String str = (String) annotation.getClass().getMethod("name", new Class[0]).invoke(annotation, new Object[0]);
            if (str == null || str.length() <= 0) {
                return null;
            }
            return str;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not get entity name from class ");
            sb.append(cls);
            throw new IllegalStateException(sb.toString(), e);
        }
    }
}
