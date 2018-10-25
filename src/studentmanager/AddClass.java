package studentmanager;

//添加班级面板类
//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//创建“添加班级面板”类，并继承Jpanel类，和动作监听器借口
public class AddClass extends JPanel implements ActionListener 
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
	//创建一个标签对象ClassID用来显示学号
	JLabel ClassID=new JLabel("班级号：");
	//创建一个文本输入框对象ClassID2用来输入学号字符串
	JTextField ClassID2=new JTextField();
	//创建一个标签对象ClassID3用来显示，注意学号的格式
	JLabel ClassID3=new JLabel("班级号是6位数，如:201601");
	//创建一个标签对象XiID用来显示所属部门系号
	JLabel XiID=new JLabel("所属系：");
	//创建一个文本输入框对象XiID2用来输入所属部门系号
	JTextField XiID2=new JTextField();
	//创建一个标签对象XiID3用来显示，注意学号的格式
	JLabel XiID3=new JLabel("部门系号是2位数，如:01");
	//创建一个标签对象ClassTeacher用来显示班主任
	JLabel ClassTeacher=new JLabel("班主任：");
	//创建一个文本输入框对象ClassTeacher2用来输入班主任
	JTextField ClassTeacher2=new JTextField();
	//创建一个标签对象ClassNum用来显示班级人数
	JLabel ClassNum=new JLabel("班级人数：");
	//创建一个文本输入框对象ClassNum2用来输入班级人数
	JTextField ClassNum2=new JTextField();
		
	//创建一个按钮对象addClass用来添加班级信息到数据库
	JButton addClass=new JButton("添加班级");
	//添加学生面板类的构造方法
	public AddClass()
	{
		try{
			//调用添加学生的初始化函数
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	//添加班级图形界面的初始化函数，初始化各变量，组件。
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
		//setBounds(new Rectangle(x,y,w,h)),移动组件并调整其大小。由 x 和 y 指定左上角的新位置，由 w和 h指定新的大小,使其符合新的有界矩形 。
		//标签：班级号的大小和位置。
		ClassID.setBounds(new Rectangle(21,20,60,25));
		//文本输入框：班级号，的大小和位置
		ClassID2.setBounds(new Rectangle(80,20,100,25));
		//标签：班级号格式，的大小和位置
		ClassID3.setBounds(new Rectangle(190,20,170,25));
		//标签：系号，的大小和位置
		XiID.setBounds(new Rectangle(18,55,65,25));
		//文本输入框：系号，的大小和位置
		XiID2.setBounds(new Rectangle(80,55,100,25));
		//标签：系号格式，的大小和位置
		XiID3.setBounds(new Rectangle(190,55,170,25));
		//标签：班主任，的大小和位置
		ClassTeacher.setBounds(new Rectangle(21,92,60,25));
		//文本输入框：班主任，的大小和位置
		ClassTeacher2.setBounds(new Rectangle(80,92,100,25));
		//标签：班级人数，的大小和位置
		ClassNum.setBounds(new Rectangle(12,130,65,25));
		//文本输入框：班级人数，的大小和位置
		ClassNum2.setBounds(new Rectangle(80,130,100,25));
		
		
		addClass.setBounds(new Rectangle(110,180,180,30));
		/** 
		 * 对“添加学生”按钮，添加动作事件监听器，监听当前窗体。
		 * 当按下“添加学生”按钮，会自动调用actionPerformed(ActionEvent e)方法
		 * */
		addClass.addActionListener(this);
		/*
		 * 把上面初始化完成的各类组件都添加到当前窗体容器内。
		 */
		//添加标签，班级号
		this.add(ClassID);
		//添加文本输入框，班级号
		this.add(ClassID2);
		//添加标签，班级号格式
		this.add(ClassID3);
		//添加标签，系号
		this.add(XiID);
		//添加文本输入框，系号
		this.add(XiID2);
		//添加标签，系号格式
		this.add(XiID3);
		//添加标签，班主任
		this.add(ClassTeacher);
		//添加文本输入框，班主任
		this.add(ClassTeacher2);
		//添加标签，班级人数
		this.add(ClassNum);
		//添加文本输入框，班级人数
		this.add(ClassNum2);
		//添加按钮，添加班级
		this.add(addClass);
	}
	
	
	//点击按钮添加学生，有个监听器事件监听该动作
	public void actionPerformed(ActionEvent e)
	{
		//变量banjihao用来搜集班级号信息
		String banjihao=ClassID2.getText();
		//变量xihao用来搜集系号
		String xihao=XiID2.getText();
		//变量bzr用来搜集班主任
		String bzr=ClassTeacher2.getText();
		//变量renshu用来搜集出生地信息
		String renshu=ClassNum2.getText();
		//班级号已经存在的不允许插入！返回并提醒错误：该学号已经存在。
		try{
			ResultSet rs=statement.executeQuery("select * from classinfo where ClassId='"+banjihao+"'");
			if(rs.next()){
				JOptionPane.showMessageDialog(this,"该班级号已经存在，请检查后再输入！");
				return;
				}
			}catch(Exception ex){
					//如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
				ex.printStackTrace();
			}
		
		//加一个输入检查，班级号为非空且是6位数，系号非空且是2位数，否则重新输入
		if(!((banjihao.length())==6 && (xihao.length())==2)){
			JOptionPane.showMessageDialog(this,"输入数据格式错误，请检查后再输入！");
			return;
		}
		
		//异常处理
		try{
			//利用statement对象，执行SQL语句，进行插入操作
			statement.executeUpdate("insert into classinfo values('"+banjihao
					+"','"+bzr+"','"+renshu+"','"+xihao+"')");
			//利用消息对话框提示插入操作成功
			//JOptionPane 有助于方便地弹出要求用户提供值或向其发出通知的标准对话框。
			JOptionPane.showMessageDialog(this,"插入班级信息成功！");
			//清空文本输入框：学号、姓名、出生日期、籍贯的内容
			ClassID2.setText("");
			XiID2.setText("");
			ClassTeacher2.setText("");
			ClassNum2.setText("");
		}catch(Exception ex){
			//如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
			JOptionPane.showMessageDialog(this,"输入数据格式错误，请检查后输入！");
			ex.printStackTrace();
		}
	}
}
