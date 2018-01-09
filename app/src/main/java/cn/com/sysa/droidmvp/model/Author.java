package cn.com.sysa.droidmvp.model;

import java.io.Serializable;

/**
 * Created by LewJun on 2018/1/10.
 */
public class Author implements Serializable {
    private static final long serialVersionUID = 2701611773813762723L;

    public String name;
    public String fullname;
    public String github;
    public String address;
    public String qq;
    public String email;
    public String des;

    @Override
    public String toString() {
        return "Author{\n" +//
                "\t name='" + name + "\'\n" +//
                "\t fullname='" + fullname + "\'\n" +//
                "\t github='" + github + "\'\n" +//
                "\t address='" + address + "\'\n" +//
                "\t qq='" + qq + "\'\n" +//
                "\t email='" + email + "\'\n" +//
                "\t des='" + des + "\'\n" +//
                '}';
    }
}
