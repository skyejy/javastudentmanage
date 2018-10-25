package studentmanager;

/**
 * 这是学生管理系统的主程序，main();
 */
//导入公共java包
import java.awt.*;
//import javax.swing.*;

//创建学生管理系统类
public class StudentsManager {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建主界面窗口
		MainInterface frame=new MainInterface();
		//获取屏幕尺寸
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		//获取主界面的窗体尺寸
		Dimension frameSize =frame.getSize();
		//令主界面窗体居中
		if(frameSize.height>screenSize.height)
			frameSize.height=screenSize.height;
		if(frameSize.width>screenSize.width)
			frameSize.width=screenSize.width;
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		frame.setVisible(true);
	}

}

