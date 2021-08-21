// index 변수안에 save 함수를 선언하므로써 공용공간으로 쓰이는 scope 에서 중복을 방지한다.
// a.js 안에 save라는 함수가 있더라도 index.js는 main.save()를 사용하므로 중복되지 않는다.
var main = {
    init : function (){
        var _this = this;
        $('#btn-save').on('click', function (){
           _this.save();
        });
        $('#btn-update').on('click', function(){
            _this.update();
        });
        $('#btn-delete').on('click', function(){
            _this.delete();
        });
    },
    save : function (){
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val(),
        };

        $.ajax({
            type:'POST',
            url:'/api/v1/posts',
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(
            function(){
                alert('글이 등록되었습니다.');
                window.location.href = '/';
            }
        ).fail(
            function (err){
                alert(JSON.stringify(err));
            }
        )
    },
    update: function(){
        var data = {
            title: $('#title').val(),
            content : $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (err){
            alert(JSON.stringify(err));
        })
    },
    delete: function(){
        var id = $('#id').val();

        $.ajax({
            type:'DELETE',
            url : '/api/v1/posts/'+id,
            dataType:'json',
            contentType:'application/json; charset=utf-8'
        }).done(function (){
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(err){
            alert(JSON.stringify(err));
        })
    }
}

main.init();