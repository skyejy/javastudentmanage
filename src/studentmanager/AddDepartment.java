package studentmanager;

//添加部门系面板类
//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//创建“添加部门系面板”类，并继承Jpanel类，和动作监听器借口
public class AddDepartment extends JPanel implements ActionListener 
{
	//声明一个静态变量长整型的变量serialVersionUID，此处不知什么用，但是没有这个,程序会有警告。不写下面这行，也不影响程序运行。
	private static final long serialVersionUID = 1L;
	//声明一个连接数据库的对象
	Connection conn;
	//创建一个声明，用来执行SQL语句
	Statement statement;
	/*
	 * 以下是创建组件对象：标签、文本行、单选、按钮的细节
	 */
	//创建一个标签对象DepNum用来显示系号
	JLabel DepNum=new JLabel("系号：");
	//创建一个文本输入框对象DepNum2用来输入系号字符串
	JTextField DepNum2=new JTextField();
	//创建一个标签对象xiHaoFormat用来显示，注意系号的格式
	JLabel xiHaoFormat=new JLabel("系号2位数，如:02");
	//创建一个标签对象DepName用来显示系名
	JLabel DepName=new JLabel("系名：");
	//创建一个文本输入框对象DepName2用来输入系名字符串
	JTextField DepName2=new JTextField();
	//创建一个标签对象xiTeacher用来显示系主任
	JLabel xiTeacher=new JLabel("系主任：");
	//创建一个文本输入框对象xiTeacher2用来输入系主任字符串
	JTextField xiTeacher2=new JTextField();
	//创建一个按钮对象addDep用来添加部门系信息到数据库
	JButton addDep=new JButton("添加部门系");
	//添加部门系面板类的构造方法
	public AddDepartment()
	{
		try{
			//调用添加部门系的初始化函数
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	//添加部门系图形界面的初始化函数，初始化各变量，组件。
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
		//标签：系号的大小和位置。
		//setBounds(new Rectangle(x,y,w,h)),移动组件并调整其大小。由 x 和 y 指定左上角的新位置，由 w和 h指定新的大小,使其符合新的有界矩形 。
		DepNum.setBounds(new Rectangle(60,20,65,25));
		//文本输入框：系号，的大小和位置
		DepNum2.setBounds(new Rectangle(105,20,50,25));
		//标签：系号格式，的大小和位置
		xiHaoFormat.setBounds(new Rectangle(170,20,170,25));
		//标签：系名，的大小和位置
		DepName.setBounds(new Rectangle(60,65,53,22));
		//文本输入框：系名，的大小和位置
		DepName2.setBounds(new Rectangle(105,65,150,25));
		//标签：系主任，的大小和位置
		xiTeacher.setBounds(new Rectangle(50,110,65,25));
		//文本输入框：系主任，的大小和位置
		xiTeacher2.setBounds(new Rectangle(105,110,100,25));
		//按钮：添加部门系，的大小和位置
		addDep.setBounds(new Rectangle(105,150,150,30));
		/** 
		 * 对“添加部门系”按钮，添加动作事件监听器，监听当前窗体。
		 * 当按下“添加部门系”按钮，会自动调用actionPerformed(ActionEvent e)方法
		 * */
		addDep.addActionListener(this);
		/*
		 * 把上面初始化完成的各类组件都添加到当前窗体容器内。
		 */
		//添加标签，系号
		this.add(DepNum);
		//添加文本输入框，系号
		this.add(DepNum2);
		//添加标签，系号格式
		this.add(xiHaoFormat);
		//添加标签，系名
		this.add(DepName);
		//添加文本输入框，系号
		this.add(DepName2);
		//添加标签，系主任
		this.add(xiTeacher);
		//添加文本输入框，系主任
		this.add(xiTeacher2);
		//添加按钮，添加部门系
		this.add(addDep);
	}
	
	
	//点击按钮添加部门系，有个监听器事件监听该动作
	public void actionPerformed(ActionEvent e)
	{
		//变量xiID用来搜集系号信息
		String xiID=DepNum2.getText();
		//变量xiName用来搜集系名信息
		String xiName=DepName2.getText();
		//变量xiT用来搜集系主任信息
		String xiTeacher=xiTeacher2.getText();
		//系号已经存在的不允许插入！返回并提醒错误：该系号已经存在。
		try{
			ResultSet rs=statement.executeQuery("select * from departmentinfo where xiID='"+xiID+"'");
			if(rs.next()){
				JOptionPane.showMessageDialog(this,"该系号已经存在，请检查后再输入！");
				return;
				}
			}catch(Exception ex){
					//如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
				ex.printStackTrace();
			}
		
		//加一个输入检查，系名为非空，且系号是2位数，且系名非空，否则重新输入
		if(!((xiID.length())==2 && (xiName.length())>0)){
			JOptionPane.showMessageDialog(this,"输入数据格式错误，请检查后再输入！");
			return;
		}
		
		//异常处理
		try{
			//利用statement对象，执行SQL语句，进行插入操作
			statement.executeUpdate("insert into departmentinfo values('"+xiID
					+"','"+xiName+"','"+xiTeacher+"')");
			//利用消息对话框提示插入操作成功
			//JOptionPane 有助于方便地弹出要求用户提供值或向其发出通知的标准对话框。
			JOptionPane.showMessageDialog(this,"插入部门系信息成功！");
			//清空文本输入框：系号、系名、系主任内容
			DepNum2.setText("");
			DepName2.setText("");
			xiTeacher2.setText("");
		}catch(Exception ex){
			//如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
			JOptionPane.showMessageDialog(this,"输入数据格式错误，请检查后输入！");
			ex.printStackTrace();
		}
	}
}
