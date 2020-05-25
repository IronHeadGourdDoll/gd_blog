tinymce.init({
    selector: '#message_textarea',
    mode : "textareas",
    //language_url : '/js/tinymce/js/tinymce/langs/zh_CN.js',//可不写
    language:'zh_CN',
    directionality: 'ltr',//文字方向
    browser_spellcheck: true,
    contextmenu: false,
    plugins: [
        "advlist autolink lists link image charmap print preview anchor",
        "searchreplace visualblocks code fullscreen",
        "insertdatetime media table paste imagetools wordcount",
        "code"
    ],
    toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | code",
});

tinymce.init({
    selector: '#edit_blog_content',
    mode : "textareas",
    language:'zh_CN',
    directionality: 'ltr',
    browser_spellcheck: true,
    contextmenu: false,
    plugins: [
        "advlist autolink lists link image charmap print preview anchor",
        "searchreplace visualblocks code fullscreen",
        "insertdatetime media table paste imagetools wordcount",
        "code"
    ],
    toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | code",
});