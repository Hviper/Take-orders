package Student;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Student extends Person{
    public static void show(Student[] stuName, Student[] couName, double[][] score, double[] sumStuScore,
            double[] avgStuScore, String[] str, double[] avgCouScore, double[] sumCouScore) {
        Scanner sc = new Scanner(System.in);
        String answer = "n"; // 循环条件
        while ("n".equals(answer)) {// 判断两个对象的内容是否相等
            System.out.println("--------欢迎使用XX成绩管理系统--------");
            System.out.println("\t1、查看学生成绩信息");
            System.out.println("\t2、查询学生课程成绩");
            System.out.println("\t3、查询学生总成绩");
            System.out.println("\t4、查询各课程平均分&学生课程平均分");
            System.out.println("\t5、查询课程最高分&最低分");
            System.out.println("\t6、学生成绩排名");
            System.out.println("\t7、删除学生记录");
            System.out.println("\t8、查看课程中部分学生成绩分布所占比例");
            System.out.println("\t9、修改某门成绩");
            System.out.println("\t0、退出系统");
            System.out.println("\t请选择相应序列号：");
            System.out.println("-------------------------------------");

            int choose = sc.nextInt();
            switch (choose) {        //switch控制
                case 0:
                    System.out.println("欢迎您再次使用XX学生成绩管理系统！");
                    System.exit(0); // 退出程序
                case 1:
                    information(stuName, couName, score);
                    break;

                case 2:
                    stuScoreOfCourse(stuName, couName, score);
                    break;

                case 3:
                    sumScore(stuName, couName, sumStuScore, str);
                    break;

                case 4:
                    average(stuName, couName, avgCouScore, avgStuScore, score, sumCouScore);
                    break;

                case 5:
                    maxAndMinCouScore(stuName, couName, score);
                    break;
                case 6:
                    int number = -1;
                    System.out.println("请选择排序方式：1、学生总成绩排序\t2、课程成绩排序");
                    number = sc.nextInt();
                    if (number == 1) {
                        outputSort(stuName, couName, str, sumStuScore);
                    } else if (number == 2) {
                        sortOfCourse(stuName, couName, score);
                    } else {
                        System.out.println("序号输入错误！");
                    }
                    break;
                case 7:
                     delete(stuName, couName, score);
                    break;
                case 8:
                    getProportion(stuName,couName,score);
                    break;
                case 9:

                    ChangeScore(stuName,couName,score);
                    break;
                default:
                    System.out.println("请输入正确的序列号！！！");

            }
        }
    }

    /**
     * 给课程名赋值
     * 
     * @param couName
     */
    public static void courseName(Student[] couName) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < couName.length; i++) {
            System.out.println("请输入第" + (i + 1) + "门课程名称：");
            couName[i] = new Student(); // 对象数组在使用前必须要给其分配空间
            couName[i].setCourse(sc.next());
        }
    }

    /**
     * 给各个学生的课程成绩赋值
     * 
     * @param stuName
     * @param couName
     * @param score
     * @param sumStuScore
     * @param avgStuScore
     * @param str
     */
    public static void assignment(Student[] stuName, Student[] couName, double[][] score, double[] sumStuScore,
            double[] avgStuScore, String[] str) {
        Scanner sc = new Scanner(System.in);
        courseName(couName);
        String[] tempStr = new String[stuName.length];
        for (int i = 0; i < tempStr.length; i++) {
            tempStr[i] = "";
        }
        for (int i = 0; i < stuName.length; i++) {
            str[i] = null;
            stuName[i] = new Student();
            System.out.println("请输入第" + (i + 1) + "位学生的姓名：");
            stuName[i].setName(sc.next());
            for (int j = 0; j < couName.length; j++) {
                System.out.println("请输入" + stuName[i].getName() + "的" + couName[j].getCourse() + "成绩：");
                score[i][j] = sc.nextDouble();
                tempStr[i] += score[i][j] + "\t";
                sumStuScore[i] = sumStuScore[i] + score[i][j];
            }
            avgStuScore[i] = sumStuScore[i] / couName.length;
            str[i] = stuName[i].getName() + "\t" + tempStr[i]; // 保存学生姓名、课程成绩和总成绩的记录信息
        }
    }

    /**
     * 打印学生的姓名、课程名以及相应成绩
     * 
     * @param couName
     * @param
     */
    public static void information(Student[] stuName, Student[] couName, double[][] score) {
        System.out.print("姓名");
        for (int i = 0; i < couName.length; i++) {
            System.out.print("\t" + couName[i].getCourse());
        }
        System.out.println();
        for (int i = 0; i < stuName.length; i++) {
            System.out.print(stuName[i].getName());
            for (int j = 0; j < couName.length; j++) {
                System.out.print("\t" + score[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 查询某一学生某门课程的成绩
     * 
     * @param stuName
     * @param couName
     * @param score
     */
    public static void stuScoreOfCourse(Student[] stuName, Student[] couName, double[][] score) {
        Scanner sc = new Scanner(System.in);
        String answer = "n"; // 循环条件
        while ("n".equals(answer)) {
            boolean isFind = false; // 判断学生名是否找到
            int index = -1; // 待查询姓名的数组下标
            System.out.println("请输入待查询的学生姓名：");
            String name = sc.next();
            for (int i = 0; i < stuName.length; i++) {
                if (name.equals(stuName[i].getName())) {// 判断两个对象的内容是否相等
                    isFind = true;
                    index = i;
                    break; // 跳出循环
                }
            }
            if (isFind && index != -1) { // 当查询到该学生记录时
                System.out.println("请输入课程名：");
                String course = sc.next();
                boolean isCorrect = false; // 判断课程名是否找到
                int couIndex = -1; // 待查询课程的数组下标
                for (int j = 0; j < couName.length; j++) {// 遍历课程名数组
                    if (course.equals(couName[j].getCourse())) {// 判断两个对象的内容是否相等
                        isCorrect = true;
                        couIndex = j;
                        break;
                    }
                }
                if (isCorrect && couIndex != -1) {// 匹配对应学生的课程名记录，当姓名和课程同时匹配时，输出结果
                    System.out.println(stuName[index].getName() + "的" + couName[couIndex].getCourse() + "成绩是："
                            + score[index][couIndex]);
                } else {// 当课程名错误
                    System.out.println("课程名输入错误！");
                }
            } else {// 当姓名错误
                System.out.println("姓名输入错误！");
            }
            System.out.println("是否退出查询？\t（y/n）");
            answer = sc.next();
        }
    }


    /**
     * 修改某门成绩
     * @param stuName
     * @param couName
     * @param score
     */
    public static void ChangeScore(Student[] stuName, Student[] couName, double[][] score) {
        Scanner sc = new Scanner(System.in);
        String answer = "n"; // 循环条件
        while ("n".equals(answer)) {
            boolean isFind = false; // 判断学生名是否找到
            int index = -1; // 待查询姓名的数组下标
            System.out.println("请输入待修改成绩的学生姓名：");
            String name = sc.next();
            for (int i = 0; i < stuName.length; i++) {
                if (name.equals(stuName[i].getName())) {// 判断两个对象的内容是否相等
                    isFind = true;
                    index = i;
                    break; // 跳出循环
                }
            }
            if (isFind) { // 当查询到该学生记录时
                System.out.println("请输入课程名：");

                String course = sc.next();
                System.out.println("请输入新的成绩：");
                Double new_score = sc.nextDouble();
                boolean isCorrect = false; // 判断课程名是否找到
                int couIndex = -1; // 待查询课程的数组下标
                for (int j = 0; j < couName.length; j++) {// 遍历课程名数组
                    if (course.equals(couName[j].getCourse())) {// 判断两个对象的内容是否相等
                        isCorrect = true;
                        couIndex = j;
                        break;
                    }
                }
                if (isCorrect) {// 匹配对应学生的课程名记录，当姓名和课程同时匹配时，输出结果
                    score[index][couIndex] = new_score;
                    System.out.println("修改成功！！"+stuName[index].getName() + "的" + couName[couIndex].getCourse() + "新成绩是："
                            + score[index][couIndex]);

                } else {// 当课程名错误
                    System.out.println("课程名输入错误！");
                }
            } else {// 当姓名错误
                System.out.println("姓名输入错误！");
            }
            System.out.println("是否退出修改？\t（y/n）");
            answer = sc.next();
        }
    }



    public static void sumScore(Student[] stuName, Student[] couName, double[] sumStuScore, String[] str) {
        /** 将指定的字符串追加到此字符序列 */
        StringBuffer tempStr = new StringBuffer("姓名");
        for (int i = 0; i < couName.length; i++) {
            tempStr.append("\t"); // 子串追加到StringBuffer对象tempStr中
            tempStr.append(couName[i].getCourse());
        }
        tempStr.append("\t");
        tempStr.append("总分");
        tempStr.append("\n");
        for (int i = 0; i < str.length; i++) {
            tempStr.append(str[i]);
            // tempStr.append("\t");
            tempStr.append(sumStuScore[i]);
            tempStr.append("\n");
        }
        System.out.println(tempStr);
    }

    /**
     * 获取某门课程的总分和平均分
     *
     * @param stuName：学生姓名
     * @param couName：存放课程名称
     * @param score：某名学生某一门课程的成绩
     * @param sumCouScore：所有学生某门课程的总分【累加】
     * @param avgCouScore：所有学生某门课程的平均分
     */
    public static void getsumCouScoreAndAvgCouScore(Student[] stuName, Student[] couName, double[][] score, double[] sumCouScore, double[] avgCouScore) {
        for (int j = 0; j < couName.length; j++) {
            for (int i = 0; i < stuName.length; i++) {
                sumCouScore[j] = sumCouScore[j] + score[i][j]; // 课程总分
            }
            avgCouScore[j] = sumCouScore[j] / stuName.length; // 获取课程平均分
        }

    }

    /**
     * 获取比例优秀（90-100），优秀（80-89），中等（70-79），及格（60-69），不及格（0-59）
     * @param stuName：学生姓名
     * @param couName：存放课程名称
     * @param score：某名学生某一门课程的成绩
     */

    public static void getProportion(Student[] stuName, Student[] couName, double[][] score
                                                    ) {

        for (int j = 0; j < couName.length; j++) {
            int countExcellent = 0;
            int countGood = 0;
            int countMedium =  0;
            int countPass = 0;
            int countNoPass = 0;

            for (int i = 0; i < stuName.length; i++) {

                double s = score[i][j];

                if(s>=90.0 && s<=100.0){
                    countExcellent+=1;
                }else if(s>=80.0 && s<=89.0){
                    countGood+=1;
                }
                else if(s>=70.0 && s<=79.0){
                    countMedium+=1;
                }else if(s>=60.0 && s<=69.0){
                    countPass+=1;
                }else if (s>=0.0 && s<=59.0){
                    countNoPass+=1;
                }
            }
            System.out.println("----------------课程名称为："+couName[j].course+"学生情况如下：----------------");
            System.out.println("卓越成绩比例为："+Chufa(countExcellent,stuName.length));
            System.out.println("优秀成绩比例为："+Chufa(countGood,stuName.length));
            System.out.println("中等比例为："+Chufa(countMedium,stuName.length));
            System.out.println("及格比例为："+Chufa(countPass,stuName.length));
            System.out.println("不及格比例为："+Chufa(countNoPass,stuName.length));

            System.out.println();
            System.out.println();
        }


    }

    /**
     *自定义除法器
     * @param a
     * @param b
     * @return
     */
    public static String Chufa(int a,int b) {
        //“0.00000000”确定精度
        DecimalFormat dF = new DecimalFormat("0.00000000");
        return dF.format((float)a/b);
    }

    /**
     * 显示各个学生的平均分，以及各个课程的平均分
     * 
     * @param stuName
     * @param couName
     * @param avgCouScore
     * @param avgStuScore
     * @param score
     * @param sumCouScore
     */
    public static void average(Student[] stuName, Student[] couName, double[] avgCouScore, double[] avgStuScore,
            double[][] score, double[] sumCouScore) {

        getsumCouScoreAndAvgCouScore(stuName, couName, score, sumCouScore, avgCouScore);
        System.out.println("姓名\t\t平均分");
        for (int i = 0; i < stuName.length; i++) {
            System.out.printf("%s\t%.2f", stuName[i].getName(), avgStuScore[i]);// 利用printf进行输出； .2f表示保留小数点后2位
            System.out.println();
        }
        System.out.println();// 换行
        System.out.println("课程\t\t平均分");
        for (int i = 0; i < couName.length; i++) {
            System.out.printf("%s\t%.2f", couName[i].getCourse(), avgCouScore[i]);
            System.out.println();
        }
    }

    /**
     * 查询某一课程分数的最高分和最低分
     * 
     * @param stuName 学生姓名
     * @param couName 课程名
     * @param score   某一课程分数
     */
    public static void maxAndMinCouScore(Student[] stuName, Student[] couName, double[][] score) {
        Scanner sc = new Scanner(System.in);
        String answer = "n"; // 循环条件
        while ("n".equals(answer)) {// 判断两个对象的内容是否相等
            System.out.println("请输入待查询的课程：");
            String course = sc.next();
            double max = 0; // 用于暂时存放最高分
            double min = 0; // 用于暂时存放最低分
            for (int j = 0; j < couName.length; j++) {
                if (course.equals(couName[j].getCourse())) { // 判断输入的课程名与couName[i].getCourse的值相同
                    max = score[0][j]; // 假设某一课程第一条记录为最高分
                    min = score[0][j]; // 假设某一课程第一条记录为最低分
                    for (int i = 1; i < stuName.length; i++) {
                        if (max < score[i][j]) {
                            max = score[i][j];
                        } else if (min > score[i][j]) {
                            min = score[i][j];
                        }
                    }
                    System.out.println(couName[j].getCourse() + "最高分：" + max);
                    System.out.println(couName[j].getCourse() + "最低分：" + min);
                    break; // 跳出循环
                } else {
                    if (j == couName.length - 1) { // 当全部遍历后仍找不到 ，则跳出循环
                        System.out.println("暂无此课程！");
                        break;
                    }
                }
            }

            System.out.println("是否退出查询？\t（y/n） ");
            answer = sc.next();
        }

    }

    /**
     * 按照学生总成绩进行排序
     * 
     * @param stuName
     * @param couName
     * @param str         学生记录信息
     * @param sumStuScore
     */
    public static void sortStuScore(Student[] stuName, Student[] couName, String[] str, double[] sumStuScore) {
        for (int i = 0; i < stuName.length - 1; i++) {
            for (int j = 0; j < stuName.length - i - 1; j++) {
                if (sumStuScore[j] < sumStuScore[j + 1]) {
                    double temp = sumStuScore[j]; // 定义一个临时变量存放sumStuScore[j]的值
                    /** 交换两个数值 */
                    sumStuScore[j] = sumStuScore[j + 1];
                    sumStuScore[j + 1] = temp;
                    /** 在进行排序是，不仅只是将总分数的位置进行交换，还需要将相应的学生记录进行交换 */
                    String tempStr = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = tempStr;
                }
            }
        }
    }

    public static void outputSort(Student[] stuName, Student[] couName, String[] str, double[] sumStuScore) {
        sortStuScore(stuName, couName, str, sumStuScore);
        StringBuffer tempStr = new StringBuffer("姓名");
        for (int i = 0; i < couName.length; i++) {
            tempStr.append("\t");
            tempStr.append(couName[i].getCourse());
        }
        tempStr.append("\t");
        tempStr.append("总分");
        tempStr.append("\t");
        tempStr.append("排名");
        tempStr.append("\n");
        for (int i = 0; i < str.length; i++) {
            tempStr.append(str[i]);
            tempStr.append(sumStuScore[i]);
            tempStr.append("\t");
            tempStr.append("第" + (i + 1) + "名");
            tempStr.append("\n");
        }
        System.out.println(tempStr);// 输出字符串内容
    }

    /**
     * 按课程总分排序
     * 
     * @param stuName
     * @param couName
     * @param score
     */
    public static void sortOfCourse(Student[] stuName, Student[] couName, double[][] score) {
        Scanner sc = new Scanner(System.in);
        String answer = "n";// 循环条件
        while ("n".equals(answer)) {// 判断两个对象的内容是否相同
            System.out.println("请选择排序课程：");

            String course = sc.next();
            int searchIndex = -1; // 待排序课程的数组下标
            boolean isFind = false; // 判断待排序的课程是否找到
            for (int i = 0; i < couName.length; i++) {
                if (course.equals(couName[i].getCourse())) {
                    isFind = true;
                    searchIndex = i;
                    break;
                }
            }
            if (isFind && searchIndex != -1) {
                double[] temp = new double[stuName.length];
                for (int i = 0; i < stuName.length; i++) {
                    temp[i] = score[i][searchIndex];
                }
                Arrays.sort(temp);
                System.out.println("姓名\t分数\t排名");
                for (int i = 0; i < temp.length; i++) {
                    System.out.println(stuName[i].getName() + "\t" + temp[i] + "\t" + (temp.length - i));
                }
            } else {
                System.out.println("暂无次课程！");
            }
            System.out.println("是否退出排序？\t（y/n）");
            answer = sc.next();
        }
    }

    /**
     *
     * @param stuName 利用对象数组存放学生姓名
     * @param couName  利用对象数组存放课程名称
     * @param score  存放某名学生某一门课程的成绩 [二维数组]
     */
    public static void delete(Student[] stuName, Student[] couName, double[][] score) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待删除的学生姓名：");
        String name = sc.next();
        int deleteIndex = -1;
        boolean isFind = false;
        for (int i = 0; i < stuName.length; i++) {
            if (name.equals(stuName[i].getName())) {
                deleteIndex = i;    //需要删除的stuName 的 index
                isFind = true;
                break;
            }
        }

        Student[] new_stuName = null;
        double[][] new_score = null;
        if (isFind) {
            new_score = new double[stuName.length-1][couName.length];

            new_stuName= new Student[stuName.length-1];

            for (int i = 0; i < stuName.length; i++) {
                if(i==deleteIndex){
                    continue;
                }
                new_stuName[i] = stuName[i];
            }

        } else {
            System.out.println("暂无该生记录！");
        }
        stuName = new_stuName;
    }

}