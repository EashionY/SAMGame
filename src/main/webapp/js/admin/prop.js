var totalPages = 1;// 总共多少页
var count = 10;// 每页展示的数据条数
var resObj = {1:"流血抗性:",2:"全元素:",3:"冰属性抗性:",4:"火属性抗性:",5:"电属性抗性:",6:"奥术抗性:"}
var eqRareObj = {1:"reare-1",2:"reare-2",3:"reare-3"}
$(function(){
	// 获取所有防具
	getEquipmentAll();
	// 防具详情大图显示
	equipInfoShow();
	// 顶部标题选择功能
	switchTitle();
})
/**
 * 获取所有数据
 * 
 * @returns
 */
function getEquipmentAll(){
	var url = basePath+"equipment/findAll";
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		success:function(json){
			if(json.success){
				totalPages = Math.ceil(json.data.length/10);
				initPage(totalPages);
			}
		}
	})
}
// 初始化分页
function initPage(totalPages){
	pageQuery(1,count);
	$('#pageLimit').bootstrapPaginator({
	      currentPage: 1,// 当前的请求页面。
	      totalPages: totalPages,// 一共多少页。
	      count:"normal",// 页眉的大小。
	      bootstrapMajorVersion: 3,// bootstrap的版本要求。
	      alignment:"right",
	      numberOfPages:5,// 展示几个分页数量
	      itemTexts: function (type, page, current) {
	         switch (type) {
	         case "first": return "首页";
	         case "prev": return "上一页";
	         case "next": return "下一页";
	         case "last": return "末页";
	         case "page": return page;
	         }
	     },
	     onPageClicked: function (event,originalEvent,type,page){
	    	 pageQuery(page,count);
	     }
	 });
}
/**
 * 分页查询
 * 
 * @param page
 * @param count
 * @returns
 */
function pageQuery(page,count){
	var url = basePath+"equipment/pageQuery";
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		data:{page:page,count,count},
		success:function(json){
			if(json.success){
				var html = "";
				for(var i=0;i<json.data.length;i++){
					var id = json.data[i].id;
					var eqName = json.data[i].eqName;// 防具名称
					var defense = json.data[i].defense;// 基础防御
					var res = json.data[i].resistance;// 元素抗性
					var resistanceType = json.data[i].resistanceType;// 抗性类型
					var resType = resObj[resistanceType];// 抗性类型转换为名称
					var eqRare = json.data[i].eqRare;// 稀有度
					var eqStatus = json.data[i].eqStatus;// 状态
					// eqStatus = eqStatus==1?"可用":"禁用";
					var imgurl = json.data[i].imgurl;
					var msg;
					if(eqStatus==1){
						eqStatus = "可用";
						msg = "禁用";
					}else{
						eqStatus = "禁用";
						msg = "启用";
					}
					console.log(imgurl)
					html += "<tr>"+
								"<td data-id='"+id+"'>"+((i+1)+(page-1)*count)+"</td>"+
								"<td>"+
									"<img class='equip-img' src='"+"../../../"+imgurl+"'>"+
								"</td>"+
								"<td>"+eqName+"</td>"+
								"<td>基础值：+"+defense+"；"+resType+"：+"+res+"</td>"+
								"<td>防具</td>"+
								"<td data-eqrare='"+eqRare+"'>"+eqRare+"星</td>"+
								"<td>"+eqStatus+"</td>"+
								"<td>"+
									"<button type='button' class='btn btn-danger' onclick='removeEq(this);'>删除</button>"+
									"<button type='button' class='btn btn-success' onclick='updateEq(this);'>修改</button>"+
									"<button type='button' class='btn btn-warning' onclick='dealEq(this);'>"+msg+"</button>"+
								"</td>"+
							"</tr>";
				}
				$(".eq-tbody").html(html);
				equipInfoShow();
			}
		}
	})
}
function removeEq(btn){
	var id = $(btn).parent().prevAll().eq(6).data("id");
	var url = basePath+"equipment/deleteEq";
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		data:{id:id},
		success:function(json){
			if(json.success){
				$(btn).parent().parent().remove();
				layer.alert("删除成功")
			}else{
				layer.alert(json.data)
			}
		}
	});
}
function updateEq(btn){
	var id = $(btn).parent().prevAll().eq(6).data("id");
}
function banEq(btn){
	
}
// 装备信息大图显示
function equipInfoShow(){
	$(".equip-img").mouseenter(function(){
		var url = $(this).attr("src");
		var tds = $(this).parent().nextAll();
		var eqName = $(tds[0]).text();// 名称
		var defense = $(tds[1]).text();// 防御和抗性
		var eqType = $(tds[2]).text();// 装备类型
		var eqRare = $(tds[3]).data("eqrare");// 稀有度
		var top = $(this).offset().top+20;
		var left = $(this).offset().left+35;
		createImg(top,left,url,eqName,defense,eqType,eqRare);
	})
	$(".eqImg-info").mouseleave(function(){
		$(this).hide();
	});
	hideDiv("eqBigImg",".eqImg-info");// 点击任意地方隐藏装备详细信息大图
}
/**
 * 创建图标
 * 
 * @param url
 * @param tds
 * @param eqName
 * @param defense
 * @param eqType
 * @param eqRare
 * @returns
 */
function createImg(top,left,url,eqName,defense,eqType,eqRare){
	$(".eqBImg").attr("src",url);
	$(".eq-name").text(eqName);// 名称
	$(".eq-lab").text(eqType);// 类型
	var def = defense.split("；")[0];// 防御
	var res = defense.split("；")[1];// 抗性
	$(".baseDef").text(def);
	$(".baseRes").text(res);
	$(".eqImg-info").css({"top":top,"left":left}).show();
	var rare = eqRareObj[eqRare];
	$(".eqImg-info label").addClass(rare);
}
/**
 * 顶部标题下划线功能
 * 
 * @returns
 */
function switchTitle(){
	$(".eq-top .center-title").off("click").on("click",function(){
		$(this).addClass("line")
		$(".eq-top .center-title").not(this).removeClass("line");
		var text = $(this).text();
		if(text=="装备列表"){
			$(".eq-list").show();
			$(".eq-add").hide();
		}else{
			$(".eq-list").hide();
			$(".eq-add").show();
			uploadEqImg();
			writeEqInfoToImg();
		}
	})
}
// 装备管理
function equipManage(){
	$(".skill").hide();
	$(".equipment").show();
	$(".arms").hide()
}
/** *******************装备添加********************************* */
//写入属性抗性
function writeRes(){
	$(".eq-res .dropdown-menu").find("li").on("click",function(){
		var rval = $(this).find("a").text();
		var res = $(this).find("a").data("res");
		$("#resistance").text(rval).data("res",res);
		$("#res-val").data("res",res);
		$("#up-show .baseRes .baseRes-msg").text(rval+"：");
	});
}
//写入稀有度
function writeRare(){
	$(".eq-rare .dropdown-menu").find("li").on("click",function(){
		var rval = $(this).find("a").text();
		var rare = $(this).find("a").data("rare");
		$("#eqRare").val(rval).data("rare",rare);
		for(i in eqRareObj){
			$("#up-show label").removeClass(eqRareObj[i]);
		}
		var erare = eqRareObj[rare];
		$("#up-show label").addClass(erare);
	})
}
// 右边装备图标写入数据
function writeEqInfoToImg(){
	// 写入名称
	$("#eq-name").on("blur",function(){
		var eqname = $(this).val();
		$("#up-show .eq-name").text(eqname);
	});
	// 写入防御
	$("#eq-def").on("blur",function(){
		var eqdef= $(this).val();
		$("#up-show .baseDef .bmsg").text("+"+eqdef);
	});
	// 写入抗性
	$("#res-val").on("blur",function(){
		var eqres = $(this).val();
		$("#up-show .baseRes .bmsg").text("+"+eqres);
	})
	// 写入稀有度
	writeRare();
	// 写入抗性类型
	writeRes();
}
/**
 * 上传图片
 * 
 * @returns
 */
function uploadEqImg(){
	$("#upload-eq").change(function(e){
		var file = e.target.files[0];// 获取File对象，这里是上传单张图片，[0]代表第一张图片。如果多张，就是一个var
										// file = e.target.files;
	    var type = file.type.split('/')[0];// 按照惯例，不应该由前端判断格式，因为这里是根据后缀名判断的，修改后缀名仍旧可以上传，理应由后端根据文件格式来判断。
	    if (type !='image') {
	        layer.alert('请上传图片');
	        return;
	    }
	    var size = Math.round(file.size / 1024 / 1024);
	    if (size > 3) {
	    	layer.alert('图片大小不得超过3M');
	        return;
	    };
	    createEqImg(file);
	})
}
/**
 * 创建上传的图片冰展示
 * 
 * @param file
 * @returns
 */
function createEqImg(file){
	var reader = new FileReader(); // 新建FileReader对象
    reader.readAsDataURL(file); // 读取为base64
    // 以下代码可以删除
    reader.onloadstart = function(){
        console.log('start');  // 开始读取
    };
    reader.onprogress = function(e){
        // 这个是定时触发的事件，文件较大的时候较明显
        var p = '已完成：' + Math.round(e.loaded / e.total * 100) + '%' ;
        $(".file_upload").find(".progress").html(p);
        console.log('uploading');  // 文件较大，就会出现多个uploading
    };
    reader.onabort = function(){// 用作取消上传功能
        
    };
    reader.onerror = function(){// 文件读取出错的时候触发，暂模拟不出
    	layer.alert("文件读取出错啦")
    };
    reader.onload = function(){// 完成
    	var url = reader.result;
    	$("#up-show .eqBImg").attr("src",url)
    };
    
}
// 保存
function saveEquipment(){
	var eqName = $("#eq-name").val();// 装备名称
	if(eqName.trim()==""){
		layer.alert("装备名称不能为空");
		return;
	};
	var defense = $("#eq-def").val();// 基础防御
	if(defense==0){
		layer.alert("基础防御不能为0");
		return;
	};
	defense = parseInt(defense);
	var resistance = $("#res-val").val();// 元素抗性
	if(resistance==0){
		layer.alert("元素抗性不能为0");
		return;
	};
	var resistanceType = $("#res-val").data("res");
	resistance = parseInt(resistance);
	var eqRare = $("#eqRare").data("rare");// 稀有度
	var eqBImg = $("#eqBImg").attr("src");// 稀有度
	eqBImg.replace(/\+/g, "%2B")
	var pos = eqBImg.indexOf("4")+2;
	eqBImg = eqBImg.substring(pos, eqBImg.length - pos);//去掉Base64:开头的标识字符
	var data = {
			eqName:eqName,
			defense:defense,
			resistance:resistance,
			resistanceType:resistanceType,
			eqRare:eqRare,
			imgurl:eqBImg
		}
	var url = basePath + "equipment/saveEquipment";
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		data:data,
		success:function(json){
			layer.alert(json.data);
			history.go(0)
		}
	})
}