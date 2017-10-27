//跳转主页
function toIndex(){
	HighlightNavig("主页")
	$("#mainFrame").attr("src","/SAMGame/html/admin/index.html");
}
//跳转道具管理页面
function toProp(){
	HighlightNavig("道具管理")
	$("#mainFrame").attr("src","/SAMGame/html/admin/prop.html");
}
//跳转角色管理页面
function toRole(){
	HighlightNavig("角色管理")
	$("#mainFrame").attr("src","/SAMGame/html/admin/role.html");
}
//跳转用户管理页面
function toUser(){
	HighlightNavig("用户管理")
	$("#mainFrame").attr("src","/SAMGame/html/admin/user.html");
}
//跳转其他页面
function toOther(){
	HighlightNavig("注销")
	//$("#mainFrame").attr("src","/SAMGame/html/admin/user.html");
}
//导航高亮
function HighlightNavig(name){
	var lis = parent.$(".nav-ul li");
	var li;
	for(var i=0;i<lis.length;i++){
		var text = $(lis[i]).find("a").text();
		if(text==name){
			li = lis[i];
			break;
		}
	}
	$(li).addClass("active");
	$(li).parent().find("li").not(li).removeClass("active");
}