package com.hl.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String msg=null;
        //判断上传的表单是普通表单还是带文件文件表单
        if(!ServletFileUpload.isMultipartContent(req)){
            return;//终止方法运行，说明这是一个普通的表单
        }
        //创建上传文件的保存路径，建议在WEB—INF下，安全，用户无法直接访问上传的文件:
        String uploadPath = this.getServletContext().getRealPath("WEB-INF/upload");
        File uploadFile=new File(uploadPath);
        if(!uploadFile.exists()){
            uploadFile.mkdir();//创建这个文件
        }

        //缓存，临时文件
        //临时路径，假如文件超过了预期的小，我们就把它放在一个临时文件中，过几天自动删除，或者提醒用户转存为永久
        String tmpPath = this.getServletContext().getRealPath("WEB-INF/tmp");
        File tmpFile=new File(tmpPath);
        if(!tmpFile.exists()){
            uploadFile.mkdir();//创建这个临时目录
        }

        //处理上传的文件，一般通过流来获取，可以使用request.getInputStream(),原生态的文件上传流获取，十分麻烦
        //建议使用 Apache的文件上传组件来实现，common-fileupload，它需要依赖于 commons-io组件；
        //1、创建DiskFileItemFactory对象，处理文件上传路径或大小的限制
        DiskFileItemFactory factory = getDiskFileItemFactory(uploadFile);
        //2、获取ServletFileUpload
        ServletFileUpload upload = getServletFileUpload(factory);
        //3、处理上传的文件
        try {
            //把前端请求解析，封装成一个FileItem对象（表单中的输入项）
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem fileItem: fileItems) {
                if(fileItem.isFormField()){
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    System.out.println(name+":"+value);
                }else {
                    //****************************处理文件****************************
                    //拿到文件名字
                    String uploadFileName = fileItem.getName();
                    System.out.println("上传的文件名："+uploadFileName);
                    if (uploadFileName.trim().equals("") || uploadFileName==null){
                        continue;
                    }
                    //获得上传的文件名
                    String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/")+1);
                    //获得文件的后缀名
                    String fileExName = uploadFileName.substring(uploadFileName.lastIndexOf(".")+1);
                    /*
                     * 如果文件后缀名fileExName不是所需的直接return，不进行处理，告诉用户文件类型不对
                     * */
                    System.out.println("文件信息 [文件名："+fileName+"---文件类型"+fileExName+"]");
                    //可以使用UUID（唯一识别通用码）保证文件名唯一
                    String uuidPath = UUID.randomUUID().toString();
                    //****************************处理文件完毕****************************
                    //真实存在的路径
                    String realPath = uploadPath+"/"+uuidPath;
                    //给每个文件创建一个对应的文件夹
                    File realPathFile = new File(realPath);
                    if (!realPathFile.exists()){
                        realPathFile.mkdir();
                    }

                    //****************************文件传输****************************
                    //获得文件上传流
                    InputStream inputStream = fileItem.getInputStream();
                    //创建一个文件输出流
                    //realPath=真实文件的名字+"/"+uuidFileName
                    FileOutputStream fos=new FileOutputStream(realPath+"/"+fileName);

                    //创建一个缓冲区
                    byte[] buffer=new byte[1024*1024];
                    //判断是否读取完毕
                    int len=0;
                    while ((len=inputStream.read(buffer))>0){
                        fos.write(buffer,0,len);
                    }
                    fos.close();
                    inputStream.close();
                    msg = "文件上传成功";
                    //将数据发给前端
                    req.setAttribute("msg",msg);
                    req.getRequestDispatcher("index.jsp").forward(req,resp);
                    fileItem.delete();//上传成功，清除临时文件
                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    public static DiskFileItemFactory getDiskFileItemFactory(File file){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //通过这个工厂设置一个缓冲区，当上传的文件大于这个缓冲区的时候，将他放到临时文件中
        factory.setSizeThreshold(1024*1024); //缓冲区大小为1M
        factory.setRepository(file);//临时文件保存的目录，需要一个File
        return factory;
    }

    public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory){
        ServletFileUpload upload = new ServletFileUpload(factory);
        //监听文件上传进度
        upload.setProgressListener(new ProgressListener() {
            //@Override
            //pBytesRead:已经读取到的文件大小
            //pContentLength ： 文件大小
            public void update(long pBytesRead, long pContentLength, int pItems) {
                System.out.println("总大小："+pContentLength+"已上传"+pBytesRead);
            }
        });
        //处理乱码问题
        upload.setHeaderEncoding("utf-8");
        //设置单个文件的最大值
        upload.setFileSizeMax(1024*1024*10);
        //设置总共能够上传文件的大小
        upload.setSizeMax(1024 * 1024 * 10);
        return upload;
    }
}
