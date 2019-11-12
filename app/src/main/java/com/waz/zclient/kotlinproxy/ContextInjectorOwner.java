package com.waz.zclient.kotlinproxy;

import android.content.Context;

import com.waz.zclient.WireContext$;

public class ContextInjectorOwner extends JavaInjectableImpl {

    public ContextInjectorOwner(Context context) {
        injector = WireContext$.MODULE$.apply(context).injector();
    }
}
