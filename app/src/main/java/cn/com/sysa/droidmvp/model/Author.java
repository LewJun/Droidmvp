package cn.com.sysa.droidmvp.model;

import org.litepal.annotation.Column;

import java.io.Serializable;

/**
 * Created by LewJun on 2018/1/10.
 */
public class Author extends BaseModel implements Serializable {
    private static final long serialVersionUID = 2701611773813762723L;

    public String name;
    public String fullname;
    public String github;
    public String address;
    public String qq;
    public String email;
    @Column(ignore = true) // 忽略该字段
    public String des;

    public Author() {
    }

    public Author(String name, String fullname, String github, String address, String qq, String email, String des) {
        this.name = name;
        this.fullname = fullname;
        this.github = github;
        this.address = address;
        this.qq = qq;
        this.email = email;
        this.des = des;
    }

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
