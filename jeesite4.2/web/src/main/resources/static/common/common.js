/*!
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 * 项目自定义的公共JavaScript，可覆盖jeesite.js里的方法
 */


var   doAjax   =  function(url,type,parame,suc,err){
	$.ajax({
		url : url,
		type  : "post",
		data : parame,
		success:  function(data){
			if(suc) {
				suc(data);
			}
		}
	})
}
