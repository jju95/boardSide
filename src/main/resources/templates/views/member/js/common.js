
function formPost(){
    validatePassword();
    let formData = $("#joinForm").serialize();

    $.post("/member/register"),
        {formData},
        function (data, status){
            alert("회원가입 성공하였습니다. ");
        }

}

function validatePassword(){
    console.log('test');

    const password = $("input[name=password]").val();
    const passwordOk = $("input[name=passwordOk]").val();

    if(password != passwordOk){
        alert("패스워드가 일치하지 않습니다.")
        return false;
    }
}