package com.cos.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//서블릿이란 Dynamic Web Page를 만들 때 사용되는 자바 기반의 웹 애플리케이션(WAS)
// 클라이언트에서 요청, 응답
@WebServlet("/test") //주소
public class ApiTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ApiTest() {
        super();
    }
    
    //실행의 흐름 init -> service -> destroy
    @Override
    public void init() throws ServletException {
    	super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	super.service(req, resp);
    }
    
    @Override
    public void destroy() {
    	super.destroy();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mime = request.getContentType();
		System.out.println(mime);
		
		String food = request.getParameter("food");
		System.out.println(food);
		
		//주소창에 /test뒤에 ?food="김치찌개" 하면 콘솔창에 김치찌개가 찍힘
		
		// DB에 접속해서 결과를 찾아서 리턴
		// 객체
		
//		response.setContentType("text/plain;charset=utf-8");	//평서문으로 읽음 -->문자 그 자체
		response.setContentType("text/html;charset=utf-8");	//html파일
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>"+food+"</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush(); //위에 자료들을 비움
		
	}

	//사용자가 insert 하기위해서 post 방식을 많이 사용함
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String food = request.getParameter("food");
		String recipe = request.getParameter("recipe");
		
		System.out.println(food);
		System.out.println(recipe);
		
		//값을 받아서 DB에 insert하고 끝
		int result =1; // db에 입력 성공 or -1
		if(result ==1) {
			// 성공 응답
		}
		else {
			// 실패응답
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>포스트방식입니다.</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush(); //위에 자료들을 비움
		
	}

}
