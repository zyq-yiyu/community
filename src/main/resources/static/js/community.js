function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
        }),
        success: function (response) {
            if (response.code == 200) {
                $("#comment_section").hide();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=5de0bad5ae0612186658&redirect_uri=http://localhost:8887/callback&response_type=code&state=1")
                        window.localStorage.setItem("closable",true);
                    }
                } else {
                    alert(response.message);
                }

            }
        },
        dataType: "json"
    })
    console.log(questionId);
    console.log(content);
}

//改文件主要用于实现回复功能及在未登录情况下弹出提示框