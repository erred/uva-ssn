package com.j256.simplemagic.entries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MagicFormatter {
    public static final String FINAL_PATTERN_CHARS = "%bcdeEfFgGiosuxX";
    private static final Pattern FORMAT_PATTERN = Pattern.compile("([^%]*)(%[-+0-9# .lqh]*[%bcdeEfFgGiosuxX])?(.*)");
    public static final String PATTERN_MODIFIERS = "lqh";
    private final PercentExpression percentExpression;
    private final String prefix;
    private final String suffix;

    public MagicFormatter(String str) {
        Matcher matcher = FORMAT_PATTERN.matcher(str);
        if (!matcher.matches()) {
            this.prefix = str;
            this.percentExpression = null;
            this.suffix = null;
            return;
        }
        String group = matcher.group(1);
        String group2 = matcher.group(2);
        String group3 = matcher.group(3);
        if (group2 == null || !group2.equals("%%")) {
            if (group == null || group.length() == 0) {
                this.prefix = null;
            } else {
                this.prefix = group;
            }
            if (group2 == null || group2.length() == 0) {
                this.percentExpression = null;
            } else {
                this.percentExpression = new PercentExpression(group2);
            }
            if (group3 == null || group3.length() == 0) {
                this.suffix = null;
            } else {
                this.suffix = group3.replace("%%", "%");
            }
            return;
        }
        MagicFormatter magicFormatter = new MagicFormatter(group3);
        StringBuilder sb = new StringBuilder();
        if (group != null) {
            sb.append(group);
        }
        sb.append('%');
        if (magicFormatter.prefix != null) {
            sb.append(magicFormatter.prefix);
        }
        this.prefix = sb.toString();
        this.percentExpression = magicFormatter.percentExpression;
        this.suffix = magicFormatter.suffix;
    }

    public void format(StringBuilder sb, Object obj) {
        if (this.prefix != null) {
            sb.append(this.prefix);
        }
        if (!(this.percentExpression == null || obj == null)) {
            this.percentExpression.append(obj, sb);
        }
        if (this.suffix != null) {
            sb.append(this.suffix);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.prefix != null) {
            sb.append(this.prefix);
        }
        if (this.percentExpression != null) {
            sb.append(this.percentExpression);
        }
        if (this.suffix != null) {
            sb.append(this.suffix);
        }
        return sb.toString();
    }
}
