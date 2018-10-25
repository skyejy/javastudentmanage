package studentmanager;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//创建“学号查询学生”类面板
public class InquireOnStuID extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//声明连接数据库对象
	Connection conn;
	//声明SQL语句对象
	Statement st;
	//创建组件对象：标签、文本行、单选
	JLabel jLabel1=new JLabel("请输入待查询的学生的学号：");
	JTextField xueHAO=new JTextField();
	JLabel xueHAO2=new JLabel("学号是10位，如2016030607");
	JButton jButton1=new JButton("查询");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	//构造方法
	public InquireOnStuID()
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
		xueHAO.setBounds(new Rectangle(47,37,100,31));
		xueHAO2.setBounds(new Rectangle(160,37,180,30));
		jButton1.setBounds(new Rectangle(47,86,247,30));
		jScrollPane1.setBounds(new Rectangle(24,130,305,109));
		//添加按钮动作事件
		jButton1.addActionListener(this);
		//添加组件到面板
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		this.add(jLabel1);
		this.add(xueHAO);
		this.add(xueHAO2);
		this.add(jButton1);
	}
	//点击按钮事件
	public void actionPerformed(ActionEvent e)
	{
		//获取用户输入的学号
		String xuehao=xueHAO.getText();
		//清空文本区原有的内容
		jTextArea1.setText("");
		try{
			//利用st对象执行SQL语句，返回结果集对象
			ResultSet rs=st.executeQuery("select * from studentsinfo where xuehao='"+xuehao+"'");
			//处理结果集:逐条显示结果集中的记录
			//此处没有使用while，因为学号是唯一的
			if(rs.next()){
				jTextArea1.append("学号:"+rs.getString("xuehao")+"\n姓名:"+rs.getString("xingming")+"\n性别:"+rs.getString("xingbie")+"\n出生日期:"
						+rs.getDate("dateString")+"\n籍贯:"+rs.getString("jiguan")+"\n班级号:"+rs.getString("ClassId"));
				//清空文本行的内容
				xueHAO.setText("");
			}
			else
				JOptionPane.showMessageDialog(this,"没有这个学号!");
			}
		catch(Exception ex){
			//利用消息对话框提示查询失败
			JOptionPane.showMessageDialog(this,"查询失败!");
			}
	}
}

