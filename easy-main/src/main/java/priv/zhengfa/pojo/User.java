package priv.zhengfa.pojo;


/**
 * @Author: nullWagesException
 * @Date: 2020-11-08 11:07
 * @Description:
 */
public class User {

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
