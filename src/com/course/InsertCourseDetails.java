package com.course;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/InsertCourseDetails")
@MultipartConfig(
		location ="C:/Users/IBM_ADMIN/Desktop/Upload"
		//fileSizeThreshold = 1024 *1024 * 10,
	//	maxFileSize = 1024 * 1024 * 50
		)
public class InsertCourseDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cname=request.getParameter("cname");
		String cminDuration=request.getParameter("cminDuration");
		String cmaxDuration=request.getParameter("cmaxDuration");
		String cauthor=request.getParameter("cauthor");
		String courseRoleName = request.getParameter("userRole");
		String fileName = null;
		Collection<Part> parts = request.getParts();
		for(Part part:parts){
			System.out.println("NAme "+part.getName());
			System.out.println("HEADER: ");
			for (String headerName :part.getHeaderNames())
			{
				System.out.println(headerName+"\t\t"+part.getHeader(headerName));
			}
			String fileInfo = part.getHeader("content-disposition");
			System.out.println("********FILE INFO *********"+fileInfo);
			String fnames[] = fileInfo.split("\"");
			String fname = fnames[fnames.length-1];
			fileName = fname;
			part.write(fname);
		}

		System.out.println("*********************************************");
		System.out.println("EMAIL >>>>"+cname);
		System.out.println("cminDuration >>>>"+cminDuration);
		System.out.println("cmaxDuration >>>>"+cmaxDuration);
		System.out.println("cauthor >>>>"+cauthor);
		System.out.println("FILE  >>>>"+fileName);
		System.out.println("*********************************************");
		int status=CourseDao.save(cname, cminDuration, cmaxDuration, cauthor, fileName,courseRoleName);
		PpttoPNG.insertPicture(fileName);
		if(status>0){
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"FILE UPLOADED SUCESSFYLLY\")");
			out.println("</script>");
			request.getRequestDispatcher("CourseController?action=launchCourse");
		}
	}

}
