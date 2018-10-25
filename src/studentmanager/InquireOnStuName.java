package studentmanager;

//按姓名查询学生面板类
//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//创建“添加学生面板”类
public class InquireOnStuName extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//声明连接数据库对象
	Connection conn;
	//声明SQL语句对象
	Statement st;
	//创建组件对象：标签、文本行、单选
	JLabel jLabel1=new JLabel("请输入待查询的学生的姓名：");
	JTextField jTextField1=new JTextField();
	JButton jButton1=new JButton("查询");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	//构造方法
	public InquireOnStuName()
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
		jLabel1.setFont(new java.awt.Font("宋体",Font.BOLD,14));
		jLabel1.setBounds(new Rectangle(90,8,200,34));
		jTextField1.setBounds(new Rectangle(90,40,200,30));
		jButton1.setBounds(new Rectangle(110,75,150,30));
		jScrollPane1.setBounds(new Rectangle(40,115,308,130));
		//添加按钮动作事件
		jButton1.addActionListener(this);
		//添加组件到面板
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		this.add(jLabel1);
		this.add(jTextField1);
		this.add(jButton1);
	}
	//点击按钮事件
	public void actionPerformed(ActionEvent e)
	{
		//获取用户输入的姓名
		String xingming=jTextField1.getText();
		//姓名为空，提示输入姓名
		if(xingming.length()==0){
			JOptionPane.showMessageDialog(this,"请输入名字!");
			return;
		}
		//清空文本区原有的内容
		jTextArea1.setText("");
		//查询是否存在
		try{
			//利用st对象执行SQL语句，返回结果集对象
			//此处用模糊查询like
			ResultSet rs=st.executeQuery("select * from studentsinfo where xingming like '%"+xingming+"%'");
			//查不到，提示信息
			if(!(rs.next())){
				JOptionPane.showMessageDialog(this,"没有这个名字!");
				return;
			}
			rs=st.executeQuery("select * from studentsinfo where xingming like '%"+xingming+"%'");
			//处理结果集:逐条显示结果集中的记录
			while(rs.next()){
				jTextArea1.append("学号:"+rs.getString("xuehao")+"\n姓名:"+rs.getString("xingming")+"\n性别:"+rs.getString("xingbie")+"\n出生日期:"
						+rs.getDate("dateString")+"\n籍贯:"+rs.getString("jiguan")+"\n班级号:"+rs.getString("ClassId")+"\n\n");
				//清空文本行的内容
				jTextField1.setText("");
				}
			}
		catch(Exception ex){
			//利用消息对话框提示查询失败
			JOptionPane.showMessageDialog(this,"查询失败!");
			}
	}
}
