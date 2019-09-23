package com.j256.ormlite.p127db;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;

/* renamed from: com.j256.ormlite.db.BaseDatabaseType */
public abstract class BaseDatabaseType implements DatabaseType {
    protected static String DEFAULT_SEQUENCE_SUFFIX = "_id_seq";
    protected Driver driver;

    /* renamed from: com.j256.ormlite.db.BaseDatabaseType$BooleanNumberFieldConverter */
    protected static class BooleanNumberFieldConverter extends BaseFieldConverter {
        protected BooleanNumberFieldConverter() {
        }

        public SqlType getSqlType() {
            return SqlType.BOOLEAN;
        }

        public Object parseDefaultString(FieldType fieldType, String str) {
            byte b;
            if (Boolean.parseBoolean(str)) {
                b = 1;
            } else {
                b = 0;
            }
            return Byte.valueOf(b);
        }

        public Object javaToSqlArg(FieldType fieldType, Object obj) {
            return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
        }

        public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
            return Byte.valueOf(databaseResults.getByte(i));
        }

        public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
            return ((Byte) obj).byteValue() == 1 ? Boolean.valueOf(true) : Boolean.valueOf(false);
        }

        public Object resultStringToJava(FieldType fieldType, String str, int i) {
            return sqlArgToJava(fieldType, Byte.valueOf(Byte.parseByte(str)), i);
        }
    }

    private void appendCanBeNull(StringBuilder sb, FieldType fieldType) {
    }

    public void appendCreateTableSuffix(StringBuilder sb) {
    }

    public void appendSelectNextValFromSequence(StringBuilder sb, String str) {
    }

    /* access modifiers changed from: protected */
    public void configureId(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3) {
    }

    public void dropColumnArg(FieldType fieldType, List<String> list, List<String> list2) {
    }

    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean generatedIdSqlAtEnd() {
        return true;
    }

    public String getCommentLinePrefix() {
        return "-- ";
    }

    /* access modifiers changed from: protected */
    public abstract String getDriverClassName();

    public FieldConverter getFieldConverter(DataPersister dataPersister) {
        return dataPersister;
    }

    public String getPingStatement() {
        return "SELECT 1";
    }

    public boolean isAllowGeneratedIdInsertSupported() {
        return true;
    }

    public boolean isBatchUseTransaction() {
        return false;
    }

    public boolean isCreateIfNotExistsSupported() {
        return false;
    }

    public boolean isCreateTableReturnsNegative() {
        return false;
    }

    public boolean isCreateTableReturnsZero() {
        return true;
    }

    public boolean isEntityNamesMustBeUpCase() {
        return false;
    }

    public boolean isIdSequenceNeeded() {
        return false;
    }

    public boolean isLimitAfterSelect() {
        return false;
    }

    public boolean isLimitSqlSupported() {
        return true;
    }

    public boolean isNestedSavePointsSupported() {
        return true;
    }

    public boolean isOffsetLimitArgument() {
        return false;
    }

    public boolean isOffsetSqlSupported() {
        return true;
    }

    public boolean isSelectSequenceBeforeInsert() {
        return false;
    }

    public boolean isTruncateSupported() {
        return false;
    }

    public boolean isVarcharFieldWidthSupported() {
        return true;
    }

    public void loadDriver() throws SQLException {
        String driverClassName = getDriverClassName();
        if (driverClassName != null) {
            try {
                Class.forName(driverClassName);
            } catch (ClassNotFoundException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Driver class was not found for ");
                sb.append(getDatabaseName());
                sb.append(" database.  Missing jar with class ");
                sb.append(driverClassName);
                sb.append(".");
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        }
    }

    public void setDriver(Driver driver2) {
        this.driver = driver2;
    }

    public void appendColumnArg(String str, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) throws SQLException {
        StringBuilder sb2 = sb;
        FieldType fieldType2 = fieldType;
        appendEscapedEntityName(sb, fieldType.getColumnName());
        sb.append(' ');
        DataPersister dataPersister = fieldType.getDataPersister();
        int width = fieldType.getWidth();
        if (width == 0) {
            width = dataPersister.getDefaultWidth();
        }
        switch (dataPersister.getSqlType()) {
            case STRING:
                appendStringType(sb, fieldType, width);
                break;
            case LONG_STRING:
                appendLongStringType(sb, fieldType, width);
                break;
            case BOOLEAN:
                appendBooleanType(sb, fieldType, width);
                break;
            case DATE:
                appendDateType(sb, fieldType, width);
                break;
            case CHAR:
                appendCharType(sb, fieldType, width);
                break;
            case BYTE:
                appendByteType(sb, fieldType, width);
                break;
            case BYTE_ARRAY:
                appendByteArrayType(sb, fieldType, width);
                break;
            case SHORT:
                appendShortType(sb, fieldType, width);
                break;
            case INTEGER:
                appendIntegerType(sb, fieldType, width);
                break;
            case LONG:
                appendLongType(sb, fieldType, width);
                break;
            case FLOAT:
                appendFloatType(sb, fieldType, width);
                break;
            case DOUBLE:
                appendDoubleType(sb, fieldType, width);
                break;
            case SERIALIZABLE:
                appendSerializableType(sb, fieldType, width);
                break;
            case BIG_DECIMAL:
                appendBigDecimalNumericType(sb, fieldType, width);
                break;
            default:
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unknown SQL-type ");
                sb3.append(dataPersister.getSqlType());
                throw new IllegalArgumentException(sb3.toString());
        }
        sb.append(' ');
        if (fieldType.isGeneratedIdSequence() && !fieldType.isSelfGeneratedId()) {
            configureGeneratedIdSequence(sb, fieldType, list2, list, list4);
        } else if (fieldType.isGeneratedId() && !fieldType.isSelfGeneratedId()) {
            configureGeneratedId(str, sb, fieldType, list2, list3, list, list4);
        } else if (fieldType.isId()) {
            configureId(sb, fieldType, list2, list, list4);
        }
        if (!fieldType.isGeneratedId()) {
            Object defaultValue = fieldType.getDefaultValue();
            if (defaultValue != null) {
                sb.append("DEFAULT ");
                appendDefaultValue(sb, fieldType, defaultValue);
                sb.append(' ');
            }
            if (fieldType.isCanBeNull()) {
                appendCanBeNull(sb, fieldType);
            } else {
                sb.append("NOT NULL ");
            }
            if (fieldType.isUnique()) {
                addSingleUnique(sb, fieldType, list, list3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void appendStringType(StringBuilder sb, FieldType fieldType, int i) {
        if (isVarcharFieldWidthSupported()) {
            sb.append("VARCHAR(");
            sb.append(i);
            sb.append(")");
            return;
        }
        sb.append("VARCHAR");
    }

    /* access modifiers changed from: protected */
    public void appendLongStringType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("TEXT");
    }

    /* access modifiers changed from: protected */
    public void appendDateType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("TIMESTAMP");
    }

    /* access modifiers changed from: protected */
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("BOOLEAN");
    }

    /* access modifiers changed from: protected */
    public void appendCharType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("CHAR");
    }

    /* access modifiers changed from: protected */
    public void appendByteType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("TINYINT");
    }

    /* access modifiers changed from: protected */
    public void appendShortType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("SMALLINT");
    }

    private void appendIntegerType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("INTEGER");
    }

    /* access modifiers changed from: protected */
    public void appendLongType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("BIGINT");
    }

    private void appendFloatType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("FLOAT");
    }

    private void appendDoubleType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("DOUBLE PRECISION");
    }

    /* access modifiers changed from: protected */
    public void appendByteArrayType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("BLOB");
    }

    /* access modifiers changed from: protected */
    public void appendSerializableType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("BLOB");
    }

    /* access modifiers changed from: protected */
    public void appendBigDecimalNumericType(StringBuilder sb, FieldType fieldType, int i) {
        sb.append("NUMERIC");
    }

    private void appendDefaultValue(StringBuilder sb, FieldType fieldType, Object obj) {
        if (fieldType.isEscapedDefaultValue()) {
            appendEscapedWord(sb, obj.toString());
        } else {
            sb.append(obj);
        }
    }

    /* access modifiers changed from: protected */
    public void configureGeneratedIdSequence(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3) throws SQLException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GeneratedIdSequence is not supported by database ");
        sb2.append(getDatabaseName());
        sb2.append(" for field ");
        sb2.append(fieldType);
        throw new SQLException(sb2.toString());
    }

    /* access modifiers changed from: protected */
    public void configureGeneratedId(String str, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GeneratedId is not supported by database ");
        sb2.append(getDatabaseName());
        sb2.append(" for field ");
        sb2.append(fieldType);
        throw new IllegalStateException(sb2.toString());
    }

    public void addPrimaryKeySql(FieldType[] fieldTypeArr, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        StringBuilder sb = null;
        for (FieldType fieldType : fieldTypeArr) {
            if ((!fieldType.isGeneratedId() || generatedIdSqlAtEnd() || fieldType.isSelfGeneratedId()) && fieldType.isId()) {
                if (sb == null) {
                    sb = new StringBuilder(48);
                    sb.append("PRIMARY KEY (");
                } else {
                    sb.append(',');
                }
                appendEscapedEntityName(sb, fieldType.getColumnName());
            }
        }
        if (sb != null) {
            sb.append(") ");
            list.add(sb.toString());
        }
    }

    public void addUniqueComboSql(FieldType[] fieldTypeArr, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        StringBuilder sb = null;
        for (FieldType fieldType : fieldTypeArr) {
            if (fieldType.isUniqueCombo()) {
                if (sb == null) {
                    sb = new StringBuilder(48);
                    sb.append("UNIQUE (");
                } else {
                    sb.append(',');
                }
                appendEscapedEntityName(sb, fieldType.getColumnName());
            }
        }
        if (sb != null) {
            sb.append(") ");
            list.add(sb.toString());
        }
    }

    public void appendEscapedWord(StringBuilder sb, String str) {
        sb.append('\'');
        sb.append(str);
        sb.append('\'');
    }

    public void appendEscapedEntityName(StringBuilder sb, String str) {
        sb.append('`');
        sb.append(str);
        sb.append('`');
    }

    public String generateIdSequenceName(String str, FieldType fieldType) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(DEFAULT_SEQUENCE_SUFFIX);
        String sb2 = sb.toString();
        return isEntityNamesMustBeUpCase() ? sb2.toUpperCase() : sb2;
    }

    public void appendLimitValue(StringBuilder sb, long j, Long l) {
        sb.append("LIMIT ");
        sb.append(j);
        sb.append(' ');
    }

    public void appendOffsetValue(StringBuilder sb, long j) {
        sb.append("OFFSET ");
        sb.append(j);
        sb.append(' ');
    }

    public boolean isCreateIndexIfNotExistsSupported() {
        return isCreateIfNotExistsSupported();
    }

    private void addSingleUnique(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" UNIQUE (");
        appendEscapedEntityName(sb2, fieldType.getColumnName());
        sb2.append(")");
        list.add(sb2.toString());
    }
}
