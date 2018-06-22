package at.technikumwien;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("calculator")
@SuppressWarnings("serial")
public class CalculatorServlet extends HttpServlet {
	private Calculator calculator;
	
	public CalculatorServlet() {
		calculator = new Calculator();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int operand1 = Integer.parseInt(request.getParameter("operand1"));
		int operand2 = Integer.parseInt(request.getParameter("operand2"));
		
		int sum = calculator.sum(operand1, operand2);
		
		PrintWriter out = response.getWriter();
		out.print("Summe: " + sum);
	}
}