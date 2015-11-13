package maraudersmap.takenet.com.br.maraudersmap.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.LinkedList;
import java.util.List;

import maraudersmap.takenet.com.br.maraudersmap.MaraudersMapApplication;

public class ProfileUtil {

    public static String getName() {
        AccountManager manager = AccountManager.get(MaraudersMapApplication.getContext());
        Account[] accounts = manager.getAccountsByType("com.google");
        List<String> possibleEmails = new LinkedList<String>();

        for (Account account : accounts) {
            // TODO: Check possibleEmail against an email regex or treat
            // account.name as an email address only for certain account.type values.
            possibleEmails.add(account.name);
        }

        if (!possibleEmails.isEmpty() && possibleEmails.get(0) != null) {
            String email = possibleEmails.get(0);
            String[] parts = email.split("@");

            if (parts.length > 1)
                return parts[0];
        }
        return null;
    }

}
