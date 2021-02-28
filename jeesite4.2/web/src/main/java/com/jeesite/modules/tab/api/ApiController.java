package com.jeesite.modules.tab.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.Email;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.jeesite.common.beetl.ext.fn.DictUtil;
import com.jeesite.common.codec.Md5Utils;
import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.shop.entity.ShopBbs;
import com.jeesite.modules.shop.entity.ShopBusiness;
import com.jeesite.modules.shop.entity.ShopBusinessCollect;
import com.jeesite.modules.shop.entity.ShopGoodCollect;
import com.jeesite.modules.shop.entity.ShopGoodFenlei;
import com.jeesite.modules.shop.entity.ShopGoods;
import com.jeesite.modules.shop.entity.ShopIndexSider;
import com.jeesite.modules.shop.entity.ShopOrder;
import com.jeesite.modules.shop.entity.ShopTopConfig;
import com.jeesite.modules.shop.entity.ShopUserMember;
import com.jeesite.modules.shop.service.ShopBbsService;
import com.jeesite.modules.shop.service.ShopBusinessCollectService;
import com.jeesite.modules.shop.service.ShopBusinessService;
import com.jeesite.modules.shop.service.ShopGoodCollectService;
import com.jeesite.modules.shop.service.ShopGoodFenleiService;
import com.jeesite.modules.shop.service.ShopGoodsService;
import com.jeesite.modules.shop.service.ShopIndexSiderService;
import com.jeesite.modules.shop.service.ShopOrderService;
import com.jeesite.modules.shop.service.ShopTopConfigService;
import com.jeesite.modules.shop.service.ShopUserMemberService;
import com.jeesite.modules.sys.entity.DictData;
import com.jeesite.modules.tab.entity.TabOrderComment;
import com.jeesite.modules.tab.entity.TabOrderGwc;
import com.jeesite.modules.tab.entity.TabOrderList;
import com.jeesite.modules.tab.entity.TabSysContact;
import com.jeesite.modules.tab.entity.TabUserAddress;
import com.jeesite.modules.tab.entity.TabValidateCode;
import com.jeesite.modules.tab.entity.TabYjfk;
import com.jeesite.modules.tab.service.TabOrderCommentService;
import com.jeesite.modules.tab.service.TabOrderGwcService;
import com.jeesite.modules.tab.service.TabOrderListService;
import com.jeesite.modules.tab.service.TabSysContactService;
import com.jeesite.modules.tab.service.TabUserAddressService;
import com.jeesite.modules.tab.service.TabValidateCodeService;
import com.jeesite.modules.tab.service.TabYjfkService;
import com.qiniu.util.UrlSafeBase64;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "api接口", description = "开发人员编写", hidden = false)
@Controller
@RequestMapping(value = "/api")
@Scope("prototype")
public class ApiController {

	// 爬数据
	@ApiOperation(value = "爬虫", notes = "爬虫")
	@RequestMapping(value = "/pachong", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> pachong(HttpServletRequest request, ModelAndView modelAndView) throws Exception {

		// 获取
		// 爬分类数据
		// String s ="客厅 餐厅 卧室 书房 厨房 卫生间 玄关 阳台";
		//
		// s =
		// HttpPostUtil.getHanYuanUtils("https://yapi.haohaozhu.cn/decorationtab/index");
		// System.out.println(s);
		//
		// JSONObject obj = new JSONObject(s);
		//
		// JSONArray jsonArray = obj.getJSONObject("data").getJSONArray("list");
		//
		// JSONObject kjian = jsonArray.getJSONObject(9);
		//
		// JSONArray content_list = kjian.getJSONArray("content_list");
		//
		// JSONObject list = content_list.getJSONObject(0);
		//
		// JSONArray scroll_list = list.getJSONArray("scroll_list");
		//
		// for (int i = 0; i < scroll_list.length(); i++) {
		// JSONObject dd = scroll_list.getJSONObject(i);
		// String title = dd.getString("title");
		// System.out.println(title);
		// ShopGoodFenlei shopGoodFenlei = new ShopGoodFenlei();
		// shopGoodFenlei.setName(title);
		// shopGoodFenlei.setOrderindex(i+1L);
		// shopGoodFenlei.setRowid(UUID.randomUUID().toString());
		// shopGoodFenlei.setParentRowid("9");
		// shopGoodFenlei.setIsNewRecord(true);
		//
		// // shopGoodFenleiService.save(shopGoodFenlei );
		// }

		// 爬论坛 数据
		// List<ShopGoodFenlei> goodFenleis = shopGoodFenleiService.findList(new
		// ShopGoodFenlei());
		// for (ShopGoodFenlei shopGoodFenlei : goodFenleis) {
		// String s = "";
		//
		// s =
		// HttpPostUtil.getHanYuanUtils3("https://www.haohaozhu.cn/f/y/api/Share/PhotoOptionInPc?keyword="
		// +shopGoodFenlei.getName(),"",new HashMap<>());
		// System.out.println(s);
		//
		//// shopBbsService.save(shopBbs);
		//
		//
		// JSONObject jsonObject = new JSONObject(s);
		//
		// JSONObject data = jsonObject.getJSONObject("data");
		//
		//
		// JSONArray rows = data.getJSONArray("rows");
		//
		//
		// for (int i = 0; i < rows.length(); i++) {
		//
		// JSONObject listData = rows.getJSONObject(i);
		//
		// JSONObject photo =
		// listData.getJSONObject("photo").getJSONObject("photo_info");
		// String admin_tag= photo.getString("admin_tag");
		// String new_pic_url = photo.getString("new_pic_url");
		// String remark= photo.getString("remark");
		// String title= photo.getString("title");
		// JSONArray image_list= photo.getJSONArray("image_list");
		//
		// System.out.println(admin_tag);
		//
		// ShopBbs shopBbs = new ShopBbs();
		// shopBbs.setAdminTag(admin_tag);
		// shopBbs.setPicUrl(new_pic_url);
		// shopBbs.setFenlei(shopGoodFenlei.getName());
		// String imageList = "";
		//
		// for (int j = 0; j < image_list.length(); j++) {
		// JSONObject src = image_list.getJSONObject(j);
		// imageList= imageList + src.getString("pic_url") +",";
		// }
		//
		// shopBbs.setImageList(imageList );
		// shopBbs.setIsNewRecord(true);
		// shopBbs.setCreatetime(new Date());
		// shopBbs.setTitle(title);
		// shopBbs.setRemarks(filterEmoji(remark));
		//
		// shopBbs.setRowid(UUID.randomUUID().toString());
		// try {
		// shopBbsService.save(shopBbs);
		// } catch (Exception e) {
		// }
		//
		// }
		//
		// }

		// 开始爬京东的数据

		// ShopGoodFenlei fenlei = new ShopGoodFenlei();
		// fenlei.setParentRowid("1");
		// List<ShopGoodFenlei> shopGoodFenleis = shopGoodFenleiService.findList(fenlei
		// );
		//
		// for (ShopGoodFenlei shopGoodFenlei : shopGoodFenleis) {
		//
		//
		// WebClient webClient=new WebClient(BrowserVersion.CHROME); // 实例化Web客户端
		// webClient.getOptions().setThrowExceptionOnScriptError(false);
		//// webClient.setpr
		// try {
		// String url =
		// "https://search.jd.com/Search?keyword="+shopGoodFenlei.getName()+"&enc=utf-8&wq="+shopGoodFenlei.getName();
		// System.out.println(url);
		// HtmlPage page=webClient.getPage(url);
		// Document document = Jsoup.parse(page.asXml());
		// Elements list = document.getElementsByAttributeValue("class", "J_valueList
		// v-fixed");
		// System.out.println(list.size());
		//
		// if (list.size()> 0 ) {
		//
		// Elements lis = list.get(0).getElementsByTag("li");
		// for (int i = 0; i < lis.size(); i++) {
		// Element element = lis.get(i);
		// String title = (element.getElementsByTag("a").get(0).attr("title"));
		//
		// ShopBusiness shopBusiness = new ShopBusiness();
		// shopBusiness.setName(title);
		// shopBusiness.setCreatetime(new Date());
		// shopBusiness.setIsNewRecord(true);
		// shopBusiness.setRowid(UUID.randomUUID().toString());
		//// shopb
		// Elements img = element.getElementsByTag("img");
		// if (img.size()> 0 ) {
		// String src= img.get(0).attr("src").replaceAll("//", "");
		// shopBusiness.setPicurl(src);
		//
		//
		// }
		// shopBusiness.setFenlei(shopGoodFenlei.getName());
		// shopBusinessService.save(shopBusiness);
		//
		//
		// }
		// }
		//
		//
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }finally{
		// webClient.close(); // 关闭客户端，释放内存
		// }
		//
		// }

		// 开始爬产品

		List<ShopBusiness> shopBusinesses = shopBusinessService.findList(new ShopBusiness());

		for (ShopBusiness shopBusiness : shopBusinesses) {
			//
			//
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_68); // 实例化Web客户端
			webClient.getOptions().setThrowExceptionOnScriptError(false);
			// webClient.setpr
			try {
				String url = "https://search.jd.com/search?keyword=" + shopBusiness.getFenlei() + "&qrst=1&wq="
						+ shopBusiness.getFenlei() + "&stock=1&ev=exbrand_" + shopBusiness.getName();
				System.out.println(url);
				HtmlPage page = webClient.getPage(url);
				Document document = Jsoup.parse(page.asXml());
				Elements list = document.getElementsByAttributeValueContaining("class", "goods-list-v2");

				System.out.println(list.size());

				if (list.size() > 0) {

					Elements lis = list.get(0).getElementsByTag("li");
					shopBusiness.setLikes(lis.size() + 0L);
					shopBusinessService.save(shopBusiness);
					for (int i = 0; i < lis.size(); i++) {
						try {
							String src = lis.get(i).getElementsByTag("a").first().getElementsByTag("img").first()
									.attr("data-lazy-img").replaceAll("//", "");

							String p = lis.get(i).getElementsByAttributeValueContaining("class", "p-price").text()
									.replaceAll("￥ ", "");
							String names = lis.get(i).getElementsByAttributeValueContaining("class", "p-name").first()
									.getElementsByTag("em").first().text();

							ShopGoods shopGoods = new ShopGoods();
							shopGoods.setBussId(shopBusiness.getRowid());
							shopGoods.setRowid(UUID.randomUUID().toString());
							shopGoods.setImgsrc("https://" + src);
							shopGoods.setName(names);
							shopGoods.setPrice1(Double.valueOf(p));
							shopGoods.setFenlei(shopBusiness.getFenlei());
							shopGoods.setCreatetime(new Date());
							shopGoods.setIsNewRecord(true);

							shopGoodsService.save(shopGoods);
						} catch (Exception e) {
						}

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				webClient.close(); // 关闭客户端，释放内存
			}
			//
		}

		return returnValue;

	}

	public static String filterEmoji(String source) {
		if (source != null) {
			Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
					Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
			Matcher emojiMatcher = emoji.matcher(source);
			if (emojiMatcher.find()) {
				source = emojiMatcher.replaceAll("*");
				return source;
			}
			return source;
		}
		source.replaceAll("\\xF0\\x9F\\xA4\\x93", "");
		return source;

	}

	private Map<String, Object> returnValue = new HashMap<>();

	@ApiOperation(value = "发送验证码接口", notes = "发送验证码接口")
	@RequestMapping(value = "/sendCode", method = RequestMethod.POST)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phone", value = "手机号码", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "flag", value = "类型   true 标识注册  false 标识 忘记密码 ", paramType = "query", required = true, dataType = "String") })
	@ResponseBody
	public Map<String, Object> sendCode(HttpServletRequest request, ModelAndView modelAndView) throws Exception {

		String phone = request.getParameter("phone");

		String code = getCode2();

		TabValidateCode tabValidateCode = new TabValidateCode();
		tabValidateCode.setPhone(phone);
		tabValidateCode.setCode(code);
		tabValidateCode.setId(UUID.randomUUID().toString());
		tabValidateCode.setIsNewRecord(true);
		tabValidateCode.setCreatetime(new Date());
		tabValidateCode.setFlag("1");
		tabValidateCode.setValidateTime(getValiDate());
		validateCodeService.save(tabValidateCode);

		Map<String, String> map = new HashMap<String, String>();

		map.put("content", "【极速科技】您的验证码是" + code);
		map.put("mobile", phone);
		String Get_NonAssetRoomList = new HttpPostUtil().getHanYuanUtils3(
				"http://xpapi.wefeed.me/api/sendSms?content=" + map.get("content") + "&mobile=" + map.get("mobile"),
				"", map);
		return returnValue;

	}

	private Date getValiDate() {

		Date date = new Date();

		date.setTime(date.getTime() + 60 * 1000 * 30);

		return date;
	}

	private String getCode2() {

		return (new Random().nextInt(888888) + 100000) + "";
	}

	// 开始注册
	@RequestMapping(value = "/registerApi", method = RequestMethod.POST)
	@ApiOperation(value = "注册接口", notes = "注册接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phone", value = "手机号码", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "regCode", value = "验证码", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "password", value = "登录密码", paramType = "query", required = true, dataType = "String"), })
	@ResponseBody
	public Map<String, Object> registerApi(HttpServletRequest request, ModelAndView modelAndView) throws Exception {
		
		
		/**
		 * 	phone: phone,
					regCode: code,
					password: password
		 */
		
		String  phone =   request.getParameter("phone");
		String  regCode =   request.getParameter("regCode");
		String  password =   request.getParameter("regCode");
		

		Map<String, String> parame = new HashMap<>();
		parame.put("phone", phone);
		parame.put("code", regCode);
		
		
		
		List<TabValidateCode> tabValidateCodes     =    validateCodeService.checkValidCode(parame);
		
		if (tabValidateCodes.size()  >  0  ) { 
			
			ShopUserMember shopUserMember  = new ShopUserMember();
			shopUserMember.setUsername(phone);
			Long  cc   =     shopUserMemberService.findCount(shopUserMember);
			
			if (cc ==0) {
				
				shopUserMember =   new ShopUserMember();
				
				shopUserMember.setUid(UUID.randomUUID().toString());
				shopUserMember.setUsername(phone);
				shopUserMember.setPassword(Md5Utils.md5(password)
						);
				shopUserMember.setRegdate(new Date());
				shopUserMember.setIsNewRecord(true);
				shopUserMemberService.save(shopUserMember);
				
			}else {
				returnValue.put("flag", "false");
				returnValue.put("msg", "手机号码已经注册");

			}
			
		}

		
		
		return returnValue;
	}

	// login
	@ApiOperation(value = "登录接口", notes = "登录接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phone", value = "账号", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "password", value = "登录密码", paramType = "query", required = true, dataType = "String") })
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loginPost(HttpServletRequest request, ModelAndView modelAndView) throws Exception {
		
		String phone=   request.getParameter("phone");
		String password=   request.getParameter("password");
		
		if (StringUtils.isBlank(phone)) {
			returnValue.put("flag", "false");
			returnValue.put("msg", "请输入账号!");
			return returnValue ;
		}
		if (StringUtils.isBlank(password)) {
			returnValue.put("flag", "false");
			returnValue.put("msg", "请输入密码!");
			return returnValue ;
		}
		
		ShopUserMember shopUserMember =   new ShopUserMember();
		
		shopUserMember.setUsername(phone);
		shopUserMember.setPassword(Md5Utils.md5(password));
		
		List<ShopUserMember> shopUserMembers   =    shopUserMemberService.findList(shopUserMember);
		
		if (shopUserMembers.size() >  0  ) {
				returnValue.put("flag", "true");
				returnValue.put("data", shopUserMembers.get(0));
		}else {
			returnValue.put("flag", "false");
			returnValue.put("msg", "账号或密码错误");
				

		}
		
		
		return returnValue;

	}
	
	

	// 获取用户详情
	@ApiOperation(value = "获取用户详情 ", notes = "获取用户详情 ")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = true, dataType = "String") })
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getUserInfo(HttpServletRequest request, ModelAndView modelAndView) throws Exception {
		
		ShopUserMember shopUserMember  =   shopUserMemberService.get(request.getParameter("token"));
//		shopUserMember.setp
		String phone =  shopUserMember.getUsername();
		phone=  phone.substring(0, 3) +  "****" +  phone.substring(7);
		shopUserMember.setUsername(phone);;
		returnValue.put("data", shopUserMember);
		
		return returnValue;

	}

	// 获取首页配置信息

	@ApiOperation(value = "获取首页配置信息", notes = "获取首页配置信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String") })
	@RequestMapping(value = "/homeData", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> homeData(HttpServletRequest request, ModelAndView modelAndView) throws Exception {

		// 获取
		String token = request.getParameter("token");

		List<ShopTopConfig> shopTopConfigs = topConfigService.findList(new ShopTopConfig());

		returnValue.put("shopTopConfigs", shopTopConfigs);

		// 获取滑动信息

		List<ShopIndexSider> shopIndexSiders = shopIndexSiderService.findList(new ShopIndexSider());

		returnValue.put("shopIndexSiders", shopIndexSiders);

		// 获取默认的分类

		List<ShopGoodFenlei> shopGoodFenleis = shopGoodFenleiService.listHomeDefaultData();

		returnValue.put("shopGoodFenleis", shopGoodFenleis);

		returnValue.put("flag", "true");

		return returnValue;

	}

	// 获取顶部滑动内容的社区内容
	@ApiOperation(value = "获取首页配置分类下的内容", notes = "获取首页配置分类下的内容")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "adminTag", value = "分类内容", paramType = "query", required = false, dataType = "String") })
	@RequestMapping(value = "/homeDataDetail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> homeDataDetail(ShopBbs shopBbs, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 获取顶部内容

		shopBbs.setPage(new Page<>(request, response));
		Page<ShopBbs> page = shopBbsService.findPage(shopBbs);

		returnValue.put("data", page.getList());
		return returnValue;

	}

	//

	// 分类的店铺
	@ApiOperation(value = "分类的店铺", notes = "分类的店铺")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "fenlei", value = "分类名称", paramType = "query", required = false, dataType = "String") })
	@RequestMapping(value = "/listBusiness", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listBusiness(ShopBusiness shopBbs, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 获取顶部内容
		shopBbs.setLikes_gte(0L);
		shopBbs.setPage(new Page<>(request, response));
		Page<ShopBusiness> page = shopBusinessService.findPage(shopBbs);
		List<ShopBusiness> shopBusinesses = page.getList();
		for (ShopBusiness shopBusiness : shopBusinesses) {
			ShopGoods entity = new ShopGoods();
			entity.setBussId(shopBusiness.getRowid());

			// 加载部分商品
			List<ShopGoods> shopGoods = shopGoodsService.findList(entity);
			shopBusiness.setShopGoods(shopGoods);

		}
		returnValue.put("data", page.getList());
		return returnValue;

	}

	// 分类的商品

	@ApiOperation(value = "分类的商品", notes = "分类的商品")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "name", value = "分类名称", paramType = "query", required = false, dataType = "String") })
	@RequestMapping(value = "/listProduct", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listProduct(ShopGoods shopGoods, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		shopGoods.setPage(new Page<>(request, response));
		Page<ShopGoods> page = shopGoodsService.findPage(shopGoods);
		returnValue.put("data", page.getList());
		return returnValue;

	}

	// 显示产品详情数据

	@ApiOperation(value = "分类的商品详情", notes = "分类的商品详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "rowid", value = "产品详情", paramType = "query", required = false, dataType = "String") })
	@RequestMapping(value = "/productDetail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> productDetail(ShopGoods shopGoods, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		shopGoods = shopGoodsService.get(shopGoods.getRowid());

		ShopBusiness shopBusiness = shopBusinessService.get(shopGoods.getBussId());

		returnValue.put("data", shopGoods);
		returnValue.put("shopBusiness", shopBusiness);

		//
		TabOrderComment entity = new TabOrderComment();
		// entity.setProductid(shopGoods.getRowid());
		List<TabOrderComment> tabOrderComments = tabOrderCommentService.findList(entity);

		returnValue.put("tabOrderComments", tabOrderComments);
		
		//查看用户 如果有注册 查看收藏情况 和   购物车数量
		String  token  =  request.getParameter("token");
		
		if (!StringUtils.isBlank(token)) {
			//查看是否
			ShopGoodCollect entity2=  new ShopGoodCollect();
			
			String rowid =   request.getParameter("rowid");
			entity2.setGoodId(rowid);
			
			entity2.setUserId(token );
			Long cc  =    shopGoodCollectService.findCount(entity2);
			returnValue.put("cc", cc);  //看是否收藏
			
			//查看购物车数量
			
			TabOrderGwc obj = new TabOrderGwc();
			obj.setUserid(token);
			Long  cc2 =    tabOrderGwcService.getUserGwcCount(obj );
			returnValue.put("cc2", cc2);  //购物车数量

			
		}

		return returnValue;

	}

	// 显示店铺详情

	@ApiOperation(value = "店铺详情", notes = "店铺详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "rowid", value = "店铺编号", paramType = "query", required = false, dataType = "String") })
	@RequestMapping(value = "/businessDetail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> businessDetail(ShopBusiness shopBusiness, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		shopBusiness = shopBusinessService.get(shopBusiness.getRowid());
		// 查看 关联产品 新品产品 暂时 先不过滤

		ShopGoods shopGoods = new ShopGoods();
		shopGoods.setBussId(shopBusiness.getRowid());
		List<ShopGoods> list = shopGoodsService.findList(shopGoods);

		returnValue.put("data", shopBusiness);

		returnValue.put("list", list);
		
		String   token =    request.getParameter("token");
		
		if (!StringUtils.isBlank(token)) {
			ShopBusinessCollect arg0  = new ShopBusinessCollect();
			arg0.setUserId(token);
			arg0.setBussId(shopBusiness.getRowid());
			Long cc2  =   shopBusinessCollectService.findCount(arg0  );
			returnValue.put("cc2", cc2);
		}
		
		// 查看 关联茶瓶 热门产品

		// 查看 关联视频

		return returnValue;

	}
	
	
	
	@ApiOperation(value = "收藏", notes = "收藏商品")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "rowid", value = "商品编号", paramType = "query", required = false, dataType = "String") })
	@RequestMapping(value = "/collectProduct", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> collectProduct( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		
		//先看有没收藏
		
		ShopGoodCollect entity=  new ShopGoodCollect();
		
		String rowid =   request.getParameter("rowid");
		entity.setGoodId(rowid);
		
		String token =   request.getParameter("token");
		
		entity.setUserId(token );
		
		List<ShopGoodCollect> shopGoodCollects   =   shopGoodCollectService.findList(entity);
		
		
		int cc  =     shopGoodCollects.size();
		if (cc ==0) {
			//没有收藏
			
			entity =  new ShopGoodCollect();
 			entity.setUserId(token );
			entity.setGoodId(rowid);
			entity.setRowid(UUID.randomUUID().toString());
			entity.setIsNewRecord(true);
			shopGoodCollectService.save(entity);
			returnValue.put("data", "1");


		}else {
			for (ShopGoodCollect shopGoodCollect : shopGoodCollects) {
				shopGoodCollectService.delete(shopGoodCollect);
			}
			returnValue.put("data", "2");

		}
		
		returnValue.put("flag", "true");
		
		
		return returnValue;

	}
	
	//添加购物车
	
	@ApiOperation(value = "添加购物车", notes = "添加购物车")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "rowid", value = "商品编号", paramType = "query", required = false, dataType = "String") })
	@RequestMapping(value = "/addGwc", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addGwc( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		 String  token =  request.getParameter("token");
		 String rowid =  request.getParameter("rowid");
		 
		ShopGoods shopGoods   =   shopGoodsService.get(rowid);
		 
		 TabOrderGwc arg0 = new TabOrderGwc();
		 arg0.setProductid(rowid);
		 arg0.setUserid(token);
		List<TabOrderGwc> orderGwcs = tabOrderGwcService.findList(arg0);
		
		if (orderGwcs.size() >  0  ) {
			
			TabOrderGwc tabOrderGwc    =      orderGwcs.get(0);
			tabOrderGwc.setNums(tabOrderGwc.getNums()+1);
			tabOrderGwcService.save(tabOrderGwc);
			
		}else {
			TabOrderGwc tabOrderGwc  =      new TabOrderGwc();
			tabOrderGwc.setRowid(UUID.randomUUID().toString());
			tabOrderGwc.setProductid(rowid);
			tabOrderGwc.setUserid(token);
			tabOrderGwc.setNums(1L);
			tabOrderGwc.setBussinessid(shopGoods.getBussId());
			tabOrderGwc.setCreatetime(new Date());
			tabOrderGwc.setIsNewRecord(true);
			tabOrderGwc.setIscheck("1");
			tabOrderGwcService.save(tabOrderGwc);
		}
		 
		 
		//
			arg0 =  new TabOrderGwc();
			arg0.setUserid(token);
			
		Long  cc =    tabOrderGwcService.getUserGwcCount(arg0);
		 
		returnValue.put("flag", "true");
		returnValue.put("count", cc);

		
		
		return returnValue;

	}
	
	
	//提交订单 下单
	@ApiOperation(value = "提交订单数据", notes = "提交订单数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String"),
		@ApiImplicitParam(name = "rowid", value = "商品编号", paramType = "query", required = false, dataType = "String") })
@RequestMapping(value = "/submitOrder", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> submitOrder( HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		
		returnValue= 	shopOrderService.submitOrder(request);
	
		return returnValue;

		
	}
	//显示订单详情
	@ApiOperation(value = "显示订单数据", notes = "显示订单数据")
	@ApiImplicitParams({
 		@ApiImplicitParam(name = "rowid", value = "商品编号", paramType = "query", required = false, dataType = "String") })
@RequestMapping(value = "/orderDetails", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> orderDetails( HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		String rowid=   request.getParameter("rowid");
		
		ShopOrder shopOrder  =   shopOrderService.get(rowid);
		
		//加载 订单列表
		
		TabOrderList entity  = new TabOrderList();
		entity.setOrderid(shopOrder.getOrderids());
		List<TabOrderList>  tabOrderLists  =   tabOrderListService.findList(entity  );
		
		for (TabOrderList tabOrderList : tabOrderLists) {
	ShopGoods shopGoods  =   shopGoodsService.get(tabOrderList.getProductid());
			
			ShopBusiness shopBusiness  =  shopBusinessService.get(shopGoods.getBussId());
			
			shopGoods.setShopBusiness(shopBusiness);
			
			tabOrderList.setShopGoods(shopGoods);
		}
		
		
		returnValue.put("tabOrderLists", tabOrderLists);
		
		returnValue.put("shopOrder", shopOrder);
		
		return returnValue;

	}
	
	@ApiOperation(value = "更新订单", notes = "更新订单")
	@ApiImplicitParams({
 		@ApiImplicitParam(name = "rowid", value = "商品编号", paramType = "query", required = false, dataType = "String") })
@RequestMapping(value = "/updateOrders", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> updateOrders(ShopOrder shopOrder , HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		String rowid=   request.getParameter("rowid");
		
		ShopOrder data =   shopOrderService.get(rowid);
		data.setAddresstext(shopOrder.getAddresstext());
		data.setNames(shopOrder.getNames());
		data.setPhones(shopOrder.getPhones());
		data.setNotes(shopOrder.getNotes());
		shopOrderService.save(data);
		
		returnValue.put("data", data);
		
		
		return returnValue;

	}
	
	//
 	@ApiOperation(value = "显示我的地址", notes = "显示我的地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
@RequestMapping(value = "/listMyAddress", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> listMyAddress( HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		String  token =    request.getParameter("token");
		
		TabUserAddress arg0 = new TabUserAddress();
		arg0.setUserid(token);
		List<TabUserAddress> tabUserAddresses  =   userAddressService.findList(arg0 );
		
		returnValue.put("data", tabUserAddresses);
		
		return returnValue;

	}
 	
 	//
 	
 	
 	@ApiOperation(value = "显示我的地址详情", notes = "显示我的地址详情")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rowid", value = "地址编号标识", paramType = "query", required = false, dataType = "String")  })
@RequestMapping(value = "/listMyAddressDetail", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> listMyAddressDetail( HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		String  rowid =    request.getParameter("rowid");
		
		TabUserAddress arg0 =  userAddressService.get(rowid);
		
		returnValue.put("data", arg0);
		
		return returnValue;

	}
 	
 	//删除我的地址
	@ApiOperation(value = "删除我的地址详情", notes = "删除我的地址详情")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rowid", value = "地址编号标识", paramType = "query", required = false, dataType = "String")  })
@RequestMapping(value = "/delMyAddressDetail", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> delMyAddressDetail( HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		String  rowid =    request.getParameter("rowid");
		
		TabUserAddress arg0 =  userAddressService.get(rowid);
		userAddressService.delete(arg0
				);
		
		return returnValue;

	}
	
	
	
	//设置默认地址
	
	@ApiOperation(value = "设置我的地址默认", notes = "设置我的地址默认")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rowid", value = "地址编号标识", paramType = "query", required = false, dataType = "String")  })
@RequestMapping(value = "/setDefalutAddress", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> setDefalutAddress( HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		String  rowid =    request.getParameter("rowid");
		
		String  token  =  request.getParameter("token");
		
		userAddressService.saveDefalutData(rowid,token);
		 
		returnValue.put("flag", "true");
		return returnValue;

	}
	
	//保存我的地址
	
	@ApiOperation(value = "保存地址信息", notes = "保存地址信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rowid", value = "地址编号标识", paramType = "query", required = false, dataType = "String")  })
@RequestMapping(value = "/saveMyAddressDetail", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> saveMyAddressDetail( TabUserAddress tabUserAddress, HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		 String rowid=   request.getParameter("rowid");
		 
		tabUserAddress.setIsdefau("1");
		tabUserAddress.setUserid(tabUserAddress.getToken());
		if (!StringUtils.isBlank(rowid)) {
			tabUserAddress.setId(rowid);;
		}else {
			
		tabUserAddress.setIsNewRecord(true);
		tabUserAddress.setId(UUID.randomUUID().toString());
		}
		userAddressService.save(tabUserAddress);
		returnValue.put("data", tabUserAddress);
		
		
		return returnValue;

	}
	
	
	
	
 	
	
	
	@ApiOperation(value = "显示购物车数据", notes = "显示购物车数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
@RequestMapping(value = "/listGwc", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> listGwc( HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		
		String  token =    request.getParameter("token");
		
		TabOrderGwc entity = new TabOrderGwc();
		entity.setUserid(token);
		List<TabOrderGwc> tabOrderGwcs  =   tabOrderGwcService.findList(entity );
		Map<String, List<TabOrderGwc>>   list    =  new  HashMap<>();
		for (TabOrderGwc tabOrderGwc : tabOrderGwcs) {
			String goodid =   tabOrderGwc.getProductid();
			
			ShopGoods shopGoods  =   shopGoodsService.get(goodid);
			
			ShopBusiness shopBusiness  =  shopBusinessService.get(shopGoods.getBussId());
			
			shopGoods.setShopBusiness(shopBusiness);
			
			tabOrderGwc.setShopGoods(shopGoods);
			List<TabOrderGwc>    ll  =    list.get(shopGoods.getBussId());
			if (ll == null   ||   ll.size()  == 0) {
				ll = new ArrayList<>();
				ll.add(tabOrderGwc);
			}else {
				ll.add(tabOrderGwc);

			}
			
			list.put(shopGoods.getBussId(), ll);
			
		}
		
		returnValue.put("data", list);
		
		return returnValue;

		
	}
	
 	
	
	
	@ApiOperation(value = "收藏", notes = "收藏商家")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "rowid", value = "商家编号", paramType = "query", required = false, dataType = "String") })
	@RequestMapping(value = "/collectBusiness", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> collectBusiness( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		
		//先看有没收藏
		
		ShopBusinessCollect entity=  new ShopBusinessCollect();
		
		String rowid =   request.getParameter("rowid");
		entity.setBussId(rowid);
		
		String token =   request.getParameter("token");
		
		entity.setUserId(token );
		
		List<ShopBusinessCollect> shopGoodCollects   =   shopBusinessCollectService.findList(entity);
		
		int cc  =     shopGoodCollects.size();
		if (cc ==0) {
			//没有收藏
			
			entity =  new ShopBusinessCollect();
 			entity.setUserId(token );
			entity.setBussId(rowid);
			entity.setRowid(UUID.randomUUID().toString());
			entity.setIsNewRecord(true);
			shopBusinessCollectService.save(entity);
			returnValue.put("data", "1");


		}else {
			for (ShopBusinessCollect shopGoodCollect : shopGoodCollects) {
				shopBusinessCollectService.delete(shopGoodCollect);
			}
			returnValue.put("data", "2");

		}
		
		returnValue.put("flag", "true");
		
		
		return returnValue;

	}
	
	
	
	@ApiOperation(value = "收藏", notes = "收藏商家")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/listBusinessCollect", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listBusinessCollect( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		
		//先看有没收藏
		
		ShopBusinessCollect entity=  new ShopBusinessCollect();
		
		String token =   request.getParameter("token");
		
		entity.setUserId(token );
		
		List<ShopBusinessCollect> shopGoodCollects   =   shopBusinessCollectService.findList(entity);
		
		for (ShopBusinessCollect shopBusinessCollect : shopGoodCollects) {
			ShopBusiness shopBusiness =   shopBusinessService.get(shopBusinessCollect.getBussId());
			shopBusinessCollect.setShopBusiness(shopBusiness);
		}
		
		returnValue.put("flag", "true");
		returnValue.put("data", shopGoodCollects);

		return returnValue;

	}
	
	
	
	@ApiOperation(value = "更新购物车数据", notes = "更新购物车数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/updateGwcNums", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateGwcNums( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		String rowid=   request.getParameter("rowid");
		
		String nums=   request.getParameter("nums");
		
		TabOrderGwc tabOrderGwc =  tabOrderGwcService.get(rowid);
		
		tabOrderGwc.setNums(Long.valueOf(nums));
		
		tabOrderGwcService.save(tabOrderGwc);
		
		
		return returnValue;

		
	}
	
	
	@ApiOperation(value = "删除购物车数据", notes = "删除购物车数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/delGwcNums", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delGwcNums( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		String rowid=   request.getParameter("rowid");
 		
		TabOrderGwc tabOrderGwc =  tabOrderGwcService.get(rowid);
		 
		tabOrderGwcService.delete(tabOrderGwc);
		
		return returnValue;

		
	}
	
	@ApiOperation(value = "删除购物车数据", notes = "删除购物车数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/delSelectGwc", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delSelectGwc( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		tabOrderGwcService.delSelectGwc(request);
		
		return returnValue;

	}
	@ApiOperation(value = "更新购物车选择", notes = "更新购物车选择")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/checkGwcData", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkGwcData( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		String rowid=   request.getParameter("rowid");
		String ischeck=   request.getParameter("ischeck");

 		
		TabOrderGwc tabOrderGwc =  tabOrderGwcService.get(rowid);
		tabOrderGwc.setIscheck(ischeck);
		
		 
		tabOrderGwcService.save(tabOrderGwc);
		
		
		
		return returnValue;

		
	}
	
	
	@ApiOperation(value = "更新全部购物车选择", notes = "更新全部购物车选择")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/checkAllGwcData", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkAllGwcData( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		String token=   request.getParameter("token");
		String ischeck=   request.getParameter("ischeck");

		TabOrderGwc tabOrderGwc  = new TabOrderGwc();
		
		tabOrderGwc.setUserid(token);
		tabOrderGwc.setIscheck(ischeck);
		
		tabOrderGwcService.updateGwcChecks(tabOrderGwc);
		
		
		
		return returnValue;

		
	}
	
	//
	
	
	@ApiOperation(value = "提交购物车数据", notes = "提交购物车数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/submitGwcData", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitGwcData( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
//		String token=   request.getParameter("token");
		
//		tabOrder
		returnValue= 	shopOrderService.submitOrder2(request);
		
		
		return returnValue;

		
	}
	
	@ApiOperation(value = "修改密码", notes = "修改密码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/editPassword", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editPassword( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		
		String oldPass  =   request.getParameter("oldPass");
		
		String newPass  =   request.getParameter("newPass");

		String newPass1  =   request.getParameter("newPass1");
		
		String token  =   request.getParameter("token");
		
		ShopUserMember shopUserMember   =   shopUserMemberService.get(token);
		
		if (StringUtils.isBlank(oldPass)) {
			returnValue.put("flag", "false");
			returnValue.put("msg", "原始密码为空");
			return returnValue;
			

		}
		if (StringUtils.isBlank(newPass)) {
			returnValue.put("flag", "false");
			returnValue.put("msg", "新密码为空");
			return returnValue;
			
		}

		if (StringUtils.isBlank(newPass1)) {
			returnValue.put("flag", "false");
			returnValue.put("msg", "确认密码为空");
			return returnValue;
			

		}
		
		if (!newPass.equals(newPass1)) {

			returnValue.put("flag", "false");
			returnValue.put("msg", "确认密码不一致");
			return returnValue;
			
		}

		if (!Md5Utils.md5(oldPass).equals(shopUserMember.getPassword())) {
			returnValue.put("flag", "false");
			returnValue.put("msg", "原始密码错误");
			return returnValue;
		}
		
		shopUserMember.setPassword(Md5Utils.md5(newPass));
		shopUserMemberService.save(shopUserMember);
		
		
		returnValue.put("flag", "true");


		
		return returnValue;

		
	}
	
	@ApiOperation(value = "修改手机号发送验证码", notes = "修改手机号发送验证码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/sendPhoneCode", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sendPhoneCode( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		String  token =  request.getParameter("token");
		ShopUserMember shopUserMember =   shopUserMemberService.get(token);
		
		String code = getCode2().substring(0,4);

		TabValidateCode tabValidateCode = new TabValidateCode();
		tabValidateCode.setPhone(shopUserMember.getUsername());
		tabValidateCode.setCode(code);
		tabValidateCode.setId(UUID.randomUUID().toString());
		tabValidateCode.setIsNewRecord(true);
		tabValidateCode.setCreatetime(new Date());
		tabValidateCode.setFlag("1");
		tabValidateCode.setValidateTime(getValiDate());
		validateCodeService.save(tabValidateCode);

		Map<String, String> map = new HashMap<String, String>();

		map.put("content", "【极速科技】您的验证码是" + code);
		map.put("mobile", shopUserMember.getUsername());
		String Get_NonAssetRoomList = new HttpPostUtil().getHanYuanUtils3(
				"http://xpapi.wefeed.me/api/sendSms?content=" + map.get("content") + "&mobile=" + map.get("mobile"),
				"", map);
		return returnValue;

	}
	
	//检查
	
	@ApiOperation(value = "验证手机号验证码", notes = "验证手机号验证码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/checkPhoneCode", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkPhoneCode( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		String  token =  request.getParameter("token");
		ShopUserMember shopUserMember =   shopUserMemberService.get(token);
		
		String  code =  request.getParameter("code");

		Map<String, String> parame = new HashMap<>();
		parame.put("phone", shopUserMember.getUsername());
		parame.put("code", code);
		
		
		
		List<TabValidateCode> tabValidateCodes     =    validateCodeService.checkValidCode(parame);
		
		if (tabValidateCodes.size()  >  0  ) { 
			TabValidateCode tabValidateCode  = tabValidateCodes.get(0);
			tabValidateCode.setFlag("2");
			validateCodeService.save(tabValidateCode);
			
			returnValue.put("flag", "true");
		}else {
			returnValue.put("flag", "false");

		}
		
		
		
		return returnValue;

	}
	
	
	@ApiOperation(value = "验证手机号验证码", notes = "验证手机号验证码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/editPhoneData", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editPhoneData( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		String  token =  request.getParameter("token");
		ShopUserMember shopUserMember =   shopUserMemberService.get(token);
		String  phone =  request.getParameter("phone");

		String  code =  request.getParameter("code");

		Map<String, String> parame = new HashMap<>();
		parame.put("phone", phone);
		parame.put("code", code);
		
		
		
		List<TabValidateCode> tabValidateCodes     =    validateCodeService.checkValidCode(parame);
		
		if (tabValidateCodes.size()  >  0  ) { 
			TabValidateCode tabValidateCode  = tabValidateCodes.get(0);
			tabValidateCode.setFlag("2");
			validateCodeService.save(tabValidateCode);
			
			//查看这个
			
			ShopUserMember member = new ShopUserMember();
			member.setUsername(phone);
			Long  cc =     shopUserMemberService.findCount(member);
			
			if (cc >  0  ) {
			
				returnValue.put("flag", "false");
				returnValue.put("msg", "手机号码已经存在!");

			
			}else {
				shopUserMember.setUsername(phone);
				shopUserMemberService.save(shopUserMember);
				
			returnValue.put("flag", "true");
			}
		}else {
			returnValue.put("flag", "false");
			returnValue.put("msg", "验证码错误");

		}
		
		
		
		return returnValue;

	}
	
	//
	
	@ApiOperation(value = "获取系统配置", notes = "获取系统配置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/getSysConfig", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getSysConfig( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		
		TabSysContact  tabSysContact =   tabSysContactService.get("1");
		returnValue.put("data", tabSysContact);
		
		
		
		return returnValue;

	}
	
	@ApiOperation(value = "保存用户信息", notes = "保存用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/saveInfoData", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveInfoData( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		
		 String   token =  request.getParameter("token");
		 
		 String   nickName =  request.getParameter("name");
		 
		 String   sex =  request.getParameter("sex");

		 String   imgsrc =  request.getParameter("imgsrc");
		 
		 String   baseCity =  request.getParameter("baseCity");

		 
		 ShopUserMember shopUserMember    =  shopUserMemberService.get(token);
		 
		 if (!StringUtils.isBlank(nickName)) {
			 shopUserMember.setNickname(nickName);
		}
		 
		 if (!StringUtils.isBlank(sex)) {
			 shopUserMember.setSex(sex);
		}
		 
		 if (!StringUtils.isBlank(imgsrc)) {
			 shopUserMember.setUserpic(imgsrc);
		}
		 
		 if (!StringUtils.isBlank(imgsrc)) {
			 shopUserMember.setUserpic(imgsrc);
		}
		 
		 if (!StringUtils.isBlank(baseCity)) {
			 shopUserMember.setBasecity(baseCity);
		}
		 shopUserMemberService.save(shopUserMember);
		 
		 returnValue.put("flag", "true");
		 
		
		return returnValue;

	}
	
	
	
	
	
	@ApiOperation(value = "显示我收藏的列表", notes = "显示我收藏的列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/listMyShouCang", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listMyShouCang( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		List<ShopGoods> shopGoods  =   shopGoodsService.listMySc(request);
		returnValue.put("data", shopGoods);
		
		
		return returnValue;

		
	}
	
	
	//反馈类型
	
	@ApiOperation(value = "显示反馈类型", notes = "显示反馈类型")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "listFklx", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/listFklx")
	@ResponseBody
	public Map<String, Object> listFklx( HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		List<DictData>   dictData=  	DictUtil.list("fklx");
		 
		returnValue.put("data", dictData);
		
		return returnValue;

		
	}
	
	//
	


	public static void main(String[] args) throws Exception { 
		
		System.out.println(Md5Utils.md5("111111"));
	}

	@Autowired
	ShopTopConfigService topConfigService;
	@Autowired
	private ShopBbsService shopBbsService;

	@Autowired
	private ShopGoodFenleiService shopGoodFenleiService;
	@Autowired
	private ShopIndexSiderService shopIndexSiderService;
	@Autowired
	private ShopBusinessService shopBusinessService;

	@Autowired
	private ShopGoodsService shopGoodsService;

	@Autowired
	private TabOrderCommentService tabOrderCommentService;

	@Autowired
	private TabValidateCodeService validateCodeService;
	
	@Autowired
	private  ShopUserMemberService shopUserMemberService ;
	
	@Autowired
	private ShopGoodCollectService shopGoodCollectService ;
	
	@Autowired
	private TabOrderGwcService tabOrderGwcService ;
	@Autowired
	private ShopOrderService  shopOrderService ;
	
	@Autowired
	private TabOrderListService tabOrderListService;
	
	@Autowired
	private TabUserAddressService userAddressService ;
	@Autowired
	private  ShopBusinessCollectService shopBusinessCollectService ;
	
	@Autowired
	private TabSysContactService tabSysContactService ;
	
	@RequestMapping(value = "/getFileToken")
	@ResponseBody
	public Map<String, Object> getFileToken(HttpServletRequest request, ModelAndView modelAndView) throws Exception {
		String type = request.getParameter("type");
		String uuid = UUID.randomUUID().toString() + "." + type;

		String urlbase64 = UrlSafeBase64.encodeToString(HttpServletRequestUtils.bucketname + ":" + uuid);
		String pfops = HttpServletRequestUtils.fops;
		String token = HttpServletRequestUtils.getUpToken();

		returnValue.put("uuid", uuid);
		returnValue.put("token", token);

		return returnValue;
	}
	
	//
	
	@ApiOperation(value = "保存意见反馈", notes = "保存意见反馈")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "用户标识", paramType = "query", required = false, dataType = "String")  })
	@RequestMapping(value = "/saveYjfk", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveYjfk( TabYjfk tabYjfk , HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		 
		tabYjfk.setIsNewRecord(true);
		tabYjfk.setCreatetime(new Date());
		tabYjfkService.save(tabYjfk);
		
		
		
		
		
		return returnValue;

		
	}
	
	@Autowired
	private  TabYjfkService tabYjfkService ;
}
