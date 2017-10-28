$(function(){
	switchBar()
	switchMeu()
})

function skillManage(){
	$(".equipment").hide()
}

function saveSkill(){
	
}

function switchBar(){
	$(".skill .center-title").off("click").on("click",function(){
		$(this).addClass("skill-line")
		$(".skill .center-title").not(this).removeClass("skill-line")
	})
}

function switchMeu(){
	$(".left .ul-meu").off("click").on("click",function(){
		$(this).addClass("ul-bg");
		$(".left .ul-meu").not(this).removeClass("ul-bg");
	})
}