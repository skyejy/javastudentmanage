package studentmanager;

//����ϵͳ�����
import java.awt.*;
import javax.swing.*;
//�����Ի�����
public class AboutMe extends JPanel
{
	private static final long serialVersionUID = 1L;
	//������ǩ����
	JLabel jLabel1=new JLabel("������Ϣ����ϵͳ");
	JLabel jLabel2=new JLabel("����:����");
	JLabel jLabel3=new JLabel("�汾��:2018.5.21");
	JLabel jLabel4=new JLabel("��飺");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	
	//���췽��
	public AboutMe()
		{
			try{
				//���ó�ʼ������
				jbInit();
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		}
	//�����ʼ������
	private void jbInit() throws Exception
	{
		//���Ĳ���
		this.setLayout(null);
		//���ñ�ǩ����Ĵ�С
		jLabel1.setBounds(new Rectangle(40,10,249,39));
		jLabel2.setBounds(new Rectangle(40,40,174,28));
		jLabel3.setBounds(new Rectangle(40,70,126,27));
		jLabel4.setBounds(new Rectangle(40,110,126,27));
		jScrollPane1.setBounds(new Rectangle(80,115,280,120));
		//jTextArea1.append("~������è������һ��С���ԣ��������·ݵ����񣬻��кܴ�Ľ����ͳɳ��Ŀռ�~");
		jTextArea1.append("���ݿ����ҵ");


		//��ӱ�ǩ���������
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
