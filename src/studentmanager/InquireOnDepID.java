package studentmanager;

//按系号查询部门系面板类
//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//创建“添加部门系面板”类
public class InquireOnDepID extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//声明连接数据库对象
	Connection conn;
	//声明SQL语句对象
	Statement st;
	//创建组件对象：标签、文本行、单选
	JLabel jLabel1=new JLabel("请输入待查询的部门系号：");
	JTextField xiHAO=new JTextField();
	JLabel xiHAO2=new JLabel("系号是2位，如01");
	JButton jButton1=new JButton("查询");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	//构造方法
	public InquireOnDepID()
	{
		try{
			//调用初始化方法
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	//面板初始化方法
	private void jbInit() throws Exception
	{
		//连接数据库
		conn=DBConnect.getConn();
		st=conn.createStatement();
		//框架的布局
		this.setLayout(null);
		//设置各组件的大小
		jLabel1.setFont(new java.awt.Font("宋体",Font.BOLD,16));
		jLabel1.setBounds(new Rectangle(46,4,222,32));
		xiHAO.setBounds(new Rectangle(47,37,100,31));
		xiHAO2.setBounds(new Rectangle(160,37,180,30));
		jButton1.setBounds(new Rectangle(47,86,247,30));
		jScrollPane1.setBounds(new Rectangle(24,130,305,109));
		//添加按钮动作事件
		jButton1.addActionListener(this);
		//添加组件到面板
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		this.add(jLabel1);
		this.add(xiHAO);
		this.add(xiHAO2);
		this.add(jButton1);
	}
	//点击按钮事件
	public void actionPerformed(ActionEvent e)
	{
		//获取用户输入的系号
		String xiid=xiHAO.getText();
		//清空文本区原有的内容
		jTextArea1.setText("");
		try{
			//利用st对象执行SQL语句，返回结果集对象
			ResultSet rs=st.executeQuery("select * from departmentinfo where xiid='"+xiid+"'");
			//处理结果集:逐条显示结果集中的记录
			//此处没有使用while，因为系号是唯一的
			if(rs.next()){
				jTextArea1.append("系号:"+rs.getString("XiId")+"\n系名:"
						+rs.getString("xiName")+"\n系主任:"+rs.getString("xiTeacher"));
				//清空文本行的内容
				xiHAO.setText("");
			}
			else
				JOptionPane.showMessageDialog(this,"没有这个系号!");
		}
		catch(Exception ex){
			//利用消息对话框提示查询失败
			JOptionPane.showMessageDialog(this,"查询失败!");
		}
	}
}
