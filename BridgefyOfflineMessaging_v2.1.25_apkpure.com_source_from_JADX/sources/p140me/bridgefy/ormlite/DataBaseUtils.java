package p140me.bridgefy.ormlite;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/* renamed from: me.bridgefy.ormlite.DataBaseUtils */
public class DataBaseUtils {
    private static final String FILENAME = "db_config";
    private static final int PASSWORD_MAX_LENGTH = 128;
    private static final String TAG = "DataBaseUtils";

    public static String persistentDataBaseConfiguration(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BgfyPrefs", 0);
        String string = sharedPreferences.getString("database_password", null);
        String dataBasePassword = getDataBasePassword(context);
        Editor edit = sharedPreferences.edit();
        if (dataBasePassword == null && string == null) {
            String randomPassword = randomPassword();
            setDataBasePassword(context, randomPassword);
            edit.putString("database_password", randomPassword).commit();
            return randomPassword;
        } else if (string != null && dataBasePassword == null) {
            setDataBasePassword(context, string);
            return string;
        } else if (string == null) {
            edit.putString("database_password", dataBasePassword).commit();
            return dataBasePassword;
        } else if (dataBasePassword.equals(string)) {
            return null;
        } else {
            context.deleteFile(FILENAME);
            String path = context.getDatabasePath(DatabaseHelper.DATABASE_NAME).getPath();
            context.deleteDatabase(DatabaseHelper.DATABASE_NAME);
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            String randomPassword2 = randomPassword();
            setDataBasePassword(context, randomPassword2);
            edit.putString("database_password", randomPassword2).commit();
            return randomPassword2;
        }
    }

    private static String randomPassword() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int nextInt = random.nextInt(PASSWORD_MAX_LENGTH);
        for (int i = 0; i < nextInt; i++) {
            sb.append((char) (random.nextInt(96) + 32));
        }
        return sb.toString();
    }

    private static void setDataBasePassword(Context context, String str) {
        try {
            context.openFileInput(FILENAME).close();
        } catch (FileNotFoundException e) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("DataBaseUtils#setDataBasePassword - FileNotFoundException: ");
            sb.append(e.getMessage());
            Log.w(str2, sb.toString());
            try {
                FileOutputStream openFileOutput = context.openFileOutput(FILENAME, 0);
                openFileOutput.write(str.getBytes());
                openFileOutput.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private static String getDataBasePassword(Context context) {
        String str = "";
        try {
            FileInputStream openFileInput = context.openFileInput(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(readLine);
                str = sb.toString();
            }
            bufferedReader.close();
            openFileInput.close();
            try {
                Log.v(TAG, "Database password success");
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
                String str2 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("DataBaseUtils#getDataBasePassword - IOException: ");
                sb2.append(e.getMessage());
                Log.w(str2, sb2.toString());
                return str;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            str = null;
            String str3 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("DataBaseUtils#getDataBasePassword - FileNotFoundException: ");
            sb3.append(e.getMessage());
            Log.w(str3, sb3.toString());
            return str;
        } catch (IOException e4) {
            e = e4;
            str = null;
            String str22 = TAG;
            StringBuilder sb22 = new StringBuilder();
            sb22.append("DataBaseUtils#getDataBasePassword - IOException: ");
            sb22.append(e.getMessage());
            Log.w(str22, sb22.toString());
            return str;
        }
        return str;
    }

    public static boolean dropDataBase(Context context) {
        Log.w(TAG, "DataBaseUtils#dropDataBase ");
        String path = context.getDatabasePath(DatabaseHelper.DATABASE_NAME).getPath();
        context.deleteDatabase(DatabaseHelper.DATABASE_NAME);
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        return file.exists();
    }

    public static void resetDataBase(DatabaseHelper databaseHelper) {
        databaseHelper.clearDataBase();
    }
}
