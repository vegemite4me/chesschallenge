package com.robin.util;

import java.util.Set;

public class CollectionUtils {

    public static boolean containsAnyMatching(Set setA, Set setB) {
        for (Object anItem : setA) {
            if (setB.contains(anItem)) {
                return true;
            }
        }
        return false;
    }

}
