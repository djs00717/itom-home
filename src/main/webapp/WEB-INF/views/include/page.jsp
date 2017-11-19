<%@page pageEncoding="utf-8" %>
<%@page import="com.chinadrtv.scm.bean.Pager"%>
<%
String contextPath = request.getContextPath();
%>
<%
int pageSize = 10;
int currentPage = 1;
int totalPage = 0;
int totalSize = 0;

	Pager<?> pager = (Pager<?>)request.getAttribute("pager");
	if(pager != null){
		pageSize = pager.getPageSize();
		currentPage = pager.getCurrentPage();
		totalPage = pager.getTotalPages();
		totalSize = pager.getTotalSize();
	}
%>

<script type="text/javascript">
var pageSize = <%=pageSize%>;
var currentPage = <%=currentPage%>;
var totalPage = <%=totalPage%>;
var totalSize = <%=totalSize%>;

function toPage(pageNo){
	document.getElementById("currentPage").value=pageNo;		
	doSearch();
}

function goToPage(){
	var page=document.getElementById("pageNumber").value;
	var re = /^[0-9]+$/;
	if(!re.test(page))
		page = 1;
	 if(page>totalPage)
		page = totalPage;
	toPage(page);
}
function gotoFirst(){
	toPage(1);
}
function gotoLast(){
		toPage(totalPage);
}
function gotoPre(){
	if(currentPage>1)
		toPage(currentPage-1);
}
function gotoNext(){
	if(currentPage<totalPage)
		toPage(currentPage-0+1);
}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="page">
  <tr>
  	<td width="1%" >&nbsp;</td>
  
    <td width="25%" >
    	当前<%=currentPage%>页/共<%=totalPage%>页
    </td>

    <td width="68%" align="right" >
	<table width="280" border="0" cellpadding="0" cellspacing="0" class="page">
      <tr align="left">
        <td width="40">
        	<c:choose>
				<c:when test="<%=currentPage!=1%>">
					<a href="javascript:;" onclick="javascript:gotoFirst();">首页</a>
				</c:when>
				<c:otherwise>
					<span>首页</span>
				</c:otherwise>
			</c:choose>
        </td>
        <td width="40">
        	<c:choose>
				<c:when test="<%=currentPage>1%>">
					<a href="javascript:;" onclick="javascript:gotoPre();">上一页</a>
				</c:when>
				<c:otherwise>
					<span>上一页</span>
				</c:otherwise>
			</c:choose>
        </td>
        <td width="10" >&nbsp;</td>
        <td width="40">
        	<c:choose>
				<c:when test="<%=currentPage<totalPage%>">
					<a href="javascript:;" onclick="javascript:gotoNext();">下一页</a>
				</c:when>
				<c:otherwise>
					<span>下一页</span>
				</c:otherwise>
			</c:choose>
        </td>
        <td width="40">
        	<c:choose>
				<c:when test="<%=currentPage<totalPage%>">
					<a href="javascript:;" onclick="javascript:gotoLast();">末页</a>
				</c:when>
				<c:otherwise>
					<span>末页</span>
				</c:otherwise>
			</c:choose>
        </td>
        <td class="center"> 
			跳转到<input name="pageNumber" onkeypress="var e= event ? event :(window.event ? window.event : null);if(!e.ctrlKey&&e.keyCode==13){goToPage();}" id="pageNumber" type="text" size="2"  class="page_input" style="width:50px" value="<%=currentPage%>"/>页
     	  	<input type="button" style="cursor:pointer;" value='跳转' onclick="javascript:goToPage();return false;">
     	</td>
        <td width="3" >&nbsp;</td>
      </tr>
    </table>
	</td>
  </tr>
</table>

