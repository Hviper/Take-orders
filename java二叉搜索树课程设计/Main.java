
import printer.BinaryTrees;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


/**
 * @author 拾光
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BinarySearchTree<Employee> bst = new BinarySearchTree<>();
		Scanner sc = new Scanner(System.in);
		while(true){
			show();
			int choice = sc.nextInt();
			if(choice==1){

				System.out.println("*******所有员工信息如下：*******");

				//中序遍历的方式进行遍历
				bst.inorderTraversal(new BinarySearchTree.Visitor<Employee>() {
					@Override
					public void visit(Employee element) {
						System.out.println("员工信息：" +
						"工号为：" + element.id +
						", 名字为：'" + element.name + '\'' +
						", 性别为：'" + element.sex + '\'' +
						", 所在部门为：'" + element.department + '\'' +
						", 联系方式为：'" + element.tel + '\'' +
							", 职务为：'" + element.position + '\'');
					}
				});
			}else if(choice==2){

				System.out.println("请输入需要添加员工的工号：");
				int id = sc.nextInt();
				System.out.println("请输入需要添加员工的姓名：");
				String name = sc.next();
				System.out.println("请输入需要添加员工的性别：");
				String sex = sc.next();
				System.out.println("请输入需要添加员工的部门：");
				String department = sc.next();
				System.out.println("请输入需要添加员工的联系方式：");
				String tel = sc.next();
				System.out.println("请输入需要添加员工的职务：");
				String position = sc.next();
				bst.add(new Employee(id,name,sex,department,tel,position));
			}else if(choice==3){
				System.out.println("请输入需要删除员工的工号：");
				int id = sc.nextInt();
				BinarySearchTree.Node<Employee> node = bst.node(new Employee(id, "", "", "", "", ""));
				if(node==null){
					System.out.println("抱歉，没有找到该工号对应的工人！");
				}else{
					bst.remove(node);
					System.out.println("删除成功");
				}


			}else if(choice==4){
				System.out.println("请输入需要修改员工的工号：");
				int id = sc.nextInt();
				BinarySearchTree.Node<Employee> node = bst.node(new Employee(id, "", "", "", "", ""));
				if(node==null){
					System.out.println("抱歉，没有找到该工号对应的工人！");
				}else{
					System.out.println("请输入需要修改的员工的姓名");
					String name = sc.next();
					System.out.println("请输入需要修改员工的性别：");
					String sex = sc.next();
					System.out.println("请输入需要修改员工的部门：");
					String department = sc.next();
					System.out.println("请输入需要修改员工的联系方式：");
					String tel = sc.next();
					System.out.println("请输入需要修改员工的职务：");
					String position = sc.next();
					node.element.name = name;
					node.element.sex = sex;
					node.element.department = department;
					node.element.tel = tel;
					node.element.position = position;
					System.out.println("修改成功！！！");
				}
			}else if(choice==5){
				System.out.println("---------------------------");
				BinaryTrees.println(bst);
				System.out.println("---------------------------");
			}
			else if(choice==6){
				FileWriter file = new FileWriter(".\\EmployeeInfo.txt");
				bst.inorderTraversal(new BinarySearchTree.Visitor<Employee>(){
					@Override
					public void visit(Employee element){
						String data = element.id+" "+element.name+' '+element.sex+' '+element.department+' '+element.tel+' '+element.position+"\n";
						System.out.println(data);
						try {
							file.write(data);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} );
				file.close();

			}else if(choice==7){
				FileReader fr = new FileReader(".\\EmployeeInfo.txt");
				BufferedReader br = new BufferedReader(fr);

				String str;

				while((str=br.readLine())!=null){
					String[] s = str.split(" ");
					bst.add(new Employee(Integer.parseInt(s[0]),s[1],s[2],s[3],s[4],s[5]));
				}
				br.close();
				fr.close();
			}
			else if(choice==8){
				break;
			}
			else{
				System.out.println("请输入正确的选项（如：1，2，3，4，5）");
			}
		}
	}
	public static void show() {
		System.out.println("*****欢迎使用员工管理系统*******");
		System.out.println("(1)：查询所有员工");
		System.out.println("(2)：添加员工");
		System.out.println("(3)：删除员工");
		System.out.println("(4)：修改员工");
		System.out.println("(5)：二叉树树状显示");
		System.out.println("(6)：文本持久化存储");
		System.out.println("(7)：读取文本");
		System.out.println("(8)：退出系统");

	}
}
