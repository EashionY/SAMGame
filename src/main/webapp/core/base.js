var basePath = "/SAMGame/";
/**
 * 点击除触发隐藏div显示的任意元素隐藏某div
 * @param targetId = 触发隐藏div的元素id
 * @param hideDiv = 被隐藏的div
 * @returns
 */
function hideDiv(targetId, hideDiv) {
	$(document).on("click", function(e) {
		var e = e || window.event; // 浏览器兼容性
		var elem = e.target || e.srcElement;
		while (elem) { // 循环判断至跟节点，防止点击的是div子元素
			if (elem.id && elem.id == targetId) {
				return;
			}
			elem = elem.parentNode;
		}
		$(hideDiv).hide();
	});
}