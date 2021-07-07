class Student:
    def __init__(self, id1, name, sex, classes, tel, score, next1=None):
        self.id1 = id1
        self.name = name
        self.sex = sex
        self.classes = classes
        self.tel = tel
        self.score = score
        self.next1 = next1


class Stu:
    def __init__(self):
        self.head = None

    def add1(self, id1, name, sex, classes, tel, score):
        if self.head is None:
            temp = Student(id1, name, sex, classes, tel, score)
            self.head = temp
        else:
            temp = self.head
            while temp.next1:
                temp = temp.next1
            temp.next1 = Student(id1, name, sex, classes, tel, score)

    def delete1(self, id1):
        if self.head is None:
            print("链表没有元素，无法删除")
        elif self.head.id1 == id1:
            self.head = self.head.next1
        else:
            temp = self.head
            flag = 0
            while temp.next1 is not None:
                if temp.next1.id1 == id1:
                    temp.next1 = temp.next1.next1
                    flag = 1
                    break
                temp = temp.next1
            if flag == 1:
                print("删除信息成功")
            elif flag == 0:
                print("没有该学号，删除信息失败")

    def update1(self, id1):
        temp = self.head
        while temp is not None:
            if temp.id1 == id1:
                break
            temp = temp.next1
        flag = 1
        while flag:
            print("选出你要修改的数据")
            print("1:学号　　2:姓名   3:性别   4:班级   5:电话   6:得分\n")
            a = int(input("输出数字:"))
            if a == 1:
                b = int(input("输入修改后的学号:"))
                temp.id1 = b
                flag = 0
            elif a == 2:
                b = input("输入修改后的姓名:")
                temp.name = b
                flag = 0
            elif a == 3:
                b = input("输入修改后的性别:")
                temp.sex = b
                flag = 0
            elif a == 4:
                b = input("输入修改后的班级:")
                temp.classes = b
                flag = 0
            elif a == 5:
                b = input("输入修改后的电话:")
                temp.tel = b
                flag = 0
            elif a == 6:
                b = int(input("输入修改后的得分:"))
                temp.score = b
                flag = 0
            else:
                print("输入数字错误，重新输入\n")
        print("修改数据信息成功\n")

    def find1(self):
        temp = self.head
        if temp is None:
            print("链表元素是空的\n")
        else:
            flag = 1
            ff = 1
            while flag:
                print("输入数字决定你要按什么条件查找\n")
                print("1: 学号　　2:姓名\n")
                a = int(input("输入数字:"))
                if a == 1:
                    b = int(input("输入学号:"))
                    print("查找学号为%d的学生信息如下:" % b)
                    print("\n")
                    while temp:
                        if temp.id1 == b:
                            ff = 0
                            print("学号:%d  姓名:%s  性别:%s  班级:%s  电话:%d  得分:%d \n" % (temp.id1, temp.name, temp.sex, temp.classes, temp.tel, temp.score))
                            break
                        temp = temp.next1
                    flag = 0
                elif a == 2:
                    b = input("输入姓名:")
                    print("查找姓名为%s的学生信息如下:" % a)
                    print("\n")
                    while temp:
                        if temp.name == b:
                            ff = 0
                            print("学号:%d  姓名:%s  性别:%s  班级:%s  电话:%d  得分:%d \n" % (temp.id1, temp.name, temp.sex, temp.classes, temp.tel, temp.score))
                        temp = temp.next1
                    flag = 0
                else:
                    print("数字输入错误，重新输入\n")
            if ff == 1:
                print("抱歉,没有找到该学生信息\n")

    def findall(self):
        temp = self.head
        if temp is None:
            print("信息库为空\n")
        else:
            print("所有学生信息如下:\n")
            while temp:
                print("学号:%d  姓名:%s  性别:%s  班级:%s  电话:%d  得分:%d " % (temp.id1, temp.name, temp.sex, temp.classes, temp.tel, temp.score))
                print("\n")
                temp = temp.next1

    def select_sort(self):
        temp = self.head
        if temp is None:
            print("信息库为空\n")
        else:
            l = len(temp)
            for i in range(l - 1):
                pos = 0
                for j in range(1, l - i):
                    if int(temp[pos].score) < int(temp[j].score):
                        pos = j
                temp[pos], temp[l - i - 1] = temp[l - i - 1], temp[pos]
            print("学生成绩排序如下:\n")
            while temp:
                print("学号:%d  姓名:%s  得分:%d " % (temp.id1, temp.name, temp.score))
                print("\n")
                temp = temp.next1



    def main1(self):
        print("------------------------欢迎来到学生管理系统----------------------:")

        while True:
            print("1:  添加学生信息　　　　　　2:   删除学生信息 ")
            print("3:  修改学生信息          4:   查找学生信息 ")
            print("5:  输出所有学生信息　　　　6:排序  ")
            print("7:  退出系统")
            a = int(input("输入相应的数字:"))  # 用int强制转化为整数
            if a == 1:
                temp1 = int(input("输入学生学号:"))
                temp2 = input("输入学生姓名:")
                temp3 = input("输入学生性别:")
                temp4 = input("输入学生的班级:")
                temp5 = int(input("输入学生的电话:"))
                temp6 = int(input("输入学生得分:"))
                self.add1(temp1, temp2, temp3, temp4, temp5, temp6)
                print("\n")

            elif a == 2:
                temp = int(input("输入删除学生的学号:"))
                self.delete1(temp)
                print("\n")

            elif a == 3:
                temp = int(input("输入要修改的学生学号:"))
                self.update1(temp)
                print("\n")
            elif a == 4:
                self.find1()
                print("\n")
            elif a == 5:
                self.findall()
                print("\n")
            elif a == 6:
                self.select_sort()
                print("\n")
            elif a == 7:
                break
            else:
                print("输入错误，重新输入")


if __name__ == '__main__':
    a = Stu()
    a.main1()
