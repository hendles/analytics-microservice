package app.lunapos.utils;

import java.sql.Timestamp;
import java.util.*;

public class BasicUtil {
    public BasicUtil() {
    }

    public static List<Map<String, Object>> createListOfMapFromArray(List<Object[]> list, String... columnNames) throws Exception {
        if (list == null) {
            return new ArrayList();
        } else if (list.size() > 0 && ((Object[])list.get(0)).length > columnNames.length) {
            throw new Exception("Invalid Argument");
        } else {
            List<Map<String, Object>> result = new ArrayList();
            Iterator var3 = list.iterator();

            while(var3.hasNext()) {
                Object[] item = (Object[])var3.next();
                Map<String, Object> temp = new HashMap();

                for(int i = 0; i < columnNames.length; ++i) {
                    if (item[i] instanceof Timestamp) {
                        temp.put(columnNames[i], DateUtil.convertFromLocalDateTimeToString(((Timestamp)item[i]).toLocalDateTime()));
                    } else {
                        temp.put(columnNames[i], item[i]);
                    }
                }

                result.add(temp);
            }

            return result;
        }
    }

    public static boolean validateCustomId(List<String> keys, Map<String, Object> customId) {
        boolean isAuthorized = true;
        Iterator var3 = keys.iterator();

        while(var3.hasNext()) {
            String key = (String)var3.next();
            if (customId.get(key) == null) {
                isAuthorized = false;
            }
        }

        return isAuthorized;
    }
}
