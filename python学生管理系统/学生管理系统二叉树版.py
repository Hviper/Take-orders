import math

class ZYCNode:
    def __init__(self,IDCode,name,age,score,Infor):
        self.IDCode = IDCode
        self.name = name
        self.age = age
        self.score = score
        self.Infor = Infor

	##这里重写  __str__()方法可以打印出这个对象时能打印的更详细，而不是打印该对象地址
    def __str__(self):
        return "该学生的名字是:%s ,学号为：%d, 年龄是:%d，分数为：%d,其他学籍信息：%s" % (self.name, self.IDCode,self.age,self.score,self.Infor)

##模拟学生数据库表		
StudentDataBase = {}


##二叉搜索树相关的类
class Node:
	def __init__(self, value):
		self.value = value
		self.leftChild = None
		self.rightChild = None


##中序遍历方法（递归法）
	def inorder(self,l):
		if self:
			if self.leftChild:
				self.leftChild.inorder(l)
			l.append(self.value)
			
			if self.rightChild:
				self.rightChild.inorder(l)

##二叉树查找方法				
	def find(self, data):
		if(self.value == data):
			return True
		elif self.value > data:
			if self.leftChild:
				return self.leftChild.find(data)
			else:
				return False
		else:
			if self.rightChild:
				return self.rightChild.find(data)
			else:
				return False
##二叉树插入方法
	def insert(self, data):
		if self.value == data:
			return False
			
		elif self.value > data:
			if self.leftChild:
				return self.leftChild.insert(data)
			else:
				self.leftChild = Node(data)
				return True

		else:
			if self.rightChild:
				return self.rightChild.insert(data)
			else:
				self.rightChild = Node(data)
				return True


class Tree:
	##初始化方法
	def __init__(self):
		self.root = None

	def insert(self, data):
		if self.root:
			return self.root.insert(data)
		else:
			self.root = Node(data)
			return True

	def find(self, data):
		if self.root:
			return self.root.find(data)
		else:
			return False

			
	def inorder(self,l):
		print("InOrder")
		self.root.inorder(l)

##先创建 “二叉搜索树”对象
tree = Tree()




##流程控制函数
class Print():
	
	def __init__(self):
		print("欢迎使用学生基本管理系统")
	def end(self):
		print("欢迎再次使用学生基本管理系统")	
	def show(self):
		while 1:
			print("--------------------（请输入以下功能选项）----------------------")
			print("--------------------（1）添加学生信息----------------------")
			print("--------------------（2）删除学生信息----------------------")
			print("--------------------（3）按中序遍历方式遍历学生信息----------------------")
			print("--------------------（4）查询学生信息----------------------")
			print("--------------------（5）更新学生信息----------------------")
			print("--------------------（6）根据学生的成绩排序输出----------------------")

			try:
				change = int(input("输入上面功能序号"))
				if(change==1):
					IDCode = int(input("输入需要插入数据库中学生的学号： "))
					name = input("输入需要插入数据库中学生信息的姓名：")
					age = int(input("输入需要插入数据库中学生信息的年纪：  "))
					score = int(input("输入需要插入数据库中学生的成绩：   "))
					Infor = input("输入需要插入数据库中学生的其他信息：")
					zsw = ZYCNode(IDCode,name,age,score,Infor)
					StudentDataBase[IDCode] = zsw
					tree.insert(IDCode)

				elif(change==2):
					IDCode = int(input("根据学号ID进行查找，请输入需要删除的学生的学生学号："))
					try:
						del StudentDataBase[IDCode]
						reomve(IDCode);
					except Exception as e:
						print("数据库中没有该学生信息,删除失败")
	
				elif(change==3):
					l = []
				
					tree.inorder(l)    
					print("\t\t（按照学生ID的中序遍历结果）学生信息如下")
					for i in l:
						print(StudentDataBase[int(i)])
				elif(change==4):
					IDCode = int(input("请输入需要查找的学生的学生  【注意：只能根据学号ID进行查找，所以请输入正确学号】："))
					print("\t\t学生信息如下：")
					if(tree.find(IDCode)):
						info = StudentDataBase[IDCode]
						print(info)
					else:
						print("没有该学生的信息")	
				elif(change==5):
					IDCode = int(input("根据学号ID进行查找，请输入需要更新的学生的学生学号："))
					node = StudentDataBase[IDCode]

					name = input(f"输入修改学号为：{IDCode} 的学生信息的姓名：")
					age = int(input(f"输入修改学号为：{IDCode} 的学生信息的年纪：   "))
					score = int(input(f"输入修改学号为：{IDCode} 的学生信息的成绩：  "))
					Infor = input(f"输入修改学号为：{IDCode} 的学生信息的其他信息：")
					node.name = name
					node.age = age
					node.score =score
					node.Infor = Infor
				elif(change==6):
					list = {}   ##这里通过再创建一个列表的方式暂时存储所有学生，再进行排序即可
					for i in StudentDataBase:
						##key为成绩，value为学号【学生学号唯一！！，能通过学号查找到唯一的学生】
						list[StudentDataBase[i].score] = i
					list2 = sorted(list,reverse=True)
					print("\n\n-----------------按照学生成绩输出排名如下-----------------\n")
					for i in list2:
						print(StudentDataBase[list[i]])

				else:
					print("请输入正确的序号")
			except Exception as e:
				print("请输出正确的序号")
p = Print()
p.show()

p.end()