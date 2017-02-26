package servlet;

import java.io.*;  
import java.util.List;  
  
import javax.enterprise.inject.New;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import DAO.DetailMessDao;
import entity.DetailMess;
/** 
 *  
 * @author Administrator 
 * �ļ��ϴ� 
 * ���岽�裺 
 * 1����ô����ļ���Ŀ���� DiskFileItemFactory Ҫ���� 
 * 2�� ���� request ��ȡ ��ʵ·�� ������ʱ�ļ��洢���� �����ļ��洢 ���������洢λ�ÿɲ�ͬ��Ҳ����ͬ 
 * 3���� DiskFileItemFactory ��������һЩ ���� 
 * 4����ˮƽ��API�ļ��ϴ�����  ServletFileUpload upload = new ServletFileUpload(factory); 
 * Ŀ���ǵ��� parseRequest��request������  ��� FileItem ����list �� 
 *      
 * 5���� FileItem ������ ��ȡ��Ϣ��   ������ �ж� ���ύ��������Ϣ �Ƿ��� ��ͨ�ı���Ϣ  �������� 
 * 6�� 
 *    ��һ��. �õ����� �ṩ��  item.write( new File(path,filename) );  ֱ��д�������� 
 *    �ڶ���. �ֶ�����   
 * 
 */  
public class dodetailmess extends HttpServlet {  
	String username;
	String name;
	 String idcard;
	 String idcardfile;
	 int age=1;
	
	 String ismerried;
	 String ishouse;
	 String housefile;
	 String iscar;
	 String phone;
	 String address;
	 String tradepass;
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
          
        request.setCharacterEncoding("utf-8");  //���ñ���  
        PrintWriter out = response.getWriter();
        //��ô����ļ���Ŀ����  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //��ȡ�ļ���Ҫ�ϴ�����·��  
//        String path = this.getServletContext().getRealPath("/upload"); 
        String path ="D:/MyEclipse 10/workbench/Finance/WebRoot/upload";
//        System.out.println(path);
          
        //���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬  
        //������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ  
        /** 
         * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ�  
         * ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem ��ʽ��  
         * Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ���� 
	         */  
	        factory.setRepository(new File(path));  
        //���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��  
        factory.setSizeThreshold(1024*1024) ;  
          
        //��ˮƽ��API�ļ��ϴ�����  
        ServletFileUpload upload = new ServletFileUpload(factory);  
          
          ishouse="no";
          iscar="no";
          ismerried="no";
        try {  
            //�����ϴ�����ļ�  
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
              
            for(FileItem item : list)  
            {  
                //��ȡ������������  
                String name1 = item.getFieldName();  
//                System.out.println(name1);
                if ("Username".equals(name1))
                {
                	username = item.getString("utf-8") ;  
                }
                if ("Name".equals(name1))
                {
                	name = item.getString("utf-8") ;  
                }
                if ("IDcard".equals(name1))
                {
                	idcard = item.getString("utf-8") ;  
                }
                if ("IDcardfile".equals(name1))
                {
                	idcardfile = item.getName() ;  
                	
                }
                if ("Age".equals(name1))
                {
                	age = Integer.parseInt(item.getString("utf-8")) ;  
                }
                if ("Ismerried".equals(name1))
                {
                	ismerried = "yes";  
                }
                
             
                if ("Ishouse".equals(name1))
                {
                	ishouse = "yes" ;  
                }
              
                if ("Housefile".equals(name1))
                {
                	housefile = item.getName();  
                }
                if ("Iscar".equals(name1))
                {
                	iscar = "yes" ;  
                }
                
                if ("Phone".equals(name1))
                {
                	phone = item.getString("utf-8") ;  
                }
                if ("Address".equals(name1))
                {
                	address = item.getString("utf-8") ;  
                }
                if ("Tradepass".equals(name1))
                {
                	tradepass = item.getString("utf-8") ;  
                }
                //�����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ 
            }
           
            for(FileItem item : list){
            	
                if(item.isFormField())  
                {                     
                    //��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�  
                   
                                   
                 
                 
                }  
                //�Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ  
                else  
                {  
                    /** 
                     * ������������Ҫ��ȡ �ϴ��ļ������� 
                     */  
                    //��ȡ·����  
                    String value = item.getName() ;  
                    //���������һ����б��  
                    int start = value.lastIndexOf("\\");  
                    //��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�  
                    String filename = value.substring(start+1);  
                      
                    request.setAttribute(name, filename);  
                   
                      
                    //����д��������  
                    //���׳����쳣 ��exception ��׽  
                      
                    //item.write( new File(path,filename) );//�������ṩ��  
                      
                    //�ֶ�д��  
                    OutputStream os = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                      
                    System.out.println("��ȡ�ϴ��ļ����ܹ���������"+item.getSize());  
  
                    // in.read(buf) ÿ�ζ��������ݴ����   buf ������  
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //��   buf ������ ȡ������ д�� ���������������  
                        os.write(buf, 0, length);  
                          
                    }  
                  
                    in.close();  
                    os.close();  
                   
                }  
            }
              
              
              
        } 
        catch (Exception e) {  
            // TODO Auto-generated catch block  
              
            //e.printStackTrace();  
        }  
        if (DetailMessDao.Findusername(username)==false){
        	out.println("<html><head>");
	          out.println("</head>");
	          out.println("<body>");
	          out.println("<script type='text/javascript'>");
	          out.println("alert('USER HAVE EXISTED')");
	          out.println("history.back()");
	          out.println("</script>");
	          out.println("</body>");
	          out.println("</html>");
	          return;
        }
        if (name.length()==0||age==1||address.length()==0||tradepass.length()==0||phone.length()==0||idcard.length()==0||idcardfile.length()==0||("yes".equals(ishouse)==true&&housefile.length()==0)){
        	
        	out.println("<html><head>");
	          out.println("</head>");
	          out.println("<body>");
	          out.println("<script type='text/javascript'>");
	          out.println("alert('COMPLETE YOUR INFORMATION')");
	          out.println("history.back()");
	          out.println("</script>");
	          out.println("</body>");
	          out.println("</html>");
	          return;
	         
	       }
       
        
    	
//        username = (String) request.getAttribute("Username");
//        name = (String) request.getAttribute("Name");
//        idcard = (String) request.getAttribute("IDcard");
//        idcardfile =(String) request.getAttribute("IDcardfile");
//        age = Integer.parseInt((String) request.getAttribute("Age"));
//        if (request.getAttribute("Ismerried")!=null);
//        { ismerried="yes";}
//        
////        temp = (String) request.getAttribute("Ishouse");
////        if (temp!= null){ ishouse="yes";}
////        housefile = (String) request.getAttribute("Housefile");
////        temp =  (String) request.getAttribute("Iscar");
////        if (temp!= null){ iscar="yes";}
////        phone = (String) request.getAttribute("Phone");
////        address = (String) request.getAttribute("Address");
////        tradepass = (String) request.getAttribute("Tradepass");
     DetailMessDao.InsertInfo(username, name, idcard, idcardfile, age, ismerried, ishouse, housefile, iscar, phone, address, tradepass);
     response.sendRedirect("/Finance/pcenter.jsp");
//        System.out.println(username);
//        System.out.println(name);
//        System.out.println(idcard);
//        System.out.println(idcardfile);
//        System.out.println(age);
//        System.out.println(ismerried);
//        System.out.println(iscar);
//       System.out.println(ishouse);
//       System.out.println(housefile);
//       System.out.println(tradepass);
//       System.out.println(phone);
//       System.out.println(address);
    }  
  
} 