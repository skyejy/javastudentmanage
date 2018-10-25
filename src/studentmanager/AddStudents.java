package studentmanager;

//���ѧ�������
//����ϵͳ�����
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//���������ѧ����塱�࣬���̳�Jpanel�࣬�Ͷ������������
public class AddStudents extends JPanel implements ActionListener 
{
	//����һ����̬���������͵ı���serialVersionUID���˴���֪ʲô�ã�����û�����,������о��档��д�������У�Ҳ��Ӱ��������С�
	//private static final long serialVersionUID = 1L;
	//����һ���������ݿ�Ķ���
	Connection conn;
	//����һ������������ִ��SQL���
	Statement statement;
	/*
	 * �����Ǵ���������󣺱�ǩ���ı��С���ѡ����ť��ϸ��
	 */
	//����һ����ǩ����stuNo������ʾѧ��
	JLabel stuNo=new JLabel("ѧ�ţ�");
	//����һ���ı���������stuNo2��������ѧ���ַ���
	JTextField stuNo2=new JTextField();
	//����һ����ǩ����noFormat������ʾ��ע��ѧ�ŵĸ�ʽ
	JLabel noFormat=new JLabel("ѧ����10λ��,��:2016010203");
	//����һ����ǩ����stuName������ʾ����
	JLabel stuName=new JLabel("������");
	//����һ���ı���������stuName2�������������ַ���
	JTextField stuName2=new JTextField();
	//����һ����ǩ����stuSex������ʾ�Ա�
	JLabel stuSex=new JLabel("�Ա�");
	//����һ����ѡ��ť����sex_boy����ѡ���С�
	JRadioButton sex_boy=new JRadioButton("��");
	//����һ����ѡ��ť����sex_girl����ѡ��Ů��
	JRadioButton sex_girl=new JRadioButton("Ů");
	//����һ����ѡ��ť��϶���sex_group��������������ѡ��ť���һ��ȷ��ֻ��һ����ѡ��ť��ѡ��
	ButtonGroup sex_group=new ButtonGroup();
	//����һ����ǩ����stuBirthDate������ʾ��������
	JLabel stuBirthDate=new JLabel("�������ڣ�");
	//����һ���ı���������stuBirthDate2����������������ַ���
	JTextField stuBirthDate2=new JTextField();
	//����һ����ǩ����BirthDateFormat������ʾ��ע��������ڵĸ�ʽ
	JLabel BirthDateFormat=new JLabel("ע��!�������ڸ�ʽΪ:1990-02-15");
	//����һ����ǩ����stuBirthPlace������ʾ������
	JLabel stuBirthPlace=new JLabel("���᣺");
	//����һ���ı���������stuBirthPlace2��������������ַ���
	JTextField stuBirthPlace2=new JTextField();
	//����һ����ť����addStu�������ѧ����Ϣ�����ݿ�
	JButton addStu=new JButton("���ѧ��");
	//���ѧ�������Ĺ��췽��
	public AddStudents()
	{
		try{
			//�������ѧ���ĳ�ʼ������
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	//���ѧ��ͼ�ν���ĳ�ʼ����������ʼ���������������
	private void jbInit() throws Exception
	{
		//����DBConnect.java�ڵ�getConn����,��ʼ��conn�������������ݿ�
		conn=DBConnect.getConn();
		//�������ݿ�󣬳�ʼ��statement�������� SQL��䷢�͵����ݿ⡣
		statement=conn.createStatement();
		/*
		 * �Ȱѵ�ǰ��������this���Ĳ��ֹ������ÿգ�������µ��������ǰ���������С�
		 * setLayout,����java.awt.*�еĽӿڣ������JAVA_API_1.6.CHM�ļ���
		 */
		this.setLayout(null);
		/*
		 * ���ø�����Ĵ�С���ڵ�ǰ�����е�λ��
		 */
		//��ǩ��ѧ�ŵĴ�С��λ�á�
		//setBounds(new Rectangle(x,y,w,h)),�ƶ�������������С���� x �� y ָ�����Ͻǵ���λ�ã��� w�� hָ���µĴ�С,ʹ������µ��н���� ��
		stuNo.setBounds(new Rectangle(21,13,65,25));
		//�ı������ѧ�ţ��Ĵ�С��λ��
		stuNo2.setBounds(new Rectangle(65,15,100,25));
		//��ǩ��ѧ�Ÿ�ʽ���Ĵ�С��λ��
		noFormat.setBounds(new Rectangle(180,13,190,25));
		//��ǩ���������Ĵ�С��λ��
		stuName.setBounds(new Rectangle(21,51,53,22));
		//�ı�������������Ĵ�С��λ��
		stuName2.setBounds(new Rectangle(65,50,150,25));
		//��ǩ���Ա𣬵Ĵ�С��λ��
		stuSex.setBounds(new Rectangle(21,86,61,27));
		//��ѡ��ť���Ա��У��Ĵ�С��λ��
		sex_boy.setBounds(new Rectangle(70,85,65,25));
		//��ѡ��ť���Ա�Ů���Ĵ�С��λ��
		sex_girl.setBounds(new Rectangle(150,85,85,25));
		//����Ĭ�ϣ���ѡ(��)��ť��ѡ��
		sex_boy.setSelected(true);
		//��ǩ���������ڣ��Ĵ�С��λ��
		stuBirthDate.setBounds(new Rectangle(1,122,65,25));
		//�ı�����򣺳������ڣ��Ĵ�С��λ��
		stuBirthDate2.setBounds(new Rectangle(65,120,100,25));
		//��ǩ���������ڸ�ʽ���Ĵ�С��λ��
		BirthDateFormat.setBounds(new Rectangle(65,145,219,25));
		//��ǩ�������أ��Ĵ�С��λ��
		stuBirthPlace.setBounds(new Rectangle(21,180,55,25));
		//�ı�����򣺳����أ��Ĵ�С��λ��
		stuBirthPlace2.setBounds(new Rectangle(65,180,150,25));
		//��ť�����ѧ�����Ĵ�С��λ��
		addStu.setBounds(new Rectangle(103,217,180,30));
		/** 
		 * �ԡ����ѧ������ť����Ӷ����¼���������������ǰ���塣
		 * �����¡����ѧ������ť�����Զ�����actionPerformed(ActionEvent e)����
		 * */
		addStu.addActionListener(this);
		/*
		 * �������ʼ����ɵĸ����������ӵ���ǰ���������ڡ�
		 */
		//��ӱ�ǩ��ѧ��
		this.add(stuNo);
		//����ı������ѧ��
		this.add(stuNo2);
		//��ӱ�ǩ��ѧ�Ÿ�ʽ
		this.add(noFormat);
		//��ӱ�ǩ������
		this.add(stuName);
		//����ı������ѧ��
		this.add(stuName2);
		//��ӱ�ǩ���Ա�
		this.add(stuSex);
		//��ӵ�ѡ��ť����
		this.add(sex_boy);
		//��ӵ�ѡ��ť��Ů
		this.add(sex_girl);
		//�ٰ�����������ѡ��ť����ӵ���ť��϶���sex_group��
		sex_group.add(sex_boy);
		sex_group.add(sex_girl);
		//��ӱ�ǩ����������
		this.add(stuBirthDate);
		//����ı�����򣬳�������
		this.add(stuBirthDate2);
		//��ӱ�ǩ���������ڸ�ʽ
		this.add(BirthDateFormat);
		//��ӱ�ǩ��������
		this.add(stuBirthPlace);
		//����ı�����򣬳�����
		this.add(stuBirthPlace2);
		//��Ӱ�ť�����ѧ��
		this.add(addStu);
	}
	
	
	//�����ť���ѧ�����и��������¼������ö���
	public void actionPerformed(ActionEvent e)
	{
		//����xuehao�����Ѽ�ѧ����Ϣ
		String xuehao=stuNo2.getText();
		//����xingming�����Ѽ�������Ϣ
		String xingming=stuName2.getText();
		//����xingbie�����Ѽ��Ա���Ϣ
		String xingbie="";
		//�����ѡ��ť���С���ѡ����ôxingbie�ַ�������Ϊ���С�
		if(sex_boy.isSelected())
			xingbie="��";
		//�����ѡ��ť��Ů����ѡ����ôxingbie�ַ�������Ϊ��Ů��
		if(sex_girl.isSelected())
			xingbie="Ů";
		//����dateString�����Ѽ�����������Ϣ
		String dateString=stuBirthDate2.getText();
		//����jiguan�����Ѽ���������Ϣ
		String jiguan=stuBirthPlace2.getText();
		//ѧ���Ѿ����ڵĲ�������룡���ز����Ѵ��󣺸�ѧ���Ѿ����ڡ�
		try{
			ResultSet rs=statement.executeQuery("select * from studentsinfo where xuehao='"+xuehao+"'");
			if(rs.next()){
				JOptionPane.showMessageDialog(this,"��ѧ���Ѿ����ڣ�����������룡");
				return;
				}
			}catch(Exception ex){
					//��������쳣��������Ϣ�Ի�����ʾ���ܲ��룬����ʾ�쳣����Ϣ
				ex.printStackTrace();
			}
		//����CheckDateFormat.java�е�CheckDateFormat��,����һ������
		//�ö������checkDateFormat()�����������������Ƿ�Ϸ���
		CheckDateFormat cdf=new CheckDateFormat();
		//��һ�������飬����Ϊ�ǿգ���ѧ����10λ�����ҳ������ڸ�ʽ��ȷ��������������
		if(!((xuehao.length())==10 && (xingming.length())>0&&cdf.checkDateFormat(dateString))){
			JOptionPane.showMessageDialog(this,"�������ݸ�ʽ��������������룡");
			return;
		}
		
		//�쳣����
		try{
			//����statement����ִ��SQL��䣬���в������
			statement.executeUpdate("insert into studentsinfo values('"+xuehao
					+"','"+xingming+"','"+xingbie+"','"
					+dateString+"','"+jiguan+"','"+xuehao.substring(0,6)+"')");
			//������Ϣ�Ի�����ʾ��������ɹ�
			//JOptionPane �����ڷ���ص���Ҫ���û��ṩֵ�����䷢��֪ͨ�ı�׼�Ի���
			JOptionPane.showMessageDialog(this,"����ѧ����Ϣ�ɹ���");
			//����ı������ѧ�š��������������ڡ����������
			stuNo2.setText("");
			stuName2.setText("");
			stuBirthDate2.setText("");
			stuBirthPlace2.setText("");
		}catch(Exception ex){
			//��������쳣��������Ϣ�Ի�����ʾ���ܲ��룬����ʾ�쳣����Ϣ
			JOptionPane.showMessageDialog(this,"�������ݸ�ʽ������������룡");
			ex.printStackTrace();
		}
	}
}
