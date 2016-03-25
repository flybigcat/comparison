package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

// import jar file, jar.zip -> uncompress -> .jar
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author Ann Huang
 * @date 02/19/2016
 * @description controller in the MVC architecture 
 * @functions receive request -> actions ->  response  
 * 				1. Receive url request (2 uploaded files) from client
 *              2. Store file contents in the RecordEntry Model
 *              3. Compare two file contents using HashMap record by record
 *              4. send comparison results(unique records) as response back to client
 * @Algorithm Using HashMap to compare two files contents
 * @Complixity Time: O(n)
 */
@WebServlet("/comparison")
public class ComparisonController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/*
	 * two HashMap for two input files contents
	 * */ 
	private HashMap<Integer, RecordEntry> fileMap1 = new HashMap<Integer, RecordEntry>();
	private HashMap<Integer, RecordEntry> fileMap2 = new HashMap<Integer, RecordEntry>();

	/**
	* @description Get Method
	* @argument request, response
	* @return none, but clear session and redirect client to entry page(home) entry.html
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//initialize maps
		fileMap1 = new HashMap<Integer, RecordEntry>();
		fileMap2 = new HashMap<Integer, RecordEntry>();
		
		//clear session
		HttpSession session = request.getSession();
		session.invalidate();
		
		//redirect to entry page
		request.getRequestDispatcher("/WEB-INF/entry.html").forward(request,
				response);
	}

	/**
	* @description Post Method
	* @argument request, response
	* @return none, but call compare method and send compare results back to results.jps page
	*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//process(read) input file
		fileProcessor(request, response);

		//compare two files contents using hash
		compareFileMaps();

		//package results in the session attribute
		getServletContext().setAttribute("fileMap1", fileMap1);
		getServletContext().setAttribute("fileMap2", fileMap2);

		//send back response with unique results back to client -> results.jsp
		request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request,
				response);
	}

	/**
	* @description read files, populate hashmaps
	* @argument request, response
	* @return none, process input two files
	*/
	private void fileProcessor(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// check input files
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean isMultipartContent = ServletFileUpload
				.isMultipartContent(request);
		if (!isMultipartContent) {
			out.println("Please upload files<br/>");
			return;
		}

		//read files
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();

			if (!it.hasNext() || fields.size() != 2) {
				out.println("Please upload two exiting files");
				return;
			}

			// for each files
			boolean flag = true;	//flag to distinguish two files
			while (it.hasNext()) {
				FileItem fileItem = it.next();

				boolean isFormField = fileItem.isFormField();
				if (!isFormField) {

					if(flag) getServletContext().setAttribute("fileName1", fileItem.getName());
					else	getServletContext().setAttribute("fileName2", fileItem.getName());
					
					
					InputStream stream = fileItem.getInputStream();
					BufferedReader br = new BufferedReader(
							new InputStreamReader(stream, "UTF-8"));
					String line = null;
					while ((line = br.readLine()) != null) {
						if (line.length() != 0 && line.charAt(0) != '#') {
							String[] lineContents = line.split("\\s+");

							RecordEntry entry = new RecordEntry();

							// populate two collections
							for (String str : lineContents) {
								if (!isNumeric(str)) { // id
									entry.name = str;
								} else {
									int i = Integer.parseInt(str);
									if (i > 1000)
										entry.id = i;
									else
										entry.addValue(i);
								}
							}

							if (flag) {
								fileMap1.put(entry.id, entry);
							} else {
								fileMap2.put(entry.id, entry);
							}
							out.println("<br/>");
						}
					}
				}

				flag = false;
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}

	/**
	* @description compare files
	* @argument none
	* @return none, compare two files contents using hash, if record unique-> RecordEntry.unique = true
	*/
	private void compareFileMaps() {

		for (Map.Entry<Integer, RecordEntry> entry : fileMap1.entrySet()) {
			if (fileMap2.containsKey(entry.getKey())) {
				// duplicate
				if (entry.getValue().equals(fileMap2.get(entry.getKey()))) {
					entry.getValue().unique = false;
					fileMap2.get(entry.getKey()).unique = false;
				}

			}
		}
	}

	/**
	* @description check input element is digit number or string, to help read files
	* @argument string
	* @return boolean, number ->true 
	*/
	public static boolean isNumeric(String str) {
		try {
			 Integer.parseInt(str);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

}
