package studentmanager;

//导入系统的类包
import java.awt.*;
import javax.swing.*;
//创建对话框类
public class AboutMe extends JPanel
{
	private static final long serialVersionUID = 1L;
	//创建标签对象
	JLabel jLabel1=new JLabel("宿舍信息管理系统");
	JLabel jLabel2=new JLabel("作者:贾钰");
	JLabel jLabel3=new JLabel("版本号:2018.5.21");
	JLabel jLabel4=new JLabel("简介：");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	
	//构造方法
	public AboutMe()
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
		//面板的布局
		this.setLayout(null);
		//设置标签组件的大小
		jLabel1.setBounds(new Rectangle(40,10,249,39));
		jLabel2.setBounds(new Rectangle(40,40,174,28));
		jLabel3.setBounds(new Rectangle(40,70,126,27));
		jLabel4.setBounds(new Rectangle(40,110,126,27));
		jScrollPane1.setBounds(new Rectangle(80,115,280,120));
		//jTextArea1.append("~这是照猫画虎的一次小尝试，是我三月份的任务，还有很大的进步和成长的空间~");
		jTextArea1.append("数据库大作业");


		//添加标签到内容面板
		this.add(jLabel1);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		setSize(190,160);
		this.setVisible(true);
	}
}
