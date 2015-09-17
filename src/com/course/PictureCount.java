package com.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javatpoint.ConProvider;

public class PictureCount {


	public static int getPictureCount(String courseId) throws SQLException{
		Connection con=ConProvider.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pictureCount =0;
		try {
			ps = con.prepareStatement("select max(PICTURE_COUNT) as picture_count  from CoursePicture where  CourseID  = ?");
			ps.setString(1, courseId);
			rs = ps.executeQuery();
			rs.next();
			pictureCount = rs.getInt("PICTURE_COUNT");
			System.out.println("******PICTURE COUNT CLASS******"+pictureCount);

		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		} finally{
			ConProvider.cleanUp(rs, ps, con);
		}

		return pictureCount;
	}
}
