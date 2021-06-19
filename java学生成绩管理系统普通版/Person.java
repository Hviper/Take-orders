package Student;

/**
 * @author 拾光
 * @version 1.0
 */
public class Person {
    public String name; // 学生姓名
    public String course; // 课程名称
    public double score; // 课程得分

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
