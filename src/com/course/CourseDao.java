package com.course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.ConProvider;
import com.javatpoint.Formatter;
public class CourseDao {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Statement st = null;
	public static int save(String CNAME,String CMINDURATION,String CMAXDURATION,String COURSEFILENAME,String CAUTHOR,String courseRoleName){
		int status=0;
		try{
			con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into COURSE_DETAILS(CID,CNAME,CMINDURATION,CMAXDURATION,COURSEFILENAME,CAUTHOR,COURSEDATE,COURSEROLEID) values(COURSE_ID.NEXTVAL,?,?,?,?,?,?,?)");
			ps.setString(1,CNAME);
			ps.setString(2,CMINDURATION);
			ps.setString(3,CMAXDURATION);
			ps.setString(4,COURSEFILENAME);
			ps.setString(5,CAUTHOR);
			ps.setDate(6,Formatter.getCurrentDate());
			ps.setString(7,courseRoleName);
			status=ps.executeUpdate();
			System.out.println(Formatter.getCurrentDate());

		}catch(Exception e){System.out.println(e);}
		finally{
			ConProvider.cleanUp(ps, con);
		}
		return status;
	}

	public void deleteUser(int CID) {
		try {
			con=ConProvider.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement("delete from COURSE_DETAILS where CID=?");
			preparedStatement.setInt(1, CID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(ps, con);
		}
	}
	public void updateCourse(Course course) {
		try {
			con=ConProvider.getConnection();
			ps = con
					.prepareStatement("update COURSE_DETAILS set CNAME=?, CMINDURATION=?, CMAXDURATION=?, COURSEFILENAME=?, CAUTHOR=?, COURSEDATE=?,COURSEROLEID=?" +
							"where CID=?");
			ps.setString(1, course.getCname());
			ps.setInt(2, course.getCminDuration());
			ps.setInt(3, course.getCmaxDuration());
			ps.setString(4, course.getFileName());
			ps.setString(5, course.getCauthor());
			ps.setDate(6, Formatter.getCurrentDate());
			ps.setInt(5, course.getCid());
			ps.setInt(7,course.getCourseRoleId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(ps, con);
		}
	}

	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		try {
			 con=ConProvider.getConnection();

			 st = con.createStatement();
			rs = st.executeQuery("select * from COURSE_DETAILS");
			while (rs.next()) {
				Course course = new Course();
				course.setCid(rs.getInt("CID"));
				course.setCname(rs.getString("CNAME"));
				course.setCminDuration(rs.getInt("CMINDURATION"));
				course.setCmaxDuration(rs.getInt("CMAXDURATION"));
				course.setFileName(rs.getString("COURSEFILENAME"));
				course.setCauthor(rs.getString("CAUTHOR"));
				course.setCOURSEDATE(rs.getDate("COURSEDATE"));
				course.setCourseRoleId(rs.getInt("COURSEROLEID "));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(rs, st, con);
		}

		return courses;
	}

	public Course getCourseById(int courseId) {
		Course course = new Course();
		try {
			con=ConProvider.getConnection();
			 ps = con.
					prepareStatement("select * from COURSEDETAILS where CID=?");
			ps.setInt(1, courseId);
			rs = ps.executeQuery();

			if (rs.next()) {
				course.setCid(rs.getInt("CID"));
				course.setCname(rs.getString("CNAME"));
				course.setCminDuration(rs.getInt("CMINDURATION"));
				course.setCmaxDuration(rs.getInt("CMAXDURATION"));
				course.setFileName(rs.getString("COURSEFILENAME"));
				course.setCOURSEDATE(rs.getDate("COURSEDATE"));
				course.setCauthor(rs.getString("CAUTHOR"));
				course.setCourseRoleId(rs.getInt("COURSEROLEID "));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(rs, st, con);
		}

		return course;
	}
}
