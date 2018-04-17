package com.myatejx.ui_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/3/7.
 */

public class TestDataSource {

    private List<ColorEntity> mColorEntities;

    public List<ColorEntity> getColorEntities() {
        if (mColorEntities == null) {
            mColorEntities = new ArrayList<>();
            mColorEntities.add(new ColorEntity("#c4d4eb", "#394353", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#86e3cf", "#2d9a95", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#bdc1e0", "#314053", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#2ed7d4", "#293e67", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#374263", "#31b1b3", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#d4d6e5", "#384065", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#d4d6e5", "#384065", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#97b2e3", "#586489", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#dad1d7", "#3f4550", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#fbcd37", "#274964", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#d1e2f1", "#364a5a", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#fecbde", "#3e3b4c", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#0ce7d1", "#414557", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#a4b5df", "#424966", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#ccc6d0", "#3c3f4f", "To search for a second color", "connect the first one using"));
            mColorEntities.add(new ColorEntity("#364357", "#0cece1", "To search for a second color", "connect the first one using"));
        }
        return mColorEntities;
    }

}
