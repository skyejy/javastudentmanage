package studentmanager;

//ɾ���༶�����

//����ϵͳ�����
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

//������ɾ���༶��塱��
public class DelClass extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//�����������ݿ����
	Connection conn;
	//����SQL������
	Statement st;
	//�����������
	JLabel jLabel1=new JLabel("�������ɾ���İ༶�İ༶�ţ�");
	JTextField jTextField1=new JTextField();
	JLabel jLabel2 = new JLabel("(6λ��,��:201604)");
	JButton jButton1=new JButton("ɾ��");
	JButton jButton2=new JButton("ȷ��ɾ��");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	
	//���췽��
	public DelClass()
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
		//�������ݿ�
		conn=DBConnect.getConn();
		st=conn.createStatement();
		//��ܵĲ���
		this.setLayout(null);
		//���ø�����Ĵ�С
		jLabel1.setFont(new java.awt.Font("����",Font.BOLD,14));
		jLabel1.setBounds(new Rectangle(30,10,210,30));
		jTextField1.setBounds(new Rectangle(250,13,80,25));
		jLabel2.setBounds(new Rectangle(250, 40, 120, 30));
		jButton1.setBounds(new Rectangle(100,70,170,30));
		jButton2.setBounds(new Rectangle(100,205,170,30));
		jScrollPane1.setBounds(new Rectangle(90,80,180,110));
		//��Ӱ�ť�����¼�
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		//�����������
		this.add(jLabel1);
		this.add(jTextField1);
		this.add(jLabel2);
		this.add(jButton1);
		this.add(jButton2);
		jButton2.setVisible(false);
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		jScrollPane1.setVisible(false);
	}
	//�����ť�¼�
	public void actionPerformed(ActionEvent e)
	{
		//��ȡ�û�����İ༶��
		String banjihao=jTextField1.getText();
		
		//�༶�Ų����ڵĲ�����ɾ�������ز����Ѵ��󣺸ð༶���Ѿ������ڡ�
		try{
			ResultSet rs1=st.executeQuery("select * from classinfo where ClassId='"+banjihao+"'");
			if(!(rs1.next())){
				JOptionPane.showMessageDialog(this,"�ð༶�Ų����ڣ��������ɾ����");
				return;
				}
			}catch(Exception ex){
				//��������쳣��������Ϣ�Ի�����ʾ���ܲ��룬����ʾ�쳣����Ϣ
				ex.printStackTrace();
			}
		
		//ɾ��֮ǰ��ʾҪɾ���İ༶��Ϣ
		jButton1.setVisible(false);
		jScrollPane1.setVisible(true);
		jButton2.setVisible(true);
		try{
			//����st����ִ��SQL��䣬���ؽ��������
			ResultSet rs2=st.executeQuery("select * from classinfo where ClassId='"+banjihao+"'");
			//��������:������ʾ������еļ�¼
			//�˴�û��ʹ��while����Ϊ�༶����Ψһ�ģ����������ǣ�������InquireOnNamePanel.java��ʹ����while
			if(rs2.next()){
				jTextArea1.append("�༶��:"+rs2.getString("ClassId")+"\n������:"+rs2.getString("ClassTeacher")+"\n�༶����:"+rs2.getString("StuNum")+"\nϵ��:"+rs2.getString("XiId"));
			}
			else
				JOptionPane.showMessageDialog(this,"û������༶��!");
			}
		catch(Exception ex){
			//������Ϣ�Ի�����ʾ��ѯʧ��
			JOptionPane.showMessageDialog(this,"��ѯʧ��!");
			}
		
		//���ɾ��֮��Ҫ�ȴ��û��鿴�༶��Ϣ֮����ȷ��ɾ��
		if(e.getSource()==jButton1)
			return;
		//ɾ����ť�¼�ֻ��ִ�е���������ͷ����ˡ�ʣ�µ�����ȷ��ɾ����
		
		//Ҫ���û�ȷ��ɾ��
		if(JOptionPane.showConfirmDialog(this,"ȷ��Ҫɾ����")==JOptionPane.YES_OPTION)
		{
			try{
				//����st����ִ��SQLɾ������
				st.executeUpdate("delete from classinfo where ClassId='"+banjihao+"'");
				//������Ϣ�Ի�����ʾɾ�������ɹ�
				JOptionPane.showMessageDialog(this,"ɾ�������ɹ�!");
				//�������༶�ŵ��ı���
				jTextField1.setText("");
				// ÿ��ȷ��ɾ��֮�����ԭ��Ҫɾ���İ༶��Ϣ�������´�ɾ���������ϴ΄h���İ༶��Ϣ
				jTextArea1.setText("");
				jScrollPane1.setVisible(false);
				jButton2.setVisible(false);
				jButton1.setVisible(true);
				}
			catch(Exception ex){
			//������Ϣ�Ի�����ʾ����ɾ��
			JOptionPane.showMessageDialog(this,"ɾ������ִ��ʧ��!");
			}
		}
	}
}

