package studentmanager;

//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//创建“按班号查询班级面板”类
public class InquireOnClassID extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//声明连接数据库对象
	Connection conn;
	//声明SQL语句对象
	Statement st;
	//创建组件对象：标签、文本行、单选
	JLabel bjID=new JLabel("请输入待查询的班级号：");
	JTextField jTextField1=new JTextField();
	JLabel bjID2=new JLabel("班级号是6位，如201603");
	JButton jButton1=new JButton("查询");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	//构造方法
	public InquireOnClassID()
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
		bjID.setFont(new java.awt.Font("宋体",Font.BOLD,16));
		bjID.setBounds(new Rectangle(46,4,222,32));
		
		jTextField1.setBounds(new Rectangle(47,37,100,31));
		bjID2.setBounds(new Rectangle(160,37,180,30));
		
		jButton1.setBounds(new Rectangle(47,86,130,30));
		jScrollPane1.setBounds(new Rectangle(47,130,250,109));
		//添加按钮动作事件
		jButton1.addActionListener(this);
		//添加组件到面板
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		this.add(bjID);
		this.add(jTextField1);
		this.add(bjID2);
		this.add(jButton1);
		jScrollPane1.setVisible(false);
	}
	//点击按钮事件
	public void actionPerformed(ActionEvent e)
	{
		//获取用户输入的班级号
		String banji=jTextField1.getText();
		//清空文本区原有的内容
		jTextArea1.setText("");
		jScrollPane1.setVisible(true);
		try{
			//利用st对象执行SQL语句，返回结果集对象
			ResultSet rs=st.executeQuery("select * from classinfo where ClassId='"+banji+"'");
			//处理结果集:逐条显示结果集中的记录
			//此处没有使用while，因为学号是唯一的
			if(rs.next()){
				jTextArea1.append("班级号:"+rs.getString("ClassId")+"\n班主任:"+rs.getString("ClassTeacher")+"\n班级人数:"+rs.getString("StuNum")+"\n系号:"+rs.getString("XiId"));
				//清空文本行的内容
				jTextField1.setText("");
			}
			else
				JOptionPane.showMessageDialog(this,"没有这个班号!");
		}
		catch(Exception ex){
			//利用消息对话框提示查询失败
			JOptionPane.showMessageDialog(this,"查询失败!");
		}
	}
}

