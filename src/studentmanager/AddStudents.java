package studentmanager;

//添加学生面板类
//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//创建“添加学生面板”类，并继承Jpanel类，和动作监听器借口
public class AddStudents extends JPanel implements ActionListener 
{
	//声明一个静态变量长整型的变量serialVersionUID，此处不知什么用，但是没有这个,程序会有警告。不写下面这行，也不影响程序运行。
	//private static final long serialVersionUID = 1L;
	//声明一个连接数据库的对象
	Connection conn;
	//创建一个声明，用来执行SQL语句
	Statement statement;
	/*
	 * 以下是创建组件对象：标签、文本行、单选、按钮的细节
	 */
	//创建一个标签对象stuNo用来显示学号
	JLabel stuNo=new JLabel("学号：");
	//创建一个文本输入框对象stuNo2用来输入学号字符串
	JTextField stuNo2=new JTextField();
	//创建一个标签对象noFormat用来显示，注意学号的格式
	JLabel noFormat=new JLabel("学号是10位数,如:2016010203");
	//创建一个标签对象stuName用来显示姓名
	JLabel stuName=new JLabel("姓名：");
	//创建一个文本输入框对象stuName2用来输入姓名字符串
	JTextField stuName2=new JTextField();
	//创建一个标签对象stuSex用来显示性别
	JLabel stuSex=new JLabel("性别：");
	//创建一个单选按钮对象sex_boy用来选择“男”
	JRadioButton sex_boy=new JRadioButton("男");
	//创建一个单选按钮对象sex_girl用来选择“女”
	JRadioButton sex_girl=new JRadioButton("女");
	//创建一个单选按钮组合对象sex_group，把上面两个单选按钮组合一起，确保只有一个单选按钮被选中
	ButtonGroup sex_group=new ButtonGroup();
	//创建一个标签对象stuBirthDate用来显示出生日期
	JLabel stuBirthDate=new JLabel("出生日期：");
	//创建一个文本输入框对象stuBirthDate2用来输入出生日期字符串
	JTextField stuBirthDate2=new JTextField();
	//创建一个标签对象BirthDateFormat用来显示，注意出生日期的格式
	JLabel BirthDateFormat=new JLabel("注意!出生日期格式为:1990-02-15");
	//创建一个标签对象stuBirthPlace用来显示出生地
	JLabel stuBirthPlace=new JLabel("籍贯：");
	//创建一个文本输入框对象stuBirthPlace2用来输入出生地字符串
	JTextField stuBirthPlace2=new JTextField();
	//创建一个按钮对象addStu用来添加学生信息到数据库
	JButton addStu=new JButton("添加学生");
	//添加学生面板类的构造方法
	public AddStudents()
	{
		try{
			//调用添加学生的初始化函数
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	//添加学生图形界面的初始化函数，初始化各变量，组件。
	private void jbInit() throws Exception
	{
		//调用DBConnect.java内的getConn方法,初始化conn对象，来连接数据库
		conn=DBConnect.getConn();
		//连接数据库后，初始化statement对象，来将 SQL语句发送到数据库。
		statement=conn.createStatement();
		/*
		 * 先把当前窗体容器this，的布局管理器置空，再添加新的组件到当前窗体容器中。
		 * setLayout,数以java.awt.*中的接口，详情件JAVA_API_1.6.CHM文件。
		 */
		this.setLayout(null);
		/*
		 * 设置各组件的大小和在当前窗体中的位置
		 */
		//标签：学号的大小和位置。
		//setBounds(new Rectangle(x,y,w,h)),移动组件并调整其大小。由 x 和 y 指定左上角的新位置，由 w和 h指定新的大小,使其符合新的有界矩形 。
		stuNo.setBounds(new Rectangle(21,13,65,25));
		//文本输入框：学号，的大小和位置
		stuNo2.setBounds(new Rectangle(65,15,100,25));
		//标签：学号格式，的大小和位置
		noFormat.setBounds(new Rectangle(180,13,190,25));
		//标签：姓名，的大小和位置
		stuName.setBounds(new Rectangle(21,51,53,22));
		//文本输入框：姓名，的大小和位置
		stuName2.setBounds(new Rectangle(65,50,150,25));
		//标签：性别，的大小和位置
		stuSex.setBounds(new Rectangle(21,86,61,27));
		//单选按钮：性别男，的大小和位置
		sex_boy.setBounds(new Rectangle(70,85,65,25));
		//单选按钮：性别女，的大小和位置
		sex_girl.setBounds(new Rectangle(150,85,85,25));
		//设置默认，单选(男)按钮被选中
		sex_boy.setSelected(true);
		//标签：出生日期，的大小和位置
		stuBirthDate.setBounds(new Rectangle(1,122,65,25));
		//文本输入框：出生日期，的大小和位置
		stuBirthDate2.setBounds(new Rectangle(65,120,100,25));
		//标签：出生日期格式，的大小和位置
		BirthDateFormat.setBounds(new Rectangle(65,145,219,25));
		//标签：出生地，的大小和位置
		stuBirthPlace.setBounds(new Rectangle(21,180,55,25));
		//文本输入框：出生地，的大小和位置
		stuBirthPlace2.setBounds(new Rectangle(65,180,150,25));
		//按钮：添加学生，的大小和位置
		addStu.setBounds(new Rectangle(103,217,180,30));
		/** 
		 * 对“添加学生”按钮，添加动作事件监听器，监听当前窗体。
		 * 当按下“添加学生”按钮，会自动调用actionPerformed(ActionEvent e)方法
		 * */
		addStu.addActionListener(this);
		/*
		 * 把上面初始化完成的各类组件都添加到当前窗体容器内。
		 */
		//添加标签，学号
		this.add(stuNo);
		//添加文本输入框，学号
		this.add(stuNo2);
		//添加标签，学号格式
		this.add(noFormat);
		//添加标签，姓名
		this.add(stuName);
		//添加文本输入框，学号
		this.add(stuName2);
		//添加标签，性别
		this.add(stuSex);
		//添加单选按钮，男
		this.add(sex_boy);
		//添加单选按钮，女
		this.add(sex_girl);
		//再把上面两个单选按钮，添加到按钮组合对象sex_group内
		sex_group.add(sex_boy);
		sex_group.add(sex_girl);
		//添加标签，出生日期
		this.add(stuBirthDate);
		//添加文本输入框，出生日期
		this.add(stuBirthDate2);
		//添加标签，出生日期格式
		this.add(BirthDateFormat);
		//添加标签，出生地
		this.add(stuBirthPlace);
		//添加文本输入框，出生地
		this.add(stuBirthPlace2);
		//添加按钮，添加学生
		this.add(addStu);
	}
	
	
	//点击按钮添加学生，有个监听器事件监听该动作
	public void actionPerformed(ActionEvent e)
	{
		//变量xuehao用来搜集学号信息
		String xuehao=stuNo2.getText();
		//变量xingming用来搜集姓名信息
		String xingming=stuName2.getText();
		//变量xingbie用来搜集性别信息
		String xingbie="";
		//如果单选按钮“男”被选择，那么xingbie字符串内容为“男”
		if(sex_boy.isSelected())
			xingbie="男";
		//如果单选按钮“女”被选择，那么xingbie字符串内容为“女”
		if(sex_girl.isSelected())
			xingbie="女";
		//变量dateString用来搜集出生日期信息
		String dateString=stuBirthDate2.getText();
		//变量jiguan用来搜集出生地信息
		String jiguan=stuBirthPlace2.getText();
		//学号已经存在的不允许插入！返回并提醒错误：该学号已经存在。
		try{
			ResultSet rs=statement.executeQuery("select * from studentsinfo where xuehao='"+xuehao+"'");
			if(rs.next()){
				JOptionPane.showMessageDialog(this,"该学号已经存在，请检查后再输入！");
				return;
				}
			}catch(Exception ex){
					//如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
				ex.printStackTrace();
			}
		//调用CheckDateFormat.java中的CheckDateFormat类,创建一个对象
		//该对象调用checkDateFormat()方法检查输入的日期是否合法。
		CheckDateFormat cdf=new CheckDateFormat();
		//加一个输入检查，姓名为非空，且学号是10位数，且出生日期格式正确，否则重新输入
		if(!((xuehao.length())==10 && (xingming.length())>0&&cdf.checkDateFormat(dateString))){
			JOptionPane.showMessageDialog(this,"输入数据格式错误，请检查后再输入！");
			return;
		}
		
		//异常处理
		try{
			//利用statement对象，执行SQL语句，进行插入操作
			statement.executeUpdate("insert into studentsinfo values('"+xuehao
					+"','"+xingming+"','"+xingbie+"','"
					+dateString+"','"+jiguan+"','"+xuehao.substring(0,6)+"')");
			//利用消息对话框提示插入操作成功
			//JOptionPane 有助于方便地弹出要求用户提供值或向其发出通知的标准对话框。
			JOptionPane.showMessageDialog(this,"插入学生信息成功！");
			//清空文本输入框：学号、姓名、出生日期、籍贯的内容
			stuNo2.setText("");
			stuName2.setText("");
			stuBirthDate2.setText("");
			stuBirthPlace2.setText("");
		}catch(Exception ex){
			//如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
			JOptionPane.showMessageDialog(this,"输入数据格式错误，请检查后输入！");
			ex.printStackTrace();
		}
	}
}
