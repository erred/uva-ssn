package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public class DateType extends BaseDateType {
    private static final DateType singleTon = new DateType();

    public boolean isArgumentHolderRequired() {
        return true;
    }

    public static DateType getSingleton() {
        return singleTon;
    }

    private DateType() {
        super(SqlType.DATE, new Class[]{Date.class});
    }

    protected DateType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        DateStringFormatConfig convertDateStringConfig = convertDateStringConfig(fieldType, getDefaultDateFormatConfig());
        try {
            return new Timestamp(parseDateString(convertDateStringConfig, str).getTime());
        } catch (ParseException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Problems parsing default date string '");
            sb.append(str);
            sb.append("' using '");
            sb.append(convertDateStringConfig);
            sb.append('\'');
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getTimestamp(i);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        return new Date(((Timestamp) obj).getTime());
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return new Timestamp(((Date) obj).getTime());
    }

    /* access modifiers changed from: protected */
    public DateStringFormatConfig getDefaultDateFormatConfig() {
        return defaultDateFormatConfig;
    }
}