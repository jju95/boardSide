
function formPost(){
    let formData = $("#joinForm").serialize();

    $.post("/member/register"),
        {formData},
        function (data, status){
            let result = data.get("result");
            if(result == 1 && status == 200){
                alert('join ok !')
            }else
                alert('join failed...');
        }

}