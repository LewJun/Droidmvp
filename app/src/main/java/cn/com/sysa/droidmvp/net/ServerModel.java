package cn.com.sysa.droidmvp.net;

import java.io.Serializable;

public class ServerModel implements Serializable {
    private static final long serialVersionUID = -828322761336296999L;

    private String method;
    private String ip;
    private String url;
    private String des;
    private String upload;
    private Author author;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public class Author implements Serializable {
        private static final long serialVersionUID = 2701611773813762723L;

        private String name;
        private String fullname;
        private String github;
        private String address;
        private String qq;
        private String email;
        private String des;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getGithub() {
            return github;
        }

        public void setGithub(String github) {
            this.github = github;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
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
