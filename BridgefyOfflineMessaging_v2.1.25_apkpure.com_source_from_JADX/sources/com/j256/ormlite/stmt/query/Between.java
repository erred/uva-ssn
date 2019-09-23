package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class Between extends BaseComparison {
    private Object high;
    private Object low;

    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) throws SQLException {
        super.appendSql(databaseType, str, sb, list);
    }

    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public Between(String str, FieldType fieldType, Object obj, Object obj2) throws SQLException {
        super(str, fieldType, null, true);
        this.low = obj;
        this.high = obj2;
    }

    public void appendOperation(StringBuilder sb) {
        sb.append("BETWEEN ");
    }

    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        if (this.low == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BETWEEN low value for '");
            sb2.append(this.columnName);
            sb2.append("' is null");
            throw new IllegalArgumentException(sb2.toString());
        } else if (this.high != null) {
            DatabaseType databaseType2 = databaseType;
            StringBuilder sb3 = sb;
            List<ArgumentHolder> list2 = list;
            appendArgOrValue(databaseType2, this.fieldType, sb3, list2, this.low);
            sb.append("AND ");
            appendArgOrValue(databaseType2, this.fieldType, sb3, list2, this.high);
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("BETWEEN high value for '");
            sb4.append(this.columnName);
            sb4.append("' is null");
            throw new IllegalArgumentException(sb4.toString());
        }
    }
}
