/**
 * プルダウンのためのjsファイル.
 */

$(function(){
    $("#pulldown1").change(function(){
        var value = $("#pulldown1 option:selected").val();
        $.get("/showCate/pulldown/middle/" + value ,function(data){
            var obj = $.parseJSON(data);
            $("#pulldown2").html("");
            for(var i=0;i<obj.length;i++){
                $("#pulldown2").append("<option value="+obj[i].itemValue+">"+obj[i].itemLabel+"</option>");
            }
        });
    });
    
    $("#pulldown2").change(function(){
        var valueMiddleCate = $("#pulldown2 option:selected").val();
        var valueBigCate = $("#pulldown1 option:selected").val();
        $.get("/showCate/pulldown/small/" + valueBigCate+"/"+valueMiddleCate ,function(data){
            var obj = $.parseJSON(data);
            $("#pulldown3").html("");
            for(var i=0;i<obj.length;i++){
                $("#pulldown3").append("<option value="+obj[i].itemValue+">"+obj[i].itemLabel+"</option>");
            }
        });
    });
    
    
    
});