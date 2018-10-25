package studentmanager;

//��������ѯѧ�������
//����ϵͳ�����
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//���������ѧ����塱��
public class InquireOnStuName extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//�����������ݿ����
	Connection conn;
	//����SQL������
	Statement st;
	//����������󣺱�ǩ���ı��С���ѡ
	JLabel jLabel1=new JLabel("���������ѯ��ѧ����������");
	JTextField jTextField1=new JTextField();
	JButton jButton1=new JButton("��ѯ");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	//���췽��
	public InquireOnStuName()
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
		jLabel1.setFont(new java.awt.Font("����",Font.BOLD,14));
		jLabel1.setBounds(new Rectangle(90,8,200,34));
		jTextField1.setBounds(new Rectangle(90,40,200,30));
		jButton1.setBounds(new Rectangle(110,75,150,30));
		jScrollPane1.setBounds(new Rectangle(40,115,308,130));
		//��Ӱ�ť�����¼�
		jButton1.addActionListener(this);
		//�����������
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		this.add(jLabel1);
		this.add(jTextField1);
		this.add(jButton1);
	}
	//�����ť�¼�
	public void actionPerformed(ActionEvent e)
	{
		//��ȡ�û����������
		String xingming=jTextField1.getText();
		//����Ϊ�գ���ʾ��������
		if(xingming.length()==0){
			JOptionPane.showMessageDialog(this,"����������!");
			return;
		}
		//����ı���ԭ�е�����
		jTextArea1.setText("");
		//��ѯ�Ƿ����
		try{
			//����st����ִ��SQL��䣬���ؽ��������
			//�˴���ģ����ѯlike
			ResultSet rs=st.executeQuery("select * from studentsinfo where xingming like '%"+xingming+"%'");
			//�鲻������ʾ��Ϣ
			if(!(rs.next())){
				JOptionPane.showMessageDialog(this,"û���������!");
				return;
			}
			rs=st.executeQuery("select * from studentsinfo where xingming like '%"+xingming+"%'");
			//��������:������ʾ������еļ�¼
			while(rs.next()){
				jTextArea1.append("ѧ��:"+rs.getString("xuehao")+"\n����:"+rs.getString("xingming")+"\n�Ա�:"+rs.getString("xingbie")+"\n��������:"
						+rs.getDate("dateString")+"\n����:"+rs.getString("jiguan")+"\n�༶��:"+rs.getString("ClassId")+"\n\n");
				//����ı��е�����
				jTextField1.setText("");
				}
			}
		catch(Exception ex){
			//������Ϣ�Ի�����ʾ��ѯʧ��
			JOptionPane.showMessageDialog(this,"��ѯʧ��!");
			}
	}
}
