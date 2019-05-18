import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User {
    Double regist_time;
    String userName;

    public User(Double regist_time, String userName) {
        this.regist_time = regist_time;
        this.userName = userName;
    }

    public User() {
    }

    public Double getRegist_time() {
        return regist_time;
    }

    public void setRegist_time(Double regist_time) {
        this.regist_time = regist_time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "regist_time=" + regist_time +
                ", userName='" + userName + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {

        List<User> list1 = new ArrayList<>();
        list1.add(new User(14.00,"zhang"));
        list1.add(new User(16.00,"shan"));
        list1.add(new User(10.00,"li"));
        list1.add(new User(15.00,"wang"));

       // 按注册时间排序
        Collections.sort(list1, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return (int) (o1.getRegist_time() - o2.getRegist_time());
            }
        });
        
        System.out.println(list1.toString());

        //按姓名排序
        Collections.sort(list1, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return  o1.getUserName().compareTo(o2.getUserName());
            }
        });
        System.out.println(list1.toString());
    }


}
