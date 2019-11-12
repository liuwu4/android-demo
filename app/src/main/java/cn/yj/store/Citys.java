package cn.yj.store;

/**
 * @author: Administrator
 * 2019/11/12
 * description:
 */
public class Citys {
    private int id;
    private String name;

    public Citys(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
