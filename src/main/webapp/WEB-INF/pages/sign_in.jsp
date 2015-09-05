<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
    request.setAttribute("domain", "http://localhost/sanyuandb/");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/index.css">
    <title>首页</title>

</head>
<head>
    <title>Flatty - Flat administration template</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport' />
    
    <!--[if lt IE 9]>
    <script src='js/html5shiv.js' type='text/javascript'></script>
    <![endif]-->
    <link href='css/bootstrap/bootstrap.css' media='all' rel='stylesheet' type='text/css' />
    <link href='css/bootstrap/bootstrap-responsive.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / jquery ui -->
    <link href='css/jquery_ui/jquery-ui-1.10.0.custom.css' media='all' rel='stylesheet' type='text/css' />
    <link href='css/jquery_ui/jquery.ui.1.10.0.ie.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / switch buttons -->
    <link href='css/plugins/bootstrap_switch/bootstrap-switch.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / xeditable -->
    <link href='css/plugins/xeditable/bootstrap-editable.css' media='all' rel='stylesheet' type='text/css' />
    <link href='css/plugins/common/bootstrap-wysihtml5.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / wysihtml5 (wysywig) -->
    <link href='css/plugins/common/bootstrap-wysihtml5.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / jquery file upload -->
    <link href='css/plugins/jquery_fileupload/jquery.fileupload-ui.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / full calendar -->
    <link href='css/plugins/fullcalendar/fullcalendar.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / select2 -->
    <link href='css/plugins/select2/select2.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / mention -->
    <link href='css/plugins/mention/mention.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / tabdrop (responsive tabs) -->
    <link href='css/plugins/tabdrop/tabdrop.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / jgrowl notifications -->
    <link href='css/plugins/jgrowl/jquery.jgrowl.min.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / datatables -->
    <link href='css/plugins/datatables/bootstrap-datatable.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / dynatrees (file trees) -->
    <link href='css/plugins/dynatree/ui.dynatree.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / color picker -->
    <link href='css/plugins/bootstrap_colorpicker/bootstrap-colorpicker.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / datetime picker -->
    <link href='css/plugins/bootstrap_datetimepicker/bootstrap-datetimepicker.min.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / daterange picker) -->
    <link href='css/plugins/bootstrap_daterangepicker/bootstrap-daterangepicker.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / flags (country flags) -->
    <link href='css/plugins/flags/flags.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / slider nav (address book) -->
    <link href='css/plugins/slider_nav/slidernav.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / fuelux (wizard) -->
    <link href='css/plugins/fuelux/wizard.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / flatty theme -->
    <link href='css/light-theme.css' id='color-settings-body-color' media='all' rel='stylesheet' type='text/css' />
    <!-- / demo -->
    <link href='css/demo.css' media='all' rel='stylesheet' type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body class='contrast-red sign-in contrast-background'>
<div id='wrapper'>
    <div class='application'>
        <div class='application-content'>
            <a href="sign_in.html"><div class='icon-heart'></div>
                <span>Flatty</span>
            </a>
        </div>
    </div>
    <div class='controls'>
        <div class='caret'></div>
        <div class='form-wrapper'>
            <h1 class='text-center'>Sign in</h1>
            <div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
                <div class='row-fluid'>
                    <div class='span12 icon-over-input'>
                        <input class="span12" id="account" name="account" placeholder="用户名" type="text" value="" />
                        <i class='icon-user muted'></i>
                    </div>
                </div>
                <div class='row-fluid'>
                    <div class='span12 icon-over-input'>
                        <input class="span12" id="password" name="password" placeholder="密码" type="password" value="" />
                        <i class='icon-lock muted'></i>
                    </div>
                </div>
                <label class="checkbox" for="remember_me"><input id="remember_me" name="remember_me" type="checkbox" value="1" />
                    Remember me
                </label>
                <button class="btn btn-block" name="button" type="submit" onclick="signin()">Sign in</button>
            <div class='text-center'>
                <hr class='hr-normal' />
                <a href="forgot_password.html">Forgot your password?</a>
            </div>
        </div>
    </div>
    <%--<div class='login-action text-center'>--%>
        <%--<a href="sign_up.html"><i class='icon-user'></i>--%>
            <%--New to Flatty?--%>
            <%--<strong>Sign up</strong>--%>
        <%--</a>--%>
    <%--</div>--%>
</div>
<!-- / jquery -->
<script src='js/jquery/jquery.min.js' type='text/javascript'></script>
<!-- / jquery mobile events (for touch and slide) -->
<script src='js/plugins/mobile_events/jquery.mobile-events.min.js' type='text/javascript'></script>
<!-- / jquery migrate (for compatibility with new jquery) -->
<script src='js/jquery/jquery-migrate.min.js' type='text/javascript'></script>
<!-- / jquery ui -->
<script src='js/jquery_ui/jquery-ui.min.js' type='text/javascript'></script>
<!-- / bootstrap -->
<script src='js/bootstrap/bootstrap.min.js' type='text/javascript'></script>
<script src='js/plugins/flot/excanvas.js' type='text/javascript'></script>
<!-- / sparklines -->
<script src='js/plugins/sparklines/jquery.sparkline.min.js' type='text/javascript'></script>
<!-- / flot charts -->
<script src='js/plugins/flot/flot.min.js' type='text/javascript'></script>
<script src='js/plugins/flot/flot.resize.js' type='text/javascript'></script>
<script src='js/plugins/flot/flot.pie.js' type='text/javascript'></script>
<!-- / bootstrap switch -->
<script src='js/plugins/bootstrap_switch/bootstrapSwitch.min.js' type='text/javascript'></script>
<!-- / fullcalendar -->
<script src='js/plugins/fullcalendar/fullcalendar.min.js' type='text/javascript'></script>
<!-- / datatables -->
<script src='js/plugins/datatables/jquery.dataTables.min.js' type='text/javascript'></script>
<script src='js/plugins/datatables/jquery.dataTables.columnFilter.js' type='text/javascript'></script>
<!-- / wysihtml5 -->
<script src='js/plugins/common/wysihtml5.min.js' type='text/javascript'></script>
<script src='js/plugins/common/bootstrap-wysihtml5.js' type='text/javascript'></script>
<!-- / select2 -->
<script src='js/plugins/select2/select2.js' type='text/javascript'></script>
<!-- / color picker -->
<script src='js/plugins/bootstrap_colorpicker/bootstrap-colorpicker.min.js' type='text/javascript'></script>
<!-- / mention -->
<script src='js/plugins/mention/mention.min.js' type='text/javascript'></script>
<!-- / input mask -->
<script src='js/plugins/input_mask/bootstrap-inputmask.min.js' type='text/javascript'></script>
<!-- / fileinput -->
<script src='js/plugins/fileinput/bootstrap-fileinput.js' type='text/javascript'></script>
<!-- / modernizr -->
<script src='js/plugins/modernizr/modernizr.min.js' type='text/javascript'></script>
<!-- / retina -->
<script src='js/plugins/retina/retina.js' type='text/javascript'></script>
<!-- / fileupload -->
<script src='js/plugins/fileupload/tmpl.min.js' type='text/javascript'></script>
<script src='js/plugins/fileupload/load-image.min.js' type='text/javascript'></script>
<script src='js/plugins/fileupload/canvas-to-blob.min.js' type='text/javascript'></script>
<script src='js/plugins/fileupload/jquery.iframe-transport.min.js' type='text/javascript'></script>
<script src='js/plugins/fileupload/jquery.fileupload.min.js' type='text/javascript'></script>
<script src='js/plugins/fileupload/jquery.fileupload-fp.min.js' type='text/javascript'></script>
<script src='js/plugins/fileupload/jquery.fileupload-ui.min.js' type='text/javascript'></script>
<script src='js/plugins/fileupload/jquery.fileupload-init.js' type='text/javascript'></script>
<!-- / timeago -->
<script src='js/plugins/timeago/jquery.timeago.js' type='text/javascript'></script>
<!-- / slimscroll -->
<script src='js/plugins/slimscroll/jquery.slimscroll.min.js' type='text/javascript'></script>
<!-- / autosize (for textareas) -->
<script src='js/plugins/autosize/jquery.autosize-min.js' type='text/javascript'></script>
<!-- / charCount -->
<script src='js/plugins/charCount/charCount.js' type='text/javascript'></script>
<!-- / validate -->
<script src='js/plugins/validate/jquery.validate.min.js' type='text/javascript'></script>
<script src='js/plugins/validate/additional-methods.js' type='text/javascript'></script>
<!-- / naked password -->
<script src='js/plugins/naked_password/naked_password-0.2.4.min.js' type='text/javascript'></script>
<!-- / nestable -->
<script src='js/plugins/nestable/jquery.nestable.js' type='text/javascript'></script>
<!-- / tabdrop -->
<script src='js/plugins/tabdrop/bootstrap-tabdrop.js' type='text/javascript'></script>
<!-- / jgrowl -->
<script src='js/plugins/jgrowl/jquery.jgrowl.min.js' type='text/javascript'></script>
<!-- / bootbox -->
<script src='js/plugins/bootbox/bootbox.min.js' type='text/javascript'></script>
<!-- / inplace editing -->
<script src='js/plugins/xeditable/bootstrap-editable.min.js' type='text/javascript'></script>
<script src='js/plugins/xeditable/wysihtml5.js' type='text/javascript'></script>
<!-- / ckeditor -->
<script src='js/plugins/ckeditor/ckeditor.js' type='text/javascript'></script>
<!-- / filetrees -->
<script src='js/plugins/dynatree/jquery.dynatree.min.js' type='text/javascript'></script>
<!-- / datetime picker -->
<script src='js/plugins/bootstrap_datetimepicker/bootstrap-datetimepicker.js' type='text/javascript'></script>
<!-- / daterange picker -->
<script src='js/plugins/bootstrap_daterangepicker/moment.min.js' type='text/javascript'></script>
<script src='js/plugins/bootstrap_daterangepicker/bootstrap-daterangepicker.js' type='text/javascript'></script>
<!-- / max length -->
<script src='js/plugins/bootstrap_maxlength/bootstrap-maxlength.min.js' type='text/javascript'></script>
<!-- / dropdown hover -->
<script src='js/plugins/bootstrap_hover_dropdown/twitter-bootstrap-hover-dropdown.min.js' type='text/javascript'></script>
<!-- / slider nav (address book) -->
<script src='js/plugins/slider_nav/slidernav-min.js' type='text/javascript'></script>
<!-- / fuelux -->
<script src='js/plugins/fuelux/wizard.js' type='text/javascript'></script>
<!-- / flatty theme -->
<script src='js/nav.js' type='text/javascript'></script>
<script src='js/tables.js' type='text/javascript'></script>
<script src='js/theme.js' type='text/javascript'></script>
<!-- / demo -->
<script src='js/demo/jquery.mockjax.js' type='text/javascript'></script>
<script src='js/demo/inplace_editing.js' type='text/javascript'></script>
<script src='js/demo/charts.js' type='text/javascript'></script>
<script src='js/demo/demo.js' type='text/javascript'></script>
<script type="text/javascript" src="js/signin.js"></script>
<script type="text/javascript" src="js/utils/md5.js"></script>
<script type="text/javascript" src="js/utils/webstorage.js"></script>
</body>
</html>
