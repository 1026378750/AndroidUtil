package com.zxin.router.template;

/**
 * Interface that help to generate param class.
 * <p>
 * Created by zxin on 2017/6/15.
 */
public interface ParamInjector {
    /**
     * Inject params.
     *
     * @param obj Activity or fragment instance.
     */
    void inject(Object obj);
}
