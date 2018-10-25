package studentmanager;

//删除班级面板类

//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

//创建“删除班级面板”类
public class DelClass extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//声明连接数据库对象
	Connection conn;
	//声明SQL语句对象
	Statement st;
	//创建组件对象
	JLabel jLabel1=new JLabel("请输入待删除的班级的班级号：");
	JTextField jTextField1=new JTextField();
	JLabel jLabel2 = new JLabel("(6位数,如:201604)");
	JButton jButton1=new JButton("删除");
	JButton jButton2=new JButton("确认删除");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	
	//构造方法
	public DelClass()
	{
		try{
			//调用初始化方法
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	//界面初始化方法
	private void jbInit() throws Exception
	{
		//连接数据库
		conn=DBConnect.getConn();
		st=conn.createStatement();
		//框架的布局
		this.setLayout(null);
		//设置各组件的大小
		jLabel1.setFont(new java.awt.Font("宋体",Font.BOLD,14));
		jLabel1.setBounds(new Rectangle(30,10,210,30));
		jTextField1.setBounds(new Rectangle(250,13,80,25));
		jLabel2.setBounds(new Rectangle(250, 40, 120, 30));
		jButton1.setBounds(new Rectangle(100,70,170,30));
		jButton2.setBounds(new Rectangle(100,205,170,30));
		jScrollPane1.setBounds(new Rectangle(90,80,180,110));
		//添加按钮动作事件
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		//添加组件到面板
		this.add(jLabel1);
		this.add(jTextField1);
		this.add(jLabel2);
		this.add(jButton1);
		this.add(jButton2);
		jButton2.setVisible(false);
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		jScrollPane1.setVisible(false);
	}
	//点击按钮事件
	public void actionPerformed(ActionEvent e)
	{
		//获取用户输入的班级号
		String banjihao=jTextField1.getText();
		
		//班级号不存在的不允许删除！返回并提醒错误：该班级号已经不存在。
		try{
			ResultSet rs1=st.executeQuery("select * from classinfo where ClassId='"+banjihao+"'");
			if(!(rs1.next())){
				JOptionPane.showMessageDialog(this,"该班级号不存在，请检查后再删除！");
				return;
				}
			}catch(Exception ex){
				//如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
				ex.printStackTrace();
			}
		
		//删除之前显示要删除的班级信息
		jButton1.setVisible(false);
		jScrollPane1.setVisible(true);
		jButton2.setVisible(true);
		try{
			//利用st对象执行SQL语句，返回结果集对象
			ResultSet rs2=st.executeQuery("select * from classinfo where ClassId='"+banjihao+"'");
			//处理结果集:逐条显示结果集中的记录
			//此处没有使用while，因为班级号是唯一的，而姓名不是，所以在InquireOnNamePanel.java里使用了while
			if(rs2.next()){
				jTextArea1.append("班级号:"+rs2.getString("ClassId")+"\n班主任:"+rs2.getString("ClassTeacher")+"\n班级人数:"+rs2.getString("StuNum")+"\n系号:"+rs2.getString("XiId"));
			}
			else
				JOptionPane.showMessageDialog(this,"没有这个班级号!");
			}
		catch(Exception ex){
			//利用消息对话框提示查询失败
			JOptionPane.showMessageDialog(this,"查询失败!");
			}
		
		//点击删除之后，要等待用户查看班级信息之后，再确认删除
		if(e.getSource()==jButton1)
			return;
		//删除按钮事件只能执行到上面这里就返回了。剩下的留给确认删除。
		
		//要求用户确认删除
		if(JOptionPane.showConfirmDialog(this,"确认要删除吗？")==JOptionPane.YES_OPTION)
		{
			try{
				//利用st对象执行SQL删除操作
				st.executeUpdate("delete from classinfo where ClassId='"+banjihao+"'");
				//利用消息对话框提示删除操作成功
				JOptionPane.showMessageDialog(this,"删除操作成功!");
				//清空输入班级号的文本行
				jTextField1.setText("");
				// 每次确认删除之后清空原来要删除的班级信息，否则，下次删除还会有上次刪除的班级信息
				jTextArea1.setText("");
				jScrollPane1.setVisible(false);
				jButton2.setVisible(false);
				jButton1.setVisible(true);
				}
			catch(Exception ex){
			//利用消息对话框提示不能删除
			JOptionPane.showMessageDialog(this,"删除操作执行失败!");
			}
		}
	}
}

