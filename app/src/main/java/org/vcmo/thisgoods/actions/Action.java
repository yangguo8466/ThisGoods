package org.vcmo.thisgoods.actions;

/**
 * Created by Jie on 2016-05-05.
 */
public class Action<T> {
    private final String type;
    private final T data;

    public Action(String type, T data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public T getData() {
        return data;
    }
}
