var totalPages = 1;// 总共多少页
var count = 10;// 每页展示的数据条数
var resObj = {1:"流血抗性:",2:"全元素:",3:"冰属性抗性:",4:"火属性抗性:",5:"电属性抗性:",6:"奥术抗性:"}
var eqRareObj = {1:"reare-1",2:"reare-2",3:"reare-3"}
$(function(){
	getEquipmentAll();
	equipInfoShow();
	
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
			}else{
				layer.alert(json.data)
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
					var eqName = json.data[i].eqName;// 防具名称
					var defense = json.data[i].defense;// 基础防御
					var res = json.data[i].resistance;// 元素抗性
					var resistanceType = json.data[i].resistanceType;// 抗性类型
					var resType = resObj[resistanceType];// 抗性类型转换为名称
					var eqRare = json.data[i].eqRare;// 稀有度
					var eqStatus = json.data[i].eqStatus;// 状态
					eqStatus = eqStatus==1?"可用":"禁用";
					html += "<tr>"+
								"<td data-id='1'>"+((i+1)+(page-1)*count)+"</td>"+
								"<td>"+
									"<img class='equip-img' src='img/equip/equip-001.png'>"+
								"</td>"+
								"<td>"+eqName+"</td>"+
								"<td>基础值：+"+defense+"；"+resType+"：+"+res+"</td>"+
								"<td>防具</td>"+
								"<td data-eqrare='"+eqRare+"'>"+eqRare+"星</td>"+
								"<td>"+eqStatus+"</td>"+
								"<td>"+
									"<button type='button' class='btn btn-danger' onclick='removeEq(this);'>删除</button>"+
									"<button type='button' class='btn btn-success' onclick='updateEq(this);'>修改</button>"+
									"<button type='button' class='btn btn-warning' onclick='dealEq(this);'>禁用</button>"+
								"</td>"+
							"</tr>";
				}
				$(".eq-tbody").html(html);
				equipInfoShow();
			}else{
				layer.alert(json.data)
			}
		}
	})
}
function removeEq(btn){
	var id = $(btn).parent().prevAll().eq(6).data("id");
	// $(btn).parent().parent().remove();
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
		$(".eqImg-info").hide();
	});
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
	$(".eq-name").text(eqName);
	$(".eq-lab").text(eqType);
	var def = defense.split("；")[0];
	var res = defense.split("；")[1];
	$(".baseDef").text(def);
	$(".baseRes").text(res);
	$(".eqImg-info").css({"top":top,"left":left}).show();
	var rare = eqRareObj[eqRare];
	console.log(eqRare)
	$(".eqImg-info label").addClass(rare);
}
