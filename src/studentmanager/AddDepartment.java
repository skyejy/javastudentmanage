package studentmanager;

//��Ӳ���ϵ�����
//����ϵͳ�����
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//��������Ӳ���ϵ��塱�࣬���̳�Jpanel�࣬�Ͷ������������
public class AddDepartment extends JPanel implements ActionListener 
{
	//����һ����̬���������͵ı���serialVersionUID���˴���֪ʲô�ã�����û�����,������о��档��д�������У�Ҳ��Ӱ��������С�
	private static final long serialVersionUID = 1L;
	//����һ���������ݿ�Ķ���
	Connection conn;
	//����һ������������ִ��SQL���
	Statement statement;
	/*
	 * �����Ǵ���������󣺱�ǩ���ı��С���ѡ����ť��ϸ��
	 */
	//����һ����ǩ����DepNum������ʾϵ��
	JLabel DepNum=new JLabel("ϵ�ţ�");
	//����һ���ı���������DepNum2��������ϵ���ַ���
	JTextField DepNum2=new JTextField();
	//����һ����ǩ����xiHaoFormat������ʾ��ע��ϵ�ŵĸ�ʽ
	JLabel xiHaoFormat=new JLabel("ϵ��2λ������:02");
	//����һ����ǩ����DepName������ʾϵ��
	JLabel DepName=new JLabel("ϵ����");
	//����һ���ı���������DepName2��������ϵ���ַ���
	JTextField DepName2=new JTextField();
	//����һ����ǩ����xiTeacher������ʾϵ����
	JLabel xiTeacher=new JLabel("ϵ���Σ�");
	//����һ���ı���������xiTeacher2��������ϵ�����ַ���
	JTextField xiTeacher2=new JTextField();
	//����һ����ť����addDep������Ӳ���ϵ��Ϣ�����ݿ�
	JButton addDep=new JButton("��Ӳ���ϵ");
	//��Ӳ���ϵ�����Ĺ��췽��
	public AddDepartment()
	{
		try{
			//������Ӳ���ϵ�ĳ�ʼ������
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	//��Ӳ���ϵͼ�ν���ĳ�ʼ����������ʼ���������������
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
		//��ǩ��ϵ�ŵĴ�С��λ�á�
		//setBounds(new Rectangle(x,y,w,h)),�ƶ�������������С���� x �� y ָ�����Ͻǵ���λ�ã��� w�� hָ���µĴ�С,ʹ������µ��н���� ��
		DepNum.setBounds(new Rectangle(60,20,65,25));
		//�ı������ϵ�ţ��Ĵ�С��λ��
		DepNum2.setBounds(new Rectangle(105,20,50,25));
		//��ǩ��ϵ�Ÿ�ʽ���Ĵ�С��λ��
		xiHaoFormat.setBounds(new Rectangle(170,20,170,25));
		//��ǩ��ϵ�����Ĵ�С��λ��
		DepName.setBounds(new Rectangle(60,65,53,22));
		//�ı������ϵ�����Ĵ�С��λ��
		DepName2.setBounds(new Rectangle(105,65,150,25));
		//��ǩ��ϵ���Σ��Ĵ�С��λ��
		xiTeacher.setBounds(new Rectangle(50,110,65,25));
		//�ı������ϵ���Σ��Ĵ�С��λ��
		xiTeacher2.setBounds(new Rectangle(105,110,100,25));
		//��ť����Ӳ���ϵ���Ĵ�С��λ��
		addDep.setBounds(new Rectangle(105,150,150,30));
		/** 
		 * �ԡ���Ӳ���ϵ����ť����Ӷ����¼���������������ǰ���塣
		 * �����¡���Ӳ���ϵ����ť�����Զ�����actionPerformed(ActionEvent e)����
		 * */
		addDep.addActionListener(this);
		/*
		 * �������ʼ����ɵĸ����������ӵ���ǰ���������ڡ�
		 */
		//��ӱ�ǩ��ϵ��
		this.add(DepNum);
		//����ı������ϵ��
		this.add(DepNum2);
		//��ӱ�ǩ��ϵ�Ÿ�ʽ
		this.add(xiHaoFormat);
		//��ӱ�ǩ��ϵ��
		this.add(DepName);
		//����ı������ϵ��
		this.add(DepName2);
		//��ӱ�ǩ��ϵ����
		this.add(xiTeacher);
		//����ı������ϵ����
		this.add(xiTeacher2);
		//��Ӱ�ť����Ӳ���ϵ
		this.add(addDep);
	}
	
	
	//�����ť��Ӳ���ϵ���и��������¼������ö���
	public void actionPerformed(ActionEvent e)
	{
		//����xiID�����Ѽ�ϵ����Ϣ
		String xiID=DepNum2.getText();
		//����xiName�����Ѽ�ϵ����Ϣ
		String xiName=DepName2.getText();
		//����xiT�����Ѽ�ϵ������Ϣ
		String xiTeacher=xiTeacher2.getText();
		//ϵ���Ѿ����ڵĲ�������룡���ز����Ѵ��󣺸�ϵ���Ѿ����ڡ�
		try{
			ResultSet rs=statement.executeQuery("select * from departmentinfo where xiID='"+xiID+"'");
			if(rs.next()){
				JOptionPane.showMessageDialog(this,"��ϵ���Ѿ����ڣ�����������룡");
				return;
				}
			}catch(Exception ex){
					//��������쳣��������Ϣ�Ի�����ʾ���ܲ��룬����ʾ�쳣����Ϣ
				ex.printStackTrace();
			}
		
		//��һ�������飬ϵ��Ϊ�ǿգ���ϵ����2λ������ϵ���ǿգ�������������
		if(!((xiID.length())==2 && (xiName.length())>0)){
			JOptionPane.showMessageDialog(this,"�������ݸ�ʽ��������������룡");
			return;
		}
		
		//�쳣����
		try{
			//����statement����ִ��SQL��䣬���в������
			statement.executeUpdate("insert into departmentinfo values('"+xiID
					+"','"+xiName+"','"+xiTeacher+"')");
			//������Ϣ�Ի�����ʾ��������ɹ�
			//JOptionPane �����ڷ���ص���Ҫ���û��ṩֵ�����䷢��֪ͨ�ı�׼�Ի���
			JOptionPane.showMessageDialog(this,"���벿��ϵ��Ϣ�ɹ���");
			//����ı������ϵ�š�ϵ����ϵ��������
			DepNum2.setText("");
			DepName2.setText("");
			xiTeacher2.setText("");
		}catch(Exception ex){
			//��������쳣��������Ϣ�Ի�����ʾ���ܲ��룬����ʾ�쳣����Ϣ
			JOptionPane.showMessageDialog(this,"�������ݸ�ʽ������������룡");
			ex.printStackTrace();
		}
	}
}
