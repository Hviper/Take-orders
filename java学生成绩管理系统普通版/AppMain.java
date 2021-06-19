package Student;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生人数：");
        int stuNum = sc.nextInt();
        System.out.println("请输入课程数目：");
        int couNum = sc.nextInt();
        Student[][] scores = new Student[stuNum][couNum];
        /** 利用对象数组存放学生姓名 */
        Student[] stuName = new Student[stuNum];
        /** 利用对象数组存放课程名称 */
        Student[] couName = new Student[couNum];

        /** 存放某名学生某一门课程的成绩 */
        double[][] score = new double[stuNum][couNum];
        /** 某名学生所有课程的总分 */
        double[] sumStuScore = new double[stuNum];
        /** 某名学生所有课程的平均分 */
        double[] avgStuScore = new double[stuNum];
        /** 所有学生某门课程的总分 */
        double[] sumCouScore = new double[couNum];
        /** 所有学生某门课程的平均分 */
        double[] avgCouScore = new double[couNum];
        /** 用于绑定学生姓名、各课程的成绩等信息 */
        String[] str = new String[stuNum];

        Student.assignment(stuName, couName, score, sumStuScore, avgStuScore, str);
        Student.show(stuName, couName, score, sumStuScore, avgStuScore, str, avgCouScore, sumCouScore);

        sc.close();

    }
}