package com.course.dao;

import java.sql.*;
import java.util.*;

import com.course.model.Course;
import com.javatpoint.ConProvider;

public class CourseDao {

    private Connection connection;
    private PreparedStatement ps =null;
    ResultSet rs = null;
    Statement statement=null;
    /*public CourseDao() {
        connection = ConProvider.getConnection();
    }*/

    public void checkCourse(Course course) {
        try {
    		connection = ConProvider.getConnection();
            PreparedStatement ps = connection.prepareStatement("select cname from COURSE_DETAILS  where cid = ?");
            ps.setInt(1, course.getCid());
             rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateCourse(course);
            } 
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }finally{
			ConProvider.cleanUp(rs, ps, connection);
		} 
    }
    public void deleteCourse(int  cid) {
        try {
    		connection = ConProvider.getConnection();
             ps = connection.prepareStatement("delete from COURSE_DETAILS where cid=?");
            ps.setInt(1, cid);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
			ConProvider.cleanUp(ps, connection);
		} 
    }

    public void updateCourse(Course course) {
        try {
    		connection = ConProvider.getConnection();
            ps = connection.prepareStatement("update COURSE_DETAILS set cname=?, cminduration=?, cmaxduration=?, CAUTHOR=?, COURSEROLEID =?"
                    + "where cid=?");
            System.out.println("UPDATE COURSE"+course.getCname());
            ps.setString(1,course.getCname());
            ps.setInt(2, course.getCmin());
            ps.setInt(3, course.getCmax());
            ps.setString(4, course.getCauthor());
            ps.setInt(6, course.getCid());
            ps.setString(5, course.getCourseRoleId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
			ConProvider.cleanUp(ps, connection);
		}
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<Course>();
        try {
    		connection = ConProvider.getConnection();
             statement = connection.createStatement();
             rs = statement.executeQuery("select * from COURSE_DETAILS");
            while (rs.next()) {
            	Course course = new Course();
            	course.setCid(rs.getInt("CID"));
            	course.setCname(rs.getString("CNAME"));
            	course.setCmin(rs.getInt("CMINDURATION"));
            	course.setCmax(rs.getInt("CMAXDURATION"));
            	course.setCauthor(rs.getString("CAUTHOR"));
            	course.setCfileName(rs.getString("COURSEFILENAME"));
            	course.setCourseRoleId(rs.getString("COURSEROLEID"));
            	courses.add(course);
            	}
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
			ConProvider.cleanUp(rs,statement, connection);
		}

        return courses;
    }

    public List<Course> getAllCorsesforNormalUser(String courseRoleName) {
        List<Course> courses = new ArrayList<Course>();
        ResultSet rs = null;
        try {
    		connection = ConProvider.getConnection();
            statement = connection.createStatement();
            if(courseRoleName.equals("Test Analyst")){
                rs = statement.executeQuery("select * from COURSE_DETAILS where COURSEROLEID = 'Test Analyst'");
            }else if(courseRoleName.equals("Team Lead"))
            {
                rs = statement.executeQuery("select * from COURSE_DETAILS where COURSEROLEID in ('Team Lead','Test Analyst')");
            }else if(courseRoleName.equals("Test Manager"))
            {
                rs = statement.executeQuery("select * from COURSE_DETAILS ");
            }
            while (rs.next()) {
            	Course course = new Course();
            	course.setCid(rs.getInt("CID"));
            	course.setCname(rs.getString("CNAME"));
            	course.setCmin(rs.getInt("CMINDURATION"));
            	course.setCmax(rs.getInt("CMAXDURATION"));
            	course.setCauthor(rs.getString("CAUTHOR"));
            	course.setCfileName(rs.getString("COURSEFILENAME"));
            	course.setCourseRoleId(rs.getString("COURSEROLEID"));
            	courses.add(course);
            	}
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
			ConProvider.cleanUp(rs,statement, connection);
		}

        return courses;
    }
    public Course getCourseById(int cid) {
    	Course course = new Course();
        try {
    		connection = ConProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from COURSE_DETAILS where cid=?");
            preparedStatement.setInt(1, cid);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	course.setCid(rs.getInt("CID"));
            	course.setCname(rs.getString("CNAME"));
            	course.setCmin(rs.getInt("CMINDURATION"));
            	course.setCmax(rs.getInt("CMAXDURATION"));
            	course.setCauthor(rs.getString("CAUTHOR"));
            	course.setCfileName(rs.getString("COURSEFILENAME"));
            	course.setCourseRoleId(rs.getString("COURSEROLEID"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
			ConProvider.cleanUp(rs,statement, connection);
		}

        return course;
    }
}
