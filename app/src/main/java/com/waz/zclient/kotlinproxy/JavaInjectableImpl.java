package com.waz.zclient.kotlinproxy;

import scala.reflect.AnyValManifest;

public class JavaInjectableImpl extends InjectorOwner implements JavaInjectable {
    public <T> T inject(final Class<T> clazz) {
        return injector.apply(new AnyValManifest<T>(clazz.getCanonicalName()) {
            @Override
            public Class<?> runtimeClass() {
                return clazz;
            }
        });
    }
}
