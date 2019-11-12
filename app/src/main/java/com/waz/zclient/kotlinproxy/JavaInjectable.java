package com.waz.zclient.kotlinproxy;

public interface JavaInjectable {
    <T> T inject(final Class<T> clazz);
}
