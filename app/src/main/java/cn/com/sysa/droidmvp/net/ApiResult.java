package cn.com.sysa.droidmvp.net;

/**
 * Created by LewJun on 2018/01/05.
 */
public class ApiResult<T> {
    public int code;

    public String msg;

    public T data;

    @Override
    public String toString() {
        return "ApiResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
