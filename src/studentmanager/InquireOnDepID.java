package studentmanager;

//��ϵ�Ų�ѯ����ϵ�����
//����ϵͳ�����
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//��������Ӳ���ϵ��塱��
public class InquireOnDepID extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//�����������ݿ����
	Connection conn;
	//����SQL������
	Statement st;
	//����������󣺱�ǩ���ı��С���ѡ
	JLabel jLabel1=new JLabel("���������ѯ�Ĳ���ϵ�ţ�");
	JTextField xiHAO=new JTextField();
	JLabel xiHAO2=new JLabel("ϵ����2λ����01");
	JButton jButton1=new JButton("��ѯ");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	//���췽��
	public InquireOnDepID()
	{
		try{
			//���ó�ʼ������
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	//����ʼ������
	private void jbInit() throws Exception
	{
		//�������ݿ�
		conn=DBConnect.getConn();
		st=conn.createStatement();
		//��ܵĲ���
		this.setLayout(null);
		//���ø�����Ĵ�С
		jLabel1.setFont(new java.awt.Font("����",Font.BOLD,16));
		jLabel1.setBounds(new Rectangle(46,4,222,32));
		xiHAO.setBounds(new Rectangle(47,37,100,31));
		xiHAO2.setBounds(new Rectangle(160,37,180,30));
		jButton1.setBounds(new Rectangle(47,86,247,30));
		jScrollPane1.setBounds(new Rectangle(24,130,305,109));
		//��Ӱ�ť�����¼�
		jButton1.addActionListener(this);
		//�����������
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		this.add(jLabel1);
		this.add(xiHAO);
		this.add(xiHAO2);
		this.add(jButton1);
	}
	//�����ť�¼�
	public void actionPerformed(ActionEvent e)
	{
		//��ȡ�û������ϵ��
		String xiid=xiHAO.getText();
		//����ı���ԭ�е�����
		jTextArea1.setText("");
		try{
			//����st����ִ��SQL��䣬���ؽ��������
			ResultSet rs=st.executeQuery("select * from departmentinfo where xiid='"+xiid+"'");
			//��������:������ʾ������еļ�¼
			//�˴�û��ʹ��while����Ϊϵ����Ψһ��
			if(rs.next()){
				jTextArea1.append("ϵ��:"+rs.getString("XiId")+"\nϵ��:"
						+rs.getString("xiName")+"\nϵ����:"+rs.getString("xiTeacher"));
				//����ı��е�����
				xiHAO.setText("");
			}
			else
				JOptionPane.showMessageDialog(this,"û�����ϵ��!");
		}
		catch(Exception ex){
			//������Ϣ�Ի�����ʾ��ѯʧ��
			JOptionPane.showMessageDialog(this,"��ѯʧ��!");
		}
	}
}
