$(function(){
	switchBar()
	switchMeu()
})

function skillManage(){
	$(".skill").show();
	$(".equipment").hide();
	$(".arms").hide()
}

function saveSkill(){
	
}

function switchBar(){
	$(".skill .center-title").off("click").on("click",function(){
		$(this).addClass("line")
		$(".skill .center-title").not(this).removeClass("line")
	})
}

function switchMeu(){
	$(".left .ul-meu").off("click").on("click",function(){
		$(this).addClass("ul-bg");
		$(".left .ul-meu").not(this).removeClass("ul-bg");
		
	})
}