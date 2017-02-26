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
 * 文件上传 
 * 具体步骤： 
 * 1）获得磁盘文件条目工厂 DiskFileItemFactory 要导包 
 * 2） 利用 request 获取 真实路径 ，供临时文件存储，和 最终文件存储 ，这两个存储位置可不同，也可相同 
 * 3）对 DiskFileItemFactory 对象设置一些 属性 
 * 4）高水平的API文件上传处理  ServletFileUpload upload = new ServletFileUpload(factory); 
 * 目的是调用 parseRequest（request）方法  获得 FileItem 集合list ， 
 *      
 * 5）在 FileItem 对象中 获取信息，   遍历， 判断 表单提交过来的信息 是否是 普通文本信息  另做处理 
 * 6） 
 *    第一种. 用第三方 提供的  item.write( new File(path,filename) );  直接写到磁盘上 
 *    第二种. 手动处理   
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
          
        request.setCharacterEncoding("utf-8");  //设置编码  
        PrintWriter out = response.getWriter();
        //获得磁盘文件条目工厂  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //获取文件需要上传到的路径  
//        String path = this.getServletContext().getRealPath("/upload"); 
        String path ="D:/MyEclipse 10/workbench/Finance/WebRoot/upload";
//        System.out.println(path);
          
        //如果没以下两行设置的话，上传大的 文件 会占用 很多内存，  
        //设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同  
        /** 
         * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上，  
         * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的  
         * 然后再将其真正写到 对应目录的硬盘上 
	         */  
	        factory.setRepository(new File(path));  
        //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
        factory.setSizeThreshold(1024*1024) ;  
          
        //高水平的API文件上传处理  
        ServletFileUpload upload = new ServletFileUpload(factory);  
          
          ishouse="no";
          iscar="no";
          ismerried="no";
        try {  
            //可以上传多个文件  
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
              
            for(FileItem item : list)  
            {  
                //获取表单的属性名字  
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
                //如果获取的 表单信息是普通的 文本 信息 
            }
           
            for(FileItem item : list){
            	
                if(item.isFormField())  
                {                     
                    //获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的  
                   
                                   
                 
                 
                }  
                //对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些  
                else  
                {  
                    /** 
                     * 以下三步，主要获取 上传文件的名字 
                     */  
                    //获取路径名  
                    String value = item.getName() ;  
                    //索引到最后一个反斜杠  
                    int start = value.lastIndexOf("\\");  
                    //截取 上传文件的 字符串名字，加1是 去掉反斜杠，  
                    String filename = value.substring(start+1);  
                      
                    request.setAttribute(name, filename);  
                   
                      
                    //真正写到磁盘上  
                    //它抛出的异常 用exception 捕捉  
                      
                    //item.write( new File(path,filename) );//第三方提供的  
                      
                    //手动写的  
                    OutputStream os = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                      
                    System.out.println("获取上传文件的总共的容量："+item.getSize());  
  
                    // in.read(buf) 每次读到的数据存放在   buf 数组中  
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //在   buf 数组中 取出数据 写到 （输出流）磁盘上  
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