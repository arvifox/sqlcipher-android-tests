package net.zetetic.tests.support;

import net.sqlcipher.database.SQLiteDatabase;
import net.zetetic.QueryHelper;
import net.zetetic.tests.SQLCipherTest;

public class VerifyCipherProviderTest extends SupportTest {

    @Override
    public boolean execute(SQLiteDatabase database) {
        String provider = QueryHelper.singleValueFromQuery(database,
                "PRAGMA cipher_provider;");
        setMessage(String.format("Reported:%s", provider));
        return provider.contains("openssl");
    }

    @Override
    public String getName() {
        return "Verify Cipher Provider Test";
    }
}
