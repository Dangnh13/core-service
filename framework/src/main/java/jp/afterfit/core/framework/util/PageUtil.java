package jp.afterfit.core.framework.util;

import jp.afterfit.core.framework.constant.CommonConstant;

public class PageUtil {


    private PageUtil() {
    }

    public static final int getOffsetPage(Integer offsetPage) {
        if (offsetPage == null)
            return CommonConstant.PAGING.PAGE_OFFSET_DEFAULT;
        return offsetPage;
    }


}
