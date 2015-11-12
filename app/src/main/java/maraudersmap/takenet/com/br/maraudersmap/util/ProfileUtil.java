package maraudersmap.takenet.com.br.maraudersmap.util;

import android.database.Cursor;
import android.provider.ContactsContract;

import maraudersmap.takenet.com.br.maraudersmap.MaraudersMapApplication;

public class ProfileUtil {

    public static String getName() {
        Cursor c = MaraudersMapApplication.getContext().getContentResolver().query(ContactsContract.Profile.CONTENT_URI, null, null, null, null);
        c.moveToFirst();
        String nome = c.getString(c.getColumnIndex("display_name"));
        c.close();
        return nome;
    }
}
