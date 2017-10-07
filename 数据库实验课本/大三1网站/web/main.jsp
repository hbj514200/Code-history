<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="html/header.html"/>


<link href="/html/Wopop_files/style_log.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/html/Wopop_files/style.css">
<link rel="stylesheet" type="text/css" href="/html/Wopop_files/userpanel.css">
<link rel="stylesheet" type="text/css" href="/html/Wopop_files/jquery.ui.all.css">

<div id="features" >
    <div class="container"style="width: 60%">
        <!-- Section Title Start -->
        <div class="section-title">
            <h2>why choose us</h2>
        </div>
        <!-- Section Title End -->
        <div class="row">
            <!-- Feature Item Start -->
            <div class="col-md-3 col-sm-6 feature-item text-center">
                <div class="feature-item-icon">
                    <img src="html/img/features-img/01.png" alt="" class="img-responsive">
                </div>
                <div class="feature-item-content">
                    <h4>权限清晰</h4>
                    <p>不同用户权限分明，各司其职</p>
                </div>
            </div>
            <!-- Feature Item End -->
            <!-- Feature Item Start -->
            <div class="col-md-3 col-sm-6 feature-item text-center">
                <div class="feature-item-icon">
                    <img src="html/img/features-img/02.png" alt="" class="img-responsive">
                </div>
                <div class="feature-item-content">
                    <h4>牢不可破</h4>
                    <p>专业DBA管理，杜绝SQL注入.</p>
                </div>
            </div>
            <!-- Feature Item End -->
            <!-- Feature Item Start -->
            <div class="col-md-3 col-sm-6 feature-item text-center">
                <div class="feature-item-icon">
                    <img src="/html/img/features-img/03.png" alt="" class="img-responsive">
                </div>
                <div class="feature-item-content">
                    <h4>数据检索</h4>
                    <p>独有的搜索功能，能海里捞针</p>
                </div>
            </div>
            <!-- Feature Item End -->
            <!-- Feature Item Start -->
            <div class="col-md-3 col-sm-6 feature-item text-center">
                <div class="feature-item-icon">
                    <img src="/html/img/features-img/04.png" alt="" class="img-responsive">
                </div>
                <div class="feature-item-content">
                    <h4>安如泰山</h4>
                    <p>提供excel与数据库双重备份</p>
                </div>
            </div>
            <!-- Feature Item End -->
            <!-- Feature Item Start -->
            <div class="col-md-3 col-sm-6 feature-item text-center">
                <div class="feature-item-icon">
                    <img src="/html/img/features-img/05.png" alt="" class="img-responsive">
                </div>
                <div class="feature-item-content">
                    <h4>帮助中心</h4>
                    <p>详细友善的帮助文档解决您的难题</p>
                </div>
            </div>
            <!-- Feature Item End -->
            <!-- Feature Item Start -->
            <div class="col-md-3 col-sm-6 feature-item text-center">
                <div class="feature-item-icon">
                    <img src="/html/img/features-img/06.png" alt="" class="img-responsive">
                </div>
                <div class="feature-item-content">
                    <h4>技术先进</h4>
                    <p>MySql与Java结合，更有保障</p>
                </div>
            </div>
            <!-- Feature Item End -->
            <!-- Feature Item Start -->
            <div class="col-md-3 col-sm-6 feature-item text-center">
                <div class="feature-item-icon">
                    <img src="/html/img/features-img/07.png" alt="" class="img-responsive">
                </div>
                <div class="feature-item-content">
                    <h4>B/S架构</h4>
                    <p>远在天边，近在眼前</p>
                </div>
            </div>
            <!-- Feature Item End -->
            <!-- Feature Item Start -->
            <div class="col-md-3 col-sm-6 feature-item text-center">
                <div class="feature-item-icon">
                    <img src="/html/img/features-img/08.png" alt="" class="img-responsive">
                </div>
                <div class="feature-item-content">
                    <h4>性能高效</h4>
                    <p>优异的服务效率，大大降低访问延迟</p>
                </div>
            </div>
            <!-- Feature Item End -->
        </div>
    </div>
</div>


<jsp:include page="html/footer.html"/>


<%
    if (request.getParameter("noPower")!=null) out.print("<script language=\"JavaScript\">alert(\"您没有该项访问权限\");</script>\n");
%>