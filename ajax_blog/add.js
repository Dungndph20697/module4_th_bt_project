function addNewBlog() {
  //lấy dữ liệu từ form html
  let title = $("#title").val();
  let content = $("#content").val();
  let author = $("#author").val();
  let newBlog = {
    title: title,
    content: content,
    author: author,
  };
  // gọi phương thức ajax
  $.ajax({
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    type: "POST",
    data: JSON.stringify(newBlog),
    //tên API
    url: "http://localhost:8080/api/blog",
    //xử lý khi thành công
    // success: ,
  });
  //chặn sự kiện mặc định của thẻ
  // event.preventDefault();
}
