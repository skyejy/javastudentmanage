package studentmanager;

/**
 * ����ѧ������ϵͳ��������main();
 */
//���빫��java��
import java.awt.*;
//import javax.swing.*;

//����ѧ������ϵͳ��
public class StudentsManager {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//���������洰��
		MainInterface frame=new MainInterface();
		//��ȡ��Ļ�ߴ�
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		//��ȡ������Ĵ���ߴ�
		Dimension frameSize =frame.getSize();
		//�������洰�����
		if(frameSize.height>screenSize.height)
			frameSize.height=screenSize.height;
		if(frameSize.width>screenSize.width)
			frameSize.width=screenSize.width;
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		frame.setVisible(true);
	}

}

