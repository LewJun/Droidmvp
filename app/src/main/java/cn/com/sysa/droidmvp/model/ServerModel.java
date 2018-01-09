package cn.com.sysa.droidmvp.model;

import java.io.Serializable;

public class ServerModel implements Serializable {
    private static final long serialVersionUID = -828322761336296999L;

    public String method;
    public String ip;
    public String url;
    public String des;
    public String upload;
    public Author author;

    @Override
    public String toString() {
        return "ServerModel{\n" +//
                "\t method='" + method + "\'\n" +//
                "\t ip='" + ip + "\'\n" +//
                "\t url='" + url + "\'\n" +//
                "\t des='" + des + "\'\n" +//
                "\t upload='" + upload + "\'\n" +//
                "\t author=" + author + "\n" +//
                '}';
    }
}
