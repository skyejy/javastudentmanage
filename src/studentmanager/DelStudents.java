package studentmanager;

//删除学生面板类

//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

//创建“删除学生面板”类
public class DelStudents extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	// 声明连接数据库对象
	Connection conn;
	// 声明SQL语句对象
	Statement st;
	// 创建组件对象
	JLabel jLabel1 = new JLabel("请输入待删除的学生的学号:");
	JLabel jLabel2 = new JLabel("(10位数,如:2016040506)");
	JTextField jTextField1 = new JTextField();
	JButton jButton1 = new JButton("删除");
	JButton jButton2 = new JButton("确认删除");
	JScrollPane jScrollPane1 = new JScrollPane();
	JTextArea jTextArea1 = new JTextArea();

	// 构造方法
	public DelStudents() {
		try {
			// 调用初始化方法
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	// 界面初始化方法
	private void jbInit() throws Exception {
		// 连接数据库
		conn = DBConnect.getConn();
		st = conn.createStatement();
		// 框架的布局
		this.setLayout(null);
		// 设置各组件的大小
		jLabel1.setFont(new java.awt.Font("宋体", Font.BOLD, 16));
		jLabel1.setBounds(new Rectangle(40, 10, 220, 30));
		jTextField1.setBounds(new Rectangle(260, 10, 80, 25));
		jLabel2.setBounds(new Rectangle(230, 30, 140, 30));
		jButton1.setBounds(new Rectangle(120, 60, 150, 30));
		jButton2.setBounds(new Rectangle(100, 210, 170, 30));
		jScrollPane1.setBounds(new Rectangle(80, 60, 220, 140));
		// 添加按钮动作事件
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		// 添加组件到面板
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

	// 点击按钮事件
	public void actionPerformed(ActionEvent e) {
		// 获取用户输入的学号
		String xuehao = jTextField1.getText();
		// 学号不存在的不允许删除！返回并提醒错误：该学号已经不存在。
		try {
			ResultSet rs1 = st.executeQuery("select * from studentsinfo where xuehao='" + xuehao + "'");
			if (!(rs1.next())) {
				JOptionPane.showMessageDialog(this, "该学号不存在，请检查后再删除！");
				return;
			}
		} catch (Exception ex) {
			// 如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
			ex.printStackTrace();
		}
		if (e.getSource() == jButton1) {
			// 删除之前显示要删除的学生信息
			jButton1.setVisible(false);
			jScrollPane1.setVisible(true);
			jButton2.setVisible(true);
			try {
				// 利用st对象执行SQL语句，返回结果集对象
				ResultSet rs2 = st.executeQuery("select * from studentsinfo where xuehao='" + xuehao + "'");
				// 处理结果集:逐条显示结果集中的记录
				// 此处没有使用while，因为学号是唯一的
				if (rs2.next()) {
					jTextArea1.append("学号:" + rs2.getString("xuehao") + "\n姓名:" + rs2.getString("xingming") + "\n性别:"
							+ rs2.getString("xingbie") + "\n出生日期:" + rs2.getDate("dateString")+"\n籍贯:" + rs2.getString("jiguan") + "\n班级号:" + rs2.getString("ClassId"));
				} else
					JOptionPane.showMessageDialog(this, "没有这个学号!");
			} catch (Exception ex) {
				// 利用消息对话框提示查询失败
				JOptionPane.showMessageDialog(this, "查询失败!");
			}
			return;
		}

		// 要求用户确认删除
		// if(JOptionPane.showConfirmDialog(this,"确认要删除吗？")==JOptionPane.YES_OPTION)
		else {
			try {
				// 利用st对象执行SQL删除操作
				st.executeUpdate("delete from studentsinfo where xuehao='" + xuehao + "'");
				// 利用消息对话框提示删除操作成功
				JOptionPane.showMessageDialog(this, "删除操作成功!");
				// 清空输入学号的文本行
				jTextField1.setText("");
				// 每次确认删除之后清空原来要删除的学生信息，否则，下次删除还会有上次刪除的学生信息
				jTextArea1.setText("");
				jScrollPane1.setVisible(false);
				jButton2.setVisible(false);
				jButton1.setVisible(true);
			} catch (Exception ex) {
				// 利用消息对话框提示不能删除
				JOptionPane.showMessageDialog(this, "删除操作执行失败!");
			}
		}
	}
}
