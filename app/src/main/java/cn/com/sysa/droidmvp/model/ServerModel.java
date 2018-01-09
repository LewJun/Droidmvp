package cn.com.sysa.droidmvp.model;

import java.io.Serializable;

public class ServerModel extends BaseModel implements Serializable {
    private static final long serialVersionUID = -828322761336296999L;

    public String method;
    public String ip;
    public String url;
    public String des;
    public String upload;
    public Author author;

    public ServerModel() {
    }

    public ServerModel(String method, String ip, String url, String des, String upload, Author author) {
        this.method = method;
        this.ip = ip;
        this.url = url;
        this.des = des;
        this.upload = upload;
        this.author = author;
    }

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
