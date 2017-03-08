package com.huhang.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.huhang.entity.Success;
import com.huhang.service.ArgService;
import com.huhang.service.ModifyService;
import com.huhang.service.NonArgService;

/**
 * Servlet implementation class TotalController
 */
@WebServlet("/TotalController")
public class TotalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final int RECORDNUMBERPAGE =15;//record number page
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("GET request.");
		String URI=request .getRequestURI();
		String requestMethod=URI.substring(URI.lastIndexOf("/")+1);
		System.out.println(requestMethod);
		String methodString = null;
        if (requestMethod.equals("groups")) {
            methodString = "getGroups";

        } else if (requestMethod.equals("error_types")) {
            methodString = "getErrorTypes";
        }
		String jsonStr="";
		try {
			jsonStr=invokeAction(request, requestMethod, methodString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!"XMLHttpRequest".equals(request.getHeader("x-requested-with"))){
			System.out.println("Not ajax request");
			return;
		}
        constructResponse(response);
		System.out.println(jsonStr);
		response.getWriter().write(jsonStr);
	}



    protected String invokeAction(HttpServletRequest request,
                                  String requestMethod,
                                  String methodString)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NumberFormatException, Exception {
		String jsonStr=null;
		if(("groups".equals(requestMethod))||("error_types".equals(requestMethod))){
			Method method=NonArgService.class.getDeclaredMethod(methodString, null);
			jsonStr=(String)method.invoke(null);

		}else{
			ArgService argService =new ArgService();
			if("devices".equals(requestMethod)){
				int groupId=Integer.parseInt(request.getParameter("group_id"));
				jsonStr= argService.getDevices(groupId);
			}else if("errors".equals(requestMethod)){
                String sql = constructErrorHistorySQL(request);
				jsonStr= argService.getErrorHistory(sql);
			}else if("status".equals(requestMethod)){
				String sql="select " +
                        "RealTime.group_id," +
                        "DeviceGroup.name group_name," +
                        "RealTime.device_id," +
                        "Device.name device_name," +
                        "RealTime.status," +
                        "RealTime.error_code " +
                        "from RealTime,DeviceGroup,Device " +
                        "where RealTime.device_id=Device.id " +
                        "and RealTime.group_id=DeviceGroup.id ";
				if(request.getParameter("group_id")!=null)
					sql+="and RealTime.group_id="+request.getParameter("group_id")+" ";
				if(request.getParameter("page")!=null)
					sql+=("limit "+Integer.parseInt(request.getParameter("page"))* RECORDNUMBERPAGE +","+ RECORDNUMBERPAGE +"");
				System.out.println(sql);
				jsonStr= argService.getRealTimeStatus(sql);
			}
		}
		return jsonStr;
	}

    private String constructErrorHistorySQL(HttpServletRequest request) {
        String sql="select " +
                "DeviceGroup.id group_id," +
                "DeviceGroup.name group_name," +
                "Device.id device_id," +
                "Device.name device_name," +
                "ErrorHistory.start_time start," +
                "ErrorHistory.end_time," +
                "ErrorHistory.error_code " +
                "from DeviceGroup,Device,ErrorHistory " +
                "where DeviceGroup.id=Device.group_id " +
                "and ErrorHistory.device_id=Device.id " +
                "and ErrorHistory.group_id=Device.group_id ";
        if(request.getParameter("group_id")!=null)
            sql+=("and ErrorHistory.group_id="+request.getParameter("group_id")+" ");
        if(request.getParameter("device_id")!=null)
            sql+=("and device_id="+request.getParameter("device_id")+" ");
        if(request.getParameter("error_type")!=null)
            sql+=("and error_code="+request.getParameter("error_type")+" ");
        if(request.getParameter("days")!=null)
            sql+=("and start_time between now()-interval "+request.getParameter("days")+" day and now()"+" ");

        if(request.getParameter("page")!=null)
            sql+=("limit "+Integer.parseInt(
                    request.getParameter("page"))* RECORDNUMBERPAGE +","+ RECORDNUMBERPAGE +"");
        return sql;
    }

    protected String setSuccessStr(boolean isSuccess) {
		String jsonStr;
		Success success=new Success();
		success.setSuccess(isSuccess);
		jsonStr=new Gson().toJson(success);
		return jsonStr;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("name"));
		System.out.println("POST request.");
		String URI=request.getRequestURI();
		String requestMethod=URI.substring(URI.lastIndexOf("/")+1);
		String jsonStr="";
		if("login".equals(requestMethod)){
			String name=request.getParameter("username");
			String password=request.getParameter("password");
			if(request.getSession().getAttribute("user")!=null){
				jsonStr=setSuccessStr(true);
			}else{
				ArgService argService =new ArgService();
				boolean isSuccess= argService.doLogin(name, password);
				if(isSuccess==false){
					jsonStr = setSuccessStr(false);
				}else{
					jsonStr=setSuccessStr(true);
					request.getSession().setAttribute("username", name);
				}
			}
		}else if("groups".equals(requestMethod)){
			ModifyService modifyService =new ModifyService();
			jsonStr= modifyService.modifyGroupName(Integer.parseInt(request.getParameter("group_id")), request.getParameter("name"));
		}else if("devices".equals(requestMethod)){
			ModifyService modifyService =new ModifyService();
			jsonStr= modifyService.modifyDeviceName(Integer.parseInt(request.getParameter("device_id")),Integer.parseInt(request.getParameter("group_id")),request.getParameter("name"));
		}
		System.out.println(jsonStr);
        constructResponse(response);
		System.out.println(jsonStr);
		response.getWriter().write(jsonStr);
		
	}

    /**
     * For CROS request
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
	@Override
	protected void doOptions(HttpServletRequest req,
                             HttpServletResponse resp)
            throws ServletException, IOException {

		super.doOptions(req, resp);
		constructResponse(resp);
	}
    private void constructResponse(HttpServletResponse response) {
        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
    }
}
