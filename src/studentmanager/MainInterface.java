package studentmanager;

//ϵͳ��������

//����ϵͳ�İ�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//������������
public class MainInterface extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//�����������
	JPanel contentPane;
	JMenuBar jMenuBarSM=new JMenuBar();
	JMenu jMenuFile=new JMenu("�ļ�");
	JMenuItem jMenuFileExit=new JMenuItem("�˳�");
	JMenu jMenuStudents=new JMenu("ѧ����Ϣ����");
	JMenuItem jMenuStuName=new JMenuItem("��������ѯ");
	JMenuItem jMenuStuId=new JMenuItem("��ѧ�Ų�ѯ");
	JMenuItem jMenuAddStu=new JMenuItem("���ѧ��");
	JMenuItem jMenuDelStu=new JMenuItem("ɾ��ѧ��");

	JMenu jMenuClass=new JMenu("�༶��Ϣ����");
	JMenuItem jMenuOnClassId=new JMenuItem("���༶��Ų�ѯ");
	JMenuItem jMenuAddClass=new JMenuItem("��Ӱ༶");
	JMenuItem jMenuDelClass=new JMenuItem("ɾ���༶");

	JMenu jMenuDepartment=new JMenu("����ϵ��Ϣ����");
	JMenuItem jMenuOnDepId=new JMenuItem("������ϵ��Ų�ѯ");
	JMenuItem jMenuAddDep=new JMenuItem("��Ӳ���ϵ");
	JMenuItem jMenuDelDep=new JMenuItem("ɾ������ϵ");

	JMenu jMenuHelp=new JMenu("����");
	JMenuItem jMenuHelpAbout=new JMenuItem("����");
	//������ǩ��������ʾ��Ϣ
	JLabel jLabel1=new JLabel("��ӭʹ��ѧ����Ϣ����ϵͳ");
	JLabel jLabel2=new JLabel("����");
	//���췽������������ʱ�Զ�����
	public MainInterface()
	{
		try{
			//�رտ�ܴ���ʱ��Ĭ���¼�����
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		//�������������䲼��
		contentPane =(JPanel) getContentPane();
		contentPane.setLayout(null);
		//��ܵĴ�С�������
		setSize(new Dimension(400,320));
		setTitle("ѧ����Ϣ����ϵͳ");
		//����¼�������
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

		//��Ӳ˵���
		setJMenuBar(jMenuBarSM);
		//��Ӳ˵�������˵���
		jMenuBarSM.add(jMenuFile);
		jMenuBarSM.add(jMenuStudents);
		jMenuBarSM.add(jMenuClass);
		jMenuBarSM.add(jMenuDepartment);
		jMenuBarSM.add(jMenuFileExit);
		jMenuBarSM.add(jMenuHelp);

		//��Ӳ˵���������˵����
		jMenuFile.add(jMenuFileExit);
		//ѧ����Ϣ����˵��µ�ѡ�񣺰�������ѯ����ѧ�Ų�ѯ�����ѧ����ɾ��ѧ��
		jMenuStudents.add(jMenuStuName);
		jMenuStudents.add(jMenuStuId);
		jMenuStudents.add(jMenuAddStu);
		jMenuStudents.add(jMenuDelStu);
		//�༶��Ϣ����˵��µ�ѡ�񣺰��༶�Ų�ѯ����Ӱ༶��ɾ���༶
		jMenuClass.add(jMenuOnClassId);
		jMenuClass.add(jMenuAddClass);
		jMenuClass.add(jMenuDelClass);
		//����ϵ��Ϣ����˵��µ�ѡ�񣺰�ϵ�Ų�ѯ�����ϵ��ɾ��ϵ
		jMenuDepartment.add(jMenuOnDepId);
		jMenuDepartment.add(jMenuAddDep);
		jMenuDepartment.add(jMenuDelDep);
		//�����˵��µ�
		jMenuHelp.add(jMenuHelpAbout);

		//��ӱ�ǩ���������
		contentPane.add(jLabel1);
		contentPane.add(jLabel2);
		//���ñ�ǩ����Ĵ�С������
		jLabel1.setFont(new java.awt.Font("����",Font.BOLD,20));
		jLabel1.setBounds(new Rectangle(65,70,275,55));
		jLabel2.setFont(new java.awt.Font("����",Font.BOLD,16));
		jLabel2.setBounds(new Rectangle(90,150,200,35));
	}
	//�˵��¼��Ĵ�����
	public void actionPerformed(ActionEvent actionEvent)
	{
		//������ļ����˵��µġ��˳����˵���
		if(actionEvent.getSource()==jMenuFileExit)
		{
			System.exit(0);
		}
		//�����ѧ����ѯ���˵��µġ���������ѯ���˵���
		if(actionEvent.getSource()==jMenuStuName)
		{
			//��������������ѯ��������
			InquireOnStuName onName=new InquireOnStuName();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(onName);
			//�����ɼ�
			this.setVisible(true);
		}
		//�����ѧ����ѯ���˵��µġ���ѧ�Ų�ѯ���˵���
		if(actionEvent.getSource()==jMenuStuId)
		{
			//��������ѧ�Ų�ѯ��������
			InquireOnStuID onXH=new InquireOnStuID();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(onXH);
			//�����ɼ�
			this.setVisible(true);
		}
		//�����ѧ�������˵��µġ����ѧ�����˵���
		if(actionEvent.getSource()==jMenuAddStu)
		{
			//�������ѧ��������
			AddStudents add=new AddStudents();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(add);
			//�����ɼ�
			this.setVisible(true);
		}
		//�����ѧ�������˵��µġ�ɾ��ѧ�����˵���
		if(actionEvent.getSource()==jMenuDelStu)
		{
			//����ɾ��ѧ��������
			DelStudents delete=new DelStudents();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(delete);
			//�����ɼ�
			this.setVisible(true);
		}

		//������༶��Ϣ�����˵��µġ����༶��Ų�ѯ���˵���
		if(actionEvent.getSource()==jMenuOnClassId)
		{
			//��������Ų�ѯ��������
			InquireOnClassID onClassId=new InquireOnClassID();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(onClassId);
			//�����ɼ�
			this.setVisible(true);
		}
		//������༶�����˵��µġ���Ӱ༶���˵���
		if(actionEvent.getSource()==jMenuAddClass)
		{
			//������Ӱ༶������
			AddClass addClass=new AddClass();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(addClass);
			//�����ɼ�
			this.setVisible(true);
		}
		//������༶�����˵��µġ�ɾ���༶���˵���
		if(actionEvent.getSource()==jMenuDelClass){
			//����ɾ���༶������
			DelClass delClass=new DelClass();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(delClass);
			//�����ɼ�
			this.setVisible(true);
		}

		//���������ϵ��Ϣ�����˵��µġ�������ϵ��Ų�ѯ���˵���
		if(actionEvent.getSource()==jMenuOnDepId)
		{
			//��������Ų�ѯ��������
			InquireOnDepID onDepId=new InquireOnDepID();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(onDepId);
			//�����ɼ�
			this.setVisible(true);
		}

		//���������ϵ�����˵��µġ���Ӳ���ϵ���˵���
		if(actionEvent.getSource()==jMenuAddDep)
		{
			//������Ӱ༶������
			AddDepartment addDep=new AddDepartment();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(addDep);
			//�����ɼ�
			this.setVisible(true);
		}

		//���������ϵ�����˵��µġ�ɾ������ϵ���˵���
		if(actionEvent.getSource()==jMenuDelDep){
			//����ɾ���༶������
			DelDepartment delDep=new DelDepartment();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(delDep);
			//�����ɼ�
			this.setVisible(true);
		}

		//������������˵��µġ����ڡ��˵���
		if(actionEvent.getSource()==jMenuHelpAbout)
		{
			//���������ڡ�������
			AboutMe about=new AboutMe();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(about);
			//�����ɼ�
			this.setVisible(true);
		}
	}
} 
