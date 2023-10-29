package com.sunyard.hgam.presentation.base;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
import com.sunyard.hgam.persistence.dao.iface.smm.LogDao;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.util.common.DateTimeKit;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: sunhoo.com</p>
 * @author not attributable
 * @version 1.00
 */

public class LogFilter
    implements Filter {

  private static Hashtable operations = null;
  private static LogDao logDao = (LogDao) DomainLogic.getInstance().getDAO("Log");
  private FilterConfig config = null;
  //initialize operation url
  {
    operations = new Hashtable(13, 0.9f);
    List operationUrls = logDao.getAllOperationUrl();
    for (int i = 0; i < operationUrls.size(); i++) {
      OperationUrl operationUrl = (OperationUrl) operationUrls.get(i);
      operations.put(operationUrl.getUrl(),operationUrl);
    }
  }

  //修订（郑先全，20040329）：增加发布信息的相关设置
  private static String[] index = new String[] {
      "/main/left_index.jsp",
      "/smm/login.do",
      "/smm/logout.do",
      "/public/prompt.jsp",
      "/pub/viewAllPublishInfoList.do",
      "/pub/publish_info_list_all.jsp",
      "/pub/queryPublishInfoList.do",
      "/pub/queryFeedbackList.do",
      "/pub/publish_info_list.jsp",
      "/pub/viewPublishInfo.do",
      "/pub/publish_info_view.jsp",
      "/pub/feedback_info_view.jsp"
  };

  public void init(FilterConfig config) throws ServletException {
    this.config = config;
  }

  public void destroy() {
    operations = null;
    config = null;
  }

  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    long before = System.currentTimeMillis();
    String servletPath = null;
    if (request instanceof HttpServletRequest) {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      HttpServletResponse httpResponse = (HttpServletResponse) response;

      servletPath = httpRequest.getServletPath();
      AccountForm accountInfo = (AccountForm) httpRequest.getSession().getAttribute("ACCOUNT_INFORMATION");

      //登录检查
      if (!isIndexPage(servletPath)) { //非索引页面则进行登录检查

        if (accountInfo == null) {
          httpResponse.sendRedirect("/error.jsp");
          return;
        }
      }

      Account account = null;
      if (accountInfo != null) {
        account = accountInfo.getAccount();
      }
      else {
        account = new Account();
        account.setUserID("");
        account.setUserName("未知用户");
      }
      //进行日志记录
      if (operations.containsKey(servletPath)) {
        OperationUrl operationUrl = (OperationUrl) operations.get(servletPath);
        if ("1".equalsIgnoreCase(operationUrl.getIsLog()))   {
          Log log = new Log();
          log.setUserID(account.getUserID());
          log.setUserName(account.getUserName());
          log.setIp(httpRequest.getRemoteAddr());
          log.setOperID(operationUrl.getOperID());
          log.setResultCode("");
          log.setLogMsg(operationUrl.getOperDesc());
          log.setType("1");
          log.setOccurTime(DateTimeKit.getCurrentDateTime());
          logDao.insertLog(log);
        }
      }

    }

    chain.doFilter(request, response);

    long after = System.currentTimeMillis();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    System.out.println("URL[" +servletPath + "] by IP=[" + request.getRemoteAddr() + "] at " + formatter.format(new Date()) + ". " + (after - before) + " ms used.");

  }

  private boolean isIndexPage(String path) {
    for (int i = 0; i < index.length; i++) {
      if (path.equalsIgnoreCase(index[i])) {
        return true;
      }
    }
    return false;
  }
}