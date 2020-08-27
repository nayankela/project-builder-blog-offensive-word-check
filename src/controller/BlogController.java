package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.User;
import utility.CheckBlogPost;

@WebServlet(urlPatterns = { "/blog" })
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BlogController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		System.out.println(blogDetails);
		String[] userBlog = blogDetails.split(",");
		String title = userBlog[0];
		String description = userBlog[1];
		LocalDate postedOn = LocalDate.now();

		User user = null;
		Blog blog = new Blog(title, description, postedOn);
		System.out.println(title);
		System.out.println(description);

		blog.setBlogTitle(title);
		blog.setBlogDescription(description);
		blog.setDate(postedOn);

		CheckBlogPost checkblogPost = new CheckBlogPost();
		boolean checkblog = checkblogPost.checkBlog(blog);

		if (checkblog) {
			request.setAttribute("blog", blog);
			request.setAttribute("user", user);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		} else {

			request.setAttribute("error",
					"Your blog cannot be added as it contains offensive words, Please check your blog");

			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);

		}

	}

}
