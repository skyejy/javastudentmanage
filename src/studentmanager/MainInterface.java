package studentmanager;

//系统主界面类

//导入系统的包
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//创建主界面类
public class MainInterface extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//创建内容面板
	JPanel contentPane;
	JMenuBar jMenuBarSM=new JMenuBar();
	JMenu jMenuFile=new JMenu("文件");
	JMenuItem jMenuFileExit=new JMenuItem("退出");
	JMenu jMenuStudents=new JMenu("学生信息管理");
	JMenuItem jMenuStuName=new JMenuItem("按姓名查询");
	JMenuItem jMenuStuId=new JMenuItem("按学号查询");
	JMenuItem jMenuAddStu=new JMenuItem("添加学生");
	JMenuItem jMenuDelStu=new JMenuItem("删除学生");

	JMenu jMenuClass=new JMenu("班级信息管理");
	JMenuItem jMenuOnClassId=new JMenuItem("按班级编号查询");
	JMenuItem jMenuAddClass=new JMenuItem("添加班级");
	JMenuItem jMenuDelClass=new JMenuItem("删除班级");

	JMenu jMenuDepartment=new JMenu("部门系信息管理");
	JMenuItem jMenuOnDepId=new JMenuItem("按部门系编号查询");
	JMenuItem jMenuAddDep=new JMenuItem("添加部门系");
	JMenuItem jMenuDelDep=new JMenuItem("删除部门系");

	JMenu jMenuHelp=new JMenu("帮助");
	JMenuItem jMenuHelpAbout=new JMenuItem("关于");
	//创建标签，用于显示信息
	JLabel jLabel1=new JLabel("欢迎使用学生信息管理系统");
	JLabel jLabel2=new JLabel("贾钰");
	//构造方法，创建对象时自动调用
	public MainInterface()
	{
		try{
			//关闭框架窗口时的默认事件方法
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		//创建内容面板和其布局
		contentPane =(JPanel) getContentPane();
		contentPane.setLayout(null);
		//框架的大小和其标题
		setSize(new Dimension(400,320));
		setTitle("学生信息管理系统");
		//添加事件监听器
		jMenuFileExit.addActionListener(this);
		jMenuHelpAbout.addActionListener(this);
		jMenuAddStu.addActionListener(this);
		jMenuDelStu.addActionListener(this);
		jMenuStuName.addActionListener(this);
		jMenuStuId.addActionListener(this);
		jMenuOnClassId.addActionListener(this);
		jMenuAddClass.addActionListener(this);
		jMenuDelClass.addActionListener(this);
		jMenuOnDepId.addActionListener(this);
		jMenuAddDep.addActionListener(this);
		jMenuDelDep.addActionListener(this);

		//添加菜单条
		setJMenuBar(jMenuBarSM);
		//添加菜单组件到菜单条
		jMenuBarSM.add(jMenuFile);
		jMenuBarSM.add(jMenuStudents);
		jMenuBarSM.add(jMenuClass);
		jMenuBarSM.add(jMenuDepartment);
		jMenuBarSM.add(jMenuFileExit);
		jMenuBarSM.add(jMenuHelp);

		//添加菜单项组件到菜单组件
		jMenuFile.add(jMenuFileExit);
		//学生信息管理菜单下的选择：按姓名查询，按学号查询，添加学生，删除学生
		jMenuStudents.add(jMenuStuName);
		jMenuStudents.add(jMenuStuId);
		jMenuStudents.add(jMenuAddStu);
		jMenuStudents.add(jMenuDelStu);
		//班级信息管理菜单下的选择：按班级号查询，添加班级，删除班级
		jMenuClass.add(jMenuOnClassId);
		jMenuClass.add(jMenuAddClass);
		jMenuClass.add(jMenuDelClass);
		//部门系信息管理菜单下的选择：按系号查询，添加系，删除系
		jMenuDepartment.add(jMenuOnDepId);
		jMenuDepartment.add(jMenuAddDep);
		jMenuDepartment.add(jMenuDelDep);
		//帮助菜单下的
		jMenuHelp.add(jMenuHelpAbout);

		//添加标签到内容面板
		contentPane.add(jLabel1);
		contentPane.add(jLabel2);
		//设置标签组件的大小和字体
		jLabel1.setFont(new java.awt.Font("宋体",Font.BOLD,20));
		jLabel1.setBounds(new Rectangle(65,70,275,55));
		jLabel2.setFont(new java.awt.Font("宋体",Font.BOLD,16));
		jLabel2.setBounds(new Rectangle(90,150,200,35));
	}
	//菜单事件的处理方法
	public void actionPerformed(ActionEvent actionEvent)
	{
		//点击“文件”菜单下的“退出”菜单项
		if(actionEvent.getSource()==jMenuFileExit)
		{
			System.exit(0);
		}
		//点击“学生查询”菜单下的“按姓名查询”菜单项
		if(actionEvent.getSource()==jMenuStuName)
		{
			//创建“按姓名查询”面板对象
			InquireOnStuName onName=new InquireOnStuName();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(onName);
			//令界面可见
			this.setVisible(true);
		}
		//点击“学生查询”菜单下的“按学号查询”菜单项
		if(actionEvent.getSource()==jMenuStuId)
		{
			//创建“按学号查询”面板对象
			InquireOnStuID onXH=new InquireOnStuID();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(onXH);
			//令界面可见
			this.setVisible(true);
		}
		//点击“学生管理”菜单下的“添加学生”菜单项
		if(actionEvent.getSource()==jMenuAddStu)
		{
			//创建添加学生面板对象
			AddStudents add=new AddStudents();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(add);
			//令界面可见
			this.setVisible(true);
		}
		//点击“学生管理”菜单下的“删除学生”菜单项
		if(actionEvent.getSource()==jMenuDelStu)
		{
			//创建删除学生面板对象
			DelStudents delete=new DelStudents();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(delete);
			//令界面可见
			this.setVisible(true);
		}

		//点击“班级信息管理”菜单下的“按班级编号查询”菜单项
		if(actionEvent.getSource()==jMenuOnClassId)
		{
			//创建“编号查询”面板对象
			InquireOnClassID onClassId=new InquireOnClassID();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(onClassId);
			//令界面可见
			this.setVisible(true);
		}
		//点击“班级管理”菜单下的“添加班级”菜单项
		if(actionEvent.getSource()==jMenuAddClass)
		{
			//创建添加班级面板对象
			AddClass addClass=new AddClass();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(addClass);
			//令界面可见
			this.setVisible(true);
		}
		//点击“班级管理”菜单下的“删除班级”菜单项
		if(actionEvent.getSource()==jMenuDelClass){
			//创建删除班级面板对象
			DelClass delClass=new DelClass();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(delClass);
			//令界面可见
			this.setVisible(true);
		}

		//点击“部门系信息管理”菜单下的“按部门系编号查询”菜单项
		if(actionEvent.getSource()==jMenuOnDepId)
		{
			//创建“编号查询”面板对象
			InquireOnDepID onDepId=new InquireOnDepID();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(onDepId);
			//令界面可见
			this.setVisible(true);
		}

		//点击“部门系管理”菜单下的“添加部门系”菜单项
		if(actionEvent.getSource()==jMenuAddDep)
		{
			//创建添加班级面板对象
			AddDepartment addDep=new AddDepartment();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(addDep);
			//令界面可见
			this.setVisible(true);
		}

		//点击“部门系管理”菜单下的“删除部门系”菜单项
		if(actionEvent.getSource()==jMenuDelDep){
			//创建删除班级面板对象
			DelDepartment delDep=new DelDepartment();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(delDep);
			//令界面可见
			this.setVisible(true);
		}

		//点击“帮助”菜单下的“关于”菜单项
		if(actionEvent.getSource()==jMenuHelpAbout)
		{
			//创建“关于”面板对象
			AboutMe about=new AboutMe();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(about);
			//令界面可见
			this.setVisible(true);
		}
	}
} 
