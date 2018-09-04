package com.zhiyou100.crowdFunding.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.crowdFunding.utils.UploadFileUtil;
import com.zhiyou100.crowdFunding.utils.SplitPageUtil;


public abstract class AbstractAction {
	/**
	 * ��Ҫ�ǽ����������ݴ����ʱ��ת����������ǰ������ɾ������µ�ʱ��ᴫ��һ��ids�Ĳ���
	 * ������������ɣ���id|id|id...��
	 * @param request
	 * @return
	 */
	public Set<Integer> getBatchIds(HttpServletRequest request) {
		Set<Integer> set = new HashSet<Integer>() ;
		String ids = request.getParameter("ids") ;
		String result [] = ids.split("\\|") ;
		for (int x = 0 ; x < result.length ; x ++) {
			set.add(Integer.parseInt(result[x])) ;
		}
		return set ;
	}
	
	/**
	 * ���з�ҳ���ݴ��ݵ���ش���
	 * @param mav Ҫ�������ݵ�ModelAndView����
	 * @param allRecorders �ܼ�¼������ͬ��ͳ�Ƴ��ֵ��ܼ�¼����ͬ
	 * @param columnData ��ҳ���б����ݣ���ʽ���ֶα�ǩ:������|�ֶα�ǩ:������|..
	 * @param urlKey Ҫ���з�ҳ�����url�����Ե�key��Ϣ
	 * @param spu �����˷�ҳ�������պ��SplitPageUtil�����
	 */
	public void handleSplit(ModelAndView mav, Object allRecorders, String columnData, String urlKey,
			SplitPageUtil spu) {
		mav.addObject("allRecorders", allRecorders);
		mav.addObject("columnData", columnData);
		mav.addObject("column", spu.getColumn());
		mav.addObject("url", this.getValue(urlKey));
		mav.addObject("keyWord", spu.getKeyWord());
		mav.addObject("currentPage", spu.getCurrentPage());
		mav.addObject("lineSize", spu.getLineSize());
	}

	/**
	 * ����ָ���Ĳ�������һ������
	 * 
	 * @param request
	 * @param param
	 * @return
	 */
	public Set<Integer> getSetByInteger(HttpServletRequest request, String param) {
		Set<Integer> all = new HashSet<Integer>();
		String values[] = request.getParameterValues(param);
		for (int x = 0; x < values.length; x++) {
			if (values[x].matches("\\d+")) {
				all.add(Integer.parseInt(values[x]));
			}
		}
		return all;
	}

	/**
	 * ȡ�õ�ǰ��¼���û�ID����
	 * 
	 * @return
	 */
	public String getMid() {
		return SecurityUtils.getSubject().getPrincipal().toString();
//		return null;
	}

	/**
	 * ʵ��ע������
	 */
	public void logout() {
		SecurityUtils.getSubject().logout();
//		return null;
	}

	/**
	 * ������ת������Ҫ����ص���ʾ��Ϣ�Լ��Զ���ת·��������
	 * 
	 * @param mav
	 * @param msgKey
	 * @param urlKey
	 */
	public void setMsgAndUrl(ModelAndView mav, String msgKey, String urlKey) {
		if (this.getType() == null) {
			mav.addObject("msg", this.getValue(msgKey));
		} else {
			mav.addObject("msg", this.getValue(msgKey, this.getType()));
		}
		mav.addObject("url", this.getValue(urlKey));
	}

	/**
	 * ר�Ÿ������ݵ��������������������ݣ���Ҫ����Ajax������
	 * 
	 * @param response
	 * @param value
	 */
	public void print(HttpServletResponse response, Object value) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����ͼƬ����
	 * 
	 * @param photo
	 * @return
	 */
	public String createFileName(MultipartFile photo) {
		if (photo.isEmpty()) { // û���ļ��ϴ�
			return "nophoto.gif"; // Ĭ��û���ļ�
		} else { // ��Ҫ�Լ�����һ���ļ�
			return UploadFileUtil.createFileName(photo.getContentType());
		}
	}

	/**
	 * ȡ��Ҫ�������ݵı��
	 * 
	 * @return
	 */
	public abstract String getType();

	/**
	 * �����ļ��ı��洦��
	 * 
	 * @param photo
	 */
	public boolean saveFile(MultipartFile photo, String fileName, HttpServletRequest request) { // �����ϴ���ͼƬ����
		if (!photo.isEmpty()) {
			String filePath = request.getServletContext().getRealPath(this.getFileUploadDir()) + fileName;
			try {
				return UploadFileUtil.save(photo.getInputStream(), new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * �����ϴ��ļ�·��
	 * 
	 * @return
	 */
	public abstract String getFileUploadDir();

	@Resource
	private MessageSource msgSource; // ��ʾ�˶���ֱ���������úõ�����󣨸�������ƥ�䣩

	/**
	 * ����ָ����key����Ϣ������Դ���ݵĶ�ȡ����
	 * 
	 * @param msgKey
	 *            ��ʾҪ��ȡ����Դ�ļ���key������
	 * @return ��ʾ��Դ��Ӧ������
	 */
	public String getValue(String msgKey, Object... args) {
		return this.msgSource.getMessage(msgKey, args, Locale.getDefault());
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) { // ���������Լ����д
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// �������Ĵ���ָ����׷����һ���Զ����ת���༭������������Ĳ���Ŀ������Ϊjava.util.Date��
		// ��ʹ�ö���õ�SimpleDateFormat�������и�ʽ��������������˲���������Ϊ��
		binder.registerCustomEditor(java.util.Date.class, "time", new CustomDateEditor(date, true));
		binder.registerCustomEditor(java.util.Date.class, "createTime", new CustomDateEditor(datetime, true));
		binder.registerCustomEditor(java.util.Date.class, "updateTime", new CustomDateEditor(datetime, true));
	}
}
