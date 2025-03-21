package br.app.risetech.tools.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

    }

    public static String safeToUpperCase(Object value) {
        if (value == null) {
            return "";
        }
        return value.toString().toUpperCase();
    }


    public static String ensureNonEmpty(Object value) {
        if (value == null || value.toString().trim().isEmpty()) {
            return "";
        }
        return safeToUpperCase(value.toString());
    }

    public static String currentDate() {
        try {
            SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = targetFormat.format(new Date());

            return formatDate(formattedDate);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String formatDate(String dateStr) {
        return formatDate(dateStr, Locale.getDefault().toString());
    }

    public static String formatDate(String dateStr, String localeStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(dateStr);

            String[] parts = localeStr.split("_");
            Locale locale;

            if (parts.length == 2) {
                locale = new Locale(parts[0], parts[1]);
            } else {
                locale = new Locale(localeStr);
            }

            DateFormat outputFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);

            return ensureNonEmpty(outputFormat.format(date));
        } catch (Exception e) {
            return ensureNonEmpty(dateStr);
        }
    }

    public static String translator(String key, ResourceBundle bundle) {
        if (bundle == null) {
            return ensureNonEmpty(key);
        }

        try {

            Enumeration<String> keys = bundle.getKeys();

            if (bundle.containsKey(key)) {
                return bundle.getString(key);
            } else {
                return ensureNonEmpty(key);
            }

        } catch (Exception e) {
            return ensureNonEmpty(key);
        }
    }

}