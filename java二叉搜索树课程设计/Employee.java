import java.util.Objects;

/**
 * @author 拾光
 * @version 1.0
 */
public class Employee implements Comparable<Employee>{
    //工号（唯一）
    int id;
    //姓名
    String name;
    //性别
    String sex;
    //所在部门
    String department;
    //手机号
    String tel;
    //职务
    String position;

    public Employee(int id, String name, String sex, String department, String tel, String position) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.tel = tel;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id："+id+",姓名："+name;
    }

    /**
     * "员工信息：" +
     *                 "工号为：" + id +
     *                 ", 名字为：'" + name + '\'' +
     *                 ", 性别为：'" + sex + '\'' +
     *                 ", 所在部门为：'" + department + '\'' +
     *                 ", 联系方式为：'" + tel + '\'' +
     *                 ", 职务为：'" + position + '\'';
     * @param o
     * @return
     */

    //二叉搜索树的比较逻辑，是按照员工的工号进行查找
    @Override
    public int compareTo(Employee o) {
        return this.id-o.id;
    }
}
